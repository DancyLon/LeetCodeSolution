package com.dancylon.leetcodesolution.easy;

import com.dancylon.leetcodesolution.util.ListNode;

public class MergeTwoList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode ln = mergeTwoLists2(l1,l2);
        do {
            System.out.println(ln.val);
            ln = ln.next;
        }while(ln!=null);

    }

    //best
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode puppet = new ListNode(-1);
        ListNode curr = puppet;
        while(l1 != null && l2 != null) {
            if(l1.val >= l2.val){
                curr.next = l2;
                l2 = l2.next;
            } else {
                curr.next = l1;
                l1 = l1.next;
            }
            curr = curr.next;
        }
        if(l1 != null){
            curr.next = l1;
        }
        if(l2 != null){
            curr.next = l2;
        }
        return puppet.next;
    }

    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if(l2==null)
            return l1;
        ListNode ln;
        int v1 = l1.val;
        int v2 = l2.val;
        boolean flag = v1<=v2;
        ListNode smallerNode = flag?l1:l2;
        ListNode biggerNode = flag?l2:l1;
        int smallerVal = flag?v1:v2;
        int biggerVal = flag?v2:v1;
        ln = new ListNode(smallerVal);
        ListNode preNode = ln;
        while(smallerNode.next!=null){
            ListNode ln1;
            if(smallerNode.next.val<=biggerVal){
                ln1 = new ListNode(smallerNode.next.val);
                smallerNode = smallerNode.next;
                smallerVal = smallerNode.val;
            }else{
                ln1 = new ListNode(biggerVal);
                ListNode tmp = smallerNode;
                smallerVal = biggerVal;
                smallerNode = biggerNode;
                biggerVal = tmp.next.val;
                biggerNode = tmp.next;
            }
            preNode.next = ln1;
            preNode = ln1;
        }
        preNode.next = biggerNode;
        return ln;
    }
}
