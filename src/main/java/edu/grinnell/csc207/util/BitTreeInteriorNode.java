package edu.grinnell.csc207.util;

public class BitTreeInteriorNode implements BitTreeNode {
  //-----FIELDS-----
  private BitTreeNode right;
  private BitTreeNode left;
  private String value;

  //-----CONSTRUCTORS-----
  public BitTreeInteriorNode(){
    this.value = null;
    this.right = null;
    this.left = null;
  }

  //-----METHODS-----
  public BitTreeNode getLeft() {
    return this.left;
  }

  public BitTreeNode getRight() {
    return this.right;
  }

  public String getValue() {
    return this.value;
  }

  public String getPath(){
    return "";
  }

  public void setLeft(BitTreeNode node) {
    this.left = node;
  }

  public void setRight(BitTreeNode node) {
    this.right = node;
  }

  public void setPath(String path) {
    return;
  }
}
