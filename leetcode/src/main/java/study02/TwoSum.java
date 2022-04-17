package study02;

import java.util.Arrays;
import java.util.HashMap;

//leetcode 1.两数之和
public class TwoSum {
    /*暴力求解，两次循环对比target
    * 时间复杂度O(n^2)*/
    public static int[] twoSum(int num[],int target){
        int[] result = new int[2];
        for (int i = 0; i < num.length; i++) {
            for (int j = i+1; j <num.length ; j++) {//同一个元素不能在答案中重复出现
                if(num[i]+num[j]==target){
                    result[0] = i;
                    result[1] = j;
                }

            }

        }
        return result;
    }
    /*上面我们几乎要遍历两次数组，耗时耗力
    * 使用hashmap解决遍历次数问题
    * 没遍历一次元素去map里面找有没有对应的差值，有就直接返回
    * 没有就把这个元素存到我们的map中去，这样最多遍历一次数组就能解决
    * 时间复杂度O(n)*/
    public static int[] twoSumUpdate(int num[],int target){
        int result[] =new int[2];
        //数组值为key，数组下标为value
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            int another = target - num[i];
            Integer anotherIndex = map.get(another);
            if (null != anotherIndex){
                result[0] = anotherIndex;
                result[1] = i;
            }else {
                map.put(num[i],i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(ints,9)));
        System.out.println(Arrays.toString(twoSumUpdate(ints, 9)));
    }
}
