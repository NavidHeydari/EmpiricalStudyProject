package edu.uw.empiricalstudy.common;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.management.openmbean.OpenMBeanOperationInfoSupport;

public class Util {

	public static final int N = 100;

	/**
	 * generates single dimensional int array
	 * @param size
	 * @return
	 */
	public static int[] randomIntArrayGenerator(int size) {

		// init random obj with seed
		Random random = new Random();

		int[] randomNumbers = new int[size];

		for (int index = 0; index < size; index++) {
			randomNumbers[index] = (int) (random.nextInt() / 100000000);// needs
																		// bounds
																		// somehow
			if (randomNumbers[index] < 0) {
				randomNumbers[index] *= -1;
			}
		}

		return randomNumbers;
	}

	/**
	 * use this method to generate random capacity for knapsack
	 * 
	 * @return
	 */
	public static int randomIntGenerator() {

		// init random obj with seed
		Random random = new Random();

		int randomNumbers = 0;

		randomNumbers = (int) (random.nextInt() / 10000);// needs bounds somehow
		if (randomNumbers < 0) {
			randomNumbers *= -1;
		}

		return randomNumbers;
	}

	public static int[] readInputFileToArrays(String filePath) throws IOException {

		StringBuilder sb = new StringBuilder();
		Files.readAllLines(new File(filePath).toPath()).forEach(sb::append);
		List<String> numbers = Arrays.asList(sb.toString().split(","));

		return numbers.stream().mapToInt(Integer::valueOf).toArray();

	}

	public static void printPrettyArray(int[] array) {
		System.out.println(Arrays.toString(array));
	}

	public static void printPrettyArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			printPrettyArray(array[i]);
		}
	}

	public static void saveCsvToFile(long time, int sizeOfDataSet, String fileName){
	
//		String line = "time(nanoSec):," + time + ",data set size:," +sizeOfDataSet + System.lineSeparator();
		String line = "time(nanoSec):,data set size:," + System.lineSeparator() 
		+ time + "," + sizeOfDataSet + ","+ System.lineSeparator();
		try{
			File file = new File(fileName);
			if(!file.exists()){
				file.createNewFile();
			}
			
			Files.write(file.toPath(),line.getBytes(), StandardOpenOption.APPEND);
			 
		}catch(Exception e){
			System.out.println("result is:" + line);
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
