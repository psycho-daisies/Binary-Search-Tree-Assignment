public class TreeNode {
  // Class for storing a single node of a binary tree

  Entry entry;
  TreeNode left;
  TreeNode right;

  // constructs a leaf node with given data

  public TreeNode(Entry entry) {
    this(entry, null, null);
  }

  // constructs a branch node with given data, left subtree,
  // right subtree
  public TreeNode(Entry entry, TreeNode left,
                  TreeNode right) {
    this.entry = entry;
    this.left = left;
    this.right = right;
  }

  public Entry getEntry() {
    return entry;
  }

  public TreeNode getLeft() {
    return left;
  }

  public TreeNode getRight() {
    return right;
  }

  public void setRight(TreeNode right) {
    this.right = right;
  }

  public void setLeft(TreeNode left) {
    this.left = left;
  }
}
