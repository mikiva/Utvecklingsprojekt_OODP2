package se.hig.oodp2.menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import se.hig.oodp2.commands.ChangeColor;
import se.hig.oodp2.commands.ChangeStroke;
import se.hig.oodp2.commands.CommandStack;
import se.hig.oodp2.projekt.DrawPanel;
import se.hig.oodp2.shapes.SelectedShapes;
import se.hig.oodp2.shapes.Shape;

public class PropertiesPopup extends JPopupMenu
	{
		/**
		* 
		*/
		private static final long serialVersionUID = 1L;
		private JMenuItem colorItem;
		private JMenuItem strokeItem;
		private SelectedShapes sel = SelectedShapes.getInstance();
		private static PropertiesPopup popup = new PropertiesPopup();
		private CommandStack commands = CommandStack.getInstance();

		public static PropertiesPopup getInstance()
			{
				return popup;
			}

		private PropertiesPopup()
			{
				super();
				colorItem = new JMenuItem("Color");
				strokeItem = new JMenuItem("Stroke");

				colorItem.addActionListener(new ActionListener()
					{

						@Override
						public void actionPerformed(ActionEvent e)
							{

								commands.doCommand(new ChangeColor());

								getInvoker().repaint();
							}
					});
				strokeItem.addActionListener(new ActionListener()
					{
						
						@Override
						public void actionPerformed(ActionEvent e)
							{
								
								commands.doCommand(new ChangeStroke());

								getInvoker().repaint();
							}
					});

			}

		public void populateMenu(Shape s)
			{

				removeAll();
				revalidate();

				if (s.equals(sel))
					{
						add(colorItem);
						add(strokeItem);

					}

				repaint();

			}

	}
