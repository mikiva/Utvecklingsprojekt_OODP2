package se.hig.oopd2.projekt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class MainWindow extends JFrame
	{
		JPanel mainPanel;
		DrawPanel drawPanel;
		ControlPanel control;

		public MainWindow()
			{
				super("Version 1");
				setSize(800, 600);
				mainPanel = new JPanel();
				drawPanel = new DrawPanel();
				setContentPane(mainPanel);
				control = new ControlPanel();
				setJMenuBar(makeMenuBar());
				Container c = getContentPane();
				mainPanel.setLayout(new BorderLayout());
				mainPanel.setBackground(Color.BLACK);

				mainPanel.add(control, BorderLayout.SOUTH);
				mainPanel.add(drawPanel, BorderLayout.CENTER);
				control.setDrawPanel(drawPanel);
				
				// mainPanel.add(new Button1(), BorderLayout.CENTER);
				
				setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				setVisible(true);
			}

		private JMenuBar makeMenuBar()
			{

				JMenu menu = new JMenu("Menu");

				JMenuItem item1 = new JMenuItem("Test");
				menu.add(item1);
				JMenuBar menuBar = new JMenuBar();
				menuBar.add(menu);

				return menuBar;

			}

	}