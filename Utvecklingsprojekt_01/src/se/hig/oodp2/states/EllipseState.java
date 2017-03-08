package se.hig.oodp2.states;

import se.hig.oodp2.shapes.Ellipse;
import se.hig.oodp2.shapes.Shape;

public class EllipseState implements ShapeState
	{

	@Override
	public Shape createShape(double x, double y, double w, double h)
		{
			
			return new Ellipse(x, y, w, h);
		}

	@Override
	public Shape createShape(double x, double y)
		{
			// TODO Auto-generated method stub
			return new Ellipse(x,y);
		}

	}
