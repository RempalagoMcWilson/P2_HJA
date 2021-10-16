/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ucm.poker02p.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author seiya
 */
public class Cuadrito extends JButton {
    //JButton boton;
    String parejaCarta;
    String color;

    public Cuadrito(String parejaCarta, String color) {
        //super(); no hace falta creo
        this.parejaCarta = parejaCarta;
        this.color = color;
        setColorMio(color);
        //boton.setFont(Font.TYPE1_FONT);
        setSize(2, 2);
        setText(parejaCarta);
    }
    
    void setColorMio(String color){
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

    @Override
    public void addActionListener(ActionListener l) {
        super.addActionListener(l); //To change body of generated methods, choose Tools | Templates.
        
        //llama a controller
    }
    
    
}
