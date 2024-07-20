import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * @author Vinit Vala
 * SBU ID: 114501080
 * Tree Class
 */


public class Tree {

    //newNode=new1
    //node=new2
    Tree node;   //tree new2
    public TreeNode root;
    private TreeNode cursor;

    /**
     * Default constructor
     */
    public Tree() {
        root = null;
        cursor = null;
    }

    /**
     * Accessor method for cursor
     * @return
     */
    public TreeNode getCursor() {
        return cursor;
    }

    /**
     * Accessor method for root
     * @return
     */
    public TreeNode getRoot() {
        return root;
    }

    /**
     * Mutator method for cursor
     * @param cursor
     */
    public void setCursor(TreeNode cursor) {
        this.cursor = cursor;
    }

    /**
     * Mutator method for root
     * @param root
     */
    public void setRoot(TreeNode root) {
        this.root = root;
    }

    /**
     * Method to add node
     * @param label
     * @param prompt
     * @param message
     * @param parentLabel
     * @return boolean
     */
    public boolean addNode(String label, String prompt, String message, String parentLabel) {

        TreeNode newNode = new TreeNode(label, prompt, message, parentLabel);  //newNode=new1
        TreeNode node = new TreeNode(newNode);                               //node= new2

        if (root == null) {
            root = node;
        } else {
            if (root.getLeft() == null) {
                root.setLeft(node);
                return true;
            } else if (root.getLeft() != null && root.getMiddle() == null) {
                root.setMiddle(node);
                return true;
            } else if (root.getLeft() != null && root.getMiddle() != null && root.getRight() == null) {
                root.setRight(node);
                return true;
            }
        }

        return false;
    }

    /**
     * Method to add node at lcoation in array
     * @param numArray
     * @param newNode
     * @return
     * @throws EmptyNodeException
     */
    public boolean addAtNode(int[] numArray, TreeNode newNode) throws EmptyNodeException {  //is addAtN

        if(newNode==null){
            throw new EmptyNodeException("The node is empty");
        }
        TreeNode node = new TreeNode(newNode);
        int arraySize = numArray.length;

        TreeNode cursor = root;
        int j = 0;

        while (j < arraySize && cursor != null) {
            int i = numArray[j];

            if (i == 1) {
                if (j == arraySize - 1)
                    cursor.setLeft(node);
                else
                    cursor = cursor.getLeft();
            } else if (i == 2) {
                if (j == arraySize - 1)
                    cursor.setMiddle(node);
                else
                    cursor = cursor.getMiddle();
            } else if (i == 3) {
                if (j == arraySize - 1)
                    cursor.setRight(node);
                else
                    cursor = cursor.getRight();
            }
            j++;
        }
        return true;

    }

    /**
     * Method to turn the String Location into an Array
     * @param location String
     * @return int array
     */

    public int[] getLocation(String location) {

        int length = location.length();
        int c = 0;
        int n = 0;
        String ss = "";

        for (int i = 0; i < length; i++) {
            if (location.charAt(i) != '-') {
                ss += location.charAt(i);
            }
        }

        int[] addArray1 = new int[ss.length()];
        int[] addArray2 = new int[ss.length()];

        int num2 = Integer.parseInt(ss);

        while (num2 > 0) {

            int num4 = num2 % 10;
            addArray1[c] = num4;

            num2 = num2 / 10;
            c++;
        }

        for (int k = addArray1.length - 1; k >= 0; k--) {

            addArray2[n] = addArray1[k];
            n++;
        }
        return addArray2;

    }

    /**
     * Preorder method
     * @throws EmptyNodeException
     */
    public void preOrder() throws EmptyNodeException {
        preOrder(this.node.getRoot());
    }

    /**
     * Method to get Node reference
     * @param label
     * @return TreeNode
     * @throws EmptyNodeException
     */
    public TreeNode getNodeReference(String label) throws EmptyNodeException {

        cursor=root;
        TreeNode cursor2=null;
        preOrderTrav(cursor,label,cursor2);

        TreeNode numCursor=cursor;
        if(cursor!=null)
            return numCursor;
        else
            return null;
    }

