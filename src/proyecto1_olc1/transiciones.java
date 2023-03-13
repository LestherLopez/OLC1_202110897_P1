/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_olc1;

/**
 *
 * @author 50246
 */
public class transiciones {
    public String estadoInicial;
    public String transicion;
    public String estadoFinal;
    
    public transiciones( String estadoInicial, String transicion, String estadoFinal ) {
        this.estadoInicial = estadoInicial;
        this.transicion = transicion;
        this.estadoFinal = estadoFinal;
    }
    
    public boolean compare(String estadoInicial, String transicion){
        
        return this.estadoInicial.equals(estadoInicial) && this.transicion.equals(transicion);
    }
    
    @Override
    public String toString(){
        return this.estadoInicial + " -> " + this.transicion + " -> " + this.estadoFinal;
    }
    
    public String graph(){
        return this.estadoInicial +  "->"  + this.estadoFinal + "[label=\"" + this.transicion + "\"]";
    }
}
