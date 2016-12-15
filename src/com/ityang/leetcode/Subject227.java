package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class Subject227 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(calculate("12+2-2*41"));
	}

	public static int calculate(String s) {
		s = s.trim();
		int  cur = 0;
		Stack<Integer> datas = new Stack<>();
		Stack<Character> symbol = new Stack<>();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				cur = cur * 10 + s.charAt(i) - '0';
			} else if (s.charAt(i) == ' ') {
				continue;
			} else {
				list.add(cur);
				cur = 0;
				if (s.charAt(i) == '+' || s.charAt(i) == '-') {
					while (!symbol.isEmpty()) {
						list.add(findSymbol(symbol.pop()));
					}
				} else {
					while (!symbol.isEmpty() && (symbol.peek() == '*' || symbol.peek() == '/')) {
						list.add(findSymbol(symbol.pop()));
					}
				}
				symbol.push(s.charAt(i));
			}

		}
		list.add(cur);
		while (!symbol.isEmpty()) {
			list.add(findSymbol(symbol.pop()));
		}
		for(int i=0;i<list.size();i++){
			if(list.get(i)>=0)
				datas.push(list.get(i));
			else{
				int b = datas.pop();
				int a = datas.pop();
				switch (list.get(i)) {
					case -1:
						datas.push(a + b);
						break;
					case -2:
						datas.push(a - b);
						break;
					case -3:
						datas.push(a * b);
						break;
					case -4:
						datas.push(a / b);
						break;
					default:
						break;
				}
			}
				
		}
		return datas.pop();
	}

	private static int findSymbol(char c) {
		int res ;
		switch (c) {
		case '+':
			res =  -1;
			break;
		case '-':
			res =  -2;
			break;
		case '*':
			res =  -3;
			break;
		case '/':
			res =  -4;
			break;
		default:
			res = 0;
			break;
		}
		return res;
	}
}
