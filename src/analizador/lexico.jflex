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
SPACE   = [ \r\t]+

//SIGNOS_ASCII = [ -/:-]