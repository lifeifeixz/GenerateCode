package test.gongxaing.model;

/**
 * @author flysLi
 * @date 2018/3/12
 */
public class Field {
    private String field;
    private String name;
    private String type;

    public Field() {
    }

    public Field(String field, String name) {
        this.field = field;
        this.name = name;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

	@Override
	public String toString() {
		return "Field [field=" + field + ", name=" + name + ", type=" + type + "]";
	}
    
    
}
