package pl.mateuszwinnicki.specification.builder;

import org.springframework.data.jpa.domain.Specification;

/**
* @param <T> type of specification we want to build (mapped entity)
*/
public interface QueryFilter<T> {

	Specification<T> queryFilter();
	
}