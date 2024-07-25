package Second.Test.Example.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
	public static final List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Type.MEAT),
			new Dish("beef", false, 700, Type.MEAT), new Dish("chicken", false, 400, Type.MEAT),
			new Dish("french fries", true, 530, Type.OTHER), new Dish("rice", true, 350, Type.OTHER),
			new Dish("season fruit", true, 120, Type.OTHER), new Dish("pizza", true, 550, Type.OTHER),
			new Dish("prawns", false, 400, Type.FISH), new Dish("salmon", false, 450, Type.FISH));

	public static void main(String[] args) {

		// list all the dishes on menu which are vegetarian and contain more
		// than 400cal
		System.out.println("List of veg which are more than 400 Cal"); // part A
		List<Dish> veg = menu.stream().filter(p -> p.getCalories() > 400).filter(p -> p.isVegetarian() == true)
				.collect(Collectors.toList());
		veg.forEach(p -> System.out.println(p.getName()));

		// list the first 3 dishes of type Meat in sortedorder, sorted by number
		System.out.println("List of first 3 Meat items");   //part B
		List<Dish> meat = menu.stream().filter(p -> Type.MEAT.equals(p.getType()))
				.sorted((p1, p2) -> p1.getCalories() - p2.getCalories()).limit(3).collect(Collectors.toList());
		meat.forEach(p -> System.out.println(p.getName()));
		
		//return comma separated by dishes;
		System.out.println("list of dishes seperated by comma");
		 String str = menu.stream().map(p->p.getName()).collect(Collectors.joining(","));
		 System.out.println(str);
		 
		 // write an expression determine any dish named french fries  output should be True or false		 
		 boolean boo = menu.stream().filter(p ->p.getName().equalsIgnoreCase("french fries")).findAny().isPresent();		 
		 System.out.println(boo);
		 
		 //largest number of calries in the dishes in the menu. ( find using reduce method)
		 
		Optional<Dish> max = menu.stream().reduce((Dish a, Dish b) -> a.getCalories()>b.getCalories()?a:b);	 
		
		 
		 // if(max.isPresent()) {
			   System.out.println("Dishes with max calary:"+max);
		  // }

	}

}
