package de.cpg.oss.blz;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import de.cpg.oss.blz.validator.Validator;
import org.junit.Test;

public class ValidatorTest {

	@Test
	public void test1() {

		int[] expecteds = new int[5];
		expecteds[0] = Validator.crossSum(0);
		expecteds[1] = Validator.crossSum(2);
		expecteds[2] = Validator.crossSum(16);
		expecteds[3] = Validator.crossSum(128);
		expecteds[4] = Validator.crossSum(1024);

		int[] actuals = new int[5];
		actuals[0] = 0;
		actuals[1] = 2;
		actuals[2] = 1 + 6;
		actuals[3] = 1 + 2 + 8;
		actuals[4] = 1 + 0 + 2 + 4;

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void test2() {

		int[] weights = new int[3];
		weights[0] = 1;
		weights[1] = 3;
		weights[2] = 7;

		int[] expecteds = new int[5];
		expecteds[0] = 1 * 5 + 3 * 4 + 7 * 3 + 1 * 2 + 3 * 1;
		expecteds[1] = 1 * 6 + 3 * 5 + 7 * 4 + 1 * 3 + 3 * 2 + 7 * 1;
		expecteds[2] = 1 * 7 + 3 * 6 + 7 * 5 + 1 * 4 + 3 * 3 + 7 * 2 + 1 * 1;
		expecteds[3] = 1 * 8 + 3 * 7 + 7 * 6 + 1 * 5 + 3 * 4 + 7 * 3 + 1 * 2
				+ 3 * 1;
		expecteds[4] = 1 * 9 + 3 * 8 + 7 * 7 + 1 * 6 + 3 * 5 + 7 * 4 + 1 * 3
				+ 3 * 2 + 7 * 1;

		int[] actuals = new int[5];
		actuals[0] = Validator.sumRightLeft("12345", weights);
		actuals[1] = Validator.sumRightLeft("123456", weights);
		actuals[2] = Validator.sumRightLeft("1234567", weights);
		actuals[3] = Validator.sumRightLeft("12345678", weights);
		actuals[4] = Validator.sumRightLeft("123456789", weights);

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void test3() {

		int[] weights = new int[3];
		weights[0] = 1;
		weights[1] = 3;
		weights[2] = 7;

		int[] expecteds = new int[5];
		expecteds[0] = Validator.crossSum(1 * 5) + Validator.crossSum(3 * 4)
				+ Validator.crossSum(7 * 3) + Validator.crossSum(1 * 2)
				+ Validator.crossSum(3 * 1);
		expecteds[1] = Validator.crossSum(1 * 6) + Validator.crossSum(3 * 5)
				+ Validator.crossSum(7 * 4) + Validator.crossSum(1 * 3)
				+ Validator.crossSum(3 * 2) + Validator.crossSum(7 * 1);
		expecteds[2] = Validator.crossSum(1 * 7) + Validator.crossSum(3 * 6)
				+ Validator.crossSum(7 * 5) + Validator.crossSum(1 * 4)
				+ Validator.crossSum(3 * 3) + Validator.crossSum(7 * 2)
				+ Validator.crossSum(1 * 1);
		expecteds[3] = Validator.crossSum(1 * 8) + Validator.crossSum(3 * 7)
				+ Validator.crossSum(7 * 6) + Validator.crossSum(1 * 5)
				+ Validator.crossSum(3 * 4) + Validator.crossSum(7 * 3)
				+ Validator.crossSum(1 * 2) + Validator.crossSum(3 * 1);
		expecteds[4] = Validator.crossSum(1 * 9) + Validator.crossSum(3 * 8)
				+ Validator.crossSum(7 * 7) + Validator.crossSum(1 * 6)
				+ Validator.crossSum(3 * 5) + Validator.crossSum(7 * 4)
				+ Validator.crossSum(1 * 3) + Validator.crossSum(3 * 2)
				+ Validator.crossSum(7 * 1);

		int[] actuals = new int[5];
		actuals[0] = Validator.sumRightLeft("12345", weights, true);
		actuals[1] = Validator.sumRightLeft("123456", weights, true);
		actuals[2] = Validator.sumRightLeft("1234567", weights, true);
		actuals[3] = Validator.sumRightLeft("12345678", weights, true);
		actuals[4] = Validator.sumRightLeft("123456789", weights, true);

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void test4() {

		assertEquals("123456789", Validator.zeroFill("123456789", 9, 0));
		assertEquals("012345678", Validator.zeroFill("12345678", 9, 0));
		assertEquals("001234567", Validator.zeroFill("1234567", 9, 0));
		assertEquals("000123456", Validator.zeroFill("123456", 9, 0));
		assertEquals("000012345", Validator.zeroFill("12345", 9, 0));

		assertEquals("123456789", Validator.zeroFill("123456789", 9, -10));
		assertEquals("012345678", Validator.zeroFill("12345678", 9, -9));
		assertEquals("001234567", Validator.zeroFill("1234567", 9, -8));
		assertEquals("000123456", Validator.zeroFill("123456", 9, -7));
		assertEquals("000012345", Validator.zeroFill("12345", 9, -6));

		assertEquals("123456789", Validator.zeroFill("123456789", 9, -11));
		assertEquals("012345678", Validator.zeroFill("12345678", 9, -12));
		assertEquals("001234567", Validator.zeroFill("1234567", 9, -13));
		assertEquals("000123456", Validator.zeroFill("123456", 9, -14));
		assertEquals("000012345", Validator.zeroFill("12345", 9, -15));

	}

	@Test
	public void test5() {

		assertEquals("123456789", Validator.zeroFill("123456789", 9, 1));
		assertEquals("102345678", Validator.zeroFill("12345678", 9, 1));
		assertEquals("100234567", Validator.zeroFill("1234567", 9, 1));
		assertEquals("100023456", Validator.zeroFill("123456", 9, 1));
		assertEquals("100002345", Validator.zeroFill("12345", 9, 1));

		assertEquals("123456789", Validator.zeroFill("123456789", 9, -9));
		assertEquals("102345678", Validator.zeroFill("12345678", 9, -8));
		assertEquals("100234567", Validator.zeroFill("1234567", 9, -7));
		assertEquals("100023456", Validator.zeroFill("123456", 9, -6));
		assertEquals("100002345", Validator.zeroFill("12345", 9, -5));
	}

	@Test
	public void test6() {

		assertEquals("123456789", Validator.zeroFill("123456789", 9, -1));
		assertEquals("123456780", Validator.zeroFill("12345678", 9, -1));
		assertEquals("123456700", Validator.zeroFill("1234567", 9, -1));
		assertEquals("123456000", Validator.zeroFill("123456", 9, -1));
		assertEquals("123450000", Validator.zeroFill("12345", 9, -1));

		assertEquals("123456789", Validator.zeroFill("123456789", 9, 9));
		assertEquals("123456780", Validator.zeroFill("12345678", 9, 8));
		assertEquals("123456700", Validator.zeroFill("1234567", 9, 7));
		assertEquals("123456000", Validator.zeroFill("123456", 9, 6));
		assertEquals("123450000", Validator.zeroFill("12345", 9, 5));

		assertEquals("123456789", Validator.zeroFill("123456789", 9, 10));
		assertEquals("123456780", Validator.zeroFill("12345678", 9, 11));
		assertEquals("123456700", Validator.zeroFill("1234567", 9, 12));
		assertEquals("123456000", Validator.zeroFill("123456", 9, 13));
		assertEquals("123450000", Validator.zeroFill("12345", 9, 14));
	}

	@Test
	public void test7() {

		assertEquals("123456789", Validator.zeroFill("123456789", 9, -3));
		assertEquals("123456078", Validator.zeroFill("12345678", 9, -3));
		assertEquals("123450067", Validator.zeroFill("1234567", 9, -3));
		assertEquals("123400056", Validator.zeroFill("123456", 9, -3));
		assertEquals("123000045", Validator.zeroFill("12345", 9, -3));

		assertEquals("123456789", Validator.zeroFill("123456789", 9, 7));
		assertEquals("123456078", Validator.zeroFill("12345678", 9, 6));
		assertEquals("123450067", Validator.zeroFill("1234567", 9, 5));
		assertEquals("123400056", Validator.zeroFill("123456", 9, 4));
		assertEquals("123000045", Validator.zeroFill("12345", 9, 3));

	}

	@Test
	public void test8() {

		assertEquals("1", Validator.last("2221"));
		assertEquals("2", Validator.last("3332"));
		assertEquals("3", Validator.last("4443"));

	}

	@Test
	public void test9() {

		assertEquals("1234567890", Validator.extract("1234567890", 1, -1));
		assertEquals("1234567890", Validator.extract("1234567890", -1, 1));
		assertEquals("1234567890", Validator.extract("1234567890", 1, 10));
		assertEquals("1234567890", Validator.extract("1234567890", 10, 1));
		assertEquals("1234567890", Validator.extract("1234567890", -1, -10));
		assertEquals("1234567890", Validator.extract("1234567890", -10, -1));
		assertEquals("1234567890", Validator.extract("1234567890", 10, -10));
		assertEquals("1234567890", Validator.extract("1234567890", -10, 10));

	}

	@Test
	public void test10() {

		assertEquals("1", Validator.extractChecksum("123456789", 1));
		assertEquals("2", Validator.extractChecksum("123456789", 2));
		assertEquals("9", Validator.extractChecksum("123456789", -1));
		assertEquals("8", Validator.extractChecksum("123456789", -2));
	}

	@Test
	public void test11() {

		assertEquals("1234567890", Validator.zeroTrimFront("1234567890"));
		assertEquals("4567890", Validator.zeroTrimFront("0004567890"));
		assertEquals("234567890", Validator.zeroTrimFront("0234567890"));
	}

	@Test
	public void test12() {

		int[] weights = new int[4];
		weights[0] = 1;
		weights[1] = 2;
		weights[2] = 1;
		weights[3] = 2;

		int[] expecteds = new int[1];
		expecteds[0] = 1 * 1 + 2 * 2 + 1 * 3 + 2 * 4;

		int[] actuals = new int[1];
		actuals[0] = Validator.sumLeftRight("1234", weights);

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void test13() {

		int[] weights = new int[4];
		weights[0] = 1;
		weights[1] = 2;
		weights[2] = 1;
		weights[3] = 2;

		int[] expecteds = new int[1];
		expecteds[0] = Validator.crossSum(1 * 6) + Validator.crossSum(2 * 7)
				+ Validator.crossSum(1 * 8) + Validator.crossSum(2 * 9);

		int[] actuals = new int[1];
		actuals[0] = Validator.sumLeftRight("6789", weights, true);

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void test14() {

		int[] expecteds = { 5, 5, 15, 15, 105, 105, 115, 115 };

		int[] actuals = { Validator.getHalfDecade(0),
				Validator.getHalfDecade(3), Validator.getHalfDecade(7),
				Validator.getHalfDecade(12), Validator.getHalfDecade(99),
				Validator.getHalfDecade(102), Validator.getHalfDecade(108),
				Validator.getHalfDecade(114) };

		assertArrayEquals(expecteds, actuals);
	}
}
