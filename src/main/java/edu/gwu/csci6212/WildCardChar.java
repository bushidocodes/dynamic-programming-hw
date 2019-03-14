package edu.gwu.csci6212;

import java.util.*;
import java.io.*;

public class WildCardChar
{
    public static boolean isMatching(char[] c_str, char[] c_pattern, int p, int q)
	{
	    // If both input string and pattern reaches their end,
		// return true
		if ( q < 0 && p < 0) {
			return true;
		}
	    
	    // empty pattern can only match with empty string 
        else if (q == 0) 
            return (p == 0); 
        
        // If only pattern reaches its end, return false
		else if (q < 0) 
		{
			return false;
		}

		else if (p < 0)
		{
			for (int i = 0; i <= q; i++) 
			{
				if (c_pattern[i] != '*') 
				{
					return false;
				}
			}

			return true;
		}
            
    	// create a DP lookup table
        boolean[][] lookup = new boolean[p + 1][q + 1]; 
        
        // initailze lookup table to false 
        for(int i = 0; i < p + 1; i++) 
            Arrays.fill(lookup[i], false); 
            
        
        // empty pattern can match with empty string 
        lookup[0][0] = true; 
        
        if (!lookup[p][q])
		{
		    if (c_pattern[q] == '*')
			{
			    lookup[p][q] = isMatching(c_str, c_pattern, p - 1, q) ||(isMatching(c_str, c_pattern, p , q - 1 ));
        
			}
			else
			{
			    if (c_pattern[q] != '?' && c_pattern[q] != c_str[p]) 
			    {
			        lookup[p][q] = false;
				}
				else 
				{
					lookup[p][q] = isMatching(c_str, c_pattern, p - 1, q - 1);
				}
			}
		}
		
        return lookup[p][q];
	}
	
	public static void  main (String[] args) 
    {
        System.out.println("Enter The Input String \n");
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println("Enter The WildCard Pattern \n");
        String pattern=sc.nextLine();
		
		char[] c_str=str.toCharArray();
		char[] c_pattern=pattern.toCharArray();
		
		int str_len=str.length();
		int pattern_len= pattern.length();
		
			
        if (isMatching(c_str, c_pattern, str_len - 1 ,pattern_len - 1)) 
		    {
			System.out.print("Match");
		    } 
		else 
		    {
			System.out.print("No Match");
		    }
    }
}
