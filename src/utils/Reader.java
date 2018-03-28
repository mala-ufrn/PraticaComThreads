package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Reader {

	private String path;
	private ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();

	public Reader(String fileName) {
		this.path = fileName;
	}
	
	
	/**
	 * Método para leitura dos arquivos fonte disponibilizados
	 * @return resultante ArrayList<ArrayList<Integer>> matrix lida. 
	 * @throws IOException
	 */
	public  ArrayList<ArrayList<Integer>> readFile() throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			reader.readLine(); // linha com parametros

			for (String matrixLine; (matrixLine = reader.readLine()) != null;) {
				int[] intArray = Arrays.asList(matrixLine.split(" ")).stream().mapToInt(Integer::parseInt).toArray();
				Integer[] integerArray = Arrays.stream(intArray).boxed().toArray(Integer[]::new);
				matrix.add(new ArrayList<Integer>(Arrays.asList(integerArray)));
			}
		}
		return getMatrix();
	}

	private  ArrayList<ArrayList<Integer>> getMatrix() {
		return matrix;
	}

	
	

}
