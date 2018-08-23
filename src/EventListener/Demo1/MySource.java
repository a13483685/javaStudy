package EventListener.Demo1;

import java.util.Vector;

/**
 * 3.做一个事件发生者，此类中保存有所有在这里报到的类的引用
 */
public class MySource {
    int value;
    Vector listeners = new Vector();

    public void addListener(Listenable l) {
        listeners.add(l);
    }

    public void setValue(int value) {
        this.value = value;
        fireChanged();
    }

    private void fireChanged() {
        MyEvent e = new MyEvent();
        e.setValue(value);
        for (int i = 0; i < listeners.size(); i++) {
            Listenable l = (Listenable) listeners.elementAt(i);
            l.enventChanged(e);
        }
    }


}
