package se.hig.oodp2.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rectangle implements Shape
	{

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private double x;
		private double y;
		private double dx;
		private double dy;
		private double w;
		private double h;
		private int xmax;
		private int ymax;
		private Color color;
		private boolean isVisible = true;

		private double x1, y1, x2, y2;

		public Rectangle(double x, double y, double w, double h)
			{

				this.x = x;
				this.y = y;
				this.w = w;
				this.h = h;

				this.x1 = x;
				this.y1 = y;
				this.x2 = (x+w);
				this.y2 = (y+h);
				this.color = Color.blue;

			}
		public Rectangle(double x, double y)
			{

				this.x = x;
				this.y = y;

				this.x1 = x;
				this.y1 = y;
				this.x2 = (x);
				this.y2 = (y);
				this.color = Color.blue;

			}

		@Override
		public void draw(Graphics g)
			{

				Graphics2D g2 = (Graphics2D)g;
				g2.setStroke(new BasicStroke());
				g2.setColor(color);
				g2.drawLine((int) x1, (int) y1, (int) (x2), (int) (y1)); // top
				g2.drawLine((int) (x2), (int) y1, (int) (x2), (int) (y2)); // right
				g2.drawLine((int) (x1), (int) (y2), (int) (x2), (int) (y2)); // bottom
				g2.drawLine((int) (x1), (int) (y1), (int) (x1), (int) (y2)); // left

				// g.fillRect((int) x, (int) y, (int) (w), (int) (h));

			}

		public void drawDyn(int x2, int y2)
			{

				this.x2 = x2;
				this.y2 = y2;

			}

		public void setSize(int w, int h)
			{
				if (w < 0)
					{
						int temp1 = (int) x2;
						x2 = x1;
						x1 = temp1;
						w = -w;

					}
				if (h < 0)
					{
						int temp2 = (int) y2;
						y2 = y1;
						y1 = temp2;
						h = -h;
					}

				this.w = w;
				this.h = h;
			}

		@Override
		public void move()
			{
				// TODO Auto-generated method stub

			}

		@Override
		public void move(int x, int y)
			{
				this.x1 = x;
				this.y1 = y;

				this.x2 = (x + w);
				this.y2 = (y + h);
			}

		@Override
		public boolean inside(int x, int y)
			{
				if (x <= (x2) && x >= x1)
					{
						if (y <= (y2) && y >= this.y1)
							{
								System.out.println("Found rect");
								return true;
							}

					}

				System.out.println("Not found rect");
				return false;

			}

		@Override
		public int getWidth()
			{
				return (int) (w);
			}

		@Override
		public int getHeight()
			{
				return (int) (h);
			}

		public String toString()
			{
				return "Width: " + (x2 - x1) + " Height: " + (y2 - y1) + " x: " + x1 + " " + x2 + " y: " + y1 + " "
						+ y2;
			}

		@Override
		public void setColor(Color c)
			{
				this.color = color;

			}

		@Override
		public int getX()
			{
				// TODO Auto-generated method stub
				return (int)x1;
			}

		@Override
		public int getY()
			{
				// TODO Auto-generated method stub
				return (int)y1;
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
		public void toggleVisible()
			{
				// TODO Auto-generated method stub
				
			}
		@Override
		public boolean isVisible()
			{
				// TODO Auto-generated method stub
				return isVisible;
			}
		@Override
		public void setColor()
			{
				setColor(Color.blue);
				
			}

	}
