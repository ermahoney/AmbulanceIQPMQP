/*
 * linkedlist.cpp
 *
 *      Author: Blake Nelson, Alex Miera
 */


#include <stdlib.h>
#include <string.h>
#include "linkedlist.hpp"

#define TRUE (1)
#define FALSE (0)



/** Function to create an empty linked list
 *
 * @return pointer to linked list structure or NULL on error
 */
LinkedList::LLIST* LinkedList::create (void) {
    LLIST *pll = (LLIST*) malloc(sizeof(LLIST));
    if (pll != NULL) {
        pll->head = NULL;
        pll->tail = NULL;
    }
    return pll;
}


/** Function to destroy a linked list. Linked list must be empty
 *
 * @param pll is a pointer to the linked list
 * @return zero on success, nonzero on failure
 */
int destroy (LinkedList::LLIST* pll) {
    if ((pll->head != NULL) || (pll->tail != NULL)) {
        // If linked list is not empty, something is wrong
        return -1;
    } else {
        // liked list is empty, release metadata struct
        free (pll);
    }
    return 0;
}



/** Function to get first node in llist for iteration
 *
 * @param pll is a pointer to the linked list
 * @return first node in the llist or null if empty
 */
LinkedList::LLNODE* LinkedList::get_first_node (LinkedList::LLIST *pll) {
    return pll->head;
}



/** Function to get the last node in llist for iteration
 *
 * @param pll is a pointer to the linked list
 * @return first node in the llist or null if empty
 */
LinkedList::LLNODE* LinkedList::get_last_node (LinkedList::LLIST* pll) {
    return pll->tail;
}



/** Function to get the next node in llist during iteration
 *
 * @param pnode is a pointer to the current node during iteration
 * @return the next node (node following pnode) or NULL
 */
LinkedList::LLNODE* LinkedList::get_next_node (LinkedList::LLNODE* pnode) {
    return pnode->next;
}



/** Function to get the previous node in llist during iteration
 *
 * @param pnode is a pointer to the current node during iteration
 * @return the prev node (node preceding pnode) or NULL
 */
LinkedList::LLNODE* LinkedList::get_prev_node (LinkedList::LLNODE* pnode) {
    return pnode->prev;
}



/** Function to add node to head of list
 *
 * @param pll is a pointer to the linked list
 * @param pdata is a pointer to the data
 * @return zero for success or nonzero for failure
 */
int LinkedList::addhead (LinkedList::LLIST* pll, void* pdata) {
    LinkedList::LLNODE* pnode; /* pointer to the new node */

    pnode = (LinkedList::LLNODE*) calloc(1, sizeof(LinkedList::LLNODE));
    if (pnode == 0) {
        return -1; /* failed allocation, no change to llist */
    }

    /* link the data to the node just allocated */
    pnode->data = pdata;

    /* Link the new node to the head of the linked list */
    if (pll->head == NULL) {
        /* this is the only node in the list, nothing before nothing after */
        pnode->prev = NULL;
        pll->head = pnode;
        pnode->next = NULL;
        pll->tail = pnode;
    } else {
        /* link this into the list at the head position */
        pnode->prev = NULL;
        pnode->next = pll->head;
        pll->head->prev = pnode;
        pll->head = pnode;
    }

    return 0;
}



/** Function to add node to tail of list
 *
 * @param pll is a pointer to the linked list
 * @param pdata is a pointer to the data
 * @return zero for success or nonzero for failure
 */
int LinkedList::addtail (LinkedList::LLIST* pll, void* pdata) {
    LinkedList::LLNODE *pnode; /* pointer to the new node */

    pnode = (LinkedList::LLNODE *) calloc(1, sizeof(LinkedList::LLNODE));
    if (pnode == 0) {
        return -1; /* failed allocation, no change to llist */
    }

    /* link the data to the node just allocated */
    pnode->data = pdata;

    /* link the new node to the tail of the linked list */
    if (pll->tail == NULL) {
        /* this is the only node in the list, nothing before nor following */
        pnode->prev = NULL;
        pll->head = pnode;
        pnode->next = NULL;
        pll->tail = pnode;
    } else {
        /* link this node into the list at the tail position
         */
        pnode->next = NULL;
        pnode->prev = pll->tail;
        pll->tail->next = pnode;
        pll->tail = pnode;
    }

    return 0;
}



/** Function to delete specified node from the list
 *
 * Note: This function will release the node back to the system
 *       (the memory allocated for the linked list node) if the
 *       specified node is found in the list. The client (calling)
 *       code is responsible for releasing the memory of the data
 *       the node points at. This frees the memory for the node but
 *       not the data the node points to.
 *
 * @param pll is a pointer to the linked list
 * @param pnode is pointer to node to delete
 * @return zero for success, nonzero on error
 */
