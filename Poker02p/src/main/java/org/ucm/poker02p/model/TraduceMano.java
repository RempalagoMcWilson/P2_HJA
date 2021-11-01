/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ucm.poker02p.model;

import java.util.ArrayList;
import java.util.Collections;

public class TraduceMano {//Sin Terminar

    public TraduceMano() {

    }

    private ArrayList<Mano> generaMano(String cartas, String cartas2, Character tipo, boolean suma) {
        ArrayList<Mano> lista = new ArrayList();
        Integer c1, c2, c3, c4;
        c1 = charACarta(cartas.charAt(0));
        c2 = charACarta(cartas.charAt(1));

        //Falta usar cartas2
        if (suma == false) {
            if (tipo == 'p') {
                lista.add(new Mano(c1, c2, 'p'));
            } else if (tipo == 'o') {
                lista.add(new Mano(c2, c1, 'o'));
            } else {
                lista.add(new Mano(c1, c2, 's'));
            }
        } else if (cartas2 != null) {
            c3 = charACarta(cartas2.charAt(0));
            c4 = charACarta(cartas2.charAt(1));
            if (tipo == 'o') {
                for (int i = c2; i != c1; i++) {
                    lista.add(new Mano(i, c1, 'o'));
                }
            } else if (tipo == 's') {
                for (int i = c2; i != c1; i++) {
                    lista.add(new Mano(c1, i, 's'));
                }
            } else {
                for (int i = c1; i <= 14; i++) {
                    lista.add(new Mano(i, i, 'p'));
                }
            }

        } else {
            if (tipo == 'o') {
                for (int i = c2; i != c1; i++) {
                    lista.add(new Mano(i, c1, 'o'));
                }
            } else if (tipo == 's') {
                for (int i = c2; i != c1; i++) {
                    lista.add(new Mano(c1, i, 's'));
                }
            } else {
                for (int i = c1; i <= 14; i++) {
                    lista.add(new Mano(i, i, 'p'));
                }
            }
        }

        return lista;

    }

    public ArrayList<Mano> traduceMano(String entrada) {
        ArrayList<Mano> lista = new ArrayList();
        int i = 0;
        String aux, aux2;
        while (i < entrada.length()) {
            //System.out.println(i + " "+ entrada.length());
            aux = entrada.substring(i, i + 2);

            if (i + 2 < entrada.length()) {
                if (entrada.charAt(i + 2) != ',') {

                    if (entrada.charAt(i + 2) != '+') {
                        if (entrada.charAt(i + 2) == 's') {
                            //Aqui dentro mirar si hay coma, + o -

                        } else if (entrada.charAt(i + 2) == 'o') {
                            //Aqui dentro mirar si hay coma, + o -
                            if (entrada.charAt(i + 1) == ',') {
                            }
                        } else if (entrada.charAt(i + 2) == '-') {//AA-TT
                            aux2 = entrada.substring(i + 3, i + 5);
                            lista.addAll(generaMano(aux, aux2, 'p', false));
                            i = i + 6;
                        }
                    } else {
                        lista.addAll(generaMano(aux, null, 'p', true));
                        i = i + 4;
                    }
                }
            } else {//AA
                if (entrada.charAt(i) == entrada.charAt(i + 1)) {
                    int par = Integer.parseInt(entrada.substring(i, i + 1)) + 1;
                    lista.add(new Mano(Integer.parseInt(entrada.substring(i, i + 1)), Integer.parseInt(entrada.substring(i + 1, i + 2)), 'p'));
                    while (par < 15) {
                        lista.add(new Mano(par, par, 'p'));
                        par++;
                    }
                }
            }

        }

        return lista;

    }

