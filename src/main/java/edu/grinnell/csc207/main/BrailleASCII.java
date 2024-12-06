package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.BrailleAsciiTables;

/**
 *
 */
public class BrailleASCII {
  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    if (args.length == 2) {
      switch (args[0]) {
        case "braille":
          try {
            for (char letter : args[1].toCharArray()) {
              pen.print(BrailleAsciiTables.toBraille(letter));
            } // for
          } catch (Exception e) {
            System.err.println("Trouble translating because " + e);
          } // try-catch
          pen.print('\n');
          break;

        case "unicode":
          try {
            String bits;
            for (char letter : args[1].toCharArray()) {
              bits = BrailleAsciiTables.toBraille(letter);
              pen.print(BrailleAsciiTables.toUnicode(bits));
            } // for
          } catch (Exception e) {
            System.err.println("Trouble translating because " + e);
          } // try-catch
          pen.print('\n');
          break;

        case "ascii":
          try {
            if (args[1].length() % 6 == 0) {
              int beginning = 0;
              int end = 6;
              while (end <= args[1].length()) {
                pen.print(BrailleAsciiTables.toAscii(args[1].substring(beginning, end)));
                beginning += 6;
                end += 6;
              } // while
            } else {
              System.err.print("Invalid length of bit string");
            } // if-else
          } catch (Exception e) {
            System.err.println("Trouble translating because " + e);
          } // try-catch
          pen.print('\n');
          break;

        default:
          pen.println("Invalid command");
          break;
      } // switch-case
    } else {
      pen.println("Incorrect number of parameters");
    } // if-else
    pen.close();
  } // main(String[])

} // class BrailleASCII
