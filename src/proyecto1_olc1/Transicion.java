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
public class Transicion {
    private String id = new String();
    private ArrayList<Integer> estados = new ArrayList<>();
    private ArrayList<String> terminal = new ArrayList<>();
    private ArrayList<String> caracter = new ArrayList<>();

    
    public String getId() {
        return id;
    }

   
    public void setId(String id) {
        this.id = id;
    }
  
    public ArrayList<Integer> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<Integer> estados) {
        this.estados = estados;
    }

    public ArrayList<String> getTerminal() {
        return terminal;
    }

    public void setTerminal(ArrayList<String> terminal) {
        this.terminal = terminal;
    }

    public ArrayList<String> getCaracter() {
        return caracter;
    }

    public void setCaracter(ArrayList<String> caracter) {
        this.caracter = caracter;
    }
}
