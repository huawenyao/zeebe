package io.zeebe.util.sched;

import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class RunnableAdapter<T> implements Runnable
{
    private final Callable<T> callable;

    private T value;
    private Throwable exception;

    public RunnableAdapter(Callable<T> callable)
    {
        this.callable = callable;
    }

    @Override
    public void run()
    {
        try
        {
            value = callable.call();
        }
        catch (Exception e)
        {
            exception = e;
        }
    }

    public static <T> RunnableAdapter<T> wrapCallable(Callable<T> callable)
    {
        return new RunnableAdapter<>(callable);
    }

    public static RunnableAdapter<Void> wrapRunnable(Runnable callable)
    {
        return new RunnableAdapter<Void>(() ->
        {
            callable.run();
            return null;
        });
    }

    public Runnable wrapBiConsumer(BiConsumer<T, Throwable> consumer)
    {
        return () ->
        {
            consumer.accept(value, exception);
        };
    }

    public Runnable wrapConsumer(Consumer<Throwable> consumer)
    {
        return () ->
        {
            consumer.accept(exception);
        };
    }
}
