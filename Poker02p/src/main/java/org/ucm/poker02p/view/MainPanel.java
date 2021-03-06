/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.ucm.poker02p.view;

import java.awt.Color;
import java.util.ArrayList;
import java.util.TreeMap;
import javax.swing.JPanel;
import org.ucm.poker02p.control.Controller;
import org.ucm.poker02p.model.GeneraSoluciones;
import org.ucm.poker02p.model.Solucion;
//import org.ucm.poker02p.model.Simulator;


public class MainPanel extends javax.swing.JFrame {
    private Controller cntr;
    private boolean rankingActivado;
    private boolean jugadasActivado;
    private PanelRango pR;
    private GeneraSoluciones gS;
    private PanelBoard pB;
    
    /**
     * Creates new form MainPanel
     */
    public MainPanel(Controller cntr) {
        gS = new GeneraSoluciones();
        //setLocationRelativeTo(null);
        this.cntr = cntr;rankingActivado = false;jugadasActivado = false;
        
        initComponents();
        
        boardTextoButton.setEnabled(false);
        generaSolucionButton.setEnabled(false);
        this.setVisible(true);
        PanelCuadritos pC = new PanelCuadritos(cntr);
        pR = new PanelRango(cntr);
        PanelPorcentaje pP = new PanelPorcentaje(cntr);
        SliderPorcentaje sP = new SliderPorcentaje(cntr);
        pB = new PanelBoard(cntr);
        rangoEnTextoPanel.setBackground(new Color(195,195,195));
        rangoEnTextoPanel.add(pR);
        
        casillasRangoPanel.setBackground(new Color(195,195,195));
        casillasRangoPanel.add(pC);
        porcentajePanel.setBackground(new Color(195,195,195));
        porcentajePanel.add(pP);
        sliderPanel.setBackground(new Color(195,195,195));
        sliderPanel.add(sP);
        casillasBoardPanel.setBackground(new Color(195,195,195));
        casillasBoardPanel.add(pB);
        //this.setBackground(new Color(225,225,183));//
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rangoTextoButton = new javax.swing.JButton();
        casillasRangoPanel = new javax.swing.JPanel();
        resetButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        rangoEnTextoPanel = new javax.swing.JPanel();
        porcentajePanel = new javax.swing.JPanel();
        sliderPanel = new javax.swing.JPanel();
        ActivaRankingButton = new javax.swing.JButton();
        activaJugadasButton = new javax.swing.JButton();
        boardTextoButton = new javax.swing.JButton();
        casillasBoardPanel = new javax.swing.JPanel();
        generaSolucionButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(225, 225, 183));
        setResizable(false);

