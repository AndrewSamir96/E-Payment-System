package com.softwareArch.ePayment.BusinessLogic;


import com.softwareArch.ePayment.Entities.CreditCard;
import com.softwareArch.ePayment.Startup;

public class MobileServices implements IService
{
    // this part executes the way fo payment of mobile recharge service
    @Override
    public String Execute(int WoP ,String Amount ,int serviceProvider ,String CreditCardNo) //WoP: way of payment
    {
        Startup s = new Startup();
        IPaying P;
        String NoS; // name of service
        NoS = ChooseServiceProvider(serviceProvider);
        switch(WoP)
        {
            case 1:
            {
                P = new WalletPayment();
                Amount = AddDiscount(Amount);
                if(P.payment(s.currentUser,null,Amount))
                {
                    s.currentUser.l.logger(NoS +" " + "Wallet Payment" + " Amount: "+ Amount + " " + "L.E",Float.parseFloat(Amount));
                    return "Transaction Completed Successfully";
                }
                else
                {
                    return "insufficient funds";
                }
            }
            case 2:
            {
                P = new CreditCard();
                Amount = AddDiscount(Amount);

                P.payment(s.currentUser,CreditCardNo,Amount);
                s.currentUser.l.logger(NoS +" " + "Credit Card: " + s.currentUser.CardNumber + " Amount: "+ Amount + " " + "L.E",Integer.parseInt(Amount));
                return "Transaction Completed Successfully";
            }
            case 3:
            {
                P = new CashOnDelivery();
                Amount = AddDiscount(Amount);
                P.payment(s.currentUser,null,Amount);
                s.currentUser.l.logger(NoS +" " + "Cash On Delivery" + " Amount: "+ Amount + " " + "L.E",Integer.parseInt(Amount));
                return "Transaction Completed Successfully";
            }

        }
        return "Transaction failed";
    }


    @Override
    public String ChooseServiceProvider(int NosChoice) // this part manages mobile recharge service providers
    {
        if (NosChoice == 1)
        {
            return "Vodafone";
        }
        else if (NosChoice == 2)
        {
            return "Etisalat";
        }
        else if (NosChoice == 3)
        {
            return "Orange";
        }
        else if (NosChoice == 4)
        {
            return "WE";
        }
        return null;
    }

    public String PrintServiceProvider() // prints service providers for the user
    {
        return (
                "Mobile recharge services: \n"+
                        "1-Vodafone \n" +
                        "2-Etisalat\n" +
                        "3-Orange\n" +
                        "4-We"
                );
    }
    @Override
    public String AddDiscount(String amount) // applies discount for the mobile recharge service
    {
        DiscountAdder overAllDiscount = new OverAllDiscount();
        amount =  overAllDiscount.Discounting(0,amount);
        SpecificDiscount specificDiscount = new SpecificDiscount();
        amount = specificDiscount.Discounting(1,amount);
        return amount;
    }
}
