package se.hig.oodp2.menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import se.hig.oodp2.commands.CommandStack;
import se.hig.oodp2.commands.OpenFile;
import se.hig.oodp2.projekt.DrawPanel;

public class ShapeFileItem extends JMenuItem
	{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		String filename;
		DrawPanel panel = DrawPanel.getInstance();
		CommandStack commands = CommandStack.getInstance();

		public ShapeFileItem(String name){
			super(name);
			this.filename = name;
			
		
		addActionListener(new ActionListener()
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
					{
					
						
						commands.doCommand(new OpenFile(filename));
						panel.repaint();
					}
			});
		
		}
		

		
	}
