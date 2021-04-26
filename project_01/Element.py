n = int(input())
b = input().split()
a = [0]*n
max_a = 0
min_a = 0
for i in range(n):
    a[i] = int(b[i])
    if a[i] > max_a:
        max_a = a[i]
    if a[i] < min_a:
        min_a = a[i]

q = int(input())
x = [0]*q
for i in range(q):
    x[i] = int(input())

c = [0]*max_a
for i in range(n):
    c[a[i] -1] += 1

for i in range(1, max_a):
    c[i] = c[i] + c[i-1]

for i in x:
    if i > max_a:
        print(n, 0, 0)
    elif i < min_a:
        print(0, 0, n)
    elif i == 1:
        print(0, 1, n-1)
    else:
        print(c[i-2], c[i-1]-c[i-2], n-c[i-1])
