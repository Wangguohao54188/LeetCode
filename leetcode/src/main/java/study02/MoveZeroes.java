package study02;
//leetcode 283.移动零
public class MoveZeroes {
    //双指针，非零元素往前移动，最后补0（移动方法）
    public static int[] moveZeroes(int[] nums){
        if (nums == null)return nums;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0){
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i <nums.length ; i++) {
            nums[i] = 0;
        }
        return nums;
    }
}
