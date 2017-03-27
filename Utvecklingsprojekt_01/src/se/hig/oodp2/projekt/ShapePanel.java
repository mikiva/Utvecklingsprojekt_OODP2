package se.hig.oodp2.projekt;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import se.hig.oodp2.commands.CommandStack;
import se.hig.oodp2.states.CircleState;
import se.hig.oodp2.states.EllipseState;
import se.hig.oodp2.states.LineState;
import se.hig.oodp2.states.RectangleState;
import se.hig.oodp2.states.StickManState;
import se.hig.oodp2.states.TriangleState;

public class ShapePanel extends JPanel
	{
		
		private static final long serialVersionUID = 1L;
		DrawPanel drawPanel;
		CommandStack commands;
		
		public ShapePanel(){
			super();
			setBackground(Color.DARK_GRAY);
			setBorder(new EmptyBorder(5,5,5,5));
			setBorder(BorderFactory.createRaisedBevelBorder());
			
			drawPanel = DrawPanel.getInstance();
			commands = CommandStack.getInstance();
			GridBagConstraints c = new GridBagConstraints();
			setLayout(new GridBagLayout());
			c.insets = new Insets(10,5,0,5);
			JLabel name = new JLabel("Shape");
			name.setFont(new Font("Courier New", Font.PLAIN, 11));
			name.setForeground(Color.white);
			c.gridy = 0;
			this.add(name, c);
			
			c.insets = new Insets(0,5,0,5);
			c.anchor = GridBagConstraints.NORTH;
			ShapeButton circleB = new ShapeButton("circle");
			c.fill = GridBagConstraints.NONE;
			
		//	c.gridx = 0;
			c.gridy = 1;
			this.add(circleB, c);
			// setSize(100, 100);
			ShapeButton ellipseB = new ShapeButton("ellipse");
			//c.fill = GridBagConstraints.VERTICAL;
			c.gridy = 2;
			this.add(ellipseB, c);
			
			ShapeButton rectangleB = new ShapeButton("rectangle");
			//c.fill = GridBagConstraints.VERTICAL;
		
			c.gridy = 3;
			this.add(rectangleB, c);
			// setSize(100, 100)


			
			ShapeButton triangleB = new ShapeButton("triangle");
			//c.fill = GridBagConstraints.VERTICAL;
			c.gridy = 4;
			this.add(triangleB, c);

			ShapeButton lineB = new ShapeButton("line");
			//c.fill = GridBagConstraints.VERTICAL;
			c.gridy = 5;
			this.add(lineB, c);

			ShapeButton stickmanB = new ShapeButton("stickMan");
			//c.fill = GridBagConstraints.VERTICAL;
			c.gridy = 6;
			c.weighty = 1;
			this.add(stickmanB, c);
			
			c.weighty = 0;
			ShapeButton undoB = new ShapeButton("undo");
			c.gridy = 7;
			this.add(undoB, c);
			
			c.weighty = 0.1;
			ShapeButton redoB = new ShapeButton("redo");
			c.gridy = 8;
			this.add(redoB, c);

			
			circleB.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e)
						{
							drawPanel.setShapeState(new CircleState());
							
							//status.setText("Circle");
							
						}
				});
			rectangleB.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e)
						{
							drawPanel.setShapeState(new RectangleState());
							//status.setText("Rectangle");
							
						}
				});
			ellipseB.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e)
						{
							drawPanel.setShapeState(new EllipseState());
							//status.setText("Ellipse");
							
						}
				});
			triangleB.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e)
						{
							drawPanel.setShapeState(new TriangleState());
							//status.setText("Ellipse");
						
						}
				});
			lineB.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e)
						{
							drawPanel.setShapeState(new LineState());
							//status.setText("Line");
						
						}
				});
			stickmanB.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e)
						{
							drawPanel.setShapeState(new StickManState());
							//status.setText("Stick Man");
							
						}
				});
			
			undoB.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e)
						{

							commands.undoCommand();
							drawPanel.repaint();

						
						}
				});
			redoB.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e)
						{

							commands.redoCommand();
							drawPanel.repaint();
						}
				});
		
		}
		
		
		
	}
