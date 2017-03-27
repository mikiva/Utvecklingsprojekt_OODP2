package se.hig.oodp2.projekt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.WindowConstants;

import se.hig.oodp2.menus.EditMenu;
import se.hig.oodp2.menus.PropertiesPopup;
import se.hig.oodp2.menus.ShapeMenu;

public class MainWindow extends JFrame
	{
		/**
		* 
		*/
		private static final long serialVersionUID = 1L;
		private JPanel mainPanel;
		private DrawPanel drawPanel;
		private ShapePanel shapePanel;
		private PropertiesPopup popup;

		public MainWindow()
			{
				super("Version 3.14");

				mainPanel = new JPanel();
				shapePanel = new ShapePanel();
				drawPanel = DrawPanel.getInstance();
				setContentPane(mainPanel);
				setJMenuBar(makeMenuBar());
				mainPanel.setLayout(new BorderLayout());
				mainPanel.setBackground(Color.BLACK);
				mainPanel.add(shapePanel, BorderLayout.WEST);
				mainPanel.add(drawPanel, BorderLayout.CENTER);

				popup = PropertiesPopup.getInstance();
				
				drawPanel.setComponentPopupMenu(popup);

				
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				pack();
				setLocationRelativeTo(null);
				setVisible(true);
			}

		private JMenuBar makeMenuBar()
			{

				JMenuBar menuBar = new JMenuBar();
				JMenu fileMenu = ShapeMenu.getInstance();
				JMenu editMenu = EditMenu.getInstance();

				menuBar.add(fileMenu);
				menuBar.add(editMenu);
				return menuBar;

			}

	}
