import operator
n = int(input())

t = list(map(int, input().split()))
w = list(map(int, input().split()))
t_w = [(t[i] / w[i]) for i in range(n)]

my_list = list()
for i in range(n):
    my_list.append((t_w[i], t[i], w[i]))

my_list.sort(key=operator.itemgetter(0))

ans = 0
curr = 0
for i in range(n):
    curr += my_list[i][1]
    ans += (curr * my_list[i][2])

print(ans)
