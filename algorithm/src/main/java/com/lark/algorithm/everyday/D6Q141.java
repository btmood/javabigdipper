package com.lark.algorithm.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * @author btmood
 * @date 2021-08-26 18:09
 * @Description TODO
 */
public class D6Q141 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        while (prev.next != null) {
            for (ListNode listNode : list) {
                if (prev.next == listNode) {
                    return false;
                }
            }
            prev = prev.next;
        }
        return true;
    }

}
