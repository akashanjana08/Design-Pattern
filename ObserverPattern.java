import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {

	public static void main(String[] args) {
		Subject subject = new Subject();
		new Binary(subject);
		new HexaDecimal(subject);
		
		
		subject.setData(15);
		
		subject.setData(20);
	}
}

class Subject{
	
	List<Observer> observers = new ArrayList<>();
	int data;
	public void setData(int data){
		this.data = data;
		updateObserver();
	}
	
	public void getData(int data)
	{
		this.data = data;
	}
	
	
	public void attach(Observer observer){
		observers.add(observer);
	}
	
	public void updateObserver(){
		for (Observer observer : observers) {
			observer.update(data);
		}
	}
}


abstract class Observer{
		Subject subject;
	    abstract void update(int data);
}

class Binary extends Observer{
	
	public Binary(Subject subject){
		this.subject = subject;
		this.subject.attach(this);
	}
	
	void update(int data){
		System.out.println("Binary Data   "+data);
	}
}

class HexaDecimal extends Observer{
	
	public HexaDecimal(Subject subject){
		this.subject = subject;
		this.subject.attach(this);
	}
	
	void update(int data){
		System.out.println("HexaDecimal  Data   "+data);
	}
}




























