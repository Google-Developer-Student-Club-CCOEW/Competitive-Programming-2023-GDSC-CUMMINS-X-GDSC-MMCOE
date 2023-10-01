nums=int(input("Enter the numbers of elements: "))
list=[]
for i in range (0,nums):
    element=int(input("Enter an element: "))
    list.append(element)
print("The list is: ",list)

mid=nums//2

if (mid%2==0):
    l1=list[mid:]
    print(l1)
else:
    mid=mid-1
    l1=list[mid:]
    print(l1)