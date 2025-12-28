package iNas.util;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Scope;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

@Component
@RequiredArgsConstructor
@Slf4j
public class TraceUtil {

    private final Tracer tracer;

    public <T> T trace(String spanName, Supplier<T> operation) {
        return trace(spanName, Map.of(), operation);
    }

    public <T> T trace(String spanName, Map<String, Object> attributes, Supplier<T> operation) {
        Span span = tracer.spanBuilder(spanName).startSpan();
        log.debug("Starting span: {}", spanName);

        attributes.forEach((key, value)-> {
           span.setAttribute(key, value.toString());
        });

        try (Scope scope = span.makeCurrent()) {
            return operation.get();
        } catch (Exception e) {
            span.recordException(e);
            span.setStatus(StatusCode.ERROR);
            log.error("Error in span {}: {}", spanName, e.getMessage());
            throw e;
        } finally {
            span.end();
            log.debug("Finished span: {}", spanName);
        }
    }

    public void trace(String spanName, Runnable operation) {
        trace(spanName, Map.of(), operation);
    }

    public void trace(String spanName, Map<String, Object> attributes, Runnable operation) {
        Span span = tracer.spanBuilder(spanName).startSpan();
        log.debug("Starting span: {}", spanName);

        attributes.forEach((key, value)-> {
            span.setAttribute(key, value.toString());
        });

        try (Scope scope = span.makeCurrent()) {
            operation.run();
        } catch (Exception e) {
            span.recordException(e);
            span.setStatus(StatusCode.ERROR);
            log.error("Error in span {}: {}", spanName, e.getMessage());
            throw e;
        } finally {
            span.end();
            log.debug("Finished span: {}", spanName);
        }
    }

    public Optional<String> getCurrentTraceId() {
        return Optional.ofNullable(Span.current().getSpanContext().getTraceId());
    }

}
