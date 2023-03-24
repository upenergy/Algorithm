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
      ) {
    
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


    static Node sortedMerge(Node a, Node b)
    {
 
        // Reverse Linked List 'a'
        a = reverseList(a);
 
        // Reverse Linked List 'b'
        b = reverseList(b);
 
        // Initialize head of resultant list
        Node head = null;
 
        Node temp;
 
        // Traverse both lists while both of them
        // have nodes.
        while (a != null && b != null) {
 
            // If a's current value is greater than or equal
            // to b's current value.
            if (a.key >= b.key) {
 
                // Store next of current Node in first list
                temp = a.next;
 
                // Add 'a' at the front of resultant list
                a.next = head;
 
                // Make 'a' - head of the result list
                head = a;
 
                // Move ahead in first list
                a = temp;
            }
 
            // If b's value is greater. Below steps are
            // similar to above (Only 'a' is replaced with
            // 'b')
            else {
 
                temp = b.next;
                b.next = head;
                head = b;
                b = temp;
            }
        }
 
        // If second list reached end, but first list has
        // nodes. Add remaining nodes of first list at the
        // beginning of result list
        while (a != null) {
 
            temp = a.next;
            a.next = head;
            head = a;
            a = temp;
        }
 
        // If first list reached end, but second list has
        // nodes. Add remaining nodes of second list at the
        // beginning of result list
        while (b != null) {
 
            temp = b.next;
            b.next = head;
            head = b;
            b = temp;
        }
 
        // Return the head of the result list
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


    public void insertAfterNthNode(Node head, int x) {
 
        // Base case
        if (head == null)
            return;
 
        // recursively traverse till the last node
        insertAfterNthNode(head.next, x);
 
        // condition to insert the node after nth node from
        // end
        if (--n == 0) {
 
            // create a node with the given value
            Node temp = getNode(x);
 
            // update the next pointer to point next node in
            // the list
            temp.next = head.next;
 
            // make sure head points to newly inserted node
            head.next = temp;
        }
    }

    public void deleteNode(int position) {
        // If linked list is empty
        if (head == null)
            return;
 
        // Store head node
        Node temp = head;
 
        // If head needs to be removed
        if (position == 0) {
            head = temp.next; // Change head
            return;
        }
 
        // Find previous node of the node to be deleted
        for (int i = 0; temp != null && i < position - 1;
             i++)
            temp = temp.next;
 
        // If position is more than number of nodes
        if (temp == null || temp.next == null)
            return;
 
        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node next = temp.next.next;
 
        temp.next
            = next; // Unlink the deleted node from list
    }

    public void removeDuplicates() {
        Node ptr1 = null, ptr2 = null, dup = null;
        ptr1 = head;
 
        /* Pick elements one by one */
        while (ptr1 != null && ptr1.next != null) {
            ptr2 = ptr1;
 
            /* Compare the picked element with rest
                of the elements */
            while (ptr2.next != null) {
 
                /* If duplicate then delete it */
                if (ptr1.data == ptr2.next.data) {
 
                    /* sequence of steps is important here
                     */
                    ptr2.next = ptr2.next.next;
                    System.gc();
                }
                else /* This is tricky */ {
                    ptr2 = ptr2.next;
                }
            }
            ptr1 = ptr1.next;
        }
    }

    public void removeDuplicate(node head) {
        // Hash to store seen values
        HashSet<Integer> hs = new HashSet<>();
 
        /* Pick elements one by one */
        node current = head;
        node prev = null;
        while (current != null) {
            int curval = current.val;
 
            // If current value is seen before
            if (hs.contains(curval)) {
                prev.next = current.next;
            }
            else {
                hs.add(curval);
                prev = current;
            }
            current = current.next;
        }
    }


    public void skipMdeleteN( Node head, int M, int N) {
        Node curr = head, t;
        int count;
    
        // The main loop that traverses
        // through the whole list
        while (curr!=null)
        {
            // Skip M nodes
            for (count = 1; count < M && curr != null; count++)
                curr = curr.next;
    
            // If we reached end of list, then return
            if (curr == null)
                return;
    
            // Start from next node and delete N nodes
            t = curr.next;
            for (count = 1; count <= N && t != null; count++)
            {
                Node temp = t;
                t = t.next;
            }
            
            // Link the previous list with remaining nodes
            curr.next = t;
    
            // Set current pointer for next iteration
            curr = t;
        }
    }

    public Node deleteLast(Node head,int x) {
        Node temp = head;
        Node ptr = null;
        
        while (temp != null)
        {
            
            // If found key, update
            if (temp.data == x)
                ptr = temp;
                
            temp = temp.next;
        }
        
        // If the last occurrence is the last node
        if (ptr != null && ptr.next == null)
        {
            temp = head;
            
            while (temp.next != ptr)
            {
                temp = temp.next;
            }
            temp.next = null;
        }
        
        // If it is not the last node
        if (ptr != null && ptr.next != null)
        {
            ptr.data = ptr.next.data;
            temp = ptr.next;
            ptr.next = ptr.next.next;
        }
        return head;
    }


    public void display(Node head) {
        Node temp = head;
        if (head == null)
        {
            System.out.print("NULL\n");
            return;
        }
        while (temp != null)
        {
            System.out.print( temp.data+" --> ");
            temp = temp.next;
        }
        System.out.print("NULL\n");
    }

    public Node deleteLast(Node head, int key) {
        // Initialize previous of Node to be deleted 
        Node x = null; 
    
        // Start from head and find the Node to be 
        // deleted 
        Node temp = head; 
        while (temp != null) 
        { 
            // If we found the key, update xv 
            if (temp.key == key) 
                x = temp; 
    
            temp = temp.next; 
        } 
    
        // key occurs at-least once 
        if (x != null) 
        { 
    
            // Copy key of next Node to x 
            x.key = x.next.key; 
    
            // Store and unlink next 
            temp = x.next; 
            x.next = x.next.next; 
    
            // Free memory for next 
        } 
        return head;
    }

    public void display(Node head) {
        Node temp = head;
        if (head == null)
        {
            System.out.print("NULL\n");
            return;
        }
        while (temp != null)
        {
            System.out.print( temp.data+" --> ");
            temp = temp.next;
        }
        System.out.print("NULL\n");
    }

    public Node newNode(int key) { 
        Node temp = new Node(); 
        temp.key = key; 
        temp.next = null; 
        return temp; 
    }


    public void removeAllDuplicates() {
     
        // Create a dummy node that acts like a fake
        // head of list pointing to the original head
        Node dummy = new Node(0);
    
        // Dummy node points to the original head
        dummy.next = head;
        Node prev = dummy;
        Node current = head;
    
        while (current != null) {
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


    public Node newNode(int x) {
        Node temp = new Node();
        temp.data = x;
        temp.next = null;
        return temp;
    }

    public Node freeList(Node node) {
        while (node != null)
        {
            Node next = node.next;
            node = next;
        }
        return node;
    }

    public Node reverselist(Node node) {
        Node prev = null, curr = node, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node = prev;
        return node;
    }

    public void rearrange(Node node) {
 
        // 1) Find the middle point using tortoise and hare
        // method
        Node slow = node, fast = slow.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
 
        // 2) Split the linked list in two halves
        // node1, head of first half    1 -> 2 -> 3
        // node2, head of second half   4 -> 5
        Node node1 = node;
        Node node2 = slow.next;
        slow.next = null;
 
        // 3) Reverse the second half, i.e., 5 -> 4
        node2 = reverselist(node2);
 
        // 4) Merge alternate nodes
        node = new Node(0); // Assign dummy Node
 
        // curr is the pointer to this dummy Node, which
        // will be used to form the new list
        Node curr = node;
        while (node1 != null || node2 != null) {
 
            // First add the element from first list
            if (node1 != null) {
                curr.next = node1;
                curr = curr.next;
                node1 = node1.next;
            }
 
            // Then add the element from second list
            if (node2 != null) {
                curr.next = node2;
                curr = curr.next;
                node2 = node2.next;
            }
        }
 
        // Assign the head of the new list to head pointer
        node = node.next;
    }

    public void reorderListUtil(Node right) {
 
        if (right == null) {
            return;
        }
 
        reorderListUtil(right.next);
 
        // we set left = null, when we reach stop condition,
        // so no processing required after that
        if (left == null) {
            return;
        }
 
        // Stop condition: odd case : left = right, even
        // case : left.next = right
        if (left != right && left.next != right) {
            Node temp = left.next;
            left.next = right;
            right.next = temp;
            left = temp;
        }
        else { // stop condition , set null to left nodes
            if (left.next == right) {
                left.next.next = null; // even case
                left = null;
            }
            else {
                left.next = null; // odd case
                left = null;
            }
        }
    }

    public Node rearrangeEvenOdd(Node head) { 
        if (head == null) 
            return null; 
    
        // Initialize first nodes of even and 
        // odd lists 
        Node odd = head; 
        Node even = head.next; 
    
        // Remember the first node of even list so 
        // that we can connect the even list at the 
        // end of odd list. 
        Node evenFirst = even; 
    
        while (1 == 1) { 
            // If there are no more nodes,  
            // then connect first node of even  
            // list to the last node of odd list 
            if (odd == null || even == null ||
                            (even.next) == null) 
            { 
                odd.next = evenFirst; 
                break; 
            } 
    
            // Connecting odd nodes 
            odd.next = even.next; 
            odd = even.next; 
    
            // If there are NO more even nodes  
            // after current odd. 
            if (odd.next == null) 
            { 
                even.next = null; 
                odd.next = evenFirst; 
                break; 
            } 
    
            // Connecting even nodes 
            even.next = odd.next; 
            even = odd.next; 
        } 
        return head; 
    }

    public Node deleteEvenNodes(Node param) {
		    Node ptr = param;
		    Node next;
		 
		    while (ptr != null)
		    {
		        next = ptr.next;
		         
		        // if true, delete node 'ptr'
		        if (ptr.data % 2 == 0)
		            deleteNode(param, ptr);
		        ptr = next;
		    }
		    return param;
		}
		
		public static boolean isEvenParity(int x) {
	    // parity will store the
	    // count of set bits
	    int parity = 0;
	    while (x != 0) {
	      if (x % 2 == 1)
	        parity++;
	      x = x >> 1;
	    }
	 
	    if (parity % 2 == 0)
	      return true;
	    else
	      return false;
	  }
		
		
		public static void deleteEvenParityNodes() {
	    Node ptr = head;
	    Node next;
	 
	    // Iterating through
	    // the linked list
	    while (ptr != null) {
	      next = ptr.next;
	 
	      // If node's data's parity
	      // is even
	      if (isEvenParity(ptr.data)) {
	        deleteNode(ptr);
	      }
	      ptr = next;
    }

    public void zigZagList(Node head) {
        // If flag is true, then
        // next node should be greater
        // in the desired output.
        boolean flag = true;
 
        // Traverse linked list starting from head.
        Node current = head;
        while (current != null && current.next != null) {
            if (flag == true) /* "<" relation expected */
            {
                /* If we have a situation like A > B > C
            where A, B and C are consecutive Nodes
            in list we get A > B < C by swapping B
            and C */
                if (current.data > current.next.data) {
                    temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
            }
            else /* ">" relation expected */
            {
                /* If we have a situation like A < B < C where
            A, B and C are consecutive Nodes in list we
            get A < C > B by swapping B and C */
                if (current.data < current.next.data) {
                    temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
            }
 
            current = current.next;
 
            /* flip flag for reverse checking */
            flag = !(flag);
        }
    }


    public void printLL(){
        Node t = head;
        while (t != null) {
            System.out.print(t.data + " ->");
            t = t.next;
        }
        System.out.println();
    }

    /** Rearrange the linked list */
    public Node zigZag(Node node, int flag) {
        if (node == null || node.next == null) {
            return node;
        }
        if (flag == 0) {
            if (node.data > node.next.data) {
                swap(node, node.next);
            }
            return zigZag(node.next, 1);
        }
        else {
            if (node.data < node.next.data) {
                swap(node, node.next);
            }
            return zigZag(node.next, 0);
        }
    }

    public static void alternateSort(LinkedList<Integer> ll) {
        Collections.sort(ll);
         
        for (int i = 1; i < (ll.size() + 1)/2; i++)
        {
            Integer x = ll.getLast();
            ll.removeLast();
            ll.add(2*i - 1, x);
        }
         
        System.out.println(ll);
    }

    public class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }

    public void setMiddleHead() {
        if (head == null)
            return;
      
        // To traverse list nodes one
        // by one
        Node one_node = head;
      
        // To traverse list nodes by
        // skipping one.
        Node two_node = head;
      
        // To keep track of previous of middle
        Node prev = null;
        while (two_node != null &&
               two_node.next != null) {
      
            /* for previous node of middle node */
            prev = one_node;
      
            /* move one node each time*/
            two_node = two_node.next.next;
      
            /* move two node each time*/
            one_node = one_node.next;
        }
      
        /* set middle node at head */
        prev.next = prev.next.next;
        one_node.next = head;
        head = one_node;
    }

    public Node flatten(Node root) {
        // Base Cases
        if (root == null || root.right == null)
            return root;
 
        // recur for list on right
        root.right = flatten(root.right);
 
        // now merge
        root = merge(root, root.right);
 
        // return the root
        // it will be in turn merged with its left
        return root;
    }

    public void alternateSort(LinkedList<Integer> ll){
        Collections.sort(ll);
         
        for (int i = 1; i < (ll.size() + 1)/2; i++)
        {
            Integer x = ll.getLast();
            ll.removeLast();
            ll.add(2*i - 1, x);
        }
         
        System.out.println(ll);
    }


    public class Node {
         
        int data;
        Node next, child;
         
        Node(int d) {
            data = d;
            next = child = null;
        }
    }

    public void flattenList(Node node) {
         
        /*Base case*/
        if (node == null) {
            return;
        }
         
        Node tmp = null;
 
        /* Find tail node of first level linked list */
        Node tail = node;
        while (tail.next != null) {
            tail = tail.next;
        }
 
        // One by one traverse through all nodes of first level
        // linked list till we reach the tail node
        Node cur = node;
        while (cur != tail) {
 
            // If current node has a child
            if (cur.child != null) {
 
                // then append the child at the end of current list
                tail.next = cur.child;
 
                // and update the tail to new last node
                tmp = cur.child;
                while (tmp.next != null) {
                    tmp = tmp.next;
                }
                tail = tmp;
            }
 
            // Change current node
            cur = cur.next;
        }
    }


    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        }
        else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }

    public boolean isPresent(Node head, int data) {
        Node t = head;
        while (t != null) {
            if (t.data == data)
                return true;
            t = t.next;
        }
        return false;
    }
    
    public void addToTheLast(Node node){
        if (head == null) {
            head = node;
        }
        else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }

    public void mergeLists(Node a, Node b) {
        // run till either one of a or b runs out
        while (a != null && b != null) {
            // for each element of LL1,
            // compare it with first element of LL2.
            if (a.data > b.data) {
                // swap the two elements involved
                // if LL1 has a greater element
                int temp = a.data;
                a.data = b.data;
                b.data = temp;
 
                Node temp2 = b;
 
                // To keep LL2 sorted, place first
                // element of LL2 at its correct place
                if (b.next != null
                    && b.data > b.next.data) {
                    b = b.next;
                    Node ptr = b;
                    Node prev = null;
 
                    // find mismatch by traversing the
                    // second linked list once
                    while (ptr != null
                           && ptr.data < temp2.data) {
                        prev = ptr;
                        ptr = ptr.next;
                    }
 
                    // correct the pointers
                    prev.next = temp2;
                    temp2.next = ptr;
                }
            }
 
            // move LL1 pointer to next element
            a = a.next;
        }
    }

    public void getUnion(Node head1, Node head2) {
        Node t1 = head1, t2 = head2;
 
        // insert all elements of list1 in the result
        while (t1 != null) {
            push(t1.data);
            t1 = t1.next;
        }
 
        // insert those elements of list2
        // that are not present
        while (t2 != null) {
            if (!isPresent(head, t2.data))
                push(t2.data);
            t2 = t2.next;
        }
    }

    public int maxNodeLevel(Node root) {
        if (root == null)
            return -1;
    
        Queue<Node> q = new LinkedList<Node> ();
        q.add(root);
    
        // Current level
        int level = 0;
    
        // Maximum Nodes at same level
        int max = Integer.MIN_VALUE;
    
        // Level having maximum Nodes
        int level_no = 0;
    
        while (true)
        {
            // Count Nodes in a level
            int NodeCount = q.size();
    
            if (NodeCount == 0)
                break;
    
            // If it is maximum till now
            // Update level_no to current level
            if (NodeCount > max)
            {
                max = NodeCount;
                level_no = level;
            }
    
            // Pop complete current level
            while (NodeCount > 0)
            {
                Node Node = q.peek();
                q.remove();
                if (Node.left != null)
                    q.add(Node.left);
                if (Node.right != null)
                    q.add(Node.right);
                NodeCount--;
            }
    
            // Increment for next level
            level++;
        }
    
        return levelNo;
    }

    public void dfs(Node root, Map<Integer, Integer> unmap, int depth){
        if(root == null) return;
         
        // Increment the count of nodes at depth in map
        if(unmap.containsKey(depth)){
            unmap.put(depth, unmap.get(depth)+1);
        }else{
            unmap.put(depth, 1);
        }
        // unmap.put(depth, unmap.get(depth) + 1);
        dfs(root.left, unmap, depth+1);
        dfs(root.right, unmap, depth+1);
    }

    public int maxNodeLevel(Node root) {
        Map<Integer, Integer> unmap = new HashMap<Integer, Integer>();
        dfs(root, unmap, 0);
        int maxx = Integer.MIN_VALUE;
        int result = 0;
         
        for(Integer i : unmap.keySet()){
            if(unmap.get(i) > maxx){
                result = i;
                maxx = unmap.get(i);
            }
            else if(unmap.get(i) == maxx){
                result = Math.min(result, i);
            }
            // System.out.println(i + " -> " + unmap.get(i));
        }
        return result;
    }

    public void graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    public Boolean isReachable(int s, int d) {
        LinkedList<Integer>temp;
 
        // Mark all the vertices as not visited(By default set
        // as false)
        boolean visited[] = new boolean[V];
 
        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
 
        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);
 
        // 'i' will be used to get all adjacent vertices of a vertex
        Iterator<Integer> i;
        while (queue.size()!=0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
 
            int n;
            i = adj[s].listIterator();
 
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            while (i.hasNext())
            {
                n = i.next();
 
                // If this adjacent node is the destination node,
                // then return true
                if (n==d)
                    return true;
 
                // Else, continue to do BFS
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
 
        // If BFS is complete without visited d
        return false;
    }

    public boolean dfs(int start, int end) {
        if (start == end){
            return true;
        }
 
        visited[start] = 1;
        for(int i = 0; i < adj[start].size(); i++){
            int x = adj[start].get(i);
            if (visited[x] == 0){
                if (dfs(x, end)){
                    return true;
                }
            }
        }
        return false;
    }

    public Node nextRight(Node first, int k) {
        // Base Case
        if (first == null)
            return null;
  
        // Create an empty queue for level order traversal
        // A queue to store node addresses
        Queue<Node> qn = new LinkedList<Node>();
         
        // Another queue to store node levels
        Queue<Integer> ql = new LinkedList<Integer>();  
  
        int level = 0;  // Initialize level as 0
  
        // Enqueue Root and its level
        qn.add(first);
        ql.add(level);
  
        // A standard BFS loop
        while (qn.size() != 0)
        {
            // dequeue an node from qn and its level from ql
            Node node = qn.peek();
            level = ql.peek();
            qn.remove();
            ql.remove();
  
            // If the dequeued node has the given key k
            if (node.data == k)
            {
                // If there are no more items in queue or given node is
                // the rightmost node of its level, then return NULL
                if (ql.size() == 0 || ql.peek() != level)
                    return null;
  
                // Otherwise return next node from queue of nodes
                return qn.peek();
            }
  
            // Standard BFS steps: enqueue children of this node
            if (node.left != null)
            {
                qn.add(node.left);
                ql.add(level + 1);
            }
            if (node.right != null)
            {
                qn.add(node.right);
                ql.add(level + 1);
            }
        }
  
        // We reach here if given key x doesn't exist in tree
        return null;
    }
 
    public boolean isInside(int x, int y, int N) {
        if (x >= 1 && x <= N && y >= 1 && y <= N)
            return true;
        return false;
    }

    public int minStepToReachTarget(int knightPos[],
                                    int targetPos[], int N) {
        // x and y direction, where a knight can move
        int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
        int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
 
        // queue for storing states of knight in board
        Queue<cell> q = new LinkedList<>();
 
        // push starting position of knight with 0 distance
        q.add(new cell(knightPos[0], knightPos[1], 0));
 
        cell t;
        int x, y;
        boolean visit[][] = new boolean
            [N + 1][N + 1]; // default initialized to false
 
        // visit starting state
        visit[knightPos[0]][knightPos[1]] = true;
 
        // loop until we have one element in queue
        while (!q.isEmpty()) {
            t = q.poll();
 
            // if current cell is equal to target cell,
            // return its distance
            if (t.x == targetPos[0] && t.y == targetPos[1])
                return t.dis;
 
            // loop for all reachable states
            for (int i = 0; i < 8; i++) {
                x = t.x + dx[i];
                y = t.y + dy[i];
 
                // If reachable state is not yet visited and
                // inside board, push that state into queue
                if (isInside(x, y, N) && !visit[x][y]) {
                    visit[x][y] = true;
                    q.add(new cell(x, y, t.dis + 1));
                }
            }
        }
        return Integer.MAX_VALUE;
    }
    
    public Boolean isReachable(int s, int d){
        LinkedList<Integer>temp;
 
        // Mark all the vertices as not visited(By default set
        // as false)
        boolean visited[] = new boolean[V];
 
        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
 
        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);
 
        // 'i' will be used to get all adjacent vertices of a vertex
        Iterator<Integer> i;
        while (queue.size()!=0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
 
            int n;
            i = adj[s].listIterator();
 
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            while (i.hasNext())
            {
                n = i.next();
 
                // If this adjacent node is the destination node,
                // then return true
                if (n==d)
                    return true;
 
                // Else, continue to do BFS
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
 
        // If BFS is complete without visited d
        return false;
    }

    public void printNodes(Node root, int start, int end, List<List<Integer>> ans, int level) {
        if (root == null) {
            return;
        }
        printNodes(root.left, start, end, ans, level + 1);
        if (level >= start && level <= end) {
            ans.get(level - start).add(root.data);
        }
        printNodes(root.right, start, end, ans, level + 1);
    }

    public Node nextRight(Node first, int k){
        // Base Case
        if (first == null)
            return null;
  
        // Create an empty queue for level order traversal
        // A queue to store node addresses
        Queue<Node> qn = new LinkedList<Node>();
         
        // Another queue to store node levels
        Queue<Integer> ql = new LinkedList<Integer>();  
  
        int level = 0;  // Initialize level as 0
  
        // Enqueue Root and its level
        qn.add(first);
        ql.add(level);
  
        // A standard BFS loop
        while (qn.size() != 0)
        {
            // dequeue an node from qn and its level from ql
            Node node = qn.peek();
            level = ql.peek();
            qn.remove();
            ql.remove();
  
            // If the dequeued node has the given key k
            if (node.data == k)
            {
                // If there are no more items in queue or given node is
                // the rightmost node of its level, then return NULL
                if (ql.size() == 0 || ql.peek() != level)
                    return null;
  
                // Otherwise return next node from queue of nodes
                return qn.peek();
            }
  
            // Standard BFS steps: enqueue children of this node
            if (node.left != null)
            {
                qn.add(node.left);
                ql.add(level + 1);
            }
            if (node.right != null)
            {
                qn.add(node.right);
                ql.add(level + 1);
            }
        }
  
        // We reach here if given key x doesn't exist in tree
        return null;
    }

    static boolean isSafe(int mat[][], int i, int j,
                       boolean vis[][]){
        return (i >= 0) && (i < R) &&
            (j >= 0) && (j < C) &&
            (mat[i][j]==1 && !vis[i][j]);
    }

    public void BFS(int mat[][], boolean vis[][],
                int si, int sj) {
 
        // These arrays are used to get row and
        // column numbers of 8 neighbours of
        // a given cell
        int row[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int col[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
    
        // Simple BFS first step, we enqueue
        // source and mark it as visited
        Queue<pair> q = new LinkedList<pair>();
        q.add(new pair(si, sj));
        vis[si][sj] = true;
    
        // Next step of BFS. We take out
        // items one by one from queue and
        // enqueue their unvisited adjacent
        while (!q.isEmpty())
        {
    
            int i = q.peek().first;
            int j = q.peek().second;
            q.remove();
    
            // Go through all 8 adjacent
            for (int k = 0; k < 8; k++)
            {
                if (isSafe(mat, i + row[k],
                        j + col[k], vis))
                {
                    vis[i + row[k]][j + col[k]] = true;
                    q.add(new pair(i + row[k], j + col[k]));
                }
            }
        }
    }

    public int countIslands(int mat[][]) {
        // Mark all cells as not visited
        boolean [][]vis = new boolean[R][C];
    
        // Call BFS for every unvisited vertex
        // Whenever we see an univisted vertex,
        // we increment res (number of islands)
        // also.
        int res = 0;
        for (int i = 0; i < R; i++)
        {
            for (int j = 0; j < C; j++)
            {
                if (mat[i][j]==1 && !vis[i][j])
                {
                    BFS(mat, vis, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void levelOrder(Node root) {
        if (root == null)
        return;
    
        Queue<Node> q = new LinkedList<>();
    
        // Pushing root node into the queue.
        q.add(root);
    
        // Pushing delimiter into the queue.
        q.add(null);
    
        // Executing loop till queue becomes
        // empty
        while (!q.isEmpty()) {
    
        Node curr = q.poll();
    
        // condition to check the
        // occurrence of next level
        if (curr == null) {
            if (!q.isEmpty()) {
            q.add(null);
            System.out.println();
            }
        } else {
            // Pushing left child current node
            if (curr.left != null)
            q.add(curr.left);
    
            // Pushing right child current node
            if (curr.right != null)
            q.add(curr.right);
    
            System.out.print(curr.data + " ");
        }
        }
    }
    
    public String FirstNonRepeating(String A) {
          // Arraylist to keep track of current unique characters
          // Hashmap to keep track of character encountered at least once
          ArrayList<Character> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
 
        for (char ch : A.toCharArray()) {
            if (!map.containsKey(ch)) { // any new character encountered first time
                list.add(ch);
                map.put(ch, 1);
            }
            else {
                  //any repeated character encountered
                int index = list.indexOf(ch);
               
                // for any repeated character encountered more than twice the
                  // index will be -1
                if (index != -1)
                      list.remove(index);
            }
            sb.append(list.isEmpty() ? '#' : list.get(0));
        }
        return sb.toString();
    }

    public void findFirstNonRepeating() {
        // inDLL[x] contains pointer to a DLL node if x is
        // present in DLL. If x is not present, then
        // inDLL[x] is NULL
        List<Character> inDLL = new ArrayList<Character>();
 
        // repeated[x] is true if x is repeated two or more
        // times. If x is not seen so far or x is seen only
        // once. then repeated[x] is false
        boolean[] repeated = new boolean[MAX_CHAR];
 
        // Let us consider following stream and see the
        // process
        String stream = "geeksforgeeksandgeeksquizfor";
        for (int i = 0; i < stream.length(); i++) {
            char x = stream.charAt(i);
            System.out.println("Reading " + x
                               + " from stream \n");
 
            // We process this character only if it has not
            // occurred or occurred only once. repeated[x]
            // is true if x is repeated twice or more.s
            if (!repeated[x]) {
                // If the character is not in DLL, then add
                // this at the end of DLL.
                if (!(inDLL.contains(x))) {
                    inDLL.add(x);
                }
                else // Otherwise remove this character from
                     // DLL
                {
                    inDLL.remove((Character)x);
                    repeated[x]
                        = true; // Also mark it as repeated
                }
            }
 
            // Print the current first non-repeating
            // character from stream
            if (inDLL.size() != 0) {
                System.out.print(
                    "First non-repeating character so far is ");
                System.out.println(inDLL.get(0));
            }
        }
    }

    public static String firstNonRepeatingChar(String input_stream) {
        // Step 1: Create a count array of size 26 to store
        // the frequency of each character.
        int[] count = new int[26];
 
        // Step 2: Create a queue to store the characters in
        // the input stream.
        Queue<Character> q = new LinkedList<>();
 
        // Step 3: Initialize an empty string as the answer.
        String answer = "";
 
        for (char c : input_stream.toCharArray()) {
            // Step 4: For each character in the input
            // stream, add it to the queue and increment its
            // frequency in the count array.
            count++;
            q.add(c);
 
            while (!q.isEmpty()
                   && count[q.peek() - 'a'] > 1) {
                // Step 5: While the queue is not empty,
                // check if the frequency of the front
                // character in the queue is 1.
                q.remove();
            }
 
            if (q.isEmpty()) {
                // Step 7: If there are no characters left
                // in the queue, append '#' to the answer.
                answer += '#';
            }
            else {
                // Step 6: If the frequency is 1, append the
                // character to the answer.
                answer += q.peek();
            }
        }
 
        // Step 8: Return the answer.
        return answer;
    }

    public void printKMax(int arr[], int N, int K) {
        int j, max;
 
        for (int i = 0; i <= N - K; i++) {
 
            max = arr[i];
 
            for (j = 1; j < K; j++) {
                if (arr[i + j] > max)
                    max = arr[i + j];
            }
            System.out.print(max + " ");
        }
    }

    public boolean issafe(int i, int j) {
        if (i >= 0 && i < R && j >= 0 && j < C)
            return true;
 
        return false;
    }

    public void floodFill(int[][] screen, int m, int n, int x, int y, int prevC, int newC) {
        Vector<Point> queue = new Vector<Point>();
   
        // Append the position of starting
        // pixel of the component
        queue.add(new Point(x, y));
   
        // Color the pixel with the new color
        screen[x][y] = newC;
   
        // While the queue is not empty i.e. the
        // whole component having prevC color
        // is not colored with newC color
        while(queue.size() > 0)
        {
            // Dequeue the front node
            Point currPixel = queue.get(queue.size() - 1);
            queue.remove(queue.size() - 1);
   
            int posX = currPixel.x;
            int posY = currPixel.y;
   
            // Check if the adjacent
            // pixels are valid
            if(isValid(screen, m, n, posX + 1, posY, prevC, newC))
            {
                // Color with newC
                // if valid and enqueue
                screen[posX + 1][posY] = newC;
                queue.add(new Point(posX + 1, posY));
            }
   
            if(isValid(screen, m, n, posX-1, posY, prevC, newC))
            {
                screen[posX-1][posY]= newC;
                queue.add(new Point(posX-1, posY));
            }
   
            if(isValid(screen, m, n, posX, posY + 1, prevC, newC))
            {
                screen[posX][posY + 1]= newC;
                queue.add(new Point(posX, posY + 1));
            }
   
            if(isValid(screen, m, n, posX, posY-1, prevC, newC))
            {
                screen[posX][posY-1]= newC;
                queue.add(new Point(posX, posY-1));
            }
        }
    }

    public int rotOranges(int v[][]) {
        boolean changed = false;
        int no = 2;
 
        while (true) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
 
                    // Rot all other oranges present at
                    // (i+1, j), (i, j-1), (i, j+1), (i-1,
                    // j)
                    if (v[i][j] == no) {
                        if (issafe(i + 1, j)
                            && v[i + 1][j] == 1) {
                            v[i + 1][j] = v[i][j] + 1;
                            changed = true;
                        }
                        if (issafe(i, j + 1)
                            && v[i][j + 1] == 1) {
                            v[i][j + 1] = v[i][j] + 1;
                            changed = true;
                        }
                        if (issafe(i - 1, j)
                            && v[i - 1][j] == 1) {
                            v[i - 1][j] = v[i][j] + 1;
                            changed = true;
                        }
                        if (issafe(i, j - 1)
                            && v[i][j - 1] == 1) {
                            v[i][j - 1] = v[i][j] + 1;
                            changed = true;
                        }
                    }
                }
            }
 
            // If no rotten orange found it means all
            // oranges rottened now
            if (!changed)
                break;
 
            changed = false;
            no++;
        }
 
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
 
                // If any orange is found to be
                // not rotten then ans is not possible
                if (v[i][j] == 1)
                    return -1;
            }
        }
 
        // Because initial value for a rotten
        // orange was 2
        return no - 2;
    }

    public class Ele {
        int x = 0;
        int y = 0;
        Ele(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    public boolean isDelim(Ele temp) {
        return (temp.x == -1 && temp.y == -1);
    }

    public boolean checkAll(int arr[][]) {
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (arr[i][j] == 1)
                    return true;
        return false;
    }

    public int rotOranges(int arr[][]) {
        // Create a queue of cells
        Queue<Ele> Q = new LinkedList<>();
        Ele temp;
        int ans = 0;
        // Store all the cells having rotten orange in first
        // time frame
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (arr[i][j] == 2)
                    Q.add(new Ele(i, j));
 
        // Separate these rotten oranges from the oranges
        // which will rotten due the oranges in first time
        // frame using delimiter which is (-1, -1)
        Q.add(new Ele(-1, -1));
 
        // Process the grid while there are rotten oranges
        // in the Queue
        while (!Q.isEmpty()) {
            // This flag is used to determine whether even a
            // single fresh orange gets rotten due to rotten
            // oranges in the current time frame so we can
            // increase the count of the required time.
            boolean flag = false;
 
            // Process all the rotten oranges in current
            // time frame.
            while (!isDelim(Q.peek())) {
                temp = Q.peek();
 
                // Check right adjacent cell that if it can
                // be rotten
                if (isValid(temp.x + 1, temp.y)
                    && arr[temp.x + 1][temp.y] == 1) {
                    if (!flag) {
                        // if this is the first orange to
                        // get rotten, increase count and
                        // set the flag.
                        ans++;
                        flag = true;
                    }
                    // Make the orange rotten
                    arr[temp.x + 1][temp.y] = 2;
 
                    // push the adjacent orange to Queue
                    temp.x++;
                    Q.add(new Ele(temp.x, temp.y));
 
                    // Move back to current cell
                    temp.x--;
                }
 
                // Check left adjacent cell that if it can
                // be rotten
                if (isValid(temp.x - 1, temp.y)
                    && arr[temp.x - 1][temp.y] == 1) {
                    if (!flag) {
                        ans++;
                        flag = true;
                    }
                    arr[temp.x - 1][temp.y] = 2;
                    temp.x--;
                    Q.add(new Ele(
                        temp.x,
                        temp.y)); // push this cell to Queue
                    temp.x++;
                }
 
                // Check top adjacent cell that if it can be
                // rotten
                if (isValid(temp.x, temp.y + 1)
                    && arr[temp.x][temp.y + 1] == 1) {
                    if (!flag) {
                        ans++;
                        flag = true;
                    }
                    arr[temp.x][temp.y + 1] = 2;
                    temp.y++;
                    Q.add(new Ele(
                        temp.x,
                        temp.y)); // Push this cell to Queue
                    temp.y--;
                }
 
                // Check bottom adjacent cell if it can be
                // rotten
                if (isValid(temp.x, temp.y - 1)
                    && arr[temp.x][temp.y - 1] == 1) {
                    if (!flag) {
                        ans++;
                        flag = true;
                    }
                    arr[temp.x][temp.y - 1] = 2;
                    temp.y--;
                    Q.add(new Ele(
                        temp.x,
                        temp.y)); // push this cell to Queue
                }
                Q.remove();
            }
            // Pop the delimiter
            Q.remove();
 
            // If oranges were rotten in current frame than
            // separate the rotten oranges using delimiter
            // for the next frame for processing.
            if (!Q.isEmpty()) {
                Q.add(new Ele(-1, -1));
            }
 
            // If Queue was empty than no rotten oranges
            // left to process so exit
        }
 
        // Return -1 if all arranges could not rot,
        // otherwise ans
        return (checkAll(arr)) ? -1 : ans;
    }


    public ArrayList<Integer> slidingMaximum(int a[], int b, int N) {
        // s2 for push
        // s1 for pop
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<node> s1 = new Stack<>(), s2 = new Stack<>();
 
        // shifting all value except the last one if first
        // window
        for (int i = 0; i < b - 1; i++)
            insert(s2, a[i]);
 
        for (int i = 0; i <= N - b; i++) {
            // removing the last element of previous
            // window as window has shift by one
            if (i - 1 >= 0)
                delete(s1, s2);
 
            // adding the new element to
            // the window as the window is shift by one
            insert(s2, a[i + b - 1]);
 
            ans.add(get_max(s1, s2));
        }
        return ans;
    }


    public int findShortestPath(int n, int[][] edges,
                                       int src, int dst,
                                       int K) {
        // Initialize the adjacency list
        List<List<int[]> > adjlist = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjlist.add(new ArrayList<int[]>());
        }
 
        // Initialize a queue to perform BFS
        Queue<int[]> q = new LinkedList<>();
 
        Map<Integer, Integer> mp = new HashMap<>();
 
        // Store the maximum distance of
        // every node from source vertex
        int ans = Integer.MIN_VALUE;
 
        // Initialize adjacency list
        for (int[] edge : edges) {
            adjlist.get(edge[0]).add(
                new int[] { edge[1], edge[2] });
        }
 
        // Push the first element into queue
        q.add(new int[] { src, 0 });
 
        int level = 0;
 
        // Iterate until the queue becomes empty
        // and the number of nodes between src
        // and dst vertex is at most to K
        while (!q.isEmpty() && level < K + 2) {
 
            // Current size of the queue
            int sz = q.size();
 
            for (int i = 0; i < sz; i++) {
 
                // Extract the front
                // element of the queue
                int[] pr = q.poll();
 
                // If the dst vertex is reached
                if (pr[0] == dst)
                    ans = Math.max(ans, pr[1]);
 
                // Traverse the adjacent nodes
                for (int[] pr2 : adjlist.get(pr[0])) {
 
                    // If the distance is greater
                    // than the current distance
                    if (!mp.containsKey(pr2[0])
                        || mp.get(pr2[0])
                               > pr[1] + pr2[1]) {
 
                        // Push it into the queue
                        q.add(new int[] { pr2[0],
                                          pr[1] + pr2[1] });
                        mp.put(pr2[0], pr[1] + pr2[1]);
                    }
                }
            }
 
            // Increment the level by 1
            level++;
        }
 
        // Finally, return the maximum distance
        return ans != Integer.MIN_VALUE ? ans : -1;
    }

    public boolean isValid(int[][] screen, int m, int n, int x, int y, int prevC, int newC) {
        if(x < 0 || x >= m || y < 0 || y >= n || screen[x][y] != prevC
           || screen[x][y]== newC)
            return false;
        return true;
    } 

    public void generatePrintBinary(int n) {
        for (int i = 1; i <= n; i++) {
            String str = "";
            int temp = i;
            while (temp != 0) {
                if ((temp & 1) == 1) {
                    str = "1" + str;
                } else {
                    str = "0" + str;
                }
                temp = temp >> 1;
            }
            System.out.println(str);
        }
    }


    public void generatePrintBinary(int n){
        // Create an empty queue of strings
        Queue<String> q = new LinkedList<String>();
 
        // Enqueue the first binary number
        q.add("1");
 
        // This loops is like BFS of a tree with 1 as root
        // 0 as left child and 1 as right child and so on
        while (n-- > 0) {
            // print the front of queue
            String s1 = q.peek();
            q.remove();
            System.out.println(s1);
 
            // Store s1 before changing it
            String s2 = s1;
 
            // Append "0" to s1 and enqueue it
            q.add(s1 + "0");
 
            // Append "1" to s2 and enqueue it. Note that s2
            // contains the previous front
            q.add(s2 + "1");
        }
    }

    public QItem(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }

    public static int minDistance(char[][] grid) {
        QItem source = new QItem(0, 0, 0);
        
        // To keep track of visited QItems. Marking
        // blocked cells as visited.
        firstLoop:
        for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++)
        {
            
            // Finding source
            if (grid[i][j] == 's') {
            source.row = i;
            source.col = j;
            break firstLoop;
            }
        }
    }

    public int getMinDiceThrows(int move[], int n) {
        int visited[] = new int[n];
        Queue<qentry> q = new LinkedList<>();
        qentry qe = new qentry();
        qe.v = 0;
        qe.dist = 0;
 
        // Mark the node 0 as visited and enqueue it.
        visited[0] = 1;
        q.add(qe);
 
        // Do a BFS starting from vertex at index 0
        while (!q.isEmpty()) {
            qe = q.remove();
            int v = qe.v;
 
            // If front vertex is the destination
            // vertex, we are done
            if (v == n - 1)
                break;
 
            // Otherwise dequeue the front vertex and
            // enqueue its adjacent vertices (or cell
            // numbers reachable through a dice throw)
            for (int j = v + 1; j <= (v + 6) && j < n;
                 ++j) {
                // If this cell is already visited, then
                // ignore
                if (visited[j] == 0) {
                    // Otherwise calculate its distance and
                    // mark it as visited
                    qentry a = new qentry();
                    a.dist = (qe.dist + 1);
                    visited[j] = 1;
 
                    // Check if there a snake or ladder at
                    // 'j' then tail of snake or top of
                    // ladder become the adjacent of 'i'
                    if (move[j] != -1)
                        a.v = move[j];
                    else
                        a.v = j;
                    q.add(a);
                }
            }
        }
 
        // We reach here when 'qe' has last vertex
        // return the distance of vertex in 'qe'
        return qe.dist;
    }

    public int minThrow(int n, int arr[]) {
        // code here
        for (int i = 0; i < 31; i++) {
            // initialising every index of t with -1
            t[i] = -1;
        }
        // create hashmap to store snakes and ladders start
        // and end for better efficiency
        HashMap<Integer, Integer> h = new HashMap<>();
        for (int i = 0; i < 2 * n; i = i + 2) {
            // store start as key and end as value
            h.put(arr[i], arr[i + 1]);
        }
        // final ans
        return sol(1, h);
    }


    public int sol(int i, HashMap<Integer, Integer> h) {
        // base condintion
        if (i >= 30)
            return 0;
 
        // checking if block is already visited or
        // not(memoization).
        else if (t[i] != -1)
            return t[i];
 
        // initialising min as max int value
        int min = Integer.MAX_VALUE;
 
        // for loop for every dice value from 1 to 6
        for (int j = 1; j <= 6; j++) {
            // incrementing value of i with dice value i.e j
            // taking new variable k
            //->taking new variable so that we dont change i
            // as we will need it again in another iteration
            int k = i + j;
            if (h.containsKey(k)) {
                // checking if this is a snake of ladder
                // if a snake then we continue as we dont
                // need a snake
                if (h.get(k) < k)
                    continue;
                // updating if its a ladder to ladder end
                // value
                k = h.get(k);
            }
            // updating min in every iteration for getting
            // minimum throws from this particular block
            min = Math.min(min, sol(k, h) + 1);
        }
        // updating value of t[i] to min
        // memoization
        t[i] = min;
        return t[i];
    }



    public class qentry {
        int v; // Vertex number
        int dist; // Distance of this vertex from source
    }


    public int minimumCostSimplePath(int u, int destination,
                                 boolean visited[],
                                 int graph[][]) {
     
        if (u == destination)
            return 0;
            
        // Marking the current node as visited
        visited[u] = true;
    
        int ans = INF;
    
        // Traverse through all
        // the adjacent nodes
        for(int i = 0; i < V; i++)
        {
            if (graph[u][i] != INF && !visited[i])
            {
                
                // Cost of the further path
                int curr = minimumCostSimplePath(i,
                            destination, visited, graph);
    
                // Check if we have reached the
                // destination
                if (curr < INF)
                {
                    
                    // Taking the minimum cost path
                    ans = Math.min(ans, graph[u][i] + curr);
                }
            }
        }
    
        // Unmarking the current node
        // to make it available for other
        // simple paths
        visited[u] = false;
    
        // Returning the minimum cost
        return ans;
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