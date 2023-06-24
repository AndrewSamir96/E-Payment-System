package com.softwareArch.ePayment.BusinessLogic;

import com.softwareArch.ePayment.Entities.CreditCard;
import com.softwareArch.ePayment.Startup;

public class DonationServices implements IService
{
    @Override
    public String Execute(int WoP ,String Amount ,int serviceProvider ,String CreditCardNo)//WoP: way of payment
    {
        float donation=Float.parseFloat(Amount);
        Startup s = new Startup();
        IPaying p;
        String NoS; //name of service
        NoS = ChooseServiceProvider(serviceProvider);
        switch (WoP)
        {
            case 1:
            {
                p = new WalletPayment();
                //this will calculate the overall and the specific discounts
                donation = Float.parseFloat(AddDiscount(Float.toString(donation)));
                if (p.payment(s.currentUser,null,Float.toString(donation)))
                {
                    //this will log the user's transaction in the log form
                    s.currentUser.l.logger(" Donation to "  + NoS + " Amount: "+ donation + " " + "L.E",donation);
                    return "Transaction Completed Successfully";
                }
                else
                {
                    return "insufficient funds";
                }

            }
            case 2:
                // this part prompts the credit card form for the user
            {
                p = new CreditCard();
                donation = Float.parseFloat(AddDiscount(Float.toString(donation)));

                p.payment(s.currentUser,CreditCardNo,Float.toString(donation));
                //this will log the user's transaction in the log form
                s.currentUser.l.logger("Donation To "+NoS+ "Credit Card: "+ s.currentUser.CardNumber + " Amount: "+ donation + " " + "L.E",donation);
                return "Transaction Completed Successfully";

            }
            case 3: // this part prompts the cash on delivery receipt for the user
            {
                p = new CashOnDelivery();
                donation = Integer.parseInt(AddDiscount(Float.toString(donation)));
                p.payment(s.currentUser,null,Float.toString(donation));
                //this will log the user's transaction in the log form
                s.currentUser.l.logger("Donation to " +NoS+ " Amount: "+ donation + " " + "L.E",donation);
                return "Transaction Completed Successfully";
            }
        }
        return "Transaction Failed";
    }

    public String PrintServiceProvider()  //prints the service providers for the user
    {
        return("Donation Services: \n" +
                "1- Cancer Hospitals \n" +
                "2- Schools \n " +
                "3- NGOs (Non-Profitable Organization)\n");
    }

    public String ChooseServiceProvider(int NosChoice) // prompts donation form for the user
    {
        if (NosChoice == 1)
        {
            return "Cancer Hospitals";
        }
        else if (NosChoice == 2)
        {
            return "Schools";
        }
        else if (NosChoice == 3)
        {
            return "NGOs (Non-Profitable Organization";
        }
        return null;
    }

    public String AddDiscount(String amt) //This will apply the discounts on the receipt
    {
        DiscountAdder D = new OverAllDiscount();
        amt = D.Discounting(0,amt);
        DiscountAdder DD = new SpecificDiscount();
        amt = DD.Discounting(4,amt);
        return amt;
    }
}