package study01;

import java.util.HashMap;
import java.util.Map;

//leetcode   70.爬楼梯
public class ClimbStairs {
    /*递归方法实现
    * f(1)= 1
    * f(2)=2
    * f(n)=f(n-1)+f(n-2)
    * 时间复杂度比较高
    * 问题：求解过程同一个f(m)可能回出现求解多次，影响性能*/
    public static int climbStairs(int n){
        //递归终止条件
        if(n == 1)return 1;
        if (n == 2)return 2;
        return climbStairs(n-1)+climbStairs(n-2);
    }
    /*完善上面出现的求解多次的问题，采用hashmap处理*/
    public static int climbStairsUpdate(int n){
        Map<Integer,Integer> map =new HashMap<>();
        if (n == 1)return 1;
        if (n == 2)return 2;
        if (null != map.get(n))
            return map.get(n);
        else{
            int result = climbStairsUpdate(n-1)+climbStairsUpdate(n-2);
            map.put(n,result);
            return result;
        }
    }
    /*循环解法：设置两个值存储求解需要的前两个的值
    * 自底向上累加
    * 时间复杂度O(n)*/
    public static int climbStairsAdd(int n){
        if(n == 1)return 1;
        if(n == 2)return 2;
        int result = 0;
        int pre = 2;
        int prePre = 1;
        for (int i = 3; i <= n ; i++) {
            result = pre + prePre;
            prePre = pre;
            pre = result;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
        System.out.println(climbStairsUpdate(3));
        System.out.println(climbStairsAdd(3));
    }
}
