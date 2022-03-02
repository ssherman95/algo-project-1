import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Project1 {

	public static void main(String[] args) {
		ArrayList<Double> prices = new ArrayList<Double>();
		getlist(args[0], prices);
		//getlist("bitcoin.txt", prices);
		System.out.println(prices.get(1822));
		int n = prices.size();
		System.out.println(n);
	}
	
	public static ArrayList<Double> getlist(String filename, ArrayList<Double> prices) {
		File file = new File( filename );
		Scanner scan; 
		try {
			scan = new Scanner( file );
			while( scan.hasNextLine() ) {
				String line = scan.nextLine();
				prices.add(Double.valueOf(line));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return prices;		
	}
	

}
