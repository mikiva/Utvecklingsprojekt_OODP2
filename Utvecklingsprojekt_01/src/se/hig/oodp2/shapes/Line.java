package se.hig.oodp2.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;

public class Line implements Shape, Serializable

	{
		/**
		* 
		*/
		private static final long serialVersionUID = 1L;
		private double x1;
		private double x2;
		private double y1;
		private double y2;
		private Color color;
		private boolean isVisible = true;
		private double w;
		private double h;
		private int stroke = 1;

		public Line(double x1, double y1, double x2, double y2)
			{
				this.x1 = x1;
				this.y1 = y1;
				this.x2 = x2;
				this.y2 = y2;
				this.color = Color.red;
				setSize((int) (x2 - x1), (int) (y2 - y1));
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
				Graphics2D g2 = (Graphics2D) g;
				g2.setStroke(new BasicStroke(stroke));
				g2.setColor(color);

				g2.drawLine((int) x1, (int) y1, (int) x2, (int) y2);

			}

		@Override
		public void move()
			{

			}

		@Override
		public void move(int x, int y)
			{
				this.x1 = x;
				this.y1 = y;

				this.x2 = (this.x1 + w);
				this.y2 = (this.y1 + h);

			}

		@Override
		public boolean inside(int x, int y)
			{
				if (x < (int) (this.x1 + 15) && x > (int) (this.x1 - 15))
					{
						if (y < (int) (this.y1 + 15) && y > (int) (this.y1 - 15))
							return true;
					}
				else if (x < (int) (this.x2 + 15) && x > (int) (this.x2 - 15))
					{
						if (y < (int) (this.y2 + 15) && y > (int) (this.y2 - 15))
							return true;
					}

				return false;
			}

		@Override
		public void drawDyn(int x2, int y2)
			{
				this.x2 = x2;
				this.y2 = y2;
				setSize((int) (x2 - x1), (int) (y2 - y1));
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

				return (int) (x2 - x1);
			}

		@Override
		public int getHeight()
			{

				return (int) (y2 - y1);
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

				return (int) this.x1;
			}

		@Override
		public int getY()
			{

				return (int) this.y1;
			}

		@Override
		public void setX(double x)
			{
				this.x1 = x;
			}

		@Override
		public void setY(double y)
			{
				this.y1 = y;

			}

		@Override
		public void toggleVisible()
			{

			}

		@Override
		public boolean isVisible()
			{

				return isVisible;
			}

		@Override
		public void setColor()
			{
				setColor(color);

			}

		@Override
		public void setStroke(int stro)
			{
				this.stroke = stro;

			}

		@Override
		public Color getColor()
			{
				return this.color;
			}

		@Override
		public int getStroke()
			{

				return this.stroke;
			}

	}
