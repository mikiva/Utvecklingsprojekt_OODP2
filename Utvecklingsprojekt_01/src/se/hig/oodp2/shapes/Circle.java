package se.hig.oodp2.shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Circle implements Shape
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

		public Circle(double x, double y, double w, double h)
			{

				this.x = x;
				this.y = y;
				this.w = w;
				this.h = h;
				this.color = Color.yellow;
				this.dx = (Math.random() - 0.5) * 10;
				this.dy = (Math.random() - 0.5) * 10;

			}

		public Circle(double x, double y)
			{

				this.x = x;
				this.y = y;
				// this.w = w;
				// this.h = h;
				this.color = Color.yellow;
				this.dx = (Math.random() - 0.5) * 10;
				this.dy = (Math.random() - 0.5) * 10;

			}

		@Override
		public void draw(Graphics g)
			{
				g.setColor(color);
				g.fillOval((int) (x), (int) (y), (int) h, (int) h);
				// g.fillOval((int)x, (int)y, (int)radius, (int)radius);

			}

		public void drawDyn(int x2, int y2)
			{

				this.h = x2 - this.x;

			}

		public void setSize(int w, int h)
			{
				this.h = w;
			}

		@Override
		public void move(int x, int y)
			{

				this.x = x;
				this.y = y;
				/*
				 * x = (x + dx) % xmax; y = (y + dy) % ymax;
				 */
			}

		public void move()
			{
				move((int) (x + dx), (int) (y + dy));
			}

		public boolean inside(int x, int y)
			{

				double dx = this.x + (h / 2);
				double dy = this.y + (h / 2);

				// double dx = (x - (this.x)) -(h/2);
				// double dy = (y - (this.y)) -(h/2);

				return (h / 2) * (h / 2) > Math.pow(dx - x, 2) + Math.pow(dy - y, 2);

			}

		public int getWidth()
			{
				return (int) h;
			}

		public int getHeight()
			{
				return (int) h;
			}

		public String toString()
			{
				return null;
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
				// TODO Auto-generated method stub
				
			}

		@Override
		public void setY(double y)
			{
				// TODO Auto-generated method stub
				
			}

		@Override
		public double[] getShapeMeta()
			{
				// TODO Auto-generated method stub
				return null;
			}

		@Override
		public void setMoveCoor(double x, double y)
			{
				moveCoor[0] = this.x - x;
				moveCoor[1] = this.x - y;
				
			}

		@Override
		public double[] getMoveCoor()
			{
				// TODO Auto-generated method stub
				return moveCoor;
			}

	}
