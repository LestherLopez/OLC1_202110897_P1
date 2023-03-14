/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_olc1;

/**
 *
 * @author 50246
 */
public class Tree {
    private NodoArbol raiz_arbol;
    private int nonode =0;
    public Tree(NodoArbol raiz_arbol) {
        System.out.println("llega aqui");
        NodoArbol root = new NodoArbol(".");
        NodoArbol numeral = new NodoArbol("#");
        numeral.setHojas(true);
        numeral.setAnulabilidad(false);
        root.setIzquierdo(numeral);
        root.setDerecho(numeral);
        this.raiz_arbol = root;
        numero_nodo(this.raiz_arbol);
        reglas_Arbol(this.raiz_arbol);
        nonode = 0;
        
    }

    public NodoArbol getRaiz_arbol() {
        return raiz_arbol;
    }

    public void setRaiz_arbol(NodoArbol raiz_arbol) {
        this.raiz_arbol = raiz_arbol;
    }
    public void numero_nodo(NodoArbol node){
        if (node.isHojas() && node!= null){
            node.setNumber(nonode);
            nonode = nonode +1;
            return;
        }
        else if(node == null){
            return;
        }
        else{
            numero_nodo(node.getDerecho());
            numero_nodo(node.getIzquierdo());
        
        }
        
        
    
    }
    
    public void reglas_Arbol(NodoArbol node){
        if(node==null | node.isHojas()){
            return;
        }
        
        
        if(node.isHojas()){
            int numero = node.getNumber();
            node.getFirst().add(numero);
            node.getLast().add(numero);
        }
        
        
        reglas_Arbol(node.getDerecho());
        reglas_Arbol(node.getIzquierdo());
        
        if(node.getCharacter()=="*" || node.getCharacter()=="?"){
            //colacando anulabilidad para booleana y kleene
            node.setAnulabilidad(true);
            //agregando primeros para booleana y kleene
            node.getFirst().addAll(node.getIzquierdo().getFirst());
            //agregando uñtimos para booleana y kleene
            node.getLast().addAll(node.getIzquierdo().getLast());
        }else if(node.getCharacter()=="+"){
            //agregando primeros
            node.getFirst().addAll(node.getIzquierdo().getFirst());
            
            //agregando uñtimos para positiva
            node.getLast().addAll(node.getIzquierdo().getLast());
            //colacando anulabilidad 
            if(node.getIzquierdo().anulabilidad == false){
                node.setAnulabilidad(false);
               
            }else{
                node.setAnulabilidad(true);
            }
        }else if(node.getCharacter()=="|"){
            //agregando primeros para or
            node.getFirst().addAll(node.getIzquierdo().getFirst());
            node.getFirst().addAll(node.getDerecho().getFirst());
            //agregando segundos para or
            node.getLast().addAll(node.getIzquierdo().getLast());
            node.getLast().addAll(node.getDerecho().getLast());
            //colacando anulabilidad   
            if(node.getIzquierdo().isAnulabilidad()|| node.getDerecho().isAnulabilidad()){
                node.setAnulabilidad(true);
              
            }else{
                node.setAnulabilidad(false);
            }
        }else if(node.getCharacter()=="."){
            //agregando primeros
            node.getFirst().addAll(node.getIzquierdo().getFirst());
            if(node.getIzquierdo().isAnulabilidad()){
                node.getFirst().addAll(node.getDerecho().getFirst());
            }
            /*this.last.addAll(((node)rightNode).last);
                    if(((node)rightNode).anullable){
                        this.last.addAll(((node)leftNode).last);
                    }*/
            //agregando segundos para concatenacion
            node.getLast().addAll(node.getDerecho().getLast());
            if(node.getDerecho().isAnulabilidad()){
                node.getLast().addAll(node.getIzquierdo().getLast());
            }
            
            
            //colacando anulabilidad
             if(node.getIzquierdo().isAnulabilidad()&& node.getDerecho().isAnulabilidad()){
                node.setAnulabilidad(true);
                
            }else{
                node.setAnulabilidad(false);
            }
        }
        
    }
    
    public void printAbol(NodoArbol node){
        String cadena = "";
        if(node != null && node.isHojas()){
            cadena += "digraph arbol {";
            cadena += "a";
            cadena += "}";
        }
        
    }
}
