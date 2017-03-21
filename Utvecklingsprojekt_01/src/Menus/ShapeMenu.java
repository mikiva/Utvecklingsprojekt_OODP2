package Menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import se.hig.oodp2.commands.CommandStack;

public class ShapeMenu extends JMenu implements Observer
	{

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		public static ShapeMenu menu = new ShapeMenu("Shapes");
		JMenuItem item;
		CommandStack commands = CommandStack.getInstance();

		private ShapeMenu(String name)
			{
				super(name);

				fillMenu();

				addActionListener(new ActionListener()
					{

						@Override
						public void actionPerformed(ActionEvent e)
							{
								System.out.println(e.getSource());

							}
					});

			}
		
		public static ShapeMenu getInstance(){
			return menu;
		}

		public void fillMenu()
			{
				this.removeAll();
				this.revalidate();
				File folder = new File("shapes/");
				File[] listOfFiles = folder.listFiles();

				for (int i = 0; i < listOfFiles.length; i++)
					{
						if (listOfFiles[i].isFile())
							{
								this.add(new ShapeFileItem(listOfFiles[i].getName()));
							}

						else if (listOfFiles[i].isDirectory())
							{
								System.out.println("Directory " + listOfFiles[i].getName());
							}
					}

			}

		public void openFile()
			{
				System.out.println("Open");
			}

		@Override
		public void update(Observable arg0, Object arg1)
			{
				fillMenu();

			}

	}
