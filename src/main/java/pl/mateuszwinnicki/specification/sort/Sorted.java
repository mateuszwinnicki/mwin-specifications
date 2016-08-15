package pl.mateuszwinnicki.specification.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;

import pl.mateuszwinnicki.specification.sort.order.OrderBy;

public class Sorted implements SortedBy {

	private final List<OrderBy> orderByList;
	
	public Sorted(final OrderBy... orderBy) {
		this(Arrays.asList(orderBy));
	}
	
	public Sorted(final List<OrderBy> orderByList) {
		this.orderByList = orderByList;
	}
	
	@Override
	public Sort sortedBy() {
		return new Sort(
			orderByList.stream()
			.map(orderBy -> orderBy.sortOrder())
			.collect(Collectors.toList())
		);
	}

	
	
	
}