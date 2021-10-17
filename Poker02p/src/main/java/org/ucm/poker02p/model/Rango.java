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
public class Rango implements Observer{
    ArrayList<Mano> parejas;
    ArrayList<Mano> suited;
    ArrayList<Mano> offSuited;
    
    public Rango(String entrada){
        parejas = new ArrayList();
        suited = new ArrayList();
        offSuited = new ArrayList();
    }
    
    private void addMano(Mano mano){
        switch(mano.getTipo()){
            case 'p':{
                parejas.add(mano);
            }
            break;
            case 's':{
                suited.add(mano);
            }
            break;
            case 'o':{
                offSuited.add(mano);
            }
            break;
        }
    }

    @Override
    public void onRegister() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onReset() {
        parejas = new ArrayList();
        suited = new ArrayList();
        offSuited = new ArrayList();
    }

    @Override
    public void onRangeChanged(ArrayList<Mano> lista) {
        for(Mano manos : lista){
            addMano(manos);
        }
    }

    @Override
    public void onAdvance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
