

class Question3{
    public static void main(String[] args) {
       int n = 8;
        printPartten(n);

        
    }
    public static void printPartten (int n){

        for(int i =1; i<= n; i++){
            for(int j = 1; j <= n; j++){
                if( i == j){
                    System.out.print("\\");
                    
                }
                else if(i+j == n+1){
                    System.out.print("/");
                    
                }
                else{
                    System.out.print("*");
                    
                }
            }
            System.out.println();
        }

    }    
    
}