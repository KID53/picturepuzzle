package cn.homework.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import cn.homework.util.image.ImageScaler;

public class ImagePanel extends JPanel {
	private Image image;
    public ImagePanel(String path){
        //�ڹ��췽�������ͼƬ, ������һ��
        try{
            image = imageFromResource(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        int width = getWidth();
        int height = getHeight();
        g.clearRect(0, 0, width, height);

        if(image != null){
            g.drawImage(image, 0, 0, width, height, null);
        }

    }

    //����Դ����ͼƬ
    private Image imageFromResource(String path) throws IOException {
        URL url = this.getClass().getResource(path);
        BufferedImage image = ImageIO.read(url);
        return image;
    }

    //���ļ�����ͼƬ
    private Image imageFromResource(File path) throws IOException {
        BufferedImage image = ImageIO.read(path);
        return image;
    }
}
