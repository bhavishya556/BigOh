// Write a type guard function that checks if a value is an instance of a class Dog. Then, create a function that takes an array of mixed objects and returns only the objects that are instances of Dog.

// const animals = [new Dog(), new Cat(), new Dog()];
// console.log(filterDogs(animals));
// Output: [Dog, Dog]
class Animal{
    who(){
        console.log("from animal class")

    }
    
}

class Dog extends Animal{
    
    haveLegs(){
        console.log("dog have 4 leg");
    }
}
class Cat extends Animal{
    who(){
        console.log("i am cat");
    }
}



const animalArray:Animal[] = [new Dog(),new Cat() ,new Dog()]

const filterDogs = (animalArray: Animal[]): Dog[] => {
    // Use the filter method with a proper type guard
    const dogArr: Dog[] = animalArray.filter((curAnimal)=>{

        if(curAnimal instanceof Dog){
            return true
        }
        
    } 
    );

    return dogArr; 
};
