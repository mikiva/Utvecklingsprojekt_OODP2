package se.hig.oodp2.shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Line implements Shape

	{
		private double x1;
		private double x2;
		private double y1;
		private double y2;
		private Color color;

		public Line(double x1, double y1, double x2, double y2)
			{
				this.x1 = x1;
				this.y1 = y1;
				this.x2 = x2;
				this.y2 = y2;
				this.color = Color.red;
			}

		public Line(double x1, double y1)
			{
				this.x1 = x1;
				this.y1 = y1;

				this.x2 = x1;
				this.y2 = y1;

				this.color = Color.red;
			}

		@Override
		public void draw(Graphics g)
			{
				g.setColor(color);
				g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);

			}

		@Override
		public void move()
			{
				// TODO Auto-generated method stub

			}

		@Override
		public void move(int x, int y)
			{
				// TODO Auto-generated method stub

			}

		@Override
		public boolean inside(int x, int y)
			{
				// TODO Auto-generated method stub
				return false;
			}

		@Override
		public void drawDyn(int x2, int y2)
			{
				this.x2 = x2;
				this.y2 = y2;

			}

		@Override
		public void setSize(int w, int h)
			{
				// TODO Auto-generated method stub

			}

		@Override
		public int getWidth()
			{
				// TODO Auto-generated method stub
				return 0;
			}

		@Override
		public int getHeight()
			{
				// TODO Auto-generated method stub
				return 0;
			}

		@Override
		public void setColor(Color c)
			{
				this.color = c;
			}

		public String toString()
			{

				double length = Math.sqrt(((Math.pow((x2 - x1), 2)) + Math.pow((y2 - y1), 2)));

				return "Length: " + length;
			}

		@Override
		public int getX()
			{
				// TODO Auto-generated method stub
				return 0;
			}

		@Override
		public int getY()
			{
				// TODO Auto-generated method stub
				return 0;
			}

		@Override
		public double[] getShapeMeta()
			{
				// TODO Auto-generated method stub
				return null;
			}

		@Override
		public void setX(double x)
			{
				// TODO Auto-generated method stub
				
			}

		@Override
		public void setY(double y)
			{
				// TODO Auto-generated method stub
				
			}

	}