int LinkedList::deletenode (LinkedList::LLIST* pll, LinkedList::LLNODE* pnode) {
    LinkedList::LLNODE *pcur;     // current node as we iterate the list

    /* walk the list until we find the wanted node. Error if not we don't find it */
    pcur = pll->head;
    while (pcur && pcur != pnode) {
        pcur = pcur->next;
    }
    if (!pcur) {
        return -1;
    }

    /* either at node we want to delete, or end of the list
     * special processing for head and tail positions
     */
    if (pcur) {
        /* unlink from the previous node */
        if (pll->head == pcur) {
            /* special processing if removing head of list */
            pll->head = pcur->next;
        } else {
            pcur->prev->next = pcur->next;
        }

        /* unlink from the following node */
        if (pll->tail == pcur) {
            /* special processing if removing tail of list */
            pll->tail = pcur->prev;
        } else {
            pcur->next->prev = pcur->prev;
        }

        /* free the node
         * client (calling) code responsible for releasing the data node points at
         */
        free (pcur);
    }

    /* return success */
    return 0;
}



/** Function to add a node before the specified node (pnode)
 *
 * @param pll is a pointer to the linked list
 * @param pnode is a pointer to the node to add before
 * @param pdata is a pointer to the data
 * @return zero if success or nonzero on error
 */
int LinkedList::add_before (LinkedList::LLIST* pll, LinkedList::LLNODE* pnode, void* pdata) {
    LinkedList::LLNODE* pnewnode = NULL;
    pnewnode = (LinkedList::LLNODE *) calloc (1, sizeof(LinkedList::LLNODE));
    if (pnewnode == NULL) {
        /* failed to allocate memory for new node */
        return -1;
    }

    /* link the data to the node then link the node into the list */
    pnewnode->data = pdata;

    /* special processing if we are adding to empty list
     * verify parameters are sensible for this situation
     */
    if ((pll->head == NULL) || (pll->tail == NULL)) {
        /* Head, tail and pnode must all be null or something's wrong */
        if (! ((pll->head == NULL) && (pll->tail == NULL) && (pnode == NULL))) {
            free (pnewnode);
            return -2;
        }

        /* adding into an empty list - this is the one and only node */
        pnewnode->prev = pnewnode->next = NULL;
        pll->head = pll->tail = pnewnode;
        return 0;
    }

    /* we are adding before the current node into a non empty list
     * possibly the head of the list
     */
    pnewnode->next = pnode;
    pnewnode->prev = pnode->prev;
    pnode->prev = pnewnode;
    if (pll->head == pnode) {
        /* adding to head of list */
        pll->head = pnewnode;
    } else {
        /* not at head of the list */
        pnewnode->prev->next = pnewnode;
    }

    return 0;
}



/** Function to add a node after the current
 *
 * @param pll is a pointer to the linked list
 * @param pnode is a pointer to the not to add after
 * @param pdata is a pointer to the data
 * @return zero if success or nonzero on error
 */
int LinkedList::add_after (LinkedList::LLIST* pll, LinkedList::LLNODE* pnode, void* pdata) {
    LinkedList::LLNODE *pnewnode = NULL;
    pnewnode = (LinkedList::LLNODE *) calloc (1, sizeof(LinkedList::LLNODE));
    if (pnewnode == NULL) {
        /* failed to allocate memory for new node */
        return -1;
    }

    /* link the data to the node the link the node into the list */
    pnewnode->data = pdata;

    /* special processing if we are adding to empty list
     * verify parameters are sensible for this situation
     */
    if ((pll->head == NULL) || (pll->tail == NULL)) {
        /* head, tail and pnode must all be null or something's wrong */
        if (! ((pll->head == NULL) && (pll->tail == NULL) && (pnode == NULL))) {
            free (pnewnode);
            return -2;
        }

        /* adding into an empty list - this is the one and only node */
        pnewnode->prev = pnewnode->next = NULL;
        pll->head = pll->tail = pnewnode;
        return 0;
    }

    /* we are adding after the current node into a non empty list
     * possibly the end of the list
     */
    pnewnode->prev = pnode;
    pnewnode->next = pnode->next;
    pnode->next = pnewnode;
    if (pll->tail == pnode) {
        /* adding to end of list */
        pll->tail = pnewnode;
    } else {
        /* not at end of the list */
        pnewnode->next->prev = pnewnode;
    }

    return 0;
}

