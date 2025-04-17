// 🔹 1. Array Destructuring

const arr = [1, 2, 3];
const [a, b, c] = arr;
console.log(a, b, c); // 1 2 3

// Skipping elements
const [x, , y] = [10, 20, 30, 40];
console.log(x, y); // 10 30

// Using rest operator
const [first, ...rest] = [1, 2, 3, 4];
console.log(first); // 1
console.log(rest);  // [2, 3, 4]

// Default values
const [d = 5, e = 10] = [1,2];
console.log(d, e); // 1 10

let arrr = [d2 = 5, e2 = 10];
// arrr = [1]; // Reassigning to an array with one element
console.log(arrr); // 1 10

// Nested array destructuring
const nested = [1, [2, 3]];
const [one, [two, three]] = nested;
console.log(one, two, three); // 1 2 3

// Swapping variables
let m = 1, n = 2;
[m, n] = [n, m];
console.log(m, n); // 2 1

// 🔹 2. Object Destructuring

const user = { name: "Bhavishya", age: 21 };
const { name, age } = user;
console.log(name, age); // Bhavishya 21

// Renaming variables
const { name: userName } = user;
console.log(userName); // Bhavishya

// Default values
const { city = "Noida" } = user; // if is not here
console.log(city); // Noida

// Nested object destructuring
const profile = {
  name: "Bhavishya",

  address: {
    city: "Noida",
    pincode: 201301
  }
};


const {
  address: { city: loc, pincode }
} = profile;
console.log(loc, pincode); // Noida 201301

// Rest in object
const dev = { name: "Bhavishya", age: 21, role: "Developer" };
const { name: devName, ...otherDetails } = dev;
console.log(devName); // Bhavishya
console.log(otherDetails); // { age: 21, role: 'Developer' }

// 🔹 3. Mixed Destructuring

const data = {
  title: "Dev",
  tags: ["JS", "Node"],
  meta: {
    views: 100
  }
};

const {
  title,
  tags: [firstTag,restt],
  meta: { views }
} = data;
console.log(title, firstTag, views,restt); // Dev JS 100

// 🔹 4. Destructuring in Function Parameters

// Array params
function printCoordinates(...h) {
  console.log(`X: ${x}, Y: ${y}`);
}
printCoordinates(10, 20);

// Object params
function greet({ name, role }) {
  console.log(`Hello ${name}, you are a ${role}`);
}
greet({ name: "Bhavishya", role: "Engineer" });

// 🔹 5. Destructuring in Loops

const users = [
  { name: "Bhavishya", age: 21 },
  { name: "Raj", age: 22 }
];

for (const { name, age } of users) {
  console.log(`${name} is ${age} years old`);
}

// 🔹 6. React Hook Example (Array Destructuring)

// const [count, setCount] = useState(0); // works same way: [value, setter]

// 🔹 7. Destructuring from API response

const response = {
  data: {
    user: {
      name: "Bhavishya"
    }
  }
};

const {
  data: {
    user: { name: userNameFromAPI }
  }
} = response;
console.log(userNameFromAPI); // Bhavishya

// 🔹 8. Pitfall Example

try {
  const { a } = null; // ❌ Error: Cannot destructure property 'a' of 'null'
} catch (err) {
  console.log("Error:", err.message);
}

// 🔹 9. Internal working (conceptual)

const tempArr = [10, 20];
const [aa, bb] = tempArr;
// Internally: let aa = tempArr[0]; let bb = tempArr[1];

const tempObj = { name: "Bhavishya" };
const { name: newName } = tempObj;
// Internally: let newName = tempObj.name;
