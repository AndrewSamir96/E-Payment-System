package com.softwareArch.ePayment.BusinessLogic;

public interface IService
{ // this interface manages applying different actions to the services provided by the system
  public String Execute(int WoP ,String Amount ,int serviceProvider ,String CreditCardNo);
  public String PrintServiceProvider();
  public String ChooseServiceProvider(int sp);
  public String AddDiscount(String k);

}

