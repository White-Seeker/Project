import java.io.*;
import java.util.*;
import java.lang.*;

//Reading the coordinates from TSP file
 public class Tree {
    ArrayList<String[]> storing= new ArrayList<String[]>();

    public Tree() throws Exception {
        File file = new File("C:/Users/SAT/Desktop/Project/berlin52.tsp");
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
        Tree tree = new Tree();
        return tree.storing;
    }

    public static void main(String[] args) throws Exception {
        ArrayList<String[]> storedValues = returnScanner();
        for(int i=0;i<storedValues.size();i++){
            String[] arr=storedValues.get(i);
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j]+" ");
            }
            System.out.println();
        }
    }
}

