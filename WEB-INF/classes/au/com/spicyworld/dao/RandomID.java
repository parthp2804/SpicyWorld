package au.com.spicyworld.dao;

import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.stream.Collectors;
public class RandomID {
	public static String set_userId() {
		
		Random random = new Random();
		List<Integer> randomNumbers = random.ints(0, 100000).distinct().limit(10).boxed().collect(Collectors.toList());
		String id = randomNumbers.get(0).toString();
		return id;
	}
}
