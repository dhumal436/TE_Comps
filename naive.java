
import java.util.*;
class naive{
float n=0,y=0,pn=0,py=0,sy=0,sn=0;



String[][] data={
       {"1","youth","high","no","fair","no"},
       {"2","youth","high","no","excellent","no"},
       {"3","middle_aged","high","no","fair","yes"},
       {"4","senior","medium","no","fair","yes"},
       {"5","senior","low","yes","fair","yes"},
       {"6","senior","low","yes","excellent","no"},
       {"7","middle_aged","low","yes","excellent","yes"},
       {"8","youth","medium","no","fair","no"},
       {"9","youth","low","yes","fair","yes"},
       {"10","senior","medium","yes","fair","yes"},
       {"11","youth","medium","yes","excellent","yes"},
       {"12","middle_aged","medium","no","excellent","yes"},
       {"13","middle_aged","high","yes","fair","yes"},
       {"14","ssenior","medium","no","excellent","no"}
    };



    void printData(){

       for (int i=0;i<14;i++) {
           
       for (int j=0;j<6;j++) {
           System.out.print(data[i][j] + " ");
                            }
            System.out.print("\n");
       }       
       
     

    }
    void cal_probablity(){
        for (int i=0;i<14;i++) {

            if(data[i][5]=="yes"){
                y++;
            }
            else if(data[i][5]=="no")
            {
                n++;
            }
        }
                pn=n/14;
                py=y/14;
        

        System.out.println("total Probablity of  buy computer"+ " "+  py);
        System.out.println("total Probablity of not buy computer"+ " " +pn);
    }
void cal_pro_in(String age,String income,String student,String c_rating)
{
float ay=0,an=0,iy=0,in=0,sy=0,sn=0,cy=0,cn=0;

//age



    for (int i=0;i<14;i++) {
        
        if(data[i][1].equals(age) ){
           
             if(data[i][5]=="yes"){
                                    ay++;
                                  }
             else if(data[i][5]=="no")
                {
                an++;
                }
    }
    }

//income
    for (int i=0;i<14;i++) {
        if(data[i][2].equals(income) ){
             if(data[i][5]=="yes"){
                                    iy++;
                                  }
             else if(data[i][5]=="no")
                {
                in++;
                }
    }
    }
//student
    for (int i=0;i<14;i++) {
        if( data[i][3].equals(student)){
             if(data[i][5]=="yes"){
                                    sy++;
                                  }
             else if(data[i][5]=="no")
                {
                sn++;
                }
    }
    }

    //credit
    for (int i=0;i<14;i++) {
        if(data[i][4].equals(c_rating)){
             if(data[i][5]=="yes"){
                                    cy++;
                                  }
             else if(data[i][5]=="no")
                {
                cn++;
                }
    }
    }
float pay=ay/y;
float pan=an/n;
float piy=iy/y;
float pin=in/n;
float psy=sy/y;
float psn=sn/n;
float pcy=cy/y;
float pcn=cn/n;
System.out.println("Probablity of student yes: " + psy+"| "+ "no: "+psn);
System.out.println("Probablity of " +age+" yes: " + pay+ "| "+"no: "+pan);
System.out.println("Probablity of "+ income +" yes: " + piy+"| "+ "no: "+pin);
System.out.println("Probablity of "+ c_rating +" yes: " + pcy+ "| "+"no: "+pcn);

System.out.print("Probablity "+ pcy*pay*psy*piy);

}
    




    public static void main(String a[]){
        String age, income, student, c_rating;

naive n=new naive();
Scanner s=new Scanner(System.in);
n.cal_probablity();
System.out.print("Enter age\n");
age=s.nextLine();
System.out.print("Enter income\n");
income=s.nextLine();
System.out.print("Enter student\n");
student=s.nextLine();
System.out.print("Enter c_rating\n");
c_rating=s.nextLine();
n.cal_pro_in( age,income, student, c_rating);
}
}