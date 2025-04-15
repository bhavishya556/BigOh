
// 1Arithmetic Operators
// ---------------------
let a = 10;
let b = 3;

console.log("Addition:", a + b);        // 13
console.log("Subtraction:", a - b);     // 7
console.log("Multiplication:", a * b);  // 30
console.log("Division:", a / b);        // 3.333...
console.log("Modulus (Remainder):", a % b); // 1
console.log("Exponentiation:", a ** b); // 1000

// Increment & Decrement
let c = 5;
console.log("Post-increment (c++):", c++);  // 5 (then becomes 6)
console.log("After increment:", c);        // 6
console.log("Pre-decrement (--c):", --c);  // 5 (decrement before return)

// ---------------------
// 2️⃣ Assignment Operators
// ---------------------
let x = 10;
x += 5;  // x = x + 5
console.log("x is",x);
x=10
x -= 2;  // x = x - 2
console.log("x is",x);
x=10
x *= 2;  // x = x * 2
console.log("x is",x);
x=10
x /= 4;  // x = x / 4
console.log("x is",x);
x=10
x %= 3;  // x = x % 3
console.log("x is",x);
x=10
x **= 2; // x = x ** 2
console.log("x is",x);
x=10

   // Depends on above ops

// ---------------------
// 3️⃣ Comparison Operators
// ---------------------
console.log("Loose Equality (==):", 5 == '5');   // true → type coercion
console.log("Strict Equality (===):", 5 === '5');// false → type must also match
console.log("Not Equal (!=):", 5 != '5');        // false
console.log("Strict Not Equal (!==):", 5 !== '5');// true
console.log("Greater than:", 10 > 5);            // true
console.log("Less than:", 2 < 1);                // false
console.log("Greater or equal:", 10 >= 10);      // true
console.log("Less or equal:", 5 <= 4);           // false

// Interview Tip: Always use === and !== to avoid unexpected coercion bugs

// ---------------------
// 4️⃣ Logical Operators
// ---------------------
let p = true;
let q = false;
console.log("------logical operators------");

console.log("AND (&&):", p && q);     // false
console.log("OR (||):", p || q);      // true
console.log("NOT (!):", !p);  
     // false

// Short-circuiting: Stops evaluating when result is determined
console.log("true || 'fallback':", true || 'fallback');    // true
console.log("false || 'fallback':", false || 'fallback');  // "fallback"
console.log("false && 'no run':", false && 'no run');      // false
console.log("true && 'run':", true && 'run');              // 'run'

// ---------------------
// 5️⃣ Type Coercion & Edge Cases
// ---------------------
console.log("null == undefined:", null == undefined);   // true
console.log("null === undefined:", null === undefined); // false

console.log("NaN === NaN:", NaN === NaN);               // false
console.log("Object.is(NaN, NaN):", Object.is(NaN, NaN)); // true

// Conversion to boolean
console.log("Boolean(0):", Boolean(0));                 // false
console.log("Boolean('0'):", Boolean('0'));             // true
console.log("Boolean(''):", Boolean(''));               // false
console.log("Boolean('hello'):", Boolean('hello'));     // true
console.log("Boolean(undefined):", Boolean(undefined)); // false
console.log("Boolean(null):", Boolean(null));           // false

// ---------------------
// 6️⃣ Best Practices
// ---------------------

// ---------------------

// ---------------------
// 8️⃣ Object Comparison 
// ---------------------
let obj1 = { a: 1 };
let obj2 = { a: 1 };
console.log("obj1 === obj2:", obj1 === obj2); // false → different references
let obj3 = obj1;
console.log("obj1 === obj3:", obj1 === obj3); // true → same reference


let input = 0;
let value1 = input || 10;     // ❌ 10 (because 0 is falsy)
console.log("value1:", value1); // 10
let value2 = input ?? 10;     // ✅ 0 (because it's not null/undefined)
console.log("value1:", value2); // 10


console.log("---------falsy value-----------------")
let values = [false, 0, -0, 0n, "", null, undefined, NaN];

values.forEach(val => {
  console.log(`${val} →`, Boolean(val)); // All will log → false


});

if(Boolean(undefined) === !!undefined){
    console.log("equal")
}else{
    console.log("not equal")
}