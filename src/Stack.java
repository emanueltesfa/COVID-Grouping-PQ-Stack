
/**
 * This class deals with the handling of the stack functions that is used in the
 * main such as pushing and popping etc.
 *
 * @author <Emanuel Tesfa>
 * @version <October 1, 2020>
 */

public class Stack {

	private int size;
	private int top;
	private Country[] stackArr;

	/**
	 * This is the constructor for the Stack class where the parameter of arrSize is
	 * passed from main and the stack Array is declared and top is set to 0. Nothing
	 * is returned.
	 *
	 * @param arrSize will be the length of the Country array
	 * @return null
	 */

	public Stack(int arrSize) {
		size = arrSize;
		stackArr = new Country[size];
		top = 0;
	}

	/**
	 * This is a void type method with O(1) notation where the stackArr is loaded in
	 * by the insert Country object
	 *
	 * @param Country object insert is taken from main and loaded in
	 * @return
	 */

	public void push(Country insert) { // insertion
		stackArr[top++] = insert;
	}

	/**
	 * This method takes out the top Country array object from the stack and
	 * decrements the top of stack so that the next object is loaded top.
	 *
	 * @param  
	 * @return Country object insert is taken from main and loaded in
	 */

	public Country pop() {
		return stackArr[top--];
	}

	/**
	 * This method simply prints out the contents of the stack Array in an orderly
	 * fashion using multiple print.
	 *
	 * @param
	 * @return
	 */
	public void printStack() {
		System.out.println("\n\n\nStack Contents: \n"
				+ "\n\t\t\t      Name      Capitol      Population        GDP      \t Cases    Deaths"
				+ "\n-----------------------------------------------------------------------------------------------------------");

		for (int i = 0; i < stackArr.length; i++) {
			System.out.printf("\n%33s %14s %12.0f \t%15.0f \t%7.0f\t %7.0f  ", stackArr[i].getName(),
					stackArr[i].getCapitol(), stackArr[i].getPopulation(), stackArr[i].getGDP(), stackArr[i].getCases(),
					stackArr[i].getDeaths());
		}

	}

	/**
	 * This method checks to see if the top variable is -1, if so then the boolean
	 * true is passed to show that the stack is empty as it is initialized to -1.
	 * 
	 * @param
	 * @return true - the stack is empty
	 * @return false - the stack is not empty
	 * 
	 */

	public boolean isEmpty() {
		if (top == -1)
			return true;
		else
			return false;

	}

	/**
	 * This method checks to see if the top variable is the length of the array-1,
	 * if so then the boolean true is passed to show that the stack is full to the
	 * end of the array which as the last index is known as length minus 1.
	 * 
	 * @param
	 * @return true - stack is full
	 * @return false - stack is not full
	 */

	public boolean isFull() {
		if (top == (size - 1))
			return true;
		else
			return false;

	}

}
