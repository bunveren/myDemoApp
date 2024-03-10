package com.mycompany.app;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;


import java.util.*;

public class App
{
    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
            //System.out.println(req.queryParams("input1"));
            //System.out.println(req.queryParams("input2"));

            String input1 = req.queryParams("input1");
            java.util.Scanner sc1 = new java.util.Scanner(input1);
            sc1.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
            while (sc1.hasNext())
            {
                int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
                inputList.add(value);
            }
            System.out.println(inputList);


            String input2 = req.queryParams("input2").replaceAll("\\s","");
            int input2AsInt = Integer.parseInt(input2);

            boolean result = true; //todo wth

            Map map = new HashMap();
            map.put("result", result);
            return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
                (rq, rs) -> {
                    Map map = new HashMap();
                    map.put("result", "not computed yet!");
                    return new ModelAndView(map, "compute.mustache");
                },
                new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }


    public static ArrayList<Integer> mixture(ArrayList<Integer> list1, ArrayList<Integer> list2,
                                             char sortSetting, char duplicateSetting, char errorSetting, char transformSetting, int div){


        ArrayList<Integer> result = new ArrayList<>();

        if((list1==null || list1.isEmpty()) && (list2==null || list2.isEmpty())){

            if(errorSetting=='s') return result;
            else return null;

        }

        if(transformSetting=='p'){
            for(int a : list1){
                if(a<0) result.add(a*-1);
                else result.add(a);
            }
            for(int a : list2){
                if(a<0) result.add(a*-1);
                else result.add(a);
            }
        }
        else{
            if(list1!=null)
                for(int a : list1)
                    result.add(a);

            if(list2!=null)
                for(int a : list2)
                    result.add(a);
        }

        if(transformSetting=='s'){
            ArrayList<Integer> newres=new ArrayList<>();
            for(int a : result){
                newres.add((int)(a/div));
            }
            result=newres;

        }

        if(duplicateSetting=='d'){
           for(int i = 0; i<result.size()-1; i++){
               for(int j = i+1; j<result.size(); j++){
                   if(result.get(i) == result.get(j)) {
                       result.remove(j);
                       j=i;
                   }
               }
           }
        }

        /*
        sortSetting:
            a:ascending, d:descending, r:randomize, j:just concat
         */

        switch (sortSetting){
            case 'a': {
                for(int i = 0; i<result.size()-1; i++){
                    for(int j = i+1; j<result.size(); j++){
                        if(result.get(i)>result.get(j)){
                            int a = result.get(i);
                            result.set(i, result.get(j));
                            result.set(j,a);
                        }
                    }
                }
                break;
            }
            case 'd': {
                for(int i = 0; i<result.size()-1; i++){
                    for(int j = i+1; j<result.size(); j++){
                        if(result.get(i)<result.get(j)){
                            int a = result.get(i);
                            result.set(i, result.get(j));
                            result.set(j,a);
                        }
                    }
                }
                break;
            }
            case 'r': {
                for(int i = 0; i<result.size()-1; i++){
                    for(int j = i+1; j<result.size(); j++){
                        if(result.get(i)<result.get(j)){
                            int a = result.get(i);
                            result.set(i, result.get(j));
                            result.set(j,a);
                        }
                    }
                }
            }
            case 'j':{
                Collections.shuffle(result);
                break;
            }
        }

        return result;
    }


}
