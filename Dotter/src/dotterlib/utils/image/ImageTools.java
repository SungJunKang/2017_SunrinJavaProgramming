package dotterlib.utils.image;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class ImageTools {
	public static BufferedImage fromColor(Color[][] pixelData, String type){
		int height = pixelData.length;
		int width = pixelData[0].length;
		
		int imageType = Selections.colorChannelSelection(type);

		BufferedImage image = new BufferedImage(width, height, imageType);

		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				image.setRGB(x, y, pixelData[y][x].getRGB());
			}
		}
		
		return image;
	}
	
	public static BufferedImage reverse(BufferedImage image){
		BufferedImage reversedImage = new BufferedImage(image.getHeight(), image.getWidth(), image.getType());
		
		for(int y = 0; y < image.getHeight(); y++){
			for(int x = 0; x < image.getWidth(); x++){
				reversedImage.setRGB(y, x, image.getRGB(x, y));
			}
		}
		
		return reversedImage;
	}
	
	public static BufferedImage resize(BufferedImage image, int width, int height){
		BufferedImage resizedImage = new BufferedImage(width, height, image.getType());
		Graphics2D resizedGraphics = resizedImage.createGraphics();
		
		resizedGraphics.setComposite(AlphaComposite.Src);
		
		resizedGraphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		resizedGraphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		resizedGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		resizedGraphics.drawImage(image, 0, 0, width, height, null);
		resizedGraphics.dispose();
		
		return resizedImage;
	}
}