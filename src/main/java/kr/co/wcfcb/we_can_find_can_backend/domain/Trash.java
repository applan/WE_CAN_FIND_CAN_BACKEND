package kr.co.wcfcb.we_can_find_can_backend.domain;

public class Trash {

	enum Type {
        CAN("can"), GARBASGE("garbasge");

        private final String type;
        Type(String type) {this.type = type;}
        public String getType() {return type;}
    }
    // 쓰레기통 위치 명(?)
    private String title;
    private Type type;
    // 비고
    private String contents;
    // 위치 (경도, 위도)
    private Location location;
    // 삽입일
    private String insDate;
    // 수정일
    private String updDate;
    // 인덱스
    private String _index;
    
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

    public void set_index(String _index) {
    	this._index = _index;
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

    public String get_index(String _index) {
    	return _index;
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
}
