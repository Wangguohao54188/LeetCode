package study03;
//leetcode 21.合并两个有序链表
public class MergeTwoLists {
    /*双指针方法
    * 时间复杂度O(m+n)*/
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode resultNode = new ListNode(-1);
        ListNode p = resultNode;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        if (list1 != null) {
            p.next = list1;
        }
        if (list2 != null) {
            p.next = list2;
        }
        return resultNode.next;
    }
    /*递归方法*/
    public static ListNode mergeTwoList(ListNode list1,ListNode list2){
        if (list1 == null)return list2;
        if (list2 == null)return list1;
        if (list1.val < list2.val){
            list1.next = mergeTwoList(list1.next,list2);
            return list1;
        }
        list2.next =mergeTwoList(list1,list2.next);
        return list2;
    }
}
