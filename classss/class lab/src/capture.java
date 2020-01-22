/**
 *
 * This class is a management systems allowing users to keep record of price and stock at essentials
 * @author Kelvin Kofi Edudzi Akakpo
 * @version 1.0
 */

import java.io.*;
import java.util.Scanner;

public class capture {
    private static String item;
    private static  float price;
    private static int quantity;





    public capture(String item, int quantity, float price) {
        this.item = item;
        this.price = price;
        this.quantity = quantity;
    }


    public String getItem(){return item; }
    public float getPrice(){return price;}
    public int getQuantity(){return quantity;}

   @Override
    public String toString(){
        String ItemDetails;
        ItemDetails = this.item +"  "+this.quantity+"  "+ "GHC"+ this.price;
        return ItemDetails;
   }

    /**
     * @throws FileNotFoundException
     */

    /**
     * Writing Text/String to File using PrintWriter and FileOutputStream
     * Checks for "FileNotFoundException" in the connection to the file
     */
    public void writefile() throws FileNotFoundException{
        PrintWriter printwriter = null;

        try{//Note that we are able to append to the file because of the "true" parameter
            printwriter = new PrintWriter(new FileOutputStream("essentials_stock.txt", true));
        }catch(FileNotFoundException fnfe) {
            fnfe.getMessage();
        }
        printwriter.print("item" + "  " + "Quantity" + "Price(cedis)");
        printwriter.println();

        printwriter.close();

        try{//Note that we are able to append to the file because of the "true" parameter
            printwriter = new PrintWriter(new FileOutputStream("backup_essentials_stock.txt", true));
        }catch(FileNotFoundException fnfe) {
            fnfe.getMessage();
        }
        printwriter.print("item" + "  " + "Quantity" + "  " + " Price(cedis)");
        printwriter.println();

        printwriter.close();

    }
    public void writetofile() throws FileNotFoundException {

        PrintWriter printWriter = null;

        try{
            //we can append the file due to the 'true' perimeter
            printWriter = new PrintWriter(new FileOutputStream("essentials_stock.txt", true));

        }catch(FileNotFoundException fnfe){
            fnfe.getMessage();
        }
        //gets the value and prints them in text file
        printWriter.print(getItem()+"  "+ getQuantity()+"  "+getPrice());
        printWriter.println();

        //Close writer
        printWriter.close();


        try{
            //we can append the file due to the 'true' perimeter
            printWriter = new PrintWriter(new FileOutputStream("backup_essentials_stock.txt", true));

        }catch(FileNotFoundException fnfe){
            fnfe.getMessage();
        }
        //gets the value and prints them in text file
        printWriter.print(getItem()+"  "+ getQuantity()+"  "+getPrice());
        printWriter.println();

        //Closes writer
        printWriter.close();
    }

    public static void Buys(){
        Scanner stock = new Scanner(System.in);
        System.out.print("Enter item in stock: ");

        String item = stock.next();

        System.out.println("enter quantity ");
        int qty = stock.nextInt();

        System.out.println("Enter price: ");
        float price = stock.nextFloat();


        capture shop = new capture(item, qty, price);

        try{
            shop.writetofile();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void read() throws FileNotFoundException{
        File file= new File("Essentials_stock.txt");
        Scanner read = new Scanner(file);
        while(read.hasNext()){
            System.out.println(read.nextLine());
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("How many are items are you stocking?: ");
        Scanner number = new Scanner(System.in);
        int num= number.nextInt();
        capture shop = new capture(item, quantity, price);
        shop.writefile();
        for (int i = 0; i < num ; i++) {
            Buys();
        }
    }

}
