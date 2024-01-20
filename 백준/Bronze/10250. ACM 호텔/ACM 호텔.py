T = int(input())
for i in range(T):
    H, W, N = map(int, input().split())
    yy = N % H
    if yy == 0:
        yy = H
        xx = (N // H)
    else:
        xx = (N // H) + 1
    print(yy*100+xx)
