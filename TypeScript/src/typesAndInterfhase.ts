// interfase

type human = {
    name:string,
    age?:any

}
const obj : any = {
    
}
interface Dev extends human{
    postion?:String
}

interface FrontendDev extends Dev{
  
    html: boolean,
    css: boolean,
    js: boolean,
    react: boolean,
}
interface BackendDev extends Dev{
   
    node: boolean,
    express: boolean,
    db: boolean,
    SystemDesign?: boolean,
}

type FullstackDev = FrontendDev & BackendDev;

type User = BackendDev | FrontendDev | FullstackDev;





const user : User = {
    name:"bhavishy",
    html:true,
    css:true,
    js:true,
    react:true,
    node:true,
    express:true,
    db:true,
   
}
const user2 : FrontendDev = {
    name:"bhavi",
    postion:"junior frontend dev",
    html:true,
    css:true,
    js:true,
    react:true,

   
}
const user3 : FullstackDev = {
    name:"bhavishy",
    postion:"senior Software enginer",
    html:true,
    css:true,
    js:true,
    react:true,
    node:true,
    express:true,
    db:true,

   
}

function printDev(user:FullstackDev){

    console.log(user.db);


}
function printDev2(user:FrontendDev){

    console.log(user.name);


}

function printDev3(user:BackendDev){
    console.log(user.node);



     

}

printDev(user)
printDev2(user2)
printDev3(user)
printDev(user)
