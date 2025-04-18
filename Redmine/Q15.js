function rotate90Deg(nums) {
    // Step 1: Transpose the matrix
    for (let i = 0; i < nums.length; i++) { //
        for (let j = 0; j < nums[i].length; j++) { //
            if (i === j || i < j) {
                const temp = nums[i][j];
                nums[i][j] = nums[j][i];
                nums[j][i] = temp;
            }
        }
    }

    // Step 2: Reverse each row
    for (let i = 0; i < nums.length; i++) {
        reverseArray(nums[i]);
    }

    // Step 3: Print the matrix
    for (let i = 0; i < nums.length; i++) {
        console.log(nums[i].join(" , "));
    }
}

// Helper function to reverse an array
function reverseArray(arr) {
    let left = 0, right = arr.length - 1;
    while (left < right) {
        // const temp = arr[left];
        // arr[left] = arr[right];
        // arr[right] = temp;

        left++;
        right--;
    }
}

// Sample input
const nums = [
    [1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
    [11, 12, 13, 14, 15, 16, 17, 18, 19, 20],
    [21, 22, 23, 24, 25, 26, 27, 28, 29, 30],
    [31, 32, 33, 34, 35, 36, 37, 38, 39, 40],
    [41, 42, 43, 44, 45, 46, 47, 48, 49, 50],
    [51, 52, 53, 54, 55, 56, 57, 58, 59, 60],
    [61, 62, 63, 64, 65, 66, 67, 68, 69, 70],
    [71, 72, 73, 74, 75, 76, 77, 78, 79, 80],
    [81, 82, 83, 84, 85, 86, 87, 88, 89, 90],
    [91, 92, 93, 94, 95, 96, 97, 98, 99, 100]
];

// Call the function
rotate90Deg(nums);
