package com.softwareArch.ePayment.BusinessLogic;

public class OverAllDiscount implements DiscountAdder
{  // this part manages the overall discount in the different services
    static public float OVERALL_DISCOUNT;

    public String SetDiscount(float varyingDiscount,float internetDiscount,float landlineDiscount, float donationDiscount,int choice)
    {
        this.OVERALL_DISCOUNT = varyingDiscount;
        return "Discount Added Successfully";
    }

    @Override
    public String Discounting(int choice, String Amount) //responsible for calculating discount
    {
        float temp = Float.parseFloat(Amount);
        temp = temp * (1- OVERALL_DISCOUNT /100);
        return Float.toString(temp);

    }
    @Override
    public String getDiscount(int choice)
    {
        return Float.toString(OVERALL_DISCOUNT);
    }

}
