
/**
* COP 3530: Project 2 – Stacks and Priority Queues 
* <p>
* The main consists of the variable and object declaration, user interactive portion with Scanner, 
* the initialization of c object array. It also continues to load/print of priority queue and stack.
*
* @author <Emanuel Tesfa>
* @version <October 1, 2020>
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project2 {

	public static void main(String[] args) throws FileNotFoundException {

		System.out.println("Name: Emanuel Tesfa" + "COP3530 Project 2\n" + "Instructor: Xudong Liu\n\n");

		// Variable and Object Declaration
		Country[] c = new Country[153];
		Stack cStack = new Stack(153);

		Priority excellentPQ = new Priority(153);
		Priority vGoodPQ = new Priority(153);
		Priority goodPQ = new Priority(153);
		Priority fairPQ = new Priority(153);
		Priority poorPQ = new Priority(153);

		String name = null, capitol = null, fileName = null;
		double gdp = 0, population = 0, cases = 0, deaths = 0;
		int i = 0;
		Country temp = null;

		// User Interactive portion with Scanner
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter in name of file, followed by enter");
		fileName = input.next();

		Scanner read = new Scanner(new File(fileName));

		read.useDelimiter(",|\\n");

		// Initialization of c object array
		for (int j = 0; j < 153; j++) {
			c[j] = new Country();
		}

		// Parsing of CSV File
		while (read.hasNext()) {
			read.nextLine();

			name = read.next();
			capitol = read.next();
			population = read.nextDouble();
			gdp = Double.parseDouble(read.next());
			cases = read.nextDouble();
			deaths = Double.parseDouble(read.next());

			c[i].setName(name);
			c[i].setCapitol(capitol);
			c[i].setPopulation(population);
			c[i].setGDP(gdp);
			c[i].setCases(cases);
			c[i].setDeaths(deaths);

			i++;
		}
		// Loading of Priority Queue
		for (i = 0; i < c.length; i++) {

			if (c[i].getCFR() < 0.01) {
				excellentPQ.insert(c[i]);
				continue;
			} else if ((c[i].getCFR() > 0.01) && (c[i].getCFR() <= 0.02)) {
				vGoodPQ.insert(c[i]);
				continue;
			} else if ((c[i].getCFR() > 0.02) && (c[i].getCFR() <= 0.05)) {
				goodPQ.insert(c[i]);
				continue;
			} else if ((c[i].getCFR() > 0.05) && (c[i].getCFR() <= 0.1)) {
				fairPQ.insert(c[i]);
				continue;
			} else {
				poorPQ.insert(c[i]);
				continue;
			}
		}

		// Printing of Priority Queue
		System.out.println("\n\nPOOR Priority Queue Contents: ");
		poorPQ.printPQueCountry();

		System.out.println("\n\nFair Priority Queue Contents: ");
		fairPQ.printPQueCountry();

		System.out.println("\n\nGood Priority Queue Contents: ");
		goodPQ.printPQueCountry();

		System.out.println("\n\nVery Good Priority Queue Contents: ");
		vGoodPQ.printPQueCountry();

		System.out.println("\n\nExcellent Priority Queue Contents: ");
		excellentPQ.printPQueCountry();

		// Loading into stack
		while (excellentPQ.isEmpty() != true) {
			cStack.push(excellentPQ.remove());
		}
		while (vGoodPQ.isEmpty() != true) {
			cStack.push(vGoodPQ.remove());
		}
		while (goodPQ.isEmpty() != true) {
			cStack.push(goodPQ.remove());
		}
		while (fairPQ.isEmpty() != true) {
			cStack.push(fairPQ.remove());
		}
		while (poorPQ.isEmpty() != true) {
			cStack.push(poorPQ.remove());
		}

		cStack.printStack();


	}

}
