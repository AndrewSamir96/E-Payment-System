package com.softwareArch.ePayment.APIs;
import com.softwareArch.ePayment.BusinessLogic.*;
import org.springframework.web.bind.annotation.*;

//these are the web services that the User uses
@RestController
public class OperationController {

    Search s = new Search();
    CheckDiscounts c = new CheckDiscounts();
    Refund r = new Refund();
    WalletManagement w = new WalletManagement();
    Pay p = new Pay();

    //this web service will allow the user to pay Mobile fees to the desired service provider,
    //the amount to pay, the way of payment, and the credit card number
    @PostMapping(value = "/users/pay/mobile")
    public String payMobile(@RequestParam int choice,String amount ,int sp,String ccn)
    {
        return p.payMobile(choice,amount,sp,ccn);
    }

    //this web service will allow the user to pay Internet fees to the desired service provider,
    //the amount to pay, the way of payment, and the credit card number
    @PostMapping(value = "/users/pay/internet")
    public String payInternet(@RequestParam int choice,String amount ,int sp,String ccn)
    {
        return p.PayInternet(choice,amount,sp,ccn);
    }

    //this web service will allow the user to pay Donations to the desired charity,
    //the amount to pay, the way of payment, and the credit card number
    @PostMapping(value = "/users/pay/donation")
    public String payDonation(@RequestParam int choice,String amount ,int sp,String ccn)
    {
        return p.payDonation(choice,amount,sp,ccn);
    }

    //this web service will allow the user to pay Landline fees to the desired service provider,
    //the amount to pay, the way of payment, and the credit card number
    @PostMapping(value = "/users/pay/landline")
    public String payLandline(@RequestParam int choice,String amount ,int sp,String ccn)
    {
        return p.payLandline(choice,amount,sp,ccn);
    }

    //this web service will allow the user to apply a request to refund a specific transaction
    @PostMapping(value = "/users/refundRequest")
    public String refundRequest(@RequestParam int choice)
    {
        return r.RefundRequest(choice);
    }

    //this web service will allow the user to add funds to his wallet
    @PostMapping(value = "/users/addCash")
    public String addCash(@RequestParam String cnum,int cash)
    {
        return w.addCash(cnum,cash);
    }


    //this will show the specific or overall Discounts that are currently applied
    @GetMapping(value = "/users/showDiscount/{choice}")
    public String ViewDiscounts(@PathVariable ("choice") int choice)
    {
        return c.ViewDiscounts(choice);
    }
    //this will print all the available transactions that you can refund and their indices  and shows if they're refunded or not
    @GetMapping(value = "/users/showRefunds")
    public String showRefunds()
    {
        return r.ShowRefunds();
    }

    //this web service will let the user print the options of the desired choice
    @GetMapping(value = "/users/search/{searching}")
    public String SearchFunction(@PathVariable ("searching") String searching)
    {
        return s.searching(searching);
    }

    //this will show the current balance in the wallet
    @GetMapping(value = "/users/showWallet")
    public float walletPrint()
    {
        return w.walletPrint();
    }
}
