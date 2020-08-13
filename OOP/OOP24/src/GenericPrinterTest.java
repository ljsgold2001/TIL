
public class GenericPrinterTest{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	GenericPrinter<Powder> powderPrinter = new GenericPrinter<Powder>();
	//제네릭타입을 생성했다고해서 새로이 생성되는것아니다.
	Powder powder = new Powder();
	powderPrinter.setMaterial(powder);
	
	System.out.println(powderPrinter);
	
	
	GenericPrinter<Plastic> PlasticPrinter = new GenericPrinter<Plastic>();
	//제네릭타입을 생성했다고해서 새로이 생성되는것아니다.
	Plastic plastic = new Plastic();
	PlasticPrinter.setMaterial(plastic);
	
	System.out.println(PlasticPrinter);
	
	powderPrinter.printing();
	PlasticPrinter.printing();
	
	}

}
