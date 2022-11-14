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


    public Node insert(Node head, int data) {
        Node temp = new Node();
        temp.data = data;
        temp.next = temp.prev = null;
        if (head == null)
            (head) = temp;
        else
        {
            temp.next = head;
            (head).prev = temp;
            (head) = temp;
        }
        return temp;
    }


    public Node sortedInsert(Node head, Node newNode) {
            Node current;
 
            // if list is empty
            if (head == null)
                head = newNode;
 
            // if the node is to be inserted at the beginning
            // of the doubly linked list
            else if (head.data >= newNode.data)
            {
                newNode.next = head;
                newNode.next.prev = newNode;
                head = newNode;
            }
 
            else
            {
                current = head;
 
                // locate the node after which the new node
                // is to be inserted
                while (current.next != null &&
                        current.next.data < newNode.data)
                    current = current.next;
 
                /* Make the appropriate links */
                newNode.next = current.next;
 
                // if the new node is not inserted
                // at the end of the list
                if (current.next != null)
                    newNode.next.prev = newNode;
 
                current.next = newNode;
                newNode.prev = current;
             
            }
            return head;
    }
    
    
    public Node deleteNode(Node del) {
        // base case
        if (head == null || del == null)
            return null;
 
        // If node to be deleted is head node
        if (head == del)
            head = del.next;
 
        // Change next only if node to be
        // deleted is NOT the last node
        if (del.next != null)
            del.next.prev = del.prev;
 
        // Change prev only if node to be
        // deleted is NOT the first node
        if (del.prev != null)
            del.prev.next = del.next;
 
        del = null;
 
        return head;
    }

    public void deleteNodeAtGivenPos(int n) {
        /* if list in NULL or
          invalid position is given */
        if (head == null || n <= 0)
            return;
 
        Node current = head;
        int i;
 
        /*
        * traverse up to the node at
          position 'n' from the beginning
        */
        for (i = 1; current != null && i < n; i++)
        {
            current = current.next;
        }
         
        // if 'n' is greater than the number of nodes
        // in the doubly linked list
        if (current == null)
            return;
 
        // delete the node pointed to by 'current'
        deleteNode(current);
    }


    public void push(int new_data) {
        // allocate node
        Node new_node = new Node();
 
        // put in the data
        new_node.data = new_data;
 
        // since we are adding at the beginning,
        // prev is always NULL
 
        new_node.prev = null;
 
        // link the old list off the new node
        new_node.next = head;
 
        // change prev of head node to new node
        if (head != null)
            head.prev = new_node;
 
        // move the head to point to the new node
        head = new_node;
    }

    public void printList() {
        Node temp = head;
        if (temp == null)
            System.out.print("Doubly Linked list empty");
 
        while (temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void removeDuplicates(Node head) {
        /* if list is empty */
        if (head== null)
            return;
   
        Node current = head;
 
        /* traverse the list till the last node */
        while (current.next != null)
        {
            /* Compare current node with next node */
            if (current.data == current.next.data)
                /* delete the node pointed to by
              ' current->next' */
                deleteNode(head, current.next);
   
            /* else simply move to the next node */
            else
                current = current.next;
        } 
          
    }

    /* Function to delete a node in a Doubly Linked List.
    head_ref --> pointer to head node pointer.
    del  -->  pointer to node to be deleted. */
    public void deleteNode(Node head, Node del) {
         /* base case */
        if(head==null || del==null)
        {
            return ;
        }
        /* If node to be deleted is head node */
        if(head==del)
        {
            head=del.next;
        }
        /* Change next only if node to be deleted 
        is NOT the last node */
        if(del.next!=null)
        {
            del.next.prev=del.prev;
        }
        /* Change prev only if node to be deleted 
       is NOT the first node */
        if (del.prev != null)
            del.prev.next = del.next;
 
    }

    public Node push(Node head, int data) {
        /* allocate node */
        Node newNode=new Node(data);
        /* since we are adding at the beginning,
        prev is always NULL */
        newNode.prev=null;
        /* link the old list off the new node */
        newNode.next =head;
        /* change prev of head node to new node */
        if(head!=null)
        {
            head.prev=newNode;
        }
        head=newNode;
        return head;
    }

    public void printList(Node head) {
        if (head == null)
            System.out.println("Doubly Linked list empty");
         
        while (head != null)
        {
            System.out.print(head.data+" ") ;
            head = head.next;
        }
    }


    public void reverse(struct Node* head_ref) {
        struct Node* temp = NULL;
        struct Node* current = *head_ref;
    
        // swap next and prev for all nodes
        // of doubly linked list
        while (current != NULL) {
            temp = current->prev;
            current->prev = current->next;
            current->next = temp;
            current = current->prev;
        }
    
        // Before changing head, check for the cases
        // like empty list and list with only one node
        if (temp != NULL)
            head_ref = temp->prev;
    }

    public Node deleteAllOccurOfX(Node head, int x) {
        // if list is empty
        if (head == null)
            return null;
 
        Node current = head;
        Node next;
        Node deleteAllOccurOfX(Node head, int x)
        {
            // if list is empty
            if (head == null)
                return null;
     
            Node current = head;
            Node next;
     
            /* traverse the list up to the end */
            while (current != null)
            {
                // if node found with the value 'x'
                if (current.data == x)
                {
                         
                    /* save current's next node in the
                    pointer 'next' */
                    next = current.next;
     
                    /* delete the node pointed to by
                    'current' */
                    head = deleteNode(head, current);
     
                    /* update current */
                    current = next;
                }
     
                /* else simply move to the next node */
                else
                    current = current.next;
     
            }
     
            return head;
     
        }if (current.data == x)
            {
                     
                /* save current's next node in the
                pointer 'next' */
                next = current.next;
 
                /* delete the node pointed to by
                'current' */
                head = deleteNode(head, current);
 
                /* update current */
                current = next;
            }
 
            /* else simply move to the next node */
            else
                current = current.next;
 
        }
 
        return head;
 
    }

    public Node push (Node head, int new_data) {
        // allocate node
        Node new_node = new Node();
             
        // put in the data
        new_node.data = new_data;
 
        /* since we are adding at the beginning,
        prev is always NULL */
        new_node.prev = null;
 
        // link the old list off the new node
        new_node.next = head;
 
        // change prev of head node to new node
        if (head != null)
            head.prev = new_node;
 
        // move the head to point to the new node
        head = new_node;
         
        return head;
    }

    public void printList(struct Node* head) {
        /* if list is empty */
        if (head == NULL)
            cout << "Doubly Linked list empty";
    
        while (head != NULL) {
            cout << head->data << " ";
            head = head->next;
        }
    }

    public Node deleteNode(Node head_ref, Node del) {
        // base case
        if (head_ref == null || del == null)
            return head_ref;
    
        // If node to be deleted is head node
        if (head_ref == del)
            head_ref = del.next;
    
        // Change next only if node to be deleted
        // is NOT the last node
        if (del.next != null)
            del.next.prev = del.prev;
    
        // Change prev only if node to be deleted
        // is NOT the first node
        if (del.prev != null)
            del.prev.next = del.next;
        return head_ref;
    }


    public void removeDuplicates(struct Node** head_ref) {
        // if doubly linked list is empty
        if ((*head_ref) == NULL)
            return;
    
        // unordered_set 'us' implemented as hash table
        unordered_set<int> us;
    
        struct Node* current = *head_ref, *next;
    
        // traverse up to the end of the list
        while (current != NULL) {
    
            // if current data is seen before
            if (us.find(current->data) != us.end()) {
    
                // store pointer to the node next to
                // 'current' node
                next = current->next;
    
                // delete the node pointed to by 'current'
                deleteNode(head_ref, current);
    
                // update 'current'
                current = next;
            } else {
    
                // insert the current data in 'us'
                us.insert(current->data);
    
                // move to the next node
                current = current->next;
            }
        }
    }


    public void push(struct Node** head_ref, int new_data) {
        // allocate node
        struct Node* new_node =
            (struct Node*)malloc(sizeof(struct Node));
    
        // put in the data
        new_node->data = new_data;
    
        // since we are adding at the beginning,
        // prev is always NULL
        new_node->prev = NULL;
    
        // link the old list off the new node
        new_node->next = (*head_ref);
    
        // change prev of head node to new node
        if ((*head_ref) != NULL)
            (*head_ref)->prev = new_node;
    
        // move the head to point to the new node
        (*head_ref) = new_node;
    }

    public void printList(struct Node* head) {
        // if list is empty
        if (head == NULL)
            cout << "Doubly Linked list empty";
    
        while (head != NULL) {
            cout << head->data << " ";
            head = head->next;
        }
    }

    public void reverse(struct Node* head_ref) {
        struct Node* temp = NULL;
        struct Node* current = *head_ref;
    
        // swap next and prev for all nodes
        // of doubly linked list
        while (current != NULL) {
            temp = current->prev;
            current->prev = current->next;
            current->next = temp;
            current = current->prev;
        }
    
        // Before changing head, check for the cases
        // like empty list and list with only one node
        if (temp != NULL)
            head_ref = temp->prev;
    }

    
    public static Node merge(Node first, Node second) {
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

    public static Node sort(Node head) {
        // if list is empty or if it contains
        // a single node only
        if (head == null || head.next == null)
            return head;
    
        Node current = head.next;
    
        while (current != null)
        {
    
            // if true, then 'current' is the first node
            // which is smaller than its previous node
            if (current.data < current.prev.data)
                break;
    
            // move to the next node
            current = current.next;
        }
    
        // if true, then list is already sorted
        if (current == null)
            return head;
    
        // split into two lists, one starting with 'head'
        // and other starting with 'current'
        current.prev.next = null;
        current.prev = null;
    
        // reverse the list starting with 'current'
        current = reverse(current);
    
        // merge the two lists and return the
        // final merged doubly linked list
        return merge(head, current);
    }

    public static Node newNode(int val) {
        Node temp = new Node();
        temp.data = val;
        temp.prev = temp.next = null;
        return temp;
    }

    public void printList(Node head) {
        while (head.next != null)
        {
            System.out.print(head.data+ " <-> ");
            head = head.next;
        }
        System.out.println( head.data );
    }

    static Node insert(Node head, int val) {
        Node temp = newNode(val);
        temp.next = head;
        (head).prev = temp;
        (head) = temp;
        return head;
    }


    public Node reverseList(Node head) {
        Node left = head, right = head;
    
        // Traverse the list and set right pointer to
        // end of list
        while (right.next != null)
            right = right.next;
    
        // Swap data of left and right pointer and move
        // them towards each other until they meet or
        // cross each other
        while (left != right && left.prev != right)
        {
    
            // Swap data of left and right pointer
            int t = left.data;
            left.data = right.data;
            right.data = t;
    
            // Advance left pointer
            left = left.next;
    
            // Advance right pointer
            right = right.prev;
        }
        return head;
    }

    public Node push(Node head_ref, char new_data) {
        Node new_node = new Node();
        new_node.data = new_data;
        new_node.next = head_ref;
        new_node.prev = null;
        if (head_ref != null)
        head_ref.prev = new_node ;
        head_ref = new_node;
        return head_ref;
    }

    public boolean isPalindrome(Node left) {
        if (left == null)
        return true;
    
        // Find rightmost node
        Node right = left;
        while (right.next != null)
            right = right.next;
    
        while (left != right)
        {
            if (left.data != right.data)
                return false;
    
            left = left.next;
            right = right.prev;
        }
    
        return true;
    }


    public void insertEnd(int value) {
  
        // If the list is empty, create a single
        // node circular and doubly list
        if (start == null) {
            Node new_node = new Node();
            new_node.data = value;
            new_node.next = new_node.prev = new_node;
            start = new_node;
            return;
        }
    
        // If list is not empty
    
        // Find last node
        Node last = (start).prev;
    
        // Create Node dynamically
        Node new_node = new Node();
        new_node.data = value;
    
        // Start is going to be
        // next of new_node
        new_node.next = start;
    
        // Make new node previous of start
        (start).prev = new_node;
    
        // Make last previous of new node
        new_node.prev = last;
    
        // Make new node next of old last
        last.next = new_node;
    }

    public void insertAfter(int value1, int value2) {
        Node new_node = new Node();
        new_node.data = value1; // Inserting the data
    
        // Find node having value2 and next node of it
        Node temp = start;
        while (temp.data != value2)
            temp = temp.next;
        Node next = temp.next;
    
        // insert new_node between temp and next.
        temp.next = new_node;
        new_node.prev = temp;
        new_node.next = next;
        next.prev = new_node;
    }

    public void insertBegin(int value) {
        // Pointer points to last Node
        Node last = (start).prev;
  
        Node new_node = new Node();
        new_node.data = value; // Inserting the data
  
        // setting up previous and next of new node
        new_node.next = start;
        new_node.prev = last;
  
        // Update next and previous pointers of start
        // and last.
        last.next = (start).prev = new_node;
  
        // Update start pointer
        start = new_node;
    }

    public void insertAfter(int value1, int value2) {
        Node new_node = new Node();
        new_node.data = value1; // Inserting the data
    
        // Find node having value2 and next node of it
        Node temp = start;
        while (temp.data != value2)
            temp = temp.next;
        Node next = temp.next;
    
        // insert new_node between temp and next.
        temp.next = new_node;
        new_node.prev = temp;
        new_node.next = next;
        next.prev = new_node;
    }

    public void insertEnd(int value) {
        // If the list is empty, create a single node
        // circular and doubly list
        if (start == null) {
            Node new_node = new Node();
            new_node.data = value;
            new_node.next = new_node.prev = new_node;
            start = new_node;
            return;
        }
  
        // If list is not empty
  
        /* Find last node */
        Node last = (start).prev;
  
        // Create Node dynamically
        Node new_node = new Node();
        new_node.data = value;
  
        // Start is going to be next of new_node
        new_node.next = start;
  
        // Make new node previous of start
        (start).prev = new_node;
  
        // Make last previous of new node
        new_node.prev = last;
  
        // Make new node next of old last
        last.next = new_node;
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