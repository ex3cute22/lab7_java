import java.io.IOException;
import java.util.Scanner;
import java.io.PrintStream;

class Car{
    private String name;
    private int year;
    private int price;
    private Support supportCar = new Support();

    public void init(){
        name = " ";
        year = 0;
        price = 0;
    }
    
    public void init(String name, int year, int price){
        this.name = name;
        this.year = year;
        this.price = price;
    }

    public void read() {
        try {
			Scanner scan = new Scanner(System.in);
			System.out.println("Input name: ");
			name = scan.nextLine();
			System.out.println("Input year: ");
			year = scan.nextInt();
			System.out.println("Input price: ");
			price = scan.nextInt();
		} catch (Exception error) {
			error.printStackTrace();
		}
    }

    public void addTag(){
        name += " (purchased)";
    }

    public void display(){
        try {
			PrintStream ps = new PrintStream(System.out, true, "Windows-1251");
			ps.println("Name: " + name + "\n" + "Year: " + year + "\n" + "Price: " + price);
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    public String getName(){
        return name;
    }
    public int getYear(){
        return year;
    }
    public int getPrice(){
        return price;
    }
    public void showRate(){
        supportCar.getRate(this);
    }

}
class Support{
    void getRate(Car car){
        System.out.println("Rate " + car.getName() +": " + ((float) car.getYear() * 200) / car.getPrice() );
    }
}

public class Main{
    public static void main(String[] args) {
        Car cars[] = new Car[5];
        for (int i = 0; i < cars.length; i++){
            cars[i] = new Car();
            cars[i].init("Lada-210" + Integer.toString(i+3), Integer.parseInt("200" + Integer.toString(i+3)), (i+1) * 100000 );
        } 
        cars[0].addTag();
        cars[3].addTag();
        for (int i = 0; i < cars.length; i++){
            cars[i].display();
        } 
        for (int i = 0; i < cars.length; i++){
            cars[i].showRate();
        } 

}
}