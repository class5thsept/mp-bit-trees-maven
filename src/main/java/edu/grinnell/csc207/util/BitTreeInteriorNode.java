package edu.grinnell.csc207.util;

public class BitTreeInteriorNode implements BitTreeNode {
  // -----FIELDS-----
  private BitTreeNode right;
  private BitTreeNode left;
  private String value;

  // -----CONSTRUCTORS-----
  public BitTreeInteriorNode() {
    this.value = null;
    this.right = null;
    this.left = null;
  } // BitTreeInteriorNode()

  // -----METHODS-----
  public BitTreeNode getLeft() {
    return this.left;
  } // getLeft()

  public BitTreeNode getRight() {
    return this.right;
  } // getRight()

  public String getValue() {
    return this.value;
  } // getValue()

  public String getPath() {
    return "";
  } // getPath()

  public void setLeft(BitTreeNode node) {
    this.left = node;
  } // setLeft(BitTreeNode node)

  public void setRight(BitTreeNode node) {
    this.right = node;
  } // setRight(BitTreeNode node)

  public void setPath(String path) {
    return;
  } // setPath(String path)
} // class BitTreeInteriorNode
