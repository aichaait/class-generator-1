import java.util.*;
public class Class1 {
	private int attribute1 = 1;

	private String attribute2 = "mohamed";

	private double attribute4 = 1.0001;

	private List<Class2> class2s;
	private Class3 class3;


	
	public Class1(Class3 class3){
		this.class2s = new ArrayList<Class2>();
		this.class3 = class3;
}	public int getAttribute1(){
		return this.attribute1;
	}
	public void setAttribute1(int attribute1){
		this.attribute1 = attribute1;
	}
	public String getAttribute2(){
		return this.attribute2;
	}
	public void setAttribute2(String attribute2){
		this.attribute2 = attribute2;
	}
	public double getAttribute4(){
		return this.attribute4;
	}
	public void setAttribute4(double attribute4){
		this.attribute4 = attribute4;
	}
	public Boolean methode1(int param1,String param2,float param3){
		//Ecrit ici

	}
	public int methode2(float param3){
		//Ecrit ici

	}
	public String methode3(){
		//Ecrit ici

	}
}
