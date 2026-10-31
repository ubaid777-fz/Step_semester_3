# Week 11 Conceptual Questions

**Q1. Why is head insertion O(1), but tail insertion O(n)?**

Inserting at the head is O(1) because we only create a new node, make it point to the current head, and update the head. Tail insertion is O(n) when only the head is available because we must traverse the entire list to find the last node. If we maintain a separate tail reference, tail insertion becomes O(1).

**Q2. Why does deleting a node in a singly linked list need its predecessor?**

In a singly linked list, a node only knows its next node. To delete a node, its previous node's next must be changed to skip the deleted node. A doubly linked list has both prev and next references, so if we already have a direct reference to the node, it can be deleted in O(1) by updating its neighboring links.

**Q3. Why can linked-list traversal be slower than array traversal even though both are O(n)?**

Arrays store elements in contiguous memory, which gives better CPU cache performance. Linked-list nodes can be stored at different memory locations, so the CPU must follow pointers from one node to another. This pointer chasing can make linked-list traversal slower in practice even though both are O(n).

**Q4. What is the memory advantage of relinking sorted linked lists?**

When merging two sorted linked lists, we can relink the existing nodes instead of creating a new list of elements. Therefore, the additional space is O(1). For arrays, merging into a new array generally requires O(m+n) additional space.

**Q5. What is the role of the next pointer?**

The next pointer stores the reference to the next node in a singly linked list. During traversal, we move using current = current.next. The traversal ends when current == null, because the last node's next reference is null.
