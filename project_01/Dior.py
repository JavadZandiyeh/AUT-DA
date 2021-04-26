n = int(input())
b = input().split()
a = [0]*n
for i in range(len(b)):
    a[i] = int(b[i])

num = {}
bb = input().split()
q = [0]*n
for i in range(n):
    q[i] = int(bb[i])

a.sort()
for i in range(n):
    num[a[i]] = i

ans = 0
index = -1


def solve(p, r):
    global index
    if r - p >= 1:
        index += 1
    if r - p <= 1:
        return
    global ans
    ans += (r-p-1)
    pivot = q[index]
    id = num[pivot]
    solve(p, id)
    solve(id+1, r)


solve(0, n)
print(ans)
