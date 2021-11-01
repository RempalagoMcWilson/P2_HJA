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
    2. Poker
    3. FullHouse
    4. Color
    5. Escalera
    6. Trio
    7. Doble Pareja
    8. OverPair (pareja en mano mejor que la carta mas alta del board)
    9. TopPair (pareja con la carta mas alta del board)
    10. pocket pair below top pair(pareja en mano con cartas menores que la mas alta del board pero que no es débil)
    11. MiddlePair (pareja con la segunda carta mas alta del board)
    12. WeakPair (otras parejas)
    13. Ace high
    14. No made hand
    15. Proyecto color
    16. proyecto escalera open-ended
    17. proyecto escalera gutshot
    */
    /*
    new Solucion(5, 4, mano.toString());
    el primer parametro es cual es de lo de arriba, por ej el 6 es trio
    
    el segundo es el num combinaciones, por ejemplo AA sin ninguna A en el board es 6(en el pdf explica mas)
    
    el tercero poned mano.toString()
    
    podeis usar mano.toString() si lo quereis como se escribe en vez de con numeros
    el board es un ArrayList de tipo Carta.java
    for(Carta c: board){//asi se usa el for de ArrayList
    
    }
    
    en el github lo he dejado en la version 1.3.3 seguid por la .4
    */
    private Solucion parejaSolucion(){//aqui ya sabeis si es pareja
        Solucion sol = new Solucion(5, 4, mano.toString());
        if(board.getNumCart() > 3){
            
            // Comprobamos posible escalera real
            if(mano.getCarta1() >= 10){
                if(board.getColH() == 4 || board.getColS() == 4|| board.getColC() == 4 || board.getColD() == 4){
                    // Escalera Real con 4 cartas
                    if(board.getNumCart() == 4){
                        if(board.getTrio() == 0 && board.getPareja1() == 0 && board.getPoker() == 0){
                            //Mira si hay Guthshot
                            if(board.getListaOrdenada().get(0).getNum() == 10 || board.getListaOrdenada().get(0).getNum() == 11){
                                if(board.getListaOrdenada().get(3).getNum() - board.getListaOrdenada().get(0).getNum() == 4){
                                    if(board.getListaOrdenada().get(1).getNum() == 11 && board.getListaOrdenada().get(2).getNum() == 12 && mano.getCarta1() == 13){
                                        sol = new Solucion(0,1, mano.toString());
                                    }
                                    if(board.getListaOrdenada().get(1).getNum() == 12 && board.getListaOrdenada().get(2).getNum() == 13 && mano.getCarta1() == 11){
                                        sol = new Solucion(0,1, mano.toString());
                                    }
                                    if(board.getListaOrdenada().get(1).getNum() == 11 && board.getListaOrdenada().get(2).getNum() == 13 && mano.getCarta1() == 12){
                                        sol = new Solucion(0,1, mano.toString());
                                    }
                                }
                            }
                            //Mira si hay Open-ended
                            if(board.getListaOrdenada().get(0).getNum() == 10 || board.getListaOrdenada().get(0).getNum() == 11){
                                if(board.getListaOrdenada().get(3).getNum() - board.getListaOrdenada().get(0).getNum() == 4){
                                    if(board.getListaOrdenada().get(0).getNum() == 10 && mano.getCarta1() == 14){
                                        sol = new Solucion(0,1, mano.toString());
                                    }
                                    if(board.getListaOrdenada().get(4).getNum() == 14 && mano.getCarta1() == 10){
                                        sol = new Solucion(0,1, mano.toString());
                                    }
                                }
                            }
                        }
                    }
                    //Escalera Real con 5 cartas
                    if(board.getNumCart() == 5){
                        if(board.getTrio() == 0 && board.getPoker() == 0){
                            if(board.getListaOrdenada().get(3).getNum() - board.getListaOrdenada().get(0).getNum() == 4 || board.getListaOrdenada().get(4).getNum() - board.getListaOrdenada().get(1).getNum() == 4){
                            }
                        }
                    }
                }
            }
        }
        return sol;
    }
    
    private Solucion suitedSolucion(){//aqui ya sabeis si es suited
        Solucion sol = new Solucion(12, 4, mano.toString());
        return sol;
    }
    
    private Solucion offSuitedSolucion(){/// y aqui offsuited
        Solucion sol = new Solucion(7, 4, mano.toString());
        return sol;
    }
    
    
    
}
