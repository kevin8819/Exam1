import java.util.ArrayList;
import java.util.Scanner;


public class MyApplication 
{		
	public static Scanner keyboard = new Scanner(System.in);	
	
	public static void main(String args[])
	{
		ArrayList<DataItem> userData = new ArrayList<DataItem>();
		int userChoice = 0;
		
		while(userChoice != 6)
		{
			System.out.println("\nWhat would you like to do? (enter a number)" +
					"\n1 - input data" +
					"\n2 - sort data" +
					"\n3 - search data" +
					"\n4 - edit data" +
					"\n5 - display data" +
					"\n6 - exit");
			userChoice = Integer.parseInt(keyboard.nextLine());
			
			if(userChoice == 1)
			{
				inputData(userData);
			}
			else if(userChoice == 2)
			{
				sortData(userData);
			}
			else if(userChoice == 3)
			{
				searchData(userData);
			}
			else if(userChoice == 4)
			{
				editData(userData);
			}
			else if(userChoice == 5)
			{
				displayData(userData);
			}
			else if(userChoice != 6)
			{
				System.out.println("Invalid input, try again.");
			}
			else
			{
				System.out.println("Goodbye.");
			}
		}
		
		keyboard.close();
	}
	
	/**
	 * gets user input data and puts it in the arraylist
	 * @param userData the arraylist used to store the data
	 */
	public static void inputData(ArrayList<DataItem> userData)
	{
		//let user input data into the arraylist
		String keepGoing = "y";
		
		while(keepGoing.equalsIgnoreCase("y"))
		{
			String tempItem;
			int tempQuantity;
			double tempPrice;
			String tempLocation;
			
			System.out.println("Enter an item name: ");
			tempItem = keyboard.nextLine();
			
			System.out.println("Enter a quantity: ");
			tempQuantity = Integer.parseInt(keyboard.nextLine());
			
			System.out.println("Enter a price: ");
			tempPrice = Double.parseDouble(keyboard.nextLine());
			
			System.out.println("Enter a location: ");
			tempLocation = keyboard.nextLine();
			
			userData.add(new DataItem(tempItem, tempQuantity, tempPrice, tempLocation));
			
			System.out.println("Add another item (y/n)? ");
			keepGoing = keyboard.nextLine();
		}
	}

	/**
	 * sorts the arraylist data based on various user inputs
	 * @param userData the arraylist used to store the data
	 */
	public static void sortData(ArrayList<DataItem> userData)
	{
		int userChoice = 0;
		
		System.out.println("\nSort by what? (enter a number) " +
				"\n1 - item name (alphabetical)" +
				"\n2 - quantity (smallest to largest)" +
				"\n3 - price (lowest to highest)" +
				"\n4 - location (alphabetical)");
		userChoice = Integer.parseInt(keyboard.nextLine());
		
		if(userChoice == 1)
		{
			//sort by item name alphabetically
			for(int j = 0; j < userData.size(); j++)
			{
				for(int i = 0; i < userData.size() - 1; i++)
				{
					if(userData.get(i).getItem().compareTo(userData.get(i + 1).getItem()) > 0)
					{
						DataItem tempApp = new DataItem(userData.get(i));
						
						userData.remove(i);
						userData.add(i + 1, tempApp);
					}
				}
			}
		}
		else if(userChoice == 2)
		{
			//sort quantity small-large
			for(int j = 0; j < userData.size(); j++)
			{
				for(int i = 0; i < userData.size() - 1; i++)
				{
					if(userData.get(i).getQuantity() > userData.get(i + 1).getQuantity())
					{
						DataItem tempApp = new DataItem(userData.get(i));
						
						userData.remove(i);
						userData.add(i + 1, tempApp);
					}
				}
			}
		}
		else if(userChoice == 3)
		{
			//sort price low-high
			for(int j = 0; j < userData.size(); j++)
			{
				for(int i = 0; i < userData.size() - 1; i++)
				{
					if(userData.get(i).getPrice() > userData.get(i + 1).getQuantity())
					{
						DataItem tempApp = new DataItem(userData.get(i));
					
						userData.remove(i);
						userData.add(i + 1, tempApp);
					}
				}
			}
		}
		else if(userChoice == 4)
		{
			//sort location alphabetically
			for(int j = 0; j < userData.size(); j++)
			{
				for(int i = 0; i < userData.size() - 1; i++)
				{
					if(userData.get(i).getLocation().compareTo(userData.get(i + 1).getLocation()) > 0)
					{
						DataItem tempApp = new DataItem(userData.get(i));
						
						userData.remove(i);
						userData.add(i + 1, tempApp);
					}
				}
			}
		}
		else
		{
			System.out.print("Invalid input.");
		}
	}
	
