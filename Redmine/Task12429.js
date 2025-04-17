const { emp_data, projects_data } = require('./data.js');

const finalReport = emp_data.employees.map((emp) => {
  const empId = emp.employee_id;

  // Get all projects the employee worked on
  const employeeProjects = projects_data.projects
    .filter((project) => {
      return project.hours.some((entry) => entry.employee_id === empId);
    })
    .map((project) => {
      const empHours = project.hours.find((entry) => entry.employee_id === empId).hours_worked;
      return {
        project_id: project.project_id,
        name: project.name,
        hours_worked: empHours,
        rating: project.rating
      };
    });

  // Calculate total hours and average rating
  const totalHours = employeeProjects.reduce((sum, p) => sum + p.hours_worked, 0);
  const averageRating = employeeProjects.reduce((sum, p) => sum + p.rating, 0) / employeeProjects.length;

  return {
    employee_id: emp.employee_id,
    name: emp.name,
    role: emp.role,
    total_hours_worked: totalHours,
    average_project_rating: parseFloat(averageRating.toFixed(2)),
    projects: employeeProjects
  };
});

console.log(JSON.stringify(finalReport, null, 2));
