import java.util.*;
import java.io.*;
public class main {
    public static Scanner scan = new Scanner(System.in);
    public static String stdPath = "/home/gl33tx/Faculdade/IA/BinaryTrees/database";
    /*public static File irisDatabase = new File(path + "/iris.csv");
    public File restaurantDatabase = new File(path + "/restaurant.csv");
    public File weatherDatabase = new File(path + "/weather.csv");*/
    public static File folder = new File(stdPath);
    public static File database[] = folder.listFiles();
    public static Scanner inBuffer;
    public static void errorMessage(FileNotFoundException ex) {
        System.out.println("\n######\nCritical error:\n" + ex + "\n######");
        return;
    }

    public static void fileReader(int dataOption) {
        try {
            inBuffer = new Scanner(database[dataOption]);
        } catch(FileNotFoundException ex) {
            errorMessage(ex);
            System.exit(0);
        }
    }
    public static void main(String[] args) {
    	System.out.println("Database?\n");
        for (int i = 0; i < database.length; i++) {
            if (database[i].isFile()) {
                System.out.println((i+1)+". " + database[i].getName());
            }
        }
        System.out.println();
        //System.out.println("Database?\n\n1. Iris\n2.Restaurant\n3.Weather");
        Scanner scan = new Scanner(System.in);
        int dataOption = scan.nextInt();
        //int dataOption = 1;
        fileReader(dataOption-1);
        while (inBuffer.hasNextLine())
            System.out.println(inBuffer.nextLine());
    }
}