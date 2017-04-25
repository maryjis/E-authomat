/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eauthomat;

import java.util.Random;

/**
 *
 * @author Maria
 */
public class Game {
    public static void main(String[] args) {
//        int matrixA[][]={{2,4},{1,3}};
//        int matrixB[][]={{2,1},{3,4}};

        int matrixA[][]={{4,1},{3,2}};
        int matrixB[][]={{5,3},{4,2}};
        EAutomat a = new EAutomat(matrixA, true);
        EAutomat b = new EAutomat(matrixB, false);
        Random r = new Random ();
        double e =0.05;
        int stepB=r.nextInt(2);
        int stapA=0;
        double countTrue =0;
        for (int i=0; i<=10000000;i++){
            stapA=a.chooseStrategy(stepB,e );
            stepB =b.chooseStrategy(stapA, e);
            if(stapA==0 && stepB==0){
                countTrue++;
            }
        }
        
        System.out.println("Best steps: ");
        System.out.println("A: " + a.getCurrentStrategy()  + " win: " +matrixA[a.getCurrentStrategy()][b.getCurrentStrategy()]);
        System.out.println("B: " + b.getCurrentStrategy() + " win: " +matrixB[a.getCurrentStrategy()][b.getCurrentStrategy()] );
        double per=countTrue/10000000;
        System.out.println("Percentage: " + per);
    }
}
