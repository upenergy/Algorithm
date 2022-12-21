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

    public Node reverseUtil(Node curr, Node prev) {
        /*If head is initially null OR list is empty*/
        if (head == null)
            return head;
        /* If last node mark it head*/
        if (curr.next == null) {
            head = curr;
            /* Update next to prev node */
            curr.next = prev;
            return head;
        }
        /* Save curr->next node for recursive call */
        Node next1 = curr.next;
        /* and update next ..*/
        curr.next = prev;
        reverseUtil(next1, curr);
        return head;
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

    public Node reverse(Node head, int k) {
        if(head == null)
          return null;
        Node current = head;
        Node next = null;
        Node prev = null;
 
        int count = 0;
 
        /* Reverse first k nodes of linked list */
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
 
        /* next is now a pointer to (k+1)th node
           Recursively call for the list starting from
           current. And make rest of the list as next of
           first node */
        if (next != null)
            head.next = reverse(next, k);
 
        // prev is now head of input list
        return prev;
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

    public void display() {
        Node temp = start;
  
        System.out.printf(
            "\nTraversal in forward direction \n");
        while (temp.next != start) {
            System.out.printf("%d ", temp.data);
            temp = temp.next;
        }
        System.out.printf("%d ", temp.data);
  
        System.out.printf(
            "\nTraversal in reverse direction \n");
        Node last = start.prev;
        temp = last;
        while (temp.prev != last) {
            System.out.printf("%d ", temp.data);
            temp = temp.prev;
        }
        System.out.printf("%d ", temp.data);
    }
  
    public void printUnrolledList(Node n) {
        while (n != null)
        {
        
            // Print elements in current node
            for(int i = 0; i < n.numElements; i++)
                System.out.print(n.array[i] + " ");
    
            // Move to next node
            n = n.next;
        }
    }

    public void printUnrolledList(Node n) {
        while (n != null)
        {
        
            // Print elements in current node
            for(int i = 0; i < n.numElements; i++)
                System.out.print(n.array[i] + " ");
    
            // Move to next node
            n = n.next;
        }
    }

    public static Node createList(int arr[], int n) {
        Node head = null;
        Node tmp = null;
 
        // Traversing the passed array
        for (int i = 0; i < n; i++) {
 
            // Creating a node if the list
            // is empty
            if (head == null) {
                tmp = head = new Node();
            }
            else {
                tmp.next = new Node();
                tmp = tmp.next;
            }
 
            // Created a node with data and
            // setting child and next pointer
            // as NULL.
            tmp.data = arr[i];
            tmp.next = tmp.child = null;
        }
        return head;
    }

    public static void printMultiLevelList(Node head) {
 
        // While head is not null
        while (head != null) {
            if (head.child != null) {
                printMultiLevelList(head.child);
            }
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public int GetNth(int index) {
        Node current = head;
        int count = 0; /* index of Node we a`are
                          currently looking at */
        while (current != null)
        {
            if (count == index)
                return current.data;
            count++;
            current = current.next;
        }
 
        /* if we get to this line, the caller was asking
        for a non-existent element so we assert fail */
        assert (false);
        return 0;
    }

    
    public void push(int new_data) {
 
        /* 1. alloc the Node and put data*/
        Node newNode = new Node(newData);
 
        /* 2. Make next of new Node as head */
        newNode.next = head;
 
        /* 3. Move the head to point to new Node */
        head = new_Node;
    }


    public void printNthFromLast(int N) {
        int len = 0;
        Node temp = head;
 
        // 1) count the number of nodes in Linked List
        while (temp != null) {
            temp = temp.next;
            len++;
        }
 
        // check if value of N is not more than length of
        // the linked list
        if (len < N)
            return;
 
        temp = head;
 
        // 2) get the (len-N+1)th node from the beginning
        for (int i = 1; i < len - N + 1; i++)
            temp = temp.next;
 
        System.out.println(temp.data);
    }

    public Node getIntersectionNode(Node head1, Node head2) {
        while (head2 != null) {
            Node temp = head1;
            while (temp != null) {
                // if both Nodes are same
                if (temp == head2) {
                    return head2;
                }
                temp = temp.next;
            }
            head2 = head2.next;
        }
        // If intersection is not present between the lists,
        // return NULL.
        return null;
    }

    public Node addToEmpty(Node last, int data) {
        // This function is only for empty list
        if (last != null)
            return last;
    
        // Creating a node dynamically.
        Node temp = new Node();
    
        // Assigning the data.
        temp.data = data;
        last = temp;
        // Note : list was empty. We link single node
        // to itself.
        temp.next = last;
    
        return last;
    }

    public Node addBegin(Node last, int data) {
        if (last == null)
            return addToEmpty(last, data);
        
        Node temp = new Node();
        temp.data = data;
        temp.next = last.next;
        last.next = temp;
        return last;
    }

    public Node addEnd(Node last, int data) {
        if (last == null)
            return addToEmpty(last, data);
    
        // Creating a node dynamically.
        Node temp = new Node();
    
        // Assigning the data.
        temp.data = data;
    
        // Adjusting the links.
        temp.next = last.next;
        last.next = temp;
        last = temp;
    
        return last;
    }

    public Node addAfter(Node last, int data, int item) {
        if (last == null)
            return null;
    
        Node temp, p;
        p = last.next;
        do {
            if (p.data == item) {
                temp = new Node();
                temp.data = data;
                temp.next = p.next;
                p.next = temp;
    
                if (p == last)
                    last = temp;
                return last;
            }
            p = p.next;
        } while (p != last.next);
    
        System.out.println(item + " not present in the list.");
        return last;
    }

    public Node deleteKthNode(Node head, int k) {
        // If linked list is empty
        if (head == null)
            return null;
    
        if (k == 1)
        {
            head = freeList(head);
            return null;
        }
    
        // Initialize ptr and prev before 
        // starting traversal.
        Node ptr = head, prev = null;
    
        // Traverse list and delete 
        // every k-th node
        int count = 0;
        while (ptr != null)
        {
            // increment Node count
            count++;
    
            // check if count is equal to k
            // if yes, then delete current Node
            if (k == count)
            {
                // put the next of current Node in
                // the next of previous Node
                prev.next = ptr.next;
    
                // set count = 0 to reach further
                // k-th Node
                count = 0;
            }
    
            // update prev if count is not 0
            if (count != 0)
                prev = ptr;
    
            ptr = prev.next;
        }
        return head;
    }

    public void displayList(Node head){
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public void removeAllDuplicates() {
     
        // Create a dummy node that acts like a fake
        // head of list pointing to the original head
        Node dummy = new Node(0);
    
        // Dummy node points to the original head
        dummy.next = head;
        Node prev = dummy;
        Node current = head;
    
        while (current != null)
        {
            // Until the current and previous values
            // are same, keep updating current
            while (current.next != null &&
                prev.next.val == current.next.val)
                current = current.next;
    
            // If current has unique value i.e current
            // is not updated, Move the prev pointer
            // to next node
            if (prev.next == current)
                prev = prev.next;
    
            // When current is updated to the last
            // duplicate value of that segment, make
            // prev the next of current*/
            else
                prev.next = current.next;
    
            current = current.next;
        }
    
        // Update original head to the next of dummy
        // node
        head = dummy.next;
    }

    public void BToDLL(Node root) {
        // Base cases
        if (root == null)
            return;
  
        // Recursively convert right subtree
        BToDLL(root.right);
  
        // insert root into DLL
        root.right = head;
  
        // Change left pointer of previous head
        if (head != null)
            head.left = root;
  
        // Change head of Doubly linked list
        head = root;
  
        // Recursively convert left subtree
        BToDLL(root.left);
    }


    public void insertAfterNthNode(Node head, int n, int x) {
        // if list is empty
        if (head == null)
            return;
    
        // get a new node for the value 'x'
        Node newNode = getNode(x);
        Node ptr = head;
        int len = 0, i;
    
        // find length of the list, i.e, the
        // number of nodes in the list
        while (ptr != null)
        {
            len++;
            ptr = ptr.next;
        }
    
        // traverse up to the nth node from the end
        ptr = head;
        for (i = 1; i <= (len - n); i++)
            ptr = ptr.next;
    
        // insert the 'newNode' by making the
        // necessary adjustment in the links
        newNode.next = ptr.next;
        ptr.next = newNode;
    }




    public void reverseLL() {
 
        // Create a stack "s" of Node type
        Stack<Node> s = new Stack<>();
        Node temp = head;
        while (temp.next != null) {
            // Push all the nodes in to stack
            s.add(temp);
            temp = temp.next;
        }
        head = temp;
        while (!s.isEmpty()) {
            // Store the top value of stack in list
            temp.next = s.peek();
            // Pop the value from stack
            s.pop();
            // update the next pointer in the list
            temp = temp.next;
        }
        temp.next = null;
    }

    public void printReverse(Node head){
        if (head == null) return;
 
        // print list of head node
        printReverse(head.next);
 
        // After everything else is printed
        System.out.print(head.data+" ");
    }


    public Node kAltReverse(Node node, int k) {
        Node current = node;
        Node next = null, prev = null;
        int count = 0;
 
        /*1) reverse first k nodes of the linked list */
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
 
        /* 2) Now head points to the kth node.  So change next
         of head to (k+1)th node*/
        if (node != null) {
            node.next = current;
        }
 
        /* 3) We do not want to reverse next k nodes. So move the current
         pointer to skip next k nodes */
        count = 0;
        while (count < k - 1 && current != null) {
            current = current.next;
            count++;
        }
 
        /* 4) Recursively call for the list starting from current->next.
         And make rest of the list as next of first node */
        if (current != null) {
            current.next = kAltReverse(current.next, k);
        }
 
        /* 5) prev is new head of the input list */
        return prev;
    }
    

    public void rotate(int k) {
        if (k == 0)
            return;
 
        // Let us understand the below code for example k =
        // 4 and list = 10->20->30->40->50->60.
        Node current = head;
 
        // current will either point to kth or NULL after
        // this loop. current will point to node 40 in the
        // above example
        int count = 1;
        while (count < k && current != null) {
            current = current.next;
            count++;
        }
 
        // If current is NULL, k is greater than or equal to
        // count of nodes in linked list. Don't change the
        // list in this case
        if (current == null)
            return;
 
        // current points to kth node. Store it in a
        // variable. kthNode points to node 40 in the above
        // example
        Node kthNode = current;
 
        // current will point to last node after this loop
        // current will point to node 60 in the above
        // example
        while (current.next != null)
            current = current.next;
 
        // Change next of last node to previous head
        // Next of 60 is now changed to node 10
 
        current.next = head;
 
        // Change head to (k+1)th node
        // head is now changed to node 50
        head = kthNode.next;
 
        // change next of kth node to null
        kthNode.next = null;
    }


    public void push(int newData){
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node newNode = new Node(newData);
 
        /* 3. Make next of new Node as head */
        newNode.next = head;
 
        /* 4. Move the head to point to new Node */
        head = newNode;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void rotate(int k) {
        // let us consider the example
        // 10->20->30->40->50->60 - k=4
        // initialising 2 nodes temp and last
        Node last = head;
        Node temp = head;
         
        // if head is null or k==0 no rotation is required
        if (head == null || k == 0) {
            return;
        }
 
        // Making last point to the last-node of the given
        // linked list in this case 60
        while (last.next != null) {
            last = last.next;
        }
 
        // Rotating the linked list k times, one rotation at a
        // time.
        while (k != 0) {
      
            // Make head point to next of head
            // so in the example given above head becomes 20
            head = head.next;
      
            // Making next of temp as null
            // In the above example :10->null
            temp.next = null;
      
            // Making temp as last node
            // (head)20->30->40->50->60->10(last)
            last.next = temp;
            last = temp;
      
            // Point temp to head again for next rotation
            temp = head;
            k--;
        }
    }

    public Node getNode(int data) {
        // allocate memory for the node
        Node newNode = new Node();
    
        // put in the data
        newNode.data = data;
        newNode.next = null;
        return newNode;
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