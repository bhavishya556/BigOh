// // The original function
// const add = (a: number, b: number): number => a + b;

// // The wrapper function to log the call
// function loggerWrapper(){
// }

// // Wrapping the original function with the logger
// const loggedAdd = loggerWrapper(add);

// // Calling the wrapped function
// const value = loggedAdd(3, 5); // This will log the details and return the value

// // Output the result
// console.log(value); // Outputs: 8



// The original function
const add = (a: number, b: number): number => a + b;


function loggerWrapper<T extends (...args: any[]) => any> (fn: T): T {

  const fun = function (...args: any[]) {
    console.log(`Calling function ${fn.name} with arguments: ${args.join(', ')}`);
    return fn(...args);
  } as T;

  return fun;
}


const loggedAdd = loggerWrapper(add);


const value = loggedAdd(3, 5); 


console.log(value); 
export{}