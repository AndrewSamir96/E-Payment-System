package com.softwareArch.ePayment.BusinessLogic;

import com.softwareArch.ePayment.Entities.Users;

public class CashOnDelivery implements IPaying {
    //this is the option for cash on delivery way of payment
    @Override
    public boolean payment(Users u, String CardNo, String AmountToPay)
    {
        return true;
    }
}
