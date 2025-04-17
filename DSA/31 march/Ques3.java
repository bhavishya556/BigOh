import java.util.*;

class Ques3 {
    public static void main(String[] args) {
        int n = 250;
        int largestPrimeDigitNumber = -1;

        for (int i = n - 1; i > 0; i--) { 
            if (checkEveryDigitPrime(i)) {
                largestPrimeDigitNumber = i;
                break; 
            }
        }

        System.out.println("answer is is"+ largestPrimeDigitNumber);
    }

    public static boolean checkEveryDigitPrime(int n) {
        while (n > 0) {
            int curDigit = n % 10;

            if (!checkPrime(curDigit)) { 
                return false;
            }

            n /= 10;
        }
        return true;
    }

    public static boolean checkPrime(int n) {
       
        return n == 2 || n == 3 || n == 5 || n == 7;
    }
}
