package dotterlib.utils.image;

import java.awt.image.BufferedImage;

public class Selections {
	public static int colorChannelSelection(String in){
		int colorChannel;
		
		switch(in.toLowerCase()){
			case "rgb": colorChannel = BufferedImage.TYPE_INT_RGB; break;
			case "rgba": colorChannel = BufferedImage.TYPE_INT_ARGB; break;
			default: colorChannel = BufferedImage.TYPE_INT_RGB; break;
		}
		
		return colorChannel;
	}
	
	public static String imageFormatSelection(String in){
		String format = "";
		
		switch(in.toLowerCase()){
			case "png": case "jpg": case "gif": format = in; break;
			default: format = "png"; break;
		}
		
		return format;
	}
}
