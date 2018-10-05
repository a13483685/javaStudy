package DesignPattern.Builder;

public class Director {
    Builder builder = null;

    public Director(Builder builder) {
        this.builder = builder;
    }

    /*
     *构建对象
     */
    public void Construct(String boardInfo, String display) {
        builder.setBoard(boardInfo);
        builder.setDisplay(display);
        builder.setOs();
    }
}
