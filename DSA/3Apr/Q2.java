public class Q2 {
    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int arr2[] = {3, 4, 5, 6, 7, 8, 6, 12, 13};

        System.out.println("Median: " + findMedian(arr1, arr2));
    }

    public static double findMedian(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length;
        int[] merged = new int[n + m];

        int i = 0, j = 0, k = 0;

        // Merge two sorted arrays
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }

        while (i < n) merged[k++] = arr1[i++];
        while (j < m) merged[k++] = arr2[j++];

        int total = n + m;
        if (total % 2 == 0) {
            return (merged[total / 2] + merged[total / 2 - 1]) / 2.0;
        } else {
            return merged[total / 2];
        }
    }
}
