package staticProxy;

public class Browser {
	// ʹ�þ�̬����ģʽʵ��Aop
	public static void main(String[] args) {
		Register register = new RegisterImpl();
		RegisterProxy proxy = new RegisterProxy(register);
		proxy.register("����");
		proxy.delREG("����");
		
	}
}