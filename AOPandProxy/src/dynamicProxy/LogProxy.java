package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.logging.Logger;

/**
 * ��־�����࣬�����Դ���һ����Ҫ��־���������� ��ʵ���˵��ô����߽ӿ�
 */
public class LogProxy implements InvocationHandler {
	// һ����־��¼����Ա
	private Logger logger = Logger.getLogger(this.getClass().getName());
	// �������߳�Ա
	private Object beProxy;

	public LogProxy(Object beProxy) {
		this.beProxy = beProxy;
	}

	// ʵ�ֵ��÷���
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result;
		System.out.println("�������");
		System.out.println("Method now:" + method);
		result = method.invoke(beProxy, args);
		System.out.println("��¼���");
		return result;
	}
}