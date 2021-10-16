/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ucm.poker02p.control;

import org.ucm.poker02p.model.Observer;
import org.ucm.poker02p.model.Simulator;

/**
 *
 * @author seiya
 */
public class Controller {
    private Simulator sim;
    
    public void addObserver(Observer o) {
		sim.addObserver(o);
    }
}
