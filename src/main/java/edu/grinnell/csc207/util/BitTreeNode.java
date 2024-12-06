package edu.grinnell.csc207.util;

/**
 * General interface for the node. It can be internal or leaf.
 *
 * @author Leonardo Alves Nunes.
 */
public interface BitTreeNode {
  /**
   * Get the left node of the current node.
   * @return the node at the left.
   */
  public BitTreeNode getLeft();

  /**
   * Get the right node of the current node.
   * @return the node at the right.
   */
  public BitTreeNode getRight();

  /**
   * Get the value of the node.
   * @return the value as a string after the path is followed.
   */
  public String getValue();

  /**
   * Get the path used for reaching the node.
   * @return the path used for getting to that leaf.
   */
  public String getPath();

  /**
   * Set the left node of the current node to the given one.
   * @param newNode
   */
  public void setLeft(BitTreeNode newNode);

  /**
   * Set the right node of the current node to the given one.
   * @param newNode
   */
  public void setRight(BitTreeNode newNode);

  /**
   * Set the path of the node.
   * @param path
   */
  public void setPath(String path);
} // interface BitTreeNode
