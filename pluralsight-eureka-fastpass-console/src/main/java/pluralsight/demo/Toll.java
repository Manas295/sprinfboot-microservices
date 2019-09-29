package pluralsight.demo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @Builder
@NoArgsConstructor
class Toll {
	public String stationId;
	public String customerId;
	public String timestamp;
	
	public Toll(String StationId, String CustomerId, String Timestamp) {
		this.stationId = StationId;
		this.customerId = CustomerId;
		this.timestamp = Timestamp;
	}
}