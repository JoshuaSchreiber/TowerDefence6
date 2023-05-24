package de.joshua.util;

public abstract class GameObject {

    private Coordinate objectPosition;
    private double width;
    private double height;
    private double movingAngle;
    private double movingDistance;

    public GameObject(Coordinate objectPosition, double width, double height) {
        this.objectPosition = objectPosition;
        this.width = width;
        this.height = height;
        movingAngle = 0;
        movingDistance = 0;
    }

    public Coordinate getObjectPosition() {
        return objectPosition;
    }

    public void setObjectPosition(Coordinate objectPosition) {
        this.objectPosition = objectPosition;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getMovingAngle() {
        return movingAngle;
    }

    public void setMovingAngle(double movingAngle) {
        this.movingAngle = movingAngle;
    }

    public double getMovingDistance() {
        return movingDistance;
    }

    public void setMovingDistance(double movingDistance) {
        this.movingDistance = movingDistance;
    }

    public boolean isLeftOf(GameObject one, GameObject two) {
        return one.getObjectPosition().getX() < two.getObjectPosition().getX();
    }
    public boolean isRightOf(GameObject one, GameObject two){
        // return one.getObjectPosition().getX() - one.getWidth()/2 < two.getObjectPosition().getX();
        return false;
    }

    public boolean isAbove(GameObject one, GameObject two) {
        // return one.getObjectPosition().getY() + one.getHeight()/2 < two.getObjectPosition().getY();
        return false;
    }

    public boolean isBelow(GameObject one, GameObject two){
        // return one.getObjectPosition().getY() > two.getObjectPosition().getY();
        return false;
    }

    public boolean touches(GameObject one, GameObject two) {
        if (isLeftOf(one, two)) return false;
        if (isRightOf(one, two)) return false;
        if (isAbove(one, two)) return false;
        if (isBelow(one, two)) return false;

        return true;
    }


    public static Coordinate polarToCartesianCoordinates(double angle) {

        // X-Achse zeigt nach Osten, Y-Achse zeigt nach SÃ¼den beim Zeichnen
        double x = Math.cos(angle);
        double y = Math.sin(angle);

        return new Coordinate(x, y);
    }

    public void moveGameObject() {

        Coordinate direction = polarToCartesianCoordinates(movingAngle);

        objectPosition.setX(objectPosition.getX() + direction.getX() * movingDistance);
        objectPosition.setY(objectPosition.getY() + direction.getY() * movingDistance);
    }

    public void makeMove() {
        moveGameObject();
    }

    protected abstract void paintMe(java.awt.Graphics g);
}
