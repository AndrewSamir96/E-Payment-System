package com.softwareArch.ePayment.BusinessLogic;

import com.softwareArch.ePayment.Entities.Users;

public class RefundReply
{  // this part responsible for accessing transactions in the users' logs
    static  String [] Request =  new String [100];
    static int [] index = new int[100];
    static public Users[] Requestee = new Users[100];
    static int REFUND_COUNTER = 0;


    public void TakeRefunds(Users u, String l, int index) // this part manages refund requests
    {
        Request [REFUND_COUNTER] = l;
        Requestee [REFUND_COUNTER] = u;
        RefundReply.index[REFUND_COUNTER] = index;
        REFUND_COUNTER++;
    }

    public String RequestPrint()
    {
        String temp=" ";
        if(REFUND_COUNTER ==0)
        {
            return "No requests";
        }
        for (int i = 0; i < REFUND_COUNTER; i++) {
            temp += i +"-"+ Requestee[i].Username + " " + Request[i] + "\n";
        }
        return temp;

    }
    public String RequestResponse(int choice,int requestIndex) // this part is accessed by the admin to accept or deny the refund requests
    {
            if (choice == 1 && requestIndex < REFUND_COUNTER)
            {
                Requestee[requestIndex].wallet.add(Requestee[requestIndex].l.amount[index[requestIndex]]);
                REFUND_COUNTER = 0;
                return Requestee[requestIndex].Username  + " has been refunded " + Requestee[requestIndex].l.amount[index[requestIndex]]+" L.E";

            }
            else if (choice == 2)
            {
                return "Refund Denied";
            }


         return "invalid choice";
    }
}
