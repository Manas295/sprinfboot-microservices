package pluralsight.demo;

import java.util.Random;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;

@EnableBinding(TollSource.class)
//@EnableBinding(Source.class)
public class TollPublisher {

//	@InboundChannelAdapter(channel=Source.OUTPUT)
//	//@Output(value=Source.OUTPUT)
//	public String sendTollCharge() {
//		return "{station:\"20\", customerid:\"100\", timestamp:\"2017-07-12T03:15:00\"}";
//	}
//	

	Random r = new Random();
	
	@Bean
	//@InboundChannelAdapter(channel="fastpassTollChannel", poller=@Poller(fixedDelay="5000"))
	public MessageSource<Toll> sendTollCharge() {

		return () -> MessageBuilder.withPayload(new Toll("20","100","2017-07-12T12:04:00"))
				.setHeader("speed", r.nextInt(8)*10).build();		
	}
	

	
}
