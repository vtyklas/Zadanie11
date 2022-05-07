public class StringTask extends Thread implements Runnable {
    private String text;
    private int counter;
    private TaskState state;
    private String result;
    private boolean isDone = false;


    public StringTask(String text, int counter)
    {
        this.text = text;
        this.counter = counter;
        state = TaskState.CREATED;
    }

    public enum TaskState
    {
        CREATED,RUNNING,ABORTED,READY
    }

    @Override
    public void run()
    {
        Thread t = new Thread(this);
        this.state=TaskState.READY;
        t.start();
    }

    public String getResult()
    {
        return result;
    }

    public void start()
    {
        for (int i = 0; i < counter; i++) {
            result +=text;
        }
        this.state = TaskState.RUNNING;
    }

    public void abort() throws Throwable
    {
        this.isDone = true;
        this.state = TaskState.ABORTED;
        interrupt();

    }

    public boolean isDone()
    {
        return this.isDone;
    }

    public TaskState getState(){
        
    }



}
