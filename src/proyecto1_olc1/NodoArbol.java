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
public class NodoArbol {
    private String character;
    private boolean hojas = false;
    private int number; 
    private NodoArbol izquierdo;
    private NodoArbol derecho;
    boolean anulabilidad;
    private ArrayList<Integer> first = new ArrayList<>();
    private ArrayList<Integer> last= new ArrayList<>();
    private ArrayList<Integer> follow = new ArrayList<>();
    public boolean isAnulabilidad() {
        return anulabilidad;
    }

    public ArrayList<Integer> getFollow() {
        return follow;
    }

    public void setFollow(ArrayList<Integer> follow) {
        this.follow = follow;
    }

    public void setAnulabilidad(boolean anulabilidad) {
        this.anulabilidad = anulabilidad;
    }
    
    
    public String getCharacter() {
        return character;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public NodoArbol(String character) {
        this.character = character;
    }

    public boolean isHojas() {
        return hojas;
    }

    public void setHojas(boolean hojas) {
        this.hojas = hojas;
    }

    public ArrayList<Integer> getFirst() {
        return first;
    }

    public void setFirst(ArrayList<Integer> first) {
        this.first = first;
    }

    public ArrayList<Integer> getLast() {
        return last;
    }

    public void setLast(ArrayList<Integer> last) {
        this.last = last;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public NodoArbol getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoArbol izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoArbol getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoArbol derecho) {
        this.derecho = derecho;
    }
    
    
}



