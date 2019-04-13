f=open("SPCC.TXT",'r')
input1=f.read()
MACROE={1:[]}
templ=[]
MDT=[]
MNT=[]
NOP=[]
IOM=[]
ALA=[]
start = "MACRO"
end = "MEND"
count=[]
i=0
j=0
m=0
a=0
n=0
MN=True
replace="NONE"
copy = False
for line in input1.split("\n"):
    if line.strip() == start:
        copy = True
        MN=True
        i=i+1
        
    elif line.strip() == end:
        copy = False
        MDT.append(i)
        MDT.append(line)
        
    elif copy:
        MDT.append(i)
        MDT.append(line)
        a=a+1
        i=i+1
    elif not copy:
        count.append(a-1)
        print(count)
        a=0
    if MN and line != "MACRO":
        MNT.append(line.split()[0])
        NOP.append(len(list(line.split()))-1)
        ALA.append(line.split())
        IOM.append(i)
        MN=False

print("MDT")   
print("Index  Statement")
for l in range(int(len(MDT)/2)) :
    print("{} | {}".format(MDT[m],MDT[m+1]))
    m=m+2
print("\nMNT")
print("Macro name | no. of parameters | MDT Index")
for name in MNT:
    print("{}       |{}                  |   {}".format(MNT[n],NOP[n]-1,IOM[n]-1))
    n=n+1


print("\nALA")
n=0
print("Formal parameter | Positional")
for name in ALA:
    del name[0]
    for naem in name :
        if naem !=",":
            print("{}               | #{} ".format(naem,n+1))
            n=n+1



def expand(str1):
    ma=0
    temp_index=0
    index=MNT.index(str1)
    temp_index=MDT.index(IOM[index])+1
    #print(index,IOM["INDEX",index])
    for  mc in range(count[index]):
        print(MDT[temp_index+ma])
        ma=ma+2
    ma=0
    
    
def expan():
    index=0
    il=0
    for string in input1.split():
        if string in MNT:
            expand(string)

expan()
cmt=True
for str2 in input1.split("\n"):
    if str2.split()[0] in MNT and str2.split()[0] !="END":
        print(MACROE[str2.split()[0]])
        cmt=False
    else:
        cmt=True
    if cmt:
        print(str2)

