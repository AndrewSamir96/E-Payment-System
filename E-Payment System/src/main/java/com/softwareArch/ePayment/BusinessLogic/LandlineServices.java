package com.softwareArch.ePayment.BusinessLogic;

import com.softwareArch.ePayment.Startup;

public class LandlineServices implements IService
{
    float receipt =100; // this part executes the landline services options
    @Override
    public String Execute(int WoP ,String Amount ,int serviceProvider ,String CreditCardNo) //WoP: way of payment
    {
        return ChooseServiceProvider(serviceProvider);
    }

    public String PrintServiceProvider() // this displays the options of paying the landline fees
    {
        return("Landline Services: \n" +
                "1-Monthly receipt \n" +
                "2-Quarterly receipt\n" +
                "3-Exit \n" +
                "Choice: ");
    }

    public String ChooseServiceProvider(int choice) // this menu manages the payment form for landline services
    {
        Startup s = new Startup();
        receipt = Float.parseFloat(AddDiscount(Float.toString(receipt)));
        if (choice == 1)
        {
            return"For User: "+s.currentUser.Username +" Your monthly payment = "+ receipt + " L.E";
        }
        else if (choice == 2)
        {
            return"For User: "+s.currentUser.Username +" Your quarterly payment = "+ receipt*3 + " L.E";
        }
        return null;
    }
    public String AddDiscount(String k) // this part adds discounts to the landline fees
    {
        DiscountAdder overAllDiscount = new OverAllDiscount();
        receipt = Float.parseFloat(overAllDiscount.Discounting(0,Float.toString(receipt)));
        DiscountAdder specificDiscount = new SpecificDiscount();
        receipt = Float.parseFloat(specificDiscount.Discounting(3,Float.toString(receipt)));
        return Float.toString(receipt);
    }
}
