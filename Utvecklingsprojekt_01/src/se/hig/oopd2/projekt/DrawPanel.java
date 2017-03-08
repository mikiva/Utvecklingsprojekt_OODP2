package se.hig.oopd2.projekt;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JPanel;

import se.hig.oodp2.commands.Clear;
import se.hig.oodp2.commands.CommandStack;
import se.hig.oodp2.commands.Create;
import se.hig.oodp2.commands.Delete;
import se.hig.oodp2.handlers.MouseHandler;
import se.hig.oodp2.shapes.Shape;
import se.hig.oodp2.shapes.ShapeList;
import se.hig.oodp2.states.CircleState;
import se.hig.oodp2.states.ShapeState;

public class DrawPanel extends JPanel
	{

		private ShapeList<Shape> list;
		private int mX;
		private int mY;
		private int x = 0;
		private int y = 0;

		private int movX;
		private int movY;
		ShapeState shapeState;
		private List<Shape> selList;
		private CommandStack commands;
		// private Shape tempShape;

		public DrawPanel()
			{

				super();
				list = ShapeList.getInstance();
				setBackground(Color.gray);
				MouseHandler handler = new MouseHandler(this);
				new Thread(new Mover()).start();
				addMouseListener(handler);
				addMouseMotionListener(handler);
				shapeState = new CircleState();
				selList = new ShapeList<>();
				commands = CommandStack.getInstance();

			}

		public void paintComponent(Graphics g)
			{

				super.paintComponent(g);
				g.drawLine(0, 0, getWidth(), getHeight());
				g.drawLine(getWidth(), 0, 0, getHeight());

				Graphics2D g2 = (Graphics2D) g;
				g2.setStroke(new BasicStroke(2));
				g2.drawLine(movX, 0, movX, getHeight());
				// g.drawLine(movX, 0, movX, getHeight());

				for (Shape c : list)
					c.draw(g);

			}

		public Shape createShape(double x, double y, double w, double h)
			{

				Shape s1 = shapeState.createShape(x, y, w, h);

				// list.add(s);
				// list.add(r);
				// list.add(s1);

				repaint();
				return s1;
			}

		public Shape createShape(double x, double y)
			{

				Shape s1 = shapeState.createShape(x, y);

				// list.add(s);
				// list.add(r);
				// list.add(s1);

				repaint();
				return s1;
			}

		public void addToList(Shape s)
			{
				list.add(s);
			}

		public void drawDyn(Shape s, int x, int y)
			{
				s.drawDyn(x, y);

				repaint();
			}

		public Shape isShapeSelected(int x, int y)
			{
				Shape found = null;

				for (Shape c : list)
					{
						if (c.inside(x, y))
							found = c;
					}

				return found;
			}

		public void selectedShape(Shape s)
			{
				selList.add(s);
			}

		public List<Shape> getSelList()
			{
				return selList;
			}

		public void clearSelList()
			{
				selList.clear();
			}

		public void duplicate()
			{
				if (selList.isEmpty())
					return;

				for (Shape tempShape : selList)
					{

						int w = tempShape.getWidth();
						int h = tempShape.getHeight();
						Shape s = createShape(100, 100, w, h);

						commands.doCommand(new Create(s, this));

						s.toString();
						repaint();
					}

				clearSelList();

			}

		public void delete()
			{
				if (selList.isEmpty())
					return;

				for (Shape s : selList)
					{
						commands.doCommand(new Delete(s, this));
					}
				
			}

		public void setShapeState(ShapeState state)
			{
				this.shapeState = state;
			}

		public void clear()
			{
				commands.doCommand(new Clear());
				// list.clear();
			}

		public void remove(Shape s)
			{
				list.remove(s);
			}

		public void setCommandStack(CommandStack commands)
			{
				this.commands = commands;
			}

		private class Mover implements Runnable
			{

				@Override
				public void run()
					{
						while (true)
							{
								try
									{
										Thread.sleep(20);
									}
								catch (InterruptedException e)
									{
										// TODO Auto-generated catch block
										e.printStackTrace();
									}

								if (getWidth() > 0)
									movX = (movX + 1) % getWidth();
								if (getHeight() > 0)
									movY = (movY + 1) % getHeight();

								// for(Shape c : list)
								// c.move();

								repaint();
							}
					}

			}

	}
