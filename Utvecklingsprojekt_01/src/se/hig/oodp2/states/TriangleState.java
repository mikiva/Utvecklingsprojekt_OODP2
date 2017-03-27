package se.hig.oodp2.states;

import se.hig.oodp2.shapes.Shape;
import se.hig.oodp2.shapes.Triangle;

public class TriangleState implements ShapeState
	{

		@Override
		public Shape createShape(double x, double y, double w, double h)
			{
				// TODO Auto-generated method stub
				return new Triangle(x, y, w, h);
			}

		@Override
		public Shape createShape(double x, double y)
			{
				// TODO Auto-generated method stub
				return new Triangle(x, y);
			}

	}
