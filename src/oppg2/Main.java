package oppg2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;


public class Main{

    private static final int RECURRING_ADDITION = 10000;
    private static final int PERCENT = 7;
    private static final int INCREASE_LOW_SALARY = 25000;
    private static final int LOW_SALARY = 400000;
    private static final int IS_MALE = 30;

    public static void main(String[] args) {


        List<Employee> employees = Arrays.asList(
                new Employee("Charles", "Dickens", GenderEnum.MALE, "CEO", 900000),
                new Employee("Lewis", "Carroll", GenderEnum.MALE, "Chef", 400000),
                new Employee("Thomas", "Carlyle", GenderEnum.MALE, "Waiter", 350000),
                new Employee("Charlotte", "Bronte", GenderEnum.FEMALE, "Chef", 420000),
                new Employee("Matthew", "Arnold", GenderEnum.MALE, "Waiter", 370000));

        //1) Fast tillegg
        Function<Employee, Integer> recurring_addition
                = employee -> employee.getSalary()+ RECURRING_ADDITION;

        //2) Prosenttillegg
        Function<Employee , Integer> percent
                = employee -> (int) employee.getSalary() + ((employee.getSalary()/100) * PERCENT);

        //3) Tillegg for ansatt med lav lønn
        Function<Employee , Integer> low_salary_compensation
                = employee -> employee.getSalary() <= LOW_SALARY ? employee.getSalary()+ INCREASE_LOW_SALARY : employee.getSalary();

        //4) Prosent tillegg for mann
        Function<Employee, Integer> maleSalaryIncrease
                = employee -> employee.isMale() ? (int) (employee.getSalary()+ (employee.getSalary()/100) * IS_MALE) : employee.getSalary();



        System.out.println("Before changes: " + "\n" + employees + "\n");
        salaryAdjustments(employees, recurring_addition);
        System.out.println("After recurring benefits: " + "\n" + employees + "\n");
        salaryAdjustments(employees, percent);
        System.out.println("After percentage increase: " + "\n" + employees + "\n");
        salaryAdjustments(employees, low_salary_compensation);
        System.out.println("Increasing salary for lowest salary: " + "\n" + employees + "\n");
        salaryAdjustments(employees, maleSalaryIncrease);
        System.out.println("Increasing salary for males: " + "\n" + employees + "\n");



    }
    private static void salaryAdjustments(List<Employee> employees, Function<Employee, Integer> salary) {

        employees.forEach(employee -> employee.setSalary(salary.apply(employee)));
    }
}




