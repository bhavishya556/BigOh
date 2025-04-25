type personInfo = personName | otherDetails;

type personName = "John" | "Jack" | "Justin";

type otherDetails = {
  id: number;
  age: number;
};

type Person = {
  myInfo: personInfo;
  myOtherInfo: personInfo;
};

const applicant = {
  myInfo: "John",
  myOtherInfo: { id: 123, age: true },
} ;

console.log(applicant.myInfo.toUpperCase);


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
  
  // .log(joe.address.postCode); // Property 'postCode' does not exist on type 'string | TAddress'. Property 'postCode' does not exist on type 'string'.(2339)

