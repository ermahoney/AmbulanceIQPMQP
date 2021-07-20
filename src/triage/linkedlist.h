/** Header file for linked list
 *
 * @author Blake Nelson, Alex Miera
 *
 */

#ifndef LINKEDLIST_H
#define LINKEDLIST_H

typedef struct llnode {
  struct llnode *prev;       /**< pointer to previous node */
  struct llnode *next;       /**< pointer to next node     */
  double factor;          /**< pointer to the zip data  */
} LLNODE;

typedef struct llist {
  LLNODE *head;              /**< pointer to head node of ll */
  LLNODE *tail;              /**< pointer to tail node of ll */
} LLIST;

// prototypes
LLIST *create (void);
int destroy (LLIST *pll);
int addhead (LLIST *pll, double factor);
int addtail (LLIST *pll, double factor);
LLNODE *get_first_node (LLIST *pll);
LLNODE *get_last_node (LLIST *pll);
LLNODE *get_next_node (LLNODE *pnode);
LLNODE *get_prev_node (LLNODE *pnode);
int add_before (LLIST *pll, LLNODE *pnode, double factor);
int add_after (LLIST *pll, LLNODE *pnode, double factor);
int deletenode (LLIST *pll, LLNODE *pnode);
#endif
