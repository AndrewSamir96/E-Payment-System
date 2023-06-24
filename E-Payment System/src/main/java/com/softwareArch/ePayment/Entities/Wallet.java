package com.softwareArch.ePayment.Entities;

//each user will have a wallet with 1000 L.E from the start
public class Wallet
{
    float money = 1000;
    //this will add amount to wallet
    public void add(float cash)
    {
        money += cash;
    }
    //this will deduct amount of money from wallet
    public boolean deduct(float cash)
    {
        if(money>cash)
        {
            money -= cash;
            return true;
        }
        else
        {
            return false;
        }

    }
    //this will print the current amount of money in the wallet
    public float PrintMoney()
    {
        return money;
    }
}
