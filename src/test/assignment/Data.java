package test.assignment;

public class Data {
	private Long id;
	private String category;
	private String type;
	private String key;
	private String value;
	private String attributes;
	private Boolean active;
	
	public Data(String category, String type, String key, String value, String attributes, Boolean active) {
		super();
		this.category = category;
		this.type = type;
		this.key = key;
		this.value = value;
		this.attributes = attributes;
		this.active = active;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getAttributes() {
		return attributes;
	}
	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}