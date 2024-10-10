import java.util.*;

public class a8_height_and_depth_of_tree {
    public class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    Scanner sc = new Scanner(System.in);
    private Node root;

    // Constructor to initialize the tree
    public a8_height_and_depth_of_tree() {
        this.root = Create_Tree(null);
    }

    // Create tree based on user input
    private Node Create_Tree(Node parent) {
        int item = sc.nextInt();  
        Node nn = new Node(item);

        boolean hlc = sc.nextBoolean(); 
        if (hlc) {
            nn.left = Create_Tree(nn);
        }

        boolean hrc = sc.nextBoolean(); 
        if (hrc) {
            nn.right = Create_Tree(nn);
        }

        return nn;
    }

    // DFS-based method to calculate the height and depth of a specific node
    public void dfsHeightAndDepth(Node root, int value, int currentDepth, Result result) {
        if (root == null) {
            return;
        }

        if (root.data == value) {
            // Found the node, set its depth
            result.depth = currentDepth;
            // Calculate height from this node
            result.height = calculateHeight(root);
        }

        // Continue DFS in left and right subtrees
        dfsHeightAndDepth(root.left, value, currentDepth + 1, result);
        dfsHeightAndDepth(root.right, value, currentDepth + 1, result);
    }

    // Method to calculate the height of the tree (DFS logic)
    private int calculateHeight(Node root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // A utility class to hold the height and depth of the node
    class Result {
        int height = -1;
        int depth = -1;
    }

    public static void main(String[] args) {
        a8_height_and_depth_of_tree tree = new a8_height_and_depth_of_tree();

        Scanner input = new Scanner(System.in);

        // Input the node value for which height and depth are to be calculated
        System.out.println("Enter the node value for which you want to calculate height and depth:");
        int value = input.nextInt();

        // Create a result object to store height and depth
        Result result = tree.new Result();

        // Perform DFS to calculate height and depth
        tree.dfsHeightAndDepth(tree.root, value, 0, result);

        // Output the results
        if (result.depth != -1) {
            System.out.println("Height of node " + value + ": " + result.height);
            System.out.println("Depth of node " + value + ": " + result.depth);
        } else {
            System.out.println("Node with value " + value + " not found.");
        }

        input.close();
    }
}
