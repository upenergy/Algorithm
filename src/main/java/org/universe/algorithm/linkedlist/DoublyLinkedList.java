public class DoublyLinkedList {
     
    // Head of list
    Node head;
 
    // Doubly Linked list Node
    class Node {
        int data;
        Node prev;
        Node next;
 
        // Constructor to create a new node
        // next and prev is by default initialized as null
        Node(int d) { data = d; }
    }

    public void append(int new_data) {
        /* 1. allocate node
        * 2. put in the data */
        Node new_node = new Node(new_data);
    
        Node last = head; /* used in step 5*/
    
        /* 3. This new node is going to be the last node, so
        * make next of it as NULL*/
        new_node.next = null;
    
        /* 4. If the Linked List is empty, then make the new
        * node as head */
        if (head == null) {
            new_node.prev = null;
            head = new_node;
            return;
        }
    
        /* 5. Else traverse till the last node */
        while (last.next != null)
            last = last.next;
    
        /* 6. Change the next of last node */
        last.next = new_node;
    
        /* 7. Make last node as previous of new node */
        new_node.prev = last;
    }

    public static Node reverse( Node head_ref) {
    Node temp = null;
    Node current = head_ref;
 
    // swap next and prev for all nodes
    // of doubly linked list
    while (current != null)
    {
        temp = current.prev;
        current.prev = current.next;
        current.next = temp;
        current = current.prev;
    }
 
    // Before changing head, check for the cases
    // like empty list and list with only one node
    if (temp != null)
        head_ref = temp.prev;
        return head_ref;
    }
}