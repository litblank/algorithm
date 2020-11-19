package com.litblank.hot;

import com.alibaba.fastjson.JSON;

/**
 * 2. 两数相加
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @ProjectName: algorithm
 * @ClassName: addTwoNumbers_2
 * @Author: chenyadong
 * @Date: 2020/11/3 17:18
 */
public class addTwoNumbers_2 {


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root=new ListNode();
        int carry=0;
        ListNode next=root;
        while (l1!=null || l2!=null ||carry!=0){
            int l1val= l1!=null? l1.val:0;
            int l2val= l2!=null? l2.val:0;

            next.val=(l1val+l2val+carry)%10;
            carry=(l1val+l2val+carry)/10;
            if(( l1!=null&& l1.next!=null) || (l2!=null&&l2.next!=null) ||carry!=0){
                next.next=new ListNode();
                next=next.next;
            }
            l1=l1!=null?l1.next:null;
            l2=l2!=null?l2.next:null;

        }
        return root;

    }

    public static void main(String[] args) {
        ListNode root1=new ListNode();
        root1.val=9;
        ListNode root2=new ListNode();
        root2.val=9;
//        ListNode root3=new ListNode();
//        root3.val=3;
//        root2.next=root3;
        root1.next=root2;

        ListNode root4=new ListNode();
        root4.val=9;
        ListNode root5=new ListNode();
        root5.val=9;
        ListNode root6=new ListNode();
        root6.val=9;
        root5.next=root6;
        root4.next=root5;

        System.out.println(JSON.toJSONString(addTwoNumbers_2.addTwoNumbers(root1,root4)));;
    }


}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
