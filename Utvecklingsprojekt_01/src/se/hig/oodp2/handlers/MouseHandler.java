package se.hig.oodp2.handlers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

import se.hig.oodp2.commands.CommandStack;
import se.hig.oodp2.commands.Create;
import se.hig.oodp2.commands.Move;
import se.hig.oodp2.shapes.SelectedShapes;
import se.hig.oodp2.shapes.Shape;
import se.hig.oodp2.shapes.ShapeList;
import se.hig.oodp2.states.NoSelected;
import se.hig.oodp2.states.SelectedState;
import se.hig.oopd2.projekt.DrawPanel;

public class MouseHandler implements MouseListener, MouseMotionListener
	{

		private DrawPanel panel;
		private ShapeList<Shape> list;
		Shape selected;
		Shape s;
		private int mX;
		private int mY;
		int x = 0;
		int y = 0;

		int x1 = 0;
		int y1 = 0;
		CommandStack commands;
		private List<Shape> selList;

		private int fromX;
		private int fromY;
		double meta[];
		private SelectedState selectState;
		private SelectedShapes selectedShape;

		public MouseHandler(DrawPanel pan)
			{

				selList = new ShapeList<>();
				this.panel = pan;
				this.list = ShapeList.getInstance();
				this.commands = CommandStack.getInstance();
				this.selectState = new NoSelected(this);

			}

		@Override
		public void mouseDragged(MouseEvent e)
			{

				// if (!panel.getSelList().isEmpty())
				// {
				//
				// for (Shape s : panel.getSelList())
				// {
				// double meta[] = s.getShapeMeta();
				// s.move((int) (e.getX() - (meta[0])), (int) (e.getY() -
				// (meta[1])));
				// }
				// }

				if (selectState.isSelected())
					{
						selectedShape.move((int) e.getX() - (x1), (int) e.getY() - (y1));

						// selectedShape.setMoveCoor(e.getX(), e.getY());
						// selectedShape.move((int) e.getX(), (int) e.getY());

					}
				if (s != null)
					panel.drawDyn(s, e.getX(), e.getY());

				panel.repaint();

			}

		@Override
		public void mouseMoved(MouseEvent e)
			{
				// TODO Auto-generated method stub

			}

		@Override
		public void mouseClicked(MouseEvent e)
			{

				// selected = panel.isShapeSelected(e.getX(), e.getY());
				//
				// if (selected == null)
				// selectState.deSelect();
				//
				// else
				// {
				// selectShape(selected);
				//
				// // selectedShape.setX(selected.getX());
				// // selectedShape.setY(selected.getY());
				// //
				// System.out.println(selectedShape.toString() + "Selected");
				//
				// }
				// if (selected != null && panel.getSelList().isEmpty() ||
				// e.isShiftDown())
				// {
				// selected.setX(e.getX() - selected.getX());
				// selected.setY(e.getY() - selected.getY());
				// panel.selectedShape(selected);
				// }
				// else
				// {
				// panel.clearSelList();
				// // panel.selectedShape(selected);
				// }

				// if (selected != null)
				// {
				// panel.selectedShape(selected);
				// //System.out.println(selected.toString() + " selected");
				// selected = null;
				//
				// }
				panel.repaint();
			}

		@Override
		public void mouseEntered(MouseEvent e)
			{
				// TODO Auto-generated method stub

			}

		@Override
		public void mouseExited(MouseEvent e)
			{
				// TODO Auto-generated method stub

			}

		@Override
		public void mousePressed(MouseEvent e)
			{

				// selected = panel.isShapeSelected(e.getX(), e.getY());
				// if (selected != null)
				// {
				// fromX = selected.getX();
				// fromY = selected.getY();
				//
				// selectedShape.setMoveCoor(e.getX(), e.getY());
				// // x1 = e.getX() - selected.getX();
				// // y1 = e.getY() - selected.getY();
				// }

				// if (panel.getSelList().isEmpty())
				// selected = panel.isShapeSelected(e.getX(), e.getY());
				//
				// else
				// {
				// for (Shape s : panel.getSelList())
				// {
				// fromX = s.getX();
				// fromY = s.getY();
				// System.out.println("found");
				// s.setX(e.getX() - s.getX());
				// s.setY(e.getY() - s.getY());
				// meta = s.getShapeMeta();
				// }
				// }

				// selected = panel.isShapeSelected(e.getX(), e.getY());

				selected = panel.isShapeSelected(e.getX(), e.getY());

				if (selected == null)
					selectState.deSelect();

				else
					{

						selectShape(selected);

						// selectedShape.setX(selected.getX());
						// selectedShape.setY(selected.getY());
						//

						fromX = selectedShape.getX();
						fromY = selectedShape.getY();

						// selectedShape.setMoveCoor(e.getX(), e.getY());
						x1 = e.getX() - selectedShape.getX();
						y1 = e.getY() - selectedShape.getY();
						// System.out.println(selectedShape.toString() +
						// "Selected");

					}

				// if (selectedShape != null)
				// {
				// fromX = selectedShape.getX();
				// fromY = selectedShape.getY();
				//
				// selectedShape.setMoveCoor(e.getX(), e.getY());
				// x1 = e.getX() - selectedShape.getX();
				// y1 = e.getY() - selectedShape.getY();
				//
				// }

				if (selected == null)
					{

						x = e.getX();
						y = e.getY();
						mX = e.getX();
						mY = e.getY();

						s = panel.createShape(x, y);

						commands.doCommand(new Create(s, panel));
						// c1 = new Circle(x, y, mX, mX);

						// else
						// c1 = new Circle(x, y, Math.abs(mX), Math.abs(mY));

						// list.add(c1);
					}

			}

		@Override
		public void mouseReleased(MouseEvent e)
			{
				mX = (e.getX() - mX);
				mY = (e.getY() - mY);
				if (s != null)
					{
						s.setSize(mX, mY);
						// panel.addToList(s);

						System.out.println(s.toString());
					}
				if (selected != null)
					{
						commands.doCommand(new Move(fromX, fromY, selected.getX(), selected.getY(), selected));
					}

				int length = (int) Math.sqrt((Math.pow(mX, 2) + Math.pow(mY, 2)));

				// if (selected == null)
				// {
				// panel.createShape(x, y, mX, mY);
				// //c1 = new Circle(x, y, mX, mX);
				//
				// // else
				// // c1 = new Circle(x, y, Math.abs(mX), Math.abs(mY));
				//
				// //list.add(c1);
				// }

				// System.out.println(length);
				selected = null;
				s = null;
				panel.repaint();

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

		public boolean isInList(Shape shape)
			{
				for (Shape s : list)
					{
						if (s.equals(shape))
							return true;
					}
				return false;
			}

		public void selectShape(Shape s)
			{

				selectState.select(s);
				selectedShape = selectState.getSelected();
				panel.repaint();
			}

		public void setState(SelectedState state)
			{
				selectState = state;
			}

		public void setNullObject()
			{
				List<Shape> l = selectedShape.getShapesFromComp();
			}
	}
