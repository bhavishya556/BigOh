// ✅ Universal Validation Function
function validateArgs(func, args) {
    if (typeof func !== "function") {
      return "❌ Error: Provided input is not a function.";
    }
  
    if (func.length !== args.length) {
      return `❌ Error: Function expects ${func.length} argument(s), but got ${args.length}.`;
    }
  
    for (let i = 0; i < args.length; i++) {
      if (typeof args[i] === "undefined") {
        return `❌ Error: Argument at position ${i + 1} is undefined.`;
      }
  
      // Check for undeclared (ReferenceError) using try-catch
      try {
        void args[i];
      } catch {
        return `❌ Error: Argument at position ${i + 1} is not declared.`;
      }
  
      if (typeof args[i] !== "number") {
        return `❌ Error: Argument at position ${i + 1} is not a number.`;
      }
  
      if (isNaN(args[i])) {
        return `❌ Error: Argument at position ${i + 1} is NaN (Not a Number).`;
      }
    }
  
    return null; // No validation error
  }
  
  console.log(validateArgs.length);
  // 🧠 Smart Function-Based Calculator with Validation
  function smartCalculator(func, ...args) {
    const validationError = validateArgs(func, args);
    if (validationError) return validationError;
  
    try {
      return func(...args);
    } catch (err) {
      return "❌ Runtime Error: " + err.message;
    }
  }
  
  // 🔧 Math Functions
  
  ///mapping 
  const cal = {
    add: (a,b)=> ...cToF.apply,
    sub: ()...cToF.
  }
  
  const add = (a, b) => a + b;
  const subtract = (a, b) => a - b;
  const multiply = (a, b) => a * b;
  const divide = (a, b) => b === 0 ? "❌ Error: Cannot divide by zero." : a / b;
  const power = (a, b) => Math.pow(a, b);
  
  // 🌡️ Temperature Conversion
  const cToF = (c) => (c * 9) / 5 + 32;
  const fToC = (f) => ((f - 32) * 5) / 9;
  
  // 📐 Area
  const areaOfRectangle = (l, w) => l * w;
  const areaOfCircle = (r) => Math.PI * r * r;
  
  // 🧪 Test Cases
  
  console.log("✅ Add:", smartCalculator(add, 5, 3));                      // 8
  console.log("✅ Power:", smartCalculator(power, 2, 4));                 // 16
  console.log("✅ C to F:", smartCalculator(cToF, 0));                    // 32
  console.log("✅ Area of Circle:", smartCalculator(areaOfCircle, 3));   // ~28.27
  
  // ❌ Invalid Use Cases
  console.log("❌ Wrong Type:", smartCalculator(add, "5", 2));             // Not a number
  console.log("❌ Missing Arg:", smartCalculator(subtract, 10));          // Less args
  console.log("❌ Extra Arg:", smartCalculator(multiply, 5, 5, 1));       // More args
  console.log("❌ Undefined Var:", smartCalculator(divide, 20, undefined)); // Undefined
  
  // Simulating undeclared variable (via try-catch block)
  try {
    console.log("❌ Undeclared:", smartCalculator(subtract, x, 2)); // 'x' not declared
  } catch (e) {
    console.log("❌ Undeclared Variable:", e.message);
  }
  