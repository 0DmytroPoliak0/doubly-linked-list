import java.util.function.Predicate;
class Node<E> {
    E data;
   // int data;
    Node<E> next;
    Node<E> prev;

    Node(E data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
    /*
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Node)) {
            return false;
        }

        Node<E> other = (Node<E>) obj;
        return data.equals(other.data);
    }
    *
     */
}

class DoublyLinkedList<E> {
    Node<E> head;
    Node<E> tail;
    public DoublyLinkedList(Node<E> head) {
        this.head = head;
        this.tail = head;
    }

    // print list
    public void printList() {
        Node<E> curr = head;
        do {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } while (curr != tail.next);
        System.out.println();
    }
    // Add a new node to the start of the doubly linked list
    public void addFirst(E data) {
        Node<E> newNode = new Node<>(data);
        if (tail == null) {
            // If the list is empty, set the new node as the only node
            newNode.next = newNode;
            tail = newNode;
        } else {
            // Insert the new node at the beginning of the list
            newNode.next = head;
           // tail.next = newNode; was wrong I guess
            head.prev = newNode;
            head = newNode;
        }
    }
    // Add a new node to the end of the doubly linked list
    /*
    public void addLast(E data) {
        Node<E> newNode = new Node<>(data);
        if (tail == null) {
            // If the list is empty, set the new node as the only node
            newNode.next = newNode;
            tail = newNode;
        } else {
            // Insert the new node after the current tail
            newNode.next = tail.next;
            tail.next = newNode;
        }
        // Update tail to the new node
        tail = newNode;
    }

     */

    public void addLast(E data) {
        Node<E> newNode = new Node<>(data);
        if (tail == null) {
            // If the list is empty, set the new node as the only node
            newNode.next = newNode;
            newNode.prev = newNode; // Set previous to itself
            tail = newNode;
        } else {
            // Insert the new node after the current tail
            newNode.next = tail.next;
            newNode.prev = tail; // Corrected line
            tail.next = newNode;
            tail = newNode; // Update tail to the new node
        }
    }


    //delete first node of the list
    E deleteFirst() {
        if (tail == null) {
            return null; // or throw an exception indicating that the list is empty
        }

        // Save the node to be deleted
        Node<E> toDelete = head;

        // If there's only one node, set head and tail to null and return its data
        if (head == tail) {
            head = null;
            tail = null;
            return toDelete.data;
        }

        // Update the head to the next node
        head = head.next;

        // Return the data of the deleted first node
        return toDelete.data;
    }
    //delete last node of the list
    E deleteLast() {
        if (tail == null) {
            return null; // or throw an exception indicating that the list is empty
        }
        // Save the node to be deleted
        Node<E> toDelete = tail;
        // If there's only one node, set tail to null and return its data
        if (tail == head) {
            tail = null;
            head = null;
            return toDelete.data;
        }
        // Start from the head to find the node before the tail
        Node<E> current = head;
        // Traverse the list to find the node before the tail
        while (current.next != tail) {
            current = current.next;
        }
        // Update the tail to the previous node
        tail = current;
        // Update the previous node's next pointer to skip the old tail
        if (current != null) {
            current.next = null;
        }
        // Return the data of the deleted last node
        return toDelete.data;
    }
    // Add a new node after a specific node with the given data
    public void addAfter(int insertAfter, E data) {
        Node<E> curr = tail;
        do {
            if (curr.equals(insertAfter)) {
                // Insert the new node after the current node
                Node<E> newNode = new Node<>(data);
                newNode.next = curr.next;
                curr.next = newNode;
                // Update tail if the new node is added after the current tail
                if (curr.next == tail) {
                    tail = newNode;
                }
                break;
            }
            curr = curr.next;
        } while (curr != tail.next);
    }
    E deleteAfter(E data) {
        if (tail == null || head == null) {
            return null; // or throw an exception indicating that the list is empty
        }
        // Save the node to be deleted
        Node<E> toDelete = head;
        // If there's only one node, set head and tail to null and return its data
        if (head == tail) {
            head = null;
            tail = null;
            return toDelete.data;
        }
        for(; toDelete != null; toDelete = toDelete.next){
            if(toDelete.data != null && toDelete.data.equals(data)){
                toDelete = toDelete.next;
                break;
            }
        }
        if (toDelete != null){
            if(toDelete.next != null){
                toDelete.next.prev = toDelete.prev;
            }
            toDelete.prev.next = toDelete.next;
        }
        // Return the data of the deleted first node
        return toDelete.data;
    }


