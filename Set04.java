// Write a program that reads data about the changing popularity of baby names and displays the data about a particular name.
// Prompt the user for a name and gender.
// Each line a data file has a name, gender, and number in a comma-separated list.
// EX. "Jennifer,F,56709"
// Display a nicely formatted table that shows the changing popularity of the name the user entered over time.
// Think about what would make a good measure of popularity over time.
// Your program should start with a welcome message explaining the program and how it measures popularity.
// Also, display the year(s) with highest and lowest popularity.
// Do not include the data files in your submission.
// You may assume that your program will be run inside of a folder with all of the data files.
// Do not assume what years of data will be given (i.e. I may test on a subset of the data or use my own test files).
// for popularity take total population and divide by name
// another method would be to rank the names by number


import com.sun.source.tree.ClassTree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

public class Set04 {
    public static void main (String [] args) throws IOException {
        String names = "";
        int tempCount = 0;
        int count = 0; // line count
        int highestYear =0; //variable for highest year
        int lowestYear = 0;
        String currentLine;

        intro();
        String babyName= getName();
        System.out.println(babyName);
        String babySex= getSex();
        String birthYear = getYear();
       // System.out.println(birthYear);

        processNameFilesII(babyName,babySex,birthYear);






    }

    public static void readFile(){
        try {
            File fortune = new File("/home/michaelveli/IdeaProjects/Homework3/Set02/src/fortunes.txt");
            Scanner fortuneScanner = new Scanner(fortune);
            // fortuneScanner.useDelimiter("%");

            List<String> lines = new ArrayList<String>();
            while (fortuneScanner.hasNextLine()) {
                lines.add(fortuneScanner.nextLine());
                System.out.println(lines);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
    }

    public static void intro(){
        System.out.println("This program displays the changing popularity of selected baby names over a period of time.");
        System.out.println("Popularity is measured by comparing the reported number for the current year against the highest reported year for that name.");
        System.out.println("Additional (optional) parameters can be given such as a region or individual state.");
        System.out.println("The years with the highest and lowest popularity will also be displayed.");


    }

    public static String getName(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your baby name: ");
        String babyName = in.next();
        return babyName;
    }

    public static String getSex(){

        Scanner in = new Scanner(System.in);
        System.out.print("Gender F/M ?: ");
        String babySex= in.next();
        return babySex;
    }

    public static String getYear (){
        Scanner in = new Scanner(System.in);
        System.out.print("What year was the baby born in ?");
        String birthYear = in.next();
        return birthYear;
    }

    public static void processNamesFiles(String babyName) {
        for (int counter = 1880; counter <= 2018; counter++) {
            try {
                File namesFile = new File("yob" + counter + ".txt");
                Scanner readFileIn = new Scanner(namesFile);
                while (readFileIn.hasNext()) {
                    System.out.println(namesFile);
                }
            } catch (FileNotFoundException e) {
            }
        }
        for (int i = 1880; i <= 1880; i++){


        }

        System.out.println("It's working!");
    }

    public static void processNameFilesII(String babyName, String babySex, String birthYear) throws FileNotFoundException {
        PrintWriter err = new PrintWriter(System.err, true);
        final String start ="yob";
        final String ext = ".txt";
        final int lastYear=2017; //change to 2018
        final int firstYear=1880;

        System.out.println("Year - - - - - - - - - - Popularity");

        int count = 0;
        float percent;
        int maxSoFar =1;
        int minSoFar=1;
        int nameScore =1;

        int totCount = 0;
        int sum = 0;

        for (int year = firstYear; year<= lastYear; year++){
            String fileName = start + year + ext;
            Scanner fileIn = new Scanner (new FileReader(fileName));

            while(fileIn.hasNextLine()){
                String line = fileIn.nextLine();
                Scanner scan = new Scanner(line);
                while (scan.hasNext()){
                    scan.useDelimiter(",");

                    String name = scan.next();
                //    System.out.println(name);
                    String genderFile = scan.next();
                    //System.out.println(gender);

                    int nameCount = scan.nextInt();
                    sum +=nameCount;

                    count = count + nameCount;

                    if (name.equalsIgnoreCase(babyName) && birthYear.equalsIgnoreCase(birthYear) && genderFile.equalsIgnoreCase(babySex)){
                      //  totCount++;
                        nameScore = nameCount;

                        int totalCurLine = 1;
                       percent = ((float)(nameScore * 100)/count);

                    //    int nameCount = 1;

                        if (nameCount > maxSoFar){
                            maxSoFar = nameCount;}

                        if (nameCount < minSoFar){
                            maxSoFar = nameCount;}
                        System.out.println("This is the max so far:" + maxSoFar);
                        System.out.println("This is the sum: " + sum);

                        System.out.println( year + "        Popularity:     " + percent);

                    }
                }
            }
            count = 0;
            nameScore=1;

        }
        System.out.println ("The most poplular year for the given name is: " + maxSoFar);
        System.out.printf("The least popular year is: " + minSoFar);
    }



// public static void readFiles(){
    //     File currentFolder = new File (".");
    //       File[] texFiles = currentFolder.listFiles(File pathname) -> pathname.isfile() &&
    //               pathname.getName().endsWith(".txt"));
    //    for (File f: txtfiles) {
//            print(txtfiles);
//}
//        for (int year = 1880; year <= 2019; year++){
//           String filename ="yob" + year + ".txt";
//           printDataFromFile(filename);
//         ....
//           Scanner fin = new Scanner (new FileReader (filename)); //FileReader for large files
//    }
//
//    }

//public static void printFile(){

// try {
//        Scanner fin = new Scanner(f);
//       System.out.printf("printing file %s\n", f);
//        while (fin.hasNextLine()) ;
//        {
//         System.out.println(fin.nextLine);
//      }
//        System.out.println();
//   }
// }


}



