console.log("---------------------------string-------------------------")
let name = "bhavishy"
console.log(name);

//name[0] = "B"; not works
// name="bhavi"
// console.log(name)

let s2 = new String("bhavishy")

if(s2 == name){
    console.log("equal")
}else{
    console.log("not equal")
}
if(s2 === name){
    console.log("equal")
}else{
    console.log("not equal")
}
console.log( typeof(s2))
console.log( typeof(name))

console.log(name+100)
console.log(1+1200+name+100)
console.log(1+1200+s2+100)
console.log(1,1200,s2,100)
console.log("hi",1+1200+s2+100)
console.log("hi"+1+1200+s2+100)

console.log( typeof(1,1200,s2,100))
console.log( typeof(s2,100))
console.log( typeof(s2+100))
console.log( typeof(9+1+s2+100))
console.log( 9+1-s2+100)
console.log( 9+1-s2+100)
console.log("------------------------number------------------")

console.log(typeof(1)) 
let num = new Number(10);
console.log(typeof(num))
console.log(num+100)
console.log(num.valueOf())

console.log(typeof(num.valueOf()))
console.log(typeof(1.1))
console.log(2e-3)
console.log(9e-6)
let x = BigInt("123456789012345678901234567890");
console.log(typeof(x))

//console.log(x+6756755) not works
console.log(x+BigInt(6756755))

console.log("---------Booleans_______")

let isTrue = true;
let isfalse = true;

console.log(typeof(isTrue));

if(isTrue === isfalse){
    console.log("equal")
}

console.log("-------null--------")
let a = null;
console.log(a);
console.log(typeof(a))  ;

console.log(typeof null === "object");
console.log(typeof(null));
// null is obj
// null is falsy value

console.log("--------undefined---------");
let b;
console.log(b);
console.log(b+3);
console.log(typeof(b));

console.log("---------object----------");
const user = { name: "Bhavi" };
const ref = user;
ref.name = "New Name";
console.log(user); // user.name also changes

console.log("-----------symbol-----------");



