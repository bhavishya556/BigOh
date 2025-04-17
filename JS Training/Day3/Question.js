// 🧠 JavaScript ES6+ Concepts – Practice Questions (10 Questions)

// 🟢 Basic Level

// 1. Destructure the array to get first and second elements.
const nums = [10, 20, 30];
// Your code here:
const [first, second] = nums;
console.log(first, second); // 10 20

// 2. Destructure the object to get name and role.
const employee = { name: "Alice", role: "Engineer", department: "Tech" };
// Your code here:
const { name, role } = employee;
console.log(name, role); // Alice Engineer

// 3. Use spread operator to merge two arrays.
const a = [1, 2];
const b = [3, 4];
// Your code here:
const mergedArray = [...a, ...b];
console.log(mergedArray); // [1, 2, 3, 4]


// 4. Rewrite this function using arrow function syntax.
function greet(name) {
  return "Hello, " + name;
}
// Your code here:
const greetArrow = (name) => `Hello, ${name}`;
console.log(greetArrow("Alice")); 

// 🟡 Medium Level

// 5. Use template literals to print: "My name is Alice and I am a Developer".
const person = { name: "Alice", role: "Developer" };
// Your code here:
console.log(`My name is ${person.name} and I am a ${person.role}`); // My name is Alice and I am a Developer

// 6. Write a function that takes any number of arguments and returns their sum using rest operator.
function sumAll(...args) {
  // Your code here:
    return args.reduce((acc, curr) => acc + curr, 0);
}
// Call it with some numbers:

// 7. Create a callback function that runs after a timeout of 1 second.
function runAfterDelay(callback) {
  // Your code here:
    setTimeout(callback, 1000);
}
// Use it:

// 🔴 Hard Level

// 8. Create a Promise that resolves after 2 seconds with value "Done".
function delayedPromise() {
  // Your code here:
    return new Promise((resolve) => {
        setTimeout(() => resolve("Done"), 2000);
    });
}
const promise = delayedPromise();
promise.then((result) => {
  console.log(result); // "Done"
});
// Use .then() to log the result:

// 9. Rewrite the following using async/await.
function fetchData() {
  return new Promise((resolve) => {
    setTimeout(() => resolve("Fetched Data"), 1000);
  });
}
// Your async function here:
async function fetchDataAsync() {
  const data = await fetchData();
  console.log(data); // "Fetched Data"
}
fetchDataAsync(); // Call the async function

// 10. Handle error using try...catch in an async function that throws an error.
async function mightFail() {
  throw new Error("Something went wrong!");
}
// Your code here:
async function handleError() {
  try {
    await mightFail();
  } catch (error) {
    console.error(error.message); // "Something went wrong!"
  }
}
