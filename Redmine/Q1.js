function evaluateExpression(expression) {
    try {
      // Remove surrounding brackets if any
      expression = expression.trim();
      if (expression.startsWith("[") && expression.endsWith("]")) {
        expression = expression.slice(1, -1);
      }
  
      // Evaluate using Function constructor (respects BODMAS)
      const result = Function(`return (${expression})`)();
  
      return result;
    } catch (error) {
      return "Invalid expression: " + error.message;
    }
  }
  
  // Example Usage
  const expr = "[ 1+(2+3)*4-10/2 ]";
  const result = evaluateExpression(expr);
  console.log("✅ Result:", result); // Output: 16
  