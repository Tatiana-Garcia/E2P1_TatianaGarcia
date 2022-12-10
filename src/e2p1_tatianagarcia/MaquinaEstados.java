/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e2p1_tatianagarcia;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author tatig
 */
public class MaquinaEstados {
    
    private ArrayList<String>estados ;
    private ArrayList<String>estados_aceptacion = new ArrayList<>();
    private ArrayList<String>aristas ;
    private String estado_actual;

    /**
     * @return the estados
     */
    public ArrayList<String> getEstados() {
        return estados;
    }

    /**
     * @param estados the estados to set
     */
    public void setEstados(ArrayList<String> estados) {
        this.estados = estados;
    }

    /**
     * @return the estados_aceptacion
     */
    public ArrayList<String> getEstados_aceptacion() {
        return estados_aceptacion;
    }

    /**
     * @param estados_aceptacion the estados_aceptacion to set
     */
    public void setEstados_aceptacion(ArrayList<String> estados_aceptacion) {
        this.estados_aceptacion = estados_aceptacion;
    }

    /**
     * @return the artistas
     */
    public ArrayList<String> getArtistas() {
        return aristas;
    }

    /**
     * @param artistas the artistas to set
     */
    public void setArtistas(ArrayList<String> artistas) {
        this.aristas = artistas;
    }

    /**
     * @return the estado_actual
     */
    public String getEstado_actual() {
        return estado_actual;
    }

    /**
     * @param estado_actual the estado_actual to set
     */
    public void setEstado_actual(String estado_actual) {
        this.estado_actual = estado_actual;
    }
    
    public MaquinaEstados(String estados, String aristas){
        this.estados = splitStr(estados,';');
        extractAcceptNodes();
        this.aristas = splitStr(aristas,';');
        this.estado_actual = this.estados.get(0);
    }
    public ArrayList<String>splitStr(String str, char delim)
    {
        ArrayList<String>split = new ArrayList<>();
        
        String []array = str.split(Character.toString(delim));
        
        for(int i = 0; i < array.length; i++)
        {
            split.add(array[i]);
            System.out.println(split);
            
        }
        System.out.println("");
        return split;
    }
    public void extractAcceptNodes()
    {
        String cadena = "";
        for (int i = 0; i < estados.size(); i++)
        {
            if(estados.get(i).contains("."))
            {
                //estados_aceptacion.add(estados.get(i));
                cadena = estados.get(i);
                estados_aceptacion.add(cadena.substring(1));
            }
        }
        System.out.println(estados_aceptacion);
    }
    public String computeStr(String str)
    {
        estado_actual = estados.get(0);
        String cadena = "";
        
        for (int i = 0; i < str.length(); i++) {
           
           String ar = getArista(estado_actual+','+str.charAt(i));
           if(!ar.equals(""))
            {
               cadena += (estado_actual+':'+str.charAt(i));
               String array [] = ar.split(",");
               estado_actual = array[2];
               cadena += (estado_actual + '\n');
            }
           else{
               cadena+= "Rechazada";
            }
           
        }
        if(estados_aceptacion.contains(estado_actual))
        {
            cadena += "\nAceptada"; 
        }
        else
        {
            cadena +=  "\nRechazada";
        }
        return cadena;
    }
    public String getArista(String str)
    {
        for (int i = 0; i < aristas.size(); i++) {
            if(aristas.get(i).contains(str))
            {
                return aristas.get(i);
            }
        }
        return "";    
    }
    
    
    
}
