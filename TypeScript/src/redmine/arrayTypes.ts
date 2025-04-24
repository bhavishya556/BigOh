// Write a function that takes an array of numbers and returns a new array where each number is doubled. Use TypeScript to define the function's parameter and return type.

// console.log(doubleArray([1, 2, 3]));
// Output: [2, 4, 6]


let arr = new Array<number>(1,2,3,4)
console.log(arr);
arr.map((curIdx) => curIdx*2)


function doubelArr (arr:Array<number>):Object{
   const doubelArr  = arr.map((curIdx:number) => curIdx*2)
   return doubelArr;

}

console.log( doubelArr(arr));