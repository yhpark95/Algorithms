numSet = set([])
for i in range(10):
    n = int(input())
    numSet.add(n % 42)

print(len(numSet))
