package com.softwareArch.ePayment;
import com.softwareArch.ePayment.BusinessLogic.RefundReply;
import com.softwareArch.ePayment.Entities.Users;
import org.springframework.stereotype.Service;
@Service
public class Startup // this part is responsible for creating users
{
    public static Users currentUser = new Users();
    static Users[] u = new Users[100];
    static int COUNTER = 1;
    public void InitializeUsers()
    {
        RefundReply k = new RefundReply();
        for (int i = 1; i < 100; i++)
        {
            u[i] = new Users();
        }
        for (int i = 0; i < 100; i++)
        {
            k.Requestee[i] = new Users();
        }
    }
    public String SignInChecker(Users tempk) // this part checks for mail and password
    {
        for (int i = 1;i < 100; i++)
        {
            if(u[i].Email.equals(tempk.Email) && u[i].Password.equals(tempk.Password))
            {
                currentUser = u[i];
                return currentUser.Username +" signed in successfully";
            }
        }
        return "User not found";
    }
    public String checkUser(String email) // this part checks for mail and password
    {
        String k;
        for (int i = 1;i < 100; i++)
        {
            if(u[i].Email.equals(email))
            {
                k= "Email: " +  u[i].Email +"\n" + "Username: " + u[i].Username;
                return k;
            }
        }
        return null;
    }
    public String SignUpChecker(Users temp)
    {

        boolean flag = true;
        for (int i = 1;i < 100; i++)
        {
            if(u[i].Email.equals(temp.Email))
            {
                flag = false;
            }

        }
        if (flag)
        {
            u[COUNTER].setUser(temp);
            COUNTER++;
            return "User Created";
        }
        else
        {
            return "Email already exists";
        }
    }
}
