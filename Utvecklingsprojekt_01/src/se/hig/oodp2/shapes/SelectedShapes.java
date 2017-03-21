package se.hig.oodp2.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class SelectedShapes implements Shape, Observer, Serializable
	{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		private ShapeList<Shape> compList;
		private double x = -1;
		private double y = -1;
		private double w;
		private double h;
		private boolean isVisible = true;
		private List<Shape> list = ShapeList.getInstance();

		private static SelectedShapes selShape = new SelectedShapes();

		public static SelectedShapes getInstance()
			{
				return selShape;
			}

		public SelectedShapes()
			{
				compList = new ShapeList<>();

			}

		@Override
		public void draw(Graphics g)
			{

				for (Shape s : compList)
					s.draw(g);

				if (!compList.isEmpty())
					{
						Graphics2D g2 = (Graphics2D) g;
						g2.setColor(Color.pink);
						g2.setStroke(new BasicStroke(1));
						g2.drawLine((int)x, (int)y, (int)(x+w), (int)y);
						g2.drawLine((int)x, (int)y, (int)x, (int)(y+h));
//						new Line(x, y, (x + w), y).draw(g);
//						new Line(x, y, x, (y + h)).draw(g);
						

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
				if(list.contains(s))
				list.remove(s);
				compList.add(s);
				this.x = (this.x > s.getX()) ? s.getX() : this.x;
//				this.y = (this.y > s.getY()) ? s.getY() : this.y;
				
				setX(0);
				setY(0);
				
//				setX(s.getX());
//				setY(s.getY());
				setSize(0,0);

			}

		public void deselectShape(Shape s)
			{
				list.add(s);
				compList.remove(s);
			
				if (!compList.isEmpty())
					{
//						System.out.println("deselect");
//						setX(compList.get(0).getX());
//						setY(compList.get(0).getY());
//						for(Shape sh : compList){
//						this.x = (this.x > sh.getX()) ? sh.getX() : this.x;
//						this.y = (this.y > sh.getY()) ? sh.getX() : this.y;
						setX(0);
						setY(0);
						
//						}
//						Shape t = compList.get(compList.size() - 1);
//						setX(t.getX());
//						setY(t.getY());
//						setSize(t.getX(), t.getY());
//						System.out.println("deselect");
					}
				else
					setSize(0, 0);

				setSize(0,0);

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

		public void unGroup()
			{

				for (Shape s : compList)
					{
						System.out.println(s.getClass());
						if (s instanceof GroupShape)
							{
								((GroupShape)s).unGroup();
								delete();
							}
					}

			}

		public void clear()
			{
				for(Shape s: compList)
					list.add(s);
				compList.clear();
			}
		public void delete(){
			compList.clear();
		}

		@Override
		public void setColor()
			{
				// TODO Auto-generated method stub

			}

	}
