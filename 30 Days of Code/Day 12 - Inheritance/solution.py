"""
In this challenge, we observe HackerRank forcing users to obey non-PEP 8
naming conventions...
"""

################################################################################
#----------------------------- begin locked code ------------------------------#
class Person:
    def __init__(self, firstName, lastName, idNumber):
        self.firstName = firstName
        self.lastName = lastName
        self.idNumber = idNumber
    def printPerson(self):
        print("Name:", self.lastName + ",", self.firstName)
        print("ID:", self.idNumber)
#------------------------------ end locked code -------------------------------#
################################################################################

class Student(Person):
    def __init__(self, firstName, lastName, idNumber, scores):
        Person.__init__(self, firstName, lastName, idNumber)
        self.scores = scores

    def calculate(self):
        average = sum(scores) / len(scores)
        if average >= 90:
            return 'O'
        elif average >= 80:
            return 'E';
        elif average >= 70:
            return 'A';
        elif average >= 55:
            return 'P';
        elif average >= 40:
            return 'D';
        else:
            return 'T';

################################################################################
#----------------------------- begin locked code ------------------------------#
line = input().split()
firstName = line[0]
lastName = line[1]
idNum = line[2]
numScores = int(input()) # not needed for Python
scores = list( map(int, input().split()) )
s = Student(firstName, lastName, idNum, scores)
s.printPerson()
print("Grade:", s.calculate())
#------------------------------ end locked code -------------------------------#
################################################################################