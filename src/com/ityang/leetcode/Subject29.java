package com.ityang.leetcode;

public class Subject29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide(-2147483648, 1));
	}

	public static int divide(int dividend, int divisor) {
		/*if(divisor == 0)
			return Integer.MAX_VALUE;
		long res = ((long)dividend)/((long)divisor);
		if(res>=Integer.MIN_VALUE && res<=Integer.MAX_VALUE)
			return (int) res;
		return Integer.MAX_VALUE;*/
		if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1))
	        return Integer.MAX_VALUE;
	   
	    boolean sign = (dividend > 0)^(divisor > 0);
	    long A = Math.abs((long)divisor);
	    long B = Math.abs((long)dividend);
	    int ret = 0;
	    
	    
	    for(int i = 31; i >= 0; i--)
	    {
	        if((B>>i) >= A)
	        {
	            ret = (ret<<1)|0x01;
	            B -= (A<<i);   // update B
	        }
	        else
	            ret = ret<<1;
	    }
	    
	    if(sign)
	        ret = -ret;
	    
	    return ret;
	}
}
