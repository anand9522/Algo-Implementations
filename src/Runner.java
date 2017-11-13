import Arrays.AddOne;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by anand on 13/11/17.
 */
public class Runner {
    public static void main(String[] args) {
        Integer [] test = {0, 0, 4, 4, 6, 0, 9, 6, 5, 1};
        ArrayList<Integer> test_list = new ArrayList<Integer>(Arrays.<Integer>asList(test));
        AddOne a = new AddOne();
        System.out.println(a.plusOne(test_list));

    }

}
