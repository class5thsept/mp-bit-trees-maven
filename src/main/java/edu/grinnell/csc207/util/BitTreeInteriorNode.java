package edu.grinnell.csc207.util;

/**
 * Node used as a path to the leaf in the tree.
 *
 * @author Leonardo Alves Nunes.
 */
public class BitTreeInteriorNode implements BitTreeNode {
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
   * Stores the value of the current node.
   */
  private String value;

  // -----CONSTRUCTORS-----
  /**
   * Constructor to build a node used as a path.
   */
  public BitTreeInteriorNode() {
    this.value = null;
    this.right = null;
    this.left = null;
  } // BitTreeInteriorNode()

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
   * @return the node at the right
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
  } // getValue()

  /**
   * Get the path used for reaching the node.
   * @return the path used for getting to that leaf.
   */
  public String getPath() {
    return "";
  } // getPath()

  /**
   * Set the left node of the current node to the given one.
   * @param node
   */
  public void setLeft(BitTreeNode node) {
    this.left = node;
  } // setLeft(BitTreeNode node)

  /**
   * Set the right node of the current node to the given one.
   * @param node
   */
  public void setRight(BitTreeNode node) {
    this.right = node;
  } // setRight(BitTreeNode node)

  /**
   * Set the path of the node.
   * @param path
   */
  public void setPath(String path) {
    return;
  } // setPath(String path)
} // class BitTreeInteriorNode
