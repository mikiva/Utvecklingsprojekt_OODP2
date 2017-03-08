package se.hig.oodp2.shapes;

import java.awt.Color;
import java.awt.Graphics;

public class SelectedShapes implements Shape
	{
		private ShapeList<Shape> compList;

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
				// TODO Auto-generated method stub
				return 0;
			}

		@Override
		public int getY()
			{
				// TODO Auto-generated method stub
				return 0;
			}

		@Override
		public double[] getShapeMeta()
			{

				return null;
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

		public void addShape(Shape s)
			{
				compList.add(s);

			}

	}
