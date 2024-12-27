import java.sql.SQLOutput;
import java.util.*;
abstract class Employee
{
    private String name;
    private int id;
    public Employee(String name , int id)
    {
        this.name= name;
        this.id= id;
    }
    public String getName()
    {
        return name;
    }
    public int getID()
    {
        return id;
    }
     public abstract double calculateSalary();
    @Override
    public String toString()
    {
        return "Employee[name= "+name+",id="+id+",salary="+calculateSalary()+"]";
    }
}
class FullTimeEmployee extends Employee{
     private double monthlySalary;
     public FullTimeEmployee(String name , int id, double monthlySalary)
     {
         super(name,id);// using the super keyword  a child class can run the constructor of its parent class
         this.monthlySalary= monthlySalary;// monthly salary is the variable declared in this class only so it is written by this keyword
     }
     @Override
    public double calculateSalary()
     {
         return monthlySalary;
     }
}
class PartTimeEmployee extends Employee{
    private int hourswork;
     private double hourlyrate;
     public PartTimeEmployee(String name , int id,int hourswork, double hourlyrate)
     {
         super(name, id);
         this.hourswork=hourswork;
       this.hourlyrate= hourlyrate;

     }
     @Override
    public double calculateSalary()
     {
         return hourswork*hourlyrate;
     }
}
class PayrollSystem{
    private ArrayList<Employee> employeeList;
    public PayrollSystem()
    {
        employeeList= new ArrayList<>();
    }
    public void addEmployee(Employee employee)
    {
        employeeList.add(employee);
    }
    public void removeEmployee(int id)
    {
        //employeeList.remove(employee);
        Employee employeeToRemove= null;
        for(Employee employee : employeeList)
        {
    if(employee.getID()==id)
    {
        employeeToRemove= employee;
        break;
    }
        }
        if(employeeToRemove!=null)
        {
            employeeList.remove(employeeToRemove);
        }
    }
    public void displayEmployees()
    {
        for(Employee employee : employeeList)
        {
            System.out.println(employee);
        }
    }
}
public class Main{
    public static void main(String []args)
    {
        PayrollSystem payroll = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("Vikas",1,70000);
        PartTimeEmployee pt = new PartTimeEmployee("Ankush",2,40,100);
        payroll.addEmployee(emp1);
        payroll.addEmployee(pt);
        System.out.println("Initial Employee details");
        payroll.displayEmployees();
        System.out.println("Removing Employees");
        payroll.removeEmployee(2);
        System.out.println("Remaining details");
        payroll.displayEmployees();
    }
}
