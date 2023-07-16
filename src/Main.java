import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream("test/baboon.bmp");
            FileOutputStream fout = new FileOutputStream("test/complement_baboon.bmp");
            byte[] header = new byte[54];
            fin.read(header);
            fout.write(header);

            int octet;
            while((octet = fin.read()) != -1)
                fout.write(255 - octet);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}