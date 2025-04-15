// === 1. Using `for` loop ===
console.log("Using 'for' loop:");
const arr = [10, 20, 30, 40, 50];

// The classic 'for' loop, used for iterating over arrays with access to index.
for (let i = 0; i < arr.length; i++) {
  console.log(`Index ${i}, Value: ${arr[i]}`);
}

// Output:
// Index 0, Value: 10
// Index 1, Value: 20
// Index 2, Value: 30
// Index 3, Value: 40
// Index 4, Value: 50


// === 2. Using `for-of` loop ===
console.log("\nUsing 'for-of' loop:");
const arr2 = ["apple", "banana", "cherry"];

// The 'for-of' loop is used for iterating over iterable objects like arrays and strings.
// It directly accesses the values without needing to know the index.
for (const fruit of arr2) {
  console.log(fruit);
}

// Output:
// apple
// banana
// cherry


// === 3. Using `for-in` loop ===
console.log("\nUsing 'for-in' loop:");
const person = {
  name: "Alice",
  age: 25,
  city: "Wonderland"
};

// The 'for-in' loop is used for iterating over object properties (keys).
// It accesses each key of the object. Be cautious: for-in also iterates over inherited properties.
for (const key in person) {
  console.log(`${key}: ${person[key]}`);
  console.log(typeof(key));
}

// Output:
// name: Alice
// age: 25
// city: Wonderland


// === Example of incorrect usage of `for-in` with arrays ===
console.log("\nIncorrect usage of 'for-in' with arrays:");
const arr3 = [100, 200, 300];

// Using 'for-in' for an array will iterate over the **indexes** (keys as strings), not values.
for (const index in arr3) {
  console.log(`Index: ${index}, Value: ${arr3[index]}`);
}

// Output:
// Index: 0, Value: 100
// Index: 1, Value: 200
// Index: 2, Value: 300

// The issue here is that the index is a string (e.g., "0", "1", "2") rather than a number.


/* === Correcting the issue: Use `for-of` instead for arrays === */
console.log("\nCorrecting with 'for-of' loop for arrays:");
for (const value of arr3) {
  console.log(value); // This will correctly output the values.
}

// Output:
// 100
// 200
// 300


// === Advanced Example using `hasOwnProperty` to avoid inherited properties in `for-in` loop ===
console.log("\nAvoiding inherited properties using 'hasOwnProperty':");
const obj = {
  name: "Bob",
  profession: "Developer"
};

Object.prototype.age = 30;  // Adding a property to the prototype chain

// Using 'for-in' on an object includes inherited properties unless we filter them.
for (const key in obj) {
  if (obj.hasOwnProperty(key)) {  // Check if the key is an own property (not inherited)
    console.log(`${key}: ${obj[key]}`);
  }
}

// Output:
// name: Bob
// profession: Developer
// The inherited 'age' property won't be logged because we checked with `hasOwnProperty`.

