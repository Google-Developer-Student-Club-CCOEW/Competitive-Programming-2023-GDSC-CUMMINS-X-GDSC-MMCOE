n=int(input("How many elemnts do you want in the list? "))

l=[]

for i in range(0,n):
    a=int(input("Enter list item/s "))
    l.append(a)

m=[]
for i in l:
    m.append(i)
m.reverse()

if l==m:
    print(True)
else:
    print(False)