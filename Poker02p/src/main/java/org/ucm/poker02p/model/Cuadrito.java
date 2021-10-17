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


public class Cuadrito extends JButton{
    //JButton boton;
    private Mano mano;
    private String color;
    private boolean seleccionado;

    public Cuadrito(Mano mano, String color) {
        //super(); no hace falta creo
        seleccionado = false;
        this.mano = mano;
        this.color = color;
        setColorMio(color);
        //boton.setFont(Font.TYPE1_FONT);
        setSize(new Dimension(40, 40));
        setMargin(new java.awt.Insets(0,0,0,0));
        this.setFont(new Font("arial", Font.PLAIN, 17));
        setText(mano.toString());//mano.toString()
        
        setVisible(true);
        this.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizaCuadrito();
                //llamada a controller de cuadrito cambiado
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
