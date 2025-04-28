// After reversing the array is should have exact reverse type

// const arr = [42, 'hello', true];
// const reversedTuple = reverseTuple(tuple);
// ReversedTuple should be [boolean, string, number]

// Challenges1 : Define the const arr using the type

type MyTuple = [number, string, boolean];

const arr: MyTuple = [42, 'hello', true];

type Reverse<T extends unknown[]> = T extends [infer First, ...infer Rest]
  ? [...Reverse<Rest>, First]
  : [];

type ReversedTuple = Reverse<MyTuple>;


const reversed: ReversedTuple = [true, 'hello', 42];




export{}