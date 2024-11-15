package linkedlistsortingalgoritym;

public class Main {

	public static void main(String[] args) {
		System.out.println("hello, singly linked list");
		SinglyLinkedList list = new SinglyLinkedList();
		list.Append(17);	
		list.Prepend(9);
		list.Append(5);
		
		list.Sort(true);
		list.Print();
	}

}
