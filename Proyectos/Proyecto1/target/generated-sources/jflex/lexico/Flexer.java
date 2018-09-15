/* The following code was generated by JFlex 1.4.3 on 9/14/18 10:36 PM */

package lexico;
import java.util.*;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 9/14/18 10:36 PM from the specification file
 * <tt>/home/alexis/Documents/Compiladores/Compiladores/Proyectos/Proyecto1/src/main/jflex/Flexer.jflex</tt>
 */
public class Flexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int INDENTACION = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1, 1
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\37\1\30\25\0\1\2\1\25\1\27\1\32\1\0\1\25"+
    "\2\0\1\25\1\25\1\25\1\24\1\0\1\24\1\5\1\25\1\3"+
    "\11\4\1\36\1\0\1\24\1\26\1\24\2\0\5\1\1\35\15\1"+
    "\1\33\6\1\1\0\1\31\2\0\1\1\1\0\1\6\2\1\1\10"+
    "\1\17\1\20\1\1\1\14\1\15\2\1\1\16\1\1\1\7\1\11"+
    "\1\23\1\1\1\21\1\22\1\12\1\34\1\1\1\13\3\1\uff85\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\1\2\1\3\2\4\1\1\7\2\2\5"+
    "\1\1\1\6\1\1\2\2\1\7\1\10\1\11\2\12"+
    "\1\1\7\10\2\13\1\1\1\14\2\10\1\15\1\16"+
    "\1\17\2\2\1\20\3\2\1\0\1\21\2\0\2\2"+
    "\1\22\2\10\1\23\3\10\1\0\1\24\1\0\2\10"+
    "\3\2\1\25\2\2\3\10\1\26\2\10\1\27\1\30";

  private static int [] zzUnpackAction() {
    int [] result = new int[82];
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
    "\0\0\0\40\0\100\0\140\0\100\0\200\0\240\0\300"+
    "\0\340\0\u0100\0\u0120\0\u0140\0\u0160\0\u0180\0\u01a0\0\u01c0"+
    "\0\100\0\u01e0\0\100\0\u0200\0\u0220\0\u0240\0\100\0\u0260"+
    "\0\100\0\u0280\0\u02a0\0\u02c0\0\u02e0\0\u0300\0\u0320\0\u0340"+
    "\0\u0360\0\u0380\0\u03a0\0\u03c0\0\100\0\u03e0\0\100\0\u0400"+
    "\0\u0420\0\100\0\100\0\300\0\u0440\0\u0460\0\140\0\u0480"+
    "\0\u04a0\0\u04c0\0\u01e0\0\u04e0\0\u04e0\0\u0200\0\u0500\0\u0520"+
    "\0\u02c0\0\u0540\0\u0560\0\u0260\0\u0580\0\u05a0\0\u05c0\0\u03e0"+
    "\0\u05e0\0\u05e0\0\u0600\0\u0620\0\u0640\0\u0660\0\u0680\0\u04e0"+
    "\0\u06a0\0\u06c0\0\u06e0\0\u0700\0\u0720\0\u05e0\0\u0740\0\u0760"+
    "\0\140\0\u0260";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[82];
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
    "\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12"+
    "\1\4\1\13\1\4\1\14\1\4\1\15\1\4\1\16"+
    "\3\4\1\17\1\20\1\21\1\20\1\22\1\23\1\3"+
    "\1\24\1\25\1\4\1\26\1\27\2\3\1\30\1\31"+
    "\1\32\1\33\1\34\1\35\1\36\1\30\1\37\1\30"+
    "\1\40\1\30\1\41\1\30\1\42\3\30\1\43\1\44"+
    "\1\45\1\44\1\46\1\47\1\3\1\24\1\50\1\30"+
    "\1\51\1\52\1\53\41\0\1\4\1\0\2\4\1\0"+
    "\16\4\7\0\3\4\7\0\1\54\35\0\2\7\1\54"+
    "\35\0\2\54\34\0\1\4\1\0\2\4\1\0\1\4"+
    "\1\55\14\4\7\0\3\4\3\0\1\4\1\0\2\4"+
    "\1\0\3\4\1\56\12\4\7\0\3\4\3\0\1\4"+
    "\1\0\2\4\1\0\13\4\1\57\2\4\7\0\3\4"+
    "\3\0\1\4\1\0\2\4\1\0\6\4\1\60\7\4"+
    "\7\0\3\4\3\0\1\4\1\0\2\4\1\0\12\4"+
    "\1\57\3\4\7\0\3\4\3\0\1\4\1\0\2\4"+
    "\1\0\10\4\1\61\5\4\7\0\3\4\3\0\1\4"+
    "\1\0\2\4\1\0\13\4\1\62\2\4\7\0\3\4"+
    "\30\0\1\21\11\0\27\63\1\64\1\0\1\65\6\63"+
    "\30\66\1\5\7\66\1\0\1\4\1\0\2\4\1\0"+
    "\13\4\1\67\2\4\7\0\3\4\3\0\1\4\1\0"+
    "\2\4\1\0\1\70\15\4\7\0\3\4\3\0\1\30"+
    "\1\0\2\30\1\0\16\30\7\0\3\30\7\0\1\71"+
    "\35\0\2\33\1\71\35\0\2\71\34\0\1\30\1\0"+
    "\2\30\1\0\1\30\1\72\14\30\7\0\3\30\3\0"+
    "\1\30\1\0\2\30\1\0\3\30\1\73\12\30\7\0"+
    "\3\30\3\0\1\30\1\0\2\30\1\0\13\30\1\74"+
    "\2\30\7\0\3\30\3\0\1\30\1\0\2\30\1\0"+
    "\6\30\1\75\7\30\7\0\3\30\3\0\1\30\1\0"+
    "\2\30\1\0\12\30\1\74\3\30\7\0\3\30\3\0"+
    "\1\30\1\0\2\30\1\0\10\30\1\76\5\30\7\0"+
    "\3\30\3\0\1\30\1\0\2\30\1\0\13\30\1\77"+
    "\2\30\7\0\3\30\30\0\1\45\11\0\27\100\1\101"+
    "\1\0\1\102\6\100\1\0\1\30\1\0\2\30\1\0"+
    "\13\30\1\103\2\30\7\0\3\30\3\0\1\30\1\0"+
    "\2\30\1\0\1\104\15\30\7\0\3\30\3\0\1\4"+
    "\1\0\2\4\1\0\2\4\1\57\13\4\7\0\3\4"+
    "\3\0\1\4\1\0\2\4\1\0\4\4\1\57\11\4"+
    "\7\0\3\4\3\0\1\4\1\0\2\4\1\0\7\4"+
    "\1\105\6\4\7\0\3\4\3\0\1\4\1\0\2\4"+
    "\1\0\7\4\1\15\4\4\1\106\1\4\7\0\3\4"+
    "\3\0\1\4\1\0\2\4\1\0\7\4\1\107\6\4"+
    "\7\0\3\4\2\0\27\65\1\110\1\0\7\65\1\0"+
    "\1\4\1\0\2\4\1\0\16\4\7\0\1\4\1\111"+
    "\1\4\3\0\1\4\1\0\2\4\1\0\10\4\1\112"+
    "\5\4\7\0\3\4\3\0\1\30\1\0\2\30\1\0"+
    "\2\30\1\74\13\30\7\0\3\30\3\0\1\30\1\0"+
    "\2\30\1\0\4\30\1\74\11\30\7\0\3\30\3\0"+
    "\1\30\1\0\2\30\1\0\7\30\1\113\6\30\7\0"+
    "\3\30\3\0\1\30\1\0\2\30\1\0\7\30\1\41"+
    "\4\30\1\114\1\30\7\0\3\30\3\0\1\30\1\0"+
    "\2\30\1\0\7\30\1\115\6\30\7\0\3\30\2\0"+
    "\27\102\1\116\1\0\7\102\1\0\1\30\1\0\2\30"+
    "\1\0\16\30\7\0\1\30\1\117\1\30\3\0\1\30"+
    "\1\0\2\30\1\0\10\30\1\120\5\30\7\0\3\30"+
    "\3\0\1\4\1\0\2\4\1\0\10\4\1\106\5\4"+
    "\7\0\3\4\3\0\1\4\1\0\2\4\1\0\11\4"+
    "\1\57\4\4\7\0\3\4\3\0\1\4\1\0\2\4"+
    "\1\0\1\4\1\56\14\4\7\0\3\4\3\0\1\4"+
    "\1\0\2\4\1\0\11\4\1\121\4\4\7\0\3\4"+
    "\3\0\1\4\1\0\2\4\1\0\14\4\1\111\1\4"+
    "\7\0\3\4\3\0\1\30\1\0\2\30\1\0\10\30"+
    "\1\114\5\30\7\0\3\30\3\0\1\30\1\0\2\30"+
    "\1\0\11\30\1\74\4\30\7\0\3\30\3\0\1\30"+
    "\1\0\2\30\1\0\1\30\1\73\14\30\7\0\3\30"+
    "\3\0\1\30\1\0\2\30\1\0\11\30\1\122\4\30"+
    "\7\0\3\30\3\0\1\30\1\0\2\30\1\0\14\30"+
    "\1\117\1\30\7\0\3\30\2\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[1920];
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
    "\2\0\1\11\1\1\1\11\13\1\1\11\1\1\1\11"+
    "\3\1\1\11\1\1\1\11\13\1\1\11\1\1\1\11"+
    "\2\1\2\11\7\1\1\0\1\1\2\0\11\1\1\0"+
    "\1\1\1\0\20\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[82];
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
	Stack<Integer> indentaciones = new Stack<Integer>();
	int espacios = 0;

	public void analiza(String lexema){
		if(indentaciones.empty()){
			if(espacios == 0)
				System.out.printf("%s(%s)",lexema,yytext());
			else{
				System.out.printf("INDENTA(%d)",espacios);
				System.out.printf("%s(%s)",lexema,yytext());
				indentaciones.push(espacios);
			}
		}else{
			if(espacios == 0){
				while(!indentaciones.empty()){
					System.out.printf("DEINDENTA(%d)\n",indentaciones.pop());
				}
				System.out.printf("%s(%s)",lexema,yytext());
			}else if(espacios < indentaciones.peek()){
				System.out.printf("%s(%s)\n",lexema,yytext());		System.out.printf("DEINDENTA(%d)",indentaciones.pop());
			}else if(espacios == indentaciones.peek()){
				System.out.printf("%s(%s)",lexema,yytext());
			}else{
				System.out.printf("INDENTA(%d)",espacios);
				System.out.printf("%s(%s)",lexema,yytext());
				indentaciones.push(espacios);
			}
		}
		espacios = 0;
		yybegin(YYINITIAL);
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
    while (i < 120) {
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
        case 11: 
          { analiza("OPERADOR");
          }
        case 25: break;
        case 9: 
          { espacios++;
          }
        case 26: break;
        case 19: 
          { analiza("RESERVADA");
          }
        case 27: break;
        case 23: 
          { System.out.printf("BOOLEANO(%s)", yytext());
          }
        case 28: break;
        case 12: 
          { yybegin(YYINITIAL);
          }
        case 29: break;
        case 24: 
          { analiza("BOOLEANO");
          }
        case 30: break;
        case 17: 
          { System.out.printf("CADENA(%s)", yytext());
          }
        case 31: break;
        case 2: 
          { System.out.printf("IDENTIFICADOR(%s)", yytext());
          }
        case 32: break;
        case 18: 
          { analiza("REAL");
          }
        case 33: break;
        case 13: 
          { analiza("SEPARADOR");
          }
        case 34: break;
        case 14: 
          { espacios+=4;
          }
        case 35: break;
        case 8: 
          { analiza("IDENTIFICADOR");
          }
        case 36: break;
        case 3: 
          { /*IGNORAR*/
          }
        case 37: break;
        case 22: 
          { analiza("CADENAINVALIDA");
          }
        case 38: break;
        case 16: 
          { System.out.printf("RESERVADA(%s)", yytext());
          }
        case 39: break;
        case 21: 
          { System.out.println("\n" + "Error:Cadena mal formada" + " en linea " + (yyline+1)); System.exit(1);
          }
        case 40: break;
        case 1: 
          { System.out.println("\n" + "Error:Lexema no reconocido" + " en linea " + (yyline+1)); System.exit(1);
          }
        case 41: break;
        case 15: 
          { System.out.printf("REAL(%s)",yytext());
          }
        case 42: break;
        case 6: 
          { System.out.println("SALTO\n"); yybegin(INDENTACION);
          }
        case 43: break;
        case 4: 
          { System.out.printf("ENTERO(%s)", yytext());
          }
        case 44: break;
        case 5: 
          { System.out.printf("OPERADOR(%s)",yytext());
          }
        case 45: break;
        case 20: 
          { analiza("CADENA");
          }
        case 46: break;
        case 7: 
          { System.out.printf("SEPARADOR(%s)", yytext());
          }
        case 47: break;
        case 10: 
          { analiza("ENTERO");
          }
        case 48: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return YYEOF;
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }

  /**
   * Runs the scanner on input files.
   *
   * This is a standalone scanner, it will print any unmatched
   * text to System.out unchanged.
   *
   * @param argv   the command line, contains the filenames to run
   *               the scanner on.
   */
  public static void main(String argv[]) {
    if (argv.length == 0) {
      System.out.println("Usage : java Flexer <inputfile>");
    }
    else {
      for (int i = 0; i < argv.length; i++) {
        Flexer scanner = null;
        try {
          scanner = new Flexer( new java.io.FileReader(argv[i]) );
          while ( !scanner.zzAtEOF ) scanner.yylex();
        }
        catch (java.io.FileNotFoundException e) {
          System.out.println("File not found : \""+argv[i]+"\"");
        }
        catch (java.io.IOException e) {
          System.out.println("IO error scanning file \""+argv[i]+"\"");
          System.out.println(e);
        }
        catch (Exception e) {
          System.out.println("Unexpected exception:");
          e.printStackTrace();
        }
      }
    }
  }


}
