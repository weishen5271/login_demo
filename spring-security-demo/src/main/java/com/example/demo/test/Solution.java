package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>类描述：。</p>
 *
 * @author 沈伟 [shenwei]。
 * @version v1.0.0.1。
 * @since JDK1.8。
 * <p>创建日期：2020/10/27 0027 11:43。</p>
 */


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        List<Integer> list = new ArrayList<>();

        int index = 0;
        while (l1 != null){
            int val1 = l1.val;
            int val2 = 0;
            if (l2!=null){
                val2 = l2.val;
            }

            if (index >= list.size()){
                list.add(0);
            }
            int sum = val1 + val2 + list.get(index);


            list.set(index,sum % 10);
            if (sum >= 10){
                list.add(0);
                list.set(index + 1,sum / 10);
            }
            l1 = l1.next;
            if (l2 != null){
                l2 = l2.next;
            }

            index++;
        }

        while (l2 != null){
            int val2 = l2.val;

            if (index >= list.size()){
                list.add(0);
            }

            int sum =   val2 + list.get(index);


            list.set(index,sum % 10);
            if (sum >= 10){
                list.add(0);
                list.set(index + 1,sum / 10);
            }

            l2 = l2.next;
            index++;
        }

        return arrayToListNode(list);
    }

    public static  ListNode arrayToListNode(List<Integer> list){

        if (list.size() != 0){
            return new ListNode(list.remove(0),arrayToListNode(list));
        }else {
            return null;
        }
    }


    public static void main(String[] args) {

        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(9)));
        ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4,new ListNode(9))));
        ListNode l3 = new ListNode(3,new ListNode(3));





        ListNode result = addTwoNumbers(l1,l2);

        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }

    }

}