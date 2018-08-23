package EventListener.Demo1;
/**
 * 好了，如果谁想监听MySource的value值改变了，就在MySource哪儿注册一下，然后写消息处理代码，就可以了,我们定义这样一个监听者：
 * */
public class MyListener implements Listenable{
    @Override
    public void enventChanged(MyEvent e) {
        System.out.println( "value changed to:"+e.getValue());
    }
}
