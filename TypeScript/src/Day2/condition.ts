type IsString<T> = T extends string ? String : number;

type Test1 = IsString<string>;
type Test2 = IsString<number>;


let str : Test1 = "rf";
let num : Test2 = 9;

//let test: Test2 = "s";


type ApiEndpoints = "users" | "posts" | "comments";
type ApiPath = `/api/${ApiEndpoints}`;

const userPath: ApiPath = "/api/users";
//const invalidPath: ApiPath = "/api/unknown";

//type infrence
let typeInference = [0, 1, null];

type v = [1,2,3,4,"l", null]

let num1:v=[1,2,3,4,"l", null];
export{}
   


