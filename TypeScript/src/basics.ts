//data tyep 
//number boolean String

let x : number = 10;
console.log(x);
let y : any = 8;
y = "now its string";
console.log(y);


function sum(a:number,b:number):number{
    // console.log("object");
    return a+b
}

function printSum(sum:(a:number,b:number)=>void, num1:number, num2:number){
    console.log("sum is",sum(num1,num2));
    
}

//by typealica defile type of function
type sumFun = (a:number,b:number) => number;

function printSumWithTypeAlica(sum:sumFun,num1:number,num2:number){
  console.log(   sum(num1,num2));

}

printSum(sum,x,10)
printSumWithTypeAlica(sum,x,90)

//option and default
function greet(name: string, greeting?: string ,date:Date = new Date()): string {
  console.log(date);
    if (greeting) {
        return `${greeting}, ${name}!`;
    }
    return `Hello, ${name}!`;
}

console.log(greet("bhavi")); 
console.log(greet("bhavishya", "Good morning"));







