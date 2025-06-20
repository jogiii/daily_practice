package com.immutable;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;


//How to make a class immutable

//1) Make the class final so it can't be subclassed
//2) Make all the fields private and final
//3) Don't provide setters
//4) Initialize all fields via constructor
//5) perform deep copies for mutable objects
//6) Return copes of mutable fields instead of references in getter

public final class Person {

    private final String name;
    private final Date date;
    private final HashMap<String, String> map;


    public Person(String name, Date date, Map<String, String> map){
        this.name = name;
        this.date = new Date(date.getTime());
        this.map = new HashMap<>(map);
    }


    public String getName() {
        return name;
    }


    public Date getDate() {
        return new Date(date.getTime());
    }


    public HashMap<String, String> getMap() {
        return new HashMap<>(map);
    }
    


    public String toString(){
        return "Person{" +
                "name='" + name + '\'' +
                ", birthDate=" + date +
                ", preferences=" + map +
                '}';
    }



    public static void main(String[] args) {
        String name = "Joginder";
        Date date = new Date();

        Map<String, String> map = new HashMap<>();
        map.put("joginder", "kumar");

        Person p = new Person(name, date, map);

        System.out.println("person initally "+p);

        date.setTime(0);
        map.put("name", "name");

        var pp =p.getMap();
        pp.put("test", "test");


        System.out.println("After change "+p);

    }



}
