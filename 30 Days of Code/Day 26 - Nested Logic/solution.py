"""
There are cleaner ways to get the expected results, but this is a tutorial
based on nested logic, so I used nested logic in the most readable way I could.

Note that the fine policy defined in this problem is pretty silly; for example, 
"a year early" and "a year late" are determined by comparing JUST the year 
values, such that 12/31/2017 and 1/1/2018 are "a year apart".
"""


ad, am, ay = [int(x) for x in input().split(' ')] # Actual date
ed, em, ey = [int(x) for x in input().split(' ')] # Expected date

fine = 0
if ay == ey:
    if am == em and ad > ed:
        # Returned in expected year and month, at least a day late
        fine = 15 * (ad - ed);
    elif am > em:
        # Returned in expected year, at least a month late
        fine = 500 * (am - em);
elif ay > ey:
    # Returned at least a year late
    fine = 10000
    
print(fine)