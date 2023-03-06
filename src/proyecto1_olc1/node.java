/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_olc1;
import java.util.ArrayList;

import proyecto1_olc1.tipo.Tipos;
/**
 *
 * @author 50246
 */
public class node {
    ArrayList<Integer> first;
    ArrayList<Integer> last;
    boolean anullable;
    
    String lexeme;
    Tipos tipo;
    int number;
    
    boolean accept;
    
    Object left;
    Object right;
    
    ArrayList<node> leaves;
    ArrayList<ArrayList> table;
    
    public node(String lexeme, Tipos type, int number, Object left, Object right, ArrayList<node> leaves, ArrayList<ArrayList> table) {
        first = new ArrayList();
        last = new ArrayList();
        anullable = true;
        
        this.lexeme = lexeme;
        this.tipo = type;
        this.number = number;
        
        accept = "#".equals(this.lexeme);
        
        this.left = left;
        this.right = right;
        
        this.leaves = leaves;
        this.table = table;
    }
    
    public node getNode(){
        
        
        Object leftNode = this.left instanceof node ? ((node) this.left).getNode() : null;
        Object rightNode = this.right instanceof node ? ((node) this.right).getNode() : null;
        
        if(null != this.tipo)switch (this.tipo) {
            case HOJA:
                this.anullable = false;
                this.first.add(this.number);
                this.last.add(this.number);
                break;
            case AND:
                if(leftNode instanceof node && rightNode instanceof node){
                    this.anullable = ((node)leftNode).anullable && ((node) rightNode).anullable;
                    
                    this.first.addAll(((node)leftNode).first);
                    if(((node)leftNode).anullable){
                        this.first.addAll(((node)rightNode).first);
                    }
                    
                    if(((node)rightNode).anullable){
                        this.last.addAll(((node)leftNode).last);
                    }
                    this.last.addAll(((node)rightNode).last);
                }   
                break;
            case OR:
                if(leftNode instanceof node && rightNode instanceof node){
                    this.anullable = ((node)leftNode).anullable || ((node) rightNode).anullable;
                    
                    this.first.addAll(((node)leftNode).first);
                    this.first.addAll(((node)rightNode).first);
                    
                    
                    this.last.addAll(((node)leftNode).last);
                    this.last.addAll(((node)rightNode).last);
                }  
                break;
            case KLEENE:
                if(leftNode instanceof node){
                    this.anullable = true;
                    this.first.addAll(((node)leftNode).first);
                    this.last.addAll(((node)leftNode).last);
                }
                break;
            default:
                break;
        }
        return this;
    }
    
    public Object follow(){
        Object leftFollow=  this.left instanceof node ? ((node) this.left).follow() : null;
        Object rightFollow =  this.right instanceof node ? ((node) this.right).follow() : null;
        
        if(null != this.tipo)switch (this.tipo) {
            case AND:
                for (int item : ((node)leftFollow).last) {
                    Hoja hoja = new Hoja();
                    node nodo = hoja.getLeave(item, leaves);
             //       tablaSiguientes tabla = new tablaSiguientes();
            //        tabla.append(nodo.number, nodo.lexeme, ((node) rightFollow).first, table);
                }
                break;
            case KLEENE:
                for (int item : ((node)leftFollow).last) {
                    Hoja hoja = new Hoja();
                    node nodo = hoja.getLeave(item, leaves);
                //    tablaSiguientes tabla = new tablaSiguientes();
                //    tabla.append(nodo.number, nodo.lexeme, ((node) leftFollow).first, table);
                }
                break;
            default:
                break;
        }
        
        return this;
    }
}


