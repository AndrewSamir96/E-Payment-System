package com.softwareArch.ePayment.Entities;

public class Users
{
    // this part initiates user account and wallet
    public String Username,Email,Password;
    public Wallet wallet = new Wallet();
    public Logs l = new Logs();
    public String CardNumber;
    public Users() // this part is the constructor giving initial value to its attributes
    {

        Username ="ljkshadflkjhasfdglkjhasdfg";
        Email = "ljkshadflkjhasfdglkjhasdfg";
        Password = "ljkshadflkjhasfdglkjhasdfg";
    }
    public Users(String username, String email, String password) {
        Username = username;
        Email = email;
        Password = password;
    }
    public String setUser(Users k)
    {
        // setter for user attributes
        Username = k.Username;
        Email = k.Email;
        Password = k.Password;
        return "Added Successfully";
    }
    public void setCardNumber(String cardNumber)
    {
        CardNumber = cardNumber;
    } // setter for cardNumber
}
