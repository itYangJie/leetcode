package com.ityang.leetcode;

public class Subject135 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public static int candy(int[] ratings) {
		 
        // 5 6 7 434 3 23 23 5 3 5 4 1 434 32 231
		 
		// 1 1 1 1   1 1  1  1 1 1 1 1 1   1  1
		// 1 2 3 4   1 2  1  1 1 2 1 1 2   1  2
		// 1 2 3 4   1 2  3  2 1 3 2 1 2   1  2
        // 1 2 3 4   1 3  3  2 1 3 2 1 2   1  2
		 if(ratings==null || ratings.length==0)
			 return 0;
		 if(ratings.length==1)
			 return 1;
		 
		 int size = ratings.length;
		 int num[] = new int[size];
		 
		 for(int i=0;i<size;i++)
			 num[i] = 1;
		 for (int i = 1; i < size; i++)
		 {
			 if(ratings[i]>ratings[i-1])
				 num[i]=num[i-1]+1;
		 }
		 for (int i= size-1; i>0 ; i--)
		 {
			 if(ratings[i-1]>ratings[i])
				 num[i-1]=Math.max(num[i]+1,num[i-1]);
		 }
		 int result=0;
		 for (int i = 0; i < size; i++)
		 {
			 result+=num[i];
			
		 }
		 return result;
    }
}
