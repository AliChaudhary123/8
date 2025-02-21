package edu.ucalgary.oop;

public class Inquirer {
    private final String firstName;
    private final String lastName;
    private final String info;
    private final String servicesPhone;

    public Inquirer(String firstName, String lastName, String servicesPhone, String info){
        this.firstName = firstName;
        this.lastName = lastName;
        this.servicesPhone = servicesPhone;
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
        return servicesPhone;
    }

    public String getInfo()
    {
        return info;
    }

    
}
