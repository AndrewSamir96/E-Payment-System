# E-Payment-System
Simulated E-Payment-System using APIs for a college assignment

# Project Description
- This project uses REST APIs developed in Java using Spring Initializr which are tested using postman API platform. 
- This project is a simulation for an online payment system that helps in paying online bills of several services such as mobile services, internet services etc.
- This project uses 3 different design patterns while trying to apply the SOLID principles:
  - The first design pattern we applied in our class diagram is the decorator design pattern, using the interface “Discount Adder” as the interface and “Overall discount”, “Specific discount” as the concrete decorators applied to the different services we have in our system.
  - The second design pattern applied is the Strategy pattern, using the “I Paying” interface to manage the different ways of payment chosen by the user for the different services present in the system. “Cash on delivery”, “Credit Card”, “Wallet Payment” are the classes used for representing the different payment method for the services.
  - The Third design pattern we applied is the abstract factory method, with the “Services” interface as the one managing the relation between all the actions the user of the system might use and all the services provided by the system to the user “Pay”, “Check discounts”, “Refund”, “Search” are the actions that could be chosen to be operated by the user on the different services which are “Internet Services”, ”Landline Services”, “Mobile Recharge Service”, “Donations”.
- As well as adding New web services to interact with the system they were divided into UserController, AdminMenuController, MenuController and operationController these web services provide a way to access all of the systems functions to be used.
