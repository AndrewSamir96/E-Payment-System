package com.softwareArch.ePayment.BusinessLogic;

public class Search
{
    public String searching (String sname) // this part responsible for  searching for services by name
    {
        IService x;

        if(sname.equals("mobileservices")) // this part displays mobile services and executes it
        {
                x = new MobileServices();
                return x.PrintServiceProvider();

        }
        else if(sname.equals("internetservices")) // this part displays internet services and executes it
        {
                x = new InternetServices();
                return x.PrintServiceProvider();

        }
        else if (sname.equals("landlineservices")) // this part displays landline services and executes it
        {
                x = new LandlineServices();
                return x.PrintServiceProvider();

        }
        else if (sname.equals("donations")) // this part displays donations services and executes it 
        {
                x = new DonationServices();
                return x.PrintServiceProvider();

        }
        return "service not found in database";
    }
}

