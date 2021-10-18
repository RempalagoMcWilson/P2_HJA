/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ucm.poker02p.model;

import java.util.ArrayList;


public interface Observer {
    public void onRegister();
    public void onReset();
    public void activaRanking(boolean rankingActivado);
    public void onRankingChanged(ArrayList<Mano> lista);
    public void onRangeChanged(ArrayList<Mano> lista);
    public void onAdvance();
    public void onCuadritoChanged(Mano mano, boolean seleccionado);
}
