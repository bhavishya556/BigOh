function sum(a:number,b:number):number{
    // console.log("object");
    return a+b
}

function printSum(sum:(a:number,b:number)=>void, num1:number, num2:number){
    console.log("sum is",sum(num1,num2));
    
}

//by typealica defile type of function
type sumFun = (a:number,b:number) => number;

printSum(sum,4,5)