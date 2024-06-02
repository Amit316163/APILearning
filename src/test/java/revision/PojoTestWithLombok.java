package revision;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class PojoTestWithLombok {
	
	@JsonProperty("name")
	private String amit;
	
	private String gender;
	private String email;
	private String status;	
	private Integer id;
	

	
	
	

	public PojoTestWithLombok(String amit, String gender, String email, String status) {
		
		this.amit = amit;
		this.gender = gender;
		this.email = email;
		this.status = status;
	}
	
	

}
