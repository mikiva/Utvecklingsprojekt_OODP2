package se.hig.oodp2.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public class Ellipse implements Shape, Serializable
	{

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		private boolean isVisible = true;

		public Ellipse(double x, double y)
			{
				this.x = x;
				this.y = y;
				this.color = Color.green;
				
				this.dx = (Math.random()*(-0.5*10));
				this.dy = (Math.random()*(-0.5*10));

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
		public void setX(double x)
			{
				this.x = x;

			}

		@Override
		public void setY(double y)
			{
				this.y = y;

			}



		public String toString()
			{
				return "Ellipse " + isVisible();
			}

		@Override
		public void toggleVisible()
			{
				isVisible = !isVisible;
			
			}

		@Override
		public boolean isVisible()
			{

				return isVisible;
			}

		@Override
		public void setColor()
			{
				setColor(Color.green);
				
			}

	}
