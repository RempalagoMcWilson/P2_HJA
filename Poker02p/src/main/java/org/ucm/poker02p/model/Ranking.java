/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ucm.poker02p.model;

import java.util.ArrayList;
import java.util.List;
/*
RANKING Sklansky-Chubukov sacado de:
https://www.pokermatematicas.com/rankings/sklansky_chubukov.txt
*/

public class Ranking {
    ArrayList<Mano> rankList;
    public Ranking() {
        rankList = new ArrayList();
        generaRankList();
    }
    public List<Mano> getRankListActual(double porcentaje){
        Double pos = (porcentaje/100) * 169;
        
        if(pos < rankList.size())
            return rankList.subList(0, pos.intValue());
        else
            return rankList.subList(0, rankList.size());
    }
    
    
    private void generaRankList(){//en los o se pone el pequeño en la izq
        rankList.add(new Mano(14, 14, 'p'));//AA
        rankList.add(new Mano(13, 13, 'p'));//KK
        rankList.add(new Mano(14, 13, 's'));//AKs
        rankList.add(new Mano(12, 12, 'p'));//QQ
        rankList.add(new Mano(13, 14, 'o'));//AKo
        rankList.add(new Mano(11, 11, 'p'));//JJ
        rankList.add(new Mano(14, 12, 's'));//AQs
        rankList.add(new Mano(10, 10, 'p'));//TT
        rankList.add(new Mano(12, 14, 'o'));//AQo
        rankList.add(new Mano(9, 9, 'p'));//99
        rankList.add(new Mano(14, 11, 's'));//AJs
        rankList.add(new Mano(8, 8, 'p'));//88
        rankList.add(new Mano(14, 10, 's'));//ATs
        rankList.add(new Mano(11, 14, 'o'));//AJo
        rankList.add(new Mano(7, 7, 'p'));//77
        rankList.add(new Mano(6, 6, 'p'));//66
        rankList.add(new Mano(10, 14, 'o'));//ATo
        rankList.add(new Mano(14, 9, 's'));//A9s
        rankList.add(new Mano(5, 5, 'p'));//55
        rankList.add(new Mano(14, 8, 's'));//A8s
        rankList.add(new Mano(13, 12, 's'));//KQs
        rankList.add(new Mano(4, 4, 'p'));//44
        rankList.add(new Mano(9, 14, 'o'));//A9o
        rankList.add(new Mano(14, 7, 's'));//A7s
        
        
    }
/*
KJs
A5s
A8
A6s
A4s
33
KTs
A7
A3s
KQ
A2s
A5
A6
A4
KJ
QJs
A3
22
K9s
A2
KT
QTs
K8s
K7s
JTs
K9
K6s
QJ
Q9s
K5s
K8
K4s
QT
K7
K3s
K2s
Q8s
K6
J9s
K5
Q9
JT
K4
Q7s
T9s
Q6s
K3
J8s
Q5s
K2
Q8
Q4s
J9
Q3s
T8s
J7s
Q7
Q2s
Q6
98s
Q5
J8
T9
J6s
T7s
J5s
Q4
J4s
J7
Q3
97s
T8
J3s
T6s
Q2
J2s
87s
J6
98
T7
96s
J5
T5s
T4s
86s
J4
T6
97
T3s
76s
95s
J3
T2s
87
85s
96
T5
J2
75s
94s
T4
65s
86
93s
84s
95
T3
76
92s
74s
54s
T2
85
64s
83s
94
75
82s
73s
93
65
53s
63s
84
92
43s
74
72s
54
64
52s
62s
83
42s
82
73
53
63
32s
43
72
52
62
42
32
    */
}
