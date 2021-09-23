package app.controller;

import app.model.Employee;
import app.model.Stock;
import app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> list() {
        return employeeService.getAll();
    }

    @GetMapping("/getEmployeeInfo")
    public Employee getProduct(@RequestParam("empid") int empid) {
        System.out.println("Inside get employee");
        System.out.println("received id" + empid);
        return employeeService.getEmployee(empid);
    }

    @PostMapping("/updateEmployeeInfo")
    public boolean updateEmployee(@RequestBody Employee e)
    {
        System.out.println("Inside update employee");
        boolean status = employeeService.updateEmployee(e);
        return status;
    }

    @PostMapping("/addEmployeeInfo")
    public boolean addEmployee(@RequestBody Employee e)
    {
        System.out.println("Inside add employee");
        boolean status = employeeService.addEmployee(e);
        return status;
    }


    @GetMapping("/deleteEmployee")
    public boolean deleteEmployee(@RequestParam("empid") int empid) {
        System.out.println("Inside delete employee");
        System.out.println("received id" + empid);
        return employeeService.deleteEmployee(empid);
    }


    /*
    @GetMapping("/getemployeedetails")
    public Employee getDetails(@RequestParam("x") int empid)
    {
        Employee e =employeeService.getDetails(empid);

        return e;


    }

	@PostMapping("/updateemp")
	public boolean updateEmp(@RequestBody Emp e)
	{
		return service.updateEmp(e);
	}

*/
}
