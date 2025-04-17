let a=1;
var b=2;
const c=3;

{
    let a=10;
    var b=20;
    const c=30;
    console.log(a); 
    console.log(b,'inside block'); 
    console.log(c); 
}
console.log(a);
console.log(b,'outside block'); 
console.log(c); 

var x =10;
{
    let x = 90;
    console.log(x); // 90
}
console.log(a);
let y =10;
{
   // var y = 90;
    console.log(y); // 90
}
console.log(a);

