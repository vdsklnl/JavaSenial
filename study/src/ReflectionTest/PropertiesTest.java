package ReflectionTest;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author vdsklnl
 * @create 2022-04-25 20:54
 * @Description  获取配置文件
 */

public class PropertiesTest {

    @Test
    public void test() {
        Properties pros = new Properties();

//        // 方法一(当前module下)
//        // 可以写绝对路径
//        FileInputStream fis = null;
//        try {
//            fis = new FileInputStream("jdbc.properties");
//            pros.load(fis);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if(fis != null) {
//                try {
//                    fis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        // 方法二(当前module\src下)
        InputStream is = null;
        try {
            ClassLoader cl = PropertiesTest.class.getClassLoader();
            is = cl.getResourceAsStream("jdbc.properties");
            pros.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        String name = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println("user=" + name + ",password=" + password);
    }

}
