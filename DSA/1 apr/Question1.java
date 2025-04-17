import java.util.HashMap;
import java.util.Map;

class Question1{
    public static void main(String[] args) {
        int[] arr ={1,2,3,3,3,3,9,9,9,1,1,4,4,3};
        removeDuplicates(arr);

        
    }
    public static void removeDuplicates (int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i =0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i]) + 1);
            }else{
                map.put(arr[i], 1);

            }

        }

        int[] ans = new int[map.size()];
        int i = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

         ans[i] = entry.getKey();
         i++;
        }

        for(int j = 0; j<ans.length; j++){
            System.out.println(ans[j]);
        }

   


    }
}