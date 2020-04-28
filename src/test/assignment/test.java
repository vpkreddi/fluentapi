package test.assignment;

import java.util.ArrayList;
import java.util.Collection;

public class test {

	public static void main(String[] args) {
		Data sample = new Data("c","t","k","v","a",true);
		Data sample1 = new Data("b","c","l","x","b",false);
		Data sample2 = new Data("a","b","j","d","c",true);
		Data sample3 = new Data("t","t","k","v","d",false);
		
		Collection<Data> list =new ArrayList<Data>(0);
		list.add(sample);list.add(sample1);list.add(sample2);list.add(sample3);
		
		FluentApi api = new FluentApiImpl(list);
		System.out.println(api.isActive().size());
		api = new FluentApiImpl(list);
		System.out.println(api.category("c").and().isActive().size());
		api = new FluentApiImpl(list);
		System.out.println(api.type("t").find().size());
		
		Collection<String> typelist = new ArrayList<String>(0);
		Collection<String> categorylist = new ArrayList<String>(0);
		
		typelist.add("a");typelist.add("b");
		categorylist.add("c");categorylist.add("t");
		
		api = new FluentApiImpl(list);
		System.out.println(api.types(typelist).find().size());
		api = new FluentApiImpl(list);
		System.out.println(api.categories(categorylist).find().size());

	}
	
	

}
