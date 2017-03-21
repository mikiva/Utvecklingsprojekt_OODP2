package se.hig.oopd2.projekt;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import se.hig.oodp2.commands.CommandStack;
import se.hig.oodp2.commands.Delete;
import se.hig.oodp2.commands.Group;
import se.hig.oodp2.states.CircleState;
import se.hig.oodp2.states.EllipseState;
import se.hig.oodp2.states.LineState;
import se.hig.oodp2.states.RectangleState;
import se.hig.oodp2.states.StickManState;

public class ControlPanel extends JPanel 
	{
		/**
		* 
		*/
		private static final long serialVersionUID = 1L;
		DrawPanel drawPanel;
		CommandStack commands;

		ControlPanel() throws IOException
			{
				super();

				setLayout(new GridBagLayout());

				commands = CommandStack.getInstance();
				GridBagConstraints c = new GridBagConstraints();
//				ShapeButton but1 = new ShapeButton("circle");
//				c.fill = GridBagConstraints.HORIZONTAL;
//				c.gridx = 0;
//				c.gridy = 0;
//				this.add(but1, c);
//				// setSize(100, 100);
//
//				ShapeButton but2 = new ShapeButton("rectangle");
//				c.fill = GridBagConstraints.HORIZONTAL;
//				c.gridx = 1;
//				c.gridy = 0;
//				this.add(but2, c);
//				// setSize(100, 100)
//
//				ShapeButton but3 = new ShapeButton("ellipse");
//				c.fill = GridBagConstraints.HORIZONTAL;
//				c.gridx = 2;
//				this.add(but3, c);
//
//				ShapeButton but4 = new ShapeButton("line");
//				c.fill = GridBagConstraints.HORIZONTAL;
//				c.gridx = 3;
//				this.add(but4, c);
//
//				ShapeButton but5 = new ShapeButton("stickMan");
//				c.fill = GridBagConstraints.HORIZONTAL;
//				c.gridx = 4;
//				this.add(but5, c);

				Button1 undoB = new Button1("Undo");
				c.gridy = 1;
				c.gridx = 1;
				this.add(undoB, c);

				Button1 redoB = new Button1("Redo");
				c.gridy = 1;
				c.gridx = 2;
				this.add(redoB, c);

				Button1 resetB = new Button1("Clear");
				c.gridy = 1;
				c.gridx = 3;
				this.add(resetB, c);

				Button1 duplicateB = new Button1("Duplicate");
				c.gridy = 1;
				c.gridx = 4;
				this.add(duplicateB, c);
				
				Button1 deleteB = new Button1("Delete");
				c.gridy = 1;
				c.gridx = 5;
				this.add(deleteB, c);
				
				Button1 groupB = new Button1("Group");
				c.gridy = 1;
				c.gridx = 6;
				this.add(groupB, c);
				
				Button1 unGroupB = new Button1("Ungroup");
				c.gridy = 1;
				c.gridx = 7;
				this.add(unGroupB, c);
				
				Button1 saveShapesB = new Button1("Save Shapes");
				c.gridy = 1;
				c.gridx = 8;
				this.add(saveShapesB, c);
				
				Button1 saveImageB = new Button1("Save Image");
				c.gridy = 1;
				c.gridx = 9;
				this.add(saveImageB, c);

				JTextArea status = new JTextArea();
				c.gridx = 0;
				c.gridy = 1;
				this.add(status, c);
				status.setText("Circle");
				
				
				

//				but1.addActionListener(new ActionListener()
//					{
//
//						@Override
//						public void actionPerformed(ActionEvent e)
//							{
//								drawPanel.setShapeState(new CircleState());
//								status.setText("Circle");
//								repaint();
//							}
//					});
//				but2.addActionListener(new ActionListener()
//					{
//
//						@Override
//						public void actionPerformed(ActionEvent e)
//							{
//								drawPanel.setShapeState(new RectangleState());
//								status.setText("Rectangle");
//								repaint();
//							}
//					});
//				but3.addActionListener(new ActionListener()
//					{
//
//						@Override
//						public void actionPerformed(ActionEvent e)
//							{
//								drawPanel.setShapeState(new EllipseState());
//								status.setText("Ellipse");
//								repaint();
//							}
//					});
//				but4.addActionListener(new ActionListener()
//					{
//
//						@Override
//						public void actionPerformed(ActionEvent e)
//							{
//								drawPanel.setShapeState(new LineState());
//								status.setText("Line");
//								repaint();
//							}
//					});
//				but5.addActionListener(new ActionListener()
//					{
//
//						@Override
//						public void actionPerformed(ActionEvent e)
//							{
//								drawPanel.setShapeState(new StickManState());
//								status.setText("Stick Man");
//								repaint();
//							}
//					});
				undoB.addActionListener(new ActionListener()
					{

						@Override
						public void actionPerformed(ActionEvent e)
							{

								commands.undoCommand();
								repaint();
							}
					});
				redoB.addActionListener(new ActionListener()
					{

						@Override
						public void actionPerformed(ActionEvent e)
							{

								commands.redoCommand();
								repaint();
							}
					});

				resetB.addActionListener(new ActionListener()
					{

						@Override
						public void actionPerformed(ActionEvent e)
							{
								drawPanel.clear();
								repaint();

							}
					});
				duplicateB.addActionListener(new ActionListener()
					{

						@Override
						public void actionPerformed(ActionEvent e)
							{

							//	drawPanel.duplicate();
								

								repaint();

							}
					});
				deleteB.addActionListener(new ActionListener()
					{

						@Override
						public void actionPerformed(ActionEvent e)
							{

								commands.doCommand(new Delete());
								

								repaint();

							}
					});
				groupB.addActionListener(new ActionListener()
					{
						
						@Override
						public void actionPerformed(ActionEvent e)
							{
								commands.doCommand(new Group());
								repaint();
								
							}
					});
				unGroupB.addActionListener(new ActionListener()
					{
						
						@Override
						public void actionPerformed(ActionEvent e)
							{
								drawPanel.unGroup();
								repaint();
								
							}
					});

				saveShapesB.addActionListener(new ActionListener()
					{
						
						@Override
						public void actionPerformed(ActionEvent e)
							{
								drawPanel.saveShape();
								repaint();
								
							}
					});
				saveImageB.addActionListener(new ActionListener()
					{
						
						@Override
						public void actionPerformed(ActionEvent e)
							{
								drawPanel.saveImage();
								repaint();
								
							}
					});
			}

		public void setDrawPanel(DrawPanel d)
			{
				this.drawPanel = d;
			}

	}
