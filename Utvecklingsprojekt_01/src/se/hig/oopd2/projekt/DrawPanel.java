package se.hig.oopd2.projekt;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Menus.ShapeMenu;
import se.hig.oodp2.commands.Reset;
import se.hig.oodp2.commands.CommandStack;
import se.hig.oodp2.commands.Delete;
import se.hig.oodp2.handlers.MouseHandler;
import se.hig.oodp2.shapes.GroupShape;
import se.hig.oodp2.shapes.SelectedShapes;
import se.hig.oodp2.shapes.Shape;
import se.hig.oodp2.shapes.ShapeList;
import se.hig.oodp2.states.CircleState;
import se.hig.oodp2.states.ShapeState;

public class DrawPanel extends JPanel implements Observer
	{

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private ShapeList<Shape> list;
		private int mX;
		private int mY;
		private int x = 0;
		private int y = 0;

		private int movX;
		private int movY;
		private ShapeState shapeState;
		private List<Shape> selList;
		private CommandStack commands;
		private Shape tempShape;
		private LayerPanel layerPanel;
		private SelectedShapes selShape = SelectedShapes.getInstance();
		private OpenObject openObj;
		private static DrawPanel panel = new DrawPanel();
		private static ShapeMenu shapeMenu = ShapeMenu.getInstance();

		public static DrawPanel getInstance()
			{
				return panel;
			}

		public DrawPanel()
			{

				super();

				list = ShapeList.getInstance();
				setBackground(Color.gray);
				setPreferredSize(new Dimension(800, 600));
				//setBorder(BorderFactory.createBevelBorder(12));
				MouseHandler handler = new MouseHandler(this);
				new Thread(new Mover()).start();
				addMouseListener(handler);
				addMouseMotionListener(handler);
				shapeState = new CircleState();
				selList = new ShapeList<>();
				commands = CommandStack.getInstance();
				openObj = OpenObject.getInstance();

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
					{
						if (c.isVisible())
							c.draw(g);
					}

				if (tempShape != null)
					tempShape.draw(g);

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
		public void delete()
			{

				commands.doCommand(new Delete());
				repaint();
			}

		public void setShapeState(ShapeState state)
			{
				this.shapeState = state;
			}

		public void clear()
			{
				commands.doCommand(new Reset());

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

		public void unGroup()
			{

				selShape.unGroup();
			}

		public void saveShape()
			{

				List<Shape> sL = selShape.getShapesFromComp();

				if (sL.size() == 1)
					{
						if (sL.get(0) instanceof GroupShape)
							new WriteObject((GroupShape) sL.get(0));
					}

				shapeMenu.fillMenu();
			}
		
		public void saveImage()
			{
				
				new WriteImage(list);
				
			}

		public void open()
			{
				// OpenObject oo = new OpenObject();
			for(Shape sh : list)
				System.out.println(sh.toString());
			}
		public void clearSelected(){
			selShape.clear();
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

//								 for(Shape c : list)
//								 c.move();

								repaint();
							}
					}

			}

		@Override
		public void update(Observable o, Object arg)
			{
			//	System.out.println("update");

				repaint();

			}



	}
