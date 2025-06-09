package com.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Employee {
    int id;

    String name;

    int age;

    String gender;

    String department;

    int yearOfJoining;

    double salary;

    private static List<Employee> employeeList = new ArrayList<Employee>();

    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Id : " + id
                + ", Name : " + name
                + ", age : " + age
                + ", Gender : " + gender
                + ", Department : " + department
                + ", Year Of Joining : " + yearOfJoining
                + ", Salary : " + salary;
    }

    public static void main(String[] args) {

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        // how to collect number of male and females in list

        Map<String, Long> collect = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(collect);

        // print names of all departments in list

        employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

        // average age of males and females

        Map<String, Double> collect2 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println(collect2);

        // highest paid employee

        Employee orElse = employeeList.stream().max(Comparator.comparingDouble(Employee::getSalary)).orElse(null);

        System.out.println(orElse);

        // get the name of all the employees whi joined after 2015

        employeeList.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employee::getName)
                .forEach(System.out::println);

        // count number of employees in each department

        Map<String, Long> collect3 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        Set<Entry<String, Long>> entrySet = collect3.entrySet();

        for (Entry<String, Long> e : entrySet) {
            System.out.println("Key is :" + e.getKey() + " , value is :" + e.getValue());
        }

        // average salary of each department

        Map<String, Double> collect4 = employeeList.stream().collect(
                Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        for (Entry<String, Double> e : collect4.entrySet()) {
            System.out.println("key is :" + e.getKey() + " , value is " + e.getValue());
        }

        // youngest male emplye in product development department

        Optional<Employee> min = employeeList.stream()
                .filter(e -> e.getGender() == "Male" && e.getDepartment() == "Product Development")
                .min(Comparator.comparingInt(Employee::getAge));

        System.out.println("Nmae of the youngest employee :" + min);

        // longest working employee in the organisation

        Optional<Employee> first = employeeList.stream().sorted(Comparator.comparing(Employee::getYearOfJoining))
                .findFirst();

        System.out.println(first.get());

        // how many males and females in sales and marketing team

        Map<String, Long> collect5 = employeeList.stream().filter(e -> e.getDepartment() == "Sales And Marketing")
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        System.out.println(collect5);

        // what is the averag salary of male and femal employees

        Map<String, Double> collect6 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(collect6);
    }

}
