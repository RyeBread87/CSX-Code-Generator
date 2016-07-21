/*  Replace this with your solution from project 2 */
import java_cup.runtime.*;
class CSXToken {
	int linenum;
	int colnum;
	CSXToken(int line,int col){
		linenum=line;colnum=col;};
}
class CSXIntLitToken extends CSXToken {
	int intValue;
	CSXIntLitToken(int val,int line,int col){
		super(line,col);intValue=val;};
}
//class CSXIdentifierToken extends CSXToken {
//	static Registration reg = new Registration();
//	SerialNum serialNum;
//	CSXIdentifierToken(String text,int line,int col){
//		super(line,col);serialNum=reg.registerStr(text);};
//}
class CSXIdentifierToken extends CSXToken {
	String identifierText;
	CSXIdentifierToken(String text,int line,int col){
		super(line,col);identifierText=text;};
}
class CSXCharLitToken extends CSXToken {
	char charValue;
	CSXCharLitToken(char val,int line,int col){
		super(line,col);charValue=val;};
}
//class CSXStringLitToken extends CSXToken {
//	String stringValue;
//	String fullStringValue;
//	CSXStringLitToken(String text,int line,int col){
//		super(line,col);
//		fullStringValue=text;
//		stringValue=null;// This will have to be changed
//	};
//}
class CSXStringLitToken extends CSXToken {
	String stringText; // Full text of string literal,
                          //  including quotes & escapes
	CSXStringLitToken(String text,int line,int col){
		super(line,col);
		stringText=text;
	};
}
// This class is used to track line and column numbers
// Feel free to change to extend it
class Pos {
	static int  linenum = 1; /* maintain this as line number current
                                 token was scanned on */
	static int  colnum = 1; /* maintain this as column number current
                                 token began at */
	static int  line = 1; /* maintain this as line number after
					scanning current token  */
	static int  col = 1; /* maintain this as column number after
					scanning current token  */
	static void setpos() { // set starting position for current token
		linenum = line;
		colnum = col;
	}
}


class Yylex {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final char YYEOF = '\uFFFF';
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yy_lexical_state;

