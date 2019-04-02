import java.util.Scanner;

/**
 * This program implements a simple Floyd's Algorithm approach to determine the shortest path between
 *  2 vertices by allowing passage through a specific vertex (1 thru n).  It only checks the path up
 *  to the third vertex.  A value of -1 indicates that no path exists for this vertex pair.
 * 
 * @author Michael R. Boykin
 * @version 2019-03-21 #001
 */
public class Floyd
{
    // instance variables - replace the example below with your own
    private int[][] weight, interVert;
    private int numOfVerts;

    /**
     * Constructor for objects of class Floyd
     */
    public Floyd()
    {
        // initialise Floyd's Algorithm table
        // row and column 0 contain zeroes so I can reference data without decrements. #LAZY
        weight = new int[][] {
            
            {0,1,-1,1,5},
            {9,0,3,2,-1},
            {-1,-1,0,4,-1},
            {-1,-1,2,0,3},
            {3,-1,-1,-1,0}
        };
        
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void chooseVertex()//int numOfVerts)
    {
        // put your code here
        int tempWeight;
        for (int d = 0; d < numOfVerts; d++){
            System.out.println(d + 1 + ": ");
            for (int x = 0; x < numOfVerts; x++){
                
                String endComma = ", ";
                for (int y = 0; y < numOfVerts; y++){
                    if(x!=d && y!=d){
                        if(y ==numOfVerts - 1){
                            endComma = "";
                        }
                        
                        if (weight[x][d] > 0 && weight[d][y] > 0){
                            tempWeight = weight[x][d] + weight [d][y];
                        
                        
                            if ((weight[x][y] > tempWeight && tempWeight > 0) || 
                                    weight[x][y] == -1)
                            {
                                weight[x][y] = tempWeight;
                                interVert[x][y] = d+1;
                            } 
                        }
                    }
                    
                    System.out.print (weight[x][y] + endComma);
                }
                System.out.println();
            }
            
            
        }
        
    }
    
    public static void main (String [] args){
        Floyd floyd1 = new Floyd();
        floyd1.createArray();
    }
    
    public void createArray () {
        System.out.print("Enter the number of vertices in this algorythm: ");
        Scanner typed = new Scanner( System.in );
        
        numOfVerts = Integer.parseInt(typed.nextLine());
        interVert = new int [numOfVerts][numOfVerts];
        weight = new int[numOfVerts][numOfVerts];
        int numIndex = 1, prevIndex = 0;
        int getNum;
        //String inputLine = "";
        
        for (int y = 0; y < numOfVerts; y++) {
            prevIndex = 0;
            System.out.print("Enter line #" + (y+1) + " of data: ");            
            String inputLine = typed.nextLine();
            //
            for (int x = 0; x < numOfVerts; x++) {
                char testchar = inputLine.charAt(numIndex -1);
                int wordLength = inputLine.length();
                while ( numIndex != inputLine.length() && 
                         inputLine.charAt(numIndex-1) != ' ' ){
                    numIndex ++;
                }
                
                iiif (numIndex == inputLine.length()){
                    String tempStr = inputLine.substring( prevIndex, numIndex );
                }
                else {
                    String tempStr = inputLine.substring( prevIndex, numIndex-1 );
                }
                getNum = Integer.parseInt( tempStr );
                prevIndex = numIndex;
                numIndex++;
                weight[x][y] = getNum;
            }
            
            
        }
        
    }
}
