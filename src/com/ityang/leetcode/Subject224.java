package com.ityang.leetcode;

import java.util.Stack;

public class Subject224 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subject224 s = new Subject224();
		System.out.println(s.calculate("2147483647"));
	}

	public int calculate(String str) {
		if (str == null || str.length() == 0 || str.trim().length() == 0)
			return 0;
		// 创建栈对象
		StringBuffer buffer = new StringBuffer();
		Stack<Character> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		
		getBackExpression(buffer, str.trim(), stack1);
		
		System.out.println(buffer.toString());
		
		return getResult(stack2, buffer.toString());
	}
	private  int getResult(Stack<Integer> s, String line) {
		char[] array = line.toCharArray();

		for (int i = 0; i < array.length; i++) {
			char c = array[i];
			if (c >= '0' && c <= '9') {
				// 为数字则压栈
				s.push((int)(c-'0'));
			} else {
				int b = s.pop();
				int a = s.pop();
				switch (c) {
					case '+':
						s.push(a + b);
						break;
					case '-':
						s.push(a - b);
						break;
					case '*':
						s.push(a * b);
						break;
					case '/':
						s.push(a / b);
						break;
					default:
						break;
				}
				
				
			}

		}
		
		return s.pop();
	}
	/**
	 * 中序表达式得到后序表达式
	 * 
	 * @param buffer
	 * @param line
	 * @param s
	 * @throws IOException
	 */
	private  void getBackExpression(StringBuffer buffer, String line,
			Stack<Character> s)  {

		// 将中缀表达式转换为后缀表达式
		char[] array = line.toCharArray();
		Character temp;
		for (int i = 0; i < array.length; i++) {
			char c = array[i];

			if (c >= '0' && c <= '9') {
				// 是数字则直接打印
				buffer.append(c);
			}else if(c == '('){
				s.push(c);
			}
			else if (c == '*' || c == '/' ) {
				if (s.size() != 0) {
					temp = s.peek();
					for (; temp == '*' || temp == '/';) {
						buffer.append(s.pop());
						if (s.size() != 0) {
							temp = s.peek();
						} else {
							break;
						}
					}
				}
				// 将优先级高的运算符弹栈后再压栈
				s.push(c);
			} else if (c == '+' || c == '-') {
				if (s.size() != 0) {
					temp = s.peek();
					for (; temp == '*' || temp == '/' || temp == '+' || temp == '-';) {
						buffer.append(s.pop());
						if (s.size() != 0) {
							temp = s.peek();
						} else {
							break;
						}
					}
				}
				// 将优先级高的运算符弹栈后再压栈
				s.push(c);
			} else if (c == ')') {

				while ((temp = s.pop()) != '(') {
					buffer.append(temp);
				}
			}
		}
		// 将栈中余下的数弹出
		while (s.size() != 0 && (temp = s.pop()) != null) {
			buffer.append(temp);
		}
	}
}
