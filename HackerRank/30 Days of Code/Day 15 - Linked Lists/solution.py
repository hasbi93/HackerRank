"""
Note that it may be preferred to make a LinkedList class, that maintains its
own reference to its head. Then the calling code doesn't have to maintain the
reference to the head, and the insert() function doesn't have to return it.
"""

################################################################################
#----------------------------- begin locked code ------------------------------#
class Node:
    def __init__(self,data):
        self.data = data
        self.next = None
class Solution:
    def display(self,head):
        current = head
        while current:
            print(current.data,end=' ')
            current = current.next
#------------------------------ end locked code -------------------------------#
################################################################################

    def insert(self, head, data):
        """Add a new node to the end of the given list."""
        new_node = Node(data)

        if not head:
            return new_node

        current = head
        while current.next:
            current = current.next
        current.next = new_node
        return head

################################################################################
#----------------------------- begin locked code ------------------------------#
mylist= Solution()
T=int(input())
head=None
for i in range(T):
    data=int(input())
    head=mylist.insert(head,data)
mylist.display(head);
#------------------------------ end locked code -------------------------------#
################################################################################
