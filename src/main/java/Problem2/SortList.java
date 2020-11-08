package Problem2;

import java.util.List;

public class SortList {
    private static final int SENTRY = Integer.MAX_VALUE;
    // DO NOT ADD ANY NEW MEMBER VARIABLE AND MEMBER FUNCTION

    // DO NOT CHANGE ANYTHING IN THIS FUNCTION
    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode mid = findMidAndBreak(head);
        return mergeLists(sortList(head), sortList(mid));
    }

    public static ListNode findMidAndBreak(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode x = head;
        ListNode twoX = head.next;

        while (twoX != null) {
            twoX = twoX.next;
            if (twoX != null) {
                twoX = twoX.next;
                if (twoX != null) {
                    x = x.next;
                }
            }
        }
        ListNode secondHead = x.next;
        x.next = null;

        return secondHead;
    }


    public static ListNode mergeLists(ListNode list1, ListNode list2) {
        // homework
        if (list1 == null && list2 == null) {
            return null;
        }
        ListNode list1Temp = list1;
        ListNode list2Temp = list2;
        ListNode newHead;
        if (list1Temp == null) {
            newHead = list2Temp;
            list2Temp = list2Temp.next;
        } else if (list2Temp == null) {
            newHead = list1Temp;
            list1Temp = list1Temp.next;
        } else {
            if (list1Temp.val < list2Temp.val) {
                newHead = list1Temp;
                list1Temp = list1Temp.next;
            } else {
                newHead = list2Temp;
                list2Temp = list2.next;
            }
        }
        ListNode temp = newHead;

        while (!(list1Temp == null && list2Temp == null)) {
            if (list1Temp == null) {
                temp.next = list2Temp;
                temp = temp.next;
                list2Temp = list2Temp.next;
            } else if (list2Temp == null) {
                temp.next = list1Temp;
                temp = temp.next;
                list1Temp = list1Temp.next;
            } else {
                if (list1Temp.val < list2Temp.val) {
                    temp.next = list1Temp;
                    temp = temp.next;
                    list1Temp = list1Temp.next;
                } else {
                    temp.next = list2Temp;
                    temp = temp.next;
                    list2Temp = list2Temp.next;
                }
            }
        }
        return newHead;
    }
}
