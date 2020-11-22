package base.proxy;

public class NikeClothFactory implements ClothFactory {
    @Override
    public void produceCloth() {
        System.out.println("nike工厂生产一批运动服");
    }
}
