package day2;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Policy
{
	String password;
	int least, most;
	char letter;

	public Policy(final String rawData)
	{
		String firstPart = rawData.split(":")[0];
		String secondPart = rawData.split(":")[1];

		String report = firstPart.split(" ")[0];
		String letter = firstPart.split(" ")[1];

		int least = Integer.parseInt(report.split("-")[0]);
		int most = Integer.parseInt(report.split("-")[1]);

		this.password = secondPart.trim();
		this.least = least;
		this.most = most;
		this.letter = letter.charAt(0);
	}
}

