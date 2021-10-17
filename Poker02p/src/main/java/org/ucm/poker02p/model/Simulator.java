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
public class Simulator {
    private ArrayList<Observer> so;
    
    public Simulator() {
        so = new ArrayList();
    }
    
    public void addObserver(Observer o) {
	boolean add = true;
	for (Observer obs : so) {
		if (obs.equals(o))
			add = false;
	}
	if (add)
		so.add(o);
        //o.onRegister();
    }
    public void rangeChanged(ArrayList<Mano> list){
        for(Observer obs : so) {
            obs.onRangeChanged(list);
	}
    }
    
    public void reset(){
        for(Observer obs : so) {
            obs.onReset();
	}
    }

    public void cuadritoChanged(Mano mano, boolean seleccionado) {
        for(Observer obs : so) {
            obs.onCuadritoChanged(mano, seleccionado);
	}
    }

    
}
