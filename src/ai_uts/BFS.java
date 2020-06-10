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
public class BFS {
    
    private static int index1,index2;
    private static LinkedList list1;   
     public static void BreadthFirstSearch3(int a[][][], int x[][]) {
        index1 = 0;
        index2 = 0;
        list1 = new LinkedList();
        
        list1.append(a[0]);
        list1.next();
        index1++;
        index2++;
        
        BreadthFirstSearchHelper3(a, x);
        
        int temp_index = index1-1;
        int temp_index2 = index2;
        int [][][] hasil1 = new int[temp_index2][3][3];
//        System.out.println(temp_index);

        while(temp_index > 0){
            hasil1[--temp_index2] = (int[][])list1.getValueOf(temp_index);
            temp_index =  ((int)Math.ceil((temp_index-1)/4));
//            System.out.println(temp_index);
        }
        hasil1[--temp_index2] = (int[][])list1.getValueOf(temp_index);

        System.out.println("====== HASIL ======");
        Print3(hasil1);
    }
    public static void BreadthFirstSearchHelper3(int a[][][], int x[][]) {
        boolean cari_lagi = true;
        index2++;
        
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
                    list1.append(null);
                    list1.next();
                    index1++;
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
                                        list1.append(b[4*i+l]);
                                        list1.next();
                                        index1++;
                                        if(
                                            d[0][0] == x[0][0] && d[0][1] == x[0][1] && d[0][2] == x[0][2] &&
                                            d[1][0] == x[1][0] && d[1][1] == x[1][1] && d[1][2] == x[1][2] &&
                                            d[2][0] == x[2][0] && d[2][1] == x[2][1] && d[2][2] == x[2][2]
                                        ) 
                                        {
                                            cari_lagi = false;
                                            break loop_paling_luar;
                                        }   
                                    }

                                    //cek bawah
                                    if(l==1){
                                        d[j][k] = d[j+1][k];
                                        d[j+1][k] = 0;

                                        b[4*i+l] = d;
                                        list1.append(b[4*i+l]);
                                        list1.next();
                                        index1++;
                                        if(
                                            d[0][0] == x[0][0] && d[0][1] == x[0][1] && d[0][2] == x[0][2] &&
                                            d[1][0] == x[1][0] && d[1][1] == x[1][1] && d[1][2] == x[1][2] &&
                                            d[2][0] == x[2][0] && d[2][1] == x[2][1] && d[2][2] == x[2][2]
                                        ) 
                                        {
                                            cari_lagi = false;
                                            break loop_paling_luar;
                                        }   
                                    }
                                    
                                    //cek kanan
                                    if(l==2){
                                        d[j][k] = d[j][k+1];
                                        d[j][k+1] = 0;

                                        b[4*i+l] = d;
                                        list1.append(b[4*i+l]);
                                        list1.next();
                                        index1++;

                                        if(
                                            d[0][0] == x[0][0] && d[0][1] == x[0][1] && d[0][2] == x[0][2] &&
                                            d[1][0] == x[1][0] && d[1][1] == x[1][1] && d[1][2] == x[1][2] &&
                                            d[2][0] == x[2][0] && d[2][1] == x[2][1] && d[2][2] == x[2][2]
                                        ) 
                                        {
                                            cari_lagi = false;
                                            break loop_paling_luar;
                                        }   
                                    }
                                    
                                    //cek atas
                                    if(l==3){
                                        d[j][k] = d[j-1][k];
                                        d[j-1][k] = 0;

                                        b[4*i+l] = d;
                                        list1.append(b[4*i+l]);
                                        list1.next();
                                        index1++;
                                        if(
                                            d[0][0] == x[0][0] && d[0][1] == x[0][1] && d[0][2] == x[0][2] &&
                                            d[1][0] == x[1][0] && d[1][1] == x[1][1] && d[1][2] == x[1][2] &&
                                            d[2][0] == x[2][0] && d[2][1] == x[2][1] && d[2][2] == x[2][2]
                                        ) 
                                        {
                                            cari_lagi = false;
                                            break loop_paling_luar;
                                        }  
                                    }
                                }catch(ArrayIndexOutOfBoundsException e){
                                    int d[][] = new int[3][3];
                                    b[4*i+l] = d;
                                    list1.append(null);
                                    list1.next();
                                    index1++;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("------------------");
        Print3(b);

        
        // jika belum ditemukan, maka perlu dilakukan proses berikutnya
        if(cari_lagi == true) {
            BreadthFirstSearchHelper3(b, x);
        }
    }
    public static void Print3(int a[][][]) {
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
