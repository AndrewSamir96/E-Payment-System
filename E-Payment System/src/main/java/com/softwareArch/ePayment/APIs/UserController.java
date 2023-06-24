package com.softwareArch.ePayment.APIs;
import com.softwareArch.ePayment.Startup;
import com.softwareArch.ePayment.Entities.Users;
import org.springframework.web.bind.annotation.*;


//these are the web services for managing the Current user that uses all the web services
@RestController
public class UserController
{
    public Startup s = new Startup();

    //this web service will let the user create an account
    @PostMapping(value = "/users/signUp")
    public String signUp(@RequestBody Users users)
    {

        return s.SignUpChecker(users);
    }

    //the user will log in with the credentials from the signup process in order to use all the other services
    @PostMapping(value = "/users/signIn")
    public String signIn(@RequestBody Users users)
    {
        return s.SignInChecker(users);
    }

    //this web service will show if the user typed is in the database or not
    @GetMapping(value = "/users/{Email}")
    public String getUser(@PathVariable ("Email") String Email)
    {
        return s.checkUser(Email);
    }
}
