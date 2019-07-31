//***********************************************************************************
// BalancedBinaryTrees.java
//
//  James Behnke
//COMP 2231 Assignment 4 Question 2
// This application prompts users to enter integer digits in an unordered sequence,
// then returns the ordered and balanced binary tree.
//***********************************************************************************

import java.util.ArrayList;
import java.util.Scanner;

class BinaryTree{

    Node root;

    public void addNode(int key)
    {
        Node newNode = new Node(key);
        System.out.println(key + " was added");
        if(root == null)
            root = newNode;
        else{
            Node focusNode = root;

            Node parent;

            while(true){
                parent = focusNode;
                //if the new element is less than the parent node, add the node to the left side.
                if (key < focusNode.key){
                    focusNode = focusNode.leftChild;

                    if (focusNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                    // otherwise the element is greater, so insert to left side
                } else {
                    focusNode = focusNode.rightChild;

                    if (focusNode == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }

            }
        }

    }

    public ArrayList inOrderCopyToArray(Node focusNode, ArrayList list)
    {
        /* return null if an empty list was passed in */
        if (focusNode == null) {
            return list;
        }

        inOrderCopyToArray(focusNode.leftChild, list);


        //add element to list
        list.add(focusNode.key);

        inOrderCopyToArray(focusNode.rightChild, list);


        return list;
    }

      public void inOrderTraverseTree(Node focusNode)
      {
        if (focusNode != null)
        {
            //traverse left side of tree first
            inOrderTraverseTree(focusNode.leftChild);
            //print the focusNode
            System.out.println(focusNode);
                //secondly traverse right side
            inOrderTraverseTree(focusNode.rightChild);

        }
    }
    public void preOrderTraverseTree(Node focusNode)
    {
        if (focusNode != null){
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.leftChild);

            inOrderTraverseTree(focusNode.rightChild);

        }
    }


    public void printInorder(Node node)
    {
        if (node == null)
            return;

        /* first recursively traverse on left child */
        printInorder(node.leftChild);

        /* then print the data of node */
        System.out.print(node.key + " ");

        /* then recursively traverse on right child */
        printInorder(node.rightChild);
    }

    public void printPreOrder(Node node)
    {
        if (node == null)
            return;
        /* first print data of node */
        System.out.print(node.key + " ");

        /* then recur on left sutree */
        printPreOrder(node.leftChild);

        /* now recur on right subtree */
        printPreOrder(node.rightChild);
    }

    public int getHeight(Node root)
    {
        if (root == null)
            return 0;
        else {
            int leftHeight = getHeight(root.leftChild);
            int rightHeight = getHeight(root.rightChild);

            //get the larger value
           return Math.max(leftHeight+1, rightHeight+1);
        }
    }

    public void printByLevel(Node root, int level)
    {
        if (root == null)
            return;
        if (level==1)
            System.out.println(root.key);
        else if (level > 1){
            printByLevel(root.leftChild, level-1);
            printByLevel(root.rightChild, level -1);
        }
    }

    public void printByLeveledOrder()
    {
        int height = getHeight(root);
        for (int i = 1; i <= height; i++){
            printByLevel(root, i);
        }
    }

    public Node insertToLevelOrder(ArrayList<Integer> arrayList, Node root, int i)
    {
        if (i < arrayList.size()){

            //create a temp node
            Node temp = new Node(arrayList.get(i));
            root = temp;

            //insert left child
            root.leftChild = insertToLevelOrder(arrayList, root.leftChild, 2 * i + 1);

            //insert right child
            root.rightChild = insertToLevelOrder(arrayList, root.rightChild, 2* i + 2);
        }
        return root;
    }
}

public class BalancedBinaryTrees
{

    public static void main(String[] args)
    {
        BinaryTree theTree = new BinaryTree();
        Scanner input = new Scanner(System.in);

        ArrayList<Integer> arrayList = new ArrayList<>();
        //create a binary tree and add nodes via scanner input

        System.out.println("Add numbers to binary tree to test! Type exit to finish");
        while (input.hasNextInt()){
            int elementToAdd = input.nextInt();
            theTree.addNode(elementToAdd);
        }


        //copy elements from the tree to an array list using an inorder traverse and insert
        theTree.inOrderCopyToArray(theTree.root, arrayList);

        //create new Binary tree to test balance method
        BinaryTree balancedTree = new BinaryTree();
        balancedTree.root = balancedTree.insertToLevelOrder(arrayList, balancedTree.root, 0);

        //show output to console
        System.out.println("\n The balanced tree is: \n" );
        balancedTree.printInorder(balancedTree.root);
        }
    }


class Node
{
    //The key variable will hold the data of the node
    int key;
    Node leftChild;
    Node rightChild;

    Node(int key){
        this.key = key;


    }

    public String toString(){
        return "index " +" has a key " + key;
    }
}