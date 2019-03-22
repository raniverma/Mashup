package com.stackroute.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ResultsServiceImpl implements ResultsService{
    public File[] finder( String dirName){
        File dir = new File(dirName);

        return dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String filename)
            { return filename.endsWith(".java"); }
        } );

    }
    public String getfilename(String code)
    {
        return code.substring(code.indexOf("class")+6,code.indexOf("{")).trim()+".java";
    }
    public String finderror(String userName) throws Exception
    {
        int total=2,error=2,failure=2;
        Matcher matcher;
        File file;
        BufferedReader fr;

        String m="";
        String fileName="/DB/users/"+userName+"/compile.log";
        file=new File(fileName);
        BufferedReader br=new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String d;
        String k="";
        while((d=br.readLine())!=null)
            k+=d;

//        file.delete();

        String r[]=k.split("\\[ERROR\\]");

        int mm=0;
        if(k.isEmpty()){
            return 2+"@*#"+2+"@*#Tests passed";
        }
        else
        if(k.contains("COMPILATION ERROR")){
            for(String queryString:r){
                if(mm==0){
                    mm=1;
                    continue;
                }
                if(queryString.indexOf(':')!=-1){
                    if(queryString.contains("Compilation failure"))
                        break;
                    if(queryString.contains("location")){
                        m+=queryString.substring(1+queryString.indexOf(':'),queryString.indexOf("location"))+"\n";
                    }
                    else
                        m+=queryString.substring(1+queryString.indexOf(':'))+"\n";
                }
                else{
                    break;
                }
            }  }
        else{

            String queryString=r[1];

            Pattern pattern = Pattern.compile("Failures");
            matcher = pattern.matcher(queryString);
            matcher.find();
            String  p = queryString.substring(matcher.start() + 10, matcher.start() + 11);

            int a=Integer.parseInt(p);
         failure=a;
            pattern = Pattern.compile("Errors");
            matcher = pattern.matcher(queryString);
            matcher.find();
            p = queryString.substring(matcher.start() + 8, matcher.start() + 9);
                   error=Integer.parseInt(p);
            a+=Integer.parseInt(p);
            pattern = Pattern.compile("run");
            matcher = pattern.matcher(queryString);
            matcher.find();
            p = queryString.substring(matcher.start() + 5, matcher.start() + 6);
            total=Integer.parseInt(p);
            Matcher matcher2;
            for(int i=2;i<2+a;i++) {

                if(r[i].contains("FAILURE")){
                    int g;
                    if(r[i].contains("ComparisonFailure:")){
                        pattern = Pattern.compile("ComparisonFailure:");
                        matcher2 = pattern.matcher(r[i]);
                        g=18;
                        matcher2.find();
                    }
                    else{
                        pattern = Pattern.compile("AssertionError:");
                        matcher2 = pattern.matcher(r[i]);
                        g=15;
                        matcher2.find();
                    }

                    pattern = Pattern.compile("expected.*but");
                    matcher = pattern.matcher(r[i]);
                    matcher.find();
                    p=r[i].substring(matcher2.start() + g,matcher.start());
                    m+=p+"\n";
                    p = r[i].substring(matcher.start() + 10,matcher.end()-5);

                    m+="expected: "+p+"\n";
                    pattern = Pattern.compile("but was:.*>");
                    matcher = pattern.matcher(r[i]);
                    matcher.find();
                    p = r[i].substring(matcher.start() + 9,matcher.end()-1);


                    m+="actual: "+p+"\n";
                }
                else{
                    pattern = Pattern.compile("ERROR.*at");
                    matcher = pattern.matcher(r[i]);
                    matcher.find();
                    p = r[i].substring(matcher.start() +6,matcher.end()-2);

                    m+=p+"\n";
                }

            }




        }
        System.out.println("THis is log file\n"+m);
        return total+"@*#"+(total-error-failure)+"@*#"+m;  }

    public  String  run(String code)  {
        String username=   code.split("@#")[0];
        System.out.println("oldone"+code);
        code=code.split("@#")[1];
        System.out.println("new one"+code);

        try{

            FileWriter fw=new FileWriter(finder("/DB/users/"+username+"/src/main/java/com/stackroute/")[0]);

                fw.flush();
            fw.write(code);
           System.out.println(code);
            fw.close();
        }catch(Exception e){System.out.println(e);}
        System.out.println("Success...");
        try {
            String[] cmdScript = new String[]{"sh", "/DB/script/run.sh", username, "/DB/users"};
            Process procScript = Runtime.getRuntime().exec(cmdScript);
            procScript.waitFor();


            BufferedReader reader = new BufferedReader(new InputStreamReader(procScript.getInputStream()));
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(procScript.getErrorStream()));

            String line = "";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            line = "";
            while ((line = errorReader.readLine()) != null) {
                System.out.println(line);
            }
            String errorlogs=finderror(username);
            return  errorlogs;
        }
        catch(Exception e){

        }


//        try {
//            Thread.sleep(5000);
//            String errorlogs = finderror(username);
//            return errorlogs;
//
//        }
//        catch (Exception e){
//
//        }

       return null;

    }

}



