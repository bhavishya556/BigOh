let arr = [1, [2, [3, 4]], 5];

function summ(arr){
    let sum = 0;
    for (let i = 0; i < arr.length; i++) {
        if (Array.isArray(arr[i])) {
            sum += summ(arr[i]);
        } else {
            sum += arr[i];
        }
    }
    return sum;
}
console.log(summ(arr)); 