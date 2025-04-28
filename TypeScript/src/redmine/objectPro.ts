// Description

// A function to access object property value
// Parameters are object value and key name, key name is restricted to object keys
// Return type is be accessed object value.

// Challenge1 : Flat level object

// const value = flatGet(user, 'name');
// Challenge2 : Nested Object
// const value = deepGet(obj, 'foo.bar.baz');
// const value = deepGet(obj, ['foo','bar','baz'];

// Challenge3 : Full path else type error
type User = {
    name:string,
    age:number
}
const user : User = {
    name:"bhavi",
    age:70
}
let a = user["name"]

function getPropertyValue(user:User, str:keyof User){
    const value = user[str];
    return value;
    
}
let value = getPropertyValue(user,"age")
console.log(value, typeof value);
export{}