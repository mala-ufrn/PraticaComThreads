package modelos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import utils.Writer;
/**
 * Classe modelo para todas as abstra��es
 * @author Paulo & Hugo
 *
 */
public abstract class MultiplicaMatrizes {
	
	protected Integer[][] matrixA;
	protected Integer[][] matrixB;
	protected Integer[][] matrixC;
	
	Writer writer;
	/**
	 * M�todo que converter� os Arrays lidos dos arquivos em vetores de vetores.
	 * @param matrixA Primeira Matriz lida.
	 * @param matrixB Segunda Matriz lida.
	 * @param args Argumentos de entrada, para gera��o do arquivo de sa�da.
	 * @return Array Resultante da multiplica��o de matrixA x matrixB.
	 */
	public ArrayList<ArrayList<Integer>> multiplicar(ArrayList<ArrayList<Integer>> matrixA,
			ArrayList<ArrayList<Integer>> matrixB, String[] args) {
		this.matrixA = matrixA.stream().map(u -> u.toArray(new Integer[0])).toArray(Integer[][]::new);
		this.matrixB = matrixB.stream().map(u -> u.toArray(new Integer[0])).toArray(Integer[][]::new);

		this.matrixC = new Integer[this.matrixA.length][this.matrixA.length];

		long startTime = System.nanoTime();
		
		this.execute();
		
		long endTime = System.nanoTime();
		
		String metricPath = "resultado/metrics/" + args[1] + "_" + args[0] + "x" + args[0] + ".txt";
		
		
		try {
			writer = new Writer(metricPath);
			writer.writeFile(args[0]+ ";" + args[1] +";"+(endTime - startTime)+"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		// System.out.println(args[0]+ ";" + args[1] +";"+(endTime - startTime));

		return getResultArray();
	}
	
	/**
	 * M�todo que dever� retornar a matrixC em formato  ArrayList<ArrayList<Integer>>.
	 * @return matrixC no formato  ArrayList<ArrayList<Integer>>
	 */
	private ArrayList<ArrayList<Integer>> getResultArray() {

		ArrayList<ArrayList<Integer>> resultArray = new ArrayList<ArrayList<Integer>>();

		for (Integer[] linha : matrixC) {
			resultArray.add(new ArrayList<Integer>(Arrays.asList(linha)));
		}
		return resultArray;
	}
	
	protected abstract void execute();

}
