package Java8.Optional;

import org.junit.Test;

import java.util.Optional;

/**
 * @author vdsklnl
 * @create 2022-04-29 11:24
 * @Description
 */

public class OptionalTest {

    @Test
    public void test1() {

        Boy boy = null;
        boy = new Boy();
        boy = new Boy(new Girl("王晓晗"));
        String girlName = getGirlName(boy);
        System.out.println(girlName);

    }

    public String getGirlName(Boy boy) {

        // 确保Boy对象非空
        Optional<Boy> boy1 = Optional.ofNullable(boy);
        Boy boy2 = boy1.orElse(new Boy(new Girl("WXH")));
        Girl girl = boy2.getGirl();

        // 确保Boy中Girl对象非空
        Optional<Girl> girl1 = Optional.ofNullable(girl);
        Girl girl2 = girl1.orElse(new Girl("WangXh"));
        return girl2.getName();

    }

}
