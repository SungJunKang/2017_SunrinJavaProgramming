package dotterlib.io;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import dotterlib.utils.image.*;

public class Image {
	public static BufferedImage importImage(String imagePath) throws IOException{
		File imageFile = new File(imagePath);

		BufferedImage image = ImageIO.read(imageFile);
		
		return image;
	}

	public static void exportImage(RenderedImage outputImage, String outputPath, String format) throws IOException{
		File outputFile = new File(outputPath);
		
		String outputFormat = Selections.imageFormatSelection(format.toLowerCase());
		
		ImageIO.write(outputImage, outputFormat, outputFile);
	}
}
