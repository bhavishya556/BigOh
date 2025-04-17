//31 march 2025
import java.util.*;
class Ques11{
    public static void main(String[] args) {
        System.out.println(isValid("sTS"));
        
    }
    public static boolean isValid(String name){
   
   
        boolean firstS = false;
        boolean firstT = false;
        boolean secondS = false;

        int vowelArr[] = {0,0,0,0,0};
                       //{a,e,i,o,u}
      
         for(int i = 0; i< name.length(); i++){
            char vowel = name.charAt(i);


            if(vowel =='A' || vowel =='a'){
                vowelArr[0] = vowelArr[0]+1;

            }
            if(vowel =='E' || vowel =='e'){
                vowelArr[1] = vowelArr[1]+1;

            }
            if(vowel =='I' || vowel =='i'){
                vowelArr[2] = vowelArr[2]+1;

            }
            if(vowel =='o' || vowel =='O'){
                vowelArr[3] = vowelArr[3]+1;

            }
            if(vowel =='u' || vowel =='U'){
                vowelArr[4] = vowelArr[4]+1;

            }

           

           
       


          
            

            if(vowel =='S'){
                firstS = true;

            }
            if(firstS && vowel =='T'){
                firstT = true;

            }
            if(firstS && firstT &&vowel =='S'){
                secondS = true;

            }

         

         }
         int count =0;

         for(int i = 0; i< vowelArr.length; i++){

            if(vowelArr[i]>0){
                count++;
            }

         }
         if(count>1){
            return false;
         }

         if(firstS&& secondS && firstT){
            return false;
         }
         
       
         
         return true;
    }
}