package Menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import se.hig.oodp2.commands.CommandStack;
import se.hig.oodp2.commands.Delete;
import se.hig.oodp2.commands.Group;
import se.hig.oopd2.projekt.DrawPanel;

public class EditMenu extends JMenu
	{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private JMenuItem undo;
		private JMenuItem redo;
		private JMenuItem reset;
		private JMenuItem delete;
		private JMenuItem group;
		private JMenuItem ungroup;
		private JMenuItem saveShapes;
		private JMenuItem saveImage;

		private CommandStack commands = CommandStack.getInstance();
		private DrawPanel drawPanel = DrawPanel.getInstance();
		private static EditMenu menu = new EditMenu("Edit");

		public static EditMenu getInstance()
			{
				return menu;
			}

		private EditMenu(String name)
			{
				super(name);
				undo = new JMenuItem("Undo");
				redo = new JMenuItem("Redo");
				reset = new JMenuItem("Reset");
				delete = new JMenuItem("Delete");
				group = new JMenuItem("Group");
				ungroup = new JMenuItem("Ungroup");
				saveShapes = new JMenuItem("Save Shapes");
				saveImage = new JMenuItem("Save Image");

				undo.addActionListener(new ActionListener()
					{

						@Override
						public void actionPerformed(ActionEvent e)
							{

								commands.undoCommand();
								repaint();
							}
					});
				redo.addActionListener(new ActionListener()
					{

						@Override
						public void actionPerformed(ActionEvent e)
							{

								commands.redoCommand();
								repaint();
							}
					});

				reset.addActionListener(new ActionListener()
					{

						@Override
						public void actionPerformed(ActionEvent e)
							{
								drawPanel.clear();
								repaint();

							}
					});
				// duplicateB.addActionListener(new ActionListener()
				// {
				//
				// @Override
				// public void actionPerformed(ActionEvent e)
				// {
				//
				// // drawPanel.duplicate();
				//
				//
				// repaint();
				//
				// }
				// });
				delete.addActionListener(new ActionListener()
					{

						@Override
						public void actionPerformed(ActionEvent e)
							{

								commands.doCommand(new Delete());

								repaint();

							}
					});
				group.addActionListener(new ActionListener()
					{

						@Override
						public void actionPerformed(ActionEvent e)
							{
								commands.doCommand(new Group());
								repaint();

							}
					});
				ungroup.addActionListener(new ActionListener()
					{

						@Override
						public void actionPerformed(ActionEvent e)
							{
								drawPanel.unGroup();
								repaint();

							}
					});

				saveShapes.addActionListener(new ActionListener()
					{

						@Override
						public void actionPerformed(ActionEvent e)
							{
								drawPanel.saveShape();
								repaint();

							}
					});
				saveImage.addActionListener(new ActionListener()
					{

						@Override
						public void actionPerformed(ActionEvent e)
							{
								drawPanel.saveImage();
								repaint();

							}
					});

				add(undo);
				add(redo);
				add(reset);
				add(delete);
				add(group);
				add(ungroup);
				add(saveShapes);
				add(saveImage);

			}

	}
