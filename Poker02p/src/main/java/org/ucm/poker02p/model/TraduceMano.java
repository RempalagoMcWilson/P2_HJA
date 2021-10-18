/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ucm.poker02p.model;

import java.util.ArrayList;

/**
 *
 * @author seiya
 */
public class TraduceMano {
    
    public TraduceMano(){
        
    }
    
    private ArrayList<Mano> generaMano(String cartas, Character tipo, boolean suma){
        ArrayList<Mano> lista = new ArrayList();Integer c1, c2;
        c1 = charACarta(cartas.charAt(0));
        c2 = charACarta(cartas.charAt(1));
        if(suma == false){
            if(tipo == 'p')
                lista.add(new Mano(c1, c2, 'p'));
            else if(tipo == 'o')
                lista.add(new Mano(c2, c1, 'o'));
            else
                lista.add(new Mano(c1, c2, 's'));
        }
        else{
            if(tipo == 'o'){
                for(int i = c2;i != c1;i++)
                    lista.add(new Mano(i, c1, 'o'));
            }
            else if(tipo == 's'){
                for(int i = c2;i != c1;i++)
                    lista.add(new Mano(c1, i, 's'));
            }
            else{
                for(int i = c1;i <= 14;i++)
                    lista.add(new Mano(i, i, 'p'));
            }
        }
            
        return lista;
        
    }
    
    public ArrayList<Mano> traduceMano(String entrada){
        ArrayList<Mano> lista = new ArrayList(); int i = 0;String aux = "";Character tipo = null;boolean suma = false;
        while(i < entrada.length()){
            //System.out.println(i + " "+ entrada.length());
            aux = entrada.substring(i, i+2);
            
            if(i+2 < entrada.length()){
                if(entrada.charAt(i+2) != ','){
                    if(entrada.charAt(i+2) != '+'){
                        
                    }
                    else{
                        if(entrada.charAt(i+2) == '+'){
                            
                            lista.addAll(generaMano(aux,'p',true));
                            i = i+3;
                            
                        }
                        else{
                            
                        }
                    }
                }
                else{
                    
                }
            }
            else{
                
            }
            tipo = null;suma = false;
        }
        
        return lista;
        
    }
    
    
    private int charACarta(char carta){
        switch(carta){
            case 'A':{
                return 14;
            }
            case 'K':{
                return 13;
            }
            case 'Q':{
                return 12;
            }
            case 'J':{
                return 11;
            }
            case 'T':{
                return 10;
            }
            default:{
                return Character.getNumericValue(carta);
            }
        }
    }
}
