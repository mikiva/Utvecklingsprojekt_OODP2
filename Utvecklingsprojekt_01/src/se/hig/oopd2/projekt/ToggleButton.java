package se.hig.oopd2.projekt;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import se.hig.oodp2.shapes.Shape;

public class ToggleButton extends JButton
	{

		private Shape shape;

		public ToggleButton(String text, Shape s)
			{
				super(text);
				this.shape = s;
				setPreferredSize(new Dimension(20, 20));

				addActionListener(new ActionListener()
					{

						@Override
						public void actionPerformed(ActionEvent e)
							{
								shape.toggleVisible();
							//	setText(shape.isVisible()+"");

								updateL();
							}
					});
			}
		public void updateL(){
		
		}

	}
