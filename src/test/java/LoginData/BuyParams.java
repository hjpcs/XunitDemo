package LoginData;

import org.testng.annotations.DataProvider;

public class BuyParams {

    @DataProvider
    public Object[][] getBuyData(){
        return new Object[][]{  //String name, String pwd, int proId, int count, int expect
                /*WEIJIN(1,"围巾",200,0),
                MAOZI(2,"帽子",120,10),
                SHOUTAO(3,"手套",80,1);*/
                {"","",1,10,-2}, //未登录情况
                {"zhangsan","123456",3,0,-1}, //登录后购买数量<=0
                {"admin","123456",2,5,1}, //登录后购买帽子5个，库存充足，剩余5个
                {"admin","123456",2,6,0}, //登录后再购买帽子6个，库存不足
                {"lisi","8888",1,5,0} //登录后购买围巾5条，库存不足
        };
    }
}
