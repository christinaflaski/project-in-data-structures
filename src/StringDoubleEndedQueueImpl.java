import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringDoubleEndedQueueImpl implements StringDoubleEndedQueue {
    public Node head = null;
    public Node tail = null;
    public int size = 0;
    public StringDoubleEndedQueueImpl() {

    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void addFirst(String item) {
        Node newNode = new Node(item);
        this.size+=1;
        //if list is empty, head and tail points to newNode
        if (head == null) {
            head = tail = newNode;
            //head's previous will be null
            head.previous = null;
            //tail's next will be null
            tail.next = null;
        } else {
            //add newNode to the end of list. head->previous set to newNode
            head.previous = newNode;
            //newNode->next set to head
            newNode.next = head;
            //newNode becomes new tail
            head = newNode;
            //tail's next point to null
            head.previous = null;
        }

    }

    @Override
    public String removeFirst() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException();
        String item = head.getItem();
        this.size-=1;
        if (head == tail)
            head = tail = null;
        else
            head = head.getNext();
        return item;
    }

    @Override
    public void addLast(String item) {
        Node newNode = new Node(item);
        this.size+=1;
        //if list is empty, head and tail points to newNode
        if (head == null) {
            head = tail = newNode;
            //head's previous will be null
            head.previous = null;
            //tail's next will be null
            tail.next = null;
        } else {
            //add newNode to the end of list. tail->next set to newNode
            tail.next = newNode;
            //newNode->previous set to tail
            newNode.previous = tail;
            //newNode becomes new tail
            tail = newNode;
            //tail's next point to null
            tail.next = null;
        }
    }

    @Override
    public String removeLast() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException();
        String item = tail.getItem();
        this.size-=1;
        if (head == tail)
            head = tail = null;
        else
            tail = tail.getPrevious();
            tail.next = null;
        return item;
    }

    @Override
    public String getFirst() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException();
        String item = head.getItem();
        return item;
    }

    @Override
    public String getLast() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException();
        String item = tail.getItem();
        return item;
    }

    @Override
    public void printQueue(PrintStream stream) {
        if (isEmpty())
            throw new NoSuchElementException();
        Node current = head;

        while (current != null) {
            //Prints each node by incrementing the pointer.

            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println();
    }


    @Override
    public int size() {
        if (isEmpty()) {
            System.out.println(0);
            return 0;
        }else {
            return this.size;
        }
    }

}