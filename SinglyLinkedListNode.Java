package linkedlistsortingalgoritym;



public class SinglyLinkedListNode {
	//link
		public SinglyLinkedListNode nextNode;
		//value
		public Integer payload;
		
		public SinglyLinkedListNode() {
			this.nextNode = null;
			this.payload = 0;
		}
		
		public SinglyLinkedListNode(int value) {
			this.nextNode = null;
			this.payload = value;
		}
		
		//what is the default result of ToString of an object?
		@Override
		public String toString() {
			return String.valueOf(this.payload);
		}
		
		//if this is equal to another, return 0
		//if this is larger than another, return 1
		//if this is smaller than another return -1
		public int compareTo(SinglyLinkedListNode another) {
			if (this.payload instanceof Integer) {
				if ((int)this.payload > (int)another.payload) {
					return 1;
				} else if ((int)this.payload < (int)another.payload) {
					return -1;
				} else {
					return 0;
				}
			} else if (this.payload instanceof Integer) {
				return ((Integer)this.payload).compareTo((Integer)another.payload);
			} else {
				return 0;
			}
		}
		}

