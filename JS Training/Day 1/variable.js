//variables
//var
console.log("---------var-----------------")
console.log(a)
var a = 10

var a 
console.log(a)

var a = 9
console.log(a)

//hoisting works in var show undiefiend but not{a = 100}

console.log(a)

{
    a=50
    console.log(a)
}
console.log(a)
{
   var a=500
    console.log(a)
}
//scope i global
console.log(a)

{var c=89}
console.log(c)


le
// let 
console.log("---------let----------")

//console.log(b)
// let b;
//hoisting not works in let 

// let b;
// cannot redeclare

{
    let b =10
    console.log(b);
}
//console.log(b)
//scope is not global

//---------------const---------------
console.log("----------const_________")
//console.log(e)
const e=0;
{
    const w=90
    console.log(e)
}
//console.log(w)
//hoisting not works in const 
//const cantbe only define without value(value is must)
// cnat be redclare
// value cant change after declare
//e=9;
console.log(e)

x=100;
console.log(x)