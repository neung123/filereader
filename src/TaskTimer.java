/**
 * A class for run all tasks.
 *
 * @author Pornpavee Seri-umnuoy
 */
public class TaskTimer {

    /**
     * measing time while doing a task
     * and print the result.
     * @param task is a task that you want to measuring time.
     * @return time in double.
     */
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