    public String tablaToTexto(Rango rango) {
        String sol = "";
        ArrayList<Mano> parejas = rango.getParejas();
        ArrayList<Mano> offSuited = rango.getOffSuited();
        ArrayList<Mano> suited = rango.getSuited();
        //Ordeno las colecciones
        Collections.sort(parejas);
        Collections.sort(offSuited);
        Collections.sort(suited);
        int seguidos = 0;
        int baja = 0;
        for (int i = 0; i < parejas.size(); i++) {
            if (seguidos == 0) {//empiezas una posible secuencia de continuas
                baja = i;
                seguidos++;
            } else if (parejas.get(i).getCarta1() == parejas.get(i - 1).getCarta1() + 1) {//sigues la "escalera"
                seguidos++;
            } else { //rompes la "escalera" por lo tanto guardas y reseteas la cuenta
                if (seguidos > 1) {
                    sol += parejas.get(baja).toString() + '-' + parejas.get(i - 1).toString() + ',';
                } else {
                    sol += parejas.get(i - 1).toString() + ',';
                }
                i--;
                seguidos = 0;
            }
            if (parejas.get(i).getCarta1() == 14) {
                sol += parejas.get(baja).toString() + '+';//Estaria ya al final y es la unica posibilidad del +
            }
        }
        //reseteamos parametros
        baja = 0;
        seguidos = 0;
        int pilar;
        if (!offSuited.isEmpty()) {
            pilar = offSuited.get(0).getCarta1();
            sol += '\n';
            for (int i = 0; i < offSuited.size(); i++) {
                if (seguidos == 0) {
                    baja = i;
                    pilar = offSuited.get(i).getCarta1();
                    seguidos++;
                } else if (offSuited.get(i).getCarta1() == pilar) {//Carta mayor es igual
                    if (pilar == offSuited.get(i).getCarta2() + 1) {//Tope para el +
                        sol += offSuited.get(baja).toString() + "+, ";
                        seguidos = 0;
                    } else if (offSuited.get(i).getCarta2() == offSuited.get(i - 1).getCarta2() + 1) {//continua la escalera
                        seguidos++;
                    } else { //rompe la escalera
                        if (seguidos > 1) {
                            sol += offSuited.get(baja).toString() + '-' + offSuited.get(i - 1).toString() + ',';
                        } else {
                            sol += offSuited.get(i - 1).toString() + ',';
                        }
                        i--;
                        seguidos = 0;
                    }
                } else {//Carta mayor no igual
                    //Guardas lo anterior
                    if (seguidos > 1) {
                        sol += offSuited.get(baja).toString() + '-' + offSuited.get(i - 1).toString() + ',';
                    } else {
                        sol += offSuited.get(i - 1).toString() + ',';
                    }
                    seguidos = 0;
                    i--;
                }
            }
        }

        baja = 0;
        seguidos = 0;
        if (!suited.isEmpty()) {
            pilar = suited.get(0).getCarta1();
            sol += '\n';
            for (int i = 0; i < suited.size(); i++) {
                if (seguidos == 0) {
                    baja = i;
                    pilar = suited.get(i).getCarta1();
                    seguidos++;
                } else if (suited.get(i).getCarta1() == pilar) {//Carta mayor es igual
                    if (pilar == suited.get(i).getCarta2() + 1) {//Tope para el +
                        sol += suited.get(baja).toString() + "+, ";
                        seguidos = 0;
                    } else if (suited.get(i).getCarta2() == suited.get(i - 1).getCarta2() + 1) {//continua la escalera
                        seguidos++;
                    } else { //rompe la escalera
                        if (seguidos > 1) {
                            sol += suited.get(baja).toString() + '-' + suited.get(i - 1).toString() + ',';
                        } else {
                            sol += suited.get(i - 1).toString() + ',';
                        }
                        i--;
                        seguidos = 0;
                    }
                } else {//Carta mayor no igual
                    //Guardas lo anterior
                    if (seguidos > 1) {
                        sol += suited.get(baja).toString() + '-' + suited.get(i - 1).toString() + ',';
                    } else {
                        sol += suited.get(i - 1).toString() + ',';
                    }
                    seguidos = 0;
                    i--;
                }

            }
        }

        return sol;
    }

    private int charACarta(char carta) {
        switch (carta) {
            case 'A': {
                return 14;
            }
            case 'K': {
                return 13;
            }
            case 'Q': {
                return 12;
            }
            case 'J': {
                return 11;
            }
            case 'T': {
                return 10;
            }
            default: {
                return Character.getNumericValue(carta);
            }
        }
    }
}
