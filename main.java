import java.util.*;
import java.io.*;
public class main extends Aux{
    public static Scanner scan = new Scanner(System.in);
    public static String stdPath = (new File("database")).getAbsolutePath();
    /*public static File irisDatabase = new File(path + "/iris.csv");
    public File restaurantDatabase = new File(path + "/restaurant.csv");
    public File weatherDatabase = new File(path + "/weather.csv");*/
    public static File folder = new File(stdPath);
    public static File databaseFiles[] = folder.listFiles();
    public static Scanner inBuffer;
    public static void errorMessage(FileNotFoundException ex) {
        System.out.println("\n######\nCritical error:\n" + ex + "\n######");
        return;
    }

    public static void fileReader(int dataOption) {
        try {
            inBuffer = new Scanner(databaseFiles[dataOption]);
        } catch(FileNotFoundException ex) {
            errorMessage(ex);
            System.exit(0);
        }
    }
    public static void main(String[] args) {
    	System.out.println("Database?\n");
        for (int i = 0; i < databaseFiles.length; i++) {
            if (databaseFiles[i].isFile()) {
                System.out.println((i+1)+". " + databaseFiles[i].getName());
            }
        }
        System.out.println();
        //System.out.println("Database?\n\n1. Iris\n2.Restaurant\n3.Weather");
        Scanner scan = new Scanner(System.in);
        int dataOption = scan.nextInt()-1;
        //int dataOption = 0;
        fileReader(dataOption);
        String attributes[] = (inBuffer.nextLine()).split(",");
        int attributesSize=attributes.length;
        System.out.println(attributesSize);
        int sum=0;
        while (inBuffer.hasNextLine()){
        	inBuffer.nextLine();
        	sum++;
        }
        fileReader(dataOption);
        String database[][]= new String[sum+1][1000];
        int i=0;
        String tempString;
        while (inBuffer.hasNextLine()){
        	tempString=inBuffer.nextLine();
        	database[i]=tempString.substring(tempString.indexOf(",")+1,tempString.length()).split(",");
            for(String a : database[i])System.out.print(a+" ");
            System.out.println();
            i++;
        }
        System.out.println("Best Gain: "+valueImportance(database));
    }
}