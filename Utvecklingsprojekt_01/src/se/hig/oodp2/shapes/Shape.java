package se.hig.oodp2.shapes;

import java.awt.Color;
import java.io.Serializable;

public interface Shape extends Drawable, Movable, Serializable
	{
		
		public void move();
		public void move(int x, int y);
		public boolean inside(int x, int y);
		public void drawDyn(int x2, int y2);
		public void setSize(int w, int h);
		public int getWidth();
		public int getHeight();
		public void setColor(Color c);
		public void setColor();
		public int getX();
		public int getY();
		public void setX(double x);
		public void setY(double y);
		public void toggleVisible();
		public boolean isVisible();
		
	}
