package se.hig.oodp2.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

public class SelectedShapes implements Shape
	{
		private ShapeList<Shape> compList;
		private double x = -1;
		private double y = -1;
		private double mX;
		private double mY;

		public SelectedShapes()
			{
				compList = new ShapeList<>();

			}

		@Override
		public void draw(Graphics g)
			{
				
				for (Shape s : compList)
					s.draw(g);

			}

		@Override
		public void move()
			{

			}

		@Override
		public void move(int x, int y)
			{
				for (Shape s : compList)
					{

						double[] mCoor = s.getMoveCoor();
						int dx = (int)(x - (mCoor[0]-s.getX()));
						int dy = (int)(y - (mCoor[1]-s.getY()));

						s.move((int)(x+(mCoor[0])), (int)(y+(mCoor[1])));
					}

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
				// TODO Auto-generated method stub

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
				// TODO Auto-generated method stub

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
		public double[] getShapeMeta()
			{

				return null;
			}

		@Override
		public void setX(double x)
			{
				if (this.x < 0 || this.x > x)
					this.x = x;
			}

		@Override
		public void setY(double y)
			{
				if (this.y < 0 || this.y > y)
					this.y = y;

			}

		public void setMoveCoor(double x, double y)
			{
				for (Shape s : compList)
					{
						s.setMoveCoor(x, y);
					}
			}

		public void addShape(Shape s)
			{
				setX(s.getX());
				setY(s.getY());
				compList.add(s);

			}

		public String toString()
			{

				StringBuilder str = new StringBuilder();
				for (Shape s : compList)
					{
						str.append(s.toString() + " \n");
					}
				return str.toString();
			}

		@Override
		public double[] getMoveCoor()
			{
				// TODO Auto-generated method stub
				return null;
			}

	}
