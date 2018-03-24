package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Reader {

	private String path;
	private ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();

	public Reader(String fileName) {
		this.path = fileName;
	}

	public void readFile() throws FileNotFoundException, IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			reader.readLine();

			for (String matrixLine; (matrixLine = reader.readLine()) != null;) {
				int[] array = Arrays.asList(matrixLine.split(" ")).stream().mapToInt(Integer::parseInt).toArray();
				List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList()); 
				ArrayList<Integer> line = new ArrayList<Integer>(list);
				matrix.add(line);

			}
			
			matrix.stream().forEach(System.out::println);;

		}
	}

}
