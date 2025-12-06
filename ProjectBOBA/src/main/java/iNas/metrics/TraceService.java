package iNas.metrics;

import io.micrometer.tracing.Span;
import io.micrometer.tracing.Tracer;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
@RequiredArgsConstructor
public class TraceService {
    private static final Logger logger = LoggerFactory.getLogger(TraceService.class);
    private final Tracer tracer;

    public <T> T trace(String spanName, Supplier<T> operation) {
        Span span = tracer.nextSpan().name(spanName).start();
        try (Tracer.SpanInScope ws = tracer.withSpan(span)) {
            logger.debug("Starting span: {}", spanName);
            return operation.get();
        } catch (Exception e) {
            span.error(e);
            logger.error("Error in span {}: {}", spanName, e.getMessage());
            throw e;
        } finally {
            span.end();
            logger.debug("Finished span: {}", spanName);
        }
    }

    public void trace(String spanName, Runnable operation) {
        Span span = tracer.nextSpan().name(spanName).start();
        try (Tracer.SpanInScope ws = tracer.withSpan(span)) {
            logger.debug("Starting span: {}", spanName);
            operation.run();
        } catch (Exception e) {
            span.error(e);
            logger.error("Error in span {}: {}", spanName, e.getMessage());
            throw e;
        } finally {
            span.end();
            logger.debug("Finished span: {}", spanName);
        }
    }

    public void addTag(String key, String value) {
        Span currentSpan = tracer.currentSpan();
        if (currentSpan != null) {
            currentSpan.tag(key, value);
            logger.debug("Added tag {}={} to span", key, value);
        }
    }

    public Span createChildSpan(String spanName) {
        Span childSpan = tracer.nextSpan().name(spanName).start();
        logger.debug("Created child span: {}", spanName);
        return childSpan;
    }

    public String getCurrentTraceId() {
        return tracer.currentSpan() != null ?
                tracer.currentSpan().context().traceId() : "no-trace";
    }

}
