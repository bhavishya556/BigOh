// Function to check if the expression is balanced or not
function isBalanced(expr) {
    let count = 0;

    // Traversing the expression
    for (let i = 0; i < expr.length; i++) {
        if (expr[i] === '{') {
            count++;
        } else {
            // It is a closing bracket
            count--;
        }
        if (count < 0) {
            // This means there are more closing brackets than opening ones
            return false;
        }
    }

    // If count is not zero, it means there are more opening brackets
    return count === 0;
}

// Recursive function to find the number of reversals
function recur(expr, n, ind, change, ans) {
    // When generated expression is balanced
    if (isBalanced(expr)) {
        ans[0] = Math.min(ans[0], change);
    }

    // When we have covered the whole string
    if (ind === n) {
        return;
    }

    // Keep bracket as it is
    recur(expr, n, ind + 1, change, ans);

    // Reverse the bracket
    let exprArray = expr.split('');
    if (exprArray[ind] === '{') {
        exprArray[ind] = '}';
    } else {
        exprArray[ind] = '{';
    }
    recur(exprArray.join(''), n, ind + 1, change + 1, ans);
}

// Returns the count of minimum reversals for making expr balanced. Returns -1 if expr cannot be balanced.
function countMinReversals(expr) {
    // Length of expression
    const n = expr.length;

    // To store answer
    let ans = [Infinity];

    // When the total number of brackets is odd
    if (n % 2 === 1) {
        return -1;
    } else {
        // Function call for finding answer
        recur(expr, n, 0, 0, ans);
        return ans[0] === Infinity ? -1 : ans[0];
    }
}

// Test the function
const expr = "}{{}}{{{";
console.log(countMinReversals(expr));  
