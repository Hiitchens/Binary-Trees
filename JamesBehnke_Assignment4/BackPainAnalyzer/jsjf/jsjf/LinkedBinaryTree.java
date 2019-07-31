package jsjf;

import java.util.*;
import exceptions.*;

/**
 * LinkedBinaryTree implements the BinaryTreeADT interface
 *
 * @author Java Foundations
 * @version 4.0
 */
public class LinkedBinaryTree<T> implements jsjf.BinaryTreeADT<T>, Iterable<T>
{
	protected jsjf.BinaryTreeNode<T> root;
	protected int modCount;

	/**
	 * Creates an empty binary tree.
	 */
	public LinkedBinaryTree()
	{
		root = null;
	}

	/**
	 * Creates a binary tree with the specified element as its root.
	 *
	 * @param element the element that will become the root of the binary tree
	 */
	public LinkedBinaryTree(T element)
	{
		root = new jsjf.BinaryTreeNode<T>(element);
	}

	/**
	 * Creates a binary tree with the specified element as its root and the
	 * given trees as its left child and right child
	 *
	 * @param element the element that will become the root of the binary tree
	 * @param left the left subtree of this tree
	 * @param right the right subtree of this tree
	 */
	public LinkedBinaryTree(T element, LinkedBinaryTree<T> left,
							LinkedBinaryTree<T> right)
	{
		root = new jsjf.BinaryTreeNode<T>(element);
		root.setLeft(left.root);
		root.setRight(right.root);
	}

	/**
	 * Returns a reference to the element at the root
	 *
	 * @return a reference to the specified target
	 * @throws EmptyCollectionException if the tree is empty
	 */
	public T getRootElement() throws EmptyCollectionException
	{
		// To be completed as a Programming Project

		return root.element;  // temp
	}

	/**
	 * Returns a reference to the node at the root
	 *
	 * @return a reference to the specified node
	 * @throws EmptyCollectionException if the tree is empty
	 */
	protected jsjf.BinaryTreeNode<T> getRootNode() throws EmptyCollectionException
	{
		// To be completed as a Programming Project

		return root;  // temp
	}

	/**
	 * Returns the left subtree of the root of this tree.
	 *
	 * @return a link to the left subtree fo the tree
	 */
	public LinkedBinaryTree<T> getLeft()

	{
		// To be completed as a Programming Project
		if (root == null){
			throw new EmptyCollectionException("No left node. Tree is empty");
		}
		LinkedBinaryTree<T> theLeft = new LinkedBinaryTree<>();
		theLeft.root = root.getLeft();

		return theLeft;  // temp
	}

	/**
	 * Returns the right subtree of the root of this tree.
	 *
	 * @return a link to the right subtree of the tree
	 */
	public LinkedBinaryTree<T> getRight()
	{
		// To be completed as a Programming Project
		if (root == null){
			throw new EmptyCollectionException("No right node. Tree is empty");
		}

		LinkedBinaryTree<T> theRight = new LinkedBinaryTree<>();
		theRight.root = root.getRight();
		return theRight;  // temp
	}

	/**
	 * Returns true if this binary tree is empty and false otherwise.
	 *
	 * @return true if this binary tree is empty, false otherwise
	 */
	public boolean isEmpty()
	{
		return (root == null);
	}

	/**
	 * Returns the integer size of this tree.
	 *
	 * @return the integer size of the tree
	 */
	//must create overload method to avoid implementing abstract size method in BinaryTreeADT.java
	public int size()
	{
		return size(root);

	}
	//recursively check left child starting at root then right
	public int size(jsjf.BinaryTreeNode node){
		if (node==null)
			return 0;
		else
			return (size(node.left) + 1 + size(node.right));
	}

	/**
	 * Returns the height of this tree.
	 *
	 * @return the height of the tree
	 */
	public int getHeight()
	{
		if (root==null)
			return 0;
		// To be completed as a Programming Project
		int leftHeight =0, rightHeight = 0;
		while(root.getLeft() != null){
			leftHeight++;
		}
		while(root.getRight() != null){
			rightHeight++;
		}

		return Math.max(leftHeight, rightHeight);  // temp
	}

