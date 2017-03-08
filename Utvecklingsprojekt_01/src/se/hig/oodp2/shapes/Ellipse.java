package se.hig.oodp2.shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Ellipse implements Shape
	{

		private double x;
		private double y;
		private double dx;
		private double dy;
		private double radius;
		private double w;
		private double h;
		private int xmax;
		private int ymax;
		private Color color;
		private double[] moveCoor = new double[2];

		public Ellipse(double x, double y)
			{
				this.x = x;
				this.y = y;
				this.color = Color.green;

			}

		public Ellipse(double x, double y, double w, double h)
			{
				this.x = x;
				this.y = y;
				this.w = w;
				this.h = h;
				this.color = Color.green;

			}

		@Override
		public void draw(Graphics g)
			{
				g.setColor(color);
				g.fillOval((int) x, (int) y, (int) w, (int) h);

			}

		@Override
		public void move()
			{
				// TODO Auto-generated method stub

			}

		@Override
		public void move(int x, int y)
			{
				this.x = x;
				this.y = y;

			}

		@Override
		public boolean inside(int x, int y)
			{

				if (x <= this.x + w && x >= this.x)
					{
						if (y <= this.y + h && y >= this.y)
							return true;
					}

				return false;
			}

		@Override
		public void drawDyn(int x2, int y2)
			{
				this.w = x2 - this.x;
				this.h = y2 - this.y;

			}

		@Override
		public void setSize(int w, int h)
			{
				this.w = w;
				this.h = h;

			}

		@Override
		public int getWidth()
			{

				return (int) (this.w);
			}

		@Override
		public int getHeight()
			{
				// TODO Auto-generated method stub
				return (int) this.h;
			}

		@Override
		public void setColor(Color c)
			{
				this.color = c;

			}

		@Override
		public int getX()
			{
				// TODO Auto-generated method stub
				return (int) x;
			}

		@Override
		public int getY()
			{
				// TODO Auto-generated method stub
				return (int) y;
			}

		@Override
		public double[] getShapeMeta()
			{
				return new double[] { dx, dy, w, h };
			}

		@Override
		public void setX(double x)
			{
				dx = x;

			}

		@Override
		public void setY(double y)
			{
				dy = y;

			}

		@Override
		public void setMoveCoor(double x, double y)
			{
				moveCoor[0] = (x - this.x);
				moveCoor[1] = (y - this.y);
			}

		@Override
		public double[] getMoveCoor()
			{
				
				return moveCoor;
			}

	}
