public class Q4 {
    public static void main(String[] args) {
        int[] height = {1,2,3,4,4,4,6,8,4};
        System.out.println(maxWater(height));
        
    }
    
    public static int maxWater(int[] height) {

        int i =0;
        int j =height.length-1;

        int maxWater = 0;

        while (i<j) {
            int minHeight = Math.min(height[i], height[j]);
            int width = j-i;
            int curWater = minHeight * width;
            maxWater = Math.max(maxWater, curWater);

            if(height[i]<height[j]){
                i++;

            }else{
                j--;
            }
            
           

            
        }
        return maxWater;
        
    }

    
}
