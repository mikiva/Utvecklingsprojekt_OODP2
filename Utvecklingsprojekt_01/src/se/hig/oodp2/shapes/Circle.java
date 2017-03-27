package se.hig.oodp2.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Circle implements Shape
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
		private int stroke = 1;

		private Color color;

		private boolean isVisible = true;

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
				this.color = Color.yellow;
				this.dx = (Math.random() - 0.5) * 10;
				this.dy = (Math.random() - 0.5) * 10;

			}

		@Override
		public void draw(Graphics g)
			{
				Graphics2D g2 = (Graphics2D) g;
				g2.setStroke(new BasicStroke(stroke));

				g2.setColor(color);
				g2.drawOval((int) (x), (int) (y), (int) h, (int) h);
				g2.fillOval((int) x, (int) y, (int) radius, (int) radius);

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
			//	System.out.println(x + "  " + y);

				this.x = x;
				this.y = y;
			}

		public void move()
			{
				move((int) (x + dx), (int) (y + dy));
			}

		public boolean inside(int x, int y)
			{

				double dx = this.x + (h / 2);
				double dy = this.y + (h / 2);
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
				return "Circle";
			}

		@Override
		public void setColor(Color c)
			{
				this.color = c;

			}

		@Override
		public int getX()
			{
		
				return (int) x;
			}

		@Override
		public int getY()
			{
		
				return (int) y;
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
		public void setStroke(int stroke)
			{
				this.stroke = stroke;;
				
			}

		@Override
		public Color getColor()
			{
				// TODO Auto-generated method stub
				return this.color;
			}

		@Override
		public int getStroke()
			{

				return this.stroke;
			}

	}
