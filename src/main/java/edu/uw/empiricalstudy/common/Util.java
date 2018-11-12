package edu.uw.empiricalstudy.common;

import java.util.Random;

public class Util {

	public static final int N = 100;

	public static int[] randomIntArrayGenerator(int size) {

		// init random obj with seed
		Random random = new Random(System.currentTimeMillis());

		int[] randomNumbers = new int[size];

		for (int index = 0; index < size; index++) {
			randomNumbers[index] = random.nextInt();// needs bounds somehow
		}

		return randomNumbers;
	}

}
