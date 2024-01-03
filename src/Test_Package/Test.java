package Test_Package;


abstract class Handler {

    protected Handler handler;

    public void setHadler(Handler handler) {
        this.handler = handler;
    }

    public abstract void process(Client client);
}

class Hadler1 extends Handler {

    @Override
    public void process(Client client) {
        if (client.i == 0) {
            System.out.println("Error - A");
        } else {
            this.handler.process(client);
        }
    }
}

class Hadler2 extends Handler {

    @Override
    public void process(Client client) {
        if (client.i % 2 == 0) {
            this.handler.process(client);
        } else {
            System.out.println("Error - B");
        }
    }
}

class Hadler3 extends Handler {

    @Override
    public void process(Client client) {
        if (client.i % 5 == 0) {
            System.out.println("Success");
        } else {
            System.out.println("Error - C");
        }
    }

}

class Client {

    int i;
}

public class Test {

    public static void main(String[] args) {
        Client client = new Client();
        client.i = 10;

        Hadler1 hadler1 = new Hadler1();
        Hadler2 hadler2 = new Hadler2();
        Hadler3 hadler3 = new Hadler3();

        hadler1.setHadler(hadler2);
        hadler2.setHadler(hadler3);
        
        hadler1.process(client);
    }
}
