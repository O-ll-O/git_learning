package leetcode.reverselist;

import leetcode.common.ListNode;

public class ReverseList_206 {
//在遍历链表时，将当前节点的 next 指针改为指向前一个节点。由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。在更改引用之前，还需要存储后一个节点。最后返回新的头引用。
	public ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode next = curr.next;// 记录 后继节点
			curr.next = pre;// 移动指针cur.next指向pre
			pre = curr;// pre右移动
			curr = next;// cur右移
		}
		return pre;// 当cur为空时，返回pre

	}

	public ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = reverseList(head.next);// 将链表分为head和head.next两部分，子链表也分解成这样
		head.next.next = head;
		head.next = null;
		return newHead;// 返回翻转后的子链
	}

}
