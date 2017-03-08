package se.hig.oodp2.states;

import se.hig.oodp2.shapes.Line;
import se.hig.oodp2.shapes.Shape;

public class LineState implements ShapeState
	{

	@Override
	public Shape createShape(double x, double y, double w, double h)
		{
			// TODO Auto-generated method stub
			return new Line(x,y, w, h);
		}

	@Override
	public Shape createShape(double x, double y)
		{
			// TODO Auto-generated method stub
			return new Line(x, y);
		}

	}
