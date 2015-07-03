package staticProxy;

import java.util.logging.Logger;

/**
 * ע�������
 */
public class RegisterProxy {
	// һ����־��¼����Ա
	Logger logger = Logger.getLogger(this.getClass().getName());
	// һ��ע��ӿڵ�����
	private Register register;

	public RegisterProxy(Register register) {
		this.register = register;
	}

	public void register(String name) {
		logger.info("�������....");
		register.register(name);
		logger.info("ע�����");
	}

	public void delREG(String name) {
		logger.info("�������....");
		register.delReg(name);
		logger.info("ע�����");
	}
}