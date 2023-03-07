/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_olc1;

/**
 *
 * @author 50246
 */
public class noHoja {
        public int contenido;
        
        public noHoja(String contenido) {
        this.contenido = clean(contenido) + 1;
        }

        
        public int getNumber(){
            contenido -= 1;
            return contenido;
            
        }
        
        public int clean(String contenido) {
            return contenido.replace(".", "").replace("|", "").replace("*", "").replace("+", "").replace("?","").length();
        }
}
