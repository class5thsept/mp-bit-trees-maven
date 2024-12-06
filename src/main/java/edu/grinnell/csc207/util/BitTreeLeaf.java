package edu.grinnell.csc207.util;

public class BitTreeLeaf implements BitTreeNode {
  // -----FIELDS-----
  private BitTreeNode right;
  private BitTreeNode left;
  private String value;
  private String path;

  // -----CONSTRUCTORS-----
  public BitTreeLeaf(String val) {
    this.right = null;
    this.left = null;
    this.value = val;
    this.path = null;
  } // BitTreeLeaf(String val)

  // -----METHODS-----
  public BitTreeNode getLeft() {
    return this.left;
  } // getLeft()

  public BitTreeNode getRight() {
    return this.right;
  } // getRight()

  public String getValue() {
    return this.value;
  } // String getValue()

  public String getPath() {
    return this.path;
  } // String getPath()

  public void setLeft(BitTreeNode node) {
    this.left = null;
  } // setLeft(BitTreeNode node)

  public void setRight(BitTreeNode node) {
    this.right = null;
  } // setRight(BitTreeNode node)

  public void setPath(String path) {
    this.path = path;
  } // setPath(String path)
} // class BitTreeLeaf
