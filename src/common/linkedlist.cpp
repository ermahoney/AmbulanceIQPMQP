/** File for implementation of linked list
 *
 * @author Blake Nelson, Alex Miera, Patrick Critz
 *
 */

#include <cstdlib>
#include <cstring>
#include "linkedlist.hpp"


/** Default Constructor
 */
template<typename T>
LinkedList<T>::LinkedList(){
    head = nullptr;
    tail = nullptr;
    num_elements = 0;
}

/** Default Destructor
 * Assumes that the list is still perfectly forwardly linked
 */
template<typename T>
LinkedList<T>::~LinkedList() {
    LinkedList::Node* node = head;
    while(node){
        LinkedList::Node* next = node->next;
        delete node;
        node = next;
        num_elements -= 1;
    }
    //TODO add custom error checking for full cleared list
    delete this;
}

template<typename T>
typename LinkedList<T>::Node* LinkedList<T>::push_front(T data) {
    LinkedList<T>::Node* n = new LinkedList<T>::Node();
    n->next = head;
    head = n;
    if(!tail){ //if the tail is empty this the list must have started empty
        tail = n;
    }
    num_elements += 1;
    return n;
}

template<typename T>
typename LinkedList<T>::Node* LinkedList<T>::push_back(T data) {
    LinkedList<T>::Node* n = new LinkedList<T>::Node();
    n->prev = tail;
    tail = n;
    if(!head){ //if the tail is empty this the list must have started empty
        head = n;
    }
    num_elements += 1;
    return n;
}

template<typename T>
T LinkedList<T>::pop_front() {
    LinkedList<T>::Node* n = head;
    T* v = n->data;
    head = n->next;
    delete n;
    num_elements -= 1;
    return v;
}

template<typename T>
T LinkedList<T>::pop_back() {
    LinkedList<T>::Node* n = tail;
    T* v = n->data;
    tail = n->next;
    delete n;
    num_elements -= 1;
    return v;
}

template<typename T>
typename LinkedList<T>::Node* LinkedList<T>::get_head() {
    return head;
}

template<typename T>
typename LinkedList<T>::Node* LinkedList<T>::get_tail() {
    return tail;
}

template<typename T>
typename LinkedList<T>::Node* LinkedList<T>::insert_before(LinkedList::Node* before, T data) {
    if(!before){
        return nullptr;
    }
    LinkedList<T>::Node* n = new LinkedList<T>::Node();
    n->data = data;
    n->prev = before->prev;
    n->next = before;
    before->prev = n;
    if(head == before) { //replace the head if adding before the current head
        head = n;
    }
    num_elements += 1;
    return n;
}

template<typename T>
typename LinkedList<T>::Node* LinkedList<T>::insert_after(LinkedList::Node* after, T data) {
    if(!after){
        return nullptr;
    }
    LinkedList<T>::Node* n = new LinkedList<T>::Node();
    n->data = data;
    n->prev = after;
    n->next = after->next;
    after->next = n;
    if(tail == after) { //replace the tail if adding after the tail
        tail = n;
    }
    num_elements += 1;
    return n;
}

template<typename T>
int LinkedList<T>::remove_node(LinkedList::Node* node_to_remove) {
    if(!node_to_remove){
        return -2;
    }
    LinkedList<T>::Node* n = head;
    while(n && n != node_to_remove){
        n = n->next;
        if(n == tail){
            return -1;
        }
    }
    //reconnect prev and next
    n->prev->next = n->next;
    n->next->prev = n->prev;
    delete n;
    num_elements -= 1;
    return 0;
}

template<typename T>
size_t LinkedList<T>::size() {
    return num_elements;
}
