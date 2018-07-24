/**
 * ---------------------------------------------------------------------------

 * File name: Contact.java
 * Project name: Project2 - Contact
 * ---------------------------------------------------------------------------
 * Creator's name and email: Justin Adams, adamsjl3@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Feb 23, 2017
 * ---------------------------------------------------------------------------
 */

package addressBook;

import arrayOperations.ArrayOperations;

/**
 * Contact Book 
 * 
 * <hr>
 * Date created: Feb 23, 2017
 * <hr>.
 *
 * @author Justin Adams
 */
public class Contact
{
	
	
	private ContactType type;	/** The type. */
	
	private String name;	/** The name. */
	
	private String streetAddress;	/** The street address. */
	
	private String city;	/** The city. */
	
	private String state;	/** The state. */
	
	private String zipCode;	/** The zip code. */
	
	private String phone;	/** The phone. */
	
	private String email;	/** The email. */
	
	private String photo;	/** The photo. */
	
	/**
	 * Constructor        
	 * 
	 * <hr>
	 * Date created: Feb 23, 2017 .
	 */
	public Contact() 
	{
		type = ContactType.OTHER;
		name = "***";
		streetAddress = "***";
		city= "***";
		state = "XX";
		zipCode = "00000";
		phone = "(000)000-0000";
		email = "invalid@address.given";
		photo = "invalidFileName.jpg";
	}//End Contact() 
	
	/**
	 * Constructor        
	 * 
	 * <hr>
	 * Date created: Feb 24, 2017 .
	 *
	 * @param type the type
	 * @param name the name
	 * @param streetAddress the street address
	 * @param city the city
	 * @param state the state
	 * @param zipCode the zip code
	 * @param phone the phone
	 * @param email the email
	 * @param photo the photo
	 */
	public Contact (String type, String name, 
	                String streetAddress, String city, 
	                String state, String zipCode, 
	                String phone, String email, 
	                String photo)
	{
		setType(type.toUpperCase ( ));
		setName(name.toUpperCase ( ));
		setStreetAddress(streetAddress.toUpperCase ( ));
		setCity(city.toUpperCase ( ));
		setState(state.toUpperCase ( ));
		setZipCode(zipCode);
		setPhone(phone);
		setEmail(email.toUpperCase ( ));
		setPhoto(photo);
	}//End Contact (String, String, String, String, 
	//				String, int, String, String, String)

	/**
	 * Instantiates a new contact.
	 *
	 * @param copy the copy
	 */
	public Contact (Contact copy)
	{
		this.type = copy.type;
		this.name = copy.name;
		this.streetAddress = copy.streetAddress;
		this.city = copy.city;
		this.state = copy.state;
		this.zipCode = copy.zipCode;
		this.phone = copy.phone;
		this.email = copy.email;
		this.photo = copy.photo;
	}//End Contact (Contact)


