  const emp_data = {
    "employees": [
      {
        "employee_id": "E001",
        "name": "John Doe",
        "role": "Developer" 
      },
      {
        "employee_id": "E002",
        "name": "Jane Smith",
        "role": "Designer" 
      },
      {
        "employee_id": "E003",
        "name": "Emily Davis",
        "role": "Project Manager" 
      }
    ]
  }

 const projects_data = {
    "projects": [
      {
        "project_id": "P001",
        "name": "Project Alpha",
        "hours": [
          { "employee_id": "E001", "hours_worked": 120 },
          { "employee_id": "E002", "hours_worked": 80 }
        ],
        "rating": 4.5
      },
      {
        "project_id": "P002",
        "name": "Project Beta",
        "hours": [
          { "employee_id": "E001", "hours_worked": 150 },
          { "employee_id": "E003", "hours_worked": 200 }
        ],
        "rating": 4.7
      },
      {
        "project_id": "P003",
        "name": "Project Gamma",
        "hours": [
          { "employee_id": "E002", "hours_worked": 50 },
          { "employee_id": "E003", "hours_worked": 60 }
        ],
        "rating": 4.0
      }
    ]
  }
  module.exports = { emp_data ,projects_data};