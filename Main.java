// Assignment: Binary Search Tree
// Authors: Troy Brunette
// This program tests the BinarySearchTree class by constructing a
// binary search tree with elements with a name and phone number
// Printing its contents and its structure.
public class Main {
    public static void main(String[] args) {
        // can add to tree, check if it contains a value, print the tree,
        // and remove an entry from the tree
        BinarySearchTree tree = new BinarySearchTree();

        tree.add(new Entry("John", "3603204344"));
        tree.add(new Entry("David", "3603204349"));
        tree.add(new Entry("Chris", "3603204313"));
        tree.add(new Entry("Alex", "3603204343"));
        tree.add(new Entry("Laura", "3603204347"));
        tree.add(new Entry("Sara", "3603204345"));
        tree.add(new Entry("Tom", "3603204348"));
        tree.add(new Entry("Peter", "3603204343"));

        System.out.println();
        System.out.println("Tree Structure:");
        tree.printSideways();
        System.out.println("Sorted list:");
        tree.print();

        // returns true that "Alex" is in the tree
        System.out.println(tree.contains("Alex"));

        tree.remove("Alex");
        // returns false since "Alex" was removed from the tree
        System.out.println(tree.contains("Alex"));
        tree.print();

        // counts the number of levels and leaves in the tree
        System.out.println("tree levels: " + tree.countLevels());
        System.out.println("leaves: " + tree.countLeaves());
    }
}
