
f=open("spcc.asm","r")
IS={"STOP":00,"ADD":1,"SUB":2,"MULT":3,"MOVR":4,"MOVM":5,"COMP":6,"BC":7,"DIV":8,"READ":9,"PRINT":10}
AS={"START":1,"END":2,"ORIGIN":3,"EQU":4,"LTORG":5}
DS={"DS":2,"DC":1}
input1=f.read()
ml=input1.split()[1]
m_loc_tab={}
a=['0','1','2','3','4','5','6','7','8','9']
b=[0,1,2,3,4,5,6,7,8,9]

test=[]
test2=[]
test3=[]
p="='"
lt_no=list()
LT=[]
CT=[]
def cal(ml):
    for j in input1.split("\n"):
        m_loc_tab.update({j.split()[0]:int(ml)-1})
        ml=int(ml)+1
        #print(j)
        lt_no.append(j[j.find(",='")+3])
    for i in input1.split():
        for k in i:
            if k not in a:
               test.append(i)
    for key in AS:
        test2.append(key)
    for j in IS:
        test3.append(j)
    sym_tab=list(set(test)-set(test2)-set(test3)-set(a))
    print("Symbol table" ,{k: m_loc_tab[k] for k in m_loc_tab.keys() & set(sym_tab)})
    lit_set=set(a)&set(lt_no)
   
    for i in lit_set:
        LT.append("='{}'".format(i))
    print("litral table",LT)
isrD=[]
def isr(IDS,n):
    str1=""
    if n ==1:
        str1="AS"
    elif n==2:
        str1="IS"
    else:
        str1="DS"

    for k in input1.split():
        for key,value in IDS.items():
            if k==key:
                isrD.append([key,str1,"0"+str(value)])
for i in input1.split():
    if i[0] in a :
            isrD.append(["C",i])
for l in LT:
    isrD.append(["L",l])
        
    
cal(ml)
isr(AS,1)
isr(IS,2)
isr(DS,3)
print("ISR Table")
print(isrD)
