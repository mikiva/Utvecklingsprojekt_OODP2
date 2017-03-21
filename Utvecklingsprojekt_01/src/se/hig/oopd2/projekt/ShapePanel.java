package se.hig.oopd2.projekt;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			ShapeButton but1 = new ShapeButton("circle");
			c.fill = GridBagConstraints.NONE;
			
		//	c.gridx = 0;
			c.gridy = 1;
			this.add(but1, c);
			// setSize(100, 100);
			
			ShapeButton but2 = new ShapeButton("rectangle");
			//c.fill = GridBagConstraints.VERTICAL;
		
			c.gridy = 2;
			this.add(but2, c);
			// setSize(100, 100)

			ShapeButton but3 = new ShapeButton("ellipse");
			//c.fill = GridBagConstraints.VERTICAL;
			c.gridy = 3;
			this.add(but3, c);

			ShapeButton but4 = new ShapeButton("line");
			//c.fill = GridBagConstraints.VERTICAL;
			c.gridy = 4;
			this.add(but4, c);

			ShapeButton but5 = new ShapeButton("stickMan");
			//c.fill = GridBagConstraints.VERTICAL;
			c.gridy = 5;
			c.weighty = 1;

			this.add(but5, c);
			

			
			but1.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e)
						{
							drawPanel.setShapeState(new CircleState());
							
							//status.setText("Circle");
							repaint();
						}
				});
			but2.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e)
						{
							drawPanel.setShapeState(new RectangleState());
							//status.setText("Rectangle");
							repaint();
						}
				});
			but3.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e)
						{
							drawPanel.setShapeState(new EllipseState());
							//status.setText("Ellipse");
							repaint();
						}
				});
			but4.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e)
						{
							drawPanel.setShapeState(new LineState());
							//status.setText("Line");
							repaint();
						}
				});
			but5.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e)
						{
							drawPanel.setShapeState(new StickManState());
							//status.setText("Stick Man");
							repaint();
						}
				});
		
		}
		
		
	}
