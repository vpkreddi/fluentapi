package test.assignment;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FluentApiImpl implements FluentApi {

	private Collection<Data> dataList;
	Predicate<Data> predicate = (data) -> {return true;};
	boolean and;
	boolean or;
	
	public  FluentApiImpl(Collection<Data> dataList) {
		this.dataList = dataList;
	}
	
	@Override
	public Collection<Data> find() {
		// TODO Auto-generated method stub
		dataList = (Collection<Data>) dataList.stream().filter(predicate).collect(Collectors.toList());
		return this.dataList;
	}

	@Override
	public Optional<Data> findOne() {
		// TODO Auto-generated method stub
		Optional<Data> response= dataList.stream().filter(predicate).findAny();
		return response;
	}

	@Override
	public  FluentApi and() {
		and =true;
		return this;
	}

	@Override
	public FluentApi or() {
		or = true;
		return this;
		// TODO Auto-generated method stub
	}

	@Override
	public FluentApi category(String category) {

		if(and) {
			this.predicate = predicate.and((data) -> {
			if(data.getCategory().equals(category))
				return true;
			else 
				return false;
		});
		}
		else if(or){
			this.predicate = predicate.or((data) -> {
				if(data.getCategory().equals(category))
					return true;
				else 
					return false;
			});
		}  else {
			this.predicate = (data) -> {
				if(data.getCategory().equals(category))
					return true;
				else 
					return false;
			};
		}
		return this;
	}

	@Override
	public FluentApi categories(Collection<String> categories) {
		Predicate<Data> pred = null;
		for(String cat : categories) {
			if(pred==null) {
				pred = (data) -> {
					if(data.getCategory().equals(cat))
						return true;
					else 
						return false;
				};
			}
			else {
			pred = pred.or((data) -> {
				if(data.getCategory().equals(cat))
					return true;
				else 
					return false;
			});
			}
			
			
		}
		if(and) this.predicate = predicate.and(pred);
		else if(or) this.predicate = predicate.or(pred);
		else this.predicate =pred;
		return this;
	}

	@Override
	public Collection<Data> isActive() {
		// TODO Auto-generated method stub
		if(and) {
			this.predicate = predicate.and((data) -> {
			if(data.getActive())
				return true;
			else 
				return false;
		});
		}
		else if(or) {
			this.predicate = predicate.or((data) -> {
				if(data.getActive())
					return true;
				else 
					return false;
			});
		}
		else {
			this.predicate = (data) -> {
				if(data.getActive())
					return true;
				else 
					return false;
			};
		}
		return (Collection<Data>) this.dataList.stream().filter(predicate).collect(Collectors.toList());
	}

	@Override
	public FluentApi type(String type) {
		if(and) {
			this.predicate = predicate.and((data) -> {
			if(data.getType().equals(type))
				return true;
			else 
				return false;
		});
		}
		else if(or){
			this.predicate = predicate.or((data) -> {
				if(data.getType().equals(type))
					return true;
				else 
					return false;
			});
		} else {
			this.predicate = (data) -> {
				if(data.getType().equals(type))
					return true;
				else 
					return false;
			};
		}
		return this;
	}

	@Override
	public FluentApi types(Collection<String> types) {
		Predicate<Data> pred = null;
		for(String type : types) {
			if(pred==null) {
				pred = (data) -> {
					if(data.getType().equals(type))
						return true;
					else 
						return false;
				};
			}
			else {
			pred = pred.or((data) -> {
				if(data.getType().equals(type))
					return true;
				else 
					return false;
			});
			}
			
		}

		if(and) this.predicate = predicate.and(pred);
		else if(or) this.predicate = predicate.or(pred);
		else this.predicate =pred;
		return this;
	}

}
