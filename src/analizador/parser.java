
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package analizador;

import java.util.ArrayList;
import java_cup.runtime.*;
import java_cup.runtime.XMLElement;
import proyecto1_olc1.NodoArbol;
import proyecto1_olc1.Tree;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\035\000\002\002\004\000\002\002\012\000\002\003" +
    "\004\000\002\003\003\000\002\005\011\000\002\005\007" +
    "\000\002\011\005\000\002\011\005\000\002\011\005\000" +
    "\002\011\005\000\002\011\005\000\002\011\003\000\002" +
    "\007\005\000\002\007\003\000\002\012\003\000\002\012" +
    "\003\000\002\012\003\000\002\012\003\000\002\012\003" +
    "\000\002\006\005\000\002\006\005\000\002\006\004\000" +
    "\002\006\004\000\002\006\004\000\002\006\003\000\002" +
    "\006\005\000\002\004\004\000\002\004\003\000\002\010" +
    "\006" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\107\000\004\013\005\001\002\000\004\002\111\001" +
    "\002\000\006\005\007\027\011\001\002\000\010\005\007" +
    "\012\074\027\011\001\002\000\004\015\036\001\002\000" +
    "\010\005\ufffe\012\ufffe\027\ufffe\001\002\000\004\017\012" +
    "\001\002\000\004\016\013\001\002\000\020\013\016\022" +
    "\015\023\020\024\022\025\017\026\021\032\014\001\002" +
    "\000\022\011\uffe9\013\uffe9\022\uffe9\023\uffe9\024\uffe9\025" +
    "\uffe9\026\uffe9\032\uffe9\001\002\000\020\013\016\022\015" +
    "\023\020\024\022\025\017\026\021\032\014\001\002\000" +
    "\004\027\032\001\002\000\020\013\016\022\015\023\020" +
    "\024\022\025\017\026\021\032\014\001\002\000\020\013" +
    "\016\022\015\023\020\024\022\025\017\026\021\032\014" +
    "\001\002\000\020\013\016\022\015\023\020\024\022\025" +
    "\017\026\021\032\014\001\002\000\020\013\016\022\015" +
    "\023\020\024\022\025\017\026\021\032\014\001\002\000" +
    "\004\011\024\001\002\000\010\005\ufffc\012\ufffc\027\ufffc" +
    "\001\002\000\020\013\016\022\015\023\020\024\022\025" +
    "\017\026\021\032\014\001\002\000\022\011\uffed\013\uffed" +
    "\022\uffed\023\uffed\024\uffed\025\uffed\026\uffed\032\uffed\001" +
    "\002\000\022\011\uffec\013\uffec\022\uffec\023\uffec\024\uffec" +
    "\025\uffec\026\uffec\032\uffec\001\002\000\022\011\uffeb\013" +
    "\uffeb\022\uffeb\023\uffeb\024\uffeb\025\uffeb\026\uffeb\032\uffeb" +
    "\001\002\000\022\011\uffea\013\uffea\022\uffea\023\uffea\024" +
    "\uffea\025\uffea\026\uffea\032\uffea\001\002\000\004\014\033" +
    "\001\002\000\022\011\uffe8\013\uffe8\022\uffe8\023\uffe8\024" +
    "\uffe8\025\uffe8\026\uffe8\032\uffe8\001\002\000\020\013\016" +
    "\022\015\023\020\024\022\025\017\026\021\032\014\001" +
    "\002\000\022\011\uffee\013\uffee\022\uffee\023\uffee\024\uffee" +
    "\025\uffee\026\uffee\032\uffee\001\002\000\004\027\037\001" +
    "\002\000\004\017\040\001\002\000\004\016\041\001\002" +
    "\000\014\004\050\006\047\007\051\010\046\031\043\001" +
    "\002\000\006\011\ufff4\020\ufff4\001\002\000\010\011\ufff0" +
    "\020\ufff0\021\072\001\002\000\004\011\071\001\002\000" +
    "\006\011\ufff6\020\062\001\002\000\010\011\uffef\020\uffef" +
    "\021\060\001\002\000\010\011\ufff2\020\ufff2\021\056\001" +
    "\002\000\010\011\ufff1\020\ufff1\021\054\001\002\000\010" +
    "\011\ufff3\020\ufff3\021\052\001\002\000\004\007\053\001" +
    "\002\000\004\011\ufffb\001\002\000\004\004\055\001\002" +
    "\000\004\011\ufff8\001\002\000\004\006\057\001\002\000" +
    "\004\011\ufffa\001\002\000\004\010\061\001\002\000\004" +
    "\011\ufff9\001\002\000\014\004\070\006\067\007\066\010" +
    "\065\031\064\001\002\000\006\011\ufff5\020\ufff5\001\002" +
    "\000\006\011\ufff0\020\ufff0\001\002\000\006\011\uffef\020" +
    "\uffef\001\002\000\006\011\ufff3\020\ufff3\001\002\000\006" +
    "\011\ufff2\020\ufff2\001\002\000\006\011\ufff1\020\ufff1\001" +
    "\002\000\010\005\ufffd\012\ufffd\027\ufffd\001\002\000\004" +
    "\031\073\001\002\000\004\011\ufff7\001\002\000\004\012" +
    "\076\001\002\000\010\005\uffff\012\uffff\027\uffff\001\002" +
    "\000\004\012\077\001\002\000\004\012\100\001\002\000" +
    "\004\027\103\001\002\000\006\014\110\027\103\001\002" +
    "\000\006\014\uffe6\027\uffe6\001\002\000\004\015\104\001" +
    "\002\000\004\030\105\001\002\000\004\011\106\001\002" +
    "\000\006\014\uffe5\027\uffe5\001\002\000\006\014\uffe7\027" +
    "\uffe7\001\002\000\004\002\000\001\002\000\004\002\001" +
    "\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\107\000\004\002\003\001\001\000\002\001\001\000" +
    "\006\003\005\005\007\001\001\000\004\005\074\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\006\022\001\001\000\002\001\001" +
    "\000\004\006\033\001\001\000\002\001\001\000\004\006" +
    "\030\001\001\000\004\006\027\001\001\000\004\006\026" +
    "\001\001\000\004\006\024\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\006\025\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\006\034\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\010\007\044\011\043\012\041\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\012\062\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\006\004\100\010\101\001\001" +
    "\000\004\010\106\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    /**
     * Método al que se llama automáticamente ante algún error sintactico.
     **/ 
    
    public ArrayList<Tree> leaves = new ArrayList();
    public ArrayList<ArrayList> table = new ArrayList();

    public void syntax_error(Symbol s){ 
        System.out.println("Error Sintáctico en la Línea " + (s.left) +
        " Columna "+s.right+ ". No se esperaba este componente: " +s.value+"."); 
    } 

    /**
     * Método al que se llama automáticamente ante algún error sintáctico 
     * en el que ya no es posible una recuperación de errores.
     **/ 
    public void unrecovered_syntax_error(Symbol s) throws java.lang.Exception{ 
        System.out.println("Error síntactico irrecuperable en la Línea " + 
        (s.left)+ " Columna "+s.right+". Componente " + s.value + 
        " no reconocido."); 
    }  


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parser$do_action_part00000000(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= ini EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // ini ::= LLAVE_ABRIR primer_bloque PORCENTAJE PORCENTAJE PORCENTAJE PORCENTAJE segundo_bloque LLAVE_CERRAR 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("ini",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-7)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // primer_bloque ::= primer_bloque sentencia 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("primer_bloque",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // primer_bloque ::= sentencia 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("primer_bloque",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // sentencia ::= CONJ DOS_PUNTOS NOMBRE_VARIABLE GUION MAYOR notacion_conjunto PUNTO_Y_COMA 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("sentencia",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // sentencia ::= NOMBRE_VARIABLE GUION MAYOR er PUNTO_Y_COMA 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
                
                NodoArbol stm = (NodoArbol)(Object)a;
                Tree nueva_raiz = new Tree(stm);
                leaves.add(nueva_raiz);

                    

              CUP$parser$result = parser.getSymbolFactory().newSymbol("sentencia",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // notacion_conjunto ::= MINUSCULAS VIRGUILILLA MINUSCULAS 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("notacion_conjunto",7, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // notacion_conjunto ::= MAYUSCULAS VIRGUILILLA MAYUSCULAS 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("notacion_conjunto",7, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // notacion_conjunto ::= SIGNOS_ASCII VIRGUILILLA SIGNOS_ASCII 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("notacion_conjunto",7, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // notacion_conjunto ::= ENTERO VIRGUILILLA ENTERO 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("notacion_conjunto",7, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // notacion_conjunto ::= CONJUNTO_ABC VIRGUILILLA CONJUNTO_ABC 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("notacion_conjunto",7, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // notacion_conjunto ::= conjuntos_con_comas 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("notacion_conjunto",7, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // conjuntos_con_comas ::= conjuntos_con_comas COMA elemento 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("conjuntos_con_comas",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // conjuntos_con_comas ::= elemento 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("conjuntos_con_comas",5, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // elemento ::= MINUSCULAS 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("elemento",8, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // elemento ::= MAYUSCULAS 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("elemento",8, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // elemento ::= ENTERO 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("elemento",8, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // elemento ::= CONJUNTO_ABC 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("elemento",8, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // elemento ::= SIGNOS_ASCII 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("elemento",8, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // er ::= PUNTO er er 
            {
              Object RESULT =null;
		int characterleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int characterright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		String character = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int dileft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int diright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object di = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int ddleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int ddright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object dd = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  
                        NodoArbol nconjuncion = new NodoArbol(character);    
                        NodoArbol leftp = (NodoArbol)(Object)di;
                        NodoArbol rightp = (NodoArbol)(Object)dd;
                        nconjuncion.setIzquierdo(leftp);
                        nconjuncion.setDerecho(rightp);
                        RESULT = nconjuncion;
                                
              CUP$parser$result = parser.getSymbolFactory().newSymbol("er",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // er ::= DISYUNCION er er 
            {
              Object RESULT =null;
		int characterleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int characterright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		String character = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int dileft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int diright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object di = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int ddleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int ddright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object dd = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  
                        NodoArbol ndisyuncion = new NodoArbol(character);    
                        NodoArbol lefto = (NodoArbol)(Object)di;
                        NodoArbol righto = (NodoArbol)(Object)dd;
                        ndisyuncion.setIzquierdo(lefto);
                        ndisyuncion.setDerecho(righto);
                        RESULT = ndisyuncion;
                    
              CUP$parser$result = parser.getSymbolFactory().newSymbol("er",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // er ::= KLEENE er 
            {
              Object RESULT =null;
		int characterleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int characterright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String character = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int kleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int kright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object k = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  
                        NodoArbol nk = new NodoArbol(character);
              
                        NodoArbol unariok = (NodoArbol)(Object)k;
                        nk.setIzquierdo(unariok);
                      
                        RESULT = nk;
                    
              CUP$parser$result = parser.getSymbolFactory().newSymbol("er",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // er ::= SUMA er 
            {
              Object RESULT =null;
		int characterleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int characterright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String character = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int pleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int pright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object p = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  

                        NodoArbol np = new NodoArbol(character);
              
                        NodoArbol unariop = (NodoArbol)(Object)p;
                        np.setIzquierdo(unariop);
                      
                        RESULT = np;
                    
              CUP$parser$result = parser.getSymbolFactory().newSymbol("er",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // er ::= INTERROGACION er 
            {
              Object RESULT =null;
		int characterleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int characterright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String character = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  
                                NodoArbol nb = new NodoArbol(character);
              
                                NodoArbol unariob = (NodoArbol)(Object)a;
                                nb.setIzquierdo(unariob);
                               RESULT = nb;
                    
              CUP$parser$result = parser.getSymbolFactory().newSymbol("er",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // er ::= CARACTER_ESPECIAL 
            {
              Object RESULT =null;
		int characterleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int characterright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String character = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		                               NodoArbol nz = new NodoArbol(character);
                                                                      nz.setHojas(true);
                                                                      RESULT = nz;
                                     
              CUP$parser$result = parser.getSymbolFactory().newSymbol("er",4, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // er ::= LLAVE_ABRIR NOMBRE_VARIABLE LLAVE_CERRAR 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int characterleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int characterright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String character = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int cright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String c = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  NodoArbol nd = new NodoArbol(character);
                                                                      RESULT = nd;
                                                                   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("er",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // segundo_bloque ::= segundo_bloque sentencias_segundobloque 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("segundo_bloque",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // segundo_bloque ::= sentencias_segundobloque 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("segundo_bloque",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // sentencias_segundobloque ::= NOMBRE_VARIABLE DOS_PUNTOS TEXT PUNTO_Y_COMA 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("sentencias_segundobloque",6, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
              return CUP$parser$do_action_part00000000(
                               CUP$parser$act_num,
                               CUP$parser$parser,
                               CUP$parser$stack,
                               CUP$parser$top);
    }
}

}
