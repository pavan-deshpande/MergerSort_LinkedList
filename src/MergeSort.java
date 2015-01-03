public class MergeSort {
	
	MyLinkedList list;
	
	public MergeSort(){
		list =  new MyLinkedList();
	}

	public Node mergeSort(Node head) {

		if (head == null || head.getNext() == null) {
			return head;
		}

		int count = 0;
		Node p = head;
		while (p.getNext() != null) {
			count++;
			p = p.getNext();
		}

		int middle = count / 2;
		Node l = head;
		Node r = null;
		Node temp = head;

		int half = 0;

		while (temp != null) {
			half++;
			Node next = temp.getNext();

			if (half == middle) {
				temp.setNext(null);
				r = next;
			}
			temp = next;
		}

		Node h1 = mergeSort(l);
		Node h2 = mergeSort(r);

		// merge together
		Node merged = mergeTwoLists(h1, h2);

		return merged;

	}

	public Node mergeTwoLists(Node l1, Node l2) {

		Node p1 = l1;
		Node p2 = l2;

		MyLinkedList mergeList = new MyLinkedList();
		MyLinkedList p = mergeList;

		while (p1 != null && p2 != null) {
			if (p1.getData() <= p2.getData()) {
				p.add(p1.getData());
				p1 = p1.getNext();
			} else {
				p.add(p2.getData());
				p2 = p2.getNext();
			}

		}

		while (p1 != null) {
			p.add(p1.getData());
			p1 = p1.getNext();
		}
		while (p2 != null) {
			p.add(p2.getData());
			p2 = p2.getNext();
		}

		return mergeList.head;
	}
	
	
	
	public static void main(String[] args) {
		MergeSort obj = new MergeSort();
		
		obj.list.add(3);
		obj.list.add(7);
		obj.list.add(2);
		obj.list.add(8);
		obj.list.add(1);
		obj.list.add(5);
		
		Node n = obj.mergeSort(obj.list.head);
		
		
		
		while(n != null){
			System.out.println(n.getData());
			n.setNext(n.getNext());
			
		}
		
	}

	private class MyLinkedList {
		Node head;
		int size;

		public MyLinkedList() {
			head = new Node();
			size = 0;
		}

		public void add(int value) {

			Node temp = new Node(value);
			Node current = head;
			
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(temp);
			size++;
		}

	}

	class Node {

		public Node next;
		public int data;

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node(){
			next = null;
		}
		public Node(int value) {
			next = null;
			data = value;
		}

		public Node(int value, Node nextNode) {
			data = value;
			next = nextNode;
		}
	}

}
