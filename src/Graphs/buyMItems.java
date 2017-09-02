package Graphs;

/**
 * Created by anand on 02/09/17.
 */
//public class buyMItems {
//}
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

  class Solution {



    static long minimumTime(int[] b, int m, int k){
        ArrayList<Integer> setIndices=new ArrayList<>();
        long minTime;
        long constant=0;
        long value=0;
        for (int i=0;i<b.length;i++){
            if (b[i]==1){
                setIndices.add(i);
            }
        }

        if (setIndices.size()<m){
            return -1;
        }
        else {
            value+=setIndices.get(0);
            for (int i=1;i<m;i++){
                long localConstant=(setIndices.get(i)-setIndices.get(i-1))*k;
                constant+=localConstant;
                value+=localConstant*i;
            }
            minTime=value;
            for (int i=1;i<setIndices.size()-(m-1);i++){
                value-=(constant);
                long localConstant=(setIndices.get(i+(m-1))-setIndices.get(i+(m-2)))*k;
                constant+=localConstant;
                constant-=(setIndices.get(i)-setIndices.get(i-1))*k;
                value+=setIndices.get(i)-setIndices.get(i-1)+localConstant*(m-1);
                if (value<minTime){
                    minTime=value;
                }
            }
            return minTime;
        }

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] b = new int[n];
        for(int b_i = 0; b_i < n; b_i++){
            b[b_i] = in.nextInt();
        }
        long result = minimumTime(b, m, k);
        System.out.println(result);
        in.close();
    }
}


