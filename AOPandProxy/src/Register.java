import java.util.logging.Logger;

/**
 * ע�����
 */
public class Register {
	// һ����־��¼����Ա
	Logger logger = Logger.getLogger(this.getClass().getName());
	/**
	 * ע�᷽��
	 */
	public void register(String name) {
		logger.info(name + "��ʼ���");
		System.out.println("����ע��...");
		logger.info(name + "ע�����");
	}
}