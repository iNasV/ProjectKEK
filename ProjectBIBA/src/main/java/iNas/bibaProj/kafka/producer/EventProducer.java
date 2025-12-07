package iNas.bibaProj.kafka.producer;

public interface EventProducer<T> {
    void produce(T event);
}
