// Description

// Define an interface Person with properties name (string) and age (number). Then, create a function that takes a Person object and returns a string in the format: "Name: <name>, Age: <age>".

// Complete describePerson Function :

// console.log(describePerson({ name: 'Alice', age: 30 }));

// Expected Output: "Name: Alice, Age: 30"

interface User {
    name:string,
    age: number
}


const describePerson = (user :User) : string=>{

    const useStr = `Name ${user.name}, Age ${user.age}`
    return useStr
}

let user : User = {
    name : "bhavishya",
    age: 78
}

console.log(describePerson(user))
export{}
   