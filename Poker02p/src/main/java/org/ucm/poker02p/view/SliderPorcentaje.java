/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ucm.poker02p.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JSlider;
import org.ucm.poker02p.control.Controller;
import org.ucm.poker02p.model.Mano;
import org.ucm.poker02p.model.Observer;


public class SliderPorcentaje extends JSlider implements Observer{
    private Controller ctrl;

    public SliderPorcentaje(Controller ctrl) {
        this.ctrl = ctrl;
        ctrl.addObserver(this);
        setSize(new Dimension(510, 33));//37 520
        setLocation(5, 4);
        setBackground(Color.WHITE);
        this.setVisible(true);
        this.setValue(0);
        setEnabled(false);
        
    }

    @Override
    public void onRegister() {
        
    }

    @Override
    public void onReset() {
        this.setValue(0);
    }

    @Override
    public void onRangeChanged(ArrayList<Mano> lista) {
        
    }

    @Override
    public void onAdvance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onCuadritoChanged(Mano mano, boolean seleccionado) {
        
    }

    @Override
    public void activaRanking(boolean rankingActivado) {
        if(rankingActivado) setEnabled(true);
        else setEnabled(false);
    }

    @Override
    public void onRankingChanged(ArrayList<Mano> lista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
