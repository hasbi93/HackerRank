"""
Once again, this challenge encourages users to use camelCase for names that 
should be in snake_case. Pylint hates this code.
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
        """Return a letter denoting the student's average score."""
        average = sum(self.scores) / len(self.scores)
        if average >= 90:
            return 'O'
        if average >= 80:
            return 'E'
        if average >= 70:
            return 'A'
        if average >= 55:
            return 'P'
        if average >= 40:
            return 'D'
        return 'T'

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
