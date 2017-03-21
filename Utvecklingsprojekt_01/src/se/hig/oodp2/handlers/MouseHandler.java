package se.hig.oodp2.handlers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;
import java.util.Observable;

import se.hig.oodp2.commands.CommandStack;
import se.hig.oodp2.commands.Create;
import se.hig.oodp2.commands.Move;
import se.hig.oodp2.shapes.SelectedShapes;
import se.hig.oodp2.shapes.Shape;
import se.hig.oodp2.shapes.ShapeList;
import se.hig.oodp2.states.NoSelected;
import se.hig.oodp2.states.SelectedState;
import se.hig.oopd2.projekt.DrawPanel;

public class MouseHandler extends Observable implements MouseListener, MouseMotionListener
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
		private boolean hasDragged = false;

		public MouseHandler(DrawPanel pan)
			{

				selList = new ShapeList<>();
				this.panel = pan;
				this.list = ShapeList.getInstance();
				this.commands = CommandStack.getInstance();
				this.selectState = new NoSelected(this);
				this.selectedShape = new SelectedShapes();
				addObserver(panel);
				addObserver(selectedShape);

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
				hasDragged = true;
				if (selectState.isSelected())
					{
						selectedShape.move((int) e.getX() - (x1), (int) e.getY() - (y1));
						//System.out.println("dragged");
						// selectedShape.setMoveCoor(e.getX(), e.getY());
						// selectedShape.move((int) e.getX(), (int) e.getY());

					}
				if (s != null)
					panel.drawDyn(s, e.getX(), e.getY());

				// panel.repaint();

			}

		@Override
		public void mouseMoved(MouseEvent e)
			{
				// TODO Auto-generated method stub

			}

		@Override
		public void mouseClicked(MouseEvent e)
			{

				// if (selected != null && selectState.isSelected(selected))
				// deSelectShape(selected);

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

				selected = panel.isShapeSelected(e.getX(), e.getY());

				if (selected == null)
					selectState.deSelect();

				else
					{
						System.out.println(selected.toString() + " selected");
						if (!(selected instanceof SelectedShapes) && e.isShiftDown())
							selectShape(selected);

						else if (selected instanceof SelectedShapes && e.isShiftDown())
							{
								deSelectShape(e.getX(), e.getY());
							}
						else if(!(selected instanceof SelectedShapes) && e.isControlDown())
							{
								selectedShape.clear();
								selectShape(selected);
							}

						panel.repaint();

						if (selectedShape != null)
							{
								fromX = selectedShape.getX();
								fromY = selectedShape.getY();

								x1 = e.getX() - selectedShape.getX();
								y1 = e.getY() - selectedShape.getY();

							}
					}

				if (selected == null)
					{

						x = e.getX();
						y = e.getY();
						mX = e.getX();
						mY = e.getY();

						s = panel.createShape(x, y);

						commands.doCommand(new Create(s, panel));

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

						System.out.println(s.toString());
					}
				if (selected != null && hasDragged)
					{
						commands.doCommand(new Move(fromX, fromY, selected.getX(), selected.getY(), selected));
					}

				s = null;
				setChanged();
				notifyObservers();
				panel.repaint();
				hasDragged = false;

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
				if (!selectState.isSelected(s))
					{
						selectState.select(s);
						selectedShape = selectState.getSelected();
					}

				panel.repaint();
			}

		public void deSelectShape(int x, int y)
			{

				selectState.deSelect(x, y);

				selectedShape = selectState.getSelected();
				panel.repaint();
			}

		public void setState(SelectedState state)
			{
				selectState = state;
			}

	}
