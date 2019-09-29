package pluralsight.demo;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface TollSource {

	@Output("fastpassTollChannel")
	MessageChannel fastpassToll();

	@Output("standardTollChannel")
	MessageChannel standardToll();

}
