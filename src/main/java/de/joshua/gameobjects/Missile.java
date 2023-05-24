package de.joshua.gameobjects;

import de.joshua.util.Coordinate;
import de.joshua.util.GameObject;
import de.joshua.util.window.GameWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Missile extends GameObject {

    Coordinate position;
    double width;
    double height;
    double cannonLength;
    double turningDirection;
    double shootRange;
    double yShootRange;
    boolean rotateTrue = true;
    double canonDirection = 0;
    boolean firstRound = true;
    double endDirection = 0;
    Coordinate fixedObjectPosition = new Coordinate(getObjectPosition().getX(), getObjectPosition().getY());
    boolean rotateTrue2 = true;
    String direction;
    public Missile(Coordinate position, double width, double height, double cannonLength, double turningDirection) {
        super(position, width, height);

        this.position = position;
        this.width = width;
        this.height = height;
        this.cannonLength = cannonLength;
        this.turningDirection = turningDirection;
    }

    public void changeMissileYShootRange(){
        if(firstRound){
            yShootRange = yShootRange * -1;
        }
    }
    public void setMissileDirection(String direction){
        this.direction = direction;
    }

    @Override
    public void paintMe(java.awt.Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GREEN);
        AffineTransform transform = new AffineTransform();
        setObjectPosition(new Coordinate(fixedObjectPosition.getX() + getWidth() * (0.75 / 2) + cannonLength + shootRange * 10,
                fixedObjectPosition.getY() + getHeight() * (0.16 / 0.5) + yShootRange));
        Ellipse2D missileShape = new Ellipse2D.Double(fixedObjectPosition.getX() + getWidth() * (0.75 / 2) + cannonLength + shootRange * 10,
                fixedObjectPosition.getY()+ getHeight() * (0.16 / 0.5) + yShootRange,
                10, 10);

        if (rotateTrue) {
            transform.rotate(turningDirection, fixedObjectPosition.getX() + getWidth() * 0.4, fixedObjectPosition.getY() + getHeight() * 0.4);
            canonDirection = canonDirection + turningDirection;
        } else if (rotateTrue2){
            if (firstRound) {
                endDirection = canonDirection;
                firstRound = false;
            }
            canonDirection = canonDirection + turningDirection;
            transform.rotate(endDirection, fixedObjectPosition.getX() + getWidth() * 0.4, fixedObjectPosition.getY() + getHeight() * 0.4);
        }
        Shape transformedMissileShape = transform.createTransformedShape(missileShape);
        g2d.fill(transformedMissileShape);
    }
}
