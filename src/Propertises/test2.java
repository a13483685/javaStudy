package Propertises;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class test2 {
    //查询配置
    public String getProperty(String type){
        Properties prop = new Properties();// 属性集合对象
        FileInputStream fis = null;// 属性文件输入流
        try {
            fis = new FileInputStream("resources/test.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(fis);// 将属性文件流装载到Properties对象中
            fis.close();// 关闭流
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(type);
    }

    //设置配置
    public String setProperty(String type,String val){
        Properties prop = new Properties();// 属性集合对象
        prop.setProperty(type,val);
        FileOutputStream fos = null;// 属性文件输入流
        try {
            fos = new FileOutputStream("resources/test.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.store(fos,"Copyright (c) Suchness");// 将属性文件流装载到Properties对象中
            fos.close();// 关闭流
        } catch (IOException e) {
            e.printStackTrace();
        }




        return prop.getProperty(type);
    }

@Test
    public void getVal(){
        String devName = getProperty("devName");
        System.out.println("get val is :"+devName);
    }

    @Test
    public void setVal(){
        String s = setProperty("devName", "open");
        System.out.println("get val is :"+s);
    }
}
