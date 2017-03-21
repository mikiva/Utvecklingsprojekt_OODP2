package se.hig.oopd2.projekt;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Button1 extends JButton
	{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


		public Button1()
			{
				this("Button");
			}

		public Button1(String name)
			{
				super(name);

				setPreferredSize(new Dimension(110, 30));
				this.addActionListener(new ActionListener()
					{

						@Override
						public void actionPerformed(ActionEvent e)
							{
								getParent().repaint();
								repaint();

							}
					});

			}
	}
