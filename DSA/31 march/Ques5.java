
class Ques5{

    public static void main(String []args) 
    {
        long number = 20;
        long ans = lcm(number);
        System.out.println(ans);
    
    }

    public static long gcd(long a, long b)
    {
       if(a%b != 0) 
          return gcd(b,a%b);
       else 
          return b;
    }
    
   
    public static long lcm(long n)
    {
        long ans = 1;    
        for (long i = 1; i <= n; i++)
            ans = (ans * i)/(gcd(ans, i));
        return ans;
    }
     

}
 
 
    
    