package day6;

import java.util.List;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Group
{
	int persons;
	int questions;
	List<String> rawData;

	public Group(List<String> data)
	{
		this.persons = data.size();
		this.rawData = data;
	}
}
