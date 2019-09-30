package pluralsight.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageChannelController {
	@Autowired private TollPubService tollservice;

	@Autowired 
	private TollPublisher publisher;

	@PostMapping(path="/publish") public void publishMessage(@RequestBody Toll toll) {

		tollservice.sendMessage(toll); }
	
	
	@PostMapping(path = "/publishMessage")
	public void sendMessage() {
		publisher.sendTollCharge();
	}

}
