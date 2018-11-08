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