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
public class Hoja {
    public void addLeave(node nodo, ArrayList<node> leaves){
        leaves.add(nodo);
    }
    public node getLeave(int numLeave, ArrayList<node> leaves){
        for (node item : leaves) {
            if(item.number == numLeave) return item;
        }
        return null;
    }
    public boolean isAccept(int numLeave, ArrayList<node> leaves){
        for (node item : leaves) {
            if(item.number == numLeave) return item.accept;
        }
        return false;
    }
}
