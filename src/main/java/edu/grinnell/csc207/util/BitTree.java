package edu.grinnell.csc207.util;

import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Trees intended to be used in storing mappings between fixed-length sequences of bits and
 * corresponding values.
 *
 * @author Leonardo Alves Nunes
 */
public class BitTree {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * Root (starting point) of the tree.
   */
  private BitTreeNode root;

  /**
   * Amount of levels in the tree.
   */
  private int size;
  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a tree with a root.
   *
   * @param n number of levels in the tree.
   */
  public BitTree(int n) {
    this.size = n;
    this.root = new BitTreeInteriorNode();
  } // BitTree(int)
  // +---------------+-----------------------------------------------
  // | Local helpers |
  // +---------------+
  /**
   * Recursive function to traverse all nodes printing them.
   *
   * @param node
   * @param pen
   */
  public void dumpHelper(BitTreeNode node, PrintWriter pen) {
    if (node.getLeft() instanceof BitTreeLeaf) {
      pen.println(node.getLeft().getPath() + "," + node.getLeft().getValue());
    } else if (node.getRight() instanceof BitTreeLeaf) {
      pen.println(node.getRight().getPath() + "," + node.getRight().getValue());
    } else {
      if (node.getLeft() != null) {
        dumpHelper(node.getLeft(), pen);
      } // if
      if (node.getRight() != null) {
        dumpHelper(node.getRight(), pen);
      } // if
    } // if
  } // dumpHelper(BitTreeNode node, PrintWriter pen)
  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Follow a bath indicated by bits and set the leaf to value.
   *
   * @param bits
   * @param value
   */
  public void set(String bits, String value) {
    if (bits.length() != this.size) {
      throw new IndexOutOfBoundsException("Inappropriate length or values other than 0 or 1.");
    } // if
    BitTreeNode cur = this.root;

    for (int i = 0; i < bits.length() - 1; i++) {
      if (bits.charAt(i) == '0') {
        if (cur.getLeft() == null) {
          BitTreeNode newNode = new BitTreeInteriorNode();
          cur.setLeft(newNode);
        } // if
        cur = cur.getLeft();
      } else if (bits.charAt(i) == '1') {
        if (cur.getRight() == null) {
          BitTreeNode newNode = new BitTreeInteriorNode();
          cur.setRight(newNode);
        } // if
        cur = cur.getRight();
      } else {
        throw new IndexOutOfBoundsException("Inappropriate length or values other than 0 or 1.");
      } // if-else
    } // for

    if (bits.charAt(bits.length() - 1) == '0') {
      BitTreeNode newNode = new BitTreeLeaf(value);
      cur.setLeft(newNode);
      cur = cur.getLeft();
      cur.setPath(bits);
    } else if (bits.charAt(bits.length() - 1) == '1') {
      BitTreeNode newNode = new BitTreeLeaf(value);
      cur.setRight(newNode);
      cur = cur.getRight();
      cur.setPath(bits);
    } else {
      throw new IndexOutOfBoundsException("Inappropriate length or values other than 0 or 1.");
    } // if
  } // set(String, String)

  /**
   * Follow the path indicated by bits and return the value at the leaf.
   *
   * @param bits
   * @return the value stored in the leaf if the path is followed.
   */
  public String get(String bits) {
    if (bits.length() != this.size) {
      throw new IndexOutOfBoundsException("Inappropriate length or values other than 0 or 1.");
    } // if

    BitTreeNode cur = root;

    for (int i = 0; i < bits.length() - 1; i++) {
      if (bits.charAt(i) == '0') {
        if (cur.getLeft() == null) {
          throw new IndexOutOfBoundsException("This path is not set yet.");
        } // if
        cur = cur.getLeft();
      } else if (bits.charAt(i) == '1') {
        if (cur.getRight() == null) {
          throw new IndexOutOfBoundsException("This path is not set yet.");
        } // if
        cur = cur.getRight();
      } else {
        throw new IndexOutOfBoundsException("Inappropriate length or values other than 0 or 1.");
      } // if-else
    } // for
    if (bits.charAt(bits.length() - 1) == '0') {
      if (cur.getLeft() == null) {
        throw new IndexOutOfBoundsException("This path is not set yet.");
      } // if
      return cur.getLeft().getValue();
    } else if (bits.charAt(bits.length() - 1) == '1') {
      if (cur.getRight() == null) {
        throw new IndexOutOfBoundsException("This path is not set yet.");
      } // if
      return cur.getRight().getValue();
    } else {
      throw new IndexOutOfBoundsException("Inappropriate length or values other than 0 or 1.");
    } // if-else
  } // get(String, String)

  /**
   * Main dump function that initializes the recursive by the root.
   *
   * @param pen
   */
  public void dump(PrintWriter pen) {
    dumpHelper(this.root, pen);
  } // dump(PrintWriter)

  /**
   * Reads the provided table to build the tree.
   *
   * @param source
   */
  public void load(InputStream source) {
    try {
      String bits = "";
      String value = "";
      int current = source.read();
      while (current != -1) {
        // When everything is ready, set
        if ((char) current == '\n') {
          this.set(bits, value);
          current = source.read();
          bits = "";
          value = "";
        } // if
        if ((char) current != ',') {
          bits = bits + (char) current;
          current = source.read();
        } // if
        // If it identifies a comma, it is time to get value
        if ((char) current == ',') {
          current = source.read();
          while ((char) current != '\n' && current != -1) {
            value = value + Character.toString((char) current);
            current = source.read();
          } // while
        } // if
      } // while
    } catch (Exception e) {
      System.err.println(e);
    } // try-catch
  } // load(InputStream)
} // class BitTree
