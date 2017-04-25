/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eauthomat;

import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 *
 * @author Maria
 */
public class EAutomat {
    
    private int[][] matrix = new int[2][2];
    private Queue<Memory> memory= new LinkedList<Memory>();
    private int currentStrategy =0;
    private boolean isFirst =true;

    EAutomat(int[][] matrix, boolean isFirst){
        this.matrix=matrix;
        this.isFirst=isFirst;
    }
    
    public boolean isIsFirst() {
        return isFirst;
    }

    public void setIsFirst(boolean isFirst) {
        this.isFirst = isFirst;
    }
   
    
    
    
    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public Queue<Memory> getMemory() {
        return memory;
    }

    public void setMemory(Queue<Memory> memory) {
        this.memory = memory;
    }



    public int getCurrentStrategy() {
        return currentStrategy;
    }

    public void setCurrentStrategy(int currentStrategy) {
        this.currentStrategy = currentStrategy;
    }
            
    public int chooseStrategy(int stategyBAutomat, double e){
        int choosenStretegy =0;
        if(!memory.isEmpty() && memory.size()==2){
            Memory slot1=memory.poll();
            Memory slot2=memory.peek();
            if(slot1.getWin()>=slot2.getWin()){
                choosenStretegy=chooseStrategyWithProbability(slot1.getStrategy(),e);
            }else{
                choosenStretegy=chooseStrategyWithProbability(slot2.getStrategy(),e);
            }
            
        }else{
            Random r = new Random ();
            choosenStretegy=r.nextInt(2);
        }
        
        int win =isFirst? matrix[choosenStretegy][stategyBAutomat]: matrix[stategyBAutomat][choosenStretegy];
        Memory slot3= new Memory(choosenStretegy, win);
        memory.add(slot3);
        currentStrategy=choosenStretegy;
        return choosenStretegy;
    }        
            
     
    private  int chooseStrategyWithProbability(int bestStrategy,double e){
        int choosenStrategy=0;
        Random r = new Random ();
        double k =r.nextDouble();
        if(k<=1-e){
            choosenStrategy=bestStrategy;
        }else{
            choosenStrategy=otherStrategy(bestStrategy);
        }
       
        return choosenStrategy;
    }
    
    private int otherStrategy( int strategy){
        if(strategy==0){
            return 1;
        }else{
            return 0;
        }
    }
    private class Memory{
        private int strategy;
        private int win;

        public Memory(int strategy, int win) {
            this.strategy = strategy;
            this.win = win;
        }

        
        
        public int getStrategy() {
            return strategy;
        }

        public void setStrategy(int strategy) {
            this.strategy = strategy;
        }

        public int getWin() {
            return win;
        }

        public void setWin(int win) {
            this.win = win;
        }
        
        
    }
}
