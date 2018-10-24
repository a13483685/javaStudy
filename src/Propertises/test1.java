package Propertises;

import ch.qos.logback.core.util.FileUtil;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.util.Iterator;
import java.util.Properties;

public class test1 {
    /**
     * read properties file
     * @param paramFile file path
     * @throws Exception
     */
    public static void inputFile(String paramFile) throws Exception
    {
        Properties props=new Properties();//使用Properties类来加载属性文件
        FileInputStream iFile = new FileInputStream(paramFile);
        props.load(iFile);

        /**begin*******直接遍历文件key值获取*******begin*/
        Iterator<String> iterator = props.stringPropertyNames().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            System.out.println(key+":"+props.getProperty(key));
        }
        /**end*******直接遍历文件key值获取*******end*/

        /**begin*******在知道Key值的情况下，直接getProperty即可获取*******begin*/
        String value=props.getProperty("testKey");
//        String pass=props.getProperty("pass");
        System.out.println("\n"+"testKey"+"\n"+value);
        /**end*******在知道Key值的情况下，直接getProperty即可获取*******end*/
        iFile.close();
    }


    /**
     *write properties file
     * @param paramFile file path
     * @throws IOException
     */
    private static void outputFile(String paramFile) throws IOException {
        ///保存属性到b.properties文件
        Properties props=new Properties();
        FileOutputStream oFile = new FileOutputStream(paramFile, true);//true表示追加打开
        props.setProperty("testKey", "value");
        //store(OutputStream,comments):store(输出流，注释)  注释可以通过“\n”来换行
        props.store(oFile, "The New properties file Annotations"+"\n"+"Test For Save!");
        oFile.close();
    }

    //读
    @Test
    public void testInputFile(){//read properties file
        try {
            inputFile("resources/test.properties");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testOutputFile(){//write properties file
        try {
            outputFile("resources/test.properties");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
@Test
    public void test1()  {
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

// 获取属性值，sitename已在文件中定义
    System.out.println("获取属性值：password=" + prop.getProperty("password"));
    System.out.println("获取属性值：devName=" + prop.getProperty("devName"));
// 获取属性值，country未在文件中定义，将在此程序中返回一个默认值，但并不修改属性文件
// System.out.println("获取属性值：country=" + prop.getProperty("country", "中国"));

// 修改sitename的属性值
//    prop.setProperty("password", "xiezheng");
    prop.setProperty("devName", "close");
    System.out.println("获取属性值：devName=" + prop.getProperty("devName"));
    System.out.println("获取属性值：devName=" + prop.getProperty("devName"));
// 文件输出流
    FileOutputStream fos = new FileOutputStream("resources/test.properties");
// 将Properties集合保存到流中
    prop.store(fos, "Copyright (c) Boxcode Studio");
    fos.close();// 关闭流

    } catch (IOException e) {
        e.printStackTrace();
    }
    System.out.println("获取修改后的属性值：password=" + prop.getProperty("password"));
    }

}
