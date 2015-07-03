import java.util.logging.Logger;

/**
 * 注册机类
 */
public class Register {
	// 一个日志记录器成员
	Logger logger = Logger.getLogger(this.getClass().getName());
	/**
	 * 注册方法
	 */
	public void register(String name) {
		logger.info(name + "开始审核");
		System.out.println("正在注册...");
		logger.info(name + "注册完毕");
	}
}