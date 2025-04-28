// 📦 Calculator Function
function simpleCalculator(operator, num1, num2) {
    switch (operator) {
      case '+':
        return num1 + num2;
     
      case '-':
        return num1 - num2;
      case '*':
        return num1 * num2;
      case '/':
        return num2 !== 0 ? num1 / num2 : '❌ Error: Division by zero';
      case '%':
        return num2 !== 0 ? num1 % num2 : '❌ Error: Division by zero';
      default:
        return '❌ Error: Invalid operator';
    }
  }

//   mapping
  
  // 🧪 Example Usage
  console.log("5 + 3 =", simpleCalculator('+', 5, 3));     // 8
  console.log("10 - 4 =", simpleCalculator('-', 10, 4));   // 6
  console.log("6 * 7 =", simpleCalculator('*', 6, 7));     // 42
  console.log("20 / 4 =", simpleCalculator('/', 20, 4));   // 5
  console.log("10 % 3 =", simpleCalculator('%', 10, 3));   // 1
  
  // ❌ Error Cases
  console.log("Divide by 0:", simpleCalculator('/', 10, 0));  // ❌
  console.log("Invalid op:", simpleCalculator('^', 2, 3));    // ❌
  