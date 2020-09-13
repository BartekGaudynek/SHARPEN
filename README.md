SHARPEN is simple online store with weapons.
It is one of projects I have prepared during my Java Programming course.

---------------------------------------------------------------------------------------------------------------
SHARPEN contains following functionalities:

1. PRODUCTS
In store, there are displayed products divided into categories and subcategories.
On product and product subcategory level there is an option to add product to basket.

2. SHOPPING
As written above, SHARPEN offers adding products to basket as a part of purchasing process.
The process itself contains few steps: basket, getting client data to delivery, choosing delivery
and payment option and finally, displaying shopping summary.
User has possibility to check his/her shopping basket, where all added products are stored and displayed.
In addtion, products can be removed from basket. In next step, login status is verified. If user is logged in,
personal data are taken from account and added to purchase details as delivery information about customer.
If not, user needs to log in to account, to continue purchasing process.
Next step is choosing delivery and payment option. Last step is displaying purchase summary, containing
information about products, delivery, payment and total price.

3. USER ACCOUNT
Any SHARPEN visitor can create account, enabling to purchase products from store.
Basically, there is registration form with mandatory data to be filled in. Those data are used as delivery details
and as unique account identification. On form level there are some conditions helping to ensure that entered data
are correct. Moreover, it is also checked if account using entered e-mail exist in account database and if so, 
declines account creation. 
Created account is stored in database, as well as personal information about user.

Next part is login site. If user tries to use incorrect login data, apropriate message will be displayed.
Succesful login attempt redirects user to account panel or next step of shopping process (if done after accepting
basket content).

---------------------------------------------------------------------------------------------------------------
BEFORE YOU RUN APPLICATION, IT IS REQUIRED TO CREATE DATABASE.
In project there is a file dbQuerySet, contating all queries required to create database and test data in it.
It is also required to update existing objects from newConnection class. Its constructors enable to create database
connection with any database URL and assigned user and password. 

