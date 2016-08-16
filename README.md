# mwin-specifications
OOP way for creating good object to working with JpaSpecificationExecutor. You can use this classes if you are using REST interface with query properties (which can be null). 

Example class implementing SortBy interface:

```
public class PersonSortStrategy implements SortByStrategy {

    private enum PersonSortBy {

        ID("uuid"),
        NAME("name"),
        SURNAME("surname"),
        PHONE("phones.phoneNumber"),
        CITY("address.city");
        
        private final String text;

        private PersonSortBy(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }

    }

    @Override
    public String value(final String value) {
        return PersonSortBy.valueOf(value).toString();
    }

    @Override
    public String defaultValue() {
        return PersonSortBy.ID.toString();
    }

}

```
