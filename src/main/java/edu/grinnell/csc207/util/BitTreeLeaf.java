package edu.grinnell.csc207.util;

public class BitTreeLeaf implements BitTreeNode{
  //-----FIELDS-----
  private BitTreeNode right;
  private BitTreeNode left;
  private String value;
  private String path;

  //-----CONSTRUCTORS-----
  public BitTreeLeaf(String val){
    this.right = null;
    this.left = null;
    this.value = val;
    this.path = null;
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

  public String getPath() {
    return this.path;
  }

  public void setLeft(BitTreeNode node){
    this.left = null;
  }

  public void setRight(BitTreeNode node){
    this.right = null;
  }

  public void setPath(String path) {
    this.path = path;
  }
}
