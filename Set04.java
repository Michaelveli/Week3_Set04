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


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

public class Set04 {
    public static void main (String [] args) throws IOException {
        String names = "";
        int tempCount = 0;
        int totalCount =0;
        int count = 0;
        String currentLine;


        List<String> nameList = new ArrayList<String>();
        List<Integer> nameCount = new ArrayList<Integer>(); //list for the amount of babies born for a certain name

        Scanner nameScanner= new Scanner(new File("/home/michaelveli/Homework3/Set04/names/yob1996.txt")).useDelimiter(",");


        String line = nameScanner.nextLine();
        while (nameScanner.hasNext()) {
            names = nameScanner.next();
            nameList.add(names);
            count++;
        }
        nameScanner.close();
        System.out.println(nameList); //test to see contents of list
        System.out.println(nameCount);
        Scanner countScanner= new Scanner(new File("/home/michaelveli/Homework3/Set04/names/yob1996.txt")).useDelimiter(",");

System.out.println("Accepting integers");

        while (countScanner.hasNextInt()){ //while loop to add the number value from each name line (doesn't work currently!!)
            tempCount = nameScanner.nextInt();
            System.out.println("tempCount is " + tempCount);
            nameCount.add(tempCount);

        }

        //  System.out.println("There are " + (count - 1) +" fortunes.");
        int max = count;
        int min = 1;

        Iterator i = nameCount.iterator();
        while (i.hasNext())
          System.out.println(i.next()); //test to see contents of list
        System.out.println("There are " + count/2 + " names in the registry.");

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

        Scanner in = new Scanner(System.in);
        System.out.print("Enter your baby name: ");
        String babyName = in.next();
        System.out.print("Gender F/M ?: ");
        String babySex = in.next();

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



