package se.hig.oodp2.states;

import se.hig.oodp2.shapes.Circle;
import se.hig.oodp2.shapes.Shape;

public class CircleState implements ShapeState
	{

		@Override
		public Shape createShape(double x, double y, double w, double h)
			{
				return new Circle(x, y, w, h);
			}

		@Override
		public Shape createShape(double x, double y)
			{
				// TODO Auto-generated method stub
				return new Circle(x, y);
			}

	}
