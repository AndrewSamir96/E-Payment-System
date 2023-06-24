package com.softwareArch.ePayment.BusinessLogic;

public class CheckDiscounts
{  // this part is responsible for viewing discounts for different services for the user
    public String ViewDiscounts(int choice)
    {
        DiscountAdder specificDiscount = new SpecificDiscount();
        DiscountAdder overAllDiscount = new OverAllDiscount();
        if (choice == 5)
        {
            return overAllDiscount.getDiscount(choice);
        }
        return specificDiscount.getDiscount(choice);

    }

}
