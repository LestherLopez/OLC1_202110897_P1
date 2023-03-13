/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_olc1;

import java.util.ArrayList;

/**
 *
 * @author 50246
 */
public class tablaTransiciones {
        public ArrayList<ArrayList> states;
    public int cont;
    
    public tablaTransiciones(node root, ArrayList tabla, ArrayList<node> leaves) {
        this.states = new ArrayList();
        
        ArrayList datos = new ArrayList();
        datos.add("S0");
        datos.add(root.first);
        datos.add(new ArrayList());
        datos.add(false);
        
        this.states.add(datos);
        this.cont = 1;
        
        for(int i = 0; i < states.size(); i++){
            ArrayList state = states.get(i);
            ArrayList<Integer> elementos = (ArrayList) state.get(1);
            
            // TODO  Aqui se encuentra el bug sobre las transiciones
            // Sucede cuando existe dos transisiciones con el mismo simbolos y diferentes siguientes
            // Ej: S0 ={1,2,3}  se ve la tabla de siguiente y se tiene  (S0,a) = {1,2,3} y (S0,a) = {4} el nuevo estado quedaria de la union de estos dos S1 = {1,2,3,4}
            // Lo que hace ahora es remplazar el estado final entonces queda asi S1 = {4} y no S1 = {1,2,3,4}
            
            for(int hoja : elementos){
                tablaSiguientes sigTabla = new tablaSiguientes();
                ArrayList lexemeNext = (ArrayList) sigTabla.next(hoja, tabla).clone();
                
                
                boolean existe = false;
                String found = "";
                
                for( ArrayList e : states ){
                    if(e.get(1).equals(lexemeNext.get(1))){
                        existe = true;
                        found = (String)e.get(0);
                        break;
                    }
                }
                
                if(!existe){
                    Hoja hojas = new Hoja();
                    if(hojas.isAccept(hoja, leaves)){
                        state.set(3, true);
                    }
                    if(lexemeNext.get(0)==""){
                        continue;
                    }
                    
                    ArrayList nuevo = new ArrayList();
                    nuevo.add("S"+cont);
                    nuevo.add(lexemeNext.get(1));
                    nuevo.add(new ArrayList());
                    nuevo.add(false);
                    
                    transiciones transicion = new transiciones(state.get(0) + "", lexemeNext.get(0) + "", nuevo.get(0) + "");
                    ((ArrayList)state.get(2)).add(transicion);
                    
                    cont += 1;
                    states.add(nuevo);
                
                }
                else{
                    Hoja hojas = new Hoja();
                    if(hojas.isAccept(hoja, leaves)){
                        state.set(3, true);
                    }
                    
                    boolean trans_exist = false;
                    
                    for(Object transicion : (ArrayList)state.get(2)){
                        transiciones t = (transiciones) transicion;
                        if(t.compare(state.get(0) + "", lexemeNext.get(0) + "")){
                            trans_exist = true;
                            break;
                        }
                    }
                    if(!trans_exist){
                        transiciones transicion = new transiciones(state.get(0) + "", lexemeNext.get(0) + "", found + "");
                        ((ArrayList)state.get(2)).add(transicion);
                    }
                }
            }
            
        }
    }
    
    public void impTable(){
        for(ArrayList state : states){
            String transicion = "[";
            for(Object tr : (ArrayList)state.get(2)){
                transiciones t = (transiciones) tr;
                transicion += t.toString() + ", ";           
            }
            transicion += "]";
            transicion = transicion.replace(", ]", "]");
            System.out.println(state.get(0) + " " + state.get(1) + " " + transicion + " " + state.get(3));
        }
    }
    
     public void impGraph(){
        for(ArrayList state : states){
            String graph = "";
            for(Object tr : (ArrayList)state.get(2)){
                transiciones t = (transiciones) tr;
                graph += t.graph();
            }
            System.out.println(graph);
        }
    }
}