	/**
	 * Returns the height of the specified node.
	 *
	 * @param node the node from which to calculate the height
	 * @return the height of the tree
	 */
	private int height(jsjf.BinaryTreeNode<T> node, int data, int level)
	{
		if (node == null)
			return 0;
		if (node.element == node)
			return level;

		int levelDown = height(node.left, data, level + 1);
		if (levelDown != 0){
			return levelDown;
		}

		levelDown = height(node.right, data, level + 1);
		return levelDown;



	}

	public int getLevelofNode(jsjf.BinaryTreeNode<T> node, int data){
		return height(node, data, 1);
	}

	/**
	 * Returns true if this tree contains an element that matches the
	 * specified target element and false otherwise.
	 *
	 * @param targetElement the element being sought in this tree
	 * @return true if the element in is this tree, false otherwise
	 */
	public boolean contains(T targetElement)
	{
		try {
			find(targetElement);
		} //if error: elementNotFound is found, return false
		catch (ElementNotFoundException notFound){
			return false;
		}// else return true

		return true;  // temp
	}

	/**
	 * Returns a reference to the specified target element if it is
	 * found in this binary tree.  Throws a ElementNotFoundException if
	 * the specified target element is not found in the binary tree.
	 *
	 * @param targetElement the element being sought in this tree
	 * @return a reference to the specified target
	 * @throws ElementNotFoundException if the element is not in the tree
	 */
	public T find(T targetElement) throws ElementNotFoundException
	{
		jsjf.BinaryTreeNode<T> current = findNode(targetElement, root);

		if (current == null)
			throw new ElementNotFoundException("LinkedBinaryTree");

		return (current.getElement());
	}

	/**
	 * Returns a reference to the specified target element if it is
	 * found in this binary tree.
	 *
	 * @param targetElement the element being sought in this tree
	 * @param next the element to begin searching from
	 */
	private jsjf.BinaryTreeNode<T> findNode(T targetElement,
											jsjf.BinaryTreeNode<T> next)
	{
		if (next == null)
			return null;

		if (next.getElement().equals(targetElement))
			return next;

		jsjf.BinaryTreeNode<T> temp = findNode(targetElement, next.getLeft());

		if (temp == null)
			temp = findNode(targetElement, next.getRight());

		return temp;
	}

	/**
	 * Returns a string representation of this binary tree showing
	 * the nodes in an inorder fashion.
	 *
	 * @return a string representation of this binary tree
	 */
	public String toString()
	{
		// To be completed as a Programming Project

		return "";  // temp
	}

	/**
	 * Returns an iterator over the elements in this tree using the
	 * iteratorInOrder method
	 *
	 * @return an in order iterator over this binary tree
	 */
	public Iterator<T> iterator()
	{
		return iteratorInOrder();
	}

	/**
	 * Performs an inorder traversal on this binary tree by calling an
	 * overloaded, recursive inorder method that starts with
	 * the root.
	 *
	 * @return an in order iterator over this binary tree
	 */
	public Iterator<T> iteratorInOrder()
	{
		jsjf.ArrayUnorderedList<T> tempList = new jsjf.ArrayUnorderedList<T>();
		inOrder(root, tempList);

		return new TreeIterator(tempList.iterator());
	}

	/**
	 * Performs a recursive inorder traversal.
	 *
	 * @param node the node to be used as the root for this traversal
	 * @param tempList the temporary list for use in this traversal
	 */
	protected void inOrder(jsjf.BinaryTreeNode<T> node,
						   jsjf.ArrayUnorderedList<T> tempList)
	{
		if (node != null)
		{
			inOrder(node.getLeft(), tempList);
			tempList.addToRear(node.getElement());
			inOrder(node.getRight(), tempList);
		}
	}

	/**
	 * Performs an preorder traversal on this binary tree by calling
	 * an overloaded, recursive preorder method that starts with
	 * the root.
	 *
	 * @return a pre order iterator over this tree
	 */
	public Iterator<T> iteratorPreOrder()
	{
		//create new empty iterator
		jsjf.ArrayUnorderedList<T> tempList = new jsjf.ArrayUnorderedList<>();


		if (root != null)
			preOrder(root, tempList);


		// To be completed as a Programming Project

		return new TreeIterator(tempList.iterator());  // temp
	}

