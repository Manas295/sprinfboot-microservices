package pluralsight.demo;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class TollPubListener {
	@StreamListener(target=FastPassStreams.INPUT)
	 public void handleGreetings(@Payload Toll tolls) {
       System.out.println("Received greetings: {} "+ tolls);
   }
}
