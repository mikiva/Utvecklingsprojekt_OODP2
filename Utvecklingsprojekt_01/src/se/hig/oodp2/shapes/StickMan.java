package se.hig.oodp2.shapes;

import java.awt.Color;
import java.awt.Graphics;

public class StickMan implements Shape
	{

		private static final long serialVersionUID = 1L;
		private double x;
		private double y;
		private double dx;
		private double dy;
		private double w;
		private double h;
		private Color color = Color.orange;
		private boolean isVisible = true;
		private int stroke = 1;
		private Shape[] man = new Shape[5];

		private double x1, y1, x2, y2;

		public StickMan(double x, double y, double w, double h)
			{

				this.x = x;
				this.y = y;

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

				this.x1 = x;
				this.y1 = y;

				this.dx = (Math.random() - 0.5) * 10;
				this.dy = (Math.random() - 0.5) * 10;

			}

		@Override
		public void draw(Graphics g)
			{

				man[0] = new Circle(x1 + w / 6, y1, (2 * (w / 3)), 2 * (w / 3)); // head
				man[1] = new Line(x1 + (w / 2), (y1 + (2 * w / 3)), ((x1 + (w / 2))), (y1 + (h * 0.8))); // body
				man[2] = new Line(x1, (y1 + (w)), (x1 + w), (y1 + w));// arms
				man[3] = new Line(x1 + (w / 2), (y1 + (h * 0.8)), (x1), (y1 + h));// left
																					// leg
				man[4] = new Line(x1 + (w / 2), (y1 + (h * 0.8)), (x1 + w), (y1 + h));// right
																						// leg

				for (Shape s : man)
					{
						s.setColor(this.color);
						s.setStroke(this.stroke);
						s.draw(g);
					}

			}

		@Override
		public void move()
			{
				move((int) (x1 + dx), (int) (y1 + dy));

			}

		@Override
		public void move(int x, int y)
			{

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
				this.h = w * 2;

			}

		@Override
		public void setSize(int w, int h)
			{
			}

		@Override
		public int getWidth()
			{
				return (int) w;
			}

		@Override
		public int getHeight()
			{
				return (int) h;
			}

		@Override
		public void setColor(Color c)
			{
				this.color = c;

			}

		public String toString()
			{
				return "Width: " + this.w + " Height: " + this.h;
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

			}

		@Override
		public void setY(double y)
			{

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

				for (Shape s : man)
					{
						s.setStroke(this.stroke);
						System.out.println(this.stroke);
					}

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
