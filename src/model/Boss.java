package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Boss {
    private int posX;
    private int posY;
    private BufferedImage img;
    private boolean visible;
    private boolean touch;

    private static double go;
    private static double goDown;
    private Bullet bullet;

    public Boss(){
        visible = false;
        touch = true;
        File imageFile = new File("image\\bossn.png");
        try {
            img = ImageIO.read(imageFile);

        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }
    }
    public boolean isTouch() {
        return touch;
    }

    public void setTouch(boolean touch) {
        this.touch = touch;
    }

    public Rectangle rectangle() {
        return new Rectangle(posX, posY, 120,120);
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public boolean isVisible() {
        return visible;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void move(){
        posX = (int) (posX + go);
        posY = (int) (posY + goDown);

        if (posX < 180){
            go += 0.8;
        }
        if (posX > 650){
            go -= 0.8;
        }

        if (posY < 20){
            goDown += 0.8;
        }
        if (posY > 650){
            goDown -= 0.8;
        }
    }


    public void checkVisible(){
        if (!visible){
            posX = -100;
            posY = 0;
        }
    }
    public Bullet getBullet() {
        return bullet;
    }


    public class Bullet {
        private int x;
        private int y;
        public BufferedImage img;
        private boolean destroy;

        public Bullet(int x, int y) {
            this.x = x;
            this.y = y;
            destroy = true;
            File imageFile = new File("image\\bossn.png");
            try {
                img = ImageIO.read(imageFile);

            } catch (IOException e) {
                System.err.println("Blad odczytu obrazka");
                e.printStackTrace();
            }
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public boolean isDestroy() {
            return destroy;
        }

        public void setDestroy(boolean destroyed) {
            this.destroy= destroyed;
        }

        public Rectangle rectangleBullet(){
            return new Rectangle(x, y, 10,30);
        }
    }
}
