package week2.forth;

public class Controller {
    public static void main(String[] args) {
        SleepyImpl sleepyc = new SleepyImpl();
        sleepyc.ask();
        sleepyc.sleep();
        sleepyc.ask();
        sleepyc.wakeUp();
        sleepyc.ask();
    }
}
