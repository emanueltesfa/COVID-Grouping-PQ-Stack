
/**
 * This class deals with the handling of the Priority Queues functions that is
 * used in the main such as pushing and popping etc.
 * 
 * @author <Emanuel Tesfa>
 * @version <October 1, 2020>
 */

public class Priority {

	private int size;
	private int nItems;
	private Country[] queArr;

	/**
	 * This is the constructor for the Priority Queue class where the parameter of
	 * queArr is passed from main and the queArray is declared and top is set to 0.
	 * Nothing is returned.
	 *
	 * @param queSize will be the length of the Country queArray
	 * @return null
	 */

	public Priority(int queSize) {
		size = queSize;
		queArr = new Country[size];
		nItems = 0;
	}

	/**
	 * This is a void type method with O(1) notation where the queArr is loaded in
	 * by the insert Country object
	 *
	 * @param Country object insert is taken from main and loaded in
	 * @return
	 */

	public void insert(Country item) {
		int j;
		if (nItems == 0)
			queArr[nItems++] = item;
		else {
			for (j = nItems - 1; j >= 0; j--) {
				if (item.getCFR() < queArr[j].getCFR())
					queArr[j + 1] = queArr[j];
				else
					break;
			}
			queArr[j + 1] = item;
			nItems++;
		}
	}

	/**
	 * This method takes out the top Country array object from the queue and
	 * decrements the top of queue.
	 *
	 * @param Country object insert is taken from main and loaded in
	 * @return the queArr at the length minus 1 is returned
	 */

	public Country remove() {
		return queArr[--nItems];
	}

	/**
	 * This method simply prints out the contents of the queue Array in an orderly
	 * fashion using 2 print statements.
	 *
	 * @param
	 * @return
	 */

	public void printPQueCountry() {
		System.out.println("\n\t\t\t      Name      Capitol      Population        GDP      \t Cases    Deaths"
				+ "\n-----------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < nItems; i++) {
			System.out.printf("\n %33s %14s %12.0f \t%15.0f \t%7.0f\t %7.0f  ", queArr[i].getName(),
					queArr[i].getCapitol(), queArr[i].getPopulation(), queArr[i].getGDP(), queArr[i].getCases(),
					queArr[i].getDeaths());
		}

	}

	/**
	 * This method checks to see if the nItems variable is 0, if so then the boolean
	 * true is passed to show that the queue is empty as it is initialized to 0.
	 * 
	 * @param
	 * @return true - the queue is empty
	 * 
	 */

	public boolean isEmpty() {
		return (nItems == 0);
	}

	/**
	 * This method checks to see if the nItems variable is equivalent to the size,
	 * if so then boolean true is returned.
	 * 
	 * @param
	 * @return true - queue is full
	 */

	public boolean isFull() {
		return (nItems == size);
	}

}
