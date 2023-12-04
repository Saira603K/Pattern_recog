import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class RecogImage {
    public static void main(String args[]) throws IOException {
        BufferedImage img = null;
        File f = null;

        // read image
        try {
            f = new File("C:\\Users\\Asim_old_Dell_PC\\Pattern_Recog\\e.jpg");
            img = ImageIO.read(f);
        } catch(IOException e) {
            System.out.println(e);
        }

        // get width and height
        int width = img.getWidth();
        int height = img.getHeight();

        // print out the size of the image
        System.out.println("Original Image Size: " + width + "x" + height);

        // resize image to 24x24
        BufferedImage resizedImg = new BufferedImage(24, 24, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resizedImg.createGraphics();
        g2d.drawImage(img, 0, 0, 24, 24, null);
        g2d.dispose();

        // convert to grayscale and print out the values
        int[][] arr = new int[24][24];
        for (int y = 0; y < 24; y++) {
            for (int x = 0; x < 24; x++) {
                int p = resizedImg.getRGB(x, y);

                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                // calculate average for grayscale
                int avg = (r + g + b) / 3;

                arr[y][x] = avg;

                // replace RGB value with avg (although this won't be visible in a grayscale image)
                p = (a << 24) | (avg << 16) | (avg << 8) | avg;

                resizedImg.setRGB(x, y, p);
            }
        }

        // print the grayscale values
        for(int i = 0; i < 24; i++) {
            for(int j = 0; j < 24; j++) {
                System.out.print(String.format("%1$3s", arr[i][j]));
            }
            System.out.println();
        }

        // write the resized image to file
        try {
            f = new File("C:\\Users\\Asim_old_Dell_PC\\Pattern_Recog\\output_e.jpg");
            ImageIO.write(resizedImg, "bmp", f);
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}
