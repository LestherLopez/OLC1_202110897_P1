/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_olc1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JFileChooser;
 import java.util.Random;
import proyecto1_olc1.Error;

/**
 *
 * @author 50246
 */
public class Tree {
    private NodoArbol raiz_arbol;
    private int nonode =1;
    public int contador_transicion = 1;
    
    ArrayList<ArrayList> table;
    private ArrayList<NodoArbol> hojas = new ArrayList<>();
    public  ArrayList<NodoArbol> transiciones = new ArrayList<>();
     public  ArrayList<String> caracteres_hojas = new ArrayList<>();
     
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
       

        String arbol_codigo = printArbol(this.raiz_arbol, nonode);
        graphviz(arbol_codigo, "arbol");
        reglas_siguientes(this.raiz_arbol);
        String siguientes_codigo = printSiguientes(this.raiz_arbol, nonode);
        graphviz(siguientes_codigo, "siguientes");
        caracterhoja();
        transicion_inicial(this.raiz_arbol);
        obtenerTransiciones(this.raiz_arbol);
        obtenerTerminales();
        String transiciones_codigo = printTransiciones();
        graphviz(transiciones_codigo, "transiciones");
        String codigo_afd = obtenerAFD();
        graphviz(codigo_afd, "afd");
        
    }

   

    public NodoArbol getRaiz_arbol() {
        return raiz_arbol;
    }

   
    public void numero_nodo(NodoArbol node){
        
        if(node == null){
           
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
    public void caracterhoja(){
        for (int j = 0; j < hojas.size(); j++){ 
                 if(caracteres_hojas.contains(hojas.get(j).getCharacter())){
                     
                 }
                 else{
                     caracteres_hojas.add(hojas.get(j).getCharacter());
                 }
             }
}
 
    public String obtenerAFD(){
        String cadenaAFD= "";
        cadenaAFD += "rankdir=LR\n";
        for(int i =0; i < transiciones.size(); i++){
         
            if((transiciones.get(i).getCaracteres().contains("#") || transiciones.get(i).getEstados().contains(hojas.size()))){
            cadenaAFD += "S"+i+"[color= black shape = doublecircle, label=\""+transiciones.get(i).getId()+"\"]; \n";
            }
            else{
                cadenaAFD += "S"+i+"[color= black shape = circle, label=\""+transiciones.get(i).getId()+"\"]; \n";
            }
        }
        for(int i =0; i < transiciones.size(); i++){
            for(int j =0; j < transiciones.get(i).getTerminal().size(); j++){
                if(transiciones.get(i).getTerminal().get(j)!="-"){
           
                       cadenaAFD += "S"+i+" -> "+transiciones.get(i).getTerminal().get(j)+"[labeldistance=2\n";
                        cadenaAFD += "labelangle=0\n"; 
                        cadenaAFD += "label=<\n";
                       cadenaAFD += "<table bgcolor=\"white\" border=\"0\">\n"; 
                       cadenaAFD += "<tr>\n";
                       cadenaAFD += "<td>"+caracteres_hojas.get(j)+"</td>\n";
                       cadenaAFD += "</tr> </table>>]";
     
                }
            }
        }
        return cadenaAFD;
    }
    public void obtenerTerminales(){
        for(int j =1; j < transiciones.size(); j++){
            for(int i =0; i < (transiciones.get(j).getEstados().size()); i++){
            
                transiciones.get(j).getCaracteres().add(hojas.get(transiciones.get(j).getEstados().get(i)-1).getCharacter());
                
            }
           
        }
                                   /*s for(int i =1; i < transiciones.get(j-1).getCaracteres().size(); i++){
                            if(transiciones.get(j).getCaracteres().contains(transiciones.get(j-1).getCaracteres().get(i))){
                                transiciones.get(j).getTerminal().add("S"+(j+1));
                            }*/
    
        for(int j =1; j < transiciones.size(); j++){
                
                 for(int z =0; z < (caracteres_hojas.size()-1); z++){
                     
                    if(transiciones.get(j).getCaracteres().contains(caracteres_hojas.get(z)) && caracteres_hojas.get(z)!="#"){
                        
                        if(j==(transiciones.size()-1) ){
                            transiciones.get(j).getTerminal().add("S"+(j));
                        }else if(transiciones.get(j-1).getCaracteres().contains(caracteres_hojas.get(z))){
                            transiciones.get(j).getTerminal().add("S"+(j));
                        }else{
                            transiciones.get(j).getTerminal().add("S"+(j+1));
                        }
                  
                        
                    }else{
                        transiciones.get(j).getTerminal().add("-");
                            
                            }}   
        }
    }
    public void obtenerTransiciones(NodoArbol node){
     if(node==null){
            
            return;
        }
        obtenerTransiciones(node.getIzquierdo());
        obtenerTransiciones(node.getDerecho());
        if(node.isHojas() && node.getCharacter()!="#"){
            
      

 
                System.out.println(node.getFollow());
                if(transiciones.get(contador_transicion-1).getEstados().toString().equals(node.getFollow().toString())){
                
             
                    return;
                }else{
                 node.setId("S"+contador_transicion);
                 node.getEstados().addAll(node.getFollow());
            /*     for(int j =0; j < hojas.size(); j++){
                     node.getTerminal().add("-");
                 }*/
                 transiciones.add(node);
                 
                 contador_transicion += 1;
                 System.out.println("se agrego");
                 return;
                }
                 
 
       }

        
    }
    

    public void transicion_inicial(NodoArbol node){
        if(node==null){
            
            return;
        }
        
 
        transicion_inicial(node.getIzquierdo());
        transicion_inicial(node.getDerecho());
       if(node.getCharacter()=="#"){
            node.getEstados().add(1);
            node.setId("S0");
            for (int j = 0; j < hojas.size(); j++) {
                if(hojas.get(j).getNumber()==1){
                    node.getCaracteres().add(hojas.get(j).getCharacter());
                    node.getTerminal().add("S1");
                }else{
                    node.getTerminal().add("-");
                }
            
            }
            transiciones.add(node);
       }
        
    }
       public String printTransiciones(){
        String cadena = "";
        
       cadena += "parent[\n";
       cadena += "shape=plaintext\n";
       cadena += "label=<\n";
       cadena += "<table border='1' cellborder='1'>\n";
        cadena += "<tr><td  rowspan=\"2\">Estado</td><td colspan=\""+(caracteres_hojas.size()-1)+"\">Terminales</td></tr>\n";
        cadena += "<tr>";
        for(int j = 0; j < caracteres_hojas.size()-1; j++) {
           cadena+= "<td>"+caracteres_hojas.get(j)+"</td>\n";
        }
       
        cadena += " </tr>\n";
          
        for(int i =0; i < transiciones.size(); i++ ){
            cadena +="<tr><td port='port_one'>"+transiciones.get(i).getId()+transiciones.get(i).getEstados()+"</td>";
          
                for(int j =0; j < caracteres_hojas.size()-1; j++){
                cadena +=   "<td>"+transiciones.get(i).getTerminal().get(j)+"</td>";
                }
            cadena += "</tr>";
        }      
      
        cadena += "</table>>];\n";
        return cadena;
        
    }
    public void reglas_siguientes(NodoArbol node){
        if(node==null){
            
            return;
        }
       
        reglas_siguientes(node.getIzquierdo());
        reglas_siguientes(node.getDerecho());
       
        if(node.getCharacter().equals("+") || node.getCharacter().equals("*")){
            
            for (int j = 0; j < hojas.size(); j++) { //recorrer listado de hojas
                 for(int i = 0; i < node.getIzquierdo().getLast().size(); i++){ // recorrer listado de ultimos del nodo hijo izquierdo
                        if(hojas.get(j).getNumber()==node.getIzquierdo().getLast().get(i)){ //condicional de igualdad entre identificador de hoja y ultimo del nodo hijo izquierdo
                            for(int z=0; z < node.getIzquierdo().getFirst().size(); z++){//recorrer listado de primeros del hijo izquierdo
                                if(hojas.get(j).getFollow().contains(node.getIzquierdo().getFirst().get(z))){ //comprobar si el siguiente existe en l tabla siguientes
                                    return;
                            
                            //System.out.println(hojas.get(i).getFollow());
                                }else{
                                    hojas.get(j).getFollow().add(node.getIzquierdo().getFirst().get(z));
                                }
                            }
                         }

                }
            }
        }else if (node.getCharacter().equals(".")){     //si nodo es concatenacion
     
                for (int j = 0; j < hojas.size(); j++){ //recorrer listado de hojas
                    for(int i = 0; i < node.getIzquierdo().getLast().size(); i++){ // recorrer listado de ultimos del nodo hijo izquierdo
                        if(hojas.get(j).getNumber()==node.getIzquierdo().getLast().get(i)){ //condicional de igualdad entre identificador de hoja y ultimo del nodo hijo izquierdo
                            for(int z=0; z < node.getDerecho().getFirst().size(); z++){ //recorrer listado de primeros del hijo derecho
                                if(hojas.get(j).getFollow().contains(node.getDerecho().getFirst().get(z))){ //comprobar si el siguiente existe en l tabla siguientes
                                    return;
                                }
                                else{  //meter elemento a listado de siguientes
                                hojas.get(j).getFollow().add(node.getDerecho().getFirst().get(z));
                                }
                            }
                            
                        }
                    }
                }
            
         }
        
    }
    public String printSiguientes(NodoArbol node, int principal){
        String cadena = "";
        
        nonode += 1;
        int current = nonode;
        if(node == null){
            nonode -= 1;
            return cadena;
        }
        
        if( node.isHojas()){
          //   <tr><td port='port_one'>First port</td><td port='port_two'>Second port</td><td port='port_three'>Third port</td></tr>
          if(node.getCharacter()=="#"){
              cadena += "<tr><td port=\'port_one\'>"+node.getCharacter()+"</td><td port=\'port_two\'>"+node.getNumber()+"</td><td port=\'port_three\'>-</td></tr>\n";
           
          }else{
               cadena += "<tr><td port=\'port_one\'>"+node.getCharacter()+"</td><td port=\'port_two\'>"+node.getNumber()+"</td><td port=\'port_three\'>"+node.getFollow()+"</td></tr>\n";
          }
        }else{
        }
        /*
        if (principal !=0){
            cadena += "N_" + principal + "-> N_"+current+";\n"; 
        }
        cadena +=  printArbol(node.getIzquierdo(),current);
        cadena +=  printArbol(node.getDerecho(),current);
        */
        cadena +=  printSiguientes(node.getIzquierdo(),current);
        cadena +=  printSiguientes(node.getDerecho(),current);
        return cadena;
        
    }
    public void reglas_Arbol(NodoArbol node){

        if(node==null){
            
            return;
        }
        
        
        if(node.isHojas()){
             
            
            hojas.add(node);
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
    
    
    public void graphviz(String codigo, String tipo){
            Random random = new Random();
            
            GraphViz gv = new GraphViz();
            gv.addln(gv.start_graph());
            Proyecto1_OLC1 inde = new Proyecto1_OLC1();
          
            
            if(tipo=="arbol"){
                gv.add(codigo);
                gv.addln(gv.end_graph());
              //  System.out.println(gv.getDotSource());
                gv.increaseDpi();
                String type = "png";
                String repesentationType = "dot";
                File out = new File("ARBOLES_202110897\\arbol_"+random+"." +type);
                gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), type, repesentationType), out);
            }else if(tipo=="siguientes"){
                String cadena_siguientes;
                cadena_siguientes="parent[\n";
                cadena_siguientes+="shape=plaintext\n";
                cadena_siguientes+="label=<\n";
                cadena_siguientes+="<table border='1' cellborder='1'>\n";
                cadena_siguientes+="<tr><td colspan=\"2\">Hoja</td><td>Siguientes</td></tr>\n";
                cadena_siguientes+=codigo;
                cadena_siguientes+="</table>\n";
                cadena_siguientes+=">];";

                gv.add(cadena_siguientes);
                gv.addln(gv.end_graph());
          //    System.out.println(gv.getDotSource());
                gv.increaseDpi();
                String type = "png";
                String repesentationType = "dot";
                File out = new File("SIGUIENTES_202110897\\siguientes_"+random+"." +type);
                gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), type, repesentationType), out);
            }else if(tipo=="transiciones"){
                 gv.add(codigo);
                gv.addln(gv.end_graph());
              System.out.println(gv.getDotSource());
            //    gv.increaseDpi();
                String type = "png";
                String repesentationType = "dot";
                File out = new File("TRANSICIONES_202110897\\transiciones_"+random+"." +type);
                gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), type, repesentationType), out);
            }else if(tipo=="afd"){
                gv.add(codigo);
                gv.addln(gv.end_graph());
              System.out.println(gv.getDotSource());
                gv.increaseDpi();
                String type = "png";
                String repesentationType = "dot";
                File out = new File("AFD_202110897\\AFD_"+random+"." +type);
                gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), type, repesentationType), out);
            }
            
            
            
    }
}

     