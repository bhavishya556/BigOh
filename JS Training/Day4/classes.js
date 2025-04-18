// 1. **Class Declaration and Syntax**
// A basic class declaration with a constructor and method.
class Person {
    // Constructor method initializes the object's properties
    constructor(name, age) {
      this.name = name;  // Instance property
      this.age = age;    // Instance property
    }
  
    // Instance method to introduce the person
    greet() {
      return `Hi, I'm ${this.name} and I'm ${this.age} years old.`;
    }
  }
  
  // Creating an instance of Person
  const person1 = new Person("Alice", 25);
  console.log(person1.greet());  // Output: Hi, I'm Alice and I'm 25 years old.
  
  // OOps, -->
  // 2. **Understanding Constructors**
  // Constructor is called when a new instance is created.
  class Car {
     counter = 0
    constructor(brand, model) {
      this.brand = brand;
      this.model = model;

      this.counter++

        console.log(this)
    }
    
    getCarInfo() {
        console.log("its static method");
    }

    increaseValue(obj) {
        obj.counter = tthis.counter + obj.counter

        console.log(this)
    }
  }

  class Honda extends Car {

  }

const car1 = new Car("Toyota", "Corolla") // 1
car1.increaseValue(car1)//2

const car2 = new Car("Honda", "Civic") //1
car1.increaseValue(car2)

console.log(car1.counter) 

// new Car("Honda", "Civic")
new Car("BMW", "X5")
new Car("Mercedes", "Benz")

console.log(Car.counter)
  
  // Creating an instance of Car
  const car1 = new Car("Toyota", "Corolla");
  console.log(car1.brand);  // Output: Toyota
  console.log(car1.model);  // Output: Corolla
  
  // 3. **Defining and Using Instance Properties and Methods**
  class Animal {
    constructor(name, species) {
      this.name = name;  // Instance property
      this.species = species;  // Instance property
    }
  
    // Instance method
    describe() {
      return `${this.name} is a ${this.species}.`;
    }
  }
  
  const tiger = new Animal("Tiger", "Big Cat");
  console.log(tiger.describe());  // Output: Tiger is a Big Cat.
  
  // 4. **Role of `this` in Classes**
  // `this` refers to the current instance of the class.
  class User {
    constructor(username, email) {
      this.username = username;
      this.email = email;
    }
  
    // Method that uses `this` to access the instance properties
    getUserInfo() {
      return `User: ${this.username}, Email: ${this.email}`;
    }
  }
  
  const user1 = new User("john_doe", "john@example.com");
  console.log(user1.getUserInfo());  // Output: User: john_doe, Email: john@example.com
  

  // 5. **Implementing Inheritance Between Classes**
  // Subclass inherits properties and methods from a superclass.
  class Dog extends Animal {
    constructor(name, breed) {
      super(name, "Dog");  // Call the parent class constructor
      this.breed = breed;

      console.log(this.describe())

      //
    }
  
    // Overriding the describe method from the parent class
    describe() {
      return `${this.name} is a ${this.breed} dog.`;
    }
  }
  
  const dog1 = new Dog("Buddy", "Golden Retriever");
  console.log(dog1.describe());  // Output: Buddy is a Golden Retriever dog.
  
  // 6. **Using Getter and Setter Methods**
  // Getters and setters allow controlled access to properties.
  class Rectangle {
    constructor(width, height) {
      this._width = width;  // Private variable convention (underscore)
      this._height = height;
    }
  
    // Getter method for area
    get area() {
      return this._width * this._height;
    }
  
    // Setter method to validate width before setting it
    set width(value) {
      if (value > 0) {
        this._width = value;
      } else {
        console.log("Width must be greater than zero.");
      }
    }
  }
  
  const rect = new Rectangle(5, 10);
  console.log(rect.area);  // Output: 50 (using getter)
  rect.width = -3;  // Invalid width (using setter)
  rect.width = 8;  // Valid width
  console.log(rect.area);  // Output: 80 (after changing width)
  
  // 7. **Exploring Static Methods and When to Use Them**
  // Static methods are called on the class itself, not on an instance.
  class Calculator {
    static add(a, b) {
      return a + b;
    }
  
    static subtract(a, b) {
      return a - b;
    }
  }
  
  // Calling static methods without creating an instance
  console.log(Calculator.add(5, 3));  // Output: 8
  console.log(Calculator.subtract(5, 3));  // Output: 2
  
  // 8. **Private Methods and Fields**
  // Private fields and methods are introduced using the `#` syntax (only accessible within the class).
  class Counter {
    #count = 0;  // Private field
  
    increment() {
      this.#count++;
      return this.#count;
    }
  
    getCount() {
      return this.#count;
    }
  }
  
  const counter = new Counter();
  console.log(counter.increment());  // Output: 1
  console.log(counter.getCount());   // Output: 1
  // console.log(counter.#count);    // Error: Private field '#count' must be accessed within class

  class Test {
    // static staticMethod() {
    //   console.log("I'm static");
    // }
  
    instanceMethod() {
      console.log("I'm instance");
    }
  }
  
  console.log(Test.hasOwnProperty('staticMethod')); // true ✅
  console.log(Test.prototype.hasOwnProperty('instanceMethod')); // true ✅
  
  
  