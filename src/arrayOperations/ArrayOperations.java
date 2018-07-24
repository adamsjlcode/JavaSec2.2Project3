/**
 * ---------------------------------------------------------------------------
 * File name: ArrayOperations.java
 * Project name: Project2 - Contact
 * ---------------------------------------------------------------------------
 * Creator's name and email: Justin Adams, adamsjl3@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Feb 23, 2017
 * ---------------------------------------------------------------------------
 */

package arrayOperations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Array Operations
 * 
 * <hr>
 * Date created: Feb 23, 2017
 * <hr>.
 *
 * @author Justin Adams
 */
public class ArrayOperations
{
	
	
	/** The data. */
	static String[] data = { "AK", "AL", "AR","AZ", "CA",
							"CO", "CT", "DE", "FL", "GA",
							"HI", "IA", "ID", "IL", "IN",
							"KS", "KY", "LA","MA", "MD",
							"ME", "MI", "MN", "MO", "MS",
							"MT", "NC", "ND", "NE", "NH",
							"NJ", "NM","NV", "NY", "OH",
							"OK", "OR", "PA", "RI", "SC",
							"SD", "TN", "TX", "UT", "VA", 
							"VT", "WA","WI","WV", "WY"};	
								/** The State data. */
	/**
	 * Constructor        
	 * 
	 * <hr>
	 * Date created: Feb 23, 2017 .
	 */
	public ArrayOperations ( )
	{
		
	}//End ArrayOperations ( )

	
	/**
	 * Find max.
	 *
	 * @param array the array
	 * @param size the size
	 * @return the int
	 */
	public static int findMax (String[] array, int size)
	{
		int max = 0;	//Placeholder for max value
		for(int i = 0 ; i < size; i++)
		{
			if (array[i].compareTo(array[max])>0)
			{
				max = i;
			}
		}
		return max;
	}//End findMax (String[], int)
	
	/**
	 * Find max.
	 *
	 * @param array the array
	 * @param size the size
	 * @return the int
	 */
	public static int findMax (ArrayList<String> array, int size)
	{
		int max = 0;	//Placeholder for max value
		for(int i = 0 ; i < size; i++)
		{
			if (array.get (i) .compareTo(array.get (max))>0)
			{
				max = i;
			}
		}
		return max;
	}//End findMax (String[], int)
	
	/**
	 * Selection sort.
	 *
	 * @param array the array
	 * @param size the size
	 */
	public static void selectionSort(String[] array, int size)
	{
			for(int i = size ; 0 < i; i--)
			{
				int max = findMax(array, i);
				if(array[i-1].compareTo(array[max])<0)
				{
					String temp = array[max];
					array[max] = array[i-1];
					array[i-1] = temp;
				}
			}
	}//End selectionSort(String[], int)

	/**
	 * Selection sort.
	 *
	 * @param array the array
	 * @param size the size
	 */
	public static void selectionSort(ArrayList<String> array, int size)
	{
			for(int i = size ; 0 < i; i--)
			{
				int max = findMax(array, i);
				if(array.get (i-1).compareTo(array.get (max))<0)
				{
					String temp = array.get (max);
					array.set (max, array.get (i-1));
					array.set (i-1, temp);
				}
			}
	}//End selectionSort(String[], int)
	
	/**
	 * Sequence search.
	 *
	 * @param array the array
	 * @param value the value
	 * @return the int
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 */
	public static int sequenceSearch(ArrayList<String> array, String value)throws IndexOutOfBoundsException
	{
		int iPosition = 0;
		
		boolean blnCheck = false;
		while (blnCheck != true)
		{
			if (array.get (iPosition).compareTo (value)==0)
			{
				blnCheck = true;
			}
			else
			{
				iPosition++;
			}
		}
		return iPosition;
		
		
	}//End sequenceSearch(ArrayList<String>, String)
	
	
	
	/**
	 * Binary search.
	 *
	 * @param array the array
	 * @param value the value
	 * @return the int
	 */
	public static int binarySearch(String[] array,String value)
	{
		int first;      //First element
		int last;       //Last element
		int middle;     //Middle element
		int position;   //Current element
		boolean found;  //Flag
		first = 0;
		last = array.length;
		middle = 0;
		position = -1;
		found = false;

			while (!found && first <= last)
			{
				if (middle == array.length)
				{
					return position;
				}
				middle = (first + last) / 2;
				if (array[middle].compareTo(value) == 0)
				{
					found = true;
					position = middle;
				}
				else if (array[middle].compareTo(value) > 0)
				{
					last = middle - 1;
				}
				else
				{
					first = middle + 1;
				}
			}
		return position;
	}//End binarySearch(String)

	/**
	 * Binary search.
	 *
	 * @param array the array
	 * @param value the value
	 * @return the int
	 */
	public static int binarySearch(ArrayList<String> array,String value)
	{
		int first;      //First element
		int last;       //Last element
		int middle;     //Middle element
		int position;   //Current element
		boolean found;  //Flag
		first = 0;
		last = array.size ( );
		middle = 0;
		position = -1;
		found = false;

			while (!found && first <= last)
			{
				if (middle == array.size ( ))
				{
					return position;
				}
				middle = (first + last) / 2;
				if (array.get (middle).compareTo(value) == 0)
				{
					found = true;
					position = middle;
				}
				else if (array.get (middle).compareTo(value) > 0)
				{
					last = middle - 1;
				}
				else
				{
					first = middle + 1;
				}
			}
		return position;
	}//End binarySearch(String)
	/**
	 * Binary search.
	 *
	 * @param value the value
	 * @return the int
	 */
	public static int binarySearch(String value)
	{
		int first;      //First element
		int last;       //Last element
		int middle;     //Middle element
		int position;   //Current element
		boolean found;  //Flag
		first = 0;
		last = data.length -1;
		middle = 0;
		position = -1;
		found = false;

			while (!found && first <= last)
			{
				if (middle == data.length)
				{
					return position;
				}
				middle = (first + last) / 2;
				if (data[middle].compareTo(value) == 0)
				{
					found = true;
					position = middle;
				}
				else if (data[middle].compareTo(value) > 0)
				{
					last = middle - 1;
				}
				else
				{
					first = middle + 1;
				}
			}
		return position;
	}//End binarySearch(String)
	
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
		String strData = "";
		for (int i = 0; i < data.length; i++ )
		{
			strData = data[i] + "\n";
		}
		return strData;
	}//End toString ( )
	
}//End ArrayOperations
