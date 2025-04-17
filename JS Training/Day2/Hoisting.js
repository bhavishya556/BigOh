// 🌟 VAR Example
console.log(a); // ✅ undefined (hoisted + initialized)
var a = 10;

// 🌟 LET Example
// console.log(b); ❌ ReferenceError: Cannot access 'b' before initialization
let b = 20;

// 🌟 CONST Example
// console.log(c); ❌ ReferenceError: Cannot access 'c' before initialization
const c = 30;

// 🌟 Function Declaration
sayHi(); // ✅ Works because function declarations are hoisted fully
function sayHi() {
  console.log("Hello from function declaration");
}

// 🌟 Function Expression with VAR
console.log(sayHello); // ✅ undefined
// sayHello(); // ❌ TypeError: sayHello is not a function
var sayHello = function () {
  console.log("Hello from function expression");
};

// 🌟 Function Expression with LET
// sayBye(); 
// ❌ ReferenceError: Cannot access 'sayBye' before initialization
//console.log(sayBye);
let sayBye = function () {
  console.log("Bye!");
};
