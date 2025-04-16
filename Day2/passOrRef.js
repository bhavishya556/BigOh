"use strict";

// 🧠 Primitive values (number, string, boolean, null, undefined, symbol, bigint) are passed by value
function modifyPrimitive(x) {
  x = x + 10; // This changes only the local copy
  console.log("Inside function (primitive):", x);
}

let num = 5;
modifyPrimitive(num);
console.log("Outside function (primitive):", num); // 5 - Original value remains unchanged


// 🧠 Arrays (and objects) are reference types — passed by reference
function modifyArray(arr) {
  arr.push(99); // This modifies the original array, since both point to the same memory
  console.log("Inside function (array):", arr);
}

let originalArray = [1, 2, 3];
modifyArray(originalArray);
console.log("Outside function (array):", originalArray); // [1, 2, 3, 99] - Modified


// 🔁 If you want to avoid modifying the original array, create a copy
function modifyArrayCopy(arr) {
  let newArr = [...arr]; // Spread operator makes a shallow copy
  newArr.push(77);
  console.log("Inside function (copied array):", newArr);
}

let safeArray = [10, 20, 30];
modifyArrayCopy(safeArray);
console.log("Outside function (safe array):", safeArray); // [10, 20, 30] - Unchanged


// 🔁 Another way to copy an array: using slice()
function copyWithSlice(arr) {
  let copied = arr.slice(1,2);
  copied.push(55);
  console.log("Inside function (slice copy):", copied);
}

let slicedArray = [7, 8, 9];
copyWithSlice(slicedArray);
console.log("Outside function (sliced array):", slicedArray); // [7, 8, 9]


// ⚠️ Reassigning the array inside function does NOT affect original
function reassignArray(arr) {
  arr = [100, 200, 300]; // New reference assigned locally
  console.log("Inside function (reassigned):", arr);
}

let resetArray = [5, 6, 7];
reassignArray(resetArray);
console.log("Outside function (after reassignment):", resetArray); // [5, 6, 7]


// 💡 Summary:
console.log("\n===== Summary =====");
console.log("Primitive types ➤ Passed by value (safe, local copy)");
console.log("Reference types (Array, Object) ➤ Passed by reference (shared memory)");
console.log("To avoid mutation ➤ Use spread [...], slice(), or structuredClone()");