    /**
     * Method to set Cursor
     * @param node
     */
    public void setNumCursor(TreeNode node){
        this.cursor=node;
    }

    /**
     * Preorder traversal method
     * @param cursor
     * @throws EmptyNodeException
     */
    public void preOrder(TreeNode cursor) throws EmptyNodeException {

        if (cursor == null) {
            throw new EmptyNodeException("The node is empty");
        } else if (cursor.getLeft() == null) {
            System.out.println("Label: " + cursor.object.getLabel());
            System.out.println("Prompt: " + cursor.object.getPrompt());
            System.out.println("Message: " + cursor.object.getMessage());
        } else {
            if (cursor != null) {
                System.out.println("Label: " + cursor.object.getLabel());
                System.out.println("Prompt: " + cursor.object.getPrompt());
                System.out.println("Message: " + cursor.object.getMessage());
                preOrder(cursor.getLeft());
                preOrder(cursor.getMiddle());
                preOrder(cursor.getRight());
            }
        }
    }

    /**
     * Preorder traversal method 2
     * @param cursor
     * @param label
     * @param cursor2
     * @throws EmptyNodeException
     */
    public void preOrderTrav(TreeNode cursor,String label,TreeNode cursor2) throws EmptyNodeException {

        if(cursor==null) {
            throw new EmptyNodeException("The node is empty");
        }
        else if(cursor.getLabel().compareTo(label)==0){
            cursor2=cursor.object;
            setNumCursor(cursor2);
        }
        else{
            if(cursor!=null){
                preOrderTrav(cursor.getLeft(),label,cursor2);
                preOrderTrav(cursor.getMiddle(),label,cursor2);
                preOrderTrav(cursor.getRight(),label,cursor2);
                if(cursor.getLabel().compareTo(label)==0)
                    cursor2=cursor.object;
            }
        }
    }

    /**
     * Method to load from file
     * @param filename
     * @throws FileNotFoundException
     * @throws EmptyNodeException
     */
    public void loadFromFile(String filename) throws FileNotFoundException, EmptyNodeException {

        if(filename==null){
            throw new FileNotFoundException("File not found");  //Handle the exception properly
        }
        File file=new File(filename);

        Scanner stdin=new Scanner(file);
        String line;
        String line3;
        String line4;
        int i=0;

        Tree newNode=new Tree();
        this.node=new Tree();

        while(i<4){
            line= stdin.nextLine();
            line=line.trim();

            if(line.compareTo("root 3")==0){
                //continue;
            }
            line3=stdin.nextLine();
            line3=line3.trim();
            line4= stdin.nextLine();
            line4=line4.trim();

            newNode.addNode(line,line3,line4,line);
            this.node.addNode(line,line3,line4,line);
            i++;
        }

        while(stdin.hasNextLine()) {

            line = stdin.nextLine();
            if (line != null) {
                line = line.trim();
                if (!containsSpace(line)){
                }
                else{

                    int []numArray= newNode.getLocation(line);
                    int []numArray2= this.node.getLocation(line);

                    line3=stdin.nextLine();
                    line3=line3.trim();

                    line4=stdin.nextLine();
                    line4=line4.trim();

                    TreeNode new4Node= new TreeNode(line,line3,line4,line);
                    newNode.addAtNode(numArray,new4Node);
                    this.node.addAtNode(numArray2,new4Node);
                }

            }
            else
                break;
        }
        stdin.close();
    }

