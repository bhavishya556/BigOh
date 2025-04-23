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