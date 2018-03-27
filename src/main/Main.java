package main;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.util.ArrayList;

import modelos.ConcorrenteFixo;
import modelos.ConcorrenteLinear;
import modelos.ConcorrenteQuadrado;
import modelos.Sequencial;
import utils.Reader;
import utils.Writer;

public class Main {

	public static void main(String[] args) {
		int contador = 0;
		String resource1 = "matrizes/A" + args[0] + "x" + args[0] + ".txt";
		String resource2 = "matrizes/B" + args[0] + "x" + args[0] + ".txt";
		String targetFile = "resultado/C" + args[0] + "x" + args[0] + ".txt";

		String metricPath = "resultado/metrics/" + args[1] + "_" + args[0] + "x" + args[0] + ".txt";

		ArrayList<ArrayList<Integer>> matrixA = null;
		ArrayList<ArrayList<Integer>> matrixB = null;
		ArrayList<ArrayList<Integer>> matrixC = null;

		Reader reader1 = new Reader(resource1);
		Reader reader2 = new Reader(resource2);

		Writer writer = new Writer(targetFile);

		try {
			matrixA = reader1.readFile();
			matrixB = reader2.readFile();

			switch (args[1].toUpperCase()) {
			case "S":
				Sequencial sequencial = new Sequencial();
				matrixC = sequencial.multiplicar(matrixA, matrixB);
				break;
			case "C1":
				ConcorrenteQuadrado concorrenteQuadrado = new ConcorrenteQuadrado();
				matrixC = concorrenteQuadrado.multiplicar(matrixA, matrixB);
				break;
			case "C2":
				ConcorrenteLinear concorrenteLinear = new ConcorrenteLinear();
				matrixC = concorrenteLinear.multiplicar(matrixA, matrixB);
				break;
			case "C3":
				ConcorrenteFixo concorrenteFixo = new ConcorrenteFixo();
				matrixC = concorrenteFixo.multiplicar(matrixA, matrixB);
				break;
			default:
				System.out.println("O que você está fazendo?");
				System.exit(0);
			}
			
			writer.writeFile(matrixC);
			writer.writeMetrics(printUsage(args), metricPath);
			//System.out.println("Fim da execução do modelo: " +args[0] +" "+args[1]);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String printUsage(String[] args) {
		OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();

		StringBuilder out = new StringBuilder().append(args[0]).append(";").append(args[1]);

		for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
			method.setAccessible(true);
			if (method.getName().startsWith("getProcess")) {
				Object value;
				try {
					value = method.invoke(operatingSystemMXBean);
				} catch (Exception e) {
					value = e;
				} // try
				out.append(";").append(value);

			}
		}
		return out.append("\n").toString();

	}

}
