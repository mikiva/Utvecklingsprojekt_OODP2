package se.hig.oodp2.projekt;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import se.hig.oodp2.shapes.Shape;
import se.hig.oodp2.shapes.ShapeList;

public class LayerPanel extends JPanel
	{

		/**
		* 
		*/
		private static final long serialVersionUID = 1L;
		ShapeList<Shape> list;
		GridBagConstraints c;
		JTextArea layerText;

		public LayerPanel()
			{
				super();

		//		this.layerText = new JTextArea();
				this.list = ShapeList.getInstance();
				setPreferredSize(new Dimension(300, getHeight()));
				// setBackground(Color.black);
				c = new GridBagConstraints();
				setLayout(new GridBagLayout());
				
				updateLayers();
				
				

			}
		@Override
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			
		}
		

		public void updateLayers()
			{
				
				//layerText.setText(null);
				JTextArea ltext;
				int i = list.size();
				this.removeAll();
				c.insets = new Insets(5, 0, 5, 0);
				
				for (Shape s : list)
					{
						layerText = new JTextArea(s.toString());
						//layerText.append(s.toString());
						layerText.setPreferredSize(new Dimension(getWidth(), 25));
						c.fill = GridBagConstraints.HORIZONTAL;
						c.gridy = i--;
						c.gridx = 1;
						this.add(layerText, c);
						c.gridx = 0;
						this.add(new ToggleButton("t", s), c);
						
						
					}
				revalidate();
				repaint();
			}



	}
