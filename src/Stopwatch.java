public class Stopwatch {
    private static final double NANOSECOND = 1.0E-9;
    long startTime;
    long stopTime;
    private boolean running;

    public Stopwatch(){
        running = false;
    }
    public boolean isRunning() {
        return running;
    }

    public void start(){
        if(running) return;
        running = true;
        startTime = System.nanoTime();
    }

    public void stop(){
        if(!running) return;
        running = false; 
        stopTime = System.nanoTime();
    }

    public double getElapsed(){
        if(running) return (System.nanoTime() - startTime)*NANOSECOND;
        else return (stopTime - startTime)*NANOSECOND;
    }




}
