package dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * �ͻ��˴���
 */
public class Browser {
	public static void main(String[] args) {
		// ʵ������־������
		LogProxy logProxy = new LogProxy(new RegisterImpl());
		// ��̬��ȡ����ʵ��
		// ������ע�������װ����,������Ľӿ�,��־�����ʵ��
		Register re = (Register) Proxy.newProxyInstance(
				RegisterImpl.class.getClassLoader(),
				RegisterImpl.class.getInterfaces(), logProxy);
		re.register("����");
		re.delReg("����");
	}
}