        rangoTextoButton.setText("METE RANGO TEXTO");
        rangoTextoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rangoTextoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout casillasRangoPanelLayout = new javax.swing.GroupLayout(casillasRangoPanel);
        casillasRangoPanel.setLayout(casillasRangoPanelLayout);
        casillasRangoPanelLayout.setHorizontalGroup(
            casillasRangoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );
        casillasRangoPanelLayout.setVerticalGroup(
            casillasRangoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        resetButton.setText("RESET");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Este es el rango actual en texto");

        javax.swing.GroupLayout rangoEnTextoPanelLayout = new javax.swing.GroupLayout(rangoEnTextoPanel);
        rangoEnTextoPanel.setLayout(rangoEnTextoPanelLayout);
        rangoEnTextoPanelLayout.setHorizontalGroup(
            rangoEnTextoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        rangoEnTextoPanelLayout.setVerticalGroup(
            rangoEnTextoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout porcentajePanelLayout = new javax.swing.GroupLayout(porcentajePanel);
        porcentajePanel.setLayout(porcentajePanelLayout);
        porcentajePanelLayout.setHorizontalGroup(
            porcentajePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 82, Short.MAX_VALUE)
        );
        porcentajePanelLayout.setVerticalGroup(
            porcentajePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout sliderPanelLayout = new javax.swing.GroupLayout(sliderPanel);
        sliderPanel.setLayout(sliderPanelLayout);
        sliderPanelLayout.setHorizontalGroup(
            sliderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );
        sliderPanelLayout.setVerticalGroup(
            sliderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        ActivaRankingButton.setText("ACTIVA RANKING");
        ActivaRankingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActivaRankingButtonActionPerformed(evt);
            }
        });

        activaJugadasButton.setText("ACTIVA JUGADAS");
        activaJugadasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activaJugadasButtonActionPerformed(evt);
            }
        });

        boardTextoButton.setText("METE BOARD TEXTO");
        boardTextoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boardTextoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout casillasBoardPanelLayout = new javax.swing.GroupLayout(casillasBoardPanel);
        casillasBoardPanel.setLayout(casillasBoardPanelLayout);
        casillasBoardPanelLayout.setHorizontalGroup(
            casillasBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        casillasBoardPanelLayout.setVerticalGroup(
            casillasBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        generaSolucionButton.setText("GENERAR SOLUCION");
        generaSolucionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generaSolucionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rangoEnTextoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(casillasRangoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sliderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(porcentajePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(activaJugadasButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(boardTextoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(resetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ActivaRankingButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(generaSolucionButton, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                    .addComponent(rangoTextoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(casillasBoardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rangoEnTextoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(casillasBoardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(casillasRangoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(rangoTextoButton)
                        .addGap(18, 18, 18)
                        .addComponent(boardTextoButton)
                        .addGap(18, 18, 18)
                        .addComponent(resetButton)
                        .addGap(18, 18, 18)
                        .addComponent(ActivaRankingButton)
                        .addGap(18, 18, 18)
                        .addComponent(activaJugadasButton)
                        .addGap(18, 18, 18)
                        .addComponent(generaSolucionButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sliderPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(porcentajePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rangoTextoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rangoTextoButtonActionPerformed
        
        MeterRangoFrame mRF = new MeterRangoFrame(cntr, this);
        
    }//GEN-LAST:event_rangoTextoButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        cntr.reset();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void ActivaRankingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActivaRankingButtonActionPerformed
        if(rankingActivado) {
            rankingActivado = false;
            
            rangoTextoButton.setEnabled(true);
            activaJugadasButton.setEnabled(true);
        }
        else {
            rankingActivado = true;
            
            rangoTextoButton.setEnabled(false);
            activaJugadasButton.setEnabled(false);
        }
        cntr.activaRanking(rankingActivado);
        
    }//GEN-LAST:event_ActivaRankingButtonActionPerformed

    private void activaJugadasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activaJugadasButtonActionPerformed
        if(jugadasActivado) {
            jugadasActivado = false;
            boardTextoButton.setEnabled(false);
            
            ActivaRankingButton.setEnabled(true);
            generaSolucionButton.setEnabled(false);
        }
        else {
            jugadasActivado = true;
            
            boardTextoButton.setEnabled(true);
            ActivaRankingButton.setEnabled(false);
            generaSolucionButton.setEnabled(true);
        }
        cntr.activaJugadas(jugadasActivado);
    }//GEN-LAST:event_activaJugadasButtonActionPerformed

    private void generaSolucionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generaSolucionButtonActionPerformed
        if(pB.getBoard().getNumCart() >2 && pB.getBoard().getNumCart() < 6){
            gS.generaSolucion(pR.getRango(), pB.getBoard());
            SolucionFrame sF = new SolucionFrame(this , gS.getSoluciones());
        }
    }//GEN-LAST:event_generaSolucionButtonActionPerformed

    private void boardTextoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boardTextoButtonActionPerformed
        MeterBoardFrame mBF = new MeterBoardFrame(cntr, this);
    }//GEN-LAST:event_boardTextoButtonActionPerformed

    
    

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActivaRankingButton;
    private javax.swing.JButton activaJugadasButton;
    private javax.swing.JButton boardTextoButton;
    private javax.swing.JPanel casillasBoardPanel;
    private javax.swing.JPanel casillasRangoPanel;
    private javax.swing.JButton generaSolucionButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel porcentajePanel;
    private javax.swing.JPanel rangoEnTextoPanel;
    private javax.swing.JButton rangoTextoButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JPanel sliderPanel;
    // End of variables declaration//GEN-END:variables
}
