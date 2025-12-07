package iNas.kafka.handler;

public interface EventHandler<T> {
    boolean isHandle(T event);
    void handle(T event);
}
