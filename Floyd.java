import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

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
    private String[] inputsParse;
    private Scanner typed = new Scanner( System.in );

    /**
     * Constructor for objects of class Floyd
     */
    public Floyd()
    {
        // initialise Floyd's Algorithm table
        // row and column 0 contain zeroes so I can reference data without decrements. #LAZY
        
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
        String endComma = "\t|  ";
        
        int tempWeight;
        for (int d = 0; d < numOfVerts; d++){
            System.out.println(d + 1 + ": ");
            for (int x = 0; x < numOfVerts; x++){
                
                
                for (int y = 0; y < numOfVerts; y++){
                    if(x!=d && y!=d){
                        
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
                    
                    if( weight[x][y] == -1 ){
                        System.out.print ("-" + endComma);
                    } else {
                        System.out.print (weight[x][y] + endComma);
                    }
                    
                }
                System.out.println();
                for (int index = 0; index < numOfVerts; index++ ) 
                {
                    System.out.print ("  " + interVert[x][index] + endComma );
                }
                System.out.println();
                System.out.println("-----------------------------------------");
            }
            
            
        }
        
    }
    
    public static void main (String [] args){
        Floyd floyd1 = new Floyd();
        
        System.out.println("How do you wish to populate the Floyd's Algorithm table?");
        System.out.println("[1] manually enter");
        System.out.println("[2] load data from a file");
        System.out.println("[3] end program");
        
        //Scanner typed = new Scanner (System.in);
        int choice = Integer.parseInt( floyd1.typed.nextLine() );
        
        if( choice == 1 ) {
            floyd1.manuallyEnterArray();
        }
        else if( choice == 2 ) {
            floyd1.loadArray();
        }
        else {
            System.exit(0);
        }
        
        floyd1.createArray();
        //for( int graphIteration = 0; graphIteration < num
        floyd1.chooseVertex();
    }
    
    public void manuallyEnterArray () {
        System.out.print("Enter the number of vertices in this algorythm: ");
        //Scanner typed = new Scanner( System.in );
        numOfVerts = Integer.parseInt( typed.nextLine() );
        
        inputsParse = new String[ numOfVerts ];
        
        for(int index = 0; index < numOfVerts; index++){
            System.out.print("Enter line #" + (index+1) + " of data: ");
            inputsParse[index] = typed.nextLine();
        }
        //
    }
    
    public void loadArray () {
        //
        System.out.print("Please type the name of the file (with .txt) to load: ");
        //Scanner typed = new Scanner( System.in );
        String fileName = typed.nextLine();
        String readLine;
        BufferedReader inputFile;
        int index = 0;
        
        try {
            inputFile = new BufferedReader( new FileReader( fileName ) );
            numOfVerts = Integer.parseInt( inputFile.readLine() );
            inputsParse = new String[ numOfVerts ];
        
            while( ( readLine = inputFile.readLine() ) != null) {
                //
                inputsParse[ index ] = readLine;
                index++;
            }
            inputFile.close();
        }
        catch(Exception e) {
            System.out.println("Problem opening/reading file named [" + fileName + "]");
        }
        
        //
    }
    
    public void createArray () {
        interVert = new int [numOfVerts][numOfVerts];
        weight = new int[numOfVerts][numOfVerts];
        int numIndex = 1, prevIndex = 0, index = 0;
        int getNum;
        
        for (int y = 0; y < numOfVerts; y++) {
            prevIndex = 0; numIndex = 1; index = y;
            String inputLine = inputsParse[ index ];
            //
            for (int x = 0; x < numOfVerts; x++) {
                
                while ( numIndex != inputLine.length() && 
                         inputLine.charAt(numIndex-1) != ' ' ){
                    numIndex ++;
                }
                //
                int modNum = ( numIndex / inputLine.length() ) -1;
                String tempStr = inputLine.substring( prevIndex, ( numIndex + modNum ) );
                
                getNum = Integer.parseInt( tempStr );
                prevIndex = numIndex;
                numIndex++;
                weight[y][x] = getNum;
            }
            
            
        }
        
    }
}
