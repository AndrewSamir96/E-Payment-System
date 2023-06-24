package com.softwareArch.ePayment.APIs;
import com.softwareArch.ePayment.BusinessLogic.DiscountAdder;
import com.softwareArch.ePayment.BusinessLogic.OverAllDiscount;
import com.softwareArch.ePayment.BusinessLogic.RefundReply;
import com.softwareArch.ePayment.BusinessLogic.SpecificDiscount;
import org.springframework.web.bind.annotation.*;


// REST web services for our implemented admin options logic
@RestController
public class AdminMenuController
{
    RefundReply refundReply = new RefundReply();
    DiscountAdder specificDiscount = new SpecificDiscount();
    DiscountAdder overAllDiscount = new OverAllDiscount();

    //this web Service will set a specific discount on the mobile Service transactions by the admin
    @PostMapping(value = "/admin/discount/mobile")
    public String MobileServiceSpeDis(@RequestParam int discountSpecific)
    {
        return specificDiscount.SetDiscount(discountSpecific,0,0,0,1);
    }
    //this web Service will set a specific discount on the Internet Service transactions by the admin
    @PostMapping(value = "/admin/discount/Internet")
    public String internetDiscount(@RequestParam int discountSpecific)
    {
        return specificDiscount.SetDiscount(0,discountSpecific,0,0,2);
    }
    //this web Service will set a specific discount on the Landline Service transactions by the admin
    @PostMapping(value = "/admin/discount/Landline")
    public String landlineDiscount(@RequestParam int discountSpecific)
    {
        return  specificDiscount.SetDiscount(0,0,discountSpecific,0,3);
    }
    //this web Service will set a specific discount on the Donation Service transactions by the admin
    @PostMapping(value = "/admin/discount/Donation")
    public String donationDiscount(@RequestParam int discountSpecific)
    {
        return specificDiscount.SetDiscount(0,0,0,discountSpecific,4);
    }
    //this web Service will set the overall discount on all the  transactions by the admin
    @PostMapping(value = "/admin/discount/overall")
    public String overallDiscount(@RequestParam int overallDiscount)
    {
        return overAllDiscount.SetDiscount(overallDiscount,0,0,0,0);
    }
    //this web Service will print the current refund requests available for the admin with the indices
    @PostMapping(value = "/admin/requestReply")
    public String requestReply(@RequestParam int choice, int index)
    {
        return refundReply.RequestResponse(choice,index);
    }


    //this web Service will allow the admin to authorize or deny on the specified index entered
    @GetMapping(value = "/admin/printRequest")
    public String getRefundRequests()
    {
        return refundReply.RequestPrint();
    }

}