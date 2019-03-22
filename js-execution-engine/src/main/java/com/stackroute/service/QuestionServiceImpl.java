package com.stackroute.service;

import org.springframework.stereotype.Service;
import java.io.*;
import java.util.regex.Matcher;

@Service
public class QuestionServiceImpl implements QuestionService{

    // method for parsing the output.log file to send back the result
    public String finderror() throws Exception
    {
        int total=2,error=2,failure=2;
        Matcher matcher;
        File file;
        BufferedReader fr;
        String m="";
        String fileName="/DB/js-boilerplate/compile.log";
//        String fileName = "/home/user/Documents/Mashup/aws-v1.0.4/boeing-wave3-mashup/js-boilerplate/compile.log";
        file=new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String d;
        String k = "";
        while((d=br.readLine())!=null) {
            k += d;
            k += " ";
        }
//        file.delete();
        String r[]=k.split("\\[ERROR\\]");
        int mm=0;
        if(k.isEmpty()){
            return null;
        }
        else if(k.contains("COMPILATION ERROR")){
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
        else if(k.substring(0, 6).equals("output")) {
            if (k.contains(" Exception ")) {
                System.out.println(k);
                int indexOfExecption = k.indexOf("Exception");
                m += k.substring(9, indexOfExecption -1);
                int indexOfMain = k.indexOf("main\"") + 6;
                int indexOfAt = k.indexOf("\t");
                m += "\n";
                m += "[Exception] ";
                m += k.substring(indexOfMain, indexOfAt);
                System.out.println("m + Except: " + m);
            } else {
                m = k.substring(9);
                System.out.println("only m" + m);
            }
        }
        System.out.println("This is log file\n" + m);
//        file.delete();
        return m;
    }

// method to run the jsrun.sh script file on every run hit
    public  String  run(String code)  {
//        String filename = getfilename(code);
        System.out.println("code =>" + code);
        String filename = "/DB/js-boilerplate/src/main/java/com/stackroute/JSComplete.java";
//        String filename = "/home/user/Documents/Mashup/aws-v1.0.4/boeing-wave3-mashup/js-boilerplate/src/main/java/com/stackroute/JSComplete.java";
        try{
//            FileWriter fw=new FileWriter("/DB/js-boilerplate/src/main/java/com/stackroute/"+filename);
            FileWriter fw=new FileWriter(filename);
            fw.write("package com.stackroute;\n" +
                    "public class JSComplete {\n" +
                    "    public static void main(String[] arg){\n" +
                    "        JSComplete jscomplete = new JSComplete();\n" +
                    "        jscomplete.verifyCode();\n" +
                    "    }\n" +
                    "    public  void verifyCode(){\n" +
                    code +
                    "\n    }\n" +
                    "}");
            fw.close();
        }catch(Exception e){System.out.println(e);}
        System.out.println("Success...");
        Process p;
        try {
            String[] cmd = {"sh", "/DB/script/jsrun.sh"};
//            String[] cmd = {"sh", "/home/user/Documents/Mashup/aws-v1.0.4/boeing-wave3-mashup/js-execution-engine/src/main/java/com/stackroute/script/jsrun.sh"};
            p = Runtime.getRuntime().exec(cmd);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println("curr path" + System.getProperty("user.dir"));
//        File file1=new File("/DB/js-boilerplate/src/main/java/com/stackroute/"+filename);
//        File file1=new File("/home/user/Documents/Mashup/aws-v1.0.4/boeing-wave3-mashup/js-boilerplate/src/main/java/com/stackroute/"+filename);
//        if(file1.exists()) {
//            System.out.println("file exists");
//        }
//        else {
//            System.out.println("file not exits");
//        }
//        if(file1.delete()){
//            System.out.println("file is deleted");
//        }
//        else{
//            System.out.println("not done your task");
//        }
        try {
            String errorlogs = finderror();
            return errorlogs;
        }
        catch (Exception e){

        }
        return  null;

    }

}