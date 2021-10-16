/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ucm.poker02p.model;

import java.util.List;

/**
 *
 * @author seiya
 */
public class Simulator {
    private List<Observer> so;
    
    public void addObserver(Observer o) {
	boolean add = true;
	for (Observer obs : so) {
		if (obs.equals(o))
			add = false;
	}
	if (add)
		so.add(o);
        o.onRegister();
    }
}
