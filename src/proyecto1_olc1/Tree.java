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
    private int nonode =1;
    public Tree(NodoArbol raiz_arbol) {
            
         NodoArbol root = new NodoArbol(".");
        NodoArbol numeral = new NodoArbol("#");
        root.setDerecho(numeral);
        root.setIzquierdo(raiz_arbol);
        numeral.setHojas(true);
        numeral.setAnulabilidad(false);
        this.raiz_arbol = root;
        numero_nodo(this.raiz_arbol);
        nonode = 0;
        reglas_Arbol(this.raiz_arbol);
        System.out.println(printArbol(this.raiz_arbol, nonode));
    }

    public NodoArbol getRaiz_arbol() {
        return raiz_arbol;
    }


    public void numero_nodo(NodoArbol node){
        System.out.println("llega a numeri nodo");
        if(node == null){
            System.out.println("AAA");
            return;
        }
       
        else if (node.isHojas()){
            node.setNumber(nonode);
            nonode = nonode +1;
            return;
        }
        
            numero_nodo(node.getIzquierdo());
        
        numero_nodo(node.getDerecho());
        
        
        
    
    }
    
    public void reglas_Arbol(NodoArbol node){

        if(node==null){
            
            return;
        }
        
        
        if(node.isHojas()){
           
           
            node.getFirst().add(node.getNumber());
            node.getLast().add(node.getNumber());
            return;
        }
        reglas_Arbol(node.getIzquierdo());
        reglas_Arbol(node.getDerecho());
        if(node.getCharacter().equals("*") ||node.getCharacter().equals("?")){
            System.out.println("entra a if");
            //colacando anulabilidad para booleana y kleene
            System.out.println("Se meta aca");
            node.setAnulabilidad(true);
            //agregando primeros para booleana y kleene
            node.getFirst().addAll(node.getIzquierdo().getFirst());
            //agregando uñtimos para booleana y kleene
            node.getLast().addAll(node.getIzquierdo().getLast());
        }else if(node.getCharacter().equals("+")){
            //colacando anulabilidad 
            System.out.println("entra a if");
            if(node.getIzquierdo().anulabilidad == true){
                node.setAnulabilidad(true);
               
            }
            node.setAnulabilidad(false);
           // node.setAnulabilidad(node.getIzquierdo().isAnulabilidad());
            //agregando primeros
            System.out.println("se mete en  positiva");
           node.getFirst().addAll(node.getIzquierdo().getFirst());
            
            //agregando uñtimos para positiva
           node.getLast().addAll(node.getIzquierdo().getLast());
            
        }else if(node.getCharacter().equals("|")){
            //colacando anulabilidad  
            System.out.println("entra a if");
            if(node.getIzquierdo().isAnulabilidad()|| node.getDerecho().isAnulabilidad()){
                node.setAnulabilidad(true);
              
            }else{
                node.setAnulabilidad(false);
            }
          // node.setAnulabilidad(node.getDerecho().isAnulabilidad() || node.getIzquierdo().isAnulabilidad());
            //agregando primeros para or
            node.getFirst().addAll(node.getIzquierdo().getFirst());
            node.getFirst().addAll(node.getDerecho().getFirst());
            //agregando segundos para or
            node.getLast().addAll(node.getIzquierdo().getLast());
            node.getLast().addAll(node.getDerecho().getLast());
             
            
        }else if(node.getCharacter().equals(".")){
            //colacando anulabilidad
            
             if(node.getIzquierdo().isAnulabilidad()&& node.getDerecho().isAnulabilidad()){
                node.setAnulabilidad(true);
                
            }else{
                node.setAnulabilidad(false);
            }
        //    node.setAnulabilidad(node.getDerecho().isAnulabilidad() && node.getIzquierdo().isAnulabilidad());
            //agregando primeros
     
            node.getFirst().addAll(node.getIzquierdo().getFirst());
            if(node.getIzquierdo().isAnulabilidad()){
                node.getFirst().addAll(node.getDerecho().getFirst());
            }
      
            //agregando segundos para concatenacion
            
            node.getLast().addAll(node.getDerecho().getLast());
            if(node.getDerecho().isAnulabilidad()){
                node.getLast().addAll(node.getIzquierdo().getLast());
            }
            
            
            
        }
        
        
        

    }
    
    public String printArbol(NodoArbol node, int principal){
        String cadena = "";
        
        nonode += 1;
        int current = nonode;
        if(node == null){
            nonode -= 1;
            return cadena;
        }
        
        if( node.isHojas()){
            
            cadena += "N_"+current+"[shape=none label=<\n";
            cadena += "<TABLE border=\"1\" cellspacing=\"5\"  style=\"rounded\">\n";    
            cadena += "<TR>\n";
            cadena += "<TD colspan=\"3\">"+node.isAnulabilidad()+"</TD>\n";
            cadena += "</TR>\n";
            
            cadena += "<TR>\n";
            cadena += "<TD>"+node.getFirst()+"</TD>\n";
             cadena += "<TD>"+node.getCharacter()+"</TD>\n";
              cadena += "<TD>"+node.getLast()+"</TD>\n";
            cadena += "</TR>\n";
            cadena += "<TR>\n";
            cadena += "<TD colspan=\"3\">"+node.getNumber()+"</TD>\n";
            cadena += "</TR>\n";
            cadena += "</TABLE>>];\n";
            
        }else{
            cadena += "N_"+current+"[shape=none label=<\n";
             cadena += "<TABLE border=\"1\" cellspacing=\"5\"  style=\"rounded\">\n";
            cadena += "<TR>\n";
            cadena += "<TD colspan=\"3\">"+node.isAnulabilidad()+"</TD>\n";
            cadena += "</TR>\n";
            cadena += "<TR>\n";
            cadena += "<TD>"+node.getFirst()+"</TD>\n";
             cadena += "<TD>"+node.getCharacter()+"</TD>\n";
              cadena += "<TD>"+node.getLast()+"</TD>\n";
            cadena += "</TR>\n";
         
          
            cadena += "</TABLE>>];\n";

            }
        if (principal !=0){
            cadena += "N_" + principal + "-> N_"+current+";\n"; 
        }
        cadena +=  printArbol(node.getIzquierdo(),current);
        cadena +=  printArbol(node.getDerecho(),current);
        
        
        return cadena;
    }
  
}

     