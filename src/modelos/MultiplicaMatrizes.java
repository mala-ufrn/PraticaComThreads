package modelos;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class MultiplicaMatrizes {
	
	protected Integer[][] matrixA;
	protected Integer[][] matrixB;
	protected Integer[][] matrixC;
	
	public ArrayList<ArrayList<Integer>> multiplicar(ArrayList<ArrayList<Integer>> matrixA,
			ArrayList<ArrayList<Integer>> matrixB) {
		this.matrixA = matrixA.stream().map(u -> u.toArray(new Integer[0])).toArray(Integer[][]::new);
		this.matrixB = matrixB.stream().map(u -> u.toArray(new Integer[0])).toArray(Integer[][]::new);

		this.matrixC = new Integer[this.matrixA.length][this.matrixA.length];

		long startTime = System.nanoTime();
		
		this.execute();
		
		long endTime = System.nanoTime();
		System.out.println("Tempo de execucao: "+ (endTime - startTime) + " nano.");

		return getResultArray();
	}
	
	private ArrayList<ArrayList<Integer>> getResultArray() {

		ArrayList<ArrayList<Integer>> resultArray = new ArrayList<ArrayList<Integer>>();

		for (Integer[] linha : matrixC) {
			resultArray.add(new ArrayList<Integer>(Arrays.asList(linha)));
		}
		return resultArray;
	}
	
	protected abstract void execute();

}
