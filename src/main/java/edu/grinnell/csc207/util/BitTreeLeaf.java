package edu.grinnell.csc207.util;


/**
 * Node used as a the leaf (end) in the tree.
 *
 * @author Leonardo Alves Nunes.
 */
public class BitTreeLeaf implements BitTreeNode {
  // -----FIELDS-----
  /**
   * Stores the right node of the current node.
   */
  private BitTreeNode right;

  /**
   * Stores the left node of the current node.
   */
  private BitTreeNode left;

  /**
   * Stores the value of the current node. Appropriate if it is a leaf.
   */
  private String value;

  /**
   * Stores the path to get to the node through the tree.
   */
  private String path;

  // -----CONSTRUCTORS-----
  /**
   * Constructor to build a node used as a path.
   * @param val
   */
  public BitTreeLeaf(String val) {
    this.right = null;
    this.left = null;
    this.value = val;
    this.path = null;
  } // BitTreeLeaf(String val)

  // -----METHODS-----
  /**
   * Get the left node of the current node.
   * @return the node at the left.
   */
  public BitTreeNode getLeft() {
    return this.left;
  } // getLeft()

  /**
   * Get the right node of the current node.
   * @return the node at the right.
   */
  public BitTreeNode getRight() {
    return this.right;
  } // getRight()

  /**
   * Get the value of the node.
   * @return the value stored in the leaf.
   */
  public String getValue() {
    return this.value;
  } // String getValue()

  /**
   * Get the path used for reaching the node.
   * @return the path in bits.
   */
  public String getPath() {
    return this.path;
  } // String getPath()

  /**
   * Set the left node of the current node to the given one.
   * @param node
   */
  public void setLeft(BitTreeNode node) {
    this.left = null;
  } // setLeft(BitTreeNode node)

  /**
   * Set the right node of the current node to the given one.
   * @param node
   */
  public void setRight(BitTreeNode node) {
    this.right = null;
  } // setRight(BitTreeNode node)

  /**
   * Set the path of the node.
   * @param path
   */
  public void setPath(String path) {
    this.path = path;
  } // setPath(String path)
} // class BitTreeLeaf
