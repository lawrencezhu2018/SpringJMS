package xyz.cicy.server.student;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService
{
	private Map<String, Double> scores = new HashMap<>();

	public StudentServiceImpl()
	{
		scores.put("cc", (double) 100);
		scores.put("zz", (double) 99);
	}

	@Override
	public double findScore(String name)
	{
		Double score = scores.get(name);

		if (score == null)
		{
			return 0;
		}

		return score;
	}
}
