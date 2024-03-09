package com.mycompany.app;


import java.util.ArrayList;

public class App
{
    public static void main( String[] args )
    {

    }

    public static ArrayList<Integer> mixture(ArrayList<Integer> list1, ArrayList<Integer> list2,
                                             char sortSetting, char duplicateSetting, char errorSetting, char transformSetting, int mod){
        /*

        sortSetting:
            a:ascending, d:descending, r:randomize, j:just concat

        *duplicateSetting:
            c:care for duplicates(put all of them), d:don't care for duplicates(take one in the resulting list only)

        *errorSetting:
            n: return null for some cases, s:won't return null ever(for sensitive usages)

        *transformSetting:
            p: make all elements >=0 (take negative ones' absolute value), n: if there are negative ones don't mess with them , s: shrink in mod of last int

        *mod is ignored by default. if transformSetting=s then it will be used
         */

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
            for(int a : result){
                result.remove(a);
                result.add(a%mod);
            }

        }

        if(duplicateSetting=='d'){
           for(int i = 0; i<result.size(); i++){
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

            }
            case 'd': {

            }
            case 'r': {

            }
            case 'j':{

            }




        }




        return null;
    }
}
