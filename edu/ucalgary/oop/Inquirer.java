package edu.ucalgary.oop;

public class Inquirer {
    private String firstName;
    private String lastName;
    private String info;
    private String servicesPhoneNum;

    public Inquirer(String firstName, String lastName, String servicesPhoneNum, String info){
        this.firstName = firstName;
        this.lastName = lastName;
        this.servicesPhoneNum = servicesPhoneNum;
        this.info = info;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getServicesPhoneNum()
    {
        return servicesPhoneNum;
    }

    public String info()
    {
        return info;
    }

    
}
