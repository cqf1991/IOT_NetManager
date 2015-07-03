package dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * 客户端代码
 */
public class Browser {
	public static void main(String[] args) {
		// 实例化日志代理类
		LogProxy logProxy = new LogProxy(new RegisterImpl());
		// 动态获取代理实例
		// 参数：注册类的类装载器,被代理的接口,日志代理的实例
		Register re = (Register) Proxy.newProxyInstance(
				RegisterImpl.class.getClassLoader(),
				RegisterImpl.class.getInterfaces(), logProxy);
		re.register("张三");
		re.delReg("张三");
	}
}