    /**
     * Begin Session method which runs the simulation
     */
    public void beginSession(){

        //Tree cursor=node;
       // cursor.setCursor(root);

        cursor=this.node.getRoot();
        TreeNode node= root;
        TreeNode leftNode= root;
        TreeNode middleNode= root;
        TreeNode rightNode= root;
        Scanner stdin= new Scanner(System.in);
        boolean flag=true;

        System.out.println("Help session starting....");
//        System.out.println(root.getMessage());
        System.out.println( cursor.object.getMessage()); //getPrompt
        System.out.println("1 "+cursor.getLeft().object.getMessage());
        leftNode=cursor.getLeft();

        System.out.println("2 "+cursor.getMiddle().object.getMessage());
        middleNode=cursor.getMiddle();

        System.out.println("3 "+cursor.getRight().object.getMessage());
        rightNode=cursor.getRight();

        System.out.println("0 "+"Exit Session");
        System.out.println("4 "+"Go Back            ");

        System.out.print("Choice> ");
        int userInput=stdin.nextInt();
        cursor=this.node.getRoot();

        while(flag){

            switch (userInput){

                case 0:
                    System.out.println("Exited Help Session\n\n");
                    break;

                case 1: {

                    cursor = cursor.getLeft(); //node.object.getLeft();
//                    if (node.isLeaf(node)) {
//                        System.out.println(node.object.getMessage());
//                        flag = false;
//                        break;
//                    }
                    if(cursor.getLeft()==null && cursor.getMiddle()==null && cursor.getRight()==null) {
                            System.out.println(cursor.object.getMessage());
                            flag=false;
                            break;
                    }

                    else if (cursor.getLeft() != null && cursor.getMiddle() != null && cursor.getRight() != null) {

                        System.out.println("" + cursor.object.getMessage());  //leftNode.obj.getM
                        System.out.println("1 " + cursor.getLeft().object.getPrompt()); // getPrompt
                        leftNode = cursor.getLeft();

                        System.out.println("2 " + cursor.getMiddle().object.getPrompt());
                        middleNode = cursor.getMiddle();

                        System.out.println("3 " + cursor.getRight().object.getPrompt());
                        rightNode = cursor.getRight();

                        System.out.println("0 Exit Session");

                        System.out.print("Choice> ");
                        userInput = stdin.nextInt();
                        flag = true;
                    }
                    else if (cursor.getLeft() == null && cursor.getMiddle() != null && cursor.getRight() != null) {

                        System.out.println(" " + leftNode.object.getMessage());

                        System.out.println("2 " + cursor.getMiddle().object.getPrompt());
                        middleNode = cursor.getMiddle();

                        System.out.println("3 " + cursor.getRight().object.getPrompt());
                        rightNode = cursor.getRight();

                        System.out.println("0 Exit Session");

                        System.out.print("Choice> ");
                        userInput = stdin.nextInt();
                        flag = true;
                    }
                    else if (cursor.getLeft() != null && cursor.getMiddle() == null && cursor.getRight() != null) {

                        System.out.println(" " + leftNode.object.getMessage());
                        System.out.println("1 " + cursor.getLeft().object.getPrompt());
                        leftNode = cursor.getLeft();

                        System.out.println("3 " + cursor.getRight().object.getPrompt());
                        rightNode = cursor.getRight();

                        System.out.println("0 Exit Session");

                        System.out.print("Choice> ");
                        userInput = stdin.nextInt();
                        flag = true;
                    }
                    else if (cursor.getLeft() != null && cursor.getMiddle() != null && cursor.getRight() == null) {

                        System.out.println(" " + leftNode.object.getMessage());
                        System.out.println("1 " + cursor.getLeft().object.getPrompt());
                        leftNode = cursor.getLeft();

                        System.out.println("2 " + cursor.getMiddle().object.getPrompt());
                        middleNode = cursor.getMiddle();

                        System.out.println("0 Exit Session");

                        System.out.print("Choice> ");
                        userInput = stdin.nextInt();
                        flag = true;
                    }

                }
                break;

                case 2:{

                    cursor = cursor.getMiddle(); //node.object.getLeft();
//                    if (node.isLeaf(node)) {
//                        System.out.println(node.object.getMessage());
//                        flag = false;
//                        break;
//                    }
                    if(cursor.getLeft()==null && cursor.getMiddle()==null && cursor.getRight()==null) {
                        System.out.println(cursor.object.getMessage());
                        flag=false;
                        break;
                    }

                    else if (cursor.getLeft() != null && cursor.getMiddle() != null && cursor.getRight() != null) {

                        System.out.println("" + cursor.object.getMessage());  //leftNode.obj.getM
                        System.out.println("1 " + cursor.getLeft().object.getPrompt()); // getPrompt
                        leftNode = cursor.getLeft();

                        System.out.println("2 " + cursor.getMiddle().object.getPrompt());
                        middleNode = cursor.getMiddle();

                        System.out.println("3 " + cursor.getRight().object.getPrompt());
                        rightNode = cursor.getRight();

                        System.out.println("0 Exit Session");

                        System.out.print("Choice> ");
                        userInput = stdin.nextInt();
                        flag = true;
                    }
                    else if (cursor.getLeft() == null && cursor.getMiddle() != null && cursor.getRight() != null) {

                        System.out.println(" " + leftNode.object.getMessage());

                        System.out.println("2 " + cursor.getMiddle().object.getPrompt());
                        middleNode = cursor.getMiddle();

                        System.out.println("3 " + cursor.getRight().object.getPrompt());
                        rightNode = cursor.getRight();

                        System.out.println("0 Exit Session");

                        System.out.print("Choice> ");
                        userInput = stdin.nextInt();
                        flag = true;
                    }
                    else if (cursor.getLeft() != null && cursor.getMiddle() == null && cursor.getRight() != null) {

                        System.out.println(" " + leftNode.object.getMessage());
                        System.out.println("1 " + cursor.getLeft().object.getPrompt());
                        leftNode = cursor.getLeft();

                        System.out.println("3 " + cursor.getRight().object.getPrompt());
                        rightNode = cursor.getRight();

                        System.out.println("0 Exit Session");

                        System.out.print("Choice> ");
                        userInput = stdin.nextInt();
                        flag = true;
                    }
                    else if (cursor.getLeft() != null && cursor.getMiddle() != null && cursor.getRight() == null) {

                        System.out.println(" " + leftNode.object.getMessage());
                        System.out.println("1 " + cursor.getLeft().object.getPrompt());
                        leftNode = cursor.getLeft();

                        System.out.println("2 " + cursor.getMiddle().object.getPrompt());
                        middleNode = cursor.getMiddle();

                        System.out.println("0 Exit Session");

                        System.out.print("Choice> ");
                        userInput = stdin.nextInt();
                        flag = true;
                    }

                }
                break;

                case 3:{

                    cursor = cursor.getRight(); //node.object.getLeft();
//                    if (node.isLeaf(node)) {
//                        System.out.println(node.object.getMessage());
//                        flag = false;
//                        break;
//                    }
                    if(cursor.getLeft()==null && cursor.getMiddle()==null && cursor.getRight()==null) {
                        System.out.println(cursor.object.getMessage());
                        flag=false;
                        break;
                    }

                    else if (cursor.getLeft() != null && cursor.getMiddle() != null && cursor.getRight() != null) {

                        System.out.println("" + cursor.object.getMessage());  //leftNode.obj.getM
                        System.out.println("1 " + cursor.getLeft().object.getPrompt()); // getPrompt
                        leftNode = cursor.getLeft();

                        System.out.println("2 " + cursor.getMiddle().object.getPrompt());
                        middleNode = cursor.getMiddle();

                        System.out.println("3 " + cursor.getRight().object.getPrompt());
                        rightNode = cursor.getRight();

                        System.out.println("0 Exit Session");

                        System.out.print("Choice> ");
                        userInput = stdin.nextInt();
                        flag = true;
                    }
                    else if (cursor.getLeft() == null && cursor.getMiddle() != null && cursor.getRight() != null) {

                        System.out.println(" " + leftNode.object.getMessage());

                        System.out.println("2 " + cursor.getMiddle().object.getPrompt());
                        middleNode = cursor.getMiddle();

                        System.out.println("3 " + cursor.getRight().object.getPrompt());
                        rightNode = cursor.getRight();

                        System.out.println("0 Exit Session");

                        System.out.print("Choice> ");
                        userInput = stdin.nextInt();
                        flag = true;
                    }
                    else if (cursor.getLeft() != null && cursor.getMiddle() == null && cursor.getRight() != null) {

                        System.out.println(" " + leftNode.object.getMessage());
                        System.out.println("1 " + cursor.getLeft().object.getPrompt());
                        leftNode = cursor.getLeft();

                        System.out.println("3 " + cursor.getRight().object.getPrompt());
                        rightNode = cursor.getRight();

                        System.out.println("0 Exit Session");

                        System.out.print("Choice> ");
                        userInput = stdin.nextInt();
                        flag = true;
                    }
                    else if (cursor.getLeft() != null && cursor.getMiddle() != null && cursor.getRight() == null) {

                        System.out.println(" " + leftNode.object.getMessage());
                        System.out.println("1 " + cursor.getLeft().object.getPrompt());
                        leftNode = cursor.getLeft();

                        System.out.println("2 " + cursor.getMiddle().object.getPrompt());
                        middleNode = cursor.getMiddle();

                        System.out.println("0 Exit Session");

                        System.out.print("Choice> ");
                        userInput = stdin.nextInt();
                        flag = true;
                    }

                }
                break;

                case 4:{

                    if(node!=root) {
                        cursor=cursor.getParent();
                    }

                    if(cursor.getLeft()==null && cursor.getMiddle()==null && cursor.getRight()==null) {
                        System.out.println(cursor.object.getMessage());
                        flag=false;
                        break;
                    }

                    else if (cursor.getLeft() != null && cursor.getMiddle() != null && cursor.getRight() != null) {

                        System.out.println("" + cursor.object.getMessage());  //leftNode.obj.getM
                        System.out.println("1 " + cursor.getLeft().object.getMessage()); // getPrompt
                        leftNode = cursor.getLeft();

                        System.out.println("2 " + cursor.getMiddle().object.getPrompt());
                        middleNode = cursor.getMiddle();

                        System.out.println("3 " + cursor.getRight().object.getPrompt());
                        rightNode = cursor.getRight();

                        System.out.println("0 Exit Session");

                        System.out.print("Choice> ");
                        userInput = stdin.nextInt();
                        flag = true;
                    }
                    else if (cursor.getLeft() == null && cursor.getMiddle() != null && cursor.getRight() != null) {

                        System.out.println(" " + leftNode.object.getMessage());

                        System.out.println("2 " + cursor.getMiddle().object.getPrompt());
                        middleNode = cursor.getMiddle();

                        System.out.println("3 " + cursor.getRight().object.getPrompt());
                        rightNode = cursor.getRight();

                        System.out.println("0 Exit Session");

                        System.out.print("Choice> ");
                        userInput = stdin.nextInt();
                        flag = true;
                    }
                    else if (cursor.getLeft() != null && cursor.getMiddle() == null && cursor.getRight() != null) {

                        System.out.println(" " + leftNode.object.getMessage());
                        System.out.println("1 " + cursor.getLeft().object.getPrompt());
                        leftNode = cursor.getLeft();

                        System.out.println("3 " + cursor.getRight().object.getPrompt());
                        rightNode = cursor.getRight();

                        System.out.println("0 Exit Session");

                        System.out.print("Choice> ");
                        userInput = stdin.nextInt();
                        flag = true;
                    }
                    else if (cursor.getLeft() != null && cursor.getMiddle() != null && cursor.getRight() == null) {

                        System.out.println(" " + leftNode.object.getMessage());
                        System.out.println("1 " + cursor.getLeft().object.getPrompt());
                        leftNode = cursor.getLeft();

                        System.out.println("2 " + cursor.getMiddle().object.getPrompt());
                        middleNode = cursor.getMiddle();

                        System.out.println("0 Exit Session");

                        System.out.print("Choice> ");
                        userInput = stdin.nextInt();
                        flag = true;
                    }
                }
                break;

                default:
                    System.out.println("Invalid choice! TRY AGAIN!\n");
                    break;

            }
        }

    }

    /**
     * Method to check for spaces
     * @param str
     * @return
     */
    public static boolean containsSpace(String str){

        int size=str.length();
        boolean choice= true;

        for(int i=0;i<size;i++){
            if(Character.isWhitespace(str.charAt(i))){ //str.charAt(i)==' '
                choice=false;
                break;
            }
        }
        return choice;

    }

}

