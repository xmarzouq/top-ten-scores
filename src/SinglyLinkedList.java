public class SinglyLinkedList <E>{
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	public SinglyLinkedList() { }
	public int size() { return size;}
	public boolean isEmpty() {return size==0;}


	public Node<E> getHead() {
		return head;
	}
	public Node<E> getTail() {
		return tail;
	}
	public E first()
	{
		if (isEmpty()) return null;
		return head.getData();
	}
	public E last()
	{
		if (isEmpty()) return null;
		return head.getData();
	}
	public void addFirst(E e)
	{
		head=new Node<>(e,head);
		if(size==0)
			tail=head;
		size++;

	}
	public void insertInMiddle(E e) {

		if (isEmpty() || (size < 2) ) {
			System.err.println("The list should have at least 2 nodes !");
			System.exit(0);
		} else {
			Node<E> inMiddle = new Node<>(e, null);
			int middleChecker = 0;
			if ((size % 2) == 0)
				middleChecker = size/2;
			else
				middleChecker = (size/ 2) + 1;
			int i = size;

			for (Node<E> tmp=head;tmp!=null;tmp=tmp.getNext()) {
				if (middleChecker == (i-1)) {
					inMiddle.setNext(tmp.getNext());
					i--;
				}
				if (middleChecker == i) {
					tmp.setNext(inMiddle);
					i--;
				} else 
					i--;

			}
		}
		size++;
	}
	public void addLast(E e)
	{
		Node<E> newest=new Node<>(e,null);
		if(isEmpty())
			head=newest;
		else
			tail.setNext(newest);

		tail=newest;
		size++;
	}

	public E removeFirst()
	{
		if(isEmpty()) return null;
		E answer=head.getData();
		head=head.getNext();
		size--;
		if (size==0)
			tail=null;
		return answer;
	}
	public E removeLast()
	{
		if(isEmpty()) return null;
		E answer=tail.getData();
		if (head==tail)
			head=tail=null;
		else
		{
			Node<E> tmp=head;
			while (tmp.getNext()!=tail)
				tmp=tmp.getNext();
			tmp.setNext(null);
			tail=tmp;
		}
		size--;
		return answer;
	}
	
//	
//	
//	public void removeRest(int size) {
//		if (size == 10 || size() > 10) {
//			for(int i=(size - 10); i<0; i--) {
//				remove(i);
//			}
//		}
//	}
//	
//	
//	
	
	
	public E remove(int position)
	{
		E removed = null;
		Node<E> temp = head;
		if (head == null)
			return null;

		if (position == 0)
		{
			return removeFirst();
		}

		// Find previous node of the node to be deleted
		for (int i=0; temp!=null && i<position-1; i++)
			temp = temp.getNext();

		// If position is more than number of nodes
		if (temp == null || temp.getNext() == null) {
			System.err.println("Error\t Index Out Of Bound.");
			return null;
		}

		// Node temp.getNext is the node to be deleted. Store pointer to the next of node to be deleted
		removed = temp.getNext().getData();
		Node<E> next = temp.getNext().getNext();
		temp.setNext(next);
		size--;
		return removed;
	}

	public void reverseDisplay(Node<E> head) {
		int i=0;
		if (head == null) {
			return;
		}
		reverseDisplay(head.getNext());
		System.out.println(head.getData());
	}

	public void display() {
		for (Node<E> tmp=head;tmp!=null;tmp=tmp.getNext())
			System.out.println(tmp.getData());
	}
}