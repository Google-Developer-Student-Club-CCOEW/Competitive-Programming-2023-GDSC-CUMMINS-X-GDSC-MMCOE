def PeakIndex(A):
  if not A:
    return None
  left = 0
  right = len(A) - 1
  while left < right :
    m = (left + right) // 2
    if A[m] > A[m+1] and A[m] > A[m-1]:
        return m
    elif A[m] < A[m+1]:
        left = m+1
    else:
        right = m-1
  return left
