package staticProxy;

import java.util.logging.Logger;

/**
 * 注册代理类
 */
public class RegisterProxy {
	// 一个日志记录器成员
	Logger logger = Logger.getLogger(this.getClass().getName());
	// 一个注册接口的引用
	private Register register;

	public RegisterProxy(Register register) {
		this.register = register;
	}

	public void register(String name) {
		logger.info("正在审核....");
		register.register(name);
		logger.info("注册完毕");
	}

	public void delREG(String name) {
		logger.info("正在审核....");
		register.delReg(name);
		logger.info("注册完毕");
	}
}