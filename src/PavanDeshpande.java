/**
 * 
 * @author pavan
 * 
 * This is the main class which executes the merge sort function
 *
 */

public class PavanDeshpande {
	public static void main(String[] args) {
		MyLinkedList object = new MyLinkedList();
		object.insert(30);
		object.insert(10);
		object.insert(50);
		object.insert(20);
		object.insert(5);
		object.insert(8);
		object.display();
		System.out.println("The list after merge sort");
		object.append(object.MergeSort(object.getHead()));
		object.display();
	}
}