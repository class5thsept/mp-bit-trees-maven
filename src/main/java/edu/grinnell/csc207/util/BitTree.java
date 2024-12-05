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

  private BitTreeNode root;
  private int size;
  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   *
   */
  public BitTree(int n) {
    this.size = n;
    this.root = new BitTreeInteriorNode();
  } // BitTree(int)

  // +---------------+-----------------------------------------------
  // | Local helpers |
  // +---------------+

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   *
   */
  public void set(String bits, String value) {
    if (bits.length() != this.size) {
      throw new IndexOutOfBoundsException("Inappropriate length or values other than 0 or 1.");
    }
    BitTreeNode cur = this.root;

    for (int i = 0; i < bits.length() - 1; i++) {
      if (bits.charAt(i) == '0') {
        if (cur.getLeft() == null) {
          BitTreeNode newNode = new BitTreeInteriorNode();
          cur.setLeft(newNode);
        }
        cur = cur.getLeft();
      } else if (bits.charAt(i) == '1') {
        if (cur.getRight() == null) {
          BitTreeNode newNode = new BitTreeInteriorNode();
          cur.setRight(newNode);
        }
        cur = cur.getRight();
      } else {
        throw new IndexOutOfBoundsException("Inappropriate length or values other than 0 or 1.");
      }
    }

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
    }
  } // set(String, String)

  /**
   *
   */
  public String get(String bits) {
    if (bits.length() != this.size) {
      throw new IndexOutOfBoundsException("Inappropriate length or values other than 0 or 1.");
    }

    BitTreeNode cur = root;

    for (int i = 0; i < bits.length() - 1; i++) {
      if (bits.charAt(i) == '0') {
        if (cur.getLeft() == null) {
          throw new IndexOutOfBoundsException("This path is not set yet.");
        }
        cur = cur.getLeft();
      } else if (bits.charAt(i) == '1') {
        if (cur.getRight() == null) {
          throw new IndexOutOfBoundsException("This path is not set yet.");
        }
        cur = cur.getRight();
      } else {
        throw new IndexOutOfBoundsException("Inappropriate length or values other than 0 or 1.");
      }
    }
    if (bits.charAt(bits.length() - 1) == '0') {
      if (cur.getLeft() == null) {
        throw new IndexOutOfBoundsException("This path is not set yet.");
      }
      return cur.getLeft().getValue();
    } else if (bits.charAt(bits.length() - 1) == '1') {
      if (cur.getRight() == null) {
        throw new IndexOutOfBoundsException("This path is not set yet.");
      }
      return cur.getRight().getValue();
    } else {
      throw new IndexOutOfBoundsException("Inappropriate length or values other than 0 or 1.");
    }
  } // get(String, String)

  /**
   *
   */
  public void dump(PrintWriter pen) {
    dumpHelper(this.root, pen);
  } // dump(PrintWriter)

  public void dumpHelper(BitTreeNode node, PrintWriter pen) {
    if (node.getLeft() instanceof BitTreeLeaf) {
      pen.println(node.getLeft().getPath() + "," + node.getLeft().getValue());
    } else if (node.getRight() instanceof BitTreeLeaf) {
      pen.println(node.getRight().getPath() + "," + node.getRight().getValue());
    } else {
      if (node.getLeft() != null) {
        dumpHelper(node.getLeft(), pen);
      }
      if (node.getRight() != null) {
        dumpHelper(node.getRight(), pen);
      }
    }
  }

  /**
   *
   */
  public void load(InputStream source) {
    try {
      String bits = "";
      String value = "";
      int current = source.read();
      while (current != -1) {
        if ((char) current == '\n') {
          this.set(bits, value);
          current = source.read();
          bits = "";
          value = "";
        }
        if ((char) current != ',') {
          bits = bits + (char) current;
        }
        
        if ((char) current == ',') {
          current = source.read();
          value = Character.toString((char) current);
        }
        current = source.read();
      }
      
    } catch (Exception e) {
      System.err.println(e);
    }

    
    
  } // load(InputStream)

} // class BitTree
