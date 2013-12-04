package activity4;

import java.awt.Point;

public class Q9support {
	
	public static void main(String[] args) {
		
		//given A:(1, 4), B:(3, 7), C:(5, 1) and D:(7, 2), any two can determine the secret, which one is wrong? mod 11

		//M = (y1 * (-x2/(x1-x2))) + (y2 * (-x1/(x2-x1)))
		
		Point A = new Point(1, 4);
		Point B = new Point(3, 7);
		Point C = new Point(5, 1);
		Point D = new Point(7, 2);
		
		Point[] points = new Point[4];
		points[0] = A;
		points[1] = B;
		points[2] = C;
		points[3] = D;
		
		for(int i = 0; i < 3; i++) {
			for(int j = i+1; j < 4; j++) {
				System.out.printf("%d, %d = (%d * (-%d/%d)) + (%d * (-%d/%d))\n", i, j, points[i].y, points[j].x, (points[i].x - points[j].x) % 11, points[j].y, points[i].x, (points[j].x - points[i].x)%11);
			}
		}
		
		
	}

}
