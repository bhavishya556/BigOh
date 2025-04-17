import java.math.BigInteger;

public class TerminalAnimation {
    public static void main(String[] args) throws InterruptedException {
        int width = 50;

        BigInteger bigInt = BigInteger.valueOf(0);

        double c = 1.0;

        while (true) {
            for (int i = 0; i < width; i++) {
                System.out.print("\r"); // Return to the beginning of the line
                for (int j = 0; j < i; j++) {
                    System.out.print(" ");
                    
                  System.out.println( i  );  
                System.out.println(c=c+c );           }
                System.out.print("●"); // Dot character
               // Thread.sleep(50); // Delay for animation effect
            }
        }
    }
}
