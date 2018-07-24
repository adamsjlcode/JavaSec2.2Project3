/**
 * ---------------------------------------------------------------------------
 * File name: Utility.java 
 * Project name: Project3
 * ---------------------------------------------------------------------------
 * Creator's name and email: Justin Adams, adamsjl3@etsu.edu 
 * Course: CSCI 1260
 * Creation Date: Mar 21, 2017
 * ---------------------------------------------------------------------------
 */

package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import addressBook.Contact;

/**
 * Utilitys for program
 * 
 * <hr>
 * Date created: Mar 21, 2017
 * <hr>.
 *
 * @author Justin Adams
 */
public class Utility
{
	
	
	Scanner kbInputString = new Scanner (System.in);	/** The kb input string. */
	
	Scanner kbInputInt = new Scanner (System.in);		/** The kb input int. */
	
	/**
	 * Constructor
	 * 
	 * <hr>
	 * Date created: Mar 21, 2017.
	 */
	public Utility ( )
	{

	}// End Utility ( )

	/**
	 * Import export data.
	 *
	 * @param temp the temp
	 * @param choice the choice
	 * @return the string[]
	 */
	public String [ ] importExportData (String [ ] temp, int choice)
	{
		String holder = "";		//Holder for file data in string
		Scanner data = null;	//File reader
		switch (choice)
		{
			case 0:
			{
				JFileChooser file = new JFileChooser (".\\docs");
				file.showDialog (null, "Import");
				if (file.APPROVE_OPTION == 0)
				{
					try
					{
						data = new Scanner (file.getSelectedFile ( ));
					}
					catch (FileNotFoundException e)
					{
						e.printStackTrace ( );
					}
					while (data.hasNextLine ( ))
					{
						String strCheck = data.nextLine ( )+"\n";
						holder += strCheck;
						strCheck = "";
					}
					temp = holder.split ("\\r?\\n");
				}
				data.close ( );
				break;
			}// End case 0:
			case 1:
			{
				JFileChooser file = new JFileChooser (".\\docs");
				PrintWriter write = null; 	//File writer
				file.showDialog (null, "Export");
				if (file.APPROVE_OPTION == 0)
				{
					try
					{
						write = new PrintWriter (new File (file.getSelectedFile ( )
															.getAbsolutePath ( )));
					}
					catch (FileNotFoundException e)
					{
						e.printStackTrace ( );
					}
					
					for (int i = 0; i < temp.length; i++ )
					{
						write.println (temp[i]);
					}// End for loop
				}
				else
				{
					return null;
				}
				write.close ( );
				break;
			}// End case 1:
		}// End switch ( )
		return temp;
	}// End importExportData (String[], int)

	
	/**
	 * Info.
	 *
	 * @param info the info
	 * @return the string
	 */
	public String info (String info)
	{
		System.out.println ("What is the Contact's " + info);
		return kbInputString.nextLine ( );
	}// End info (String)

	/**
	 * Load contact.
	 *
	 * @param data the data
	 * @return the contact
	 */
	public Contact loadContact (String data)
	{
		Contact temp = new Contact ( );//Temporey holder for contact
		String [ ] strTemp = data.split ("\\|");//Split string into an array
		for (int i = 0; i < strTemp.length; i++ )
		{
			switch (i)
			{
				case 0:
					temp.setType (strTemp [i].toUpperCase ( ));
					break;
				case 1:
					temp.setName (strTemp [i].toUpperCase ( ));
					break;
				case 2:
					temp.setStreetAddress (strTemp [i].toUpperCase ( ));
					break;
				case 3:
					temp.setCity (strTemp [i].toUpperCase ( ));
					break;
				case 4:
					temp.setState (strTemp [i].toUpperCase ( ));
					break;
				case 5:
					temp.setZipCode (strTemp [i].toUpperCase ( ));
					break;
				case 6:
					strTemp [i] = removePhone(strTemp [i]);
					temp.setPhone (strTemp [i].toUpperCase ( ));
					break;
				case 7:
					temp.setEmail (strTemp [i].toUpperCase ( ));
					break;
				case 8:
					temp.setPhoto (strTemp [i]);
					break;
			}// End switch ( )
		}// End for loop
		return temp;
	}// End loadContact (int,String)

	/**
	 * Load string.
	 *
	 * @param data the data
	 * @return the string
	 */
	public String loadString (Contact data)
	{
		return new String(data.getType ( )+"|"+
						data.getName ( )+"|"+
						data.getStreetAddress ( )+"|"+
						data.getCity ( )+"|"+
						data.getState ( )+"|"+
						data.getZipCode ( )+"|"+
						data.getPhone ( )+"|"+
						data.getEmail ( )+"|"+
						data.getPhoto ( ));
	}//End loadString (Contact)

	/**
	 * Menu.
	 *
	 * @return the int
	 */
	public int menu ( )
	{
		int choice = -1; //Holder for user choice
		do
		{
			System.out.println ("What would you like to do?" 
								+ "\n1. Add Contact" 
								+ "\n2. Edit Contact" 
								+ "\n3. Remove Contact" 
								+ "\n4. Find Contact by Name" 
								+ "\n5. Find Contact by Contact Type" 
								+ "\n6. Find Contacts by Zip Code" 
								+ "\n7. Sort Contacts by Name"
								+ "\n8. Display Contacts" 
								+ "\n9. Exit");
			try
			{
				choice = kbInputInt.nextInt ( );
			}
			catch (InputMismatchException e)
			{
				System.out.println ("Error not a number");
				kbInputInt.nextLine ( );
				choice = -1;
			}
		}
		while (choice < 1 || choice > 9);
		return choice;
	}//End menu ( )
	
	/**
	 * Removes the phone.
	 *
	 * @param phone the phone
	 * @return the string
	 */
	public String removePhone (String phone)throws StringIndexOutOfBoundsException
	{
			String strArea = phone.substring (1, 4);
			String strFirst = phone.substring (5, 8);
			String strLast = phone.substring (9, 13);	
			phone = strArea + strFirst + strLast;
			return phone;	
	}//End removePhone (String)
	
}// End Utility
