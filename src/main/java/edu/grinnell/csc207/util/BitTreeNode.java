package edu.grinnell.csc207.util;

public interface BitTreeNode {
  /**
   * 
   * @return
   */
  public BitTreeNode getLeft();

  /**
   * 
   * @return
   */
  public BitTreeNode getRight();

  /**
   * 
   * @return
   */
  public String getValue();

  public String getPath();
  /**
   * 
   * @return
   */
  public void setLeft(BitTreeNode newNode);

  /**
   * 
   * @return
   */
  public void setRight(BitTreeNode newNode);

  public void setPath(String path);
}
