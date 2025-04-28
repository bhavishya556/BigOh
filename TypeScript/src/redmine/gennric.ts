// Description

// Generic type
// Create Type
// Add constraints
// Add default value
// Add another argument
// One should be optional another one required
// Q1. Create a working example to showcase the above steps

// Generic Function
// Create Generic function
// Make one parameter of function depend on another
// How the argument send change the type of function
// Q2. Create a working example to showcase the above steps


// Generic Type Example
type ResponseData<T extends object = {}> = {
    data: T;
    success: boolean;
    message?: string; 
  };
  

  const successResponse: ResponseData<{ id: number; name: string }> = {
    data: { id: 1, name: "John" },
    success: true,
    message: "Operation successful",
  };
  
  const defaultResponse: ResponseData = {
    data: {},
    success: true,
  };


  export{}