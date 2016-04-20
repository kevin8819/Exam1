I made a class representing a single data item. Each data item has a String item which represents the item's name, an int for quantity, a double for the price, and a String for the location.

There is a default constructor, a constructor with parameters, and a copy constructor. Then all the appropriate getters and setters for the data variables.

The MyApplication is where I wrote the majority of the program. The main presents a menu asking a user to select an option to input data, sort data, search data, edit data, display data, or exit. Based on user choice the appropriate method is called passing in the ArrayList that holds all the DataItems.

I had problems when using the Scanner to be switching back and forth between using .nextInt() and nextLine(), so I simply resolved to always use nextLine() and use the Integer.parseInt() method to convert to the correct data type.

If I were to develop this application further I would definitely split up the large static methods in MyApplication and probably make a utility class. The util class would itself contain an ArrayList of DataItem's and have methods for processing them. This way I could keep the main as a much shorter and more isolated file.

There is some data validation, if a user enters a 7 on the main menu it will report invalid input and let them retry, but the program will generate an exception if they enter a String. It could be further developed to include custom exceptions and/or the use of try/catch blocks.