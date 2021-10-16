/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ucm.poker02p.view;

import javax.swing.JPanel;
import org.ucm.poker02p.model.Cuadrito;
import org.ucm.poker02p.model.Observer;

/**
 *
 * @author seiya
 */
public class PanelCuadritos extends JPanel implements Observer{
    
    private Cuadrito[][] matrizC;
    
    public PanelCuadritos() {
        this.setBounds(1, 1, 2*13, 2*13);
        iniMatriz();
        meteMatriz();
        
    }
    
    
    
    void iniMatriz(){
        for(int i = 0; i< 13;i++){
            for(int j = 0; j < 13; j++){
                if(i == j)
                    matrizC[i][j] = new Cuadrito(generaTexto(i,j), "amarillo");
                else if(i < j)
                    matrizC[i][j] = new Cuadrito(generaTexto(i,j), "rojo");
                else
                    matrizC[i][j] = new Cuadrito(generaTexto(i,j), "azul");

            }
        }
    }
    
    void meteMatriz(){
        for(int i = 0; i< 13;i++){
            for(int j = 0; j < 13; j++){
                add(matrizC[i][j]);
            }
            //mirar como decirle que salte de linea
        }
    }
    
    String generaTexto(int i, int j){
        return "";
    }

    @Override
    public void onRegister() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onReset() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onBodyAdded() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onAdvance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
