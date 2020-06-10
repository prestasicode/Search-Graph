/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_uts;

/**
 *
 * @author ferisa
 */
public class AI_UTS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.currentTimeMillis();
        int[][][] goal_node = {{{1,2,3},
                                {4,5,6},
                                {7,8,0}}};
        
        int[][][] init_node  = {{{1,2,3},
                                 {5,0,6},
                                 {4,7,8}}};
//        BidirectionalSearch test = new BidirectionalSearch(init_node, goal_node);
//        test.result();
        int[][] goal = goal_node[0];
        IterativeDeepeningSearch test1 = new IterativeDeepeningSearch(init_node, goal, 4);
        test1.result();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long actualMemUsed=afterUsedMem-beforeUsedMem;
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("===== Time =====");
        System.out.println(elapsedTime+" ms");
        System.out.println("===== Memory =====");
        System.out.println(actualMemUsed+" byte");
    }
    
}
