// Description

// const obj = { a: 1, b: 'hello', c: true };
// const updated = updateObject(obj, 'b', 'world');
// Function that takes object as first parameter and second parameter of take only keys of the object provided. Also value type should be same as the original

function updateObject<T, K extends keyof T>(obj: T, key: K, value: T[K]): T {
    return {
      ...obj,
      [key]: value,
    };
  }
  
  const obj = { a: 1, b: 'hello', c: true };

const updated = updateObject(obj, 'b', 'world'); 
// updated: { a: 1, b: 'world', c: true }
export{}