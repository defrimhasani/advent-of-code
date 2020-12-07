package day7;

import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Bag
{
	String color;
	List<Pair<Integer, String>> contains;

	public Bag(final String color)
	{
		this.color = color;
		contains = new ArrayList<>();
	}

	public void addColor(Integer amount, String color)
	{
		this.contains.add(new Pair<>(amount, color));
	}
}
