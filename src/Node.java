public class Node {
    protected String item;
    protected Node next = null;
    protected Node previous = null;

    /**
     * Constructor. Sets data
     *
     * @param item the data stored
     * @return
     */
    Node(String item) {
        this.item = item;
    }

    /**
     * Returns this node's data
     *
     * @return the reference to node's data
     */
    public String getItem() {
        // return data stored in this node
        return item;
    }

    /**
     * Get reference to next node
     *
     * @return the next node
     */
    public Node getNext() {
        // get next node
        return next;
    }

    public Node getPrevious() {
        return previous;
    }
    /**
     * Set reference to next node
     *
     * @param next reference
     */
    public void setNext(Node next) {
        this.next = next;
    }

    public String toString() {

        String s = String.valueOf(this.item);
        return s;
    }
}

