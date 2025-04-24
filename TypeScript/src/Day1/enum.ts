enum Direction {
    North,
    South,
    East,
    West
}


function going1(dir:Direction){

    if(dir === Direction.North) console.log("go to up")
    else if(dir === Direction.South) console.log("go to down")
    else if(dir  === Direction.East) console.log("go in left")
    else console.log("go in right")
    
    
}

going1(Direction.East);
going1(Direction.South);
going1(Direction.West);
going1(Direction.North);

console.log("defaul enum");



//----------------------------------------num

enum DirectionNum {
    North =1,
    South,
    East,
    West
}


function goingNum(dir:Direction){

    if(dir === Direction.North) console.log("go to up")
    else if(dir === Direction.South) console.log("go to down")
    else if(dir  === Direction.East) console.log("go in left")
    else console.log("go in right")
    
    
}

console.log("number enum");
going1(Direction.East);
going1(Direction.South);
going1(Direction.West);
going1(Direction.North);


//-----------------------------string

enum Direction3 {
    North = "a",
    South = "b",
    East = "c",
    West = "d"
}


function going3(dir:Direction){

    if(dir === Direction.North) console.log("go to up")
    else if(dir === Direction.South) console.log("go to down")
    else if(dir  === Direction.East) console.log("go in left")
    else console.log("go in right")
    
    
}

console.log("String enum");

going3(Direction.East);
going3(Direction.South);
going3(Direction.West);
going3(Direction.North);
export {}