//31 march 2025
import java.util.*;
class Ques1{
    public static void main(String[] args) {
        System.out.println(isValid("aeiou"));
        System.out.println(isValid("aeiouu"));
        System.out.println(isValid("aeiouSTS"));
       
        
    }
    public static boolean isValid(String name){
        List<Character> vowelHash = new ArrayList<>();
        vowelHash.add('a');
        vowelHash.add('e');
        vowelHash.add('i');
        vowelHash.add('o');
        vowelHash.add('u');
   
        boolean firstS = false;
        boolean firstT = false;
        boolean secondS = false;
      
         for(int i = 0; i< name.length(); i++){
            char vowel = name.charAt(i);
            if( vowelHash.contains(vowel)){
                vowelHash.remove(Character.valueOf(vowel));
            }
            else{
            return false;
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
         if(firstS&& secondS && firstT){
            return false;
         }
         return true;
    }
}