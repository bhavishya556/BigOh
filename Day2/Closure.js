function parent(){
    let a = 10;
    child();
    function child(){
        a++;
        console.log(a);
    }
}
parent();