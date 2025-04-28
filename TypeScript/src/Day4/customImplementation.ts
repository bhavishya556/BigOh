// type User = {
//     id: string
//     name: string,
//     age: number
//     isHuman: boolean
//     user?:User

// }

// type CustomPick<T,U extends keyof T>={[P in U]: T[P];}


// type NewUpdateUser2 = CustomPick<User, "name" | "age" >
// type NewUpdateUser = Pick<User, "name" | "age">






type User = {
    id: string
    name: string,
    age?: number
    isHuman: boolean
    user?:{
        age: number;
        name: string;
      }

}



type NullableProperties<U> = U extends object
    ? {
        [K in keyof U] : NullableProperties<U[K]> | null
      }
    : U|null



type CustomRequried<U> = U extends object
    ? {
        [K in keyof U]-? : CustomRequried<U[K]> 
      }
    : U



type CustomPartial<U> = U extends object
    ? {
        [K in keyof U]? : CustomPartial<U[K]> 
      }
    : U




type Custom1<U> = U extends object
    ? {
        [K in keyof U]-?: CustomRequried<U[K]>;
      }
    : U extends string
    ? U | null // If U is a string, make it nullable
    : U;


type n = number | null | undefined

type m = Omit<User, "id" | "name" | "isHuman"> ;
type m1 = Exclude<User, "id" | "name" | "isHuman"> & { [key: string]: any };

 

type PartialUser = Partial<User>;
type RequiredlUser = Required<User>;
 
type NullableExample = NullableProperties<NestedUser>;
type CustomRequriedEx = CustomRequried<NestedUser>;
type CustomPartialEx = CustomPartial<NestedUser>;
 
 
interface NestedUser {
    age?: number;
    personalInfo?: {
        name: string;
        address: {
            city: string ;
        };
    };
}


