/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_uts;

import StrukturData.List.Linked.LinkedList;
//import static ai_uts.BidirectionalSearch.print;

/**
 *
 * @author Ferisa
 */
public class IterativeDeepeningSearch {
    private int[][][] init_node;
    private int[][] goal_node;
    private int deep;
    private int index_goal,index_deep, temp;
    private LinkedList list_node;
    
    public IterativeDeepeningSearch(int[][][] init_node, int[][] goal_node, int deep){
        this.init_node = init_node;
        this.goal_node = goal_node;
        this.deep = deep;
        this.list_node = new LinkedList();
    }
    
    private void IterativeDeepeningSearchHelper(int index_start){
        this.list_node.moveToPos(index_start-1);
        int length = this.list_node.length();
        for (int i = index_start-1; i < length; i++) {
            Object value = this.list_node.getValue();
            int[][] c = (int[][]) value;
            
            int[][][] temp = {c};
            Print(temp);
            System.out.println("-------------------");
            
            
            if(value== null) {
                for (int j = 0; j < 4; j++) {
                    this.list_node.append(null);
                }
            } else {
                for (int j = 0; j < c.length; j++) {
                    for (int k = 0; k < c[0].length; k++) {
                        if(c[j][k] == 0) {
                            for (int l = 0; l < 4; l++) {
                                try{
                                    int d[][] = {
                                        {c[0][0],c[0][1],c[0][2]},
                                        {c[1][0],c[1][1],c[1][2]},
                                        {c[2][0],c[2][1],c[2][2]}
                                    };

                                    //cek kiri
                                    if(l==0){
                                        d[j][k] = d[j][k-1];
                                        d[j][k-1] = 0;

                                        list_node.append(d);
                                    }

                                    //cek bawah
                                    if(l==1){
                                        d[j][k] = d[j+1][k];
                                        d[j+1][k] = 0;

                                        list_node.append(d);
                                    }

                                    //cek kanan
                                    if(l==2){
                                        d[j][k] = d[j][k+1];
                                        d[j][k+1] = 0;

                                        list_node.append(d); 
                                    }

                                    //cek atas
                                    if(l==3){
                                        d[j][k] = d[j-1][k];
                                        d[j-1][k] = 0;

                                        list_node.append(d);
                                    }
                                 }catch(ArrayIndexOutOfBoundsException e){
                                    this.list_node.append(null);
                                }
                            }
                            
                        }
                    }
                }
                
            }
            list_node.next();
            this.index_goal++;
        }
    }
    private void IterativeDeepeningSearch(){
        for (int level = 0; level <= deep; level++) {
            this.index_goal = 0;
            this.index_deep = 0;
            this.list_node.clear();
            
            this.list_node.append(init_node[0]);
            this.index_goal++;
            
            
            for (int i = 0; i < level; i++) {
//                System.out.println(index_goal);
                this.IterativeDeepeningSearchHelper(this.index_goal);
                
            }
            
            if (isFoundGoal()) {
                int temp_index = temp;
                int temp_index2 = level+1;
                int [][][] hasil1 = new int[temp_index2][3][3];

                while(temp_index > 0){
                    hasil1[--temp_index2] = (int[][])list_node.getValueOf(temp_index);
                    temp_index =  ((int)Math.floor((temp_index-1)/4));
                }
                hasil1[--temp_index2] = (int[][])list_node.getValueOf(temp_index);

                System.out.println("====== Hasil dari Initial ======");
                Print(hasil1);
                break;
            }
            System.out.println("===== Level "+level+" =====");
            this.list_node.show();
//            Print();
        }
        if (!isFoundGoal()) {
            System.out.println("===== Hasil =====");
            System.out.println("Tidak Ada Penyelesaian, perlu menambah kedalaman/deep");
        }
    }
    public void result(){
        IterativeDeepeningSearch();
    }
    private boolean isFoundGoal(){
        boolean result = false;
        temp = 0;
        list_node.moveToStart();
        int length = list_node.length();
        for (int i = 0; i < length; i++) {
            if (list_node.getValue() != null) {
                int[][] curr_node = (int[][])list_node.getValue();
                if(
                    curr_node[0][0] == goal_node[0][0] && curr_node[0][1] == goal_node[0][1] && curr_node[0][2] == goal_node[0][2] &&
                    curr_node[1][0] == goal_node[1][0] && curr_node[1][1] == goal_node[1][1] && curr_node[1][2] == goal_node[1][2] &&
                    curr_node[2][0] == goal_node[2][0] && curr_node[2][1] == goal_node[2][1] && curr_node[2][2] == goal_node[2][2]
                ) 
                {
                    result = true;
                    break;
                }
            }
            list_node.next();
            temp++;
        }
        return result;
    }
     
    public void Print(int[][][] a) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < a.length; j++) {
                for(int k = 0; k < 3; k++) {
                    try{
                        System.out.print(a[j][i][k] + " ");
                    }catch(NullPointerException e){
                        System.out.print(0 + " ");
                    }
                }
                System.out.print("\t");
            }
            System.out.println();
        }
    }
    
}
