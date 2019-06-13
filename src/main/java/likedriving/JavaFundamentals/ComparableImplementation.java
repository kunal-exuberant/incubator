package likedriving.JavaFundamentals;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

/*
Implement sorting of employee class based on age and then name
 */
public class ComparableImplementation {


    public static void main(String[] args) {
        EmployeeList employeeList = new EmployeeList();
        Employee employee1 = new Employee("Jithin", 28);
        Employee employee2 = new Employee("Ashutosh", 28);
        Employee employee3 = new Employee("Ravish", 27);

        employeeList.getEmployeeList().add(employee1);
        employeeList.getEmployeeList().add(employee2);
        employeeList.getEmployeeList().add(employee3);
        employeeList.sort();

        for(Employee employee: employeeList.getEmployeeList()){
            System.out.println(employee);
        }
    }
}


class CompareEmployees implements Comparator<Employee> {

    @Override
    public int compare(Employee emp1, Employee emp2) {
        if(emp1.getAge() < emp2.getAge()){
            return -1;
        }
        if(emp1.getAge() > emp1.getAge()){
            return 1;
        }
        if(emp1.getAge() == emp1.getAge()){
            return emp1.getName().compareTo(emp2.getName());
        }
        return 0;
    }
}


@Data
class EmployeeList extends CompareEmployees{
    private List<Employee> employeeList = new ArrayList<>();

    public void sort(){
        Collections.sort(employeeList, new CompareEmployees());
    }
}

@Data
@AllArgsConstructor
class Employee{
    private String name;
    private int age;
}


