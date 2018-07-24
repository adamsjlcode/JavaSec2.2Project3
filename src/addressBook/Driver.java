/**
 * ---------------------------------------------------------------------------
 * File name: Driver.java 
 * Project name: Project3
 * ---------------------------------------------------------------------------
 * Creator's name and email: Justin Adams, adamsjl3@etsu.edu 
 * Course: CSCI 1260
 * Creation Date: Mar 24, 2017
 * ---------------------------------------------------------------------------
 */

package addressBook;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import arrayOperations.ArrayOperations;
import util.Utility;

/**
 * Create an address book of contacts
 *
 * <hr>
 * Date created: Mar 24, 2017
 * <hr>
 * 
 * @author Justin Adams
 */
public class Driver
{

	/**
	 * Driver program for AddressBook Class
	 *
	 * <hr>
	 * Date created: Mar 21, 2017
	 *
	 * <hr>
	 * 
	 * @param args
	 */
	public static void main (String [ ] args)
	{
		AddressBook addressBook = new AddressBook ( );	//Address of contacts
		Utility help = new Utility ( );					//Utility methods
		String [ ] data = null;							//Tempery Holder for contact data
		Scanner kbInput = new Scanner(System.in);		//Keyboard scanner object
		final int IMPORT = 0;							//Constant for import data from file
		final int EXPORT = 1;							//Constant for export data to file
		final String[] NAMES = {"type",
								"name",
								"address",
								"city",
								"state",
								"zipcode",
								"phone",
								"email",
								"photo address"};
														//Constant for asking data for contact
		int choice = JOptionPane.OK_OPTION;				//Holder for user choice
		String strtemp = "";							//Holder for user choice
		int iPos = -1;									//Holder for user choice
		int iChoice = -1;								//Holder for user choice
		boolean blnOwner = false;						//Flag for owner
		//Import File
		do 
		{
			try
			{
				data = help.importExportData (data, IMPORT);
				for (String temp : data)
				{
					try
					{
						addressBook.add (new Contact (help.loadContact (temp)));
						if(help.loadContact (temp).getType ( ) == ContactType.OWNER)
						{
							blnOwner = true;
						}
					}
					catch (Exception e)
					{
						
						e.printStackTrace ( );
					}
				}
				choice = JOptionPane.OK_OPTION;
			}
			catch (NullPointerException e)
			{
				choice = JOptionPane.showConfirmDialog (null,
					"No file was selected do you want to continue", "Error",
					JOptionPane.YES_NO_OPTION);
			}
		}while (choice == JOptionPane.CANCEL_OPTION || choice == JOptionPane.NO_OPTION);
		
		//Welcome Owner
		if (blnOwner)
		{
			for (int i = 0; i < addressBook.size ( ) ; i++ )
			{
				String strOwner = addressBook.get (i).getType ( ).toString ( );
				if (strOwner.equals ("OWNER"))
				{
					System.out.println ("\n\nWelcome " + 
										addressBook.get (i).getName ( ) + 
										"\n\n\n");
					addressBook.setOwner(addressBook.get (i));
					addressBook.remove (i);
				}
			}
		}
		while (!blnOwner)
		{
			if(addressBook.size ( ) != 0 ||!blnOwner)
			{
				System.out.println ("There is no owner for Address Book " +
							"\nPlease fill out this info");
				addressBook.setOwner (new Contact
									("OWNER",
										help.info(NAMES[1]).toUpperCase ( ),
										help.info(NAMES[2]).toUpperCase ( ),
										help.info(NAMES[3]).toUpperCase ( ),
										help.info(NAMES[4]).toUpperCase ( ),
										help.info(NAMES[5]),
										help.info(NAMES[6]),
										help.info(NAMES[7]).toUpperCase ( ),
										help.info(NAMES[8])));
				blnOwner = true;
			}
		}
		
		//Menu
		do
		{
			choice = help.menu ( );
			switch (choice) 
			{ 
				case 1:
				{
					addressBook.add (new Contact
									(help.info(NAMES[0]).toUpperCase ( ),
									help.info(NAMES[1]).toUpperCase ( ),
									help.info(NAMES[2]).toUpperCase ( ),
									help.info(NAMES[3]).toUpperCase ( ),
									help.info(NAMES[4]).toUpperCase ( ),
									help.info(NAMES[5]),
									help.info(NAMES[6]),
									help.info(NAMES[7]).toUpperCase ( ),
									help.info(NAMES[8])));
					break;
				}
				case 2:
				{
					iPos = -1;
					iChoice = -1;
					System.out.println (addressBook);
					System.out.println ("Which Contact?");
					while (iPos == -1)
					{
						try
						{
							iPos = kbInput.nextInt( )-1;			
						}
						catch (Exception e)
						{
							System.out.println ("Invalid Selection Try Again");
							iPos = -1;
						}
					}
					Contact temp = new Contact(addressBook.get (iPos));
					System.out.println ("What you like to edit?");
					for (int i = 0; i < NAMES.length; i++ )
					{
						System.out.println (i+1 + ". " + NAMES[i].toUpperCase ( ));
					}
					while (iChoice == -1)
					{
						try
						{
							iChoice = kbInput.nextInt( )-1;
							kbInput.nextLine ( );
						}
						catch (Exception e)
						{
							System.out.println ("Invalid Selection Try Again");
							iChoice = -1;
						}
					}
					strtemp = help.info(NAMES[iChoice]);
					if(iChoice == 0)temp.setType (strtemp.toUpperCase ( ));
					if(iChoice == 1)temp.setName (strtemp.toUpperCase ( ));
					if(iChoice == 2)temp.setStreetAddress (strtemp.toUpperCase ( ));
					if(iChoice == 3)temp.setCity (strtemp.toUpperCase ( ));
					if(iChoice == 4)temp.setState (strtemp.toUpperCase ( ));
					if(iChoice == 5)temp.setZipCode (strtemp);
					if(iChoice == 6)temp.setPhone (strtemp);
					if(iChoice == 7)temp.setEmail (strtemp.toUpperCase ( ));
					if(iChoice == 8)temp.setPhoto (strtemp);
					addressBook.set (iPos, new Contact(temp));
					break;
				}
				case 3:
				{
					strtemp = "";
					while (strtemp == "")
					{
						System.out.println ("What is the name?");
						strtemp = "";
						try
						{
							strtemp = kbInput.nextLine ( );
							ArrayList<Contact> find = new ArrayList<Contact> ();
							for (int i = 0 ; i < addressBook.size ( ) ; i++)
							{
								if (addressBook.get (i).getName( ).equalsIgnoreCase(strtemp))
								find.add (new Contact(addressBook.get (i)));
							}
							if (find.size ( ) != 0)
							{
								for (int i = 0; i < find.size(); i++ )
								{
									addressBook.remove (i);
								}
							}
							else
							{	
								System.out.println ("There is no contact");
							}
						}
						catch (Exception e)
						{
							System.out.println ("Invalid Selection Try Again");
							strtemp = "";
						}
					}
					break;
				}

				case 4:
				{
					strtemp = "";
					while (strtemp == "")
					{
						System.out.println ("What is the name?");
						strtemp = "";
						try
						{
							strtemp = kbInput.nextLine ( );
							ArrayList<Contact> find = new ArrayList<Contact> ();
							for (int i = 0 ; i < addressBook.size ( ) ; i++)
							{
								if (addressBook.get (i).getName( ).equalsIgnoreCase(strtemp))
								find.add (new Contact(addressBook.get (i)));
							}
							if (find.size ( ) != 0)
							{
								for (int i = 0; i < find.size(); i++ )
								{
									System.out.println (find.get (i).toString ( ));
								}
							}
							else
							{	
								System.out.println ("There is no contact");
							}
						}
						catch (Exception e)
						{
							System.out.println ("Invalid Selection Try Again");
							strtemp = "";
						}
					}
					break;
				}
				case 5:
				{
					strtemp = "";
					while (strtemp == "")
					{
						System.out.println ("What is the Contact Type?");
						strtemp = "";
						try
						{
							strtemp = kbInput.nextLine ( );
							ArrayList<Contact> find = new ArrayList<Contact> ();
							for (int i = 0 ; i < addressBook.size ( ) ; i++)
							{
								if (addressBook.get (i).getType ( ).toString ( ).equals(strtemp.toUpperCase ( )))
									find.add (new Contact(addressBook.get (i)));
							}
							if (find.size ( ) != 0)
							{
								for (int i = 0; i < find.size(); i++ )
								{
									System.out.println (find.get (i).toString ( ));
								}
							}
							else
							{
								System.out.println ("There is no contact");
							}
						}
						catch (Exception e)
						{
							System.out.println ("Invalid Selection Try Again");
							strtemp = "";
						}
					}
					break;
				}
				case 6:
				{
					strtemp = "";
					while (strtemp == "")
					{
						System.out.println ("What is the Zip Code?");
						strtemp = "";
						try
						{
							strtemp = kbInput.nextLine ( );
							ArrayList<Contact> find = new ArrayList<Contact> ();
							for (int i = 0 ; i < addressBook.size ( ) ; i++)
							{
								if (addressBook.get (i).getZipCode ( ).equals (strtemp))
									find.add (new Contact(addressBook.get (i)));
							}
							if (find.size ( ) != 0)
							{
								for (int i = 0; i < find.size(); i++ )
								{
									System.out.println (find.get (i).toString ( ));
								}
							}
							else
							{
								System.out.println ("There is no contact");
							}
						}
						catch (Exception e)
						{
							System.out.println ("Invalid Selection Try Again");
							strtemp = "";
						}
					}
					break;
				}
				case 7:
				{
					ArrayList<Contact> sorting = addressBook.copy ( );
					ArrayList<String> unsorted = new ArrayList<String>(sorting.size ( ));
					ArrayList<String> sorted = new ArrayList<String>(sorting.size ( ));
					for (int i = 0; i < sorting.size ( ); i++ )
					{
						unsorted.add (sorting.get (i).getName ( ));
					}
					for (int h = 0; h < sorting.size ( ); h++)
					{
						sorted.add(sorting.get (h).getName ( ));
					}
					ArrayOperations.selectionSort(sorted, sorted.size ( ));
					for (int i = 0; i < sorted.size ( ); i++ )
					{
						sorting = addressBook.copy ( );
						int iPosition = ArrayOperations.sequenceSearch (unsorted, sorted.get (i));
						Contact cTemp = addressBook.get(iPosition);
						addressBook.set (iPosition, addressBook.get (i));
						addressBook.set(i,cTemp);
						sorting = addressBook.copy ( );
						unsorted = new ArrayList<String>(sorting.size ( ));
						for (int j = 0; j < sorting.size ( ); j++ )
						{
							unsorted.add (sorting.get (j).getName ( ));
						}
					}
				}
				case 8:
				{
					for (int i = 0; i < addressBook.size ( ); i++ )
					{
						System.out.println (addressBook.get (i));
					}
					break;
				}
				case 9:
				{
					choice = JOptionPane.showConfirmDialog (null, 
															"Do you wish to save these changes?",
															"Save",
															JOptionPane.YES_NO_OPTION);
					if (choice == JOptionPane.YES_OPTION)
					{
						String[] strTemp =  new String[addressBook.size ( )+1];
						//Holder for users contacts to convert to string
						for (int i = 0 ; i < addressBook.size ( )+1 ; i++)
						{
							if (i == 0)
							{
								strTemp[0] = help.loadString(addressBook.getOwner ( ));
								continue;
							}
							strTemp[i] = help.loadString (new Contact(addressBook.get (i-1)));
						}
						for (String element : strTemp)
						{
							System.out.println (element);
						}
						try
						{
							help.importExportData(strTemp,EXPORT);
						}
						catch (NullPointerException e)
						{
							System.out.println ("Error file was not saved");
						}
					}
					System.exit (0);
				}
			}//End switch
			
		}while (choice != -1);

	}// End main(String [ ])

}// End DriverAddressBook
