package com.softwareArch.ePayment.BusinessLogic;

public class Pay {
    IService q;
    public String payMobile(int choice,String amount ,int serviceProvider,String ccn)
    {
        q = new MobileServices();
        return q.Execute(choice,amount,serviceProvider,ccn);
    }
    public String PayInternet(int choice,String amount ,int serviceProvider,String ccn)
    {
        q = new InternetServices();
        return q.Execute(choice,amount,serviceProvider,ccn);
    }
    public String payDonation(int choice,String amount ,int serviceProvider,String ccn)
    {
        q = new DonationServices();
        return q.Execute(choice,amount,serviceProvider,ccn);
    }
    public String payLandline(int choice,String amount ,int serviceProvider,String ccn)
    {
        q = new LandlineServices();
        return q.Execute(choice,amount,serviceProvider,ccn);
    }
}
