package linkedlistsortingalgoritym;

public class SinglyLinkedList {
	public SinglyLinkedListNode header;
	public SinglyLinkedListNode tail;
	public int length; //not necessary
	
	public SinglyLinkedList() {
		this.header = null;
		this.tail = null;
		this.length = 0;
	}
	
	//O(n)
	public int GetLength() {
		//can we do without using length?
		/*int len = 0;
		SinglyLinkedListNode node = this.header;
		while(node != null) {
			len++;
			node = node.nextNode;
		}*/
		return this.length; //O(1) insteand of O(n)
	}
	
	public boolean IsEmpty() {
		return this.header == null;
	}
	
	//Append: add to the end to the node
	//O(n)
	public void Append(int value) {
		SinglyLinkedListNode newNode = new SinglyLinkedListNode(value);
		if (this.IsEmpty()) { //when it is an empty list
			this.header = newNode;
			this.length++;
		} else { //when it is not empty
			//find the tail node
			SinglyLinkedListNode tail = this.header;
			while(tail.nextNode != null) {
				tail = tail.nextNode;
			}
			tail.nextNode = newNode;
			this.length++;
			//make the tail node's next be the newNode
		}
	}
	
	
	//Prepend: add to the front
	//O(1)
	public void Prepend(int value) {
		SinglyLinkedListNode newNode = new SinglyLinkedListNode(value);
		newNode.nextNode = this.header;
		this.header = newNode;
		this.length++;
	}
	
	//InsertAfter
	//O(1)
	public void InsertAfter(SinglyLinkedListNode a, int value) {
		SinglyLinkedListNode b = a.nextNode;
		SinglyLinkedListNode newNode = new SinglyLinkedListNode(value);
		a.nextNode = newNode;
		newNode.nextNode = b;
		this.length++;
	}
	
	//Remove: delete the node from the list
	//return: does the remove action complete
	//O(n)
	public boolean Remove(SinglyLinkedListNode node) {
		//0. when this is an empty list
		if (this.IsEmpty()) {
			return false;
		} else {
			//1. locate the previous node of the node
			//2. connect the previous node to the next node
			//3. make the node point to null
			if (this.header == node) {
				if (this.header.nextNode == null) {
					this.header = null;
					this.length = 0;
				} else {
					this.header = this.header.nextNode;
					this.length--;
				}
				node.nextNode = null;
				return true;
			} else {
				SinglyLinkedListNode previous = this.header;
				while (previous.nextNode != null) {
					if (previous.nextNode == node) {
						previous.nextNode = previous.nextNode.nextNode;
						this.length--;
						node.nextNode = null;
						return true;
					} else {
						previous = previous.nextNode;
					}
				}
				//we do not find the node on the list
				return false;
			}
		}
		
	}
	//Search: return the first node that match the value to search
	//O(1)
	public SinglyLinkedListNode Search(int value) {
		SinglyLinkedListNode node = this.header;
		while (node != null) {
			if (node.payload == value) {
				return node;
			} else {
				node = node.nextNode;
			}
		}
		return null;
	}
	
	//Print
	public void Print() {
		System.out.println(this);
	}
	
	//object-oriented programming
	@Override
	public String toString() {
		if (this.IsEmpty()) {
			return "(0){empty}";
		}
		SinglyLinkedListNode node = this.header;
		String output = "(" + this.GetLength() + ")" + "{"+ node;
		node = this.header.nextNode;
		while (node != null) {
			output = output + ", " + node;
			node = node.nextNode;
		}
		output = output + "}";
		return output;
	}
	
	//PrintReverse
	public void PrintReverse() {
		if (this.IsEmpty()) {
			System.out.println( "(0){empty}");
		}
		SinglyLinkedListNode node = this.header;
		//1 > 2 > 3
		String output = node.toString(); //1
		node = this.header.nextNode;
		while (node != null) {
			//3 2 1
			output = node + " < " + output;
			node = node.nextNode;
		}
		//output is "3 < 2 < 1" -> "(3){3 < 2 <1}"
		//string format template is "(%d){%s}"
		System.out.println(String.format("(%d){%s}", this.GetLength(), output));
	}
	
	//Sort
	public void Sort(boolean asending) {
		//how?
		//Selection sort
		//1 we pick a node, and find the smallest node starting from that node
		//2 swap the node with the found node
		//3 move to the next node, and repeat step 1 and step 2
		//you need to repeat this for n times
		SinglyLinkedListNode node = this.header;
		SinglyLinkedListNode node1 = this.header.nextNode;
		SinglyLinkedListNode nNode = node.nextNode;
		SinglyLinkedListNode temp = null;
		while (node1 != null) {
			//1 -> 1 -> 1
			if(node.compareTo(node1) > 0) {
				//swap node and node 1
				temp = node;
				node = node1;
				node1 = temp;
				//if node was head
				if(node == header) {
					node1 = this.header;
				//if node was tail
				}else if(nNode == null) {
					node = this.tail;
				}
				//else do nothing
				//define what is next node
				//this is for the next iteration, next round node is node 1
				//... -> 2 -> 1 -> ...
				//'node = 2; node1 = 1;
				//... -> 1 -> 2 -> ...
				//'node is still 2, node1 is still 1
				//node = node;
				//node 1 is node.nextNode
				node1 = node.nextNode;
			} else if (node.compareTo(node1) == 0) {
				node = node1;
				node1 = node.nextNode;
			} else {
				node = node1;
				node1 = node.nextNode;
			}
		}
	}
		
		
		//Insertion Sort
		//it is a bad idea using singly linked list because we need to go backwards
		
		//quick sort
		//not a good algorithm for singly linked list, because we also need to go backwards
		
		//merge sort
		//a good algorithm to try on the singly linked list
	}

