// Description

// Create a function that takes a parameter which can either be a string or a number. The function should return the parameter as a string.

// Complete stringify method :

// console.log(stringify(123));
// Output: "123"

// console.log(stringify('hello'));
// Output: "hello"

const changeToSting =<T extends string | number> (someting:T  ):string=>{

    const str :string = someting.toString();
    return str;



}

changeToSting<number>(123)
changeToSting<string>("123")

export{}
   