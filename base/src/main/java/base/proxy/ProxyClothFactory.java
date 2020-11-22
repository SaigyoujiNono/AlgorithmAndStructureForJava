package base.proxy;

public class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory;

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    public ProxyClothFactory() {
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");

        factory.produceCloth();

        System.out.println("收尾工作-");
    }
}
