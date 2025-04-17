"use strict";

// ✅ 1. if statement
const age = 18;
if (age >= 18) {
  console.log("You are an adult."); // This runs if the condition is true
}

// ✅ 2. if-else
const score = 45;
if (score >= 50) {
  console.log("Pass");
} else {
  console.log("Fail"); // This runs if the condition is false
}

// ✅ 3. if-else if-else
const marks = 85;
if (marks >= 90) {
  console.log("Grade A");
} else if (marks >= 75) {
  console.log("Grade B"); // This will run
} else {
  console.log("Grade C");
}

// ✅ 4. Nested if
const user = {
  isLoggedIn: true,
  role: "admin",
};

if (user.isLoggedIn) {
  if (user.role === "admin") {
    console.log("Access granted to admin panel");
  } else {
    console.log("Access granted to user dashboard");
  }
}

// ✅ 5. Ternary Operator (shorthand for if-else)
const num = 5;
const isEven = (num % 2 === 0) ? "Even" : "Odd";
console.log(isEven); // ➝ Odd


// ✅ 6. switch-case (great for multiple discrete values)
const fruit = "banana";

switch (fruit) {
  case "apple":
    console.log("Apples are red.");
    break;
  case "banana":
    console.log("Bananas are yellow."); // This runs
    break;
  case "mango":
    console.log("Mangoes are sweet.");
    break;
  default:
    console.log("Unknown fruit");
}

// ✅ 7. Logical Operators in conditionals
const hasLicense = true;
const hasCar = false;

if (hasLicense && hasCar) {
  console.log("You can drive.");
} else if (hasLicense || hasCar) {
  console.log("Partial access."); // This runs
} else {
  console.log("You can't drive.");
}

// ✅ 8. Nullish Coalescing Operator (??) — returns right-hand side if left is null/undefined
const userName = null;
const finalName = userName ?? "Guest";
console.log(finalName); // ➝ Guest

// ✅ 9. Optional chaining with conditionals
const student = {
  profile: {
    name: "Bhavishya",
  },
};

if (student?.profile?.name) {
  console.log("Student's name is", student.profile.name); // Safe access
}

// ✅ 10. Truthy / Falsy check
const data = "";

if (data) {
  console.log("This is truthy");
} else {
  console.log("This is falsy"); // This runs
}

// Falsy values in JS: false, 0, "", null, undefined, NaN
// Everything else is truthy

// ✅ 11. Shorthand pattern
const isAdmin = true;
isAdmin && console.log("Welcome Admin"); // acts like: if (isAdmin) { console.log(...) }

