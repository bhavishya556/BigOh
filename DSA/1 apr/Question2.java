import java.util.ArrayList;


class Question2 {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int target = 10;


        int[][] ans = tripletArray(arr,target);


        for(int i = 0; i<ans.length; i++){
            System.out.print("[");
            for(int j =0; j<3; j++){

                System.out.print(" "+ans[i][j]+" ");

            }
            System.out.print("]");
            System.out.println();
        }

    }

    public static int[][] tripletArray(int[] arr, int target) {

   

        ArrayList <int[]> list = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {

                    if (arr[i] + arr[j] + arr[k] == target) {
                        int[] tempArr = new int[3];
                        tempArr[0] = arr[i];
                        tempArr[1] = arr[j];
                        tempArr[2] = arr[k];
                        list.add(tempArr);
                       

                    }

                }

            }
        }

        int[][] ans = list.toArray(new int[list.size()][]);

        if(ans.length == 0){
            int[][] emptyArray = new int[0][0];
            return emptyArray;
        }

        return ans;

      
      

    }

}