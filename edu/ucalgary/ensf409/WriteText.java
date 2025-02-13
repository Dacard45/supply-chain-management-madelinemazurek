package edu.ucalgary.ensf409;
import java.io.*;

/**
 * WriteText creates an output file for the orderform that corresponds to
 * the furniture items that are being purchased. It uses the furniture
 * category, type, and number, as well as the furniture ID of the used items
 * being purchased, and the overall purchase price.
 */
public class WriteText{
    private BufferedWriter writer;
    private String fileName = "orderform.txt";  //hardcoding filename
    private String category;
    private String type;
    private String number;
    private String[] itemIDs;
    private String price;
    private String output;

    public WriteText(String category, String type, String number, String[] itemIDs, String price){
        this.category = category;
        this.type = type;
        this.number = number;
        this.itemIDs = itemIDs;
        this.price = price;
    }

    public void writeOutput(){
        File out;   //declare a file object
        try{
            //instantiate file object with fileName
            out = new File(fileName);
            //instantiate a BufferedWriter object using the File object
            writer = new BufferedWriter(new FileWriter(out));
        }
        catch(IOException e){
            System.out.println("Error opening output file.");
            e.printStackTrace();
        }
        //format the output string
        formatOutput();

        try{
            //write the output string to the file
            writer.write(this.output);
        }
        catch(IOException e){
            System.out.println("Unable to write to output file.");
            e.printStackTrace();
        }
        finally{
            try{
                //try to close the file if the file was opened
                if(writer != null){
                    writer.close();
                }
            }
            catch(IOException e){
                //if file cannot be closed, exit
                System.out.println("Error closing output file.");
                e.printStackTrace();
            }
        }

    }

    private void formatOutput(){
        //format the string to contain the appropriate characters and newlines
        this.output = "";
        this.output = "Furniture Order Form\n";
        this.output += "\n";
        this.output += "Faculty Name:\n";
        this.output += "Contact:\n";
        this.output += "Date:\n";
        this.output += "\n";
        this.output +=  "Original Request: " + type + " " + category + ", " + number + "\n";
        this.output += "\n";
        this.output += "Items Ordered\n";
        //iterate through the itemIDs array and insert them into the string
        for(int i = 0; i < this.itemIDs.length; i++){
            this.output += "ID: ";
            this.output += this.itemIDs[i];
            this.output += "\n";
        }
        this.output += "\n";
        this.output += "Total Price: $" + price;
    }

}