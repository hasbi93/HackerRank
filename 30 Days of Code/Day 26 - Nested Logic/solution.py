"""
There are cleaner ways to get the expected results, but this is a tutorial
based on nested logic, so I used nested logic in the most readable way I could.

Note that the fine policy defined in this problem is pretty silly; for example,
"a year early" and "a year late" are determined by comparing JUST the year
values, such that 12/31/2017 and 1/1/2018 are "a year apart".
"""

def compute_fine(
        act_d, act_m, act_y,
        exp_d, exp_m, exp_y):
    """Return the fine amount, based on the actual and expected return dates."""
    fine = 0
    if act_y == exp_y:
        if act_m == exp_m and act_d > exp_d:
            # Returned in expected year and month, at least a day late
            fine = 15 * (act_d - exp_d)
        elif act_m > exp_m:
            # Returned in expected year, at least a month late
            fine = 500 * (act_m - exp_m)
    elif act_y > exp_y:
        # Returned at least a year late
        fine = 10000
    return fine

def main():
    act_d, act_m, act_y = [int(x) for x in input().split(' ')] # Actual date
    exp_d, exp_m, exp_y = [int(x) for x in input().split(' ')] # Expected date

    print(compute_fine(act_d, act_m, act_y,
                       exp_d, exp_m, exp_y))

if __name__ == "__main__":
    main()
