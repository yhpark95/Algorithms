result = 1
for i in range(3):
    result *= int(input())
dic = {i: 0 for i in range(10)}
while result > 0:
    i = result % 10
    result //= 10
    dic[i] += 1

for number in dic.values():
    print(number)
