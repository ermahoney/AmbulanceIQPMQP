/** Header file for linked list
 *
 * @author Blake Nelson, Alex Miera, Patrick Critz
 *
 */

#pragma once

/** Linked List
 * This class represents a doubly linked list structure
 * where the nodes all contain data of type T.
 *
 * Examples:
 * LinkedList<int>* IntList = new LinkedList<int>(); (All of the nodes contain integers)
 * IntList->push_back(0); //Both head and tail contain pointers to the same node with data 0
 * LinkedList<Int>::Node* MyNode = IntList->push_back(10); //IntList: (0, 10) and a pointer to
 *                                                           the node that was just created is stored in MyNode
 * IntList->insert_before(MyNode, 5); //IntList: (0, 5, 10)
 * IntList->remove(MyNode); //IntList: (0, 5)
 * IntList->pop_back(); //IntList: (0)
 * delete IntList;
 */
template<typename T>
class LinkedList {
  
    public:

        struct Node {
            Node* prev;       /**< pointer to previous node */
            Node* next;       /**< pointer to next node     */
            T data;          /**< pointer to the data  */
        };

        LinkedList(); //Default Constructor
        ~LinkedList(); //Default Destructor

    private:

        Node* head;
        Node* tail;
        size_t num_elements; //cached for quick access

    public:

        //////////////////////
        // GETTERS
        //////////////////////

        /** Get the current size of the number of the linked list
         * @return the number of elements in the list from num_elements
         */
        size_t size();

        /**
         * @return a pointer to the head node
         */
        Node* get_head();

        /**
         * @return a pointer to the tail node
         */
        Node* get_tail();

        //////////////////////
        // INSERT OPERATORS
        //////////////////////

        /** Adds a node to the head of the list
         * @param data - a pointer to the data to be stored in the node
         * @return a pointer to the node that was created
         */
        Node* push_front(T data);

        /** Adds a node to the tail of the list
         * @param data - a pointer to the data to be stored in the node
         * @return a pointer to the node that was created
         */
        Node* push_back(T data);

        /** Adds data before the specified node
         * If run successfully the "before" node will come after the node containing T
         * @param before - a pointer to the node to put this data before
         * @param data - a pointer to the data to be stored in the node
         * @return a pointer to the node that was created or nullptr if the before node is not in the list
         */
        Node* insert_before(Node* before, T data);

        /** Adds data after the specified node
         * If run successfully the "after" node will come before the node containing T
         * @param after - a pointer to the node to put this data after
         * @param data - a pointer to the data to be stored in the node
         * @return a pointer to the node that was created or nullptr if the before node is not in the list
         */
        Node* insert_after(Node* after, T data);

        //////////////////////
        // REMOVE OPERATORS
        //////////////////////

        /** Removes the first node from the list
         * @return the last value of head
         */
        T pop_front();

        /** Removes the last node from the list
         * @return the last value of tail
         */
        T pop_back();

        /** Removes the specified node from the list
         * @param node_to_remove
         * @return 0 if successful or a negative number in the event of an error
         */
        int remove_node(Node* node_to_remove);
};