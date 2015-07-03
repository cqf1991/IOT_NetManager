package dynamicProxy;

public class rg2Impl implements Register {

	@Override
	public void register(String name) {
		System.out.println(name + "regIng");

	}

	@Override
	public void delReg(String name) {
		System.out.println(name + "DELregIng");
		
	}

}
