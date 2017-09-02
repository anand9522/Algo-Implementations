package Strings;

/**
 * Created by anand on 02/09/17.
 */
//public class kCharachterSubstring {
//}
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

 class Solution {

    static String subsequenceAgain(String s, int k) {
        // Complete this function
        StringBuffer answer = new StringBuffer("");

        HashMap<Character,Integer> charMap=new HashMap<>();
        for(char c:s.toCharArray()){
            if(!charMap.containsKey(c)){
                charMap.put(c,1);
            }
            else{
                charMap.put(c,charMap.get(c)+1);
            }
        }


        for(char c:s.toCharArray()){
            if(charMap.get(c)>=k){
                answer.append(c);
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int k = in.nextInt();
        String result = subsequenceAgain(s, k);
        System.out.println(result);
        in.close();
    }
}

