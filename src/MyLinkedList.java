public class MyLinkedList {
	private Node head;

	public MyLinkedList() {
		head = null;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public void insert(int val) {
		Node newNode = new Node(val);
		newNode.next = head;
		head = newNode;
	}

	public void append(Node result) {
		head = result;
	}

	public void display() {
		Node current = head;
		while (current != null) {
			current.displayNode();
			current = current.next;
		}
		System.out.println("");
	}

	public Node getHead() {
		return head;
	}

	public Node MergeSort(Node headOriginal) {
		if (headOriginal == null || headOriginal.next == null)
			return headOriginal;
		Node a = headOriginal;
		Node b = headOriginal.next;
		while ((b != null) && (b.next != null)) {
			headOriginal = headOriginal.next;
			b = (b.next).next;
		}
		b = headOriginal.next;
		headOriginal.next = null;
		return merge(MergeSort(a), MergeSort(b));

	}

	public Node merge(Node a, Node b) {
		Node temp = new Node();
		Node head = temp;
		Node c = head;
		while ((a != null) && (b != null)) {
			if (a.item <= b.item) {
				c.next = a;
				c = a;
				a = a.next;
			} else {
				c.next = b;
				c = b;
				b = b.next;
			}
		}
		c.next = (a == null) ? b : a;
		return head.next;
	}

	class Node {
		public int item;
		public Node next;

		public Node(int val) {
			item = val;
		}

		public Node() {
		}

		public void displayNode() {
			System.out.println(item);
		}
	}
}