	/**
	 * searches the arraylist for user input
	 * @param userData the arraylist used to store the data
	 */
	public static void searchData(ArrayList<DataItem> userData)
	{
		int userChoice = 0;
		
		System.out.println("\nSearch for what? (enter a number)" +
				"\n1 - item name" +
				"\n2 - quantity" +
				"\n3 - price" +
				"\n4 - location");
		userChoice = Integer.parseInt(keyboard.nextLine());
		
		if(userChoice == 1)
		{
			//search name
			System.out.println("Search for what name? ");
			String searcher = keyboard.nextLine();
			boolean found = false;
			int indexLocation = 0;
			
			for(int i = 0; i < userData.size(); i++)
			{
				if(searcher.equals(userData.get(i).getItem()))
				{
					found = true;
					indexLocation = i;
				}
			}
			
			if(found == true)
			{
				System.out.println(searcher + " was first found at index " + indexLocation);
				System.out.println("Name: " + userData.get(indexLocation).getItem());
				System.out.println("Quantity: " + userData.get(indexLocation).getQuantity());
				System.out.println("Price: " + userData.get(indexLocation).getPrice());
				System.out.println("Location: " + userData.get(indexLocation).getLocation());
			}
			else
			{
				System.out.println("That name was not found");
			}
		}
		else if(userChoice == 2)
		{
			//search quantity
			System.out.println("\nSearch for what quantity? ");
			int searcher = Integer.parseInt(keyboard.nextLine());
			boolean found = false;
			int indexLocation = 0;
			
			for(int i = 0; i < userData.size(); i++)
			{
				if(searcher == userData.get(i).getQuantity())
				{
					found = true;
					indexLocation = i;
				}
			}
			
			if(found == true)
			{
				System.out.println(searcher + " was first found at index " + indexLocation);
				System.out.println("Name: " + userData.get(indexLocation).getItem());
				System.out.println("Quantity: " + userData.get(indexLocation).getQuantity());
				System.out.println("Price: " + userData.get(indexLocation).getPrice());
				System.out.println("Location: " + userData.get(indexLocation).getLocation());
			}
			else
			{
				System.out.println("That quantity was not found");
			}
		}
		else if(userChoice == 3)
		{
			//search price
			System.out.println("\nSearch for what price? ");
			double searcher = Double.parseDouble(keyboard.nextLine());
			boolean found = false;
			int indexLocation = 0;
			
			for(int i = 0; i < userData.size(); i++)
			{
				if(searcher == userData.get(i).getPrice())
				{
					found = true;
					indexLocation = i;
				}
			}
			
			if(found == true)
			{
				System.out.println(searcher + " was first found at index " + indexLocation);
				System.out.println("Name: " + userData.get(indexLocation).getItem());
				System.out.println("Quantity: " + userData.get(indexLocation).getQuantity());
				System.out.println("Price: " + userData.get(indexLocation).getPrice());
				System.out.println("Location: " + userData.get(indexLocation).getLocation());
			}
			else
			{
				System.out.println("That price was not found");
			}
		}
		else if(userChoice == 4)
		{
			//search location
			System.out.println("\nSearch for what location? ");
			String searcher = keyboard.nextLine();
			boolean found = false;
			int indexLocation = 0;
			
			for(int i = 0; i < userData.size(); i++)
			{
				if(searcher.equals(userData.get(i).getLocation()))
				{
					found = true;
					indexLocation = i;
				}
			}
			
			if(found == true)
			{
				System.out.println(searcher + " was first found at index " + indexLocation);
				System.out.println("Name: " + userData.get(indexLocation).getItem());
				System.out.println("Quantity: " + userData.get(indexLocation).getQuantity());
				System.out.println("Price: " + userData.get(indexLocation).getPrice());
				System.out.println("Location: " + userData.get(indexLocation).getLocation());
			}
			else
			{
				System.out.println("That location was not found");
			}
		}
		else
		{
			System.out.println("Invalid input.");
		}
	}
	
	/**
	 * lets the user edit data in the arraylist
	 * @param userData the arraylist used to store the data
	 */
	public static void editData(ArrayList<DataItem> userData)
	{
		int userChoice = 0;
		int index = 0;
		
		System.out.println("\nEdit which item? (enter index number)");
		index = Integer.parseInt(keyboard.nextLine());
		
		System.out.println("\nEdit which data? (enter a number)" +
				"\n1 - item name" +
				"\n2 - quantity" +
				"\n3 - price" +
				"\n4 - location");
		userChoice = Integer.parseInt(keyboard.nextLine());
		
		if(userChoice == 1)
		{
			//edit name
			System.out.println("Enter a new name. ");
			userData.get(index).setItem(keyboard.nextLine());
		}
		else if(userChoice == 2)
		{
			//edit quantity
			System.out.println("Enter a new quantity. ");
			userData.get(index).setQuantity(Integer.parseInt(keyboard.nextLine()));
		}
		else if(userChoice == 3)
		{
			//edit price
			System.out.println("Enter a new price. ");
			userData.get(index).setPrice(Double.parseDouble(keyboard.nextLine()));
		}
		else if(userChoice == 4)
		{
			//edit location
			System.out.println("Enter a new location. ");
			userData.get(index).setLocation(keyboard.nextLine());
		}
		else
		{
			System.out.println("Invalid input.");
		}
	}
	
	/**
	 * displays the data from the arraylist
	 * @param userData the arraylist used to store the data
	 */
	public static void displayData(ArrayList<DataItem> userData)
	{
		int userChoice = 0;
		
		System.out.println("\nDisplay what? (enter a number)" +
				"\n1 - single item's data" +
				"\n2 - all data");
		userChoice = Integer.parseInt(keyboard.nextLine());
		
		if(userChoice == 1)
		{
			//select index
			System.out.println("Which index number to display?");
			int index = Integer.parseInt(keyboard.nextLine());
			
			//display data at index
			System.out.println("\nName: " + userData.get(index).getItem());
			System.out.println("Quantity: " + userData.get(index).getQuantity());
			System.out.println("Price: " + userData.get(index).getPrice());
			System.out.println("Location: " + userData.get(index).getLocation());
		}
		else if(userChoice == 2)
		{
			//display all data
			for(int i = 0; i < userData.size(); i++)
			{
				System.out.println("\nName: " + userData.get(i).getItem());
				System.out.println("Quantity: " + userData.get(i).getQuantity());
				System.out.println("Price: " + userData.get(i).getPrice());
				System.out.println("Location: " + userData.get(i).getLocation());
			}
		}
		else
		{
			System.out.println("Invalid input.");
		}
	}
}