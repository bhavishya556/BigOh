"use strict"; // Node.js uses strict mode by default

// 🌍 Global Scope in Node.js
console.log("Global `this`:", this); // {} → module.exports in Node.js

// 👤 Global Regular Function
function globalRegular() {
  console.log("Regular function in global scope:", this); // undefined in strict mode
}
globalRegular();

// 🔥 Global Arrow Function
const globalArrow = () => {
  console.log("Arrow function in global scope:", this); // {} → inherits from where it's defined
};
globalArrow();

// 🧱 Object with Regular Function
const user1 = {
  name: "Bhavishya",
  greet: function () {
    console.log("user1.greet `this`:", this); // this === user1
    console.log("user1.greet name:", this.name); // Bhavishya
  }
};
user1.greet();

// ❌ Object with Arrow Function – Wrong use case
const user2 = {
  name: "Bhavishya",
  greet: () => {
    console.log("user2.greet `this`:", this); // this !== user2, it's global/module
    console.log("user2.greet name:", this.name); // undefined
  }
};
user2.greet();

// 📦 Object without name property
const user3 = {
  greet: function () {
    console.log("user3.greet name:", this.name); // undefined, because `this.name` doesn't exist
  }
};
user3.greet();

// 🧪 Using this in setTimeout with Regular Function
function TimerRegular() {
  this.count = 0;
  setInterval(function () {
    this.count++;
    console.log("Regular setInterval:", this.count); // ❌ NaN or crash – `this` is not bound
  }, 1000);
}
// new TimerRegular(); // Uncomment to test

// ✅ Using this in setTimeout with Arrow Function
function TimerArrow() {
  this.count = 0;
  setInterval(() => {
    this.count++; // Arrow captures `this` from TimerArrow context
    console.log("Arrow setInterval:", this.count); // ✅ 1, 2, 3...
  }, 1000);
}
// new TimerArrow(); // Uncomment to test

// 🧱 Class with Regular vs Arrow
class Demo {
  constructor() {
    this.label = "I am class";
  }

  regularMethod() {
    console.log("regularMethod:", this.label); // ✅ works
  }

  arrowMethod = () => {
    console.log("arrowMethod:", this.label); // ✅ works too, `this` captured at class level
  }
}
const d = new Demo();
d.regularMethod();
d.arrowMethod();
