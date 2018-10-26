/* The following code was generated by JFlex 1.4.3 on 10/25/18 11:09 PM */

/********************************************************************************
**  @author Diana Montes                                               	       **
**  @about Proyecto 3: Construcción del AST.	                               **
*********************************************************************************/
package ast;
import ast.patron.compuesto.*;
import java.util.Stack;
import java.util.Arrays;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 10/25/18 11:09 PM from the specification file
 * <tt>/home/alexis/Documents/Compiladores/Compiladores/Proyectos/Proyecto3/src/main/jflex/Flexer.flex</tt>
 */
public class Flexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int INDENTA = 2;
  public static final int YYINITIAL = 0;
  public static final int DEINDENTA = 8;
  public static final int CODIGO = 6;
  public static final int CADENA = 4;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3,  3,  4, 4
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\34\1\3\25\0\1\6\1\20\1\35\1\7\1\5\1\14"+
    "\2\0\1\21\1\22\1\12\1\10\1\0\1\11\1\1\1\13\1\2"+
    "\11\2\1\23\1\5\1\15\1\17\1\16\2\0\5\4\1\30\15\4"+
    "\1\24\6\4\1\0\1\5\2\0\1\4\1\0\1\31\2\4\1\37"+
    "\1\27\1\45\1\4\1\43\1\44\2\4\1\32\1\4\1\36\1\40"+
    "\1\46\1\4\1\25\1\33\1\41\1\26\1\4\1\42\3\4\57\0"+
    "\1\4\12\0\1\4\4\0\1\4\5\0\27\4\1\0\37\4\1\0"+
    "\u01ca\4\4\0\14\4\16\0\5\4\7\0\1\4\1\0\1\4\201\0"+
    "\5\4\1\0\2\4\2\0\4\4\10\0\1\4\1\0\3\4\1\0"+
    "\1\4\1\0\24\4\1\0\123\4\1\0\213\4\10\0\236\4\11\0"+
    "\46\4\2\0\1\4\7\0\47\4\110\0\33\4\5\0\3\4\55\0"+
    "\53\4\25\0\12\5\4\0\2\4\1\0\143\4\1\0\1\4\17\0"+
    "\2\4\7\0\2\4\12\5\3\4\2\0\1\4\20\0\1\4\1\0"+
    "\36\4\35\0\131\4\13\0\1\4\16\0\12\5\41\4\11\0\2\4"+
    "\4\0\1\4\5\0\26\4\4\0\1\4\11\0\1\4\3\0\1\4"+
    "\27\0\31\4\107\0\1\4\1\0\13\4\127\0\66\4\3\0\1\4"+
    "\22\0\1\4\7\0\12\4\4\0\12\5\1\0\7\4\1\0\7\4"+
    "\5\0\10\4\2\0\2\4\2\0\26\4\1\0\7\4\1\0\1\4"+
    "\3\0\4\4\3\0\1\4\20\0\1\4\15\0\2\4\1\0\3\4"+
    "\4\0\12\5\2\4\23\0\6\4\4\0\2\4\2\0\26\4\1\0"+
    "\7\4\1\0\2\4\1\0\2\4\1\0\2\4\37\0\4\4\1\0"+
    "\1\4\7\0\12\5\2\0\3\4\20\0\11\4\1\0\3\4\1\0"+
    "\26\4\1\0\7\4\1\0\2\4\1\0\5\4\3\0\1\4\22\0"+
    "\1\4\17\0\2\4\4\0\12\5\25\0\10\4\2\0\2\4\2\0"+
    "\26\4\1\0\7\4\1\0\2\4\1\0\5\4\3\0\1\4\36\0"+
    "\2\4\1\0\3\4\4\0\12\5\1\0\1\4\21\0\1\4\1\0"+
    "\6\4\3\0\3\4\1\0\4\4\3\0\2\4\1\0\1\4\1\0"+
    "\2\4\3\0\2\4\3\0\3\4\3\0\14\4\26\0\1\4\25\0"+
    "\12\5\25\0\10\4\1\0\3\4\1\0\27\4\1\0\12\4\1\0"+
    "\5\4\3\0\1\4\32\0\2\4\6\0\2\4\4\0\12\5\25\0"+
    "\10\4\1\0\3\4\1\0\27\4\1\0\12\4\1\0\5\4\3\0"+
    "\1\4\40\0\1\4\1\0\2\4\4\0\12\5\1\0\2\4\22\0"+
    "\10\4\1\0\3\4\1\0\51\4\2\0\1\4\20\0\1\4\21\0"+
    "\2\4\4\0\12\5\12\0\6\4\5\0\22\4\3\0\30\4\1\0"+
    "\11\4\1\0\1\4\2\0\7\4\72\0\60\4\1\0\2\4\14\0"+
    "\7\4\11\0\12\5\47\0\2\4\1\0\1\4\2\0\2\4\1\0"+
    "\1\4\2\0\1\4\6\0\4\4\1\0\7\4\1\0\3\4\1\0"+
    "\1\4\1\0\1\4\2\0\2\4\1\0\4\4\1\0\2\4\11\0"+
    "\1\4\2\0\5\4\1\0\1\4\11\0\12\5\2\0\4\4\40\0"+
    "\1\4\37\0\12\5\26\0\10\4\1\0\44\4\33\0\5\4\163\0"+
    "\53\4\24\0\1\4\12\5\6\0\6\4\4\0\4\4\3\0\1\4"+
    "\3\0\2\4\7\0\3\4\4\0\15\4\14\0\1\4\1\0\12\5"+
    "\6\0\46\4\1\0\1\4\5\0\1\4\2\0\53\4\1\0\u014d\4"+
    "\1\0\4\4\2\0\7\4\1\0\1\4\1\0\4\4\2\0\51\4"+
    "\1\0\4\4\2\0\41\4\1\0\4\4\2\0\7\4\1\0\1\4"+
    "\1\0\4\4\2\0\17\4\1\0\71\4\1\0\4\4\2\0\103\4"+
    "\45\0\20\4\20\0\125\4\14\0\u026c\4\2\0\21\4\1\0\32\4"+
    "\5\0\113\4\25\0\15\4\1\0\4\4\16\0\22\4\16\0\22\4"+
    "\16\0\15\4\1\0\3\4\17\0\64\4\43\0\1\4\4\0\1\4"+
    "\3\0\12\5\46\0\12\5\6\0\130\4\10\0\51\4\1\0\1\4"+
    "\5\0\106\4\12\0\35\4\51\0\12\5\36\4\2\0\5\4\13\0"+
    "\54\4\25\0\7\4\10\0\12\5\46\0\27\4\11\0\65\4\53\0"+
    "\12\5\6\0\12\5\15\0\1\4\135\0\57\4\21\0\7\4\4\0"+
    "\12\5\51\0\36\4\15\0\2\4\12\5\54\4\32\0\44\4\34\0"+
    "\12\5\3\0\3\4\12\5\44\4\153\0\4\4\1\0\4\4\3\0"+
    "\2\4\11\0\300\4\100\0\u0116\4\2\0\6\4\2\0\46\4\2\0"+
    "\6\4\2\0\10\4\1\0\1\4\1\0\1\4\1\0\1\4\1\0"+
    "\37\4\2\0\65\4\1\0\7\4\1\0\1\4\3\0\3\4\1\0"+
    "\7\4\3\0\4\4\2\0\6\4\4\0\15\4\5\0\3\4\1\0"+
    "\7\4\164\0\1\4\15\0\1\4\20\0\15\4\145\0\1\4\4\0"+
    "\1\4\2\0\12\4\1\0\1\4\3\0\5\4\6\0\1\4\1\0"+
    "\1\4\1\0\1\4\1\0\4\4\1\0\13\4\2\0\4\4\5\0"+
    "\5\4\4\0\1\4\64\0\2\4\u0a7b\0\57\4\1\0\57\4\1\0"+
    "\205\4\6\0\4\4\3\0\2\4\14\0\46\4\1\0\1\4\5\0"+
    "\1\4\2\0\70\4\7\0\1\4\20\0\27\4\11\0\7\4\1\0"+
    "\7\4\1\0\7\4\1\0\7\4\1\0\7\4\1\0\7\4\1\0"+
    "\7\4\1\0\7\4\120\0\1\4\u01d5\0\2\4\52\0\5\4\5\0"+
    "\2\4\4\0\126\4\6\0\3\4\1\0\132\4\1\0\4\4\5\0"+
    "\51\4\3\0\136\4\21\0\33\4\65\0\20\4\u0200\0\u19b6\4\112\0"+
    "\u51cd\4\63\0\u048d\4\103\0\56\4\2\0\u010d\4\3\0\20\4\12\5"+
    "\2\4\24\0\57\4\20\0\31\4\10\0\106\4\61\0\11\4\2\0"+
    "\147\4\2\0\4\4\1\0\4\4\14\0\13\4\115\0\12\4\1\0"+
    "\3\4\1\0\4\4\1\0\27\4\35\0\64\4\16\0\62\4\34\0"+
    "\12\5\30\0\6\4\3\0\1\4\4\0\12\5\34\4\12\0\27\4"+
    "\31\0\35\4\7\0\57\4\34\0\1\4\12\5\46\0\51\4\27\0"+
    "\3\4\1\0\10\4\4\0\12\5\6\0\27\4\3\0\1\4\5\0"+
    "\60\4\1\0\1\4\3\0\2\4\2\0\5\4\2\0\1\4\1\0"+
    "\1\4\30\0\3\4\2\0\13\4\7\0\3\4\14\0\6\4\2\0"+
    "\6\4\2\0\6\4\11\0\7\4\1\0\7\4\221\0\43\4\15\0"+
    "\12\5\6\0\u2ba4\4\14\0\27\4\4\0\61\4\u2104\0\u016e\4\2\0"+
    "\152\4\46\0\7\4\14\0\5\4\5\0\1\4\1\0\12\4\1\0"+
    "\15\4\1\0\5\4\1\0\1\4\1\0\2\4\1\0\2\4\1\0"+
    "\154\4\41\0\u016b\4\22\0\100\4\2\0\66\4\50\0\14\4\164\0"+
    "\5\4\1\0\207\4\23\0\12\5\7\0\32\4\6\0\32\4\13\0"+
    "\131\4\3\0\6\4\2\0\6\4\2\0\6\4\2\0\3\4\43\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\5\0\1\1\1\2\1\3\1\2\1\4\1\5\1\6"+
    "\1\7\1\3\1\10\1\11\1\3\1\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24"+
    "\1\25\1\26\1\3\1\27\1\30\1\31\4\16\1\32"+
    "\6\16\1\33\1\34\2\0\1\35\1\36\1\37\1\40"+
    "\1\41\1\42\5\16\1\43\1\16\1\44\6\16\1\45"+
    "\1\46\1\16\1\47\1\16\1\50\1\51\1\52\2\16"+
    "\1\53\1\54";

  private static int [] zzUnpackAction() {
    int [] result = new int[81];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\47\0\116\0\165\0\234\0\303\0\303\0\352"+
    "\0\u0111\0\303\0\303\0\303\0\303\0\303\0\u0138\0\303"+
    "\0\u015f\0\303\0\u0186\0\u01ad\0\303\0\u01d4\0\303\0\303"+
    "\0\u01fb\0\u0222\0\303\0\u0249\0\u0270\0\u0297\0\u02be\0\303"+
    "\0\303\0\303\0\u02e5\0\u030c\0\u0333\0\u035a\0\303\0\u0381"+
    "\0\u03a8\0\u03cf\0\u03f6\0\u041d\0\u0444\0\303\0\303\0\352"+
    "\0\u015f\0\303\0\303\0\303\0\303\0\303\0\303\0\u046b"+
    "\0\u0492\0\u04b9\0\u04e0\0\u0507\0\u01d4\0\u052e\0\u01d4\0\u0555"+
    "\0\u057c\0\u05a3\0\u05ca\0\u05f1\0\u0618\0\u01d4\0\u01d4\0\u063f"+
    "\0\u01d4\0\u0666\0\u01d4\0\u01d4\0\u01d4\0\u068d\0\u06b4\0\u01d4"+
    "\0\u01d4";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[81];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\3\6\1\7\2\6\1\10\1\11\24\6\1\10\12\6"+
    "\3\12\1\13\2\12\1\14\1\11\24\12\1\15\12\12"+
    "\2\16\1\17\1\20\3\17\1\11\10\17\1\21\13\17"+
    "\1\16\1\22\11\17\1\16\1\23\1\24\1\25\1\26"+
    "\1\16\1\7\1\11\1\27\1\30\1\31\1\32\1\33"+
    "\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43"+
    "\2\26\1\44\1\45\1\46\2\26\1\16\1\47\1\50"+
    "\1\26\1\51\1\26\1\52\1\26\1\53\1\54\1\55"+
    "\3\56\1\16\3\56\1\11\37\56\47\0\3\57\1\0"+
    "\2\57\1\60\1\0\24\57\1\60\12\57\3\11\1\0"+
    "\43\11\2\0\1\17\1\0\14\17\1\61\13\17\2\0"+
    "\11\17\17\0\1\17\31\0\1\23\45\0\1\23\1\24"+
    "\46\0\1\26\1\0\1\26\17\0\10\26\2\0\11\26"+
    "\12\0\1\62\47\0\1\63\52\0\1\64\46\0\1\65"+
    "\46\0\1\66\46\0\1\67\31\0\1\26\1\0\1\26"+
    "\17\0\1\26\1\70\6\26\2\0\11\26\2\0\1\26"+
    "\1\0\1\26\17\0\6\26\1\71\1\26\2\0\11\26"+
    "\2\0\1\26\1\0\1\26\17\0\5\26\1\72\2\26"+
    "\2\0\11\26\2\0\1\26\1\0\1\26\17\0\10\26"+
    "\2\0\1\73\10\26\2\0\1\26\1\0\1\26\17\0"+
    "\10\26\2\0\2\26\1\74\6\26\2\0\1\26\1\0"+
    "\1\26\17\0\1\26\1\75\6\26\2\0\11\26\2\0"+
    "\1\26\1\0\1\26\17\0\10\26\2\0\5\26\1\76"+
    "\3\26\2\0\1\26\1\0\1\26\17\0\10\26\2\0"+
    "\7\26\1\77\1\26\2\0\1\26\1\0\1\26\17\0"+
    "\10\26\2\0\2\26\1\100\6\26\2\0\1\26\1\0"+
    "\1\26\17\0\1\26\1\101\6\26\2\0\11\26\2\0"+
    "\1\26\1\0\1\26\17\0\2\26\1\102\5\26\2\0"+
    "\11\26\2\0\1\26\1\0\1\26\17\0\7\26\1\103"+
    "\2\0\6\26\1\104\2\26\2\0\1\26\1\0\1\26"+
    "\17\0\6\26\1\105\1\26\2\0\11\26\2\0\1\26"+
    "\1\0\1\26\17\0\10\26\2\0\1\26\1\106\7\26"+
    "\2\0\1\26\1\0\1\26\17\0\10\26\2\0\3\26"+
    "\1\107\5\26\2\0\1\26\1\0\1\26\17\0\10\26"+
    "\2\0\6\26\1\110\2\26\2\0\1\26\1\0\1\26"+
    "\17\0\1\26\1\111\6\26\2\0\11\26\2\0\1\26"+
    "\1\0\1\26\17\0\10\26\2\0\6\26\1\112\2\26"+
    "\2\0\1\26\1\0\1\26\17\0\3\26\1\113\4\26"+
    "\2\0\11\26\2\0\1\26\1\0\1\26\17\0\3\26"+
    "\1\114\4\26\2\0\11\26\2\0\1\26\1\0\1\26"+
    "\17\0\10\26\2\0\7\26\1\115\1\26\2\0\1\26"+
    "\1\0\1\26\17\0\7\26\1\102\2\0\11\26\2\0"+
    "\1\26\1\0\1\26\17\0\6\26\1\116\1\26\2\0"+
    "\11\26\2\0\1\26\1\0\1\26\17\0\10\26\2\0"+
    "\1\117\10\26\2\0\1\26\1\0\1\26\17\0\3\26"+
    "\1\120\4\26\2\0\11\26\2\0\1\26\1\0\1\26"+
    "\17\0\10\26\2\0\3\26\1\121\5\26";

  private static int [] zzUnpackTrans() {
    int [] result = new int[1755];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\5\0\2\11\2\1\5\11\1\1\1\11\1\1\1\11"+
    "\2\1\1\11\1\1\2\11\2\1\1\11\4\1\3\11"+
    "\4\1\1\11\6\1\2\11\2\0\6\11\32\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[81];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    /** Variables auxiliares para
    * manejar la indentación.*/
    static Stack<Integer> pila = new Stack<Integer>();
    static Integer actual = 0;
    static String cadena = "";
    static int dedents = 0;
    static int indents = 0;

    private Parser yyparser;

    public int line(){
        return yyline+1;
    }

    /** Nuevo constructor
    * @param FileReader r
    * @param Parser parser
    */
    public Flexer(java.io.Reader r, Parser parser){
    	   this(r);
    	   this.yyparser = parser;
    }

    /** Función que maneja los niveles de indetación
    * @param int espacios - nivel de indetación actual.
    * @return void
    */
    public void indentacion(int espacios){
        if(pila.empty()){ //ponerle un cero a la pila si esta vacia
             pila.push(new Integer(0));
        }

        Integer tope = pila.peek();

        if(tope != espacios){
	    //Se debe emitir un DEINDENTA por cada nivel mayor al actual
            if(tope > espacios){
                while(pila.peek() > espacios &&  pila.peek()!=0 ){
                    pila.pop();
                    dedents += 1;
                }
                if(pila.peek() == espacios){
		    yybegin(DEINDENTA);
                }else{
		    System.out.println("Error de indentación. Línea "+(yyline+1));
		    System.exit(1);
		}
                return;
            }
   	    //El nivel actual de indentación es mayor a los anteriores.
            pila.push(espacios);
	    yybegin(CODIGO);
            indents = 1;
        }else yybegin(CODIGO);
    }


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Flexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public Flexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 1700) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public int yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          zzR = false;
          break;
        case '\r':
          yyline++;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
          }
          break;
        default:
          zzR = false;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 18: 
          { return Parser.DIV;
          }
        case 45: break;
        case 8: 
          { cadena = yytext();
          }
        case 46: break;
        case 14: 
          { yyparser.yylval = new IdentificadorHoja(yytext()); return Parser.IDENTIFICADOR;
          }
        case 47: break;
        case 40: 
          { yyparser.yylval = new BooleanoHoja(Boolean.parseBoolean(yytext()));
                                            return Parser.BOOLEANO;
          }
        case 48: break;
        case 38: 
          { return Parser.NOT;
          }
        case 49: break;
        case 37: 
          { return Parser.AND;
          }
        case 50: break;
        case 43: 
          { return Parser.WHILE;
          }
        case 51: break;
        case 34: 
          { return Parser.DIFF;
          }
        case 52: break;
        case 29: 
          { return Parser.POTENCIA;
          }
        case 53: break;
        case 23: 
          { return Parser.PA;
          }
        case 54: break;
        case 22: 
          { return Parser.EQ;
          }
        case 55: break;
        case 10: 
          { yybegin(CODIGO);
                  yyparser.yylval = new CadenaHoja(cadena);
                  cadena = "";
					        return Parser.CADENA;
          }
        case 56: break;
        case 4: 
          { yypushback(1);
					    this.indentacion(actual);
					    if(indents == 1){
					      indents = 0;
					      return Parser.INDENTA;
					    }
          }
        case 57: break;
        case 20: 
          { return Parser.LE;
          }
        case 58: break;
        case 9: 
          { System.out.println("Unexpected newline. Line "+(yyline+1));
					     System.exit(1);
          }
        case 59: break;
        case 31: 
          { return Parser.LEQ;
          }
        case 60: break;
        case 36: 
          { return Parser.IF;
          }
        case 61: break;
        case 28: 
          { System.out.println("Error de indentación. Línea "+(yyline+1));
					    System.exit(1);
          }
        case 62: break;
        case 39: 
          { return Parser.FOR;
          }
        case 63: break;
        case 12: 
          { yyparser.yylval = new IntHoja(Integer.parseInt(yytext()));
                                            return Parser.ENTERO;
          }
        case 64: break;
        case 17: 
          { return Parser.POR;
          }
        case 65: break;
        case 24: 
          { return Parser.PC;
          }
        case 66: break;
        case 30: 
          { return Parser.DIVENTERA;
          }
        case 67: break;
        case 44: 
          { return Parser.PRINT;
          }
        case 68: break;
        case 15: 
          { return Parser.MAS;
          }
        case 69: break;
        case 1: 
          { yypushback(1); yybegin(CODIGO);
          }
        case 70: break;
        case 3: 
          { System.out.println("Error de sintáxis: caractér inválido: " + yytext() + "\nLínea "+(yyline+1));
					    System.exit(1);
          }
        case 71: break;
        case 21: 
          { return Parser.GR;
          }
        case 72: break;
        case 42: 
          { return Parser.ELIF;
          }
        case 73: break;
        case 27: 
          { yypushback(1);
  					    if(dedents > 0){
						dedents--;
						return Parser.DEINDENTA;
  					    }
					    yybegin(CODIGO);
          }
        case 74: break;
        case 5: 
          { actual = 0;
          }
        case 75: break;
        case 7: 
          { actual += 4;
          }
        case 76: break;
        case 13: 
          { yybegin(INDENTA); actual=0; return Parser.SALTO;
          }
        case 77: break;
        case 35: 
          { return Parser.OR;
          }
        case 78: break;
        case 32: 
          { return Parser.GRQ;
          }
        case 79: break;
        case 33: 
          { return Parser.EQUALS;
          }
        case 80: break;
        case 16: 
          { return Parser.MENOS;
          }
        case 81: break;
        case 41: 
          { return Parser.ELSE;
          }
        case 82: break;
        case 26: 
          { yybegin(CADENA);
          }
        case 83: break;
        case 6: 
          { actual++;
          }
        case 84: break;
        case 25: 
          { return Parser.DOBLEPUNTO;
          }
        case 85: break;
        case 11: 
          { yyparser.yylval = new RealHoja(Double.parseDouble(yytext()));
                                        return Parser.REAL;
          }
        case 86: break;
        case 2: 
          { 
          }
        case 87: break;
        case 19: 
          { return Parser.MODULO;
          }
        case 88: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              {
                this.indentacion(0);
					    if(dedents > 0){
					      dedents--;
					      return Parser.DEINDENTA;
					    }else{
                                              return 0;
				            }
              }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
