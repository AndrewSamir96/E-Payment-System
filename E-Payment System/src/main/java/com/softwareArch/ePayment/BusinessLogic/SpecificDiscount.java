package com.softwareArch.ePayment.BusinessLogic;

public class SpecificDiscount implements DiscountAdder{
    // this part initiates specific discounts for all services
    static public float MOBILE_SERVICE_DISCOUNT =0, INTERNET_DISCOUNT =0, LANDLINE_DISCOUNT =0, DONATION_DISCOUNT =0;

    @Override
    public String Discounting(int choice, String Amount) // this part is responsible for applying discounts to all services
    {

        if(choice == 1)  // this part applies discount to mobile service
        {
            if(MOBILE_SERVICE_DISCOUNT == 100)
            {return "0";}
            else
            {return Float.toString(Float.parseFloat(Amount)*(1- MOBILE_SERVICE_DISCOUNT /100));}
        }
        else if(choice == 2) // this part applies discount to internet service
        {
            if(INTERNET_DISCOUNT == 100)
            {return "0";}
            else
            {return Float.toString(Float.parseFloat(Amount)*(1- INTERNET_DISCOUNT /100));}

        }
        else if(choice == 3) // this part applies discount to landline service
        {
            if(LANDLINE_DISCOUNT == 100)
            {return "0";}
            else
            {return Float.toString(Float.parseFloat(Amount)*(1- LANDLINE_DISCOUNT /100));}

        }
        else if(choice == 4) // this part applies discount to donations
        {
            if(DONATION_DISCOUNT == 100)
            {return "0";}
            else
            {return Float.toString(Float.parseFloat(Amount)*(1- DONATION_DISCOUNT /100));}

        }
        return null;
    }

    @Override // this part displays discounts
    public String getDiscount(int choice) {
        if(choice == 1)
        {
            return MOBILE_SERVICE_DISCOUNT + "%";
        }
        else if(choice == 2)
        {
            return INTERNET_DISCOUNT + "%";

        }
        else if(choice == 3)
        {
            return LANDLINE_DISCOUNT + "%";

        }
        else if(choice == 4)
        {
            return DONATION_DISCOUNT + "%";

        }
        return null;
    }



    @Override
    public String SetDiscount(float mobileServiceDiscount,float internetDiscount,float landlineDiscount, float donationDiscount,int choice)
    {
        if(choice == 1){
            MOBILE_SERVICE_DISCOUNT = mobileServiceDiscount;}
        if(choice == 2){
            INTERNET_DISCOUNT = internetDiscount;}
        if(choice == 3){
            LANDLINE_DISCOUNT = landlineDiscount;}
        if(choice == 4){
            DONATION_DISCOUNT = donationDiscount;}
        return "Discount Added Successfully";
    }

}
