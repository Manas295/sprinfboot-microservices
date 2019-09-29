package pluralsight.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import lombok.NoArgsConstructor;

@Service

@NoArgsConstructor
public class TollPubService {
	@Autowired
    private  FastPassStreams fastPassStreams;

   

    public void sendMessage( Toll tolls) {
        System.out.println("Sending greetings {} "+ tolls);
        MessageChannel messageChannel = fastPassStreams.outboundGreetings();
        messageChannel.send(MessageBuilder
                .withPayload(tolls)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    }
}