	Yylex (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	Yylex (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private Yylex () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yy_lexical_state = YYINITIAL;
	}

	private boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int yy_state_dtrans[] = {
		0
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private char yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YYEOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YYEOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_start () {
		++yy_buffer_start;
	}
	private void yy_pushback () {
		--yy_buffer_end;
	}
	private void yy_mark_start () {
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int yy_acpt[] = {
		YY_NOT_ACCEPT,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR
	};
	private int yy_cmap[] = {
		0, 0, 0, 0, 0, 0, 0, 0,
		0, 1, 2, 0, 0, 0, 0, 0,
		0, 0, 0, 0, 0, 0, 0, 0,
		0, 0, 0, 0, 0, 0, 0, 0,
		1, 3, 0, 0, 0, 0, 0, 0,
		4, 5, 0, 6, 0, 7, 0, 0,
		8, 8, 8, 8, 8, 8, 8, 8,
		8, 8, 0, 9, 0, 10, 0, 0,
		0, 11, 12, 11, 11, 11, 13, 11,
		11, 14, 11, 11, 15, 11, 16, 17,
		18, 11, 19, 11, 20, 11, 11, 11,
		11, 11, 11, 0, 0, 0, 0, 0,
		0, 11, 12, 11, 11, 11, 13, 11,
		11, 14, 11, 11, 15, 11, 16, 17,
		18, 11, 19, 11, 20, 11, 11, 11,
		11, 11, 11, 21, 0, 22, 0, 0
		
	};
	private int yy_rmap[] = {
		0, 1, 1, 1, 1, 1, 1, 1,
		2, 1, 3, 4, 1, 1, 1, 1,
		4, 4, 4, 4, 5, 6, 7, 8,
		9, 10, 11, 12, 13, 14 
	};
	private int yy_nxt[][] = {
		{ 1, 2, 3, 20, 4, 5, 6, 7,
			8, 9, 10, 11, 27, 11, 21, 11,
			11, 11, 29, 11, 11, 12, 13 
		},
		{ -1, -1, -1, -1, -1, -1, -1, -1,
			-1, -1, -1, -1, -1, -1, -1, -1,
			-1, -1, -1, -1, -1, -1, -1 
		},
		{ -1, -1, -1, -1, -1, -1, -1, -1,
			8, -1, -1, -1, -1, -1, -1, -1,
			-1, -1, -1, -1, -1, -1, -1 
		},
		{ -1, -1, -1, -1, -1, -1, -1, -1,
			-1, -1, 15, -1, -1, -1, -1, -1,
			-1, -1, -1, -1, -1, -1, -1 
		},
		{ -1, -1, -1, -1, -1, -1, -1, -1,
			11, -1, -1, 11, 11, 11, 11, 11,
			11, 11, 11, 11, 11, -1, -1 
		},
		{ -1, -1, -1, -1, -1, -1, -1, -1,
			-1, -1, 14, -1, -1, -1, -1, -1,
			-1, -1, -1, -1, -1, -1, -1 
		},
		{ -1, -1, -1, -1, -1, -1, -1, -1,
			11, -1, -1, 11, 11, 16, 11, 11,
			22, 11, 11, 11, 11, -1, -1 
		},
		{ -1, -1, -1, -1, -1, -1, -1, -1,
			11, -1, -1, 11, 11, 11, 11, 11,
			11, 11, 11, 11, 17, -1, -1 
		},
		{ -1, -1, -1, -1, -1, -1, -1, -1,
			11, -1, -1, 11, 11, 11, 11, 18,
			11, 11, 11, 11, 11, -1, -1 
		},
		{ -1, -1, -1, -1, -1, -1, -1, -1,
			11, -1, -1, 11, 11, 11, 11, 11,
			11, 11, 11, 11, 19, -1, -1 
		},
		{ -1, -1, -1, -1, -1, -1, -1, -1,
			11, -1, -1, 11, 11, 11, 11, 11,
			11, 23, 11, 11, 11, -1, -1 
		},
		{ -1, -1, -1, -1, -1, -1, -1, -1,
			11, -1, -1, 11, 11, 11, 11, 11,
			24, 11, 11, 11, 11, -1, -1 
		},
		{ -1, -1, -1, -1, -1, -1, -1, -1,
			11, -1, -1, 11, 11, 11, 11, 11,
			11, 25, 11, 11, 11, -1, -1 
		},
		{ -1, -1, -1, -1, -1, -1, -1, -1,
			11, -1, -1, 11, 11, 11, 26, 11,
			11, 11, 11, 11, 11, -1, -1 
		},
		{ -1, -1, -1, -1, -1, -1, -1, -1,
			11, -1, -1, 11, 11, 11, 11, 11,
			11, 11, 11, 28, 11, -1, -1 
		}
	};
	public Symbol yylex ()
		throws java.io.IOException {
		char yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			if (YYEOF != yy_lookahead) {
				yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YYEOF == yy_lookahead && true == yy_initial) {

return new Symbol(sym.EOF, new  CSXToken(0,0));
				}
				else if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_to_mark();
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_pushback();
					}
					if (0 != (YY_START & yy_anchor)) {
						yy_move_start();
					}
					switch (yy_last_accept_state) {
					case 1:
						{System.err.println("Lexical error (line " + Pos.linenum +
				", column " + Pos.colnum +
				"): " + yytext() + " ignored.");
			Pos.col +=1;}
					case -2:
						break;
					case 2:
						{Pos.col +=1;}
					case -3:
						break;
					case 3:
						{Pos.line +=1; Pos.col = 1;}
					case -4:
						break;
					case 4:
						{Pos.setpos(); Pos.col +=1;
		return new Symbol(sym.LPAREN,
			new CSXToken(Pos.linenum,Pos.colnum));}
					case -5:
						break;
					case 5:
						{Pos.setpos(); Pos.col +=1;
		return new Symbol(sym.RPAREN,
			new CSXToken(Pos.linenum,Pos.colnum));}
					case -6:
						break;
					case 6:
						{Pos.setpos(); Pos.col +=1;
		return new Symbol(sym.PLUS,
			new CSXToken(Pos.linenum,Pos.colnum));}
					case -7:
						break;
					case 7:
						{Pos.setpos(); Pos.col +=1;
		return new Symbol(sym.MINUS,
			new CSXToken(Pos.linenum,Pos.colnum));}
					case -8:
						break;
					case 8:
						{ Pos.setpos(); Pos.col += yytext().length();
		  return new Symbol(sym.INTLIT,
		  		new CSXIntLitToken(
					new Integer(yytext()).intValue(),
					Pos.linenum,Pos.colnum));}
					case -9:
						break;
					case 9:
						{Pos.setpos(); Pos.col +=1;
		return new Symbol(sym.SEMI,
			new CSXToken(Pos.linenum,Pos.colnum));}
					case -10:
						break;
					case 10:
						{Pos.setpos(); Pos.col +=1;
		return new Symbol(sym.ASG,
			new CSXToken(Pos.linenum,Pos.colnum));}
					case -11:
						break;
					case 11:
						{ Pos.setpos(); Pos.col += yytext().length();
		  return new Symbol(sym.IDENTIFIER,
				new CSXIdentifierToken(
					yytext(), Pos.linenum,Pos.colnum));}
					case -12:
						break;
					case 12:
						{Pos.setpos(); Pos.col +=1;
		return new Symbol(sym.LBRACE,
			new CSXToken(Pos.linenum,Pos.colnum));}
					case -13:
						break;
					case 13:
						{Pos.setpos(); Pos.col +=1;
		return new Symbol(sym.RBRACE,
			new CSXToken(Pos.linenum,Pos.colnum));}
					case -14:
						break;
					case 14:
						{Pos.setpos(); Pos.col +=1;
		return new Symbol(sym.NOTEQ,
			new CSXToken(Pos.linenum,Pos.colnum));}
					case -15:
						break;
					case 15:
						{Pos.setpos(); Pos.col +=1;
		return new Symbol(sym.EQ,
			new CSXToken(Pos.linenum,Pos.colnum));}
					case -16:
						break;
					case 16:
						{Pos.setpos(); Pos.col +=2;
		return new Symbol(sym.rw_IF,
			new CSXToken(Pos.linenum,Pos.colnum));}
					case -17:
						break;
					case 17:
						{Pos.setpos(); Pos.col +=3;
		return new Symbol(sym.rw_INT,
			new CSXToken(Pos.linenum,Pos.colnum));}
					case -18:
						break;
					case 18:
						{Pos.setpos(); Pos.col +=4;
		return new Symbol(sym.rw_BOOL,
			new CSXToken(Pos.linenum,Pos.colnum));}
					case -19:
						break;
					case 19:
						{Pos.setpos(); Pos.col +=5;
		return new Symbol(sym.rw_PRINT,
			new CSXToken(Pos.linenum,Pos.colnum));}
					case -20:
						break;
					case 20:
						{System.err.println("Lexical error (line " + Pos.linenum +
				", column " + Pos.colnum +
				"): " + yytext() + " ignored.");
			Pos.col +=1;}
					case -21:
						break;
					case 21:
						{ Pos.setpos(); Pos.col += yytext().length();
		  return new Symbol(sym.IDENTIFIER,
				new CSXIdentifierToken(
					yytext(), Pos.linenum,Pos.colnum));}
					case -22:
						break;
					case 22:
						{ Pos.setpos(); Pos.col += yytext().length();
		  return new Symbol(sym.IDENTIFIER,
				new CSXIdentifierToken(
					yytext(), Pos.linenum,Pos.colnum));}
					case -23:
						break;
					case 23:
						{ Pos.setpos(); Pos.col += yytext().length();
		  return new Symbol(sym.IDENTIFIER,
				new CSXIdentifierToken(
					yytext(), Pos.linenum,Pos.colnum));}
					case -24:
						break;
					case 24:
						{ Pos.setpos(); Pos.col += yytext().length();
		  return new Symbol(sym.IDENTIFIER,
				new CSXIdentifierToken(
					yytext(), Pos.linenum,Pos.colnum));}
					case -25:
						break;
					case 25:
						{ Pos.setpos(); Pos.col += yytext().length();
		  return new Symbol(sym.IDENTIFIER,
				new CSXIdentifierToken(
					yytext(), Pos.linenum,Pos.colnum));}
					case -26:
						break;
					case 26:
						{ Pos.setpos(); Pos.col += yytext().length();
		  return new Symbol(sym.IDENTIFIER,
				new CSXIdentifierToken(
					yytext(), Pos.linenum,Pos.colnum));}
					case -27:
						break;
					case 27:
						{ Pos.setpos(); Pos.col += yytext().length();
		  return new Symbol(sym.IDENTIFIER,
				new CSXIdentifierToken(
					yytext(), Pos.linenum,Pos.colnum));}
					case -28:
						break;
					case 28:
						{ Pos.setpos(); Pos.col += yytext().length();
		  return new Symbol(sym.IDENTIFIER,
				new CSXIdentifierToken(
					yytext(), Pos.linenum,Pos.colnum));}
					case -29:
						break;
					case 29:
						{ Pos.setpos(); Pos.col += yytext().length();
		  return new Symbol(sym.IDENTIFIER,
				new CSXIdentifierToken(
					yytext(), Pos.linenum,Pos.colnum));}
					case -30:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
					}
				}
			}
		}
	}
}
