package likedriving.designpatterns;

public class CommandPattern {

    public static void main(String[] args) {
        Light light = new Light();
        Command turnOnLightCommand  = new TurnOnLightCommand(light);
        RemoteControl remoteControlOn = new RemoteControl(turnOnLightCommand);

        Command turnOffLightCommand  = new TurnOffLightCommand(light);
        RemoteControl remoteControlOff = new RemoteControl(turnOffLightCommand);

        // Turn On likedriving.designpatterns.Light
        remoteControlOn.run();

        // Turn Off likedriving.designpatterns.Light
        remoteControlOff.run();
    }
}

class RemoteControl{

    private Command command;
    RemoteControl(Command command){
        this.command = command;
    }

    void run(){
        command.execute();
    }
}

interface Command{
    void execute();
}

class TurnOnLightCommand implements Command{

    private Light light;

    TurnOnLightCommand(Light light){
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}


class TurnOffLightCommand implements Command{

    private Light light;

    TurnOffLightCommand(Light light){
        this.light = light;
    }
    public void execute(){
        light.turnOff();
    }
}

class Light{

    void turnOn(){
        System.out.println("likedriving.designpatterns.Light turned on");
    }

    void turnOff(){
        System.out.println("Turn off light");
    }
}