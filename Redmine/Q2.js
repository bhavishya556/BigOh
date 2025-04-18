// ✅ Smart Function-Based Calculator
function smartCalculator(func, ...args) {
    try {
      if (typeof func !== "function") {
        throw new Error("Provided input is not a function.");
      }
  
      if (func.length !== args.length) {
        throw new Error(
          `Function expects ${func.length} argument(s), but got ${args.length}.`
        );
      }
  
      return func(...args);
    } catch (err) {
      return "❌ Error: " + err.message;
    }
  }
  
  // 🔧 Sample Functions
  
  // Basic Arithmetic
  const add = (a, b) => a + b;
  const subtract = (a, b) => a - b;
  const multiply = function (a, b) { return a * b };
  const divide = (a, b) => b !== 0 ? a / b : "Division by zero";
  const power = (a, b) => Math.pow(a, b);
  
  // Temperature Conversions
  const celsiusToFahrenheit = (c) => (c * 9) / 5 + 32;
  const fahrenheitToCelsius = (f) => ((f - 32) * 5) / 9;
  
  // Area Calculations
  const areaOfRectangle = (l, w) => l * w;
  const areaOfCircle = (r) => Math.PI * r * r;
  
  // 🧪 Test Cases
  
  console.log("Add:", smartCalculator(add, 5, 3));                     // 8
  console.log("Subtract:", smartCalculator(subtract, 10, 4));         // 6
  console.log("Multiply:", smartCalculator(=, 6, 7));          // 42
  console.log("Divide:", smartCalculator(divide, 20, 4));             // 5
  console.log("Power:", smartCalculator(power, 2, 4));                // 16
  
  console.log("C to F:", smartCalculator(celsiusToFahrenheit, 0));    // 32
  console.log("F to C:", smartCalculator(fahrenheitToCelsius, 98));   // ~36.67
  
  console.log("Area of Rectangle:", smartCalculator(areaOfRectangle, 5, 3)); // 15
  console.log("Area of Circle:", smartCalculator(areaOfCircle, 3));   // ~28.27
  
  // ❌ Error Handling
  console.log("Too few args:", smartCalculator(add, 5));              // ❌ Error
  console.log("Invalid input:", smartCalculator("not-a-function", 5)); // ❌ Error
  