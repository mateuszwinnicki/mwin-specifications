package pl.mateuszwinnicki.specification.page;

import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import pl.mateuszwinnicki.specification.sort.Sorted;

public class Pagination implements Paginable {

	private static final Integer FIRST_PAGE = 0;
	private static final Integer DEFAULT_ITEMS_PER_PAGE = 20;
	private static final Integer MIN_ITEMS_PER_PAGE = 1;
	
	private final Integer page;
	private final Integer itemsPerPage;
	private final Sorted sorted;
	
	public Pagination(final Integer page, final Integer itemsPerPage) {
		this(page, itemsPerPage, null);
	}
	
	public Pagination(final Integer page, final Integer itemsPerPage, final Sorted sorted) {
		this.page = page;	
		this.itemsPerPage = itemsPerPage;
		this.sorted = sorted;
	}
	
	@Override
	public Pageable pageable() {
		return Optional.ofNullable(sorted)
			.map(sorted -> 	new PageRequest(page(), itemsPerPage(), sorted.sortedBy()))
			.orElse(new PageRequest(page(), itemsPerPage()));
	}
	
	private Integer page() {
		return Optional.ofNullable(page)
				.filter(page -> page >= 0)
				.orElse(FIRST_PAGE);
	}
	
	private Integer itemsPerPage() {
		return Optional.ofNullable(itemsPerPage)
				.filter(itemsPerPage -> itemsPerPage >= MIN_ITEMS_PER_PAGE)
				.orElse(DEFAULT_ITEMS_PER_PAGE);
	}
	
	
}