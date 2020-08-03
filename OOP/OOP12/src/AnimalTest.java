import java.util.ArrayList;

class Animal{
	public void move() {
		System.out.println("동물이 움직입니다.");
	}
}

class Human extends Animal{
	public void move() {
		System.out.println("사람이 두발로 걷습니다.");
	}
	public void readBooks() {
		System.out.println("사람이 책을 읽습니다.");
	}
}

class Tiger extends Animal{
	public void move() {
		System.out.println("호랑이가 네 발로 뜁니다.");
	}
	public void hunting() {
		System.out.println("호랑이가 사냥을 합니다.");
	}
}

class Eagle extends Animal{
	public void move() {
		System.out.println("독수리가 하늘을 날아갑니다.");
	}
	public void flying() {
		System.out.println("독수리가 날개를 펴고 비행합니다");
	}
}
public class AnimalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal hAnimal = new Human();
		Animal tAnimal = new Tiger();
		Animal eAnimal = new Eagle();
		
		//hanimal. - >이거는보이지 않는다. 하기위해서는 밑
		//Eagle human = (Eagle)hAnimal;// 오류 형변환이 맞지않
		
		
		
		
		// 다형성 
		/*
		AnimalTest test = new AnimalTest();
		test.moveAnimal(hAnimal);
		test.moveAnimal(tAnimal);
		test.moveAnimal(eAnimal);
		*/
		
		ArrayList<Animal> animalList = new ArrayList<Animal>();
		animalList.add(hAnimal);
		animalList.add(tAnimal);
		animalList.add(eAnimal);
		//다운캐스
		AnimalTest test = new AnimalTest();
		test.testDownCasting(animalList);
		/*for (Animal animal : animalList) {
			animal.move();//virtual function 일어난다.
		}

	}*/
	}
	public void moveAnimal(Animal animal) {
		animal.move();
	}
	/*
	public void moveAnimal(Human animal) {
		
	}
	이런식으로 human형으로 지정하게 되면 이러한 것을 3가지 만들어야한다.
	*/
	
	public void testDownCasting(ArrayList<Animal> list) {
		for( int i = 0; i<list.size(); i++) {
			Animal animal = list.get(i);
			
			if ( animal instanceof Human) {
				Human human = (Human)animal;
				human.readBooks();
			}
			else if( animal instanceof Tiger) {
				Tiger tiger = (Tiger)animal;
				tiger.hunting();
			}
			else if  (animal instanceof Eagle) {
				Eagle eagle = (Eagle)animal;
				eagle.flying();
			}
			else {
				System.out.println("Error");
			}
		}
	}
}
