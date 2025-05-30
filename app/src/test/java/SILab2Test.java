import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class SILab2Test {

@Test(expected = RuntimeException.class)
public void test_nullItemList_throwsException() {
	SILab2.checkCart(null, "1234567890123456");
	}

@Test(expected = RuntimeException.class)
public void test_itemWithNullName_throwsException() {
	List<Item> items = Arrays.asList(new Item(null, 1, 100, 0));
	SILab2.checkCart(items, "1234567890123456");
	}

@Test(expected = RuntimeException.class)
public void test_itemWithEmptyName_throwsException() {
	List<Item> items = Arrays.asList(new Item("", 1, 100, 0));
	SILab2.checkCart(items, "1234567890123456");
	}

@Test(expected = RuntimeException.class)
public void test_invalidCardNumber_short() {
	List<Item> items = Arrays.asList(new Item("Book", 1, 100, 0));
	SILab2.checkCart(items, "123");
	}

@Test(expected = RuntimeException.class)
public void test_invalidCardNumber_nonDigit() {
	List<Item> items = Arrays.asList(new Item("Book", 1, 100, 0));
	SILab2.checkCart(items, "12345678901234AB");
	}

@Test
public void test_itemWithDiscount() {
	List<Item> items = Arrays.asList(new Item("Phone", 2, 200, 0.1));
	double expected = -30 + 2 * 200 * 0.9;
	double actual = SILab2.checkCart(items, "1234567890123456");
	assertEquals(expected, actual, 0.01);
	}
@Test
public void test_itemWithHighPriceNoDiscount() {
	List<Item> items = Arrays.asList(new Item("TV", 1, 400, 0));
	double expected = -30 + 400;
	double actual = SILab2.checkCart(items, "1234567890123456");
	assertEquals(expected, actual, 0.01);
	}

@Test
public void test_multipleItems_mixed() {
	List<Item> items = Arrays.asList(
		new Item("Book", 2, 50, 0),
		new Item("Monitor", 1, 500, 0.2),
		new Item("Pen", 15, 2, 0)
		double expected = -60 + 100 + 400 + 30;
		double actual = SILab2.checkCart(items, "1234567890123456");
		assertEquals(expected, actual, 0.01);
	}
}
