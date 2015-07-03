package dynamicProxy;

/**
 * 注册机实现类
 */
public class RegisterImpl implements Register {
	@Override
	public void register(String name) {
		System.out.println(name + "正在注册");
	}

	@Override
	public void delReg(String name) {
		System.out.println(name + "正在注销");

	}
}
