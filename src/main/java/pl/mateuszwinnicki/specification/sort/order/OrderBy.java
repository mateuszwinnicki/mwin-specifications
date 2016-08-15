package pl.mateuszwinnicki.specification.sort.order;

import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import pl.mateuszwinnicki.specification.sort.strategy.SortByStrategy;

public class OrderBy implements SortOrder {

	private final String sortBy;
	private final String sortDirection;
	private final SortByStrategy sortByStrategy;
	
	public OrderBy(final String sortBy, final String sortDirection, final SortByStrategy sortByStrategy) {
		this.sortBy = sortBy;
		this.sortDirection = sortDirection;
		this.sortByStrategy = sortByStrategy;
	}

	@Override
	public Order sortOrder() {
		return new Order(
			direction(),
			sortProperty()	
		);
	}
	
	private Direction direction() {
		return Sort.Direction.fromString(
			Optional.ofNullable(sortDirection)
			.orElse(Sort.Direction.ASC.toString())
		);
	}
	
	private String sortProperty() {
		try {
			return sortByStrategy.value(
				Optional.ofNullable(sortBy).orElseThrow(
					() -> new IllegalArgumentException()
				).toUpperCase()
			);
		} catch (final IllegalArgumentException e) {
			return sortByStrategy.defaultValue();
		}
	}
	
}
