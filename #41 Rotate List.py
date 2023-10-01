a=int(input("how many elements do you want in list? "))
l=[]
for i in range(0,a):
    b=int(input("enter list items "))
    l.append(b)

k=int(input("enter the number of places to rotate to "))

e=[]
for i in range(0,k):
    p=l.pop()
    e.append(p)
    
e.reverse()
print(e+l)

'''
test case - 1:
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

test case - 2:
Input: head = [0,1,2], k = 4
Output: [2,0,1]
'''