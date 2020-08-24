package it.rm.pagopa.ex1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The FlatArray program implements an application that simply creates a flat array from a multi-dimensional one.
 * 
 * @author V. Agostini
 * @version 1.0
 * @since 23/08/2020
 *
 */
public class FlatArray {

	public static ArrayList<Integer> finArray;

	/**
	 * Default constructor
	 */
	public FlatArray() {
		finArray = new ArrayList<Integer>();
	}

	/**
	 * This is the main method 
	 * @param yourArray
	 * @return finArray
	 * @exception RuntimeException on input error.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Integer> buildFlatArr(ArrayList<Object> yourArray) {

		Iterator<Object> iter = yourArray.iterator();

		while (iter.hasNext()) {
			Object i = iter.next();
			if (i instanceof Integer) {
				finArray.add((Integer) i);
			} else if (i instanceof ArrayList) {
				buildFlatArr((ArrayList<Object>) i);
			} else{
				throw new RuntimeException("Input non atteso");
			}
		}

		return finArray;
	}

}
