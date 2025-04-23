let arrString = ["first","second"]
let arrNum = [1,2,3,4]

// one way by genric
function returnFirstElement<T>(arr:T[]){
    return arr[0];
}

//jugad either num arr or string arr

function returnFirstElement2(arr:(number[] | string[])){
    return arr[0];
}


console.log(returnFirstElement<string>(arrString));
console.log(returnFirstElement(arrNum)); // i can skip type also

console.log(returnFirstElement2(arrString));
console.log(returnFirstElement2(arrNum));
