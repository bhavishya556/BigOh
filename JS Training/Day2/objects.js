// ✅ 1. Object Declaration
const user = {
    firstName: "Bhavishya",
    'last Name': "Verma",
    123: 22,
    isAdmin: false
  };
  
  // ✅ 2. Accessing Properties
  console.log(user.123);        // Dot notation: Bhavishya
  console.log(user["lastName"]);      // Bracket notation: Verma
  
  // Note: Bracket notation allows dynamic keys
  const key = "age";
  console.log(user[key]);             // 22
  
  // ✅ 3. Modifying Properties
  user.age = 23;
  console.log(user.age);              // 23
  
  // ✅ 4. Adding New Properties
  user.email = "bhavishya@example.com";
  console.log(user.email);            // bhavishya@example.com
  
  // ✅ 5. Deleting Properties
  delete user.isAdmin;
  console.log(user.isAdmin);          // undefined
  
  // ✅ 6. Nested Objects
  const company = {
    name: "Big Oh Tech",
    address: {
      street: "A-80, Sector-2",
      city: "Noida",
      state: "UP"
    },
    employees: [
      {
        name: "Ritesh Verma",
        role: "Manager"
      },
      {
        name: "Bhavishya Verma",
        role: "Trainee"
      }
    ]
  };
  
  console.log(company.address.city);          // Noida
  console.log(company.employees[1].name);     // Bhavishya Verma
  
  // ✅ 7. Object Methods
  const student = {
    name: "Aditya",
    marks: [80, 90, 75],
    getAverage: function () {
      let sum = this.marks.reduce((acc, curr) => acc + curr, 0);
      return sum / this.marks.length;
    }
  };
  
  console.log(student.getAverage());  // 81.666... (average marks)
  
  // ✅ Bonus: Object.keys, Object.values, Object.entries
  console.log(Object.keys(user));      // ['firstName', 'lastName', 'age', 'email']
  console.log(Object.values(user));    // ['Bhavishya', 'Verma', 23, 'bhavishya@example.com']
  console.log(Object.entries(user));   // [['firstName', 'Bhavishya'], ...]
  
  // ✅ Loop through Object using for...in
  for (let prop in user) {
    console.log(`${prop}: ${user[prop]}`);
  }
  
  // ✅ Object Destructuring
  const { firstName, lastName } = user;
  console.log(`Full Name: ${firstName} ${lastName}`); // Bhavishya Verma
  
  console.log("_----------------------------------------------------");
  // 🔰 Sample Object
const person = {
    firstName: "Bhavishya",
    lastName: "Verma",
    age: 22,
    skills: {
      frontend: "React",
      backend: "Node.js"
    }
  };
  
  // 🔹 1. Object.assign() → Used for shallow copy and merging
  const shallowCopy = Object.assign({}, person); // Shallow copy
  shallowCopy.skills.backend = "Express"; // This will also affect 'person.skills.backend'
  console.log("person.skills.backend:", person.skills.backend); // "Express"
  console.log("Shallow copy:", shallowCopy);
  
  // ✅ Summary:
  // - Syntax: Object.assign(target, ...sources)
  // - Supports multiple sources
  // - Returns the target object
  // - Only does shallow copy (nested objects are shared)
  
  // 🔹 2. Object.keys() → Get all keys
  console.log("Keys:", Object.keys(person)); // ["firstName", "lastName", "age", "skills"]
  
  // 🔹 3. Object.values() → Get all values
  console.log("Values:", Object.values(person));
  
  // 🔹 4. Object.entries() → Get key-value pairs as nested arrays
  console.log("Entries:", Object.entries(person));
  
 
  
  // 🔹 6. Object.hasOwnProperty() → Check if property exists on the object itself
  console.log("Has 'age'?", person.hasOwnProperty("age")); // true
  console.log("Has 'toString'?", person.hasOwnProperty("toString")); // false (inherited from prototype)
  
  // 🔹 7. Object.freeze() → Makes object immutable
  const frozen = Object.freeze({ ...person });
  frozen.age = 30; // ❌ Won’t work
  console.log("Frozen object:", frozen);
  
  // 🔹 8. Object.seal() → Can modify existing props, but can’t add/delete
  const sealed = Object.seal({ city: "Noida" });
  sealed.city = "Delhi"; // ✅ Allowed
  delete sealed.city; // ❌ Not allowed
  sealed.state = "UP"; // ❌ Not allowed
  console.log("Sealed object:", sealed);
  
  // 🔹 9. Object.is() → Strict comparison (like ===, but better for NaN)
  console.log("Is same:", Object.is(NaN, NaN)); // true
  console.log("=== NaN:", NaN === NaN); // false
  
  // 🔹 10. Object.getOwnPropertyNames()
  console.log("Property names:", Object.getOwnPropertyNames(person));
  
  // 🔹 11. Object.defineProperty() → Add fine-grained property
  const user2 = {};
  Object.defineProperty(user2, "username", {
    value: "Bhavi",
    writable: false, // can’t change it
    enumerable: true, // shows in keys
    configurable: false // can’t delete
  });
  console.log("user.username:", user2.username);
  user2.username = "Verma"; // ❌ won’t update
  console.log("After write:", user2.username);
  
  // 🔹 12. Object.getPrototypeOf() → Get prototype of object
  console.log("Prototype:", Object.getPrototypeOf(person));
  
  // 🔹 13. Object.setPrototypeOf() → Set a new prototype
  const proto = { company: "BigOh" };
  Object.setPrototypeOf(person, proto);
  console.log("Person company:", person.company); // "BigOh"
  
  // 🔹 14. JSON methods (used to deep copy sometimes)
  const deepCopy = JSON.parse(JSON.stringify(person));
  deepCopy.skills.backend = "MongoDB";
  console.log("Original backend:", person.skills.backend); // Not affected (proves deep copy)
  
  // ⚠️ JSON method doesn’t work with:
  // - Functions
  // - Undefined
  // - Symbol
  // - Circular references
  
  // 🔹 15. Object.entries + forEach loop example
  Object.entries(person).forEach(([key, value]) => {
    console.log(`Key: ${key}, Value:`, value);
  });
  