    public static void main(String[] args) {
        // List 1: 10, 4, 5, 18, 20 (created using addFirst)
        DoublyLinkedList<Integer> list1 = new DoublyLinkedList<>(new Node<>(10));
        list1.addFirst(4);
        list1.addFirst(5);
        list1.addFirst(18);
        list1.addFirst(20);
       // list1.addFirst(10);

        System.out.println("List 1:");
        list1.printList();

        // Show the operation of deleteFirst()
        System.out.println("\nAfter deleteFirst(): " + list1.deleteFirst());
        list1.printList();

        // List 2: "Apple", "Banana", "Cherry", "Grape", "Orange" (created using addLast)
        DoublyLinkedList<String> list2 = new DoublyLinkedList<>(new Node<>("Apple"));
       // list2.addLast("Apple");
        list2.addLast("Banana");
        list2.addLast("Cherry");
        list2.addLast("Grape");
        list2.addLast("Orange");

        System.out.println("\nList 2:");
        list2.printList();

        // Show the operation of deleteLast()
        System.out.println("\nAfter deleteLast(): " + list2.deleteLast());
        list2.printList();


    }
/*
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>(new Node<>(1));
          list.addLast(2);
         list.addLast(3);
         list.addFirst(0);
         list.addAfter(2, 4);

        System.out.println("Original list:");
        list.printList();


        System.out.println("\nDeleted last node: " + list.deleteLast());

        System.out.println("\nList after deleting the last node:");
        list.printList();

        System.out.println("\nDeleting the only node:");
        DoublyLinkedList<Integer> listWithOneNode = new DoublyLinkedList<>(new Node<>(10));
        System.out.println("Deleted node: " + listWithOneNode.deleteLast());
        listWithOneNode.printList();

        System.out.println("\nDeleting from an empty list:");
        DoublyLinkedList<Integer> emptyList = new DoublyLinkedList<>(null);
        System.out.println("Deleted node: " + emptyList.deleteLast());


    }
 */
     /*
    E deleteAfter2(E data) {
        if (tail == null || head == null) {
            return null; // or throw an exception indicating that the list is empty
        }

        // Start from the head and iterate through the list
        for (Node<E> toDelete = head; toDelete != null; toDelete = toDelete.next) {
            // Check if the current node has the matching data
            if (toDelete.data != null && toDelete.data.equals(data)) {
                // Check if there is a node after the current node
                if (toDelete.next != null) {
                    Node<E> nodeToDelete = toDelete.next;

                    // Update next pointers to remove the node after the found node
                    toDelete.next = nodeToDelete.next;

                    // Update prev pointers if the node to delete is not the last node
                    if (nodeToDelete.next != null) {
                        nodeToDelete.next.prev = toDelete;
                    }

                    // If the node to delete is the last node, update the tail
                    if (nodeToDelete == tail) {
                        tail = toDelete;
                    }

                    // Return the data of the deleted node
                    return nodeToDelete.data;
                }
            }
        }

        return null; // Indicate that the node with matching data was not found
    }
     */



    /**
     * Deletes the last node in the doubly linked list and returns its data.
     * If the list is empty or has only one node, sets the tail to null and returns the data.
     *
     * @return Data of the deleted last node, or null if the list is empty.
     */
    /*
    E deleteLast() {
        if (tail == null) {
            return null; // or throw an exception indicating that the list is empty
        }

        // Save the node to be deleted
        Node<E> toDelete = tail;

        // If there's only one node, set tail to null and return its data
        if (tail == tail.next) {
            tail = null;
            return toDelete.data;
        }

        // Initialize the previous node pointer to null
        Node<E> prev = null;

        // Start from the head to find the node before the tail
        Node<E> current = head;

        // Traverse the list to find the node before the tail
        while (current != tail) {
            prev = current;
            current = current.next;
        }

        // Update the previous node's next pointer to skip the tail
        if (prev != null) {
            prev.next = null;
        }

        // Update the tail to the previous node
        tail = prev;

        // Return the data of the deleted last node
        return toDelete.data;
    }
     */
}
