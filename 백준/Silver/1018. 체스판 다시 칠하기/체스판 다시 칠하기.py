N, M = map(int, input().split())
board = []
result = []
for _ in range(N):
    board.append(input())
for i in range(N-7):
    for j in range(M-7):
        beginW = 0
        beginB = 0
        for a in range(i, i+8):
            for b in range(j, j+8):
                if (a + b) % 2 == 0:
                    if board[a][b] == "B":
                        beginW += 1
                    else:
                        beginB += 1
                else:
                    if board[a][b] == "B":
                        beginB += 1
                    else:
                        beginW += 1
        result.append(beginB)
        result.append(beginW)
print(min(result))
