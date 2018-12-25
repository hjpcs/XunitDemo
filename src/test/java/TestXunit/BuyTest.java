package TestXunit;

import DemoXunit.Login;
import DemoXunit.Products;
import DemoXunit.Shopping;
import LoginData.BuyParams;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BuyTest {

    Login login = new Login();
    Shopping shopping = new Shopping();
    int[] count = new int[3];

    @BeforeClass
    public void beforeClass() {
        System.out.println("测试前商品库存:");
        for (int i=0; i<Products.values().length; i++) {
            count[i] = Products.getPro(i+1).getCount(); //根据proId获取商品再获取数量赋给count数组
            System.out.println(count[i]);
        }
    }

    @Test(dataProvider = "getBuyData",dataProviderClass = BuyParams.class)
    public void testBuy(String name, String pwd, int proId, int count, int expect) {
        login.userLogin(name, pwd);
        int actual = shopping.buys(proId, count);
        Assert.assertEquals(actual, expect);
    }

    @AfterClass
    public void afterClass() {
        System.out.println("测试后商品库存");
        for (int i=0; i<Products.values().length; i++) {
            Products.getPro(i+1).setCount(count[i]); //将测试前count数组的值根据proId先获取对应商品再将商品数量set回去
            System.out.println(Products.getPro(i+1).getCount());
        }
    }
}
