function a(){
    console.log("executed--------------------");
}
setTimeout(a, 0);

for(let i=0; i<10000; i++){
    console.log(i);
}


function calculate(a, b, operation) {
    return operation(a, b);
  }
  
  function add(x, y) {
    return x + y;
  }
  
  console.log(calculate(5, 3, add)); // 8


  let obj1 = {1:"one"}
  let obj2 = {2:"two"}
  const mobj = {...obj1,...obj2}
  