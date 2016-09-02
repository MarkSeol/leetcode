/**
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 * @author Markxue
 *
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = l1;
        ListNode second = l2;
        ListNode end = first;
        ListNode result = first;
        boolean goUp = false;
        while (first != null && second != null) {
            int sum = first.val + second.val;
            if (goUp) {
                sum++;
            }
            if (sum >= 10) {
                sum %= 10;
                goUp = true;
            } else {
                goUp = false;
            }
            first.val = sum;
            end = first;
            first = first.next;
            second = second.next;
        }
        if (first == null) {
            end.next = second;
        }
        first = end.next;
        if (goUp) {
            while (first != null) {
                int sum = (goUp ? 1 : 0) + first.val;
                if (sum >= 10) {
                    sum %= 10;
                    goUp = true;
                } else {
                    goUp = false;
                }
                first.val = sum;
                if (!goUp) {
                    break;
                }
                end = first;
                first = first.next;
            }
            if (goUp) {
                ListNode node = new ListNode(1);
                end.next = node;
            }
        }
        return result;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(9);
        ListNode l12 = new ListNode(8);        
        l11.next = l12;
        
        ListNode l21 = new ListNode(1);      
        
        Solution s = new Solution();
        ListNode node = s.addTwoNumbers(l11, l21);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
