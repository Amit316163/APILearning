package pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class CreatePetStorePojoWithLombok {
	
	@JsonProperty("id")
	private Integer id;	
	
	@JsonProperty("category")
	private Category category;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("tags")
	private List<Tags> tags;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("photoUrls")
	private List<String> photoUrls;
	
	
	public CreatePetStorePojoWithLombok(Integer id, Category category, String name, List<Tags> tags, String status,
			List<String> photoUrls) {
		this.id = id;
		this.category = category;
		this.name = name;
		this.tags = tags;
		this.status = status;
		this.photoUrls = photoUrls;
	}
	
	
	
	
	
	@Data
	@NoArgsConstructor
	//@AllArgsConstructor
	public static class Category{
		
		@JsonProperty("id")
		private Integer id;
		
		@JsonProperty("name")
		private String name;
		
		public Category(Integer id, String name) {
			this.id = id;
			this.name = name;
		}
	}
	@Data
	@NoArgsConstructor
//	@AllArgsConstructor
	public static class Tags{
		@JsonProperty("id")
		private Integer id;
		
		

		@JsonProperty("name")
		private String name;
		
		public Tags(Integer id, String name) {
			this.id = id;
			this.name = name;
		}
		
	}
	
		
}
	
	

