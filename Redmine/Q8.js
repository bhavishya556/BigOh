const url = "https://localhost:400"

const obj = {
    "keyOne": "value One",
    "keyTwo": "value Two",
    "keyThree": "value Three",
  }
  
let ans = url;

ans += "?";
  


for (const key in obj) {
    ans += `${key}=${obj[key]}&`; // inbuild methods use
  }

  // in one method,
console.log(ans.slice(0,-1))
//.replaceAll(" ","%")); 
