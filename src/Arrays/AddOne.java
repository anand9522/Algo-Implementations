package Arrays;

import java.util.ArrayList;

/**
 * Created by anand on 13/11/17.
 */
public class AddOne {
    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        int carry = 0;
        int i=a.size()-1;
        int num = a.get(i);
        num+=1;
        if(num>9){
            carry=num/10;
            num=num%10;
        }
        a.set(i--,num);

        for(;i >= 0;i--){
            num = a.get(i);
            num += carry;
            if(num>9){

                a.set(i,num%10);
                carry=num/10;
            }
            else if(num>0){
                a.set(i,num);
                carry=0;
                break;
            }
        }
        if(carry>0){
            a.add(0,carry);
        }

        for(i=0;i<a.size();i++){
            if(a.get(i)>0){
                break;
            }
        }
        for(int j=0;j<i;j++){
            a.remove(0);
        }


        return a;
    }
}
