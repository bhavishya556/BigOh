// ===================================
// 🚀 ES6 FEATURES: Full Code Example
// ===================================

// ✅ 1. LET & CONST
let age = 25;
age = 26;

const name = "Bhavishya";
// name = "Verma"; ❌ Not allowed

// ✅ Block Scope Example
if (true) {
  let msg = "Hello inside block";
  console.log(msg); // works
}
// console.log(msg); ❌ ReferenceError

// ✅ 2. ARROW FUNCTIONS
const greet = (name) => `Hello, ${name}`;
console.log(greet("Bhavishya")); // Hello, Bhavishya

// ✅ Arrow Function & this
const user = {
  name: "Bhavishyaaaaaa",
  sayHi() {
    setTimeout(() => {
      console.log(`Hi from ${this.name}`); // Uses outer this
    }, 3000);
  }
};
user.sayHi();

// ✅ 3. TEMPLATE LITERALS
const hobby = "coding";
const intro = `I love ${hobby}.
 It's awesome!`;

 // multi line also support
console.log(intro);

// ✅ 4. DESTRUCTURING
// Array
const nums = [10, 20, 30];
const [a, b, c] = nums;
console.log(a, b, c); // 10 20 30

// Object
const person = { name: "Bhavishya", age: 22 };
const { name: personName, age: personAge } = person;
console.log(personName, personAge);

// ✅ 5. DEFAULT PARAMETERS
function welcome(name = "Guest") {
  console.log(`Welcome, ${name}`);
}
welcome(); // Guest

// ✅ 6. SPREAD & REST
// Spread (expand arrays)
const arr1 = [1, 2];
const arr2 = [...arr1, 3, 4];
console.log(arr2); // [1,2,3,4]

// Rest (gather)
function sum(...nums) {
  return nums.reduce((a, b) => a + b, 0);
}
console.log(sum(1, 2, 3)); // 6

// ✅ 7. ENHANCED OBJECT LITERALS
const x = 5;
const y = 10;
const obj = {
  x,
  y,
  sum() {
    return this.x + this.y;
  }
};
console.log(obj.sum()); // 15

// ✅ 8. FOR...OF (values)
for (let char of "ES6") {
  console.log(char); // E S 6
}

// ✅ 9. FOR...IN (keys)
const myObj = { a: 1, b: 2 };
for (let key in myObj) {
  console.log(`${key}: ${myObj[key]}`);
}

// ✅ 10. MODULES (Example only - use in separate files)
// math.js
// export const add = (a, b) => a + b;

// main.js
// import { add } from './math.js';
// console.log(add(2, 3));

// ✅ 11. CLASSES
class Animal {
  constructor(name) {
    this.name = name;
  }

  speak() {
    console.log(`${this.name} makes a sound.`);
  }
}
const dog = new Animal("Dog");
dog.speak(); // Dog makes a sound.

// ✅ 12. PROMISES
const fetchData = () => {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve("Data fetched!");
    }, 1000);
  });
};

fetchData().then((res) => console.log(res)); // Data fetched!

// ✅ BONUS: Hoisting
console.log(hoistedVar); // undefined
var hoistedVar = "I'm hoisted";

// ✅ BONUS: Closures
function outer() {
  let outerVar = "I’m outside!";
  return function inner() {
    console.log(outerVar);
  };
}
const innerFunc = outer();
innerFunc(); // I’m outside!
