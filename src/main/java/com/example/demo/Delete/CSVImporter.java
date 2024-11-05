package com.example.demo.Delete;
import com.example.demo.DataClasses.Cow;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class CSVImporter {


    public static ArrayList<Cow> getCowsFromCsv(String pathName){

        //This makes a path object
        Path path = Paths.get(pathName);

        //Our list to be returned
        ArrayList<Cow> cowsList = new ArrayList<>();

        //Trying to read the file:
        try (BufferedReader br = Files.newBufferedReader(path,
                StandardCharsets.UTF_8)){

            //This will be the column headers, unless we tell the user not to include those?
            //String topRow = br.readLine();

            //First real line for a cow:

            String csvCow = br.readLine();





            while (csvCow != null){

                //Split the row by comma delimiter
                //String[] cow = csvCow.split(",");

                //Depending on csv structure, put in the required data to make a Cow object

                System.out.println(csvCow);

                csvCow = br.readLine();
            }

        }

        catch(IOException e){
            e.printStackTrace();
        }



        return cowsList;



    }

    public static void main(String[] args){
        //ArrayList<Cow> test1 = getCowsFromCsv("");
        //System.out.println(test1);




    }



}
