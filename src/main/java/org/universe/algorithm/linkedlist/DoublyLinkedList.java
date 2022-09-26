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

    public Node getNode(int data) {
            // allocate node
            Node newNode = new Node();
 
            // put in the data
            newNode.data = data;
            newNode.prev = newNode.next = null;
            return newNode;
 
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


    // Adding a node at the front of the list
    public void push(int new_data)
    {
        /* 1. allocate node
        * 2. put in the data */
        Node new_Node = new Node(new_data);
    
        /* 3. Make next of new node as head and previous as NULL
        */
        new_Node.next = head;
        new_Node.prev = null;
    
        /* 4. change prev of head node to new node */
        if (head != null)
            head.prev = new_Node;
    
        /* 5. move the head to point to the new node */
        head = new_Node;
    }
        
    public Node merge(Node first, Node second) {
        // If first linked list is empty
        if (first == null)
            return second;
    
        // If second linked list is empty
        if (second == null)
            return first;
    
        // Pick the smaller value
        if (first.data < second.data)
        {
            first.next = merge(first.next, second);
            first.next.prev = first;
            first.prev = null;
            return first;
        }
        else
        {
            second.next = merge(first, second.next);
            second.next.prev = second;
            second.prev = null;
            return second;
        }
    }

    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public int partition (int []arr, int l, int h){
        int x = arr[h];
        int i = (l - 1);
        
        for(int j = l; j <= h - 1; j++)
        {
            if (arr[j] <= x)
            {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }    
        int tmp = arr[i + 1];
        arr[i + 1] = arr[h];
        arr[h] = tmp;
        return(i + 1);
    }

    public void quickSort(int []A, int l, int h) {
        if (l < h) {
            
            // Partitioning index 
            int p = partition(A, l, h); 
            quickSort(A, l, p - 1);  
            quickSort(A, p + 1, h);
        }
    }



    public Node split(Node head) {
        Node fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node temp = slow.next;
        slow.next = null;
        return temp;
    }

    public Node mergeSort(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node second = split(node);
  
        // Recur for left and right halves
        node = mergeSort(node);
        second = mergeSort(second);
  
        // Merge the two sorted halves
        return merge(node, second);
    }


    public Node merge(Node first, Node second) {
        // If first linked list is empty
        if (first == null) {
            return second;
        }
  
        // If second linked list is empty
        if (second == null) {
            return first;
        }
  
        // Pick the smaller value
        if (first.data < second.data) {
            first.next = merge(first.next, second);
            first.next.prev = first;
            first.prev = null;
            return first;
        } else {
            second.next = merge(first, second.next);
            second.next.prev = second;
            second.prev = null;
            return second;
        }
    }

    public void pairSum( Node head, int x) {
        // Set two pointers, first
        // to the beginning of DLL
        // and second to the end of DLL.
        Node first = head;
        Node second = head;
        while (second.next != null)
            second = second.next;
     
        // To track if we find a pair or not
        boolean found = false;
     
        // The loop terminates when 
        // they cross each other (second.next
        // == first), or they become same
        // (first == second)
        while ( first != second && second.next != first)
        {
            // pair found
            if ((first.data + second.data) == x)
            {
                found = true;
                System.out.println( "(" + first.data +
                                    ", "+ second.data + ")" );
     
                // move first in forward direction
                first = first.next;
     
                // move second in backward direction
                second = second.prev;
            }
            else
            {
                if ((first.data + second.data) < x)
                    first = first.next;
                else
                    second = second.prev;
            }
        }
     
        // if pair is not present
        if (found == false)
            System.out.println("No pair found");
    }
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
 
        /* Let us create a sorted linked list to test the
         functions Created linked list will be 10->8->4->2
       */
        list.push(2);
        list.push(4);
        list.push(8);
        list.push(10);
 
        System.out.println("Original linked list ");
        list.printList(head);
         
          // Function call
        list.reverse();
       
        System.out.println("");
        System.out.println("The reversed Linked List is ");
        list.printList(head);
    }
}