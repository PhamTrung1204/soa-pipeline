package vn.edu.ueh.bit.pipes.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.edu.ueh.bit.pipes.filters.*;
import vn.edu.ueh.bit.pipes.pipes.Pipeline;
import vn.edu.ueh.bit.pipes.queue.MessageProcessor;
import vn.edu.ueh.bit.pipes.queue.MessageQueue;

@Configuration
public class ApplicationConfig {

    @Bean
    public Pipeline pipeline() {
        Pipeline pipeline = new Pipeline();
        pipeline.addFilter(new InventoryCheckFilter());
        pipeline.addFilter(new DeliveryServiceFilter());
        pipeline.addFilter(new PaymentVerificationFilter());
        pipeline.addFilter(new OrderCreationFilter());
        pipeline.addFilter(new EmailNotificationFilter());
        return pipeline;
    }

    @Bean
    public MessageQueue messageQueue() {
        return new MessageQueue();
    }

    @Bean
    public MessageProcessor messageProcessor(MessageQueue messageQueue, Pipeline pipeline) {
        MessageProcessor processor = new MessageProcessor(messageQueue, pipeline, 4);
        processor.start();
        return processor;
    }
}