	/**
	 * Gets the type.
	 *
	 * @return type
	 */
	public ContactType getType ( )
	{
		return type;
	}//End getType ( )

	
	/**
	 * Sets the type.
	 *
	 * @param type the type to set
	 */
	public void setType (String type)
	{
		try
		{
			this.type = ContactType.valueOf(type);
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
	}//End setType (String)

	/**
	 * Gets the name.
	 *
	 * @return name
	 */
	public String getName ( )
	{
		return name;
	}//End getName ( )

	/**
	 * Sets the name.
	 *
	 * @param name the name to set
	 */
	public void setName (String name)
	{
		if(!name.matches (".*\\d+.*"))
		{
			this.name = name;
		}
		else
		{
			this.name = "Invalid";
		}
	}//End setName (String)

	/**
	 * Gets the street address.
	 *
	 * @return streetAddress
	 */
	public String getStreetAddress ( )
	{
		return streetAddress;
	}//End getStreetAddress ( )

	/**
	 * Sets the street address.
	 *
	 * @param streetAddress the streetAddress to set
	 */
	public void setStreetAddress (String streetAddress)
	{
		this.streetAddress = streetAddress;
		
	}//End setStreetAddress (String)

	/**
	 * Gets the city.
	 *
	 * @return city
	 */
	public String getCity ( )
	{
		return city;
	}//End getCity ( )

	/**
	 * Sets the city.
	 *
	 * @param city the city to set
	 */
	public void setCity (String city)
	{
		if(!city.contains ("\\p{Punct}")&&
			!city.matches (".*\\d+.*"))
		{
			this.city = city;
		}
		else
		{
			this.city = "Invalid";
		}
	}//End setCity (String)
	
	/**
	 * Gets the state.
	 *
	 * @return state
	 */
	public String getState ( )
	{
		return state;
	}//End getState ( )
	
	/**
	 * Sets the state.
	 *
	 * @param state the state to set
	 */
	@SuppressWarnings ("static-access")
	public void setState (String state)
	{
		ArrayOperations array = new ArrayOperations();
		if (state.length ( )<3||
			state.length ( )>1)
		{
			if (array.binarySearch(state.toUpperCase ( )) != -1)
			{
				this.state = state.toUpperCase ( );
			}
			else 
			{
				this.state = "XX";
			}
		}
		else 
		{
			this.state = "XX";
		}

	}//End setState (String)
	
	/**
	 * Gets the zip code.
	 *
	 * @return zipCode
	 */
	public String getZipCode ( )
	{
		return zipCode;
	}//End getZipCode ( )
	
	/**
	 * Sets the zip code.
	 *
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode (String zipCode)
	{
		if(!zipCode.contains ("\\p{Punct}")&&
			!zipCode.matches(".*[a-z].*"))
		{
			if (zipCode.length ( ) == 5)
			{
				this.zipCode = zipCode;
			}
			else
			{
				this.zipCode = "00000";
			}
		}
		else
		{
			this.zipCode = "00000";
		}

	}//End setZipCode (int)
	
	/**
	 * Gets the phone.
	 *
	 * @return phone
	 */
	public String getPhone ( )
	{
		return phone;
	}//End getPhone ( )
	
	/**
	 * Sets the phone.
	 *
	 * @param phone the phone to set
	 */
	public void setPhone (String phone)
	{
		if (phone.length ( )<11 && phone.length ( )>9 
						|| phone.contains ("\\p{Punct}"))
		{
			 
			String strArea = phone.substring (0, 3);
			String strFirst = phone.substring (3, 6);
			String strLast = phone.substring (6, 10);
			this.phone = "(" + strArea + ")" + strFirst + "-" + strLast;
		}
		else
		{
			this.phone = "(000)000-0000";
		}
		
	}//End setPhone (String)
	
	/**
	 * Gets the email.
	 *
	 * @return email
	 */
	public String getEmail ( )
	{
		return email;
	}//End getEmail ( )
	
	/**
	 * Sets the email.
	 *
	 * @param email the email to set
	 */
	public void setEmail (String email)
	{
		if (email.contains ("@"))
		{
			if(email.indexOf("@") < email.lastIndexOf ("."))
			{
				this.email = email;
			}
			else
			{
				email = "invalid@address.given";
			}
		}
		else
		{
			email = "invalid@address.given";
		}
	}//End setEmail (String)
	
	/**
	 * Gets the photo.
	 *
	 * @return photo
	 */
	public String getPhoto ( )
	{
		return photo;
	}//End getPhoto ( )

	/**
	 * Sets the photo.
	 *
	 * @param photo the photo to set
	 */
	public void setPhoto (String photo)
	{
		if (!photo.endsWith (".jpg"))
		{
			this.photo = "invalidFileName.jpg";
		}
		else
		{
			this.photo = photo;
		}
		
	}//End setPhoto (String)
	
	/**
	 * toString method        
	 * 
	 * <hr>
	 * Date created: Feb 24, 2017 
	 * 
	 * <hr>.
	 *
	 * @return the string
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString ( )
	{
		return  type +"|" + 
				name +"|" + 
				streetAddress +"|" + 
				city + "|" + 
				state + "|" + 
				zipCode +"|" + 
				phone + "|" + 
				email + "|" + 
				photo;
	}//End toString ( )
	
}//End Contact
