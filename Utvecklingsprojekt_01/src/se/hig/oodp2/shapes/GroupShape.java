package se.hig.oodp2.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class GroupShape implements Shape, Observer
	{
		private ShapeList<Shape> compList;
		private double x = -1;
		private double y = -1;
		private double w;
		private double h;
		private boolean isVisible = true;
		private SelectedShapes shapes = SelectedShapes.getInstance();

		public GroupShape()
			{
				compList = new ShapeList<>();
				List<Shape> selShapes = shapes.getShapesFromComp();
				for (Shape s : selShapes)
					{
						compList.add(s);
					}
				selShapes.clear();

			}

		@Override
		public void draw(Graphics g)
			{

				for (Shape s : compList)
					s.draw(g);

				if (!compList.isEmpty())
					{
						g.setColor(Color.blue);
						new Line(x, y, (x + w), y).draw(g);
						new Line(x, y, x, (y + h)).draw(g);

					}
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

						int dx = (int) (s.getX() - this.x);
						int dy = (int) ((s.getY() - this.y));

						s.move(x + dx, y + dy);

					}

				this.x = x;
				this.y = y;

			}

		@Override
		public boolean inside(int x, int y)
			{

				for (Shape s : compList)
					{
						if (s.inside(x, y))
							return true;
					}

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

				int tempX = -1;
				int tempY = -1;
				for (Shape s : compList)
					{
						if (tempX < (s.getX() + s.getWidth()))
							tempX = ((s.getX() + s.getWidth()));
						if (tempY < (s.getY() + s.getHeight()))
							tempY = ((s.getY() + s.getHeight()));
					}
				this.w = tempX - this.x;
				;
				this.h = tempY - this.y;

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

				this.x = -1;
				for (Shape s : compList)
					{
						if (this.x < 0 || this.x > s.getX())
							this.x = s.getX();
					}

				// if (this.x < 0 || this.x > x)
				// this.x = x;
			}

		@Override
		public void setY(double y)
			{
				this.y = -1;

				for (Shape s : compList)
					{
						if (this.y < 0 || this.y > s.getY())
							this.y = s.getY();
					}

				// if (this.y < 0 || this.y > y)
				// this.y = y;

			}



		public void selectShape(Shape s)
			{
				compList.add(s);
				setX(s.getX());
				setY(s.getY());
				setSize(s.getX(), s.getY());

			}

		public void deselect(Shape s)
			{
				compList.remove(s);
				if (!compList.isEmpty())
					{
						Shape t = compList.get(compList.size() - 1);
						setX(t.getX());
						setY(t.getY());
						setSize(t.getX(), t.getY());
					}
				else
					setSize(0, 0);
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



		public List<Shape> getShapesFromComp()
			{
				return compList;
			}

		@Override
		public void update(Observable o, Object arg)
			{
				setSize(0, 0);

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
		public void clear(){
			compList.clear();
		}

	}
