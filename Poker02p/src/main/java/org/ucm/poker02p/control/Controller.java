/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ucm.poker02p.control;

import java.util.ArrayList;
import org.ucm.poker02p.model.Mano;
import org.ucm.poker02p.model.Observer;
import org.ucm.poker02p.model.Simulator;

/**
 *
 * @author seiya
 */
public class Controller {
    private Simulator sim;

    public Controller(Simulator sim) {
        this.sim = sim;
    }
    
    public void reset(){
        sim.reset();
    }
    public void rangeChanged(ArrayList<Mano> list){
        sim.rangeChanged(list);
    }
    public void addObserver(Observer o) {
	sim.addObserver(o);
    }

    public void cuadritoChanged(Mano mano, boolean seleccionado) {
        sim.cuadritoChanged(mano, seleccionado);
    }
}
