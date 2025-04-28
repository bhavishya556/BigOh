// Description

// Use of satisfies
// Use of as
 // Showcase the proper working example



//  let accountCode = '123';
//     let castedAccountCode = <number>accountCode;


let accountCode = 123;
let castedAccountCode = accountCode as number;


type TAddress = {
    addressLine1: string;
    addressLine2?: string;
    postCode: number | string;
    city: string;
    state: string;
    country: string;
  };
  
  type UserKeys = "username" | "email" | "firstName" | "lastName" | "address";
  type TUser = Record<UserKeys, string | TAddress>;
  
  const joe: TUser = {
    username: "joe_hiyden",
    email: "joe@exmaple.com",
    firstName: "Joe",
    lastName: "Hiyden",
    address: {
      addressLine1: "1, New Avenue",
      addressLine2: "Mission Bay",
      postCode: 12345,
      city: "California",
      state: "California",
      country: "USA",
    },
  } satisfies TUser;
export{}
