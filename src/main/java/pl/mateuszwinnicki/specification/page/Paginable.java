package pl.mateuszwinnicki.specification.page;

import org.springframework.data.domain.Pageable;

public interface Paginable {

	Pageable pageable();
	
}