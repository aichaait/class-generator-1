import java.util.*;
public class Class4 extends Class3 {
	private int attribute1 = 4;

	private String attribute2 = "ayoub";

	private double attribute4 = 4.00004;

	private Class2 class2;
	private Class3 class3;
	private Class4 class4;
	public Class4(List<Class2> class2s,){
		super(class2s,);
		this.class2 = class2;
		this.class3 = class3;
		this.class4 = new Class4();
	}
	public int getAttribute1(){
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
	public Boolean methode10(int param1,String param2,float param3){
		//Ecrit ici

	}
	public int methode11(float param3){
		//Ecrit ici

	}
	public String methode12(){
		//Ecrit ici

	}
}
