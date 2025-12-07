package iNas.kafka.consumer;

public interface EventListener<T> {
    void consume(T event);
}