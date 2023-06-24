package com.softwareArch.ePayment.BusinessLogic;

//this interface is responsible for managing specific and overall discounts
public interface DiscountAdder
{
    public String Discounting(int choice,String Amount);
    public String SetDiscount(float varyingDiscount,float internetDiscount,float landlineDiscount, float donationDiscount,int choice);
    public String getDiscount(int choice);
}
