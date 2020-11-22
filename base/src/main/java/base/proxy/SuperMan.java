package base.proxy;

/**
 * 动态代理例子
 */
public class SuperMan implements Human{



    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我他妈吃爆->"+food);
    }
}
