class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    };

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class AddTwoNumbersLinkedList {
    public static void main(String[] args) {
        ListNode ls1 = new ListNode(0);
        ListNode ls2 = new ListNode(0);
        ListNode cur = ls1;
        String str1 = "150";
        String str2 = "150";
        for (int i = str1.length() - 1; i >= 0; i--) {
            cur.next = new ListNode(str1.charAt(i) - 48);
            cur = cur.next;
        }
        cur = ls2;
        for (int i = str2.length() - 1; i >= 0; i--) {
            cur.next = new ListNode(str2.charAt(i) - 48);
            cur = cur.next;
        }

        ListNode addition=getAddition(ls1.next, ls2.next);

        while (addition!=null) {
            System.out.print(addition.val); 
            addition=addition.next;           
        }

    }

    public static ListNode getAddition(ListNode ls1, ListNode ls2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while (ls1 != null || ls2 != null | carry != 0) {
            int sum = carry;
            if (ls1 != null) {
                sum += ls1.val;
                ls1 = ls1.next;
            }
            if(ls2!=null){
                sum+=ls2.val;
                ls2=ls2.next;
            }
            dummy.next=new ListNode(sum%10);
            dummy=dummy.next;
            carry=sum/10;
        }
        return cur.next;
    }
}
