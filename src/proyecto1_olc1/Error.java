/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_olc1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author 50246
 */
public class Error {
  
    private String caracter;
    private String linea;
    private String columna;
    public ArrayList<Error> errores = new ArrayList<>();

    public ArrayList<Error> getErrores() {
        return errores;
    }

    public void setErrores(ArrayList<Error> errores) {
        this.errores = errores;
    }
  

    public String getCaracter() {
        return caracter;
    }

    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getColumna() {
        return columna;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }
    public void reporteErrores(){
        
        try {
            Random random = new Random();
            String contenido = "";
            contenido +="<html>\n";
            contenido +="<head>Errores</head>\n";
            contenido +="<table border=\"1\">\n";
            contenido +="<tr>\n";
            contenido +="<th> # </ th>\n";
            contenido +="<th> Tipo de error </th>\n";
            contenido +="<th> Descripcion </th>\n";
            contenido +="<th> Linea </th>\n";
            contenido +="<th> Columna </th>\n";
            contenido +="</tr>\n";
            for (int j = 0; j < errores.size(); j++){ {
                
                contenido +="<body>\n";
                contenido +="<tr>\n";
                contenido += "<td>"+(j+1)+"</td>\n";
                contenido += "<td>Léxico</td>\n";
                contenido += "<td>No se esperaba el componente "+errores.get(j).getCaracter()+ "</td>\n";
                contenido += "<td>"+errores.get(j).getLinea()+"</td>\n";
                contenido += "<td>"+errores.get(j).getColumna()+"</td>\n";
                contenido +="</tr>\n";
                contenido +="</body>\n";
            }
            contenido +="</table>\n";
            contenido +="</html>\n";
            
            }
            File file = new File("ERRORES_202110897\\errores_"+random+".html");
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }

