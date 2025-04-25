type obj = {
    [key:number] : string,
 
}

type numberType = keyof obj;

const x : numberType = 10;


let str : string = "hi helo";

type stringType = typeof str;

let str2 : stringType = "hiodjcodncjndc"

export{}

//let str3 : stringType = 123; error

type X = {
   
}
const data={
    first:'dfhf',
    second:'dfhf',
    third:'dfhf',
    num : 6
}

function fun (obj : keyof typeof data){
    console.log(obj);
}

// fun("")
export{}
   
