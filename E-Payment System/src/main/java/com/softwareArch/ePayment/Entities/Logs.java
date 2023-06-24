package com.softwareArch.ePayment.Entities;

public class Logs
{ // this part creates logs for the users to keep track of their transactions
    public String [] log  = new String [100];
    public float [] amount = new float [100];
    public boolean [] refunded = new boolean[100];
    public int LogCounter = 0;


    public void logger(String k, float a) // this part writes the transactions of each user to their logs
    {
        if(LogCounter <100)
        {
            log [LogCounter] = k;
            amount[LogCounter] = a;
            refunded[LogCounter] = false;
            LogCounter++;
        }
        else
        {
            System.out.println("Logs are full");
        }
    }
}
