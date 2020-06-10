/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_uts;

/**
 *
 * @author Ferisa
 */
import StrukturData.List.Linked.LinkedList;
import static ai_uts.BFS.Print3;
public class BidirectionalSearch {
    private int[][][] init_node, goal_node, temp_init_curr_level, temp_goal_curr_level;
    private int[][][] middle_node  = new int[1][3][3];
    private int index_middle_node_from_init, index_level_init;
    private int index_middle_node_from_goal,index_level_goal;

    private LinkedList list_node_init,list_node_goal;  
    public BidirectionalSearch(int[][][] initial_node,int[][][] goal_node){
        this.init_node = initial_node;
        this.goal_node = goal_node;
        this.temp_init_curr_level = initial_node;
        this.temp_goal_curr_level = goal_node;
    }
    
    private void expandInitialNodeHelper(int a[][][]) {
        index_level_init++;
        
        // untuk setiap x di a, dicari elemen-elemen di bawahnya
        int b[][][] = new int[4*a.length][3][3];
        for(int i = 0; i < a.length; i++) {
            int c[][] = a[i];
            if(
                c[0][0] == 0 && c[0][1] == 0 && c[0][2] == 0 &&
                c[1][0] == 0 && c[1][1] == 0 && c[1][2] == 0 &&
                c[2][0] == 0 && c[2][1] == 0 && c[2][2] == 0
            )
            {
                for (int l = 0; l < 4; l++) {
                    b[4*i+l] = new int[3][3];
                    list_node_init.append(null);
                    list_node_init.next();
                    index_middle_node_from_init++;
                }
            } else {
                for (int j = 0; j < c.length; j++) {
                    for (int k = 0; k < c[0].length; k++) {
                        if(c[j][k] == 0){
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

                                        b[4*i+l] = d;
                                        list_node_init.append(b[4*i+l]);
                                        list_node_init.next();
                                        index_middle_node_from_init++;
                                    }

                                    //cek bawah
                                    if(l==1){
                                        d[j][k] = d[j+1][k];
                                        d[j+1][k] = 0;

                                        b[4*i+l] = d;
                                        list_node_init.append(b[4*i+l]);
                                        list_node_init.next();
                                        index_middle_node_from_init++;
                                    }
                                    
                                    //cek kanan
                                    if(l==2){
                                        d[j][k] = d[j][k+1];
                                        d[j][k+1] = 0;

                                        b[4*i+l] = d;
                                        list_node_init.append(b[4*i+l]);
                                        list_node_init.next();
                                        index_middle_node_from_init++;
                                    }
                                    
                                    //cek atas
                                    if(l==3){
                                        d[j][k] = d[j-1][k];
                                        d[j-1][k] = 0;

                                        b[4*i+l] = d;
                                        list_node_init.append(b[4*i+l]);
                                        list_node_init.next();
                                        index_middle_node_from_init++;
                                    }
                                }catch(ArrayIndexOutOfBoundsException e){
                                    int d[][] = new int[3][3];
                                    b[4*i+l] = d;
                                    list_node_init.append(null);
                                    list_node_init.next();
                                    index_middle_node_from_init++;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("===== Expand Node from Init =====");

        print(b);

        this.temp_init_curr_level = b;
    }
    private void expandGoalNodeHelper(int a[][][]) {
        index_level_goal++;
        
        // untuk setiap x di a, dicari elemen-elemen di bawahnya
        int b[][][] = new int[4*a.length][3][3];
        loop_paling_luar:
        for(int i = 0; i < a.length; i++) {
            int c[][] = a[i];
            if(
                c[0][0] == 0 && c[0][1] == 0 && c[0][2] == 0 &&
                c[1][0] == 0 && c[1][1] == 0 && c[1][2] == 0 &&
                c[2][0] == 0 && c[2][1] == 0 && c[2][2] == 0
            )
            {
                for (int l = 0; l < 4; l++) {
                    b[4*i+l] = new int[3][3];
                    list_node_goal.append(null);
                    list_node_goal.next();
                    index_middle_node_from_goal++;
                }
            } else {
                for (int j = 0; j < c.length; j++) {
                    for (int k = 0; k < c[0].length; k++) {
                        if(c[j][k] == 0){
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

                                        b[4*i+l] = d;
                                        list_node_goal.append(b[4*i+l]);
                                        list_node_goal.next();
                                        index_middle_node_from_goal++;
                                    }

                                    //cek bawah
                                    if(l==1){
                                        d[j][k] = d[j+1][k];
                                        d[j+1][k] = 0;

                                        b[4*i+l] = d;
                                        list_node_goal.append(b[4*i+l]);
                                        list_node_goal.next();
                                        index_middle_node_from_goal++;
                                    }
                                    
                                    //cek kanan
                                    if(l==2){
                                        d[j][k] = d[j][k+1];
                                        d[j][k+1] = 0;

                                        b[4*i+l] = d;
                                        list_node_goal.append(b[4*i+l]);
                                        list_node_goal.next();
                                        index_middle_node_from_goal++; 
                                    }
                                    
                                    //cek atas
                                    if(l==3){
                                        d[j][k] = d[j-1][k];
                                        d[j-1][k] = 0;

                                        b[4*i+l] = d;
                                        list_node_goal.append(b[4*i+l]);
                                        list_node_goal.next();
                                        index_middle_node_from_goal++;
                                    }
                                }catch(ArrayIndexOutOfBoundsException e){
                                    int d[][] = new int[3][3];
                                    b[4*i+l] = d;
                                    list_node_goal.append(null);
                                    list_node_goal.next();
                                    index_middle_node_from_goal++;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("===== Expand Node from Goal =====");
        Print3(b);
        this.temp_goal_curr_level = b;
    }
    
    private void expandNode() {
        index_middle_node_from_init = 0;
        index_level_init = 0;
        list_node_init = new LinkedList();
        list_node_init.append(this.init_node[0]);
        list_node_init.next();
        index_middle_node_from_init++;
        index_level_init++;
        
        
        index_middle_node_from_goal = 0;
        index_level_goal = 0;
        list_node_goal = new LinkedList();
        list_node_goal.append(this.goal_node[0]);
        list_node_goal.next();
        index_middle_node_from_goal++;
        index_level_goal++;
        
        //Setiap Perluasan Initial_Node dan Goal_Node selalu dicek apakah sudah menemukan Middle_Node
        int i = 0;
        while(!this.isFoundMiddleNode()){
            if (i%2 == 0) {
                expandInitialNodeHelper(this.temp_init_curr_level);
            } else {
                expandGoalNodeHelper(this.temp_goal_curr_level);
            }
            i++;
        }
        
        
        int temp_index = index_middle_node_from_init-1;
        int temp_index2 = index_level_init;
        int [][][] hasil1 = new int[temp_index2][3][3];
//        System.out.println(temp_index);

        while(temp_index > 0){
            hasil1[--temp_index2] = (int[][])list_node_init.getValueOf(temp_index);
            temp_index =  ((int)Math.floor((temp_index-1)/4));
//            System.out.println(temp_index);
        }
        hasil1[--temp_index2] = (int[][])list_node_init.getValueOf(temp_index);
        
        
        
        
        System.out.println("====== Hasil dari Initial ======");
        print(hasil1);
//        
//        
//        ============================================================================

        
        temp_index = index_middle_node_from_goal-1;
        temp_index2 = index_level_goal;
        int [][][] hasil2 = new int[temp_index2][3][3];
//        System.out.println(temp_index);

        while(temp_index > 0){
            hasil2[--temp_index2] = (int[][])list_node_goal.getValueOf(temp_index);
            temp_index =  ((int)Math.floor((temp_index-1)/4));
//            System.out.println(temp_index);
        }
        hasil2[--temp_index2] = (int[][])list_node_goal.getValueOf(temp_index);

        System.out.println("====== Hasil dari Goal ======");
        Print3(hasil2);
        
        int total_step = index_level_init+index_level_goal-1;
        int[][][] result = new int [total_step][3][3];
        int idx = 0;
        for (int j = 0; j < index_level_init; j++) {
            result[idx++] = hasil1[j];
        }
        for (int j = index_level_goal-1; j > 0; j--) {
            result[idx++] = hasil2[j-1];
        }
        System.out.println("===== Hasil Langkah Penyelesaian =====");
        print(result);
        
        
        
    }
    
    
    private boolean isFoundMiddleNode(){
        boolean result = false;
        int rev1 = temp_init_curr_level.length;
        for (int i = 0; i < temp_init_curr_level.length; i++) {
            rev1--;
            int rev2 = temp_goal_curr_level.length;
            for (int j = 0; j < temp_goal_curr_level.length; j++) {
                rev2--;
                if(
                   (temp_init_curr_level[i][0][0] == 0 && temp_init_curr_level[i][0][1] == 0 && temp_init_curr_level[i][0][2] == 0 &&
                    temp_init_curr_level[i][1][0] == 0 && temp_init_curr_level[i][1][1] == 0 && temp_init_curr_level[i][1][2] == 0 &&
                    temp_init_curr_level[i][2][0] == 0 && temp_init_curr_level[i][2][1] == 0 && temp_init_curr_level[i][2][2] == 0 )
                        
                        &&
                        
                   (temp_goal_curr_level[j][0][0] == 0 && temp_goal_curr_level[j][0][1] == 0 && temp_goal_curr_level[j][0][2] == 0 &&
                    temp_goal_curr_level[j][1][0] == 0 && temp_goal_curr_level[j][1][1] == 0 && temp_goal_curr_level[j][1][2] == 0 &&
                    temp_goal_curr_level[j][2][0] == 0 && temp_goal_curr_level[j][2][1] == 0 && temp_goal_curr_level[j][2][2] == 0 )
                ){
                    continue;
                }else  if (temp_init_curr_level[i][0][0] == temp_goal_curr_level[j][0][0] && temp_init_curr_level[i][0][1] == temp_goal_curr_level[j][0][1] && temp_init_curr_level[i][0][2] == temp_goal_curr_level[j][0][2] &&
                           temp_init_curr_level[i][1][0] == temp_goal_curr_level[j][1][0] && temp_init_curr_level[i][1][1] == temp_goal_curr_level[j][1][1] && temp_init_curr_level[i][1][2] == temp_goal_curr_level[j][1][2] &&
                           temp_init_curr_level[i][2][0] == temp_goal_curr_level[j][2][0] && temp_init_curr_level[i][2][1] == temp_goal_curr_level[j][2][1] && temp_init_curr_level[i][2][2] == temp_goal_curr_level[j][2][2]) 
                {
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            this.middle_node[0][k][l] = temp_init_curr_level[i][k][l];
                        }
                    }
                    System.out.println("\n\tPENCARIAN SELESAI\n");
                    System.out.println("===== Middle Node =====");
                    print(middle_node);
                    index_middle_node_from_init = index_middle_node_from_init-rev1;
                    index_middle_node_from_goal = index_middle_node_from_goal-rev2;
                    result = true;
                    break;
                    
                }
            }
        }
        
        return result;
    }
    public void result(){
        this.expandNode();
    }
    public static void print(int a[][][]) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < a.length; j++) {
                for(int k = 0; k < 3; k++) {
                    System.out.print(a[j][i][k] + " ");
                }
                System.out.print("\t");
            }
            System.out.println();
        }
    }
    
}
