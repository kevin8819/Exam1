public class DataItem 
{
	private String item;
	private int quantity;
	private double price;
	private String location;
	
	/**
	 * No parameter constructor
	 */
	public DataItem()
	{
		item = "";
		quantity = 0;
		price = 0.0;
		location = "";
	}
	
	/**
	 * Constructor with arguments
	 * @param item the item's name
	 * @param quantity the number of quantity of the item
	 * @param price the price of the item
	 * @param location the location of the item
	 */
	public DataItem(String item, int quantity, double price, String location)
	{
		this.item = item;
		this.quantity = quantity;
		this.price = price;
		this.location = location;
	}
	
	/**
	 * Copy constructor
	 * @param app the object to copy from
	 */
	public DataItem(DataItem app)
	{
		this.item = app.item;
		this.quantity = app.quantity;
		this.price = app.price;
		this.location = app.location;
	}
	
	/**
	 * Setter for item
	 * @param item the new value for the item field
	 */
	public void setItem(String item)
	{
		this.item = item;
	}
	
	/**
	 * Setter for quantity
	 * @param quantity the new value for the quantity field
	 */
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	/**
	 * Setter for price
	 * @param price the new value for the price field
	 */
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	/**
	 * Setter for location
	 * @param location the new value for location
 	 */
	public void setLocation(String location)
	{
		this.location = location;
	}
	
	/**
	 * Getter for item
	 * @return the item name
	 */
	public String getItem()
	{
		return item;
	}
	
	/**
	 * Getter for quantity
	 * @return the quantity
	 */
	public int getQuantity()
	{
		return quantity;
	}
	
	/**
	 * Getter for price
	 * @return the price
	 */
	public double getPrice()
	{
		return price;
	}
	
	/**
	 * Getter for location
	 * @return the location
	 */
	public String getLocation()
	{
		return location;
	}
}
