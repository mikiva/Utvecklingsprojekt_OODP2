package se.hig.oodp2.shapes;

import java.awt.Color;
import java.awt.Graphics;

public class StickMan implements Shape
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

		private double x1, y1, x2, y2;

		public StickMan(double x, double y, double w, double h)
			{

				this.x = x;
				this.y = y;
				this.color = Color.BLACK;

				this.x1 = x;
				this.y1 = y;
				this.w = w;
				this.h = h;

				this.dx = (Math.random() - 0.5) * 10;
				this.dy = (Math.random() - 0.5) * 10;

			}

		public StickMan(double x, double y)
			{

				this.x = x;
				this.y = y;
				this.color = Color.BLACK;

				this.x1 = x;
				this.y1 = y;

				this.dx = (Math.random() - 0.5) * 10;
				this.dy = (Math.random() - 0.5) * 10;

			}

		@Override
		public void draw(Graphics g)
			{
				g.setColor(color);
				// g.drawOval((int)(x1), (int)y1, (int)((w)/4), (int)((w)/4));
				// g.drawLine((int)(x1+(w/8)), (int)(y1+(this.w/4)),
				// (int)((x1+(w/8))), (int)(y2+ (w/2)));
				// g.drawLine((int)(x1), (int)(y1+(w/3)),
				// (int)(x1+w/4),(int)(y1+(w/3)));

				g.drawOval((int) (x1 + w/6), (int) y1, (int) ((2*(w/3))), (int)((2*(w/3)))); // head
				g.drawLine((int) (x1 + (w/2)), (int) (y1 + (2*w/3)), (int) ((x1 + (w/2))), (int) (y1 + (h*0.8))); // body
				g.drawLine((int) (x1), (int) (y1 + ((w))), (int) (x1 + w), (int) (y1 + (w))); // arms
				g.drawLine((int) (x1 + (w/2)), (int) (y1 + (h*0.8)), (int) (x1), (int) (y1 + h)); // left
																												// leg
				g.drawLine((int) (x1 + (w / 2)), (int) (y1 + (h*0.8)), (int) (x1 + w), (int) (y1 + h)); // right
																													// leg
				g.setColor(Color.red);
				g.drawLine((int)x1, (int)y1, (int)x1, (int)(y1+h));
				g.drawLine((int)x1, (int)y1, (int)(x1+w), (int)(y1));

			}

		@Override
		public void move()
			{
				move((int) (x1 + dx), (int) (y1 + dy));

			}

		@Override
		public void move(int x, int y)
			{
				// this.x1 = x - w/4;
				// this.y1 = y - h/8;

				this.x1 = x;
				this.y1 = y;

			}

		@Override
		public boolean inside(int x, int y)
			{
				if (x <= (x1 + getWidth()) && x >= x1)
					{
						if (y <= (y1 + getHeight()) && y >= this.y1)
							{
								System.out.println("Found stick man");
								return true;
							}

					}

				return false;
			}

		@Override
		public void drawDyn(int x2, int y2)
			{

				this.w = (x2 - this.x1) / 2;
				this.h = w*2;

			}

		@Override
		public void setSize(int w, int h)
			{
//				this.w = w * 2;
//				this.h = h / 8;
			}

		@Override
		public int getWidth()
			{
				// TODO Auto-generated method stub
				return (int) w;
			}

		@Override
		public int getHeight()
			{
				// TODO Auto-generated method stub
				return (int) h;
			}

		@Override
		public void setColor(Color c)
			{
				// TODO Auto-generated method stub

			}

		public String toString()
			{
				return "Width: " + this.w + " Height: " + this.h;
			}

		@Override
		public int getX()
			{
				// TODO Auto-generated method stub
				return (int) this.x1;
			}

		@Override
		public int getY()
			{
				// TODO Auto-generated method stub
				return (int) this.y1;
			}

		@Override
		public double[] getShapeMeta()
			{
				// TODO Auto-generated method stub
				return new double[]{x1, y1, w, h};
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
		public void setMoveCoor(double x, double y)
			{
				// TODO Auto-generated method stub
				
			}

		@Override
		public double[] getMoveCoor()
			{
				// TODO Auto-generated method stub
				return null;
			}

	}
