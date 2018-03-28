package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Writer {

	private String path;

	public Writer(String filePath) {
		this.path = filePath;
		
	}
	/**
	 * Escreve em arquivo de texto a matrix produto. 
	 * @param matrix
	 * @throws IOException
	 */
	public  void writeFile(ArrayList<ArrayList<Integer>> matrix) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new PrintWriter(new FileWriter(path)))) {
			writer.write(matrix.size() + " " + matrix.size() + "\n");
			for (ArrayList<Integer> array : matrix) {
				for (int i = 0; i < array.size(); i++) {
				    writer.write(array.get(i) + ((i == array.size()-1) ? "\n" : " "));
				}
			}
		}
	}
	/**
	 * Escreve os tempos capturados para execução de cada operação.
	 * @param result
	 * @throws IOException
	 */
	public void writeFile(String result) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new PrintWriter(new FileWriter(path, true)))) {
			writer.write(result);
		}
	}
}
