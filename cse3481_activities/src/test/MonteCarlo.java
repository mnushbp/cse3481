package test;

import java.util.Random;

public class MonteCarlo
{
	public static void main(String[] args) throws Exception
	{
		Random rng = new Random();
		final int DRAWS = 1000000;
		int inside = 0;
		for (int i = 0; i < DRAWS; i++)
		{
			double x = rng.nextDouble();
			double y = rng.nextDouble();
			if (x*x + y*y <= 1)
			{
				inside++;
			}
		}
		System.out.println("Exact = " + Math.PI / 4);
		System.out.println((double) inside / DRAWS);
	}
}

