// ✅ JavaScript Arrays – One Complete Unit

// 🔹 1. Creation of Arrays
const fruits = ["apple", "banana", "orange"];
const numbers = new Array(1, 2, 3); // Less common
const mixed = [1, "text", true];

// 🔹 2. Accessing and Modifying Elements
console.log("First fruit:", fruits[0]); // "apple"
fruits[1] = "grape";                    // Modify
console.log("Modified fruits:", fruits); // ["apple", "grape", "orange"]

// 🔹 3. Array Methods: push, pop, shift, unshift
let arr = [1, 2, 3];
arr.push(4);         // ➕ Add to end → [1, 2, 3, 4]
arr.pop();           // ➖ Remove from end → [1, 2, 3]
arr.unshift(0);      // ➕ Add to start → [0, 1, 2, 3]
arr.shift();         // ➖ Remove from start → [1, 2, 3]
console.log("After push/pop/unshift/shift:", arr);

// 🔹 4. splice() & slice()
let letters = ["a", "b", "c", "d"];
letters.splice(1, 2);             // Remove 1 item at index 1 → ["a", "c", "d"]
console.log("After splice1:", letters);
letters = ["a", "b", "c", "d"];
letters.splice(1, 2, "x");        // Insert "x" at index 1 → ["a", "x", "c", "d"]
console.log("After splice2:", letters);

const sliced = letters.slice(1, 3); // ["x", "c"]
console.log("Sliced array:", sliced);

// 🔹 5. concat()
const merged = [1, 2].concat([3, 4]);
console.log("Merged array:", merged);

// 🔹 6. Properties: length, indexOf, includes
const colors = ["red", "green", "blue"];
console.log("Length:", colors.length);             // 3
console.log("Index of green:", colors.indexOf("green")); // 1
console.log("Includes blue?", colors.includes("blue"));   // true

// 🔹 7. Iteration: for loop & forEach
console.log("Using for loop:");
for (let i = 0; i < colors.length; i++) {
  console.log(`Index ${i}:`, colors[i]);
}

console.log("Using forEach:");
colors.forEach((color, index) => {
  console.log(`Index ${index}:`, color);
});

// 🔹 8. map() – Transform elements
const nums = [1, 2, 3, 4];
const doubled = nums.map(n =>{
    if(n % 2 === 0)return n;
    }); // [2, 4, 6, 8]
console.log("Doubled numbers:", doubled);

// 🔹 9. filter() – Filter by condition
const even = numbers.filter((nums)=>{
    if(nums % 2 === 0){
        return nums * 2
    }
  })
console.log("Even numbers:", even);

//🔹 10. reduce() – Reduce to a single value
const sum = nums.reduce((acc, curr) => acc + curr, 0); // 10
console.log("Sum of numbers:", sum);

// 🔹 11. Summary Table (as comment)

/*
| Method        | Description                                 | Mutates? |
|---------------|---------------------------------------------|----------|
| push()        | Add to end                                  | ✅ Yes   |
| pop()         | Remove from end                             | ✅ Yes   |
| unshift()     | Add to beginning                            | ✅ Yes   |
| shift()       | Remove from beginning                       | ✅ Yes   |
| splice()      | Add/remove at specific position             | ✅ Yes   |
| slice()       | Extract portion (returns new array)         | ❌ No    |
| concat()      | Merge arrays                                | ❌ No    |
| map()         | Transforms each element                     | ❌ No    |
| filter()      | Filters elements by condition               | ❌ No    |
| reduce()      | Reduces array to single result (sum, etc.)  | ❌ No    |
| forEach()     | Iterates over array                         | ❌ No    |
*/

// 🔚 End of Array Unit








const users = [
    { firstName: "Bhavishya", lastName: "Verma", age: 23 },
    { firstName: "Ritesh", lastName: "Verma", age: 23 },
    { firstName: "Aditya", lastName: "Raj", age: 25 },
    { firstName: "Shivendra", lastName: "Porwal", age: 28 },
    { firstName: "Aman", lastName: "Singh", age: 23 },
    { firstName: "Nikita", lastName: "Sharma", age: 26 },
    { firstName: "Rahul", lastName: "Yadav", age: 24 },
    { firstName: "Priya", lastName: "Chopra", age: 27 },
    { firstName: "Sakshi", lastName: "Gupta", age: 21 },
    { firstName: "Ankit", lastName: "Rana", age: 30 }
  ];
  
  // Output: { '21': 1, '23': 3, '24': 1, '25': 1, '26': 1, '27': 1, '28': 1, '30': 1 }
let userAge = users.reduce((acc, curAge)=>{

    if(acc[curAge.age]){
        acc[curAge.age] = acc[curAge.age] + 1;
    }
    else{
        acc[curAge.age] = 1;
    }
    return acc;
},{})
console.log(userAge);

const username = users.filter((user)=>{
    if(user.age > 25){
       return user.firstName;
    }
})

console.log(username);

const userName2 = users.reduce((acc,cur)=>{
    if(cur.age > 25){
        acc.push(cur.firstName);
    }
    return acc;

},[])
console.log(userName2);

