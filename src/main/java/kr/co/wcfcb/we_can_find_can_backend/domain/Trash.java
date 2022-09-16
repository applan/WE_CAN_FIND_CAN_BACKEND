package kr.co.wcfcb.we_can_find_can_backend.domain;

public class Trash {

	enum Type {
        CAN("can"), GARBASGE("garbasge");

        private final String type;
        Type(String type) {this.type = type;}
        public String getType() {return type;}
    }
	// id
	private String id;
	// 쓰레기통 위치 명(?)
    private String title;
    // 쓰레기통 유형
	private Type type;
    // 비고
    private String contents;
    // 위치 (경도, 위도)
    private Location location;
    // 삽입일
    private String insDate;
    // 수정일
    private String updDate;
    
    public void setId(String id) {
    	this.id = id ;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setInsDate(String insDate) {
        this.insDate = insDate;
    }

    public void setUpdDate(String updDate) {
        this.updDate = updDate;
    }

    public void setType(String type) {
        this.type = Type.valueOf(type);
    }

    public String getId() {
    	return id;
    }
    
    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }
    
    public Type getType() {
        return type;
    }

    public Location getLocation() {
        return new Location(location.getLat(), location.getLon());
    }

    public String getInsDate() {
        return insDate;
    }

    public String getUpdDate() {
        return updDate;
    }
    
    public Trash() {
    }
    public Trash(String title, String contents, Location location, String insDate, String updDate, String type) {
    	this.title = title;
        this.contents = contents;
        this.location = location;
        this.insDate = insDate;
        this.updDate = updDate;
        this.type = Type.valueOf(type);
    }
    
    public Trash(String id, String title, String contents, Location location, String insDate, String updDate, String type) {
    	this.id = id;
    	this.title = title;
        this.contents = contents;
        this.location = location;
        this.insDate = insDate;
        this.updDate = updDate;
        this.type = Type.valueOf(type);
    }
}
