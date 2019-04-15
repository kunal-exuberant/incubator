package likedriving.designpatterns;

public class FactoryPattern {

    public static void main(String[] args) {

        CarBuilder carBuilder = new CarBuilder();

        CarFactory carFactory = null;
        if (args[0].equals("baleno")) {
            carFactory = new BalenoCarFactory();

        } else if (args[0].equals("ciaz")) {
            carFactory = new CiazCarFactory();
        }
        else{
            System.out.println(args[0]);
        }

        Car car = carBuilder.buildCar(carFactory);

        car.specifyColor();
        car.specifyEngine();
    }

}

// Abstract product - which the factory will produce
interface Car{

    void specifyEngine();
    void specifyColor();
}

class Baleno implements Car{

    public void specifyEngine(){
        System.out.println("My engine is: alpha turbo E1");
    }

    public void specifyColor() {
        System.out.println("My color is: Ray blue");
    }
}

class Ciaz implements Car{
    public void specifyEngine() {
        System.out.println("My engine is: zeta turbo xz");
    }

    public void specifyColor() {
        System.out.println("My color is : Next blue");
    }
}

// Abstract factory which creates different car objects
interface CarFactory{
    Car createCar();
}

class BalenoCarFactory implements CarFactory{

    public Car createCar() {
        Baleno baleno = new Baleno();
        return baleno;
    }
}

class CiazCarFactory implements CarFactory{

    public Car createCar() {
        return new Ciaz();
    }
}

class CarBuilder{
    public Car buildCar(CarFactory createCar){
        if(createCar != null) {
            return createCar.createCar();
        }
        throw new IllegalArgumentException("Type of car to be factoried is not specified");
    }
}