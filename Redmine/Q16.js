const obj = {
    "company": {
      "departments": [
        {
          "name": "Engineering",
          "employees": [
            { "id": 1, "name": "Alice", "role": "Software Engineer" },
            { "id": 2, "name": "Bob", "role": "Senior Engineer" },
            { "id": 3, "name": "Charlie", "role": "DevOps Engineer" }
          ]
        },
        {
          "name": "Human Resources",
          "employees": [
            { "id": 4, "name": "Diana", "role": "HR Manager" },
            { "id": 5, "name": "Ethan", "role": "Recruiter" }
          ]
        },
        {
          "name": "Marketing",
          "employees": [
            { "id": 6, "name": "Fiona", "role": "Marketing Specialist" },
            { "id": 7, "name": "George", "role": "Content Writer" }
          ]
        },
        {
          "name": "Finance",
          "employees": [
            { "id": 8, "name": "Hannah", "role": "Accountant" },
            { "id": 9, "name": "Ian", "role": "Financial Analyst" }
          ]
        },
        {
          "name": "Product",
          "employees": [
            { "id": 10, "name": "Julia", "role": "Product Manager" },
            { "id": 11, "name": "Kevin", "role": "UI/UX Designer" }
          ]
        }
      ]
    }
  }


  const arr = [1,20,3,4,5,6,7,8,6,9]

  console.log( arr.some(num => num ===3));
  console.log( arr.map(num => (num ===3)? num : "-"));
  console.log( arr.find(num => num ===20));


  
  function deleteEmployee (departmentName, employeeId) {

    const department = obj.company.department.find((dept)=> dept.name ===departmentName );

    const updadedEmpArray = department.employees.filter(emp => emp.id !== employeeId )

    department.employee = updadedEmpArray;

      

  }

  // //add employee to department

  //   function addEmployee(departmentName, employee) {
  //       const department = obj.company.departments.find(dep => dep.name === departmentName);
  //       if(department){
  //           department.employees.push(employee);
  //           console.log(`Employee ${employee.name} added to ${departmentName} department.`);

  //       } else {
  //           console.log(`Department ${departmentName} not found.`);
  //       }
  //   }

  //   function editEmployee (departmentName, employeeId, updatedInfo) {
  //       const department = obj.company.departments.find(dep => dep.name === departmentName);
  //       if(department){
  //           department.employees = department.employees.map(emp => {
  //               if(emp.id === employeeId){
  //                   return {...emp, ...updatedInfo};
  //               }
  //               return emp;
  //           });
            
  //       } else {
  //           console.log(`Department ${departmentName} not found.`);
  //       }
  //   }

    

  