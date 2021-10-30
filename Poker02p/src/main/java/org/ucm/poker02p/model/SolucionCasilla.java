/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ucm.poker02p.model;


public class SolucionCasilla {
    private Mano mano;
    private Board board;
    private Solucion solucion;

    public SolucionCasilla(Mano mano, Board board) {
        this.mano = mano;
        this.board = board;
        
        switch(mano.getTipo()){
            case 'p':
                solucion = parejaSolucion();
                break;
                case 's':
                solucion = suitedSolucion();
                break;
                case 'o':
                solucion = offSuitedSolucion();
                break;
        }
        
    }
    public Solucion getSolucion(){
        return solucion;
    }
    /*
    0. Escalera real
    1. Escalera de color
    3. Poker
    4. FullHouse
    5. Color
    6. Escalera
    7. Trio
    8. Doble Pareja
    9. OverPair (pareja en mano mejor que la carta mas alta del board)
    10. TopPair (pareja con la carta mas alta del board)
    11. pocket pair below top pair(pareja en mano con cartas menores que la mas alta del board pero que no es débil)
    12. MiddlePair (pareja con la segunda carta mas alta del board)
    13. WeakPair (otras parejas)
    14. Ace high
    15. No made hand
    */
    
    private Solucion parejaSolucion(){
        Solucion sol = new Solucion(0, 0, "");
        return sol;
    }
    
    private Solucion suitedSolucion(){
        Solucion sol = new Solucion(0, 0, "");
        return sol;
    }
    
    private Solucion offSuitedSolucion(){
        Solucion sol = new Solucion(0, 0, "");
        return sol;
    }
    
    
    
}
