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

      System.out.println("The file originally contains this many integers delimited by spaces: " + count);
   
      int newCount = count * 2; //Multiply by two because I need to deploy a ghost box to the right of each valid integers from file
      
      int base, height, areaOfBox = 0;
      
      height = (int) Math.sqrt(newCount); //Optimize the amount of valid integers and find the height of the box/matrix
      
      base = (int) Math.sqrt(newCount) * 2; //Optimize the amount of ((valid integers + ghost boxes) * 2) to find the base of the box/matrix 
  
      areaOfBox = height * base; //Returns the total area of the box/matrix
      
      System.out.println("Base is: " + base);
      System.out.println("Height is: " + height);
      
      int  start = base/2;
      
      System.out.println("Start is: " + start);					
        
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

        int minSigma = array[start];
        
        
            for(int x = start; x < (areaOfBox - base); x = minTempPosition)
            {

	        	minY = (x + (base - 1));
	        	minZ = (x + (base + 1));

	        	minLeftNextRowPosition = minSigma + array[minY];
	        	minRightNextRowPosition = minSigma + array[minZ];
	        	
	        	
	        	if(minLeftNextRowPosition < minRightNextRowPosition)
	        	{
	        		minSigma = minLeftNextRowPosition;
	        		
	        		minTempPosition = minY ;	            	
	        	}
	        	else
	        	{
	        		minSigma = minRightNextRowPosition;
	        		
	        		minTempPosition = minZ;	
            	}		
            }
         
            System.out.println("Total of minimum path is: " + minSigma);
            
            //Code to compare left and right values and iterate the least path summation 
            
            int maxY, maxZ, maxTempPosition, maxLeftNextRowPosition, maxRightNextRowPosition = 0;

            int maxSigma = array[start];
            
                for(int x = start; x < (areaOfBox - base); x = maxTempPosition)
                {

    	        	maxY = (x + (base - 1));
    	        	maxZ = (x + (base + 1));

    	        	maxLeftNextRowPosition = maxSigma + array[maxY];
    	        	maxRightNextRowPosition = maxSigma + array[maxZ];
    	        	
    	        	if(maxLeftNextRowPosition > maxRightNextRowPosition)
    	        	{
    	        		maxSigma = maxLeftNextRowPosition;
    	        		
    	        		maxTempPosition = maxY ;
    	
    	        	}
    	        	else
    	        	{
    	        		maxSigma = maxRightNextRowPosition;
    	        		
    	        		maxTempPosition = maxZ;         	
                	}		
                }
                System.out.println("Total of maximum path is: " + maxSigma);
	}
        
}


