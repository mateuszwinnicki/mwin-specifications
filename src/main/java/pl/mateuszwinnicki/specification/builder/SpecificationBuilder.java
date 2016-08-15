package pl.mateuszwinnicki.specification.builder;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

/**
 * Specification builder for method findAll from {@link org.springframework.data.jpa.repository.JpaSpecificationExecutor}
 *
 * @param <T> is entity we wanted to fetch
 */
public class SpecificationBuilder<T> {

	private Specifications<T> specification;
	
	public SpecificationBuilder() {
		
	}
	
	public SpecificationBuilder(final Specification<T> spec) {
		specification = Specifications.where(spec);
	}
	
	public SpecificationBuilder<T> appendOr(final Specification<T> spec) {
		specification = Specifications.where(spec).or(specification);
		return this;
	}
	
	public SpecificationBuilder<T> appendAnd(final Specification<T> spec) {
		specification = Specifications.where(spec).and(specification);
		return this;
	}
	
	public Specification<T> build() {
		return Specifications.where(specification);
	}
	
}