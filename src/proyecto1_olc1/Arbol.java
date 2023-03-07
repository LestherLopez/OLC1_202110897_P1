/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_olc1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

import proyecto1_olc1.tipo.Tipos;

/**
 *
 * @author 50246
 */
public class Arbol {
    node root;

    public Arbol( String er, ArrayList<node> leaves, ArrayList<ArrayList> table ) {
        
        noHoja numHoja = new noHoja(er);
        Stack pila = new Stack();
        
        String[] erSplit = er.split("");
        ArrayList<String> strList = new ArrayList<String>( Arrays.asList(erSplit));
        Collections.reverse(strList);
        
        strList.forEach((character) -> {
            switch (character) {
                case "|":
                    node lefto = (node) pila.pop();
                    node righto = (node) pila.pop();
                    
                    node no = new node(character, Tipos.OR, 0, lefto, righto, leaves, table);
                    pila.push(no);
                    
                    break;
                case ".":
                    node lefta = (node) pila.pop();
                    node righta = (node) pila.pop();
                    
                    node na = new node(character, Tipos.AND, 0, lefta, righta, leaves, table);
                    pila.push(na);
                    
                    break;
                case "*":
                    node unario = (node) pila.pop();
                    
                    node nk = new node(character, Tipos.KLEENE, 0, unario, null, leaves, table);
                    pila.push(nk);
                    
                    break;
                case "+":
                    node unariop = (node) pila.pop();
                    node np = new node(character, Tipos.POSITIVA, 0, unariop, null, leaves, table);
                    pila.push(np);
                    
                    break;
                 case "?":
                    node unariob = (node) pila.pop();
                    node nb = new node(character, Tipos.BOOLEANA, 0, unariob, null, leaves, table);
                    pila.push(nb);
                    
                    break;
                default:
                    node nd = new node(character, Tipos.HOJA, numHoja.getNumber(), null, null, leaves, table);
                    pila.push(nd);
                    Hoja hoja = new Hoja();
                    hoja.addLeave(nd, leaves);
                    break;
            }
        });
        this.root = (node) pila.pop();
    }
    
    public node getRoot(){
        return this.root;
    }
}
