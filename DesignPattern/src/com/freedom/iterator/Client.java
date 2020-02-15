package com.freedom.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuf
 * date: 2020-02-14
 */
public class Client {
    public static void main(String[] args) {
        List<College> colleges = new ArrayList<>();

        ComputerCollege computerCollege = new ComputerCollege();
        InfoCollege infoCollege = new InfoCollege();

        colleges.add(computerCollege);
        colleges.add(infoCollege);

//        OutputImpl output = new OutputImpl(colleges);
//        output.printCollege();

        int[] nums = new int[]{1, 2, 3, 2, 1};
        System.out.println(singleNumber(nums));

    }

    public static int singleNumber(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                System.out.printf(ans + " ^ " + nums[i] );
                ans = ans ^ nums[i];
                System.out.println(" is " + ans);
            }
        }
        return ans;
    }
}
