package se.hig.oodp2.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Triangle implements Shape
	{

		/**
		* 
		*/
		private static final long serialVersionUID = 1L;
		private boolean isVisible = true;
		private double x;
		private double y;
		private double w;
		private double h;
		private int stroke = 1;
		private int[] xPos = new int[3];
		private int[] yPos = new int[3];

		public Triangle(double x, double y, double w, double h)
			{

				this.x = x;
				this.y = y;
				this.w = w;
				this.h = h;

			}

		public Triangle(double x, double y)
			{

				this.x = x;
				this.y = y;

			}

		@Override
		public void draw(Graphics g)
			{
				Graphics2D g2 = (Graphics2D) g;
				g2.setStroke(new BasicStroke(stroke));

				xPos[0] = (int) x;
				xPos[1] = (int) (x + (w / 2));
				xPos[2] = (int) (x + w);

				yPos[0] = (int) (y + h);
				yPos[1] = (int) (y);
				yPos[2] = (int) (y + h);

				g2.drawPolygon(xPos, yPos, 3);

			}

		@Override
		public void move()
			{

			}

		@Override
		public void move(int x, int y)
			{

			}

		@Override
		public boolean inside(int x, int y)
			{
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

			}

		@Override
		public int getWidth()
			{
				return 0;
			}

		@Override
		public int getHeight()
			{
				return 0;
			}

		@Override
		public void setColor(Color c)
			{

			}

		@Override
		public void setColor()
			{

			}

		@Override
		public int getX()
			{
				return 0;
			}

		@Override
		public int getY()
			{
				return 0;
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
		public void setStroke(int stroke)
			{
				this.stroke = stroke;
			}

		@Override
		public Color getColor()
			{
				return null;
			}

		@Override
		public int getStroke()
			{
				return 0;
			}

	}
