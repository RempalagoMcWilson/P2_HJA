/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ucm.poker02p.model;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class Board {
    private ArrayList<Carta> lista;
    
    private TreeMap<Integer,ArrayList<Carta>> repeticiones;
    private int colH, colD , colC , colS ,poker , trio ,pareja1, pareja2;
    private ArrayList<Carta> listaOrdenada;

    public Board() {
        lista = new ArrayList();
    }
    
    public int getNumCart(){
        return lista.size();
    }
    public void addCarta(Carta carta){
        lista.add(carta);
    }

    public void removeCarta(Carta carta) {
        lista.remove(carta);
    }
    
    public void preparaBoard(){
        repeticiones = new TreeMap<>();
        colH = 0; colD = 0; colC = 0; colS = 0;poker = 0; trio = 0;pareja1 = 0; pareja2= 0;
        
        for(Carta c: lista){
            ArrayList<Carta> aux1 = new ArrayList<>();
            aux1.add(c);
            aux1 = repeticiones.putIfAbsent(c.getNum(), aux1);
            if(aux1 != null){
                aux1.add(c);
                repeticiones.put(c.getNum(), aux1);
            }
           switch(c.getPalo()) {
                    case 'h':
                        colH++;
                    break;
                    case 'd':
                        colD++;
                    break;
                    case 'c':
                        colC++;
                    break;
                    case 's':
                        colS++;
                    break;
            }                       
        }
        
        
        for( Map.Entry<Integer, ArrayList<Carta>>  r: repeticiones.entrySet()){
            Integer ke = r.getKey();
            ArrayList<Carta> va = r.getValue();
            for(Carta c : va){
                listaOrdenada.add(c);
            }
                                 
            switch (va.size()) {
                case 2:
                    if(ke > pareja1){
                        pareja2 = pareja1;
                        pareja1 = ke;
                    }   break;
                case 3:
                    if(ke > trio)
                        trio = ke;
                    break;
                case 4:
                    if(ke > poker)
                        poker = ke;
                    break;
                default:
                    break;
            }
        }
    }
    
    
}
