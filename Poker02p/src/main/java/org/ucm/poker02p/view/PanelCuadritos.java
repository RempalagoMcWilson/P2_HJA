/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ucm.poker02p.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.ucm.poker02p.control.Controller;
import org.ucm.poker02p.model.Cuadrito;
import org.ucm.poker02p.model.Mano;
import org.ucm.poker02p.model.Observer;


public class PanelCuadritos extends JPanel implements Observer{
    
    private Cuadrito[][] matrizC;
    private Controller ctrl;
    
    public PanelCuadritos(Controller ctrl) {
        this.ctrl = ctrl;
        ctrl.addObserver(this);
        setSize(new Dimension(520, 520));
        iniMatriz();
        setBackground(Color.WHITE);
        this.setVisible(true);
        setLocation(5, 5);
        
    }
    
    
    
    void iniMatriz(){
        
        matrizC = new Cuadrito[13][13];
        for(int i = 13; i > 0;i--){
            for(int j = 13; j > 0; j--){
                if(i == j)
                    matrizC[i-1][j-1] = new Cuadrito(new Mano(i+1,j+1,'p'), "amarillo", ctrl);
                else if(i < j)
                    matrizC[i-1][j-1] = new Cuadrito(new Mano(i+1,j+1,'s'), "rojo", ctrl);
                else
                    matrizC[i-1][j-1] = new Cuadrito(new Mano(i+1,j+1,'o'), "azul", ctrl);
               
                
                
                add(matrizC[i-1][j-1]);
                
                matrizC[i-1][j-1].setLocation(520 - 40*i, 520 - 40*j);
                
            }
        }
        //this.updateUI();
    }
    

    @Override
    public void onRegister() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onReset() {/*
        this.removeAll();// no funciona
        iniMatriz();*/
        for(int i = 13; i > 0;i--){
            for(int j = 13; j > 0; j--){
                this.remove(matrizC[i-1][j-1]);               
            }
        }
        matrizC = new Cuadrito[13][13];
        for(int i = 13; i > 0;i--){
            for(int j = 13; j > 0; j--){
                if(i == j)
                    matrizC[i-1][j-1] = new Cuadrito(new Mano(i+1,j+1,'p'), "amarillo", ctrl);
                else if(i < j)
                    matrizC[i-1][j-1] = new Cuadrito(new Mano(i+1,j+1,'s'), "rojo", ctrl);
                else
                    matrizC[i-1][j-1] = new Cuadrito(new Mano(i+1,j+1,'o'), "azul", ctrl);
               
                
                
                add(matrizC[i-1][j-1]);
                
                matrizC[i-1][j-1].setLocation(520 - 40*i, 520 - 40*j);
                
            }
        }
    }

    @Override
    public void onAdvance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onRangeChanged(ArrayList<Mano> lista) {
        /*for(Mano manos : lista){
            matrizC[manos.getCarta1()][manos.getCarta2()].actualizaCuadrito();
        }*/
        
    }

    @Override
    public void onCuadritoChanged(Mano mano, boolean seleccionado) {
        for(int i = 13; i > 0;i--){
            for(int j = 13; j > 0; j--){
                this.remove(matrizC[i-1][j-1]);
                add(matrizC[i-1][j-1]);
                
                matrizC[i-1][j-1].setLocation(520 - 40*i, 520 - 40*j);
                
            }
        }
    }
    
    
}
