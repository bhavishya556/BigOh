type User = {
    id: string
    name: string,
    age: number
    isHuman: boolean

}


type NewUpdateUser = Pick<User, "name" | "age">

type PartialUser = Partial<NewUpdateUser>

//readonly
type Config = {
    readonly apiKey: string // no one can modify
}

//record


type Users = { [key: string]: User };

const users: Users = {
    'abc123': { id: 'abc123', name: 'John Doe', isHuman: true, age: 49 },
    'xyz789': { id: 'xyz789', name: 'Jane Doe', isHuman: true, age: 43 },
};

type UsersWithRecords = Record<string, User>;
//record just give cleaner syntax

const UsersWithRecords: Users = {
    'abc123': { id: 'abc123', name: 'John Doe', isHuman: true, age: 49 },
    'xyz789': { id: 'xyz789', name: 'Jane Doe', isHuman: true, age: 43 },
};

console.log(users['abc123']); // Output: { id: 'abc123', name: 'John Doe' }



function doSomtingWithApi(apiConfigObj: Config) {

    console.log(apiConfigObj);
}


//event




//omit

type Person = {
    name: string;
    age: number;
    gender: string;
    address?: string;
    nullProperty: null,
    nullProperty2: undefined,
    
}

type NewPerson = Omit<Person, "age" >

type RequriedPerson = Required< NewPerson>

type Eventt = "scroll" | "click" | "hover" | null | undefined
type EventWithVaildProperty = NonNullable<Eventt>
type ExcludeEvent = Exclude<Eventt,"hover">

type ScrollEvent = Extract<Eventt,"scroll">

// const arr=["hh",1,true];
// function random<T>(arr:T[]){
//     return arr[0] as typeof arr[0];
// }
// let guess=random( arr);
// console.log(typeof arr[0])

// // if(typeof guess==='string'){
// //     guess.
// // }


export{}

type Txclude<T, U> = T extends U ? never : T
type Engineer = "frontend" | "backend" | "fullstake" | "SDE"

type Devloper = Txclude<Engineer,"SDE">

type Dev = {
    front:boolean,
    backend:boolean,
    fullstack:boolean,
}

type FullstackDev = Omit<Dev,"front">