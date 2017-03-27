package se.hig.oodp2.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Handler;

public class SelectedShapes implements Shape, Observer, Serializable
	{
		private static final long serialVersionUID = 1L;

		private ShapeList<Shape> compList;
		private double x = -1;
		private double y = -1;
		private double w;
		private double h;
		private boolean isVisible = true;
		private List<Shape> list = ShapeList.getInstance();
		private Color color;
		private static SelectedShapes selShape = new SelectedShapes();
		private int stroke;

		public static SelectedShapes getInstance()
			{
				return selShape;
			}

		public SelectedShapes()
			{
				compList = new ShapeList<>();
				stroke = 1;

			}

		@Override
		public void draw(Graphics g)
			{

				Graphics2D g2 = (Graphics2D) g;
				for (Shape s : compList)
					{
						if (s != null)
							s.draw(g2);
						//System.out.println("Complist " + compList.size());

					}

				if (!compList.isEmpty()) // Uncomment these line to show lines
											// where shapes are selected
					{
						// g2.setStroke(new BasicStroke(2));
						// g2.drawLine((int)x, (int)y, (int)(x+w), (int)y);
						// g2.drawLine((int)x, (int)y, (int)x, (int)(y+h));

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
				for (Shape s : compList)
					s.setColor(c);

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

				this.x = -1;
				for (Shape s : compList)
					{
						if (this.x < 0 || this.x > s.getX())
							this.x = s.getX();
					}

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

			}

		public void selectShape(Shape s)
			{
				if (list.contains(s))
					{
						list.remove(s);
						compList.add(s);

						setX(0);
						setY(0);

						setSize(0, 0);
					}
				

			}

		public void deselectShape(Shape s)
			{
				compList.remove(s);
				list.add(s);

				if (!compList.isEmpty())
					{

						setX(0);
						setY(0);

					}
				else
					setSize(0, 0);

				setSize(0, 0);

			}

		public String toString()
			{

				StringBuilder str = new StringBuilder();
				if (compList.isEmpty())
					return "Selected Empty";
				else
					{
						for (Shape s : compList)
							{
								str.append(" + " + s.toString());
							}
						return str.toString();
					}

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

			}

		@Override
		public boolean isVisible()
			{
				return isVisible;
			}

		public void unGroup()
			{

				for (Shape s : compList)
					{
						System.out.println(s.getClass());
						if (s instanceof GroupShape)
							{
								((GroupShape) s).unGroup();
								reset();
							}
					}

			}

		public void clear()
			{
				for (Shape s : compList)
					list.add(s);

				compList.clear();
				//list.remove(this);

			}

		public void reset()
			{
				compList.clear();
			}

		@Override
		public void setColor()
			{

			}

		public boolean noSelected()
			{
				// System.out.println(toString());

				return compList.isEmpty();
			}

		@Override
		public void setStroke(int stroke)
			{
				for (Shape s : compList)
					s.setStroke(stroke);

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
