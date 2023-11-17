package practice.leetcode.easy.linklist;

import practice.leetcode.ListNode;

import java.util.PriorityQueue;

/**
 * @author SummerLv
 * @version 2023/11/12 18:47
 * @link https://leetcode.cn/problems/merge-k-sorted-lists/description/
 */
public class Hard_23_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        // 以指定容量指定一个优先级队列，排序方式为升序
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length,(a,b)->(a.val-b.val));
        
        // 将k个节点的头节点加入最小堆
        for(ListNode head:lists) {
            if(head!=null)
                pq.add(head);
        }
        
        while (!pq.isEmpty()) {
            // 获取最小节点，接到结果链表中
            ListNode node = pq.poll();
            p.next = node;
            if(node.next!=null) {
                pq.add(node.next);
            }
            // 更新结果
            p = p.next;
        }
        
        return dummy.next;
    }
}
