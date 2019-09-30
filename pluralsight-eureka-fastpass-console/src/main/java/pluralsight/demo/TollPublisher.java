package pluralsight.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

@Component
@EnableBinding(TollSource.class)
//@EnableBinding(Source.class)
public class TollPublisher {

//	//@InboundChannelAdapter(channel=Source.OUTPUT)
//	@Output(Source.OUTPUT)
//	public String sendTollCharge() {
//		return "{station:\"20\", customerid:\"100\", timestamp:\"2017-07-12T03:15:00\"}";
//	}
//	

	/*
	 * Using @Output annotation for this we have used executed the messagae using messageChannel
	 */
	@Autowired
    private  FastPassStreams fastPassStreams;
	
		public void sendTollCharge() {
			String message = "{station:\"20\", customerid:\"100\", timestamp:\"2017-07-12T03:15:00\"}";
			
			  System.out.println("Sending greetings {} "+ message);
		        MessageChannel messageChannel = fastPassStreams.outbound();
		        messageChannel.send(MessageBuilder
		                .withPayload(message)
		                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
		                .build());
		}
		

//	Random r = new Random();
//	
//	@Bean
//	//@InboundChannelAdapter(channel="fastpassTollChannel", poller=@Poller(fixedDelay="5000"))
//	public MessageSource<Toll> sendTollCharge() {
//
//		return () -> MessageBuilder.withPayload(new Toll("20","100","2017-07-12T12:04:00"))
//				.setHeader("speed", r.nextInt(8)*10).build();		
//	}
//	

	
}
