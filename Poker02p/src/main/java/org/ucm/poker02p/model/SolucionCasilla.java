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
    
    // No estoy seguro de como tienen q ser los returns preguntar a JUANMA
    private Solucion parejaSolucion(){//aqui ya sabeis si es pareja
        Solucion sol = new Solucion(12, 6, mano.toString());
        int solucionActual = 12;
        // Para las escaleras y el color se necesitan más de tres cartas pq con una pareja no hay opción de conseguirlo con menos
        
            
            // Comprobamos posible escalera real
            if(mano.getCarta1() >= 10 && (board.getListaOrdenada().get(0).getNum() >= 10 || board.getListaOrdenada().get(1).getNum() >= 10)){
                
                if(board.getColC() >= 4 || board.getColS() >= 4 || board.getColH() >= 4 || board.getColD() >= 4){
                    // Escalera Real con 4 cartas en board
                    sol = resuelveEscaleraPareja();
                    if(sol.getJugada() == 5){ // Por defecto va a devolver que la jugada va a ser 5
                        sol = new Solucion(0,3,mano.toString());
                        solucionActual = 0;
                    }
                    
                }
            }
            
            // Escalera de Color
            if(solucionActual > 0){
                if(board.getColC() >= 4 || board.getColS() >= 4 || board.getColH() >= 4 || board.getColD() >= 4){
                    sol = resuelveEscaleraPareja();
                    if(sol.getJugada() == 5){
                        sol = new Solucion(1,3,mano.toString());
                        solucionActual = 1;
                    }
                }
            }
        
               
            //Poker
            if(solucionActual > 1){
                if(board.getPareja1() != 0 || board.getPareja2() != 0){
                    if(board.getPareja1() == mano.getCarta1() || board.getPareja2() == mano.getCarta1()){
                        sol = new Solucion(2,6,mano.toString());
                        solucionActual = 2;
                    }
                }
            }
        
            //Full House
            if(solucionActual > 2){
                if(board.getPareja1() != 0 || board.getTrio() != 0){ // Si en el board no hay un trio o una pareja no puede haber full 
                    if(board.getTrio() != 0){
                        sol = new Solucion(3,6,mano.toString());
                        solucionActual = 3;
                    }
                    if(board.getPareja1() != 0 && board.getRepeticiones().get(mano.getCarta1()) != null){
                        sol = new Solucion(3,6,mano.toString());
                        solucionActual = 3;
                    }
                }
            }
            
            //Color
            if(solucionActual > 3){
                if(board.getColC() == 4 || board.getColS() == 4 || board.getColH() == 4 || board.getColD() == 4){
                    sol = new Solucion(4,3,mano.toString());
                    solucionActual = 4;
                }
            }
            
            // Escalera
            if(board.getNumCart() > 3){
                if(solucionActual > 4){
                    sol = resuelveEscaleraPareja();
                    if(sol.getJugada() == 5){
                        solucionActual = 5;
                    }
                }
            }
            
            // Trio
            if(solucionActual > 5){
                if(board.getRepeticiones().get(mano.getCarta1()) != null){
                    sol = new Solucion(6,6,mano.toString());
                    solucionActual = 6;
                }
            }
            
            // Doble Pareja
            if(solucionActual > 6){
                if(board.getPareja1() != 0){ //Basta con que tenga una aunque la otra pueda ser mejor
                    sol = new Solucion(7,6,mano.toString());
                    solucionActual = 7;
                }
            }
            
            // OverPair
            if(solucionActual > 7){
                if(board.getPareja1() == 0 && mano.getCarta1() > board.getListaOrdenada().get(board.getNumCart()-1).getNum()){
                    sol = new Solucion(8,6,mano.toString());
                    solucionActual = 8;
                }
            }
            
            // TopPair
            // No puede tener Top Pair pq al ser una pareja no puede hacer una pareja con una carta del board
            
            //Pocket pair below top pair(pareja en mano con cartas menores que la mas alta del board pero que no es débil)
            if(solucionActual > 9){
                if(board.getPareja1() == 0 && mano.getCarta1() > board.getListaOrdenada().get(board.getNumCart()-2).getNum()){
                    sol = new Solucion(10,6,mano.toString());
                    solucionActual = 10;
                }
            }
            
            // MiddlePair
            // No puede tener Middle Pair pq al ser una pareja no puede hacer una pareja con una carta del board
            //12. WeakPair (otras parejas)
            
            if(solucionActual > 11){
                if(board.getPareja1() == 0 && mano.getCarta1() < board.getListaOrdenada().get(board.getNumCart()-2).getNum()){
                    sol = new Solucion(12,6,mano.toString());
                    solucionActual = 12;
                }
            }
            
            //No hace falta hacer más comprobaciones porque como mínimo tiene pareja siempre
        return sol;
    }
    
    private Solucion suitedSolucion(){ //aqui ya sabeis si es suited
        Solucion sol = new Solucion(14, 6, mano.toString());
        int solucionActual = 14;        
        
        // Escalera real
        // Escalera de color
        if(solucionActual > 1){
        
        }
        // Poker
        if(solucionActual > 2){
        	if(board.getTrio() == mano.getCarta1() || board.getTrio() == mano.getCarta2()) {
        		sol = new Solucion(2,1,mano.toString());
        		solucionActual = 2;
        	}
        }
        
        //3. FullHouse
        if(solucionActual > 3){
        	if(board.getTrio() != 0) {
        		if(board.getNRepeticiones().get(mano.getCarta1() - 2) != 0 || board.getNRepeticiones().get(mano.getCarta2() - 2) != 0) {
        			sol = new Solucion(3,3,mano.toString());
        			solucionActual = 3;
            		if(board.getNRepeticiones().get(mano.getCarta1() - 2) != 0 && board.getNRepeticiones().get(mano.getCarta2() - 2) != 0) {
            			sol = new Solucion(3,6,mano.toString());
            		}
        		}
        	}
        	if(board.getPareja1() != 0) {
        		
        		if(mano.getCarta1() == board.getPareja1() && board.getNRepeticiones().get(mano.getCarta2()-2) == 1) {
        			sol = new Solucion(3,6,mano.toString());
        			solucionActual = 3;
        		}	
        		if(mano.getCarta2() == board.getPareja1() && board.getNRepeticiones().get(mano.getCarta1()-2) == 1) {
        			sol = new Solucion(3,6,mano.toString());
        			solucionActual = 3;
        		}
        		if(board.getPareja2() != 0) {
        			if(mano.getCarta1() == board.getPareja1() || mano.getCarta1() == board.getPareja2()) {
        				sol = new Solucion(3,3,mano.toString());
        				if(mano.getCarta2() == board.getPareja1() || mano.getCarta2() == board.getPareja2()){
            				sol = new Solucion(3,3,mano.toString());
        				}
        				solucionActual = 3;
        			}
        			
        			if(mano.getCarta2() == board.getPareja1() || mano.getCarta2() == board.getPareja2()) {
        				sol = new Solucion(3,3,mano.toString());
        				if(mano.getCarta1() == board.getPareja1() || mano.getCarta1() == board.getPareja2()){
            				sol = new Solucion(3,3,mano.toString());
        				}
        				solucionActual = 3;
        			}
            	}
        	} 
        }
        
        //Color
        if(solucionActual > 4){
            if(board.getColC() == 4 || board.getColS() == 4 || board.getColH() == 4 || board.getColD() == 4){
                sol = new Solucion(4,1,mano.toString());
                solucionActual = 4;
            }
            if(board.getColC() == 3 || board.getColS() == 3 || board.getColH() == 3 || board.getColD() == 3){
                sol = new Solucion(4,1,mano.toString());
                solucionActual = 4;
            }
        }
        
        //Escalera
        if(solucionActual > 5){
        
        }
        
        // Trio
        if(solucionActual > 6){
        
        }
        
        // Doble Pareja
        if(solucionActual > 7){
        
        }
        
        // OverPair (pareja en mano mejor que la carta mas alta del board)
        // No puede haber over pair pq no tienes una pareja en mano
        
        // TopPair (pareja con la carta mas alta del board)
        if(solucionActual > 9){
            if(board.getNumCart() == 3){
                if(mano.getCarta1() == board.getListaOrdenada().get(2).getNum() || mano.getCarta2() == board.getListaOrdenada().get(2).getNum()){
                    sol = new Solucion(13,6,mano.toString());
                }
                if(board.getNumCart() == 4){
                    if(mano.getCarta1() == board.getListaOrdenada().get(3).getNum() || mano.getCarta2() == board.getListaOrdenada().get(3).getNum()){
                        sol = new Solucion(13,6,mano.toString());
                    }
                    if(board.getNumCart() == 5){
                        if(mano.getCarta1() == board.getListaOrdenada().get(4).getNum() || mano.getCarta2() == board.getListaOrdenada().get(4).getNum()){
                            sol = new Solucion(13,6,mano.toString());
                        }  
                    }
                }
            }
        }
        
        // pocket pair below top pair(pareja en mano con cartas menores que la mas alta del board pero que no es débil)
        // No puede haber pocket pair pq no tienes pareja en mano
        
        // MiddlePair (pareja con la segunda carta mas alta del board)
        if(solucionActual > 11){
            if(board.getNumCart() == 3){
                if(mano.getCarta1() == board.getListaOrdenada().get(1).getNum() || mano.getCarta2() == board.getListaOrdenada().get(1).getNum()){
                    sol = new Solucion(13,6,mano.toString());
                }
                if(board.getNumCart() == 4){
                    if(mano.getCarta1() == board.getListaOrdenada().get(2).getNum() || mano.getCarta2() == board.getListaOrdenada().get(2).getNum()){
                        sol = new Solucion(13,6,mano.toString());
                    }
                    if(board.getNumCart() == 5){
                        if(mano.getCarta1() == board.getListaOrdenada().get(3).getNum() || mano.getCarta2() == board.getListaOrdenada().get(3).getNum()){
                            sol = new Solucion(13,6,mano.toString());
                        }  
                    }
                }
            }
        }
        
        // WeakPair (otras parejas)
        if(solucionActual > 12){
            if(board.getNumCart() == 3){
                if(mano.getCarta1() == board.getListaOrdenada().get(0).getNum() || mano.getCarta2() == board.getListaOrdenada().get(0).getNum()){
                    sol = new Solucion(13,6,mano.toString());
                }
                if(board.getNumCart() == 4){
                    if(mano.getCarta1() == board.getListaOrdenada().get(1).getNum() || mano.getCarta2() == board.getListaOrdenada().get(1).getNum()){
                        sol = new Solucion(13,6,mano.toString());
                    }
                    if(board.getNumCart() == 5){
                        if(mano.getCarta1() == board.getListaOrdenada().get(2).getNum() || mano.getCarta2() == board.getListaOrdenada().get(2).getNum()){
                            sol = new Solucion(13,6,mano.toString());
                        }  
                    }
                }
            }
            
        }
        
        // Ace high
        if(solucionActual > 13){
            if(mano.getCarta1() > board.getListaOrdenada().get(board.getNumCart()-1).getNum()){
                sol = new Solucion(14,6,mano.toString());
            }
        }
        
        
        // Proyecto color       
        // proyecto escalera open-ended
        // proyecto escalera gutshot
        
        return sol;
    }
    
    private Solucion offSuitedSolucion(){/// y aqui offsuited
        Solucion sol = new Solucion(14, 6, mano.toString());
        int solucionActual = 14;        
        
        // Escalera real
        // Escalera de color
        if(solucionActual > 1){
        
        }
        // Poker
        if(solucionActual > 2){
        
        }
        
        // FullHouse
        if(solucionActual > 3){
        
        }
        
        //Color
        if(solucionActual > 4){
            if(board.getColC() >= 4 || board.getColS() >= 4 || board.getColH() >= 4 || board.getColD() >= 4 ){
                sol = new Solucion(4,4,mano.toString());
                solucionActual = 4;
            }
        }
        
        //Escalera
        if(solucionActual > 5){
        
        }
        
        // Trio
        if(solucionActual > 6){
        
        }
        
        // Doble Pareja
        if(solucionActual > 7){
        
        }
        
        // OverPair (pareja en mano mejor que la carta mas alta del board)
        // No puede haber over pair pq no tienes una pareja en mano
        
        // TopPair (pareja con la carta mas alta del board)
        if(solucionActual > 9){
            if(board.getNumCart() == 3){
                if(mano.getCarta1() == board.getListaOrdenada().get(2).getNum() || mano.getCarta2() == board.getListaOrdenada().get(2).getNum()){
                    sol = new Solucion(13,6,mano.toString());
                }
                if(board.getNumCart() == 4){
                    if(mano.getCarta1() == board.getListaOrdenada().get(3).getNum() || mano.getCarta2() == board.getListaOrdenada().get(3).getNum()){
                        sol = new Solucion(13,6,mano.toString());
                    }
                    if(board.getNumCart() == 5){
                        if(mano.getCarta1() == board.getListaOrdenada().get(4).getNum() || mano.getCarta2() == board.getListaOrdenada().get(4).getNum()){
                            sol = new Solucion(13,6,mano.toString());
                        }  
                    }
                }
            }
        }
        
        // pocket pair below top pair(pareja en mano con cartas menores que la mas alta del board pero que no es débil)
        // No puede haber pocket pair pq no tienes pareja en mano
        
        // MiddlePair (pareja con la segunda carta mas alta del board)
        if(solucionActual > 11){
            if(board.getNumCart() == 3){
                if(mano.getCarta1() == board.getListaOrdenada().get(1).getNum() || mano.getCarta2() == board.getListaOrdenada().get(1).getNum()){
                    sol = new Solucion(13,6,mano.toString());
                }
                if(board.getNumCart() == 4){
                    if(mano.getCarta1() == board.getListaOrdenada().get(2).getNum() || mano.getCarta2() == board.getListaOrdenada().get(2).getNum()){
                        sol = new Solucion(13,6,mano.toString());
                    }
                    if(board.getNumCart() == 5){
                        if(mano.getCarta1() == board.getListaOrdenada().get(3).getNum() || mano.getCarta2() == board.getListaOrdenada().get(3).getNum()){
                            sol = new Solucion(13,6,mano.toString());
                        }  
                    }
                }
            }
        }
        
        // WeakPair (otras parejas)
        if(solucionActual > 12){
            if(board.getNumCart() == 3){
                if(mano.getCarta1() == board.getListaOrdenada().get(0).getNum() || mano.getCarta2() == board.getListaOrdenada().get(0).getNum()){
                    sol = new Solucion(13,6,mano.toString());
                }
                if(board.getNumCart() == 4){
                    if(mano.getCarta1() == board.getListaOrdenada().get(1).getNum() || mano.getCarta2() == board.getListaOrdenada().get(1).getNum()){
                        sol = new Solucion(13,6,mano.toString());
                    }
                    if(board.getNumCart() == 5){
                        if(mano.getCarta1() == board.getListaOrdenada().get(2).getNum() || mano.getCarta2() == board.getListaOrdenada().get(2).getNum()){
                            sol = new Solucion(13,6,mano.toString());
                        }  
                    }
                }
            }
            
        }
        
        // Ace high
        if(solucionActual > 13){
            if(mano.getCarta1() > board.getListaOrdenada().get(board.getNumCart()-1).getNum()){
                sol = new Solucion(14,6,mano.toString());
            }
        }
        
        // Proyecto color       
        // proyecto escalera open-ended
        // proyecto escalera gutshot
        
        return sol;
    }
    
    public Solucion resuelveEscaleraPareja(){
        Solucion sol = new Solucion(12, 6, mano.toString());
        if(board.getNumCart() == 4){ // La resolucion si hay 4 cartas o 5 es distinta
            if(board.getTrio() == 0 && board.getPareja2() == 0){ // Si hay un trio o una doble pareja no puede haber escalera
                int proyectoEscalera = 0;
                int cartaQueFalta = 0;
                int resta = board.getListaOrdenada().get(3).getNum() - board.getListaOrdenada().get(0).getNum();
                if( resta == 4 || (resta == 3 && board.getListaOrdenada().get(0).getNum() > mano.getCarta1())){ // Si la carta de nuestra mano esta al final o a mitad de escalera
                    // Recorre 4 cartas, desde la primera a la 4
                    for (int i = board.getListaOrdenada().get(0).getNum() - 2 ; i < board.getListaOrdenada().get(0).getNum()+ 2; i++ ){
                        if(board.getNRepeticiones().get(i) == 1){ //Con 4 cartas no puede haber ninguna repetida
                            proyectoEscalera++;
                        }
                        else{
                            cartaQueFalta = i + 2;
                        }
                    }
                    if(proyectoEscalera == 3){
                        if(cartaQueFalta == mano.getCarta1()){
                            sol = new Solucion(5,6,mano.toString());
                            //Hay que actualizar solucion actual
                        }
                    }
                }
                
                else{ // Si la carta de la mano es menor que la menor del board
                    if(board.getListaOrdenada().get(3).getNum() - mano.getCarta1() == 4){
                        // Recorre las 4 cartas siguientes a la mano es "mano.getCarta - 1" pq el valor de esa carta es "mano.getCarta - 2" y estamos mirando desde la siguiente
                        for(int i = mano.getCarta1() - 1; i < mano.getCarta1()+4;i++){
                            if(board.getNRepeticiones().get(i) == 1){
                                proyectoEscalera++;
                            }
                        }
                        if(proyectoEscalera == 4){
                            if(cartaQueFalta == mano.getCarta1()){
                                sol = new Solucion(5,6,mano.toString());
                                //Hay que actualizar solucionActual
                            }
                        }
                    }
                }
            }
        }
        
        if(board.getNumCart() == 5){ // En caso de haber 5 cartas en el board
            int proyectoEscalera = 0;
            int cartaQueFalta = 0;
            boolean yaHayUnaRepeticion = false;
            boolean solucionado = false;
            if(mano.getCarta1() >= board.getListaOrdenada().get(0).getNum()-1){ //La escalera puede tener la primera carta del board
                int resta1 = board.getListaOrdenada().get(3).getNum() - board.getListaOrdenada().get(0).getNum();
                int resta2 = board.getListaOrdenada().get(4).getNum() - board.getListaOrdenada().get(0).getNum();
                if( resta1 == 4 || resta1 == 3 || resta2 == 4 || resta2 == 3){ // Si la carta de nuestra mano esta al final o a mitad de escalera
                    // Recorre 4 cartas, desde la primera a la 4
                    for (int i = board.getListaOrdenada().get(0).getNum() - 2 ; i < board.getListaOrdenada().get(0).getNum()+ 4; i++ ){
                        if(i != board.getListaOrdenada().get(0).getNum()+ 3){
                            if(board.getNRepeticiones().get(i) == 1){ //Con 4 cartas no puede haber ninguna repetida
                                proyectoEscalera++;
                            }
                            if(board.getNRepeticiones().get(i) == 2){ //Con 4 cartas no puede haber ninguna repetida
                               proyectoEscalera++;
                               yaHayUnaRepeticion = true;
                            }
                            if(board.getNRepeticiones().get(i) == 0){
                                cartaQueFalta = i + 2;
                            }
                        }
                        else{
                            if(yaHayUnaRepeticion){
                                if(board.getNRepeticiones().get(i) == 1){ //Con 4 cartas no puede haber ninguna repetida
                                proyectoEscalera++;
                                }
                                if(board.getNRepeticiones().get(i) == 2){ //Con 4 cartas no puede haber ninguna repetida
                                    proyectoEscalera++;
                                    yaHayUnaRepeticion = true;
                                }
                                if(board.getNRepeticiones().get(i) == 0){
                                    cartaQueFalta = i + 2;
                                }
                            }
                            
                            
                        }
                    }
                    if(proyectoEscalera == 3){
                        if(cartaQueFalta == mano.getCarta1()){
                            sol = new Solucion(5,6,mano.toString());
                            solucionado = true;
                            //Hay que actualizar solucion actual
                        }
                    }  
                }
                if(!solucionado){ // Si la carta de la mano es menor que la menor del board
                	proyectoEscalera = 0;
                	yaHayUnaRepeticion = false;
                    if(board.getListaOrdenada().get(3).getNum() - mano.getCarta1() == 4){
                      // Recorre las 4 cartas siguientes a la mano es "mano.getCarta - 1" pq el valor de esa carta es "mano.getCarta - 2" y estamos mirando desde la siguiente
                        for(int i = mano.getCarta1() - 1; i < mano.getCarta1()+5;i++){
                            if(i != mano.getCarta1()+5){
                                if(board.getNRepeticiones().get(i) == 1){ //Con 4 cartas no puede haber ninguna repetida
                                    proyectoEscalera++;
                                }
                                if(board.getNRepeticiones().get(i) == 2){ //Con 4 cartas no puede haber ninguna repetida
                                   proyectoEscalera++;
                                   yaHayUnaRepeticion = true;
                                }
                                if(board.getNRepeticiones().get(i) == 0){
                                    cartaQueFalta = i + 2;
                                }
                            }
                            else{
                                if(!yaHayUnaRepeticion){
                                    if(board.getNRepeticiones().get(i) == 1){ //Con 4 cartas no puede haber ninguna repetida
                                    proyectoEscalera++;
                                    }
                                }
                                if(board.getNRepeticiones().get(i) == 2){ //Con 4 cartas no puede haber ninguna repetida
                                    proyectoEscalera++;
                                    yaHayUnaRepeticion = true;
                                }
                                if(board.getNRepeticiones().get(i) == 0){
                                    cartaQueFalta = i + 2;
                                }
                            }
                        }
                        if(proyectoEscalera == 4){
                            if(cartaQueFalta == mano.getCarta1()){
                                sol = new Solucion(5,6,mano.toString());
                                //Hay que actualizar solucionActual
                            }
                        }
                    }
                }
            }
            
            
            if(mano.getCarta1() >= board.getListaOrdenada().get(1).getNum()-1){ //La escalera puede tener la primera carta del board
                int resta = board.getListaOrdenada().get(4).getNum() - board.getListaOrdenada().get(1).getNum();
                if( resta == 4 || resta == 3 ){ // Si la carta de nuestra mano esta al final o a mitad de escalera
                    // Recorre 4 cartas, desde la primera a la 4
                    for (int i = board.getListaOrdenada().get(1).getNum() - 2 ; i < board.getListaOrdenada().get(1).getNum()+ 2; i++ ){
                        if(board.getNRepeticiones().get(i) == 1){ //Con 4 cartas no puede haber ninguna repetida
                            proyectoEscalera++;
                        }
                        else{
                            cartaQueFalta = i + 2;
                        }
                    }
                    if(proyectoEscalera == 3){
                        if(cartaQueFalta == mano.getCarta1()){
                            sol = new Solucion(5,6,mano.toString());
                            //Hay que actualizar solucion actual
                        }
                    }
                }
                
                else{ // Si la carta de la mano es menor que la menor del board
                    if(board.getListaOrdenada().get(4).getNum() - mano.getCarta1() == 4){
                        // Recorre las 4 cartas siguientes a la mano es "mano.getCarta - 1" pq el valor de esa carta es "mano.getCarta - 2" y estamos mirando desde la siguiente
                        for(int i = mano.getCarta1() - 1; i < mano.getCarta1()+4;i++){
                            if(board.getNRepeticiones().get(i) == 1){
                                proyectoEscalera++;
                            }
                        }
                        if(proyectoEscalera == 4){
                            if(cartaQueFalta == mano.getCarta1()){
                                sol = new Solucion(5,6,mano.toString());
                                //Hay que actualizar solucionActual
                            }
                        }
                    }
                }
            }
        }
        return sol;
    }
}
