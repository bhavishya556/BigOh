import java.util.Arrays;

public class Q2 {
        public static void main(String[] args) {
        int[][] nums = {
            { 12, 34, 56, 78, 90, 23, 45, 67, 1 },
            { 89, 21, 32, 54, 76, 98, 10, 11, 2 },
            { 22, 33, 44, 55, 66, 77, 88, 99, 3 },
            { 90, 10, 11, 12, 13, 14, 15, 16, 4 },
            { 17, 18, 19, 20, 21, 22, 23, 24, 5 },
            { 25, 26, 27, 28, 29, 30, 31, 32, 6 },
            { 33, 34, 35, 36, 37, 38, 39, 40, 7 }
    };
    findElement(nums,29);

    }


    public static void findElement(int[][] nums, int target) {

        for(int i =0; i<nums.length; i++){
         
            Arrays.sort(nums[i]);

            int search = binarySearch(nums[i], target);
            if( search!= -1){

                System.out.println("i = " +i+"j = "+search);

                break;
            }
       
        }



    }

    public static int binarySearch(int[] nums, int target) {
        int n = nums.length; 
        int low = 0, high = n - 1;

   
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            else if (target > nums[mid]) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
    
}
