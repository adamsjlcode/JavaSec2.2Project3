/**
 * ---------------------------------------------------------------------------
 * File name: AddressBook.java
 * Project name: Project3
 * ---------------------------------------------------------------------------
 * Creator's name and email: Justin Adams, adamsjl3@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Mar 24, 2017
 * ---------------------------------------------------------------------------
 */

package addressBook;

import java.util.ArrayList;

/**
 * Address Book of Contacts
 * 
 * <hr>
 * Date created: Mar 24, 2017
 * <hr>.
 *
 * @author Justin Adams
 */
public class AddressBook
{
	
	
	Contact owner;						/** The owner. */
	
	ArrayList <Contact> addressBook;	/** The address book. */
	
	/**
	 * Constructor        
	 * 
	 * <hr>
	 * Date created: Mar 21, 2017 .
	 */
	public AddressBook ( )
	{
		addressBook = new ArrayList <Contact>();
		owner = null;
	}//End AddressBook ( )
	
	/**
	 * Gets the Contact.
	 *
	 * @param pos the pos
	 * @return the contact
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 */
	public Contact get(int pos)throws IndexOutOfBoundsException		
	{
		return addressBook.get (pos);
	}//End get (int)
	
	/**
	 * Adds the Contact.
	 *
	 * @param data the data
	 */
	public void add(Contact data)			
	{
		 addressBook.add (data);
	}//End add (Contact)
	
	/**
	 * Sets the Contact.
	 *
	 * @param pos the pos
	 * @param data the data
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 */
	public void set (int pos,Contact data) throws IndexOutOfBoundsException		
	{
		 addressBook.set (pos, data);
	}//End size ( )
	
	/**
	 * Size Contacts.
	 *
	 * @return the int
	 */
	public int size ( )
	{
		return addressBook.size ( );
	}//End size ( )
	
	/**
	 * Removes the Contact.
	 *
	 * @param pos the pos
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 */
	public void remove (int pos) throws IndexOutOfBoundsException				
	{
		addressBook.remove (pos);
	}//End remove (int)
	
	/**
	 * Copy.
	 *
	 * @return the array list
	 */
	public ArrayList<Contact> copy()
	{
		ArrayList<Contact> temp = new ArrayList<Contact>();
		for (int i = 0; i < addressBook.size ( ); i++ )
		{
			temp.add (addressBook.get (i));
		}
		return temp;
	}
	
	/**
	 * Sets the owner.
	 *
	 * @param owner the new owner
	 */
	public void setOwner(Contact owner)
	{
		this.owner = new Contact(owner);
	}
	
	/**
	 * Gets the owner.
	 *
	 * @return the owner
	 */
	public Contact getOwner ( )
	{
		return owner;
	}
	
	/**
	 * Creates user friendly contact list         
	 * 
	 * <hr>
	 * Date created: Mar 22, 2017 
	 * 
	 * <hr>.
	 *
	 * @return the string
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString ( )
	{
		String temp = "";
		for (int i = 0; i < addressBook.size(); i++ )
		{
			temp += i+1 +". " +addressBook.get (i).toString ( ) +"\n";
		}
		return temp;
	}//End toString ( )
	
}//End AddressBook
