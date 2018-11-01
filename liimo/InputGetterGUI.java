package liimo;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class InputGetterGUI {
	private static String temp = "";
	private static boolean isInt = false;
	public static String colName = "";

	

	public static int getInt()
	{
		
		int num = 0;
		
		do
		{
			
				temp = JOptionPane.showInputDialog(null, "Please enter a positive integer value such as: 20");
				isInt = isInt(temp);
				if(!isInt)
				{
					JOptionPane.showMessageDialog(null, "Invalid entry, please try again.\nAn integer is "
							+ "is a non-decimal, non-fractional number.");
				}
				else
				{
					num = Integer.parseInt(temp);
				}
				
				
		}while(isInt == false);
		
		//input.close();
		return num;
	}
	
	public static double getDouble()
	{
		
		boolean isDoube = false;
		double num = 0;
		
		do
		{
			
				temp = JOptionPane.showInputDialog(null, "Please enter a positive Real Number value such as: 20.001 or 20");
				if(isDouble(temp))
				{
					
					isDoube = true;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid entry, please try again.\nThis time enter a positive Real Number. A real number is "
							+ " similar to an integer, but can be a decimal or fractional number. A positive real number is greater than 0.");
					isDoube = false;
				}
			
		}while(isDoube == false);
		
		
		return num;
	}
	
	public static String getString()
	{
		return JOptionPane.showInputDialog(null, "Please enter the value for the " + colName + " column.");
	}
	
	
	public static String getAlphaString()
	{
		String incoming;
		
		while(true)
		{
			incoming = JOptionPane.showInputDialog(null, "Please enter letters only!");
			if(!isAlpha(incoming))
			{
				try
				{
					if(Integer.parseInt(incoming) == -1)
					{
						return incoming;
					}
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, "You entered at least one non-alphabetical character. Please enter letters only.");
					continue;
				}
			} 
			else if(isAlpha(incoming))
			{
				break;
			}
			
			
		}
		
	//	input.close();
		return incoming;
	}
	@SuppressWarnings("deprecation")
	public static boolean isAlpha(String incomingString) {
	    char[] candidates = incomingString.toCharArray();

	    for (char candidate : candidates) {
	        if(!Character.isLetter(candidate) & !Character.isSpace(candidate)) 
	        {
	            return false;
	        }
	        
	    }

	    return true;
	}

	
	public static boolean isDouble(String input)
	{
		
		try
		{
			if(Double.parseDouble(input) == Integer.parseInt(input))
			{
				return true;
			}
			else
			{
				return true;
			}
		}
		catch(Exception e)
		{
			return false;
		}
	
	}
	
	public static boolean isInt(String input)
	{
		
		try
		{
			if(Double.parseDouble(input) == Integer.parseInt(input))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			return false;
		}
	
	}
}