	/**
	 * Performs a recursive preorder traversal.
	 *
	 * @param node the node to be used as the root for this traversal
	 * @param tempList the temporary list for use in this traversal
	 */
	protected void preOrder(jsjf.BinaryTreeNode<T> node,
							jsjf.ArrayUnorderedList<T> tempList)
	{
		if (node != null){
			preOrder(node.getLeft(), tempList);
			tempList.addToRear(node.getElement());
			preOrder(node.getRight(), tempList);
		}

	}

	/**
	 * Performs an postorder traversal on this binary tree by calling
	 * an overloaded, recursive postorder method that starts
	 * with the root.
	 *
	 * @return a post order iterator over this tree
	 */
	public Iterator<T> iteratorPostOrder()
	{
		// To be completed as a Programming Project
		jsjf.ArrayUnorderedList<T> tempList = new jsjf.ArrayUnorderedList<>();

		if (root!=null)
			postOrder(root, tempList);

		return new TreeIterator(tempList.iterator());  // temp
	}

	/**
	 * Performs a recursive postorder traversal.
	 *
	 * @param node the node to be used as the root for this traversal
	 * @param tempList the temporary list for use in this traversal
	 */
	protected void postOrder(jsjf.BinaryTreeNode<T> node,
							 jsjf.ArrayUnorderedList<T> tempList)
	{
		if (node != null){
			postOrder(node.getLeft(), tempList);
			tempList.addToRear(node.getElement());
			postOrder(node.getRight(), tempList);
		}
		// To be completed as a Programming Project
	}

	/**
	 * Performs a levelorder traversal on this binary tree, using a
	 * templist.
	 *
	 * @return a levelorder iterator over this binary tree
	 */
	public Iterator<T> iteratorLevelOrder()
	{
		jsjf.ArrayUnorderedList<jsjf.BinaryTreeNode<T>> nodes =
				new jsjf.ArrayUnorderedList<jsjf.BinaryTreeNode<T>>();
		jsjf.ArrayUnorderedList<T> tempList = new jsjf.ArrayUnorderedList<T>();
		jsjf.BinaryTreeNode<T> current;

		nodes.addToRear(root);

		while (!nodes.isEmpty())
		{
			current = nodes.removeFirst();

			if (current != null)
			{
				tempList.addToRear(current.getElement());
				if (current.getLeft() != null)
					nodes.addToRear(current.getLeft());
				if (current.getRight() != null)
					nodes.addToRear(current.getRight());
			}
			else
				tempList.addToRear(null);
		}

		return new TreeIterator(tempList.iterator());
	}

	/**
	 * Inner class to represent an iterator over the elements of this tree
	 */
	private class TreeIterator implements Iterator<T>
	{
		private int expectedModCount;
		private Iterator<T> iter;

		/**
		 * Sets up this iterator using the specified iterator.
		 *
		 * @param iter the list iterator created by a tree traversal
		 */
		public TreeIterator(Iterator<T> iter)
		{
			this.iter = iter;
			expectedModCount = modCount;
		}

		/**
		 * Returns true if this iterator has at least one more element
		 * to deliver in the iteration.
		 *
		 * @return  true if this iterator has at least one more element to deliver
		 *          in the iteration
		 * @throws  ConcurrentModificationException if the collection has changed
		 *          while the iterator is in use
		 */
		public boolean hasNext() throws ConcurrentModificationException
		{
			if (!(modCount == expectedModCount))
				throw new ConcurrentModificationException();

			return (iter.hasNext());
		}

		/**
		 * Returns the next element in the iteration. If there are no
		 * more elements in this iteration, a NoSuchElementException is
		 * thrown.
		 *
		 * @return the next element in the iteration
		 * @throws NoSuchElementException if the iterator is empty
		 */
		public T next() throws NoSuchElementException
		{
			if (hasNext())
				return (iter.next());
			else
				throw new NoSuchElementException();
		}

		/**
		 * The remove operation is not supported.
		 *
		 * @throws UnsupportedOperationException if the remove operation is called
		 */
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}
}

