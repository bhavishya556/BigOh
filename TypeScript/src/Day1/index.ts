const salary1 = {
    baseSalary: 100_000,
    yearlyBonus: 20_000
  };
  
  const salary2 = {
    contractSalary: 110_000
  };
function totalSalary(salaryObject: { [key: string]: number }) {
    let total = 0;
    for (const name in salaryObject) {
      total += salaryObject[name];
    }
    return total;
  }
  
  console.log(totalSalary(salary1)); 
  console.log(totalSalary(salary2));



  interface FutureObj {
    [key: string]: string | number | boolean;
    age: number;
  }

  
  const options: FutureObj = {
    age: 1000,
    age2: 1000,
    age3: 1000,
    anyString: 'The request timed out!',
    isFileUpload: false
  };

  function testIndexSignatur(obj:FutureObj){

    console.log(obj);

  }

  export {}