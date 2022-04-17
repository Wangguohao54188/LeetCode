package study02;

import java.util.Arrays;

//leetcode 88.合并两个有序数组
public class MergeTwoNum {
    /*合并成为一个数组nums1，利用java的Arrays工具类进行排序(底层为快排)
    * 时间复杂度O((m+n)log(m+n))*/
    public static int[] merge(int[] nums1,int m,int[] nums2,int n){
        for (int i = 0; i < n ; i++) {
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
        return nums1;
    }
    /*双指针实现两个有序数组排序
    * 时间复杂度O(m+n)
    * 问题：这里借用了辅助数组空间复杂度O(m+n)*/
    public static int[] mergeDoublePointer(int[] nums1,int m,int[] nums2,int n){
        int k = m+n;
        int[] temp = new int[k];
        for (int index = 0,nums1Index = 0,nums2Index = 0;index < k;index++){
            if (nums1Index >= m){/*num1数组取完，直接取num2数组*/
                temp[index] = nums2[nums2Index++];
            }else if (nums2Index >= n){/*num2数组取完，直接取num1数组*/
                temp[index] = nums1[nums1Index++];
            }else if (nums1[nums1Index] >= nums2[nums2Index]){
                temp[index] = nums2[nums2Index++];
            }else{
                temp[index] = nums1[nums1Index++];
            }
        }
        for (int i = 0; i < k; i++) {
            nums1[i] =temp[i];
        }
        return nums1;
    }
    /*双指针实现
    * 解决上面空间问题，使用原数组进行排序*/
    public static int[] mergeDoublePointerUpdate(int[] nums1,int m,int[] nums2,int n){
        int k = m+n;
        for (int index = k-1,num1Index = m-1,num2Index = n-1;index >=0;index--){
            if (num1Index < 0){/*nums1的元素取完，直接取nums2的元素即可*/
                nums1[index] = nums2[num2Index--];
            }else if(num2Index < 0){/*num2的元素取完，排序结束，直接退出*/
                break;
            }else if (nums1[num1Index] > nums2[num2Index]){/*如果nums1的元素大于nums2，取大值*/
                nums1[index] = nums1[num1Index--];
            }else{
                nums1[index] = nums2[num2Index--];
            }
        }
        return nums1;
    }
    /*测试*/
    public static void main(String[] args) {
        int nums1[] ={1,2,3,0,0,0};
        int nums2[] = {2,5,6};
        System.out.println(Arrays.toString(merge(nums1, 3, nums2, 3)));
        System.out.println(Arrays.toString(mergeDoublePointer(nums1, 3, nums2, 3)));
        System.out.println(Arrays.toString(mergeDoublePointerUpdate(nums1, 3, nums2, 3)));
    }
}
