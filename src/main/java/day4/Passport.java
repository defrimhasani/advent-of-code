package day4;


import java.util.HashMap;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Passport
{
	HashMap<String, String> data;

	public Passport(HashMap<String, String> data)
	{
		this.data = data;
	}
}
