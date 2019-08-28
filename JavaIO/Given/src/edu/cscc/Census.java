package edu.cscc;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Census {
    public static Surname[] loadCensusData(String fname) {
        int line = 0; // Keep track of lines of file we've read
        Surname[] namelist = new Surname[100];

        File f = new File(fname);
        try{
            Scanner nameInput = new Scanner(f);
            String skip = nameInput.nextLine();
            while (nameInput.hasNextLine() && line <100){
                String curLine = nameInput.nextLine();
                String output[] = curLine.split(",");
                Surname curSurname = new Surname(
                        output[0],
                        Integer.parseInt(output[1]),
                        Integer.parseInt(output[2]),
                        Double.parseDouble(output[3])
                );
                namelist[line] = curSurname;
                line++;
            }

        } catch(FileNotFoundException fileNotFoundException) {

            System.out.println("File not found " + fileNotFoundException);
            return null;
        } catch(NumberFormatException numberFormatException) {
            System.out.println("Number format exception " + numberFormatException);
        } catch (Exception e) {
            System.out.println("Uh oh.. something went wrong " + e);
        }

        return namelist;
    }
}