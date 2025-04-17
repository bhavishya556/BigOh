import java.util.ArrayList;

public class Q3 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int sizeOfWindow = 3;
       ArrayList<Integer> ans = maximumOfWindow(arr,sizeOfWindow);

       for(int max : ans){
        System.out.println(max);
       }


       
    }
    public static ArrayList<Integer> maximumOfWindow(int[] arr, int sizeOfWindow) {
        
        int windowStr = 0;
        int windowEnd = sizeOfWindow;

        ArrayList<Integer> list = new ArrayList<>();
        
        while (windowEnd<=arr.length) {
            
            int maximum = findMaximun(arr, windowStr, windowEnd);
            windowEnd++;
            windowStr++;
            list.add(maximum);
            
        }
        return list;
        
    }
    
    public static int findMaximun(int[] arr,int windowStr, int windowEnd) {
        int max = Integer.MIN_VALUE;

        for(int i = windowStr; i < windowEnd; i++){

            if(max<arr[i]){
                max= arr[i];
            }

        }
        return max;
        
    }
    
    
}
