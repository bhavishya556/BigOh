let num : number[] =[1,2,3,4,5,6,7];

function sum(arr:number[]):number{

    return arr.reduce((acc,cur) => acc + cur, 0)
 
}


function sumBySpred(...spred : number[]):number{

    return spred.reduce((acc,cur) => acc + cur, 0)
 
}

console.log(sum(num));
console.log(sumBySpred(1,2,3,4,5));

export {}

const arr = [1,2]
const b = [...arr]

const obj = {
    a :1,
    arr:[1,2]
}

const obj2 = {...obj}

obj2.arr[1]=0;

const c = arr
