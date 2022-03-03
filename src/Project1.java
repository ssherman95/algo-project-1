import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Project1 {

	public static void main(String[] args) {
		String fileName = args[0]; // TODO: replace this with args[1];
		List<Double> prices = getList(fileName);

		if (prices.isEmpty()) return;
		//System.out.printf("Found %d prices\n", prices.size());
		//System.out.println(prices);
		System.out.printf("The optimal solution for %s is %f\n", fileName, getBestProfit(prices, 0, prices.size() - 1));
	}

	public static Double getBestProfit(List<Double> prices, int i, int n) {
		int leftN = (int) Math.floor((double) n / 2);
		int rightI = (int) Math.ceil(((double) n - 1) / 2) + i;

		if (i >= n) return 0.0;
		else if (rightI + 1 == n) {
			double profit = prices.get(n) - prices.get(rightI);
			return profit > 0 ? profit : 0;
		}

		double leftMin = prices.get(i);
		for (int j = i; j < leftN; ++j) {
			if (prices.get(j) < leftMin) leftMin = prices.get(j);
		}

		double rightMax = prices.get(i);
		for (int j = rightI; j < n; ++j) {
			if (prices.get(j) > rightMax) rightMax = prices.get(j);
		}

		double profit = rightMax - leftMin;

		double left = getBestProfit(prices, i, leftN);
		double right = getBestProfit(prices, rightI, n);

		return Math.max(profit, Math.max(left, right));
	}
	
	public static List<Double> getList(String filename){
		ArrayList<Double> prices = new ArrayList<>();
		File file = new File( filename );
		Scanner scan;
		try {
			scan = new Scanner( file );
			while( scan.hasNextLine() ) {
				String line = scan.nextLine();
				prices.add(Double.valueOf(line));
			}
			return prices;
		} catch (FileNotFoundException e) {
			System.out.printf("Couldn't find the file: %s\n", filename);
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
}
