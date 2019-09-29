package pluralsight.demo;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface FastPassStreams {
    String INPUT = "pub-input";
    String OUTPUT = "pub-output";
    @Input(INPUT)
    SubscribableChannel inboundGreetings();
    @Output(OUTPUT)
    MessageChannel outboundGreetings();
}