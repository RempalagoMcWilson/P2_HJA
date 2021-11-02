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
        int solucionActual = 14;
        // Para las escaleras y el color se necesitan más de tres cartas pq con una pareja no hay opción de conseguirlo con menos
        if(board.getNumCart() > 3){
            
            // Comprobamos posible escalera real
            if(mano.getCarta1() >= 10){
                if(board.getColH() == 4 || board.getColS() == 4|| board.getColC() == 4 || board.getColD() == 4){
                    // Escalera Real con 4 cartas en board
                    if(board.getNumCart() == 4){
                        if(board.getTrio() == 0 && board.getPareja1() == 0 && board.getPoker() == 0){
                            int proyecto = 0;
                            int cartaQueFalta = 0;
                            for(int i = 10; i <15;i++){
                                if(board.getRepeticiones().get(i).size() > 0){
                                    proyecto++;
                                }
                                else{
                                    cartaQueFalta = i;
                                }
                            }
                            if(proyecto < 4){
                                if(cartaQueFalta == mano.getCarta1()){
                                    sol = new Solucion(0,1,mano.toString());
                                    solucionActual = 0;
                                }
                            }
                        }
                    }
                    //Escalera Real con 5 cartas en board
                    if(board.getNumCart() == 5){
                        if(board.getTrio() == 0 && board.getPoker() == 0){
                            int proyecto = 0;
                            int cartaQueFalta = 0;
                            for(int i = 10; i <15;i++){
                                if(board.getRepeticiones().get(i).size() > 0){
                                    proyecto++;
                                }
                                else{
                                    cartaQueFalta = i;
                                }
                            }
                            if(proyecto >= 4){
                                if(cartaQueFalta == 0){ //Escalera Real en el board
                                    sol = new Solucion(0,1,mano.toString());
                                    solucionActual = 0;
                                }
                                if(cartaQueFalta == mano.getCarta1()){
                                    sol = new Solucion(0,1,mano.toString());
                                    solucionActual = 0;
                                }
                            }
                        }
                    }
                }
            }
            
            // Escalera de Color
            if(solucionActual > 1){
                if(board.getColH() == 4 || board.getColS() == 4|| board.getColC() == 4 || board.getColD() == 4){
                    // Escalera Color con 4 cartas en board
                    if(board.getNumCart() == 4){
                        if(board.getTrio() == 0 && board.getPareja1() == 0 && board.getPoker() == 0){
                            int proyecto = 0;
                            int cartaQueFalta = 0;
                            // En caso de que la primera carta no sea la de la mano
                            if(mano.getCarta1() > board.getListaOrdenada().get(0).getNum()){
                                if(board.getListaOrdenada().get(4).getNum() - board.getListaOrdenada().get(0).getNum() >= 3){
                                    for(int i = board.getListaOrdenada().get(0).getNum() ; i < board.getListaOrdenada().get(0).getNum()+ 5;i++){
                                        if(board.getRepeticiones().get(i).size() > 0){
                                            proyecto++;
                                        }
                                        else{
                                            cartaQueFalta = i;
                                        }
                                    }
                                    if(proyecto < 4){
                                        if(cartaQueFalta == mano.getCarta1()){
                                            sol = new Solucion(0,1,mano.toString());
                                            solucionActual = 1;
                                        }
                                    }
                                }
                            }
                            // En caso de que la primera carta sea de la mano
                            else{
                                if(board.getListaOrdenada().get(3).getNum() - mano.getCarta1() == 4){
                                    for(int i = mano.getCarta1(); i < mano.getCarta1()+5;i++){
                                        if(board.getRepeticiones().get(i).size() > 0){
                                            proyecto++;
                                        }
                                    }
                                    if(proyecto == 5){
                                        if(cartaQueFalta == mano.getCarta1()){
                                            sol = new Solucion(1,1,mano.toString());
                                            solucionActual = 1;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    //Escalera Color con 5 cartas en board
                    if(board.getNumCart() == 5){
                        if(board.getTrio() == 0 && board.getPareja2() == 0 && board.getPoker() == 0){
                            int proyecto = 0;
                            int cartaQueFalta = 0;
                            // En caso de que la primera carta no sea la de la mano
                            if(mano.getCarta1() > board.getListaOrdenada().get(0).getNum()){
                                // La escalera esta en el board
                                if(board.getListaOrdenada().get(4).getNum() - board.getListaOrdenada().get(0).getNum() == 4){
                                    for(int i = board.getListaOrdenada().get(0).getNum() ; i < board.getListaOrdenada().get(0).getNum()+ 5;i++){
                                        if(board.getRepeticiones().get(i).size() > 0){
                                            proyecto++;
                                        }
                                        else{
                                            cartaQueFalta = i;
                                        }
                                    }
                                    if(proyecto < 4){
                                        if(cartaQueFalta == mano.getCarta1()){
                                            sol = new Solucion(1,1,mano.toString());
                                            solucionActual = 1;
                                        }
                                    }
                                }
                                // Si la carta de la mano esta en medio o al final
                                if(board.getListaOrdenada().get(3).getNum() - board.getListaOrdenada().get(0).getNum() >= 3){
                                    for(int i = board.getListaOrdenada().get(0).getNum() ; i < board.getListaOrdenada().get(0).getNum()+ 5;i++){
                                        if(board.getRepeticiones().get(i).size() > 0){
                                            proyecto++;
                                        }
                                        else{
                                            cartaQueFalta = i;
                                        }
                                    }
                                    if(proyecto < 4){
                                        if(cartaQueFalta == mano.getCarta1()){
                                            sol = new Solucion(1,1,mano.toString());
                                            solucionActual = 1;
                                        }
                                    }
                                }
                              
                            }

                            // En caso de que la primera carta sea de la mano
                            else{
                                if(board.getListaOrdenada().get(4).getNum() - mano.getCarta1() == 4){
                                    for(int i = mano.getCarta1(); i < mano.getCarta1()+5;i++){
                                        if(board.getRepeticiones().get(i).size() > 0){
                                            proyecto++;
                                        }
                                    }
                                    if(proyecto == 5){
                                        if(cartaQueFalta == mano.getCarta1()){
                                            sol = new Solucion(1,1,mano.toString());
                                            solucionActual = 1;
                                        }
                                    }
                                }
                            }
                            if(mano.getCarta1() > board.getListaOrdenada().get(1).getNum()){
                                // La escalera esta en el board
                                if(board.getListaOrdenada().get(4).getNum() - board.getListaOrdenada().get(0).getNum() == 4){
                                    for(int i = board.getListaOrdenada().get(0).getNum() ; i < board.getListaOrdenada().get(0).getNum()+ 5;i++){
                                        if(board.getRepeticiones().get(i).size() > 0){
                                            proyecto++;
                                        }
                                        else{
                                            cartaQueFalta = i;
                                        }
                                    }
                                    if(proyecto < 4){
                                        if(cartaQueFalta == mano.getCarta1()){
                                            if(solucionActual == 1){
                                                sol = new Solucion(1,2,mano.toString());
                                            }
                                            else{
                                                sol = new Solucion(1,1,mano.toString());
                                            }
                                            solucionActual = 1;
                                        }
                                    }
                                }
                                // Si la carta de la mano esta en medio o al final
                                if(board.getListaOrdenada().get(3).getNum() - board.getListaOrdenada().get(0).getNum() >= 3){
                                    for(int i = board.getListaOrdenada().get(0).getNum() ; i < board.getListaOrdenada().get(0).getNum()+ 5;i++){
                                        if(board.getRepeticiones().get(i).size() > 0){
                                            proyecto++;
                                        }
                                        else{
                                            cartaQueFalta = i;
                                        }
                                    }
                                    if(proyecto < 4){
                                        if(cartaQueFalta == mano.getCarta1()){
                                            if(solucionActual == 1){
                                                sol = new Solucion(1,2,mano.toString());
                                            }
                                            else{
                                                sol = new Solucion(1,1,mano.toString());
                                            }
                                            solucionActual = 1;
                                        }
                                    }
                                }
                              
                            }

                            // En caso de que la primera carta sea de la mano
                            else{
                                if(board.getListaOrdenada().get(4).getNum() - mano.getCarta1() == 4){
                                    for(int i = mano.getCarta1(); i < mano.getCarta1()+5;i++){
                                        if(board.getRepeticiones().get(i).size() > 0){
                                            proyecto++;
                                        }
                                    }
                                    if(proyecto == 5){
                                        if(cartaQueFalta == mano.getCarta1()){
                                            sol = new Solucion(1,1,mano.toString());
                                            solucionActual = 1;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            
            //Poker
            if(solucionActual > 1){
                
            }
            
            //Full House
            if(solucionActual > 2){
                
            }
            
            //Color
            
            if(solucionActual > 3){
                
            }
            
            // Escalera
            if(solucionActual > 4){
                    // Escalera Color con 4 cartas en board
                    if(board.getNumCart() == 4){
                        if(board.getTrio() == 0 && board.getPareja1() == 0 && board.getPoker() == 0){
                            int proyecto = 0;
                            int cartaQueFalta = 0;
                            // En caso de que la primera carta no sea la de la mano
                            if(mano.getCarta1() > board.getListaOrdenada().get(0).getNum()){
                                if(board.getListaOrdenada().get(4).getNum() - board.getListaOrdenada().get(0).getNum() >= 3){
                                    for(int i = board.getListaOrdenada().get(0).getNum() ; i < board.getListaOrdenada().get(0).getNum()+ 5;i++){
                                        if(board.getRepeticiones().get(i).size() > 0){
                                            proyecto++;
                                        }
                                        else{
                                            cartaQueFalta = i;
                                        }
                                    }
                                    if(proyecto < 4){
                                        if(cartaQueFalta == mano.getCarta1()){
                                            sol = new Solucion(0,1,mano.toString());
                                            solucionActual = 1;
                                        }
                                    }
                                }
                            }
                            // En caso de que la primera carta sea de la mano
                            else{
                                if(board.getListaOrdenada().get(3).getNum() - mano.getCarta1() == 4){
                                    for(int i = mano.getCarta1(); i < mano.getCarta1()+5;i++){
                                        if(board.getRepeticiones().get(i).size() > 0){
                                            proyecto++;
                                        }
                                    }
                                    if(proyecto == 5){
                                        if(cartaQueFalta == mano.getCarta1()){
                                            sol = new Solucion(5,1,mano.toString());
                                            solucionActual = 1;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    //Escalera Color con 5 cartas en board
                    if(board.getNumCart() == 5){
                        if(board.getTrio() == 0 && board.getPareja2() == 0 && board.getPoker() == 0){
                            int proyecto = 0;
                            int cartaQueFalta = 0;
                            // En caso de que la primera carta no sea la de la mano
                            if(mano.getCarta1() > board.getListaOrdenada().get(0).getNum()){
                                // La escalera esta en el board
                                if(board.getListaOrdenada().get(4).getNum() - board.getListaOrdenada().get(0).getNum() == 4){
                                    for(int i = board.getListaOrdenada().get(0).getNum() ; i < board.getListaOrdenada().get(0).getNum()+ 5;i++){
                                        if(board.getRepeticiones().get(i).size() > 0){
                                            proyecto++;
                                        }
                                        else{
                                            cartaQueFalta = i;
                                        }
                                    }
                                    if(proyecto < 4){
                                        if(cartaQueFalta == mano.getCarta1()){
                                            sol = new Solucion(5,1,mano.toString());
                                            solucionActual = 5;
                                        }
                                    }
                                }
                                // Si la carta de la mano esta en medio o al final
                                if(board.getListaOrdenada().get(3).getNum() - board.getListaOrdenada().get(0).getNum() >= 3){
                                    for(int i = board.getListaOrdenada().get(0).getNum() ; i < board.getListaOrdenada().get(0).getNum()+ 5;i++){
                                        if(board.getRepeticiones().get(i).size() > 0){
                                            proyecto++;
                                        }
                                        else{
                                            cartaQueFalta = i;
                                        }
                                    }
                                    if(proyecto < 4){
                                        if(cartaQueFalta == mano.getCarta1()){
                                            sol = new Solucion(5,1,mano.toString());
                                            solucionActual = 5;
                                        }
                                    }
                                }
                              
                            }

                            // En caso de que la primera carta sea de la mano
                            else{
                                if(board.getListaOrdenada().get(4).getNum() - mano.getCarta1() == 4){
                                    for(int i = mano.getCarta1(); i < mano.getCarta1()+5;i++){
                                        if(board.getRepeticiones().get(i).size() > 0){
                                            proyecto++;
                                        }
                                    }
                                    if(proyecto == 5){
                                        if(cartaQueFalta == mano.getCarta1()){
                                            sol = new Solucion(5,1,mano.toString());
                                            solucionActual = 5;
                                        }
                                    }
                                }
                            }
                            if(mano.getCarta1() > board.getListaOrdenada().get(1).getNum()){
                                // La escalera esta en el board
                                if(board.getListaOrdenada().get(4).getNum() - board.getListaOrdenada().get(0).getNum() == 4){
                                    for(int i = board.getListaOrdenada().get(0).getNum() ; i < board.getListaOrdenada().get(0).getNum()+ 5;i++){
                                        if(board.getRepeticiones().get(i).size() > 0){
                                            proyecto++;
                                        }
                                        else{
                                            cartaQueFalta = i;
                                        }
                                    }
                                    if(proyecto < 4){
                                        if(cartaQueFalta == mano.getCarta1()){
                                            if(solucionActual == 1){
                                                sol = new Solucion(5,2,mano.toString());
                                            }
                                            else{
                                                sol = new Solucion(5,1,mano.toString());
                                            }
                                            solucionActual = 5;
                                        }
                                    }
                                }
                                // Si la carta de la mano esta en medio o al final
                                if(board.getListaOrdenada().get(3).getNum() - board.getListaOrdenada().get(0).getNum() >= 3){
                                    for(int i = board.getListaOrdenada().get(0).getNum() ; i < board.getListaOrdenada().get(0).getNum()+ 5;i++){
                                        if(board.getRepeticiones().get(i).size() > 0){
                                            proyecto++;
                                        }
                                        else{
                                            cartaQueFalta = i;
                                        }
                                    }
                                    if(proyecto < 4){
                                        if(cartaQueFalta == mano.getCarta1()){
                                            if(solucionActual == 1){
                                                sol = new Solucion(5,2,mano.toString());
                                            }
                                            else{
                                                sol = new Solucion(5,1,mano.toString());
                                            }
                                            solucionActual = 5;
                                        }
                                    }
                                }
                              
                            }

                            // En caso de que la primera carta sea de la mano
                            else{
                                if(board.getListaOrdenada().get(4).getNum() - mano.getCarta1() == 4){
                                    for(int i = mano.getCarta1(); i < mano.getCarta1()+5;i++){
                                        if(board.getRepeticiones().get(i).size() > 0){
                                            proyecto++;
                                        }
                                    }
                                    if(proyecto == 5){
                                        if(cartaQueFalta == mano.getCarta1()){
                                            sol = new Solucion(5,1,mano.toString());
                                            solucionActual = 5;
                                        }
                                    }
                                }
                            }
                        }
                    }
                
            }
        }
        return sol;
    }
    
    private Solucion suitedSolucion(){ //aqui ya sabeis si es suited
        Solucion sol = new Solucion(12, 4, mano.toString());
        return sol;
    }
    
    private Solucion offSuitedSolucion(){/// y aqui offsuited
        Solucion sol = new Solucion(7, 4, mano.toString());
        return sol;
    }   
}
