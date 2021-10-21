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
        rankList.add(new Mano(14, 7, 's'));//KJs
        rankList.add(new Mano(14, 7, 's'));//A5s
        rankList.add(new Mano(14, 7, 's'));//A8
        rankList.add(new Mano(14, 7, 's'));//A6s
        rankList.add(new Mano(14, 7, 's'));//A4s
        rankList.add(new Mano(14, 7, 's'));//33
        rankList.add(new Mano(14, 7, 's'));//KTs
        rankList.add(new Mano(14, 7, 's'));//A7
        rankList.add(new Mano(14, 7, 's'));//A3s
        rankList.add(new Mano(14, 7, 's'));//KQ
        rankList.add(new Mano(14, 7, 's'));//A2s
        rankList.add(new Mano(14, 7, 's'));//A5
        rankList.add(new Mano(14, 7, 's'));//A6
        rankList.add(new Mano(14, 7, 's'));//A4
        rankList.add(new Mano(14, 7, 's'));//KJ
        rankList.add(new Mano(14, 7, 's'));//QJs
        rankList.add(new Mano(14, 7, 's'));//A3
        rankList.add(new Mano(14, 7, 's'));//22

        rankList.add(new Mano(14, 7, 's'));//K9s
        rankList.add(new Mano(14, 7, 's'));//A2
        rankList.add(new Mano(14, 7, 's'));//KT
        rankList.add(new Mano(14, 7, 's'));//QTs
        rankList.add(new Mano(14, 7, 's'));//K8s
        rankList.add(new Mano(14, 7, 's'));//K7s
        rankList.add(new Mano(14, 7, 's'));//JTs
        rankList.add(new Mano(14, 7, 's'));//K9
        rankList.add(new Mano(14, 7, 's'));//K6s
        rankList.add(new Mano(14, 7, 's'));//QJ
        rankList.add(new Mano(14, 7, 's'));//Q9s
        rankList.add(new Mano(14, 7, 's'));//K5s
        
        rankList.add(new Mano(14, 7, 's'));//K8
        rankList.add(new Mano(14, 7, 's'));//K4s
        rankList.add(new Mano(14, 7, 's'));//QT
        rankList.add(new Mano(14, 7, 's'));//K7
        rankList.add(new Mano(14, 7, 's'));//K3s
        rankList.add(new Mano(14, 7, 's'));//K2s
        rankList.add(new Mano(14, 7, 's'));//Q8s
        
        rankList.add(new Mano(14, 7, 's'));//K6
        rankList.add(new Mano(14, 7, 's'));//J9s
        rankList.add(new Mano(14, 7, 's'));//K5
        rankList.add(new Mano(14, 7, 's'));//Q9
        rankList.add(new Mano(14, 7, 's'));//JT
        rankList.add(new Mano(14, 7, 's'));//K4
        rankList.add(new Mano(14, 7, 's'));//Q7s
        rankList.add(new Mano(14, 7, 's'));//T9s
        rankList.add(new Mano(14, 7, 's'));//Q6s
        rankList.add(new Mano(14, 7, 's'));//K3
        rankList.add(new Mano(14, 7, 's'));//J8s
        rankList.add(new Mano(14, 7, 's'));//Q5s
        rankList.add(new Mano(14, 7, 's'));//K2
        rankList.add(new Mano(14, 7, 's'));//Q8
        
        rankList.add(new Mano(14, 7, 's'));//Q4s
        rankList.add(new Mano(14, 7, 's'));//J9
        rankList.add(new Mano(14, 7, 's'));//Q3s
        rankList.add(new Mano(14, 7, 's'));//T8s
        rankList.add(new Mano(14, 7, 's'));//J7s
        rankList.add(new Mano(14, 7, 's'));//Q7
        rankList.add(new Mano(14, 7, 's'));//Q2s
        rankList.add(new Mano(14, 7, 's'));//Q6
        rankList.add(new Mano(14, 7, 's'));//98s
        rankList.add(new Mano(14, 7, 's'));//Q5
        rankList.add(new Mano(14, 7, 's'));//J8
        rankList.add(new Mano(14, 7, 's'));//T9
        rankList.add(new Mano(14, 7, 's'));//J6s
        rankList.add(new Mano(14, 7, 's'));//T7s
        rankList.add(new Mano(14, 7, 's'));//J5s
        rankList.add(new Mano(14, 7, 's'));//Q4
        rankList.add(new Mano(14, 7, 's'));//J4s
        rankList.add(new Mano(14, 7, 's'));//J7
        
        rankList.add(new Mano(14, 7, 's'));//Q3
        rankList.add(new Mano(14, 7, 's'));//97s
        rankList.add(new Mano(14, 7, 's'));//T8
        rankList.add(new Mano(14, 7, 's'));//J3s
        rankList.add(new Mano(14, 7, 's'));//T6s
        rankList.add(new Mano(14, 7, 's'));//Q2
        rankList.add(new Mano(14, 7, 's'));//J2s
        rankList.add(new Mano(14, 7, 's'));//87s
        rankList.add(new Mano(14, 7, 's'));//J6
        rankList.add(new Mano(14, 7, 's'));//98
        rankList.add(new Mano(14, 7, 's'));//T7
        rankList.add(new Mano(14, 7, 's'));//96s
        rankList.add(new Mano(14, 7, 's'));//J5
        rankList.add(new Mano(14, 7, 's'));//T5s
        rankList.add(new Mano(14, 7, 's'));//T4s
        rankList.add(new Mano(14, 7, 's'));//86s
        rankList.add(new Mano(14, 7, 's'));//J4
        rankList.add(new Mano(14, 7, 's'));//T6
        rankList.add(new Mano(14, 7, 's'));//97
        
        rankList.add(new Mano(14, 7, 's'));//97
        rankList.add(new Mano(14, 7, 's'));//97
        rankList.add(new Mano(14, 7, 's'));//97
        rankList.add(new Mano(14, 7, 's'));//T3s
        rankList.add(new Mano(14, 7, 's'));//76s
        rankList.add(new Mano(14, 7, 's'));//95s
        rankList.add(new Mano(14, 7, 's'));//J3
        rankList.add(new Mano(14, 7, 's'));//T2s
        rankList.add(new Mano(14, 7, 's'));//87
        rankList.add(new Mano(14, 7, 's'));//85s
        rankList.add(new Mano(14, 7, 's'));//96
        rankList.add(new Mano(14, 7, 's'));//T5
        rankList.add(new Mano(14, 7, 's'));//J2
        rankList.add(new Mano(14, 7, 's'));//75s
        rankList.add(new Mano(14, 7, 's'));//94s
        rankList.add(new Mano(14, 7, 's'));//T4
        rankList.add(new Mano(14, 7, 's'));//65s
        rankList.add(new Mano(14, 7, 's'));//86
        rankList.add(new Mano(14, 7, 's'));//93s
        
        rankList.add(new Mano(14, 7, 's'));//84s
        rankList.add(new Mano(14, 7, 's'));//95
        rankList.add(new Mano(14, 7, 's'));//T3
        rankList.add(new Mano(14, 7, 's'));//76
        rankList.add(new Mano(14, 7, 's'));//92s
        rankList.add(new Mano(14, 7, 's'));//74s
        rankList.add(new Mano(14, 7, 's'));//54s
        rankList.add(new Mano(14, 7, 's'));//T2
        rankList.add(new Mano(14, 7, 's'));//85
        rankList.add(new Mano(14, 7, 's'));//64s
        rankList.add(new Mano(14, 7, 's'));//83s
        rankList.add(new Mano(14, 7, 's'));//94
        rankList.add(new Mano(14, 7, 's'));//75
        rankList.add(new Mano(14, 7, 's'));//82s
        rankList.add(new Mano(14, 7, 's'));//73s
        rankList.add(new Mano(14, 7, 's'));//93
        rankList.add(new Mano(14, 7, 's'));//65
        rankList.add(new Mano(14, 7, 's'));//53s
        rankList.add(new Mano(14, 7, 's'));//63s
        rankList.add(new Mano(14, 7, 's'));//84
        rankList.add(new Mano(14, 7, 's'));//92
        rankList.add(new Mano(14, 7, 's'));//43s
        rankList.add(new Mano(14, 7, 's'));//74
        rankList.add(new Mano(14, 7, 's'));//72s
        
        rankList.add(new Mano(14, 7, 's'));//54
        rankList.add(new Mano(14, 7, 's'));//64
        rankList.add(new Mano(14, 7, 's'));//52s
        rankList.add(new Mano(14, 7, 's'));//62s
        rankList.add(new Mano(14, 7, 's'));//83
        rankList.add(new Mano(14, 7, 's'));//42s
        rankList.add(new Mano(14, 7, 's'));//82
        rankList.add(new Mano(14, 7, 's'));//73
        rankList.add(new Mano(14, 7, 's'));//53
        rankList.add(new Mano(14, 7, 's'));//63
        rankList.add(new Mano(14, 7, 's'));//32s
        rankList.add(new Mano(14, 7, 's'));//43
        rankList.add(new Mano(14, 7, 's'));//72
        rankList.add(new Mano(14, 7, 's'));//52
        rankList.add(new Mano(14, 7, 's'));//62
        rankList.add(new Mano(14, 7, 's'));//42
        rankList.add(new Mano(14, 7, 's'));//32
    }

}
