package test.assignment;

import java.util.Collection;
import java.util.Optional;

public interface FluentApi {
	Collection<Data> find();
	Optional<Data> findOne();
	FluentApi and();
	FluentApi or();
	FluentApi type(String type);
	FluentApi types(Collection<String> types);
	FluentApi category(String category);
	FluentApi categories(Collection<String> categories);
	Collection<Data> isActive();
	
}
