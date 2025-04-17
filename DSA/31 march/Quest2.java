//31 march 2025
import java.util.*;
class Ques2{
    public static void main(String[] args) {
        System.out.println(SwapFirstAndLastDigit(123498));
        
    }
    public static int SwapFirstAndLastDigit(int n){

        int temp=n;


        int rev=0;
        int rem ;

     
        while(temp>0){
            rem = temp%10;
            rev = (rev*10) + rem;
            temp= temp/10;

            
        
         

        }
    
        return rev;
       
        
    }
}