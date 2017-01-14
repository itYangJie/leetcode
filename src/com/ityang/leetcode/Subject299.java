package com.ityang.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Subject299 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getHint("1123", "0111");
	}

	public static String getHint(String secret, String guess) {

		int bulls = 0, cows = 0;
		Map<Integer, Integer> secretMap = new HashMap<>();
		Map<Integer, Integer> guessMap = new HashMap<>();

		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == guess.charAt(i))
				bulls++;
			if (secretMap.containsKey(secret.charAt(i) - '0'))
				secretMap.put(secret.charAt(i) - '0', secretMap.get(secret.charAt(i) - '0') + 1);
			else
				secretMap.put(secret.charAt(i) - '0', 1);

			if (guessMap.containsKey(guess.charAt(i) - '0'))
				guessMap.put(guess.charAt(i) - '0', guessMap.get(guess.charAt(i) - '0') + 1);
			else
				guessMap.put(guess.charAt(i) - '0', 1);

		}
		for (int i = 0; i <= 9; i++) {
			if(secretMap.containsKey(i) && guessMap.containsKey(i))
				cows += Math.min(secretMap.get(i), guessMap.get(i));
		}
		cows = cows-bulls;
		
		return bulls+"A"+cows+"B";
	}
}
