/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ucm.poker02p.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import org.ucm.poker02p.control.Controller;


public class Cuadrito extends JButton{
    //JButton boton;
    private static Controller ctrl;
    private Mano mano;
    private String color;
    private boolean seleccionado;

    public Cuadrito(Mano mano, String color,Controller ctrl) {
        this.ctrl = ctrl;
        seleccionado = false;
        this.mano = mano;
        this.color = color;
        setColorMio(color);
        //boton.setFont(Font.TYPE1_FONT);
        setSize(new Dimension(40, 40));
        setMargin(new java.awt.Insets(0,0,0,0));
        this.setFont(new Font("arial", Font.PLAIN, 17));
        this.setMinimumSize(new Dimension(40, 40));
        setText(mano.toString());//mano.toString()
        
        setVisible(true);
        this.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizaCuadrito();
                ctrl.cuadritoChanged(mano,seleccionado);
                
            }
        });
    }
    
    public void actualizaCuadrito(){
        if(!seleccionado){
            setBackground(Color.green);
            seleccionado = true;
        }
        else{
            seleccionado = false;
            setColorMio(color);
        }
    }
    public void actualizaCuadritoRanking(){
        
        if(!seleccionado){
            setBackground(Color.pink);
            seleccionado = true;
        }
        else{
            seleccionado = false;
            setColorMio(color);
        }
        //if(mano.getCarta1() == 14 && mano.getCarta2() == 13)
        //        setBackground(Color.magenta);
    }
    
    
    private void setColorMio(String color){
        switch(color){
                case "rojo":{
                    setBackground(Color.red);
                }
                break;
                case "amarillo":{
                    setBackground(Color.yellow);
                }
                break;
                case "azul":{
                    setBackground(Color.blue);
                }
                break;
                case "verde":{
                    setBackground(Color.green);
                }
                break;
        }
    }  
}
