"""
Note that you should really use simpler string methods if they do the trick.
In this case, str.endswith() is perfect, and regexes are unnecessary.
"""

import re

PATTERN = re.compile(r"@gmail\.com$")

gmail_users = []
num_rows = int(input())
for _ in range(num_rows):
    name, email = input().split()
    if PATTERN.search(email):
        gmail_users.append(name)

for name in sorted(gmail_users):
    print(name)
