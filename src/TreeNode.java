/**
 * @author Vinit Vala
 * SBU ID: 114501080
 * TreeNode Class
 */
public class TreeNode {


    private TreeNode left;
    private TreeNode right;
    private TreeNode middle;
    private TreeNode parent;

    public TreeNode object;

    private TreeNode children[];
    final int maxChildren=9;

    private String label;
    private String parentLabel;

    private String message;

    private String prompt;

    /**
     * Default Constructor
     */
    public TreeNode(){
        this.label="";
        this.message="";
        this.prompt="";
        children=new TreeNode[maxChildren];
    }

    /**
     * Constructor
     * @param obj
     */
    public TreeNode(TreeNode obj){
        this.object=obj;
    }

    /**
     * Parameterized Constructor
     * @param label
     * @param prompt
     * @param message
     * @param parentLabel
     */
    public TreeNode(String label, String prompt, String message, String parentLabel){  //put String parentName in here
        this.label=label;
        this.message=message;
        this.prompt=prompt;
        this.parentLabel=parentLabel;
        children=new TreeNode[maxChildren];
    }

    /**
     * Method to check if leaf
     * @param node
     * @return boolean
     */
    public boolean isLeaf(TreeNode node){

        if(node.getMiddle()==null && node.getLeft()==null && node.getRight()== null){
            return true;
        }else return false;
    }

    /**
     * Accessor method for Max Children
     * @return int
     */
    public int getMaxChildren() {
        return maxChildren;
    }

    /**
     * Accessor method for Label
     * @return String
     */
    public String getLabel() {
        return label;
    }

    /**
     * Accessor method for message
     * @return string
     */
    public String getMessage() {
        return message;
    }

    /**
     * Accessor method for prompt
     * @return string
     */
    public String getPrompt() {
        return prompt;
    }

    /**
     * Accessor method for  children
     * @return array
     */
    public TreeNode[] getChildren(){
        return children;
    }

    /**
     * Accessor method for parent
     * @return TreeNode
     */
    public TreeNode getParent() {
        return parent;
    }

    /**
     * Accessor method for left
     * @return
     */
    public TreeNode getLeft() {
        return left;
    }

    /**
     * Accessor method for middle
     * @return
     */
    public TreeNode getMiddle() {
        return middle;
    }

    /**
     * Accessor method for Right
     * @return
     */
    public TreeNode getRight() {
        return right;
    }

    /**
     * Accessor method for Parent Label
     * @return
     */
    public String getParentLabel() {
        return parentLabel;
    }

    /**
     * Mutator method for left
     * @param left
     */
    public void setLeft(TreeNode left) {
        this.left = left;
    }

    /**
     * Mutator method for middle
     * @param middle
     */
    public void setMiddle(TreeNode middle) {
        this.middle = middle;
    }

    /**
     * Mutator method for right
     * @param right
     */
    public void setRight(TreeNode right) {
        this.right = right;
    }

    /**
     * Mutator method for parentLabel
     * @param parentLabel
     */
    public void setParentLabel(String parentLabel) {
        this.parentLabel = parentLabel;
    }

    /**
     * Mutator method for children
     * @param children
     */
    public void setChildren(TreeNode[] children) {
        this.children = children;
    }

    /**
     * Mutator method for  label
     * @param label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Mutator method for message
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Mutator method for prompt
     * @param prompt
     */
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    /**
     * Mutator method for parent
     * @param parent
     */
    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    /**
     * ToString method
     * @return String
     */
    public String toString() {
        return "label='" + label + '\'' +
                ", message='" + message + '\'' +
                ", prompt='" + prompt + '\'' +
                '}';
    }
}
