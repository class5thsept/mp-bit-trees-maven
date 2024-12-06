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

  /**
   * 
   * @return
   */
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

  /**
   * 
   * @return
   */
  public void setPath(String path);
}
