package linkedlist;

public class LinkedList {
	private Node start;
	private Node end;

	public LinkedList() {
		start = null;
		end = null;
	}

	public void add(int val) {
		Node newNode = new Node(val, null);

		if (start == null) {
			start = newNode;
			end = start;
		} else {
			end.setNext(newNode);
			end = newNode;
		}
	}

	public void removeLast() {
		Node cur = start;
		Node prev = start;
		while (cur != end) {
			prev = cur;
			cur = cur.getNext();
		}
		end = prev;
		end.setNext(null);
		return;
	}

	public void removeAllElementGreatThanValue(int value) {
		Node cur = start;
		Node prev = start;
		while (cur != null) {
			if (cur.getData() > value && cur == start) {
				start = start.getNext();
				cur = start;
				prev = start;
			} else if (cur.getData() <= value) {
				prev = cur;
				cur = cur.getNext();
			} else {
				prev.setNext(cur.getNext());
				cur = cur.getNext();
			}
		}
		end = prev;
	}

	@Override
	public String toString() {
		if (start == null) {
			return null;
		}
		return start.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(6);
		list.add(5);
		list.add(7);
		System.out.println(list.toString());
		list.removeLast();
		System.out.println("After remove last one: " + list.toString());
		list.removeLast();
		System.out.println("After remove last one: " + list.toString());
		list.removeAllElementGreatThanValue(1);
		System.out.println("After remove all element great than value: " + list.toString());
	}

}
