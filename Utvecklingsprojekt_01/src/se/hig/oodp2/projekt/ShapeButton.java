package se.hig.oodp2.projekt;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ShapeButton extends JButton
	{
		
		private static final long serialVersionUID = 1L;

		private String name;
		private Dimension bSize = new Dimension(30,30);
		public ShapeButton(String name)
			{
				this.name = name;

				setPreferredSize(bSize);
				ImageIcon icon = new ImageIcon("images/" + name + ".png");
				setIcon(resizeIcon(icon, (int)(bSize.width*0.7), (int)(bSize.height*0.7)));
				setBackground(Color.white);
			}
		public String getName(){
			return name;
		}
		private Icon resizeIcon(ImageIcon icon, int reWidth, int reHeight){
			
			Image img = icon.getImage();
			Image resizedImage = img.getScaledInstance(reWidth, reHeight, java.awt.Image.SCALE_SMOOTH);
			
			return new ImageIcon(resizedImage);
			
		}

	}
