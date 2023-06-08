// Assignment: Binary Search Tree
// Authors: Troy Brunette

// This program constructs a data structure called Binary Search Tree
// that contain Entry objects (a person) with a name, phone number, and address.
// A Binary Search tree organizes elements in a tree-like structure.
// For each node, the elements in it's left subtree must be less than
// and the elements in the right subtree are greater.
// A BST is efficient at searching, insertion, and deletion operations.

public class BinarySearchTree {
  private TreeNode overallRoot;
  private int size;

  // constructs an empty tree
  public BinarySearchTree() {
    size = 0;
    overallRoot = null;
  }

  // value is added to overall tree so as to preserve the
  // binary search tree property
  public void add(Entry entry) {
    size++;
    overallRoot = add(overallRoot, entry);
  }

  // value is added to given tree so as to preserve the
  // binary search tree property
  private TreeNode add(TreeNode node, Entry entry) {
    size++;
    if (node == null) {
      node = new TreeNode(entry);
    } else if (entry.getName().compareToIgnoreCase(node.entry.getName()) < 0) {
      node.left = add(node.left, entry);
    } else if (entry.getName().compareToIgnoreCase(node.entry.getName()) > 0){
      node.right = add(node.right, entry);
    }
    return node;
  }

  // returns true if overall tree contains value
  public boolean contains(Entry entry) {
    return contains(overallRoot, entry);
  }

  // returns true if given tree contains value
  private boolean contains(TreeNode root, Entry entry) {
    if (root == null) {
      return false;
    } else if (entry.getName().equalsIgnoreCase(root.entry.getName())) {
      return true;
    } else if (entry.getName().compareToIgnoreCase(root.entry.getName()) < 0) {
      return contains(root.left, entry);
    } else {  // value > root.data
      return contains(root.right, entry);
    }
  }

  public boolean contains(String name) {
    return contains(overallRoot, name);
  }

  // returns true if given tree contains value
  private boolean contains(TreeNode root, String name) {
    if (root == null) {
      return false;
    } else if (name.equalsIgnoreCase(root.entry.getName()) || name.equalsIgnoreCase(root.entry.getFirstName())) {
      return true;
    } else if (name.compareToIgnoreCase(root.entry.getName()) < 0) {
      return contains(root.left, name);
    } else {  // value > root.data
      return contains(root.right, name);
    }
  }

  // public / private pair of methods:
  // returns: public method returns the result of
  // of invoking the private method with the overall root
  public int countLevels() {
    return countLevels(overallRoot);
  }
  private int countLevels(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      return 1 + Math.max(countLevels(root.left), countLevels(root.right));
    }
  }

  // public / private pair of methods:
  // returns: public method returns the result of
  // of invoking the private method with the overall root
  public int countLeaves() {
    return countLeaves(overallRoot);
  }
  private int countLeaves(TreeNode root) {
    if (root == null) {
      return 0;
    } else if (root.left == null && root.right == null) {
      return 1;
    } else {
      return countLeaves(root.left) + countLeaves(root.right);
    }
  }

  public int size() {
    return size;
  }

  // Returns the minimum value from this BST.
  // Throws a NoSuchElementException if the tree is empty.
  private String getMin(TreeNode root) {
    if (root.left == null) {
      return root.entry.getName();
    } else {
      return getMin(root.left);
    }
  }

  // Returns the minimum value from this BST.
  private Entry getMinEntry(TreeNode root) {
    if (root.left == null) {
      return root.entry;
    } else {
      return getMinEntry(root.left);
    }
  }

  // Removes the given value from this BST, if it exists.
  public void remove(String value) {
    size--;
    overallRoot = remove(overallRoot, value);
  }

  /*
  Returns:
  a negative integer, zero, or a positive integer as the specified String is
  greater than, equal to, or less than this String,
  ignoring case considerations
   */
  private TreeNode remove(TreeNode root, String value) {
    if (root == null) {
      return null;
    } else if (root.entry.getFirstName().compareToIgnoreCase(value) > 0) {
      root.left = remove(root.left, value);
    } else if (root.entry.getFirstName().compareToIgnoreCase(value) < 0) {
      root.right = remove(root.right, value);
    } else {  // root.data == value; remove this node
      if (root.right == null) {
        return root.left;    // no R child; replace w/ L
      } else if (root.left == null) {
        return root.right;   // no L child; replace w/ R
      } else {
        // both children; replace w/ min from R
        root.entry = new Entry(getMinEntry(root.right));
        root.right = remove(root.right, root.entry.getFirstName());
      }
    }
    return root;
  }

  // prints the tree contents using an inorder traversal
  public void print() {
    printInorder(overallRoot);
    System.out.println();
  }

  public void printEntry() {
    printEntryInOrder(overallRoot);
    System.out.println();
  }

  private void printEntryInOrder(TreeNode root) {
    if (root != null) {
      printEntryInOrder(root.left);
      System.out.println(root.entry.getName() + " " + root.entry.getPhoneNumber() + " ");
      printEntryInOrder(root.right);
    }
  }

  // prints contents of the tree with given root using an inorder traversal
  private void printInorder(TreeNode root) {
    if (root != null) {
      printInorder(root.left);
      System.out.println(root.entry.getName() + " ");
      printInorder(root.right);
    }
  }

  // prints the tree contents, one per line, following an
  // inorder traversal and using indentation to indicate
  // node depth; prints right to left so that it looks
  // correct when the output is rotated.
  public void printSideways() {
    printSideways(overallRoot, 0);
  }

  // prints in reversed preorder the tree with given
  // root, indenting each line to the given level
  private void printSideways(TreeNode root, int level) {
    if (root != null) {
      printSideways(root.right, level + 1);
      for (int i = 0; i < level; i++) {
        System.out.print("    ");
      }
      System.out.println(root.entry.getName());
      printSideways(root.left, level + 1);
    }
  }
}
