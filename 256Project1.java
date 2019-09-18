package cmsc256;  // do not remove or comment out this statement
/**
 *  CMSC 256 Fall 2019
 *  Project 1
 *  Shell, Asia
 **/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Project1 {

    public static void main(String[] args) {
        Project1 proj = new Project1();
        String fileName = proj.checkArgs(args);
        int numRecords = 1;
        String[][] allData = new String [numRecords][3];
        System.out.print("Enter the number of records to read from the file: ");
        Scanner in = new Scanner(System.in);
        if (!in.hasNextInt()) {
            System.out.println("Your answer is not a number.");
            System.out.print("Enter the number of records to read from the file: ");
        }
        else{
            numRecords = in.nextInt();
        }
        in.close();
        try {
            File inputFile = proj.getFile(fileName);
            allData = proj.readFile(inputFile, numRecords);
        }
        catch (FileNotFoundException  ff) {
            System.out.println("Error reading file. Program terminated.");
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
        // Display appropriately labeled information for the following:
        // What is tallest height?
        System.out.println("The tallest height is " + proj.findTallest(allData));

        // Which row has the lowest weight?
        System.out.println("The row with the lowest weight is " + proj.findLightestRecord(allData));

        // Calculate average height of 20-30 year age range in the data.
        System.out.println("The average height of the 20-30 year age range in the data is " + proj.findAvgHeightByAgeRange(allData, 20, 30));
    }

    /**
     *   Gets the file name from command line argument;
     *   If parameter is empty, call promptForFileName() method
     * @param argv  String array from command line argument
     * @return      the name of the data file
     */
    public String checkArgs(String[] argv) {
        String fileName;
        if(argv.length == 0) {
            fileName = promptForFileName();         
        }
        else {
            fileName = argv[0];
        }
    return fileName;

    }

    /**
     * Prompt user to enter a file name
     * @return user entered file name
     */
    public String promptForFileName() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the file name: ");
        String userFileName = keyboard.nextLine();
        keyboard.close();
        return userFileName;
    }

    /**
     * Retrieve file with the given file name.
     * Prompts user if file cannot be opened or does not exist.
     * @param fileName  The name of the data file
     * @return          File object
     * @throws java.io.FileNotFoundException
     */
    public File getFile(String fileName) throws FileNotFoundException {
        File file = new  File(fileName);
        while(!file.exists()) {
            String fname =  promptForFileName();
            file = new File(fname);
        }
        return file;

    }

    /**
     * Reads the comma delimited file to extract the number data elements
     * provided in the second argument.
     * @param file          The File object
     * @param numRecords    The number of values to read from the input file
     * @return              2D array of data from the File
     * @throws IOException if any lines are missing data
     */
    public String[][] readFile(File file, int numRecords) throws IOException {
        Scanner inFile = new Scanner(file);
        String[][] data = new String [numRecords][3];
        String line = inFile.nextLine(); // header with data categories is being ignored 
        int row =  0;
        
        while(inFile.hasNextLine() && row < numRecords) {
            line = inFile.nextLine();
            Scanner inLine =  new Scanner(line);
            inLine.useDelimiter(",");
        
            for(int column = 0; column < 3; column++) {
                if(inLine.hasNext()) {
                    data[row][column] = inLine.next().trim();
                }
                else {
                    inLine.close();
                    throw new IOException("Error reading the data file.");
                }
            }
            row++;
            inLine.close();
        }   
        inFile.close();
        return data;
    }

    /**
     * Determines the tallest height in the data set
     * Height is the second field in each row
     * @param db        2D array of data containing [age] [height] [weight]
     * @return          Maximum height value
     */
    public int findTallest(String[][] db) {
        int tallest = Integer.parseInt(db[0][1]);
        for (int row = 0; row < db.length; row++) {
            if(Integer.parseInt(db[row][1]) > tallest) {
                tallest = Integer.parseInt(db[row][1]);
            }
        }
        return tallest;
    }

    /**
     * Returns the values in the record that have the lowest weight
     * @param db        2D array of data containing [age] [height] [weight]
     * @return          Smallest weight value
     */
    public String[] findLightestRecord(String[][] db) {
        int lowest = Integer.parseInt(db[0][2]);
        String[] rowIndex = db[0];
        for (int row = 0; row < db.length; row++) {
            if(Integer.parseInt(db[row][2]) < lowest) {
                lowest = Integer.parseInt(db[row][2]);
                rowIndex = db[row];
            }
        }
        return rowIndex;
    }

    /**
     * Calculates the average height for all records with the given age range.
     * @param db            2D array of data containing [age] [height] [weight]
     * @param lowerBound    youngest age to include in the average
     * @param upperBound    oldest age to include in the average
     * @return              The average height for the given range or 0 if no
     *                      records match the filter criteria
     */
    public double findAvgHeightByAgeRange(String[][] db, int lowerBound, int upperBound) {
        double sumHeight = 0;
        for(int row = 0; row < db.length; row++) {
            if(Integer.parseInt(db[row][0]) >= lowerBound && Integer.parseInt(db[row][0]) <= upperBound) {
                sumHeight += Double.parseDouble(db[row][1]);
            }
            else {
                throw new IllegalArgumentException("age out of bounds");
            }
        }
        double avgHeight = sumHeight/db.length;
        return avgHeight;
    }
}