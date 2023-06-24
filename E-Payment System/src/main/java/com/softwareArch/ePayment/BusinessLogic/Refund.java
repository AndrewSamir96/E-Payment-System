package com.softwareArch.ePayment.BusinessLogic;

import com.softwareArch.ePayment.Startup;

public class Refund
{
    public String ShowRefunds()
    {
        Startup k = new Startup();

        String q =" ",pp = "";
        for (int i = 0 ; i<k.currentUser.l.LogCounter; i++)
        {
            if(k.currentUser.l.refunded[i])
            {
                q ="requested";
            }
            //this is what should be returned
            pp += i + "-" + k.currentUser.l.log[i] +" "+ q + "\n";
            q = " ";
        }
        return pp;
    }
    public String RefundRequest(int choice) // this part reviews the refund requests of the user
    {
        RefundReply r = new RefundReply();
        Startup k = new Startup();
        if (k.currentUser.l.refunded[choice])
        {
            return"request already denied";
        }
        else if(choice<k.currentUser.l.LogCounter)
        {
            r.TakeRefunds(k.currentUser,k.currentUser.l.log[choice],choice);
            k.currentUser.l.refunded[choice] = true;
            return"Refund request sent";
        }
        return "request failed";
    }
}

