package com.softwareArch.ePayment.Entities;

import com.softwareArch.ePayment.BusinessLogic.IPaying;

public class CreditCard implements IPaying {
    //this is the option for credit card way of payment
    @Override
    public boolean payment(Users u, String CardNo, String AmountToPay)
    {
        u.setCardNumber(CardNo);
        return true;
    }
}
