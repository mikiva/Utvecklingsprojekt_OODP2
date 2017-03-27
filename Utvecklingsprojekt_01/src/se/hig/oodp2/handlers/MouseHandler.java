package se.hig.oodp2.handlers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

import javax.swing.SwingUtilities;

import se.hig.oodp2.commands.CommandStack;
import se.hig.oodp2.commands.Create;
import se.hig.oodp2.commands.Deselect;
import se.hig.oodp2.commands.Move;
import se.hig.oodp2.commands.SelectOne;
import se.hig.oodp2.menus.PropertiesPopup;
import se.hig.oodp2.projekt.DrawPanel;
import se.hig.oodp2.shapes.SelectedShapes;
import se.hig.oodp2.shapes.Shape;
import se.hig.oodp2.shapes.ShapeList;
import se.hig.oodp2.states.NoSelected;
import se.hig.oodp2.states.SelectedState;

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

		private int fromX;
		private int fromY;
		double meta[];
		private SelectedState selectState;
		private SelectedShapes selectedShape = SelectedShapes.getInstance();
		private boolean hasDragged = false;
		private boolean hasPressed = false;
		private PropertiesPopup popup = PropertiesPopup.getInstance();

		public MouseHandler(DrawPanel pan)
			{

				this.panel = pan;
				this.list = ShapeList.getInstance();
				this.commands = CommandStack.getInstance();
				this.selectState = new NoSelected(this);
				// this.selectedShape = new SelectedShapes();
				addObserver(panel);
				addObserver(selectedShape);

			}

		@Override
		public void mouseDragged(MouseEvent e)
			{
				hasDragged = true;
				if (selected != null && selectState.isSelected(selected))
					{
						selectedShape.move((int) e.getX() - (x1), (int) e.getY() - (y1));

					}
				if (s != null)
					panel.drawDyn(s, e.getX(), e.getY());

				if (hasPressed)
					{
						hasDragged = true;
						create();
					}

				panel.repaint();

			}

		@Override
		public void mouseMoved(MouseEvent e)
			{

			}

		@Override
		public void mouseClicked(MouseEvent e)
			{

				panel.repaint();
			}

		@Override
		public void mouseEntered(MouseEvent e)
			{

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

				if (SwingUtilities.isRightMouseButton(e) && selected != null)
					{

						popup.populateMenu(selected);

					}

				else
					{

						if (selected == null)
							{
								selectState.deSelect();
								x = e.getX();
								y = e.getY();
								mX = e.getX();
								mY = e.getY();

								hasPressed = true;

							}

						else
							{
								// System.out.println(selected.toString());
								// System.out.println(selected.toString() + "
								// selected");
								if (!(selected instanceof SelectedShapes) && e.isShiftDown())
									selectShape(selected);

								else if (selected instanceof SelectedShapes && e.isShiftDown())
									{
										deSelectShape(e.getX(), e.getY());

									}
								else if (!(selected instanceof SelectedShapes) && e.isControlDown())
									{
										/**
										 * 
										 * 
										 * 
										 * 
										 * 
										 * SE ÖVER COMMAND
										 */
										// List<Shape> tempList = new
										// LinkedList<>();
										//
										// for(Shape s :
										// selectedShape.getShapesFromComp())
										// tempList.add(s);

										// selectedShape.clear();

										commands.doCommand(new SelectOne(this, selected));
										// setState(new NoSelected(this));

										// selectShape(selected);
										panel.repaint();
									}

								if (selectedShape != null)
									{
										fromX = selectedShape.getX();
										fromY = selectedShape.getY();

										x1 = e.getX() - selectedShape.getX();
										y1 = e.getY() - selectedShape.getY();
										System.out.println(selectedShape.toString());

									}

							}
						// if (selected == null)
						// {
						//
						//
						// }
					}

				panel.repaint();

			}

		@Override
		public void mouseReleased(MouseEvent e)
			{
				mX = (e.getX() - mX);
				mY = (e.getY() - mY);
				if (s != null)
					{
						s.setSize(mX, mY);

						// System.out.println(s.toString());
					}
				if (selected != null && selectedShape.inside(e.getX(), e.getY()) && hasDragged)
					{
						commands.doCommand(new Move(fromX, fromY, selected.getX(), selected.getY(), selected));
					}

				s = null;
				selected = null;
				setChanged();
				notifyObservers();
				panel.repaint();
				hasDragged = false;
				hasPressed = false;

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
					}

				panel.repaint();
			}

		public void deSelectShape(int x, int y)
			{

				selectState.deSelect(x, y);

				panel.repaint();
			}

		public void setState(SelectedState state)
			{
				selectState = state;
			}

		public SelectedState getSelectState()
			{
				return selectState;
			}

		public void create()
			{

				if (hasPressed && hasDragged)
					{
						s = panel.createShape(x, y);

						commands.doCommand(new Create(s, panel));
						hasPressed = false;
					}

			}

	}
