// Create a utils type DefinedProperties that takes object and make every property to be also defined (remove null or undefined from the value type)

// Challenge one -> Single level object type
// Challenge two -> Nested object type

// interface User {
// age?: number;
// name: string | null;
// }

// type DefineExample = DefinedProperties<Example>;
// Should infer DefineExample as { age: number; name: string; }

interface User {
    name : string,
    age?:number,
    addres: string | null
}

export type T = keyof User

type NewUse = Required<NonNullable<User>>

type RequiredNonNullableObject<objType,K extends keyof objType > = { [Keys in keyof objType ] : NonNullable<objType[Keys]>; };


export let user:RequiredNonNullableObject<User,"addres"> = {
    name:"bhavi",
    age:37,
    addres:null
}
export{}