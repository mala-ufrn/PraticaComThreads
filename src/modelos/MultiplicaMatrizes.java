package modelos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import utils.Writer;

public abstract class MultiplicaMatrizes {
	
	protected Integer[][] matrixA;
	protected Integer[][] matrixB;
	protected Integer[][] matrixC;
	
	Writer writer;
	
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
	
	private ArrayList<ArrayList<Integer>> getResultArray() {

		ArrayList<ArrayList<Integer>> resultArray = new ArrayList<ArrayList<Integer>>();

		for (Integer[] linha : matrixC) {
			resultArray.add(new ArrayList<Integer>(Arrays.asList(linha)));
		}
		return resultArray;
	}
	
	protected abstract void execute();

}
