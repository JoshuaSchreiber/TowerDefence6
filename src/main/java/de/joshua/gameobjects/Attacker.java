package de.joshua.gameobjects;

import de.joshua.util.Coordinate;
import de.joshua.util.GameObject;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;


public class Attacker extends GameObject {

    String form;
    public Attacker(Coordinate objectPosition, double width, double height, String form) {
        super(objectPosition, width, height);

        this.form = form;

        setWidth(getWidth()*0.8);
        setHeight(getHeight()*0.8);
    }

    @Override
    public void paintMe(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        paintAttacker(g2d);
    }

    public void paintAttacker(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D circle = null;
        switch (form) {
            case "Dreieck":

                break;
            case "Viereck":

                break;
            case "Fünfeck":

                break;
            case "Sechseck":

                break;
            case "Circle":
                circle = new Ellipse2D.Double(getObjectPosition().getX() + getWidth()*0.2, getObjectPosition().getY() - getHeight()*0.65, getWidth(), getHeight());
                break;
        }
        AffineTransform transform = new AffineTransform();

        g2d.setColor(Color.decode("#02A272"));
        Shape transformed = transform.createTransformedShape(circle);
        g2d.fill(transformed);
    }
}
