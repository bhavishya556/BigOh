// Create a utils type NullabelProperties that takes object and make every property to be also null

// Challenge one -> Single level object type
// Challenge two -> Nested object type

// interface User {
//     age: number;
//     name: string;
// }

// type NullableExample = NullabelProperties<Example>;
// Should infer NullableExample as { age: number|null ; name: string|null; }

interface User {
    name : string | null,
    age:number,
    addres: string | null
}

type NewUse = Required<NonNullable<User>>

type RequiredNonNullableObject<objType> = { [P in keyof objType] :  objType[P] | null | objType[P] -? };


let user:RequiredNonNullableObject<User> = {
    name:"bhavi",
    age:null,
    addres:"noida"
}
export{}