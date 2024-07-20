import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Vinit Vala
 * SBU ID: 114501080
 * TreeDriver Class with runs the main method
 */

public class TreeDriver {


    public static void main(String[] args) {


        Scanner stdin=new Scanner(System.in);
        Tree newTree=new Tree();
        boolean validFile=false;

        int counter=0;

        boolean flag=false;

        while(counter==0){

            System.out.println("\nL - Load a Tree");
            System.out.println("H- Begin a Help Session");
            System.out.println("T- Traverse the Tree in preorder");
            System.out.println("Q- Quit");
            System.out.println("-----------------------------------\n");

            System.out.println("Please select an option");
            char userInput = stdin.next().charAt(0);
            stdin.nextLine();
            userInput = Character.toUpperCase(userInput);

            try{
                switch (userInput){

                    case 'L':{

                        System.out.println("Enter the filename:");
                        String filename=stdin.nextLine();
                        if(filename.length()<=20){
                        newTree.loadFromFile(filename);
                        validFile=true;
                        }
                        else
                            System.out.println("File Name should be smaller than 20 characters!");

                    }
                    break;

                    case 'H':{

                        if(validFile==true){
                            newTree.beginSession();
                        }
                        else
                            System.out.println("No file loaded! Enter a file first!");
                    }
                    break;

                    case 'T':{
                        System.out.println("Traversing the tree in preorder:");
                        if(validFile==true)
                        newTree.preOrder();
                        else
                            System.out.println("No file loaded! Enter a file first!");

                    }
                    break;

                    case 'Q':{
                        System.out.println("Thank you for using our automated help services!");
                        counter++;

                    }
                    break;

                    default:
                        System.out.println("Invalid input!");
                        break;

                }

            }catch (FileNotFoundException ee) {
                System.out.println("File not found!");
            } catch (EmptyNodeException ee) {
                System.out.println("The node is empty, or there is a hole in the array ");
            }
            catch (IllegalArgumentException ff){
                System.out.println("Error!");
            }

        }
    }
}
