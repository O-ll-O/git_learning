package leetcode.twoadd;

public class TwoAdd_2 {
	public static void main(String[] args) {
		System.out.print(10 % 10);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int num1 = l1.val;
		int num2 = l2.val;
		boolean flag = false;
		ListNode root;
		int sum = num1 + num2;
		if (sum > 10) {
			flag = true;
			root = new ListNode(sum % 10);
		} else {
			root = new ListNode(sum);
		}

		sum = 0;
		num1 = 0;
		num2 = 0;

		ListNode node1;
		ListNode node2;
		ListNode next;
		next = root;
		next = next.next;
		do {
			node1 = l1.next;
			if (node1 != null) {
				num1 = node1.val;
			}
			node2 = l2.next;
			if (node2 != null) {
				num2 = node2.val;
			}
			sum = num1 + num2;
			if (flag) {
				sum += 1;
				flag = false;
			}

			if (sum > 10) {
				flag = true;
				next = new ListNode(sum % 10);

			} else {
				next = new ListNode(sum);
			}
			next.next = next;

			sum = 0;
			num1 = 0;
			num2 = 0;
		} while (node1 != null || node2 != null);

		return root;
	}

	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		ListNode head = null, tail = null;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int n1 = l1 != null ? l1.val : 0;
			int n2 = l2 != null ? l2.val : 0;
			int sum = n1 + n2 + carry;
			if (head == null) {
				head = tail = new ListNode(sum % 10);
			} else {
				tail.next = new ListNode(sum % 10);
				tail = tail.next;
			}
			carry = sum / 10;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		if (carry > 0) {
			tail.next = new ListNode(carry);
		}
		return head;
	}

}
