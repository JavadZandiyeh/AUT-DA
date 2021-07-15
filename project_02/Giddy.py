n, m, x, y = map(int, input().split())
s = input()
t = input()


def lcs(s, t):
    L = [[0] * (m + 1) for i in range(n + 1)]
    for i in range(1, n + 1):
        for j in range(1, m + 1):
            if t[i - 1] == s[j - 1]:
                L[i][j] = L[i - 1][j - 1] + 1
            else:
                L[i][j] = max(L[i - 1][j], L[i][j - 1])
    return L[n][m]


len_lcs = lcs(t, s)
print(x*(n - len_lcs) + y*(m - len_lcs))
