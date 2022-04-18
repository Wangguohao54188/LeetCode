package study02;

import java.util.ArrayList;
import java.util.List;

//leetcode 448.找到所有数组中消失的数字
public class FindDisappearedNumbers {
    public static List<Integer> findDisappearedNumbers(int[] nums){
        int n = nums.length;
        for (int num : nums){
            int x = (num-1)%n;
            nums[x] += n;
        }
        ArrayList<Integer> results = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n){
                results.add(i+1);
            }
        }
        return results;
    }
}
