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

//simbolos a aceptar (15)
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

//Palabras reservadas del lenguaje(1)
CONJ = "CONJ"

//expresiones
CONJUNTO_ABC = [a-c]
MAYUSCULAS = [A-Z]
MINUSCULAS = [a-z]
ENTERO = [0-9]
SIGNOS_ASCII = [^[^ -}]0-9A-Za-z]
//SIGNOS_ASCII = [ -/:-@\[-`{-}]

CARACTER = ("!"[^\>]) |[^\!]
TEXT = \" ([^\"] | "\\\"")+ \"
SPACE   = [ \r\t\n]+

COMENTARIO_MULTILINEA = "<!"[^/]~"!>"
COMENTARIO_SIMPLE = "//" .* 

NOMBRE_VARIABLE= [0-9a-zA-Z_][a-zA-Z_]+
ESPECIALES_NOSALTADOS = [^\'\"]
CARACTER_ESPECIAL = (\" {ESPECIALES_NOSALTADOS} \") | ("\\\"" | "\\n" | "\\\'")
//CARACTER = [^.] | .
//COMENTARIO_MULTILINEA = "<!"[^/]~"!>"
//COMENTARIO_SIMPLE = "//" {CARACTER}* {ENTER}?
%%

<YYINITIAL> {COMENTARIO_MULTILINEA}     { /*Espacios omitidos*/ }
<YYINITIAL> {COMENTARIO_SIMPLE}     { /*Espacios omitidos*/ }
<YYINITIAL> {SPACE}     { /*Espacios omitidos*/ }
<YYINITIAL> {DOS_PUNTOS}  {System.out.println(yytext());   return new Symbol(sym.DOS_PUNTOS, yyline, yycolumn, yytext());  }
<YYINITIAL> {PORCENTAJE}  {System.out.println(yytext());   return new Symbol(sym.PORCENTAJE, yyline, yycolumn, yytext());  }
<YYINITIAL> {CONJ}  {System.out.println(yytext());   return new Symbol(sym.CONJ, yyline, yycolumn, yytext());  }


<YYINITIAL> {GUION}  {System.out.println(yytext());   return new Symbol(sym.GUION, yyline, yycolumn, yytext());  }
<YYINITIAL> {MAYOR}  {System.out.println(yytext());   return new Symbol(sym.MAYOR, yyline, yycolumn, yytext());  }
<YYINITIAL> {COMA}  { System.out.println(yytext());  return new Symbol(sym.COMA, yyline, yycolumn, yytext());  }
<YYINITIAL> {COMILLA}  { System.out.println(yytext());  return new Symbol(sym.COMILLA, yyline, yycolumn, yytext());  }
<YYINITIAL> {VIRGUILILLA}  { System.out.println(yytext());  return new Symbol(sym.VIRGUILILLA, yyline, yycolumn, yytext()); }
<YYINITIAL> {LLAVE_ABRIR}  {System.out.println(yytext());   return new Symbol(sym.LLAVE_ABRIR, yyline, yycolumn, yytext());  }
<YYINITIAL> {LLAVE_CERRAR}  {System.out.println(yytext());   return new Symbol(sym.LLAVE_CERRAR, yyline, yycolumn, yytext());  }

<YYINITIAL> {PUNTO}  {System.out.println(yytext());   return new Symbol(sym.PUNTO, yyline, yycolumn, yytext());  }
<YYINITIAL> {DISYUNCION}  {System.out.println(yytext());   return new Symbol(sym.DISYUNCION, yyline, yycolumn, yytext());  }
<YYINITIAL> {SUMA}  {System.out.println(yytext());   return new Symbol(sym.SUMA, yyline, yycolumn, yytext());  }
<YYINITIAL> {INTERROGACION}  {System.out.println(yytext());   return new Symbol(sym.INTERROGACION, yyline, yycolumn, yytext());  }
<YYINITIAL> {KLEENE}  {System.out.println(yytext());   return new Symbol(sym.KLEENE, yyline, yycolumn, yytext());  }

<YYINITIAL> {PUNTO_Y_COMA}  {System.out.println(yytext());   return new Symbol(sym.PUNTO_Y_COMA, yyline, yycolumn, yytext());  }

<YYINITIAL> {NOMBRE_VARIABLE}  {System.out.println(yytext());   return new Symbol(sym.NOMBRE_VARIABLE, yyline, yycolumn, yytext());  }
<YYINITIAL> {SIGNOS_ASCII}  {System.out.println(yytext());   return new Symbol(sym.SIGNOS_ASCII, yyline, yycolumn, yytext());  }
<YYINITIAL> {MAYUSCULAS}  {System.out.println(yytext());   return new Symbol(sym.MAYUSCULAS, yyline, yycolumn, yytext());  }
<YYINITIAL> {MINUSCULAS}  {System.out.println(yytext());   return new Symbol(sym.MINUSCULAS, yyline, yycolumn, yytext());  }

<YYINITIAL> {CONJUNTO_ABC}  {System.out.println(yytext());   return new Symbol(sym.CONJUNTO_ABC, yyline, yycolumn, yytext());  }
<YYINITIAL> {ENTERO}  {System.out.println(yytext());   return new Symbol(sym.ENTERO, yyline, yycolumn, yytext());  }

 



<YYINITIAL> {CARACTER_ESPECIAL}  {System.out.println(yytext());   return new Symbol(sym.CARACTER_ESPECIAL, yyline, yycolumn, yytext());  }

<YYINITIAL> {TEXT}  {System.out.println(yytext());   return new Symbol(sym.TEXT, yyline, yycolumn, yytext());  }












<YYINITIAL> . {
        String errLex = "Error léxico : '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+(yycolumn+1);
        System.out.println(errLex);
}