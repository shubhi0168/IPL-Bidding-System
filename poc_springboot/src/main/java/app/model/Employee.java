package app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Employee {

    @Id
    private int empid;

    private int mobileno;
    private String empname;
    private String location;

    public Employee(int empid, int mobileno, String empname, String location) {
        this.empid = empid;
        this.mobileno = mobileno;
        this.empname = empname;
        this.location = location;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public int getMobileno() {
        return mobileno;
    }

    public void setMobileno(int mobileno) {
        this.mobileno = mobileno;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empid=" + empid +
                ", mobileno=" + mobileno +
                ", empname='" + empname + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public Employee() {
        // TODO Auto-generated constructor stub
    }

}
