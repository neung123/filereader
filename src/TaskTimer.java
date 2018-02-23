public class TaskTimer {

    public double timer(Runnable task) {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        task.run();
        stopwatch.stop();

        double time = stopwatch.getElapsed();
        System.out.printf("finished in %f sec\n", time);

        return time;
    }
}
