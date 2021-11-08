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

    public ArrayList<Mano> traduceMano(String entrada) {
        entrada = entrada.replace(" ", "");
        ArrayList<Mano> lista = new ArrayList();
        int i = 0;
        while (i < entrada.length()) {
            if (i + 2 < entrada.length()) {
                if (entrada.charAt(i + 2) == ',') {//es una pareja suelta
                    lista.add(new Mano(charACarta(entrada.charAt(i)), charACarta(entrada.charAt(i + 1)), 'p'));
                    i += 4;
                } else if ((entrada.charAt(i + 2) == 'o') || (entrada.charAt(i + 2) == 's')) {//es un par "s" o "o"
                    if (i + 3 >= entrada.length()) {
                        if (entrada.charAt(i + 2) == 'o') {
                            lista.add(new Mano(charACarta(entrada.charAt(i)), charACarta(entrada.charAt(i + 1)), entrada.charAt(i + 2)));
                        } else {
                            lista.add(new Mano(charACarta(entrada.charAt(i + 1)), charACarta(entrada.charAt(i)), entrada.charAt(i + 2)));
                        }
                        i += 4;
                    } else if (entrada.charAt(i + 3) == '-') {//Nos encontramos un rango
                        for (int j = 0; j <= charACarta(entrada.charAt(i + 1)) - charACarta(entrada.charAt(i + 5)); j++) {
                            if (entrada.charAt(i + 2) == 'o') {
                                lista.add(new Mano(charACarta(entrada.charAt(i)), charACarta(entrada.charAt(i + 5)) + j, entrada.charAt(i + 2)));
                            } else {
                                lista.add(new Mano(charACarta(entrada.charAt(i + 5)) + j, charACarta(entrada.charAt(i)), entrada.charAt(i + 2)));
                            }
                        }
                        i += 8;

                    } else if (entrada.charAt(i + 3) == ',') {//un par de cartas suelto suited o offsuited
                        if (entrada.charAt(i + 2) == 'o') {//                                                      + j
                            lista.add(new Mano(charACarta(entrada.charAt(i)), charACarta(entrada.charAt(i + 1)), entrada.charAt(i + 2)));
                        } else {
                            lista.add(new Mano(charACarta(entrada.charAt(i + 1)), charACarta(entrada.charAt(i)), entrada.charAt(i + 2)));
                        }
                        i += 4;
                    } else if ((entrada.charAt(i + 3) == '+')) {//añade con el + de offsuited y suited
                        for (int j = 0; j + charACarta(entrada.charAt(i + 1)) < charACarta(entrada.charAt(i)); j++) {
                            if (entrada.charAt(i + 2) == 'o') {
                                lista.add(new Mano(charACarta(entrada.charAt(i)), charACarta(entrada.charAt(i + 1)) + j, entrada.charAt(i + 2)));
                            } else {
                                lista.add(new Mano(charACarta(entrada.charAt(i + 1)) + j, charACarta(entrada.charAt(i)), entrada.charAt(i + 2)));
                            }
                        }
                        i += 5;
                    }
                } else if (entrada.charAt(i + 2) == '+') {
                    int par = charACarta(entrada.charAt(i)) + 1;
                    lista.add(new Mano(charACarta(entrada.charAt(i)), charACarta(entrada.charAt(i + 1)), 'p'));
                    while (par < 15) {
                        lista.add(new Mano(par, par, 'p'));
                        par++;
                    }
                    i += 4;
                } else if (entrada.charAt(i + 2) == '-') {
                    for (int j = 0; charACarta(entrada.charAt(i + 3)) + j <= charACarta(entrada.charAt(i)); j++) {
                        lista.add(new Mano(charACarta(entrada.charAt(i + 3)) + j, charACarta(entrada.charAt(i + 3)) + j, 'p'));
                    }
                    i += 6;
                }

            } else {//AA
                lista.add(new Mano(charACarta(entrada.charAt(i)), charACarta(entrada.charAt(i + 1)), 'p'));
                i += 3;
            }

        }
        return lista;
    }

    public String tablaToTexto(Rango rango) {
        String sol = "", antS = "";
        int cont = 0, ant = 0;
        ArrayList<Mano> parejas = rango.getParejas();
        ArrayList<Mano> offSuited = rango.getOffSuited();
        ArrayList<Mano> suited = rango.getSuited();
        //Ordeno las colecciones
        Collections.sort(parejas);
        Collections.sort(offSuited);
        Collections.sort(suited);

        
        cont++;
        
        if (parejas.size() > 1) {
            antS = parejas.get(0).toString();
            for (int i = 1; i < parejas.size(); i++) {
                if (parejas.get(i).getCarta1() - parejas.get(i - 1).getCarta1() == 1) {
                    cont++;
                    if (i == parejas.size() - 1) {
                        if (parejas.get(i).getCarta1() == 14) {
                            sol += "," + antS + "+";
                        } else {
                            sol += ", " + antS + "-" + parejas.get(i).toString();
                        }
                    }
                } else {
                    if (cont > 1) {
                        sol += ", " + antS + "-" + parejas.get(i - 1).toString();
                        if (i == parejas.size() - 1) {
                            sol += ", " +  parejas.get(i).toString();
                        }
                        ant = parejas.get(i).getCarta1();
                        antS = parejas.get(i).toString();
                        cont = 1;
                    } else {
                        ant = parejas.get(i).getCarta1();
                        antS = parejas.get(i).toString();
                        sol += "," + parejas.get(i - 1).toString();
                        
                        if (i == parejas.size() - 1)
                            sol += "," +antS;
                        cont = 1;
                    }
                }
            }
        } else {
            antS = parejas.get(0).toString();
            sol += antS;
        }

        for (int i = 0; i < offSuited.size(); i++) {
            sol += offSuited.get(i).toString() + ',';
        }
        for (int i = 0; i < suited.size(); i++) {
            sol += suited.get(i).toString() + ',';
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
