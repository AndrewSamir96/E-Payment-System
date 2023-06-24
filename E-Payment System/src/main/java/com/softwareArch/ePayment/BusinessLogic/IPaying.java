package com.softwareArch.ePayment.BusinessLogic;

import com.softwareArch.ePayment.Entities.Users;

public interface IPaying
{ // this interface manages the different ways of payment
    public boolean payment(Users u, String CardNo, String AmountToPay);
}
