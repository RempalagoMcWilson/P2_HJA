/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ucm.poker02p.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import org.ucm.poker02p.model.Cuadrito;
import org.ucm.poker02p.model.Mano;
import org.ucm.poker02p.model.Observer;


public class PanelCuadritos extends JPanel implements Observer{
    
    private Cuadrito[][] matrizC;
    
    public PanelCuadritos() {
        matrizC = new Cuadrito[13][13];
        setSize(new Dimension(520, 520));
        iniMatriz();
        //meteMatriz();
        setBackground(Color.WHITE);
        this.setVisible(true);
        setLocation(5, 5);
        
    }
    
    
    
    void iniMatriz(){
        for(int i = 13; i > 0;i--){
            for(int j = 13; j > 0; j--){
                if(i == j)
                    matrizC[i-1][j-1] = new Cuadrito(new Mano(i+1,j+1,'p'), "amarillo");
                else if(i < j)
                    matrizC[i-1][j-1] = new Cuadrito(new Mano(i+1,j+1,'s'), "rojo");
                else
                    matrizC[i-1][j-1] = new Cuadrito(new Mano(i+1,j+1,'o'), "azul");
               
                
                
                add(matrizC[i-1][j-1]);
                
                matrizC[i-1][j-1].setLocation(520 - 40*i, 520 - 40*j);
                
            }
        }
        this.updateUI();
    }
    
    /*
    void meteMatriz(){
        for(int i = 0; i< 13;i++){
            for(int j = 0; j < 13; j++){
                
            }
            //mirar como decirle que salte de linea
        }
    }*/
    

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
