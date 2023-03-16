/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_olc1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
 import java.util.Random;
/**
 *
 * @author 50246
 */
public class Tree {
    private NodoArbol raiz_arbol;
    private int nonode =1;
    public int contadorarbol = 0;
    ArrayList<ArrayList> table;
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
        System.out.println("empieza arbol");
        Proyecto1_OLC1 inde = new Proyecto1_OLC1();
        String arbol_codigo = printArbol(this.raiz_arbol, nonode);
        graphvizArbol(arbol_codigo);
    //    reglas_siguientes(this.raiz_arbol);
        tablaSiguientes tabla = new tablaSiguientes();
    //    tabla.printTable(table);
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
    public void reglas_siguientes(NodoArbol node){
        if(node==null){
            
            return;
        }
       
        reglas_siguientes(node.getIzquierdo());
        reglas_siguientes(node.getDerecho());
        if(node.getCharacter().equals("+") || node.getCharacter().equals("*")){
            tablaSiguientes tabla = new tablaSiguientes();
            tabla.append(node.getNumber(), node.getCharacter(), node.getIzquierdo().getFirst(), table);
        }else if (node.getCharacter().equals(".")){
            tablaSiguientes tabla = new tablaSiguientes();
            tabla.append(node.getNumber(), node.getCharacter(), node.getDerecho().getFirst(), table);
        }
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
    /*
  public void dibujarArbol( String dotFormat,  String name_file, String name_image){
          
         String contenido = "";
       
         //System.out.println(current_file);
         
          System.out.println(name_file);
         try {
            contenido += "diargama{\n";
            contenido += dotFormat;
            contenido += "}\n";
            File file = new File(name_file);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
            
            ProcessBuilder pbuilder;
            pbuilder = new ProcessBuilder( "dot", "-Tpng", "-o", name_image, name_file );
            pbuilder.redirectErrorStream( true );
			//Ejecuta el proceso
			pbuilder.start(); 
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    
    public void graphvizArbol(String arbol_codigo){
            Random random = new Random();
            
            GraphViz gv = new GraphViz();
            gv.addln(gv.start_graph());
            Proyecto1_OLC1 inde = new Proyecto1_OLC1();
            String automata = (arbol_codigo);
            gv.add(arbol_codigo);
            gv.addln(gv.end_graph());
            System.out.println(gv.getDotSource());
            gv.increaseDpi();
            String type = "png";
            String repesentationType = "dot";
            File out = new File("C:\\Users\\50246\\Desktop\\diarga_"+random+"." +type); // Windows
            gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), type, repesentationType), out);
            
            
    }
}

     