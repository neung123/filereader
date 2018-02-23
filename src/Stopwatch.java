/**
 * Stopwatch is an object for measuring time.
 *
 * @author Pornpavee Seri-umnuoy
 */
public class Stopwatch {
    private static final double NANOSECOND = 1.0E-9;
    long startTime;
    long stopTime;
    private boolean running;

    /**
     * construct Stopwatch and initialize running to false.
     */
    public Stopwatch(){
        running = false;
    }

    /**
     * @return the value of running in boolean.
     */
    public boolean isRunning() {
        return running;
    }

    /**
     * A method for start measuring time.
     */
    public void start(){
        if(running) return;
        running = true;
        startTime = System.nanoTime();
    }

    /**
     * A method for stop measuring time.
     */
    public void stop(){
        if(!running) return;
        running = false; 
        stopTime = System.nanoTime();
    }

    /**
     * @return  the current time, if running is true.
     *          the time after stop measuring time, if running is false.
     */
    public double getElapsed(){
        if(running) return (System.nanoTime() - startTime)*NANOSECOND;
        else return (stopTime - startTime)*NANOSECOND;
    }




}
