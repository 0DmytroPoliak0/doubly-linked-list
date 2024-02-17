# doubly-linked-list

# Doubly Linked List Implementation in Java

This Java code provides an implementation of a doubly linked list along with a node class. Doubly linked lists are data structures that consist of a sequence of elements, where each element has a reference to both the next and previous elements in the sequence.

## Node Class

The `Node<E>` class represents a single node in the doubly linked list. Each node contains a piece of data of type `E`, as well as references to the next and previous nodes in the list.

## DoublyLinkedList Class

The `DoublyLinkedList<E>` class represents the doubly linked list data structure. It includes methods to perform various operations on the list, such as adding elements to the beginning and end, deleting elements, and printing the list.

### Methods

- `printList()`: Prints the elements of the list.
- `addFirst(E data)`: Adds a new node with the given data to the beginning of the list.
- `addLast(E data)`: Adds a new node with the given data to the end of the list.
- `deleteFirst()`: Deletes the first node in the list and returns its data.
- `deleteLast()`: Deletes the last node in the list and returns its data.
- `addAfter(int insertAfter, E data)`: Adds a new node with the given data after a specific node identified by its data.
- `deleteAfter(E data)`: Deletes the node after the node containing the specified data and returns its data.

### Main Method

The `main()` method demonstrates the usage of the doubly linked list implementation by creating two lists, adding elements to them, and performing operations such as deleting the first and last elements.

## Usage

To use this code, simply create an instance of the `DoublyLinkedList` class, specifying the type of data it will contain (e.g., `DoublyLinkedList<Integer>` or `DoublyLinkedList<String>`). Then, you can use the provided methods to manipulate the list as needed.

```java
public static void main(String[] args) {
    // Example usage
    DoublyLinkedList<Integer> list = new DoublyLinkedList<>(new Node<>(10));
    list.addFirst(4);
    list.addLast(7);
    list.printList();

    // Perform other operations as needed
}
```

## Notes

- This implementation assumes that the provided data type `E` is compatible with Java's `equals()` method for comparison.
- Care should be taken when using the `deleteAfter(E data)` method to ensure that the specified data uniquely identifies a node in the list.

Feel free to modify and extend this code to suit your specific requirements. If you encounter any issues or have questions, please refer to the provided documentation or reach out for assistance.
