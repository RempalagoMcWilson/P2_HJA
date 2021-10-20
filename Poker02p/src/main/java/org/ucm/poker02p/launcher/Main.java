/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ucm.poker02p.launcher;

import org.ucm.poker02p.control.Controller;
import org.ucm.poker02p.model.Simulator;
import org.ucm.poker02p.view.MainPanel;

public class Main {
    public static void main(String[] args) {
            Simulator sim = new Simulator();
            Controller cntr = new Controller(sim);
		MainPanel mP = new MainPanel(cntr);
        
	}
}
