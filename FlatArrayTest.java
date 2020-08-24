package it.rm.pagopa.ex1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;

/**
 * The FlatArrayTest test class for FlatArray.
 * Expected result is always [1, 2, 3, 4, 5]
 * 
 * @author V. Agostini
 * @version 1.0
 * @since 23/08/2020
 *
 */
public class FlatArrayTest {

	@Parameter
	private static ArrayList<Object> arrayExpected = new ArrayList<Object>();
	@Parameter
	private ArrayList<Object> arrayInit = new ArrayList<Object>();

	@BeforeClass
	public static void initResult() {
		arrayExpected.add(new Integer(1));
		arrayExpected.add(new Integer(2));
		arrayExpected.add(new Integer(3));
		arrayExpected.add(new Integer(4));
		arrayExpected.add(new Integer(5));
	}

	/**
	 * Clears input array
	 * Called before every test case method
	 */
	@Before
	public void clear() {
		this.arrayInit.clear();
	}

	/**
	 * Test input is a flat array: [1,2,3,4,5].
	 */
	@Test
	public void testBuildFlatArrMonoDim() {
		this.arrayInit.add(new Integer(1));
		this.arrayInit.add(new Integer(2));
		this.arrayInit.add(new Integer(3));
		this.arrayInit.add(new Integer(4));
		this.arrayInit.add(new Integer(5));

		assertEquals(FlatArrayTest.arrayExpected, new FlatArray().buildFlatArr(arrayInit));

	}

	/**
	 * Test input is an array that contains a nested array (liv1) : [1,[2,3],4,5].
	 */
	@Test
	public void testBuildFlatArrNestLiv1() {

		ArrayList<Object> arrayNested1 = new ArrayList<Object>();
		arrayNested1.add(new Integer(2));
		arrayNested1.add(new Integer(3));

		this.arrayInit.add(new Integer(1));
		this.arrayInit.add(arrayNested1);
		this.arrayInit.add(new Integer(4));
		this.arrayInit.add(new Integer(5));

		assertEquals(FlatArrayTest.arrayExpected, new FlatArray().buildFlatArr(arrayInit));

	}

	/**
	 * Test input is an array that contains 2 nested arrays (liv2) : [[1,[2,3]],4,5].
	 */
	@Test
	public void testBuildFlatArrNestLiv2() {

		ArrayList<Object> arrayNested2 = new ArrayList<Object>();
		arrayNested2.add(new Integer(2));
		arrayNested2.add(new Integer(3));

		ArrayList<Object> arrayNested1 = new ArrayList<Object>();
		arrayNested1.add(new Integer(1));
		arrayNested1.add(arrayNested2);

		this.arrayInit.add(arrayNested1);
		this.arrayInit.add(new Integer(4));
		this.arrayInit.add(new Integer(5));

		assertEquals(FlatArrayTest.arrayExpected, new FlatArray().buildFlatArr(arrayInit));

	}

	/**
	 * Test input is an array that contains 3 nested arrays (liv3) : [[1,[[2,3]]],4,5].
	 */
	@Test
	public void testBuildFlatArrNestLiv3() {

		ArrayList<Object> arrayNested3 = new ArrayList<Object>();
		arrayNested3.add(new Integer(3));

		ArrayList<Object> arrayNested2 = new ArrayList<Object>();
		arrayNested2.add(new Integer(2));
		arrayNested2.add(arrayNested3);

		ArrayList<Object> arrayNested1 = new ArrayList<Object>();
		arrayNested1.add(new Integer(1));
		arrayNested1.add(arrayNested2);

		this.arrayInit.add(arrayNested1);
		this.arrayInit.add(new Integer(4));
		this.arrayInit.add(new Integer(5));

		assertEquals(FlatArrayTest.arrayExpected, new FlatArray().buildFlatArr(arrayInit));

	}

	/**
	 * Test input is an array that contains 2 arrays (liv1) : [1,[2,3],[4,5]].
	 */
	@Test
	public void testPluriArray() {
		ArrayList<Object> arrayNested1 = new ArrayList<Object>();
		arrayNested1.add(new Integer(2));
		arrayNested1.add(new Integer(3));
		
		ArrayList<Object> arrayNested2 = new ArrayList<Object>();
		arrayNested2.add(new Integer(4));
		arrayNested2.add(new Integer(5));

		this.arrayInit.add(new Integer(1));
		this.arrayInit.add(arrayNested1);
		this.arrayInit.add(arrayNested2);

		assertEquals(FlatArrayTest.arrayExpected, new FlatArray().buildFlatArr(arrayInit));

	}

	/**
	 * Test input is an array that contains 1 Double
	 * Expected result is a RuntimeException
	 */
	@Test(expected = Exception.class)
	public void testErrInput() {

		this.arrayInit.add(new Double(1));
		this.arrayInit.add(new Integer(2));
		this.arrayInit.add(new Integer(3));
		this.arrayInit.add(new Integer(4));
		this.arrayInit.add(new Integer(5));

		assertEquals(FlatArrayTest.arrayExpected, new FlatArray().buildFlatArr(arrayInit));

	}
	
	/**
	 * Prints input and output
	 * Called before every test case method
	 */
	@After
	public void printoutput() {
		System.out.println("input: " + arrayInit);
		System.out.println("output : " + arrayExpected);
		System.out.println("*******************");

	}

}
