// Just like the how array.map works create mapper function for object which takes in the object and callback function to update every value.

// Challenges
// 1. Return type of function should be same as object constant used with updated value type
// 2. Get the item type from the sent object value when passing callback
// 3. Type check -> Object type to be used as parameter should be of same property value

// const originalObject = { a: 1, b: 2, c: 3 };
// const mappedObject = mapObject(originalObject, (value) => value.toString());
// MappedObject should be and have same type

// { a: '1', b: '2', c: '3' }

function mapObject<T extends object, R>(
    obj: T,
    callback: (value: T[keyof T]) => R
  ): { [K in keyof T]: R } {
    const result = {} as { [K in keyof T]: R };
  
    for (const key in obj) {
      if (Object.prototype.hasOwnProperty.call(obj, key)) {
        result[key] = callback(obj[key]);
      }
    }
  
    return result;
  }
  

  const originalObject = { a: 1, b: 2, c: 3 };
  
  const mappedObject = mapObject(originalObject, (value) => value.toString());
  

  console.log(mappedObject);
  export{}