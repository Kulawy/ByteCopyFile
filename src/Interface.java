import java.io.*;
import java.util.Scanner;

public class Interface {

    private String fileName;

    public Interface(){

    }

    private String inputName(){

        /*
        // NEXT WAY TO GET STRING FROM KEYBOARD
        DataInputStream dataInput = new DataInputStream(System.in);
        System.out.println("Enter a string");
        try{
            return dataInput.readLine();
        }catch (IOException e){
            System.out.println("something went wrong");
        }*/

        /*
        // NEXT WAY TO GET STRING FROM KEYBOARD
        String name;
        InputStreamReader inputReader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inputReader);

        System.out.println("Enter a string");
        try{
           name = br.readLine();
           return name;
        }catch (IOException e){
            System.out.println("something went wrong");
        }*/

        /*
        // NEXT WAY TO GET STRING FROM KEYBOARD
        Console c=System.console();
        System.out.println("Enter your name: ");
        String n=c.readLine();
        System.out.println("Welcome "+n);
        */

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a path:");
        return sc.next();

    }

    private String inputComand(){
        Scanner sc = new Scanner(System.in);
        System.out.print("$:");
        return sc.next();
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void aplicationRun(){

        String command = "run";
        //String name = inputName();


        while ( !command.equals("exit") ){

            System.out.println("Hi, this is program to copy your file");

            System.out.println("First enter your base file path: ");
            FileManager fm = new FileManager();
            String fileName = inputName();
            if ( !fm.loadFile(fileName) ){
                System.out.println("Can't find a file");
                System.out.println("Do you want to exit [y/n]");
                if (inputComand().toLowerCase().equals("y"))
                    command = "exit";
            }
            else {
                System.out.println("File have loaded");
                System.out.println("To copy file type: copy");
                System.out.println("To exit type : exit");
                command = inputComand().toLowerCase();
                if ( command.equals("copy")){
                    fm.createNewFile();
                    if ( fm.copyFile(fm.getBaseFile(), fm.getNewFile()) )
                        System.out.println("your file had copied");
                    else
                        System.out.println("Error");
                }
                System.out.println("Do you want to leave type exit");
                command = inputComand();
            }
        }
        System.out.println("\nGoodbye");
    }



}
