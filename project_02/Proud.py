import sys

n = int(input())
arr = list(map(int, input().split()))


def countInvOfFirstType(arr, p, q, r):
    count = 0
    n1 = q - p + 1
    n2 = r - q
    L = arr[p: (p + n1)]
    L.append(int(sys.maxsize))
    R = arr[(q + 1): (q + n2 + 1)]
    R.append(int(sys.maxsize))
    i = 0
    j = 0
    for k in range(p, (r + 1)):
        if L[j] <= R[i]:
            arr[k] = L[j]
            j += 1
        else:
            arr[k] = R[i]
            i += 1

    t = 0
    for j in range(n1):
        while (t < n2) and (L[j] > (2 * R[t])):
            t += 1
        count += t

    # print("p: ", p, " r: ", r, " num: ", count)
    return count


def convInv(arr, p, r):
    if p < r:
        ans = 0
        q = (p + r - 1) // 2
        ans += convInv(arr, p, q)
        ans += convInv(arr, q + 1, r)
        ans += countInvOfFirstType(arr, p, q, r)
        return ans
    else:
        return 0


num = convInv(arr, 0, n - 1)
print(num)
