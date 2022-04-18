package study03;
//leetcode 83.删除排序链表的重复元素
public class DeleteDuplicates {
    /*单指针遍历链表*/
    public static ListNode deleteDuplicates(ListNode head){
        if (head == null) return head;
        ListNode currentNode = head;
        while(null != currentNode.next){
            if (currentNode.val == currentNode.next.val){
                currentNode.next = currentNode.next.next;
            }else {
                currentNode = currentNode.next;
            }
        }
        return head;
    }
    /*递归解决*/
    public static ListNode deleteDuplicate(ListNode head){
        if(head == null || head.next == null)return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }

}
