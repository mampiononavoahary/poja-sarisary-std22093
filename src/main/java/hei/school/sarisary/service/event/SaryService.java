package hei.school.sarisary.service.event;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
@NoArgsConstructor
public class SaryService {
    public byte[] convertToBlackAndWhite(byte[] inputImage, String key) {
        try {
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(inputImage));
            if (image == null) {

                System.out.println("Unable to read the image. Please make sure it is a valid image");
                return new byte[0];
            }
            BufferedImage convertedImage =
                    new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
            convertedImage.getGraphics().drawImage(image, 0, 0, null);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(convertedImage, "png", byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            System.out.println("Unable to read the image. Please make sure it is a valid image");
            return new byte[0];
        }
    }

}
