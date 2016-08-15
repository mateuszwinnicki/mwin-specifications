package pl.mateuszwinnicki.specification.sort.strategy;

public interface SortByStrategy {
	
	/**
	 * Should throw IllegalArgumentExeception in case value is not present
	 * @return 
	 */
	String value(final String value);
	
	/**
	 * Should return default value
	 * @return default value
	 */
	String defaultValue();
	
}