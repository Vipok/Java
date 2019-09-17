package Serialization;

import java.io.Serializable;

public class Employee implements Serializable {

    private String id;
    private String firstName;
    private String lastName;

    //Getters and setters

     Employee(String id, String firstName, String lastName) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }
}

