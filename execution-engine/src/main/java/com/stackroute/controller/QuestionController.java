package com.stackroute.controller;

import com.stackroute.domain.Code;
import com.stackroute.domain.Question;
import com.stackroute.domain.User;
import com.stackroute.service.FetchService;
import com.stackroute.service.ResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.*;


@RestController
@RequestMapping("api/v1/")
@CrossOrigin("*")
public class QuestionController {
    @Autowired
    private ResultsService resultsService;
    @Autowired
    public FetchService fetchService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired


    public QuestionController() {
    }

    @PostMapping(value ="/codemon/{username}")
    public  ResponseEntity<?> getQuestionObjectCodemon(@PathVariable String username,@RequestBody Question question) {
        System.out.println("its comming hereeeeeeeeeeeeee");
        try {

            File file;
            BufferedReader fr;

            String m="";
            String fileName="/DB/users/"+username+"/processid.log";
            file=new File(fileName);
            BufferedReader br=new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String d;
            String k="";
            while((d=br.readLine())!=null)
                k+=d;

            Process p;
        try {
            ///home/user/Documents/Mashup/js_complete/executionengine
            String[] cmd = {"sh","/DB/script/stopnodemon.sh",k};
              p = Runtime.getRuntime().exec(cmd);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        }
        catch (Exception e){

        }
        return null;
    }



    @PutMapping(value="/question/{username}")
    public  ResponseEntity<?> getQuestionObject(@PathVariable String username,@RequestBody Question question) {

    System.out.println(question.gitUrl);



        fetchService.setGiturl1(question.gitUrl);
        fetchService.setUsername(username);
            try{
                   Code code=new Code();
                   code.setCodeTemplate(fetchService.fetchFilesAndSave());
          return new ResponseEntity<Code>(code,HttpStatus.CREATED);
            }

            catch(Exception e){

            }

    return null;
    }

}
