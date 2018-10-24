package DesignPattern.Builder;

public class MacBookBuilder extends Builder {

    private Computer computer = new Macbook();
    @Override
    public void setBoard(String string) {
        computer.setmBoard(string);
    }

    @Override
    public void setDisplay(String string) {
        computer.setmDisplay(string);
    }

    @Override
    public void setOs() {
        computer.setOS();
    }

    @Override
    public Computer create() {
        return computer;
    }
}
