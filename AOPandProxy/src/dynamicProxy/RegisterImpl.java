package dynamicProxy;

/**
 * ע���ʵ����
 */
public class RegisterImpl implements Register {
	@Override
	public void register(String name) {
		System.out.println(name + "����ע��");
	}

	@Override
	public void delReg(String name) {
		System.out.println(name + "����ע��");

	}
}
