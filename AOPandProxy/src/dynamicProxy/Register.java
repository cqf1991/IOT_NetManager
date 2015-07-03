package dynamicProxy;

import java.util.logging.Logger;

/**
 * 注册机接口
 */
public interface Register {
	// 定义注册服务
	public void register(String name);

	public void delReg(String name);
}