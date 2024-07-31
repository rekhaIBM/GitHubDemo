package com.uitest.rmt.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Helper {

	private static final Random random = new Random();

	public static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static int getRandomInt(int bound) {
		return random.nextInt(bound);
	}

	public static String getRandomString(int length) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			builder.append(getRandomChar());
		}
		return builder.toString();
	}

	public static char getRandomChar() {
		return (char) (random.nextInt(26) + 'a');
	}

	public static boolean validateTwoMapObjectByKeys(Map<String, String> expectedMap, Map<String, String> actualMap,
			String keysToCheck) {
		String[] keys = keysToCheck.split(",");

		List<String> actual = new ArrayList<String>();
		List<String> expected = new ArrayList<String>();
		for (String key : keys) {
			if (actualMap.containsKey(key)) {
				String value = (actualMap.get(key) != null && actualMap.get(key).toString().trim().length() > 0)
						? actualMap.get(key).toString()
						: "";
				actual.add(String.format("%s:%s", key, value));
			}
			if (expectedMap.containsKey(key)) {
				String value = (expectedMap.get(key) != null && expectedMap.get(key).toString().trim().length() > 0)
						? expectedMap.get(key).toString()
						: "";
				expected.add(String.format("%s:%s", key, value));
			}

			return true;
		}
		return false;
	}

}
