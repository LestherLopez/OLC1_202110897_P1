package analizador;
import java_cup.runtime.Symbol;

%%

%{
    //Código de usuario
%}

%class Lexico  // definir como trabajara el scanner 
%cup            // trabajar con cup 
%public         // tipo publico
%line           // conteo de lineas - linea por linea
%column           // conteo de columnas - columna por columna
%char           // caracter por caracter
%unicode        // tipo de codigicacion para que acepte la  ñ u otro caracter
%full

%init{ 
    yyline = 1; 
    yychar = 1; 
%init} 

//simbolos a aceptar
PUNTO_Y_COMA = ";"
PORCENTAJE = "%"
LLAVE_ABRIR = "{"
LLAVE_CERRAR = "}"
DOS_PUNTOS = ":"
MAYOR = ">"
GUION = "-"
COMA = ","
VIRGUILILLA = "~"
COMILLA = \"
PUNTO = "."
SUMA = "+"
DISYUNCION = "|"
INTERROGACION = "?"
KLEENE = "*"

//Palabras reservadas del lenguaje
CONJ = "CONJ"

//expresiones
MAYUSCULAS = [A-Z]
MINUSCULAS = [a-z]
ENTERO = [0-9]
SIGNOS_ASCII = [ -/:-@\[-`{-}]

SPACE   = [ \r\t]+
ENTER   = \r|\n|\r\n
CARACTER = [^\r\n]
COMENTARIO_MULTILINEA = "<!"[^/]~"!>"
COMENTARIO_SIMPLE = "//" {CARACTER}* {ENTER}?
//comillas


%%



{COMENTARIO_SIMPLE} {System.out.println(yytext()); }
{COMENTARIO_MULTILINEA} {System.out.println(yytext()); }

<YYINITIAL> {CONJ}  {System.out.println(yytext());   return new Symbol(sym.CONJ, yyline, yycolumn, yytext());  }
//<YYINITIAL> {CARACTER}  {System.out.println(yytext());   return new Symbol(sym.CARACTER, yyline, yycolumn, yytext());  }
<YYINITIAL> {SPACE}     { /*Espacios omitidos*/ }
<YYINITIAL> {ENTER}     { /*Saltos de linea omitido*/}
<YYINITIAL> {MAYUSCULAS}  {System.out.println(yytext());   return new Symbol(sym.MAYUSCULAS, yyline, yycolumn, yytext());  }
<YYINITIAL> {MINUSCULAS}  {System.out.println(yytext());   return new Symbol(sym.MINUSCULAS, yyline, yycolumn, yytext());  }
<YYINITIAL> {ENTERO}  {System.out.println(yytext());   return new Symbol(sym.ENTERO, yyline, yycolumn, yytext());  }
<YYINITIAL> {SIGNOS_ASCII}  {System.out.println(yytext());   return new Symbol(sym.SIGNOS_ASCII, yyline, yycolumn, yytext());  }



<YYINITIAL> {COMILLA}  {System.out.println(yytext());   return new Symbol(sym.COMILLA, yyline, yycolumn, yytext());  }
<YYINITIAL> {PUNTO_Y_COMA}  {System.out.println(yytext());   return new Symbol(sym.PUNTO_Y_COMA, yyline, yycolumn, yytext());  }
<YYINITIAL> {PORCENTAJE}  {System.out.println(yytext());   return new Symbol(sym.PORCENTAJE, yyline, yycolumn, yytext());  }
<YYINITIAL> {LLAVE_ABRIR}  {System.out.println(yytext());   return new Symbol(sym.LLAVE_ABRIR, yyline, yycolumn, yytext());  }
<YYINITIAL> {LLAVE_CERRAR}  {System.out.println(yytext());   return new Symbol(sym.LLAVE_CERRAR, yyline, yycolumn, yytext());  }
<YYINITIAL> {DOS_PUNTOS}  {System.out.println(yytext());   return new Symbol(sym.DOS_PUNTOS, yyline, yycolumn, yytext());  }
<YYINITIAL> {MAYOR}  {System.out.println(yytext());   return new Symbol(sym.MAYOR, yyline, yycolumn, yytext());  }
<YYINITIAL> {GUION}  {System.out.println(yytext());   return new Symbol(sym.GUION, yyline, yycolumn, yytext());  }
<YYINITIAL> {COMA}  { System.out.println(yytext());  return new Symbol(sym.COMA, yyline, yycolumn, yytext());  }
<YYINITIAL> {VIRGUILILLA}  { System.out.println(yytext());  return new Symbol(sym.VIRGUILILLA, yyline, yycolumn, yytext());  }
<YYINITIAL> {PUNTO}  {System.out.println(yytext());   return new Symbol(sym.PUNTO, yyline, yycolumn, yytext());  }
<YYINITIAL> {SUMA}  {System.out.println(yytext());   return new Symbol(sym.SUMA, yyline, yycolumn, yytext());  }
<YYINITIAL> {DISYUNCION}  {System.out.println(yytext());   return new Symbol(sym.DISYUNCION, yyline, yycolumn, yytext());  }
<YYINITIAL> {INTERROGACION}  {System.out.println(yytext());   return new Symbol(sym.INTERROGACION, yyline, yycolumn, yytext());  }
<YYINITIAL> {KLEENE}  {System.out.println(yytext());   return new Symbol(sym.KLEENE, yyline, yycolumn, yytext());  }

<YYINITIAL> . {
        String errLex = "Error léxico : '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+(yycolumn+1);
        System.out.println(errLex);
}