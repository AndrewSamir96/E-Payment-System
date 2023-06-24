package com.softwareArch.ePayment.BusinessLogic;

import com.softwareArch.ePayment.Entities.Users;

//this class manages the wallet payment in the Payment of services
public class WalletPayment implements IPaying
{
    @Override
    public boolean payment(Users u, String CardNo, String AmountToPay)
    {
        return u.wallet.deduct(Float.parseFloat(AmountToPay));
    }
}
