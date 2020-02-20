package com.dancylon.leetcodesolution.medium;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.List;

/**
 * 两数之和
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTowSum {
    public static void main(String[] args) {
        ListNode l1 =  new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 =  new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode ln = addTwoNumbers2(l1,l2);
        List<Integer> list = new ArrayList<Integer>();
        getNodeArr(list,ln);
        for (Integer i:
             list) {
            System.out.println(i);
        }
    }
    //best
    public static ListNode addTwoNumbers3(ListNode l1,ListNode l2){
        if (l1 == null) {
            return l2;
        }else if(l2==null){
            return l1;
        }else if(l1.val+l2.val<=9){
            ListNode ln = new ListNode(l1.val+l2.val);
            ln.next = addTwoNumbers3(l1.next,l2.next);
            return ln;
        }else{
            ListNode ln = new ListNode(l1.val+l2.val-10);
            ln.next = addTwoNumbers3(new ListNode(1),addTwoNumbers3(l1.next,l2.next));
            return ln;
        }
    }

    private static ListNode addTwoNumbers2(ListNode l1,ListNode l2){
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode preNode = null;
        ListNode node = null;
        boolean flag = false;
        int a,b;
        while(p1!=null||p2!=null||flag){
            a = p1!=null?p1.val:0;
            b = p2!=null?p2.val:0;
            ListNode ln = new ListNode((a+b+(flag?1:0))%10);
            flag = a+b+(flag?1:0)>=10;
            if (preNode != null) {
                preNode.next = ln;
            }else{
                node = ln;
            }
            preNode = ln;
            p1=p1!=null&&p1.next!=null?p1.next:null;
            p2=p2!=null&&p2.next!=null?p2.next:null;
        }
        return node;
    }

    private static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        getNodeArr(list1, l1);
        getNodeArr(list2, l2);
        int i = 1;
        int s1 = list1.size();
        int s2 = list2.size();
        int a, b;
        boolean flag = false;
        ListNode preNode = null;
        while (s1 >= i || s2 >= i) {
            a = s1 - i >= 0 ? list1.get(s1 - i) : 0;
            b = s2 - i >= 0 ? list2.get(s2 - i) : 0;
            ListNode newln = new ListNode((a + b) % 10 + (flag ? 1 : 0));
            if (preNode != null) {
                newln.next = preNode;
            }
            preNode = newln;
            flag = a + b >= 10;
            i++;
        }
        return preNode;
    }

    //从逆序的链表得到正序的数组
    private static void getNodeArr(List<Integer> list, ListNode ll) {
        list.add(ll.val);
        if (ll.next != null) {
            getNodeArr(list, ll.next);
        }
    }
}


//  Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
