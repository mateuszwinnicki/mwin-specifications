package pl.mateuszwinnicki.specification.page;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.data.domain.Pageable;

public class PaginationTest {

	private static final int DEFAULT_ITEMS_PER_PAGE = 20;
	private static final int DEFAULT_PAGE = 0;
	
	@Test
	public void pageable_itemsNullPageNull_items20page0() {
		Pageable result = new Pagination(null, null).pageable();
		assertEquals(DEFAULT_ITEMS_PER_PAGE, result.getPageSize());
		assertEquals(DEFAULT_PAGE, result.getPageNumber());
	}
	
	@Test
	public void pageable_itemsUnder1PageUnder0_items20page0() {
		Pageable result = new Pagination(-1, 0).pageable();
		assertEquals(DEFAULT_ITEMS_PER_PAGE, result.getPageSize());
		assertEquals(DEFAULT_PAGE, result.getPageNumber());
	}
	
	@Test
	public void pageable_items100Page2_items100page2() {
		Pageable result = new Pagination(2, 100).pageable();
		assertEquals(100, result.getPageSize());
		assertEquals(2, result.getPageNumber());
	}

}