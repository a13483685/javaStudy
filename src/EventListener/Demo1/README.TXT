java中的事件监听是怎样实现随时监听的
泡在网上的日子 / 文 发表于2012-08-22 20:26 第6824次阅读 事件监听
编辑推荐：稀土掘金，这是一个针对技术开发者的一个应用，你可以在掘金上获取最新最优质的技术干货，不仅仅是Android知识、前端、后端以至于产品和设计都有涉猎，想成为全栈工程师的朋友不要错过！

        Java中的事件监听是整个Java消息传递的基础和关键。牵涉到两类对象：事件发生者和事件监听者。事件发生者是事件的起源，它可以是一个按钮，编辑框等。事件监听者就是事件的接受者，如果要想接收某个事件，它必须对该事件的发生者说一声：嗨，哥们，有事吱一声。这个过程相当与在事件发生者那儿注册了一下。当事件发生者真的有事件发生时，就会对所有对该事件注册的所有监听者送一份参考消息说：有内幕，有内幕！！事件监听者听到后，拿过来看一下，根据这份报纸各干各的事。参考消息这份报纸就是java中的事件对象。

        具体实现呢,可以看看Button的源码。可能不好看得懂。那好我们仿照侯捷先生的作法，来模拟一个这样的事件传递：
        定义一个自己的事件:

public   MyEvnet{
    private   int   value;
    public   int   getValue(){return   value;}
    public   void   setValue(int   value){this.value=value;}
}

        做一个接口 Listenable

interface   Listenable{
    public   void   enventChanged(MyEvent   e);
}


        做一个事件发生者，此类中保存有所有在这里报到的类的引用

public   MySource{
    int   value;
    Vector   listeners=new   Vector();
    public   addListener(Listenable   l){listeners.add(l);}
    public   void   setValue(int   value){
        this.value=value;
        fireChanged();
    }
    private   void   fireChanged(){
        MyEvent   e=new   MyEvent();
        e.setValue(value);
        for(int   i=0;i <listeners.size();i++){
            Listenable   l=(Listenable)listeners.elementAt(i);
            l.eventChanged(e);
        }
    }
}




        好了，如果谁想监听MySource的value值改变了，就在MySource哪儿注册一下，然后写消息处理代码，就可以了,我们定义这样一个监听者：

MyListener   implements   Listenable{
    public   void   eventChanged(MyEvent   e){
        System.out.println( "value   changed   to:   "+e.getValue());
    }
}



        这样，当MySource的value真的改变时，就会触发此方法。

        然后在其他代码中把MyListener注册到MySource:

MySource   ms=new   MySource();
MyListener   ml=new   MyListener();
ms.addListener(ml);
ms.setValue(10);

        Java中AWT/Swing的事件传递的实现，现在版本于上述有所不同，但应该都是这个原理。