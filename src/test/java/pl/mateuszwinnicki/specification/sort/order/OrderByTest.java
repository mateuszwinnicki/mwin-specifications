package pl.mateuszwinnicki.specification.sort.order;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import pl.mateuszwinnicki.specification.sort.order.strategy.PersonSortStrategy;

public class OrderByTest {

	@Test
	public void sortOrder_sortByNullSortDirectionNullPersonSortStrategy_directionASCsortByDefault() {
		PersonSortStrategy sortByStrategy = new PersonSortStrategy();
		SortOrder order = new OrderBy(null, null, sortByStrategy);
		Order result = order.sortOrder();
		assertEquals(Direction.ASC, result.getDirection());
		assertEquals(sortByStrategy.defaultValue(), result.getProperty());
	}

	@Test
	public void sortOrder_sortByNotExistingPropertySortDirectionNotExistingPersonSortStrategy_directionASCsortByDefault() {
		PersonSortStrategy sortByStrategy = new PersonSortStrategy();
		SortOrder order = new OrderBy("notExistingProperty", "notExistingDirection", sortByStrategy);
		Order result = order.sortOrder();
		assertEquals(Direction.ASC, result.getDirection());
		assertEquals(sortByStrategy.defaultValue(), result.getProperty());
	}
	
	@Test
	public void sortOrder_sortBySurnameSortDirectionDESCPersonSortStrategy_directionDESCsortBySurname() {
		PersonSortStrategy sortByStrategy = new PersonSortStrategy();
		SortOrder order = new OrderBy("surname", "DESC", sortByStrategy);
		Order result = order.sortOrder();
		assertEquals(Direction.DESC, result.getDirection());
		assertEquals("surname", result.getProperty());
	}

}
