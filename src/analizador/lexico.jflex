package analizador;
import java_cup.runtime.Symbol;
import proyecto1_olc1.noHoja;
import proyecto1_olc1.node;
import proyecto1_olc1.tipo.Tipos;
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
<YYINITIAL> {DOS_PUNTOS}  {   return new Symbol(sym.DOS_PUNTOS, yyline, yycolumn, yytext());  }
<YYINITIAL> {PORCENTAJE}  {  return new Symbol(sym.PORCENTAJE, yyline, yycolumn, yytext());  }
<YYINITIAL> {CONJ}  {   return new Symbol(sym.CONJ, yyline, yycolumn, yytext());  }


<YYINITIAL> {GUION}  {   return new Symbol(sym.GUION, yyline, yycolumn, yytext());  }
<YYINITIAL> {MAYOR}  {   return new Symbol(sym.MAYOR, yyline, yycolumn, yytext());  }
<YYINITIAL> {COMA}  {   return new Symbol(sym.COMA, yyline, yycolumn, yytext());  }
<YYINITIAL> {COMILLA}  {   return new Symbol(sym.COMILLA, yyline, yycolumn, yytext());  }
<YYINITIAL> {VIRGUILILLA}  {   return new Symbol(sym.VIRGUILILLA, yyline, yycolumn, yytext()); }
<YYINITIAL> {LLAVE_ABRIR}  {   return new Symbol(sym.LLAVE_ABRIR, yyline, yycolumn, yytext());  }
<YYINITIAL> {LLAVE_CERRAR}  {   return new Symbol(sym.LLAVE_CERRAR, yyline, yycolumn, yytext());  }

<YYINITIAL> {PUNTO}  {   return new Symbol(sym.PUNTO, yyline, yycolumn, yytext());  }
<YYINITIAL> {DISYUNCION}  {   return new Symbol(sym.DISYUNCION, yyline, yycolumn, yytext());  }
<YYINITIAL> {SUMA}  {   return new Symbol(sym.SUMA, yyline, yycolumn, yytext());  }
<YYINITIAL> {INTERROGACION}  {   return new Symbol(sym.INTERROGACION, yyline, yycolumn, yytext());  }
<YYINITIAL> {KLEENE}  {   return new Symbol(sym.KLEENE, yyline, yycolumn, yytext());  }

<YYINITIAL> {PUNTO_Y_COMA}  {   return new Symbol(sym.PUNTO_Y_COMA, yyline, yycolumn, yytext());  }

<YYINITIAL> {NOMBRE_VARIABLE}  {   return new Symbol(sym.NOMBRE_VARIABLE, yyline, yycolumn, yytext());  }
<YYINITIAL> {SIGNOS_ASCII}  {   return new Symbol(sym.SIGNOS_ASCII, yyline, yycolumn, yytext());  }
<YYINITIAL> {MAYUSCULAS}  {   return new Symbol(sym.MAYUSCULAS, yyline, yycolumn, yytext());  }
<YYINITIAL> {MINUSCULAS}  {  return new Symbol(sym.MINUSCULAS, yyline, yycolumn, yytext());  }

<YYINITIAL> {CONJUNTO_ABC}  {  return new Symbol(sym.CONJUNTO_ABC, yyline, yycolumn, yytext());  }
<YYINITIAL> {ENTERO}  {  return new Symbol(sym.ENTERO, yyline, yycolumn, yytext());  }

 



<YYINITIAL> {CARACTER_ESPECIAL}  {System.out.println(yytext());   return new Symbol(sym.CARACTER_ESPECIAL, yyline, yycolumn, yytext());  }

<YYINITIAL> {TEXT}  {System.out.println(yytext());   return new Symbol(sym.TEXT, yyline, yycolumn, yytext());  }












<YYINITIAL> . {
        String errLex = "Error léxico : '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+(yycolumn+1);
        System.out.println(errLex);
}