/*******************************************************
 * Challenge #229 - Pi from Picture - Inter. Challenge *
 * Completed by Adam Tracy                             * 
 *******************************************************/

package daily;

import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

public class PiFromCircles {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("img2.png");
		BufferedImage bi = ImageIO.read(file);
		int black = 0;
		int alpha;
		int longest = 0;
		int w = bi.getWidth();
		int h = bi.getHeight();
		byte[][] rgbArr = new byte[w][h];
		for(int i = 0; i < w; i++){
			int longestCount = 0;
			for(int j = 0; j < h; j++){
				int pixel = rgbArr[i][j] = (byte) bi.getRGB(i, j);
				alpha = (pixel >> 24) & 0xff;
				if(alpha == 0){
					black++;
					longestCount++;
					if(longestCount > longest){
						longest = longestCount;
					}
				}
			}
		}
		double pi = black / Math.pow(longest/2, 2);
			System.out.println(pi);
		

	}

}
