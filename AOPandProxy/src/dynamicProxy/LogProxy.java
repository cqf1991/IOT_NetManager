package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.logging.Logger;

/**
 * 日志代理类，他可以代理一切需要日志输出服务的类 它实现了调用处理者接口
 */
public class LogProxy implements InvocationHandler {
	// 一个日志记录器成员
	private Logger logger = Logger.getLogger(this.getClass().getName());
	// 被代理者成员
	private Object beProxy;

	public LogProxy(Object beProxy) {
		this.beProxy = beProxy;
	}

	// 实现调用方法
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result;
		System.out.println("正在审核");
		System.out.println("Method now:" + method);
		result = method.invoke(beProxy, args);
		System.out.println("记录完毕");
		return result;
	}
}