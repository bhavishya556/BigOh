
// Description

// Define an enum Direction with values Up, Down, Left, and Right. Then, create a function that takes a Direction value and returns a string representing the direction.

// Complete Below Method

// console.log(getDirection(Direction.Up)); // Output: "Up"
 enum Direction {
    Up = "up",
    Dowm = "down",
    Left = "left",
    Right = "rigth"
}


function going3(dir:Direction){

    if(dir === Direction.Up) console.log("go to up")
    else if(dir === Direction.Dowm) console.log("go to down")
    else if(dir  === Direction.Left) console.log("go in left")
    else console.log("go in right")
    
    
}

console.log("String enum");

going3(Direction.Up);
going3(Direction.Dowm);
going3(Direction.Right);
going3(Direction.Left);
export {}