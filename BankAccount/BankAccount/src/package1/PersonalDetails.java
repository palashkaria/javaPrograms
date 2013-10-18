package package1;

import java.io.Serializable;
/**
 * 
 */

/**
 * A class to store personal details
 * @author Palash
 */
public class PersonalDetails implements Serializable{
	
	//fields
	private String name, address;
	private static final long serialVersionUID=85L;
	
	
	//constructors
	PersonalDetails(String newName, String newAddress)
	{
		name=newName;
		address = newAddress;
	}
	/**
	 * to return the name of the account holder
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * to return the address of the account holder
	 * @return address
	 */
	public String getAddress()
	{
		return address;
	}
	/**
	 * to print print details in the form of a string
	 * @return s All personal details in a string
	 */
	public String toString()
	{
		String s;
		s = "Name : " + name + "  Address : " + address;
		return s;
	}
}
