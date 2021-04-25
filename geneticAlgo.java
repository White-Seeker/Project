import java.util.*;
import java.lang.*;
import java.io.*;

public class geneticAlgo{
    //READING THE TSP COORDINATES
    ArrayList<String[]> storing= new ArrayList<String[]>();;
    public geneticAlgo() throws Exception{
        File file = new File("/Users/SAT/Desktop/Project/berlin52.tsp");
        Scanner sc = new Scanner(file);
        String nextValue = null;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if("NODE_COORD_SECTION".equals(line)){
                while (sc.hasNextLine()) {
                    nextValue = sc.nextLine();
                    storing.add(nextValue.trim().split(" "));
                }
            }
        }
        sc.close();
    }

    public static ArrayList<String[]> returnScanner() throws Exception {
        geneticAlgo tree = new geneticAlgo();
        return tree.storing;
    }

    public static void main(String[] args) throws Exception {
        ArrayList<String[]> storedValues = returnScanner();

        Random rand=new Random();
        float[] arr=new float[52*2];
        float[][] coordinates=new float[52][2];
        
        int[][] path=new int[12][9];

        int j=0,k=0;
        
        //STORING THE COORDINATES IN 1D ARRAY
        while(j<52){
            String[] firstLine = storedValues.get(j);
            for (int i = 1; i < firstLine.length; i++) {
                arr[k++]=Float.parseFloat(firstLine[i]);
            }
            j++;
        }

        //STORING THE COORDINATES IN 2D ARRAY (MATRIX)
        k=0;
        for(int i=0;i<52;i=i+1){
            for(j=0;j<2;j=j+1){
                coordinates[i][j]=arr[k++];
            }
        }

        //The coordinates are stored in coOrdinates array in x y form. 
        for(int i=0;i<52;i=i+1){
            for(j=0;j<2;j=j+1){
                System.out.print(coordinates[i][j]+" ");
            }
            System.out.println();
        }

        //INITIALIZATION (No calculating the cost)

        System.out.println("INITIALIZATION OF DIFFERENT PATHS");

        int temp=rand.nextInt(51);
        for(int i=0;i<12;i=i+1){
            path[i][0]=path[i][8]=temp;
            for(j=1;j<8;j=j+1){
                path[i][j]=rand.nextInt(51);
            }
        }

        for(int i=0;i<12;i=i+1){
            for(j=0;j<9;j=j+1){
                System.out.print(path[i][j]+" ");
            }
            System.out.println();
        }


    }
}
