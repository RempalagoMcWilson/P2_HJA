/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ucm.poker02p.model;

import java.util.ArrayList;


public class Board {
    ArrayList<Carta> lista;

    public Board() {
        lista = new ArrayList();
    }
    public void addCarta(Carta carta){
        lista.add(carta);
    }

    public void removeCarta(Carta carta) {
        lista.remove(carta);
    }
    
    
}
