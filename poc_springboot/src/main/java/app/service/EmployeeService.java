package app.service;

import app.dao.EmployeeRepository;
import app.model.Employee;
import app.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public boolean updateEmployee(Employee e)
    {
        // if update fails then we will return false, else
        // we will return true.
        boolean status = false;
        if(employeeRepository.existsById(e.getEmpid()))
        {
            employeeRepository.save(e);
            status = true;
        }
        return status;

    }


    public List<Employee> getAll() {
        // TODO Auto-generated method stub
        return employeeRepository.findAll();
    }

    public Employee getEmployee(int empid) {
        Employee e =new Employee();
        Optional<Employee> o = employeeRepository.findById(empid);
        if(o.isPresent())
        {
            e = o.get();
        }
        return e;
    }

    public boolean deleteEmployee(int empid)
    {
        // if update fails then we will return false, else
        // we will return true.
        boolean status = false;

        Employee e =new Employee();
        Optional<Employee> o = employeeRepository.findById(empid);
        if(o.isPresent())
        {
            employeeRepository.deleteById(empid);
            status = true;
        }
        return status;

    }

    public boolean addEmployee(Employee e) {

        boolean status = false;
        if(!employeeRepository.existsById(e.getEmpid()))
        {
            employeeRepository.save(e);
            status = true;
        }
        return status;
    }
}
