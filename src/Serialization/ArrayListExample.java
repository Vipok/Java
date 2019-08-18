package Serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ArrayListExample
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee("1", "lokesh", "gupta"));
        employees.add(new Employee("2", "brian", "motto"));

        try
        {
            FileOutputStream fos = new FileOutputStream("employeeData");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(employees);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
}