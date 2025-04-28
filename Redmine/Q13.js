function deepClone(obj) {
    if (obj === null || typeof obj !== 'object') {
      return obj; // Return the value if obj is not an object
    }
  
    if (obj instanceof Date) {
      return new Date(obj); // Clone Date objects
    }
  
    if (obj instanceof RegExp) {
      return new RegExp(obj); // Clone RegExp objects
    }
  
    const newObj = Array.isArray(obj) ? [] : {}; // Check if it's an array or object
  
    for (const key in obj) {
      if (obj.hasOwnProperty(key)) {
        newObj[key] = deepClone(obj[key]); // Recursively clone each property
      }
    }
  
    return newObj;
  }
  
  const originalObject = {
    name: 'Alice',
    birthDate: new Date('2000-01-01'),
    nestedObj: {
      value: 42,
      arr: [1, 2, 3]
    }
  };
  
  const clonedObject = deepClone(originalObject);
  
  clonedObject.nestedObj.value = 99;
  clonedObject.birthDate.setFullYear(2022);
  
  console.log(originalObject.nestedObj.value);  // 42
  console.log(clonedObject.nestedObj.value);    // 99
  console.log(originalObject.birthDate.getFullYear()); // 2000
  console.log(clonedObject.birthDate.getFullYear());   // 2022
  


  const originalObject = {
    name: 'Bob',
    arr: [1, 2, 3],
    date: new Date(),
    map: new Map([['key', 'value']])
  };
  
  /// recursion, wrong method do not use any inbuild methods
  const clonedObject = structuredClone(originalObject);
  
  clonedObject.arr.push(4);
  clonedObject.date.setFullYear(2022);
  clonedObject.map.set('newKey', 'newValue');
  
  console.log(originalObject.arr);     // [1, 2, 3]
  console.log(clonedObject.arr);       // [1, 2, 3, 4]
  console.log(originalObject.date.getFullYear()); // Current year
  console.log(clonedObject.date.getFullYear());   // 2022
  console.log(originalObject.map);     // Map { 'key' => 'value' }
  console.log(clonedObject.map);       // Map { 'key' => 'value', 'newKey' => 'newValue' }
  