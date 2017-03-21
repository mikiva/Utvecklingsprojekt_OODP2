package se.hig.oopd2.projekt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import Menus.EditMenu;
import Menus.ShapeMenu;

public class MainWindow extends JFrame
	{
		/**
		* 
		*/
		private static final long serialVersionUID = 1L;
		JPanel mainPanel;
		DrawPanel drawPanel;
		ControlPanel control;
		LayerPanel layerPanel;
		ShapePanel shapePanel;
		private final int FRAME_WIDTH = 1000;
		private final int FRAME_HEIGHT = 800;

		public MainWindow() throws IOException
			{
				super("Version 1");

				mainPanel = new JPanel();
				layerPanel = new LayerPanel();
				shapePanel = new ShapePanel();
				drawPanel = DrawPanel.getInstance();
				setContentPane(mainPanel);
				control = new ControlPanel();
				setJMenuBar(makeMenuBar());
				Container c = getContentPane();
				mainPanel.setLayout(new BorderLayout());
				mainPanel.setBackground(Color.BLACK);
				mainPanel.add(shapePanel, BorderLayout.WEST);
				mainPanel.add(control, BorderLayout.SOUTH);
				mainPanel.add(drawPanel, BorderLayout.CENTER);
				// mainPanel.add(layerPanel, BorderLayout.EAST);
				control.setDrawPanel(drawPanel);

				// mainPanel.add(new Button1(), BorderLayout.CENTER);

				// setLocationRelativeTo(null);
				setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				// setSize(FRAME_WIDTH, FRAME_HEIGHT);
				pack();
				setVisible(true);
			}

		private JMenuBar makeMenuBar()
			{

				JMenu menu = new JMenu("Menu");

				JMenuItem item1 = new JMenuItem("Test");
				menu.add(item1);
				JMenuBar menuBar = new JMenuBar();
				// menuBar.add(menu);

				JMenu fileMenu = ShapeMenu.getInstance();
				JMenu editMenu = EditMenu.getInstance();

				menuBar.add(fileMenu);
				menuBar.add(editMenu);
				return menuBar;

			}

	}
