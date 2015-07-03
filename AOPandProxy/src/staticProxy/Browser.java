package staticProxy;

public class Browser {
	// 使用静态代理模式实现Aop
	public static void main(String[] args) {
		Register register = new RegisterImpl();
		RegisterProxy proxy = new RegisterProxy(register);
		proxy.register("张三");
		proxy.delREG("张三");
		
	}
}