package DesignPattern.Builder;

public abstract class Builder {
    public abstract void setBoard(String string);
    public abstract void setDisplay(String string);
    public abstract void setOs();
    public abstract Computer create();
}
