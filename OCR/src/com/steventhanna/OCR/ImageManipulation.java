package com.steventhanna.OCR;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class ImageManipulation {

	// Load image
	public static BufferedImage loadImage(String filename) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(filename));
			return image;
		} catch(IOException e) {
			System.out.println("There was an error: " + e);
			return null;
		}
	}

	// Save Image
	public static void saveImage(BufferedImage image, String filename, String filetype) {
		try {
    		ImageIO.write(image, filetype, new File(filename));
		} catch(IOException e) {
			System.out.println("There was an error saving the file");
		}
	}

	// Convert image to greyscale
	public static void imageGreyScale() {
		BufferedImage image = loadImage("/Users/steventhanna/Desktop/brackets.jpg");
		BufferedImage img = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
		Graphics g = img.getGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();
	}

	public static void main(String[] args) {
		imageGreyScale();
	}

}
