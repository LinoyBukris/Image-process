package org.example;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        apllyFilter("C:\\Users\\Owner\\Pictures\\Saved Pictures\\monkey.jpeg",
                "C:\\Users\\Owner\\Pictures\\Saved Pictures\\output.jpeg");

    }

    public static void apllyFilter(String input, String output){
        try {
            File file = new File(input);
            if (file.exists()) {
                System.out.println("exists");
                BufferedImage bufferedImage = ImageIO.read(file);

                int coloerCode = bufferedImage.getRGB(0,0);
                Color color = new Color(coloerCode);
                System.out.println(color.getRed());
                System.out.println(color.getGreen());
                System.out.println(color.getBlue());

                for (int x = 0 ; x<bufferedImage.getWidth(); x+=2){
                    for (int y = 0; y<bufferedImage.getHeight(); y+=2){
                        bufferedImage.setRGB(x, y, Color.PINK.getRGB());
                    }
                }

                File outputFile = new File(output);
                ImageIO.write(bufferedImage,"jpeg", outputFile);

            }else {
                System.out.println("not exists");
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}