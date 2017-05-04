import java.util.Scanner;
import java.io.*;

public class PathFinding
{
	public static void main(String[] args) throws IOException
	{
		//Code to put integers in proper boxes for each row
		
		String filename = ("FileInput.txt");
               File file = new File(filename);
               Scanner fin = new Scanner(file);
               int count = 0;

		while (fin.hasNext()) 
		{
		fin.nextInt();
		count += 1; 
		}
		
      fin.close();

      int newCount = count * 2; //Multiply by two because I need to deploy a ghost box to the right of each valid integers from file
      int base, height, areaOfBox = 0;

      height = (int) Math.sqrt(newCount); //Optimize the amount of valid integers and find the height of the box/matrix      
      base = (int) Math.sqrt(newCount) * 2; //Optimize the amount of ((valid integers + ghost boxes) * 2) to find the base of the box/matrix 
  
      areaOfBox = height * base; //Returns the total area of the box/matrix
           
      int  start = base/2;
          
        int array [] = new int [areaOfBox];
        
        File newFile = new File(filename);
        Scanner newFin = new Scanner(newFile);
        
        int temp = start;
        
        int row = 1;

        for(;newFin.hasNext();)
        { 	
        	int counter = 1;

        	array[temp] = newFin.nextInt(); 
        	        			
    			for(int y = (temp + 2);counter < row; y += 2)
    			{
        			array[y] = newFin.nextInt();
        			counter++;
    			}	    
    			
        		temp = (start + ((base*row)-row));
    			row++;
		}

        newFin.close();	
        
//Code to compare left and right values and iterate the least path summation 
        
        int minY, minZ, minTempPosition, minLeftNextRowPosition, minRightNextRowPosition = 0;

        int minCounter = 1;
        
        int minSigma = array[start];
        
        int minArray [] = new int [base];
        
        minArray[0] = start;
                
            for(int x = start; x < (areaOfBox - base); x = minTempPosition)
            {

	        	minY = (x + (base - 1));
	        	minZ = (x + (base + 1));

	        	minLeftNextRowPosition = minSigma + array[minY];
	        	minRightNextRowPosition = minSigma + array[minZ];
	        	
	        	
	        	if(minLeftNextRowPosition < minRightNextRowPosition)
	        	{
	        		minSigma = minLeftNextRowPosition;
	        		
	        		minArray [minCounter] = minY;
	        		
	        		minTempPosition = minY ;	            	
	        	}
	        	else
	        	{
	        		minSigma = minRightNextRowPosition;
	        		
	        		minArray [minCounter] = minZ;
	        		
	        		minTempPosition = minZ;	
            	}		
	        	
	        	minCounter++;
            }
 
//Code to print triangle for min path
            
            int minPrintCounter = 0;
            int minArrayCounter = 0;
                    
            for (int a = 0; a < (base*height); a+=base)
            {
            	for(int b = 0; b < base; b++)
            	{
            		if(array[(a+b)] != 0)
            		{
    					if(minPrintCounter == minArray[minArrayCounter])
    	        		{
    						if (array[(a+b)] != 0)
    						{
    							int tempNum = array[a+b];
    							int length = (int) Math.log10(tempNum);
    							
    							if(length == 1)
    							{
    			        			System.out.print("[" + array[(a+b)] + "]");
    			        			minArrayCounter++;
    							}
    							else
    							{
    			        			System.out.print("[0" + array[(a+b)] + "]");
    			        			minArrayCounter++;	
    							}
    						}
    						else
    						{
    							System.out.print("  ");
    						}
    	        		}
    					else
    					{
    						int tempNum = array[a+b];
    						int length = (int) Math.log10(tempNum);
    						
    						if(length == 1)
    						{
    							System.out.print(array[(a+b)]);
    						}
    						else
    						{
    		        			System.out.print("0" + array[(a+b)]);
    						}
    					}
            		}
            		else
            		{
            			System.out.print("  ");
            		}
            		minPrintCounter++;
            	}
            	System.out.println();
            }

            System.out.println("\n\nTotal of minimum path is " + minSigma + " and is pictured aboved");
            
//Code to compare left and right values and iterate the max path summation 
            
            int maxY, maxZ, maxTempPosition, maxLeftNextRowPosition, maxRightNextRowPosition = 0;
            
            int maxCounter = 1;
            
            int maxSigma = array[start];

            int maxArray [] = new int [base];
           
            maxArray[0] = start;
            
                for(int x = start; x < (areaOfBox - base); x = maxTempPosition)
                {

    	        	maxY = (x + (base - 1));
    	        	maxZ = (x + (base + 1));

    	        	maxLeftNextRowPosition = maxSigma + array[maxY];
    	        	maxRightNextRowPosition = maxSigma + array[maxZ];
    	        	
    	        	if(maxLeftNextRowPosition > maxRightNextRowPosition)
    	        	{
    	        		maxSigma = maxLeftNextRowPosition;
    	        		
    	        		maxArray[maxCounter] = maxY;
    	        		
    	        		maxTempPosition = maxY ;
    	
    	        	}
    	        	else
    	        	{
    	        		maxSigma = maxRightNextRowPosition;
    	        		
    	        		maxArray[maxCounter] = maxZ;

    	        		maxTempPosition = maxZ;         	
                	}		
    	        	
    	        	maxCounter++;
                }
               
//Code to print triangle for max path
        int maxPrintCounter = 0;
        int maxArrayCounter = 0;
                
        for (int i = 0; i < (base*height); i+=base)
        {
        	for(int j = 0; j < base; j++)
        	{
        		if(array[(i+j)] != 0)
        		{
					if(maxPrintCounter == maxArray[maxArrayCounter])
	        		{
						if (array[(i+j)] != 0)
						{
							int tempNum = array[i+j];
							int length = (int) Math.log10(tempNum);
							
							if(length == 1)
							{
			        			System.out.print("[" + array[(i+j)] + "]");
			        			maxArrayCounter++;
							}
							else
							{
			        			System.out.print("[0" + array[(i+j)] + "]");
			        			maxArrayCounter++;	
							}
						}
						else
						{
							System.out.print("  ");
						}
	        		}
					else
					{
						int tempNum = array[i+j];
						int length = (int) Math.log10(tempNum);
						
						if(length == 1)
						{
							System.out.print(array[(i+j)]);
						}
						else
						{
		        			System.out.print("0" + array[(i+j)]);
						}
					}
        		}
        		else
        		{
        			System.out.print("  ");
        		}
        		maxPrintCounter++;
        	}
        	System.out.println();
        }
        System.out.println("\n\nTotal of maximum path is " + maxSigma + " and is pictured aboved");
                
	}
        
}
        

