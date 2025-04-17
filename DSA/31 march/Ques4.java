public class Ques4 {
    public static void main(String[] args) {

        String str = "https://www.bigohtech.com/";
        int n = str.length();
        boolean isValid = false;

        if(str.charAt(0) == 'h' && str.charAt(1)=='t' && str.charAt(2)=='t' && str.charAt(3)=='p' && str.charAt(4)=='s' && str.charAt(5)==':' && str.charAt(6)=='/' && str.charAt(7)=='/' && str.charAt(8)=='w'&& str.charAt(9)=='w'&& str.charAt(10)=='w' && str.charAt(11)=='.'){

            for(int i = 12; i<n-5; i++){
                char ch = str.charAt(i);
                // System.out.println(ch);

                if(Character.isDigit(ch) || Character.isLetter(ch)){

                    if(str.charAt(n-1) == '/' && str.charAt(n-2)=='m' &&  str.charAt(n-3)=='o' && str.charAt(n-4)=='c' && str.charAt(n-5)=='.'){
                        isValid = true;
                        
                     
                    }
                    else{
                        System.out.println("false1");
                    }

                }
                else{
                    System.out.println("false2");
                  

                }
            }
            

        }
        else{
            System.out.println("false3");
        }
        if(isValid){
            System.out.println("true");
        }

        
        
    }
    
}
