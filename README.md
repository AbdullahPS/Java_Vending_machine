# Java_Vending_machine
A simple vending machine implementation using Java language
To let the machine support more Items or/and edit prices and items do it in __Mockdata/Items.java__.
To initialize the items which are currenttly in the machine add them into the array of Items in __Mockdata/InitialProducts.java__.
To fill the coins and notes in the machine do it in the arra mockcoins and mocknotes __Mockdata/InitialProducts.java__.

The keypad only supoprts Numbers from (0 to 9 ) and caracters from (A-E) a "cancel" string and "delete" everything else will be simply ignored from the keyboard.
(0-9): Enters these numbers on the keypad and displays them on screen
(A-E): Enters these caracters on the keypad and displays them on screen
"delete":Clears the last digit from the screen
"clear":clears the whole value on the screen
"cancel":Exits the screen, deletes the values and brings you back to the main screen 

How to use it :
When Starting the Application following will be printed on the console:

***
Please Choose what do you want to do 


1. look at items 
2. insert Card
3. put money
4. Select Items
5. Exit
***
**When you press 1 you get a table of all the supported Items it Ids and it prices:!!


1A	AliBaba     0.4$  ||   1B	Bisley      0.5$  ||   1C	Bueno       1.0$  ||   1D	Cheetos     3.0$  ||   1E	Corny       1.0$  ||   
---------------------------------------------------------------------------------------------------------------------------------------------------------
2A	DailyMilk   1.0$  ||   2B	Doritos     2.4$  ||   2C	Fritos      2.0$  ||   2D	Hanuta      4.0$  ||   2E	Haribo      2.0$  ||   
---------------------------------------------------------------------------------------------------------------------------------------------------------
3A	Hohos       1.0$  ||   3B	Karnoosh    0.5$  ||   3C	KitKat      2.0$  ||   3D	Lay         2.3$  ||   3E	Mars        2.0$  ||   
---------------------------------------------------------------------------------------------------------------------------------------------------------
4A	MilkaDark   3.0$  ||   4B	MilkaWhite  2.0$  ||   4C	MnM         2.5$  ||   4D	Neo         1.0$  ||   4E	Nutella     5.0$  ||   
---------------------------------------------------------------------------------------------------------------------------------------------------------
5A	Oreo        1.0$  ||   5B	Pringles    4.0$  ||   5C	Snickers    2.0$  ||   5D	Toffifee    4.0$  ||   5E	Twix        2.0$  ||   
---------------------------------------------------------------------------------------------------------------------------------------------------------

The machine supports 25 items. 

When pressing 2 before selecting an item you get the message 
(Please select an item first)
If an item was selected 
A message will be displayed to enter the pincode. The keypad here accepts 4 values. After the user enters 4 values the pincode is checked.
If it is true the balance of the card is checked. 
If the selected value can be bought the amount is withdrawn from the account of the user.
If not an exception is thrown that there is no sufficient credit in the users account.

If not the user can enter the value again. Also the bank here reports one wrong attempt. On three wrong attempts the card will be blocked.


When pressing 3 before selecting an item you get the message 
(Please select an item first)
If an item was selected the user can enter coins. Following coiis are supported : 

Please Choose what do you want to insert 
1. 10 Cent Coin 
2. 20 Cent Coin 
3. 50 Cent Coin 
4. 1 Dollar Coin 
5. 20 Dollar Note 
6. 50 Dollar Note 
7. Cancel and get money back

Here every choice of the user get saved in the bucket. Once the bucket value can buy the item the payment is done. IF the user selects 7 the monet will be brought back to him. 

When pressing 4 The application will ask you to enter the Item ID which can be retrieved from the table on choice 1. 
A scanner will be opened asking you to enter the IDs on the keypad. 
Based on the keypad input which keys are explained above the machine here accepts two Digits.
When the Id matches any item the machine checks if the Item is not out of stock, if it is an sception is thrown that the item is not available and the user can edit his choice.


If it is available He gets shown the price of the item on the screen adn the item gets selected.
4B
MilkaWhite
2.0$

If it is out of stock an exception is thrwos and displayed to the user and he can edit the choice
Exception occuredExceptions.ItemOutOfStockException: Item MilkaWhite is out of stock


When the Id does not match any Item and Exception is thrown that the item does not exist, the display shows the value again and the user can edit it.

Exception occuredExceptions.ItemNotSupportedException: bro, we dont sell item B9



When pressing 5 the application exits.
When pressing 

UML Diagam:
![VendingMachine UMLpng](https://user-images.githubusercontent.com/59699889/174459128-62dd5051-eac4-4c8a-823a-de7fcce5c431.png)
