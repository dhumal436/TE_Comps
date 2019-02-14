import java.io.*;
import java.util.*;



import java.lang.*;

class kmean
{
	public float mean[];
public int[] clust_s=new int[10];
boolean a=true;

int[][] cluster_;



public int clusters(int no_c,int n)
{
	int clust_size=0;
float size=(float)n/(float)no_c;
int size1=n/no_c;

if(size>size1){
	clust_size=size1+1;
}else
{
	clust_size=size1;
}
int j=n;
for(int i=0;a;i++){


	clust_s[i]=clust_size;
j-=clust_size;

if(j<clust_size)
{
	a=false;
	clust_s[i+1]=j;
}
}

//for(int i=0;i<clust_s.length;i++){System.out.print(clust_s[i]+"\n ");}
return clust_size;
}


void mean_cal(int [][] clust,int cl,int n){


	mean=new float[cl];
	float sum_=0;
		for(int j=0;j<cl;j++){
			mean[j]=0;
		}
	for(int i=0;i<n;i++)
	{
		for(int l=0;l<clust_s[i];l++)
		{
			
		sum_=sum_+clust[i][l];
		
		}
		if(0<clust_s[i]){
		mean[i]=sum_/(float)clust_s[i];
		sum_=0;
		System.out.println("M"+i+": "+mean[i]);
	}
	}


	
}
		void cluster(int arr[],int cl,int n){

//itialize

cluster_=new int[cl][n];

for(int mc=0;mc<cl;mc++)
{
for(int b=0;b<n;b++)
cluster_[mc][b]=999;

}
int i=0;
//
			float test=Math.abs(arr[0]-mean[0]);
			for(int r=0;r<n;r++)
		{boolean stop=true;
			test=Math.abs(arr[r]-mean[0]);
		for(int c=0;c<cl;c++)
			{
				
		if(test>=Math.abs(arr[r]-mean[c]))
			{
	
			//clust[r][c]=arr[i];
			i=c;
			test=Math.abs(arr[r]-mean[c]);
			}
				
				
		}
		for(int mk=0;stop;mk++){
			if(cluster_[i][mk]== 999){
			cluster_[i][mk]=arr[r];
			//System.out.println(clust[i][mk]+" :"+i);
			stop=false;

			}
			}
			
		}
		}

















public static void main(String args[])
{
	kmean km=new kmean();
	int i,j,k=0,len1,len2;


float sum1=0,sum2=0,sum3=0,sum4=0,sum5=0;
//float m1=0.0f,m2=0.0f,m3=0.0f,m4=0.0f,m5=0.0f;
//int tempm1=0,tempm2=0;
Scanner sc=new Scanner(System.in);
System.out.println("Enter number of elements");
int n=sc.nextInt();
int arr[]=new int[n];
System.out.println("Enter "+n+" elements");
for(i=0;i<n;++i)
arr[i]=sc.nextInt();
System.out.println("Enter the number of clusters");
int cl=sc.nextInt();
int num=km.clusters(cl,n);
//System.out.println(num);


//clusters

int clust[][]=new int[cl][n];
//int k1[]=new int[n];
//int k2[]=new int[n];
k=0;
do
	{
	for(i=0;i<cl;i++)
		{
		
		for(j=0;j<km.clust_s[i];j++)
			{
			clust[i][j]=arr[k];
			//System.out.println(clust[i][j]);
			k++;
			}
		}
		System.out.println("");
	}
while(k<n);
for(i=0;i<cl;i++)
	{
		System.out.print("K"+i+":");
	for(j=0;j<km.clust_s[i];j++)
		{
		System.out.print(clust[i][j] + " ");
		}
		System.out.println("");
	}


 km.mean_cal(clust,cl,n);
/*	
	for(i=0;i<n;i++)
	{
		for(int l=0;l<km.clust_s[i];l++)
		{
			
		sum2=sum2+clust[i][l];
		
		}
		if(0<km.clust_s[i]){
		mean[i]=sum2/(float)km.clust_s[i];
		sum2=0;
		System.out.print(mean[i]);
	}
	}

*/



	
//m1=(float)sum1/(float)num;
//m2=(float)sum2/(float)num;
//float mean1=Math.round(m1);
//float mean2=Math.round(m2);
//System.out.println("mean1 "+mean1);
//System.out.println("mean2 "+mean2);
//System.out.println();

//
for(i=0;i<cl;i++)
	{
	for(j=0;j<n;j++)
	clust[i][j]=999;
	}
i=j=k=0;


km.cluster(arr, cl, n);
	
/*
float test=Math.abs(arr[0]-km.mean[0]);
		for(int r=0;r<n;r++)
	{boolean stop=true;
		test=Math.abs(arr[r]-km.mean[0]);
	for(int c=0;c<cl;c++)
		{
			
	if(test>=Math.abs(arr[r]-km.mean[c]))
		{

		//clust[r][c]=arr[i];
		i=c;
		test=Math.abs(arr[r]-km.mean[c]);
		}
		else
		{
			
			
		//clust[1][k]=arr[i];
		//i++;
		//k++;
		}
		
		
			
			}
			for(int mk=0;stop;mk++){
				if(clust[i][mk]== 999){
				clust[i][mk]=arr[r];
				//System.out.println(clust[i][mk]+" :"+i);
				stop=false;
	
				}
				}
				
			}*/



for(j=0;j<cl;j++)
	{
		for(k=0;k<n;k++)
			{
clust[j][k]=km.cluster_[j][k];
//System.out.print(clust[j][k] + " ");
			}
		
//	System.out.println("");
	}


//print
System.out.println("Final clusters");
for(j=0;j<cl;j++)
	{
		System.out.print("K"+j+":");
		for(k=0;k<n;k++)
			{
if(clust[j][k]!=999){
System.out.print(clust[j][k] + " ");
}
			}
		
	System.out.println("");
	}

/*for(i=0;i<n;i++)
	{
	sum1=sum1+clust[0][i];
	sum2=sum2+clust[1][i];
	}
for(i=0;i<n;i++)
	{
	k1[i]=clust[0][i];
	k2[i]=clust[1][i];
	}
len1=k1.length;
len2=k2.length;
m1=(float)sum1/(float)len1;
m2=(float)sum2/(float)len2;
mean1=Math.round(m1);
mean2=Math.round(m2);
System.out.println("mean1 "+mean1);
System.out.println("mean2 "+mean2);*/







}
}