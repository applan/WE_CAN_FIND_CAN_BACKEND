package kr.co.wcfcb.we_can_find_can_backend.domain;

public class Trash {

    enum Type{
        LIVING, CAN
    }

    // 쓰레기통 위치 명(?)
    private String title;
    // 비고
    private String contents;
    // 위치 (경도, 위도)
    private Location location;
    // 삽입일
    private String insDate;
    // 수정일
    private String updDate;
    // 쓰레기 타입 (생활, 쓰레기통)
    private Type type;

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

    public void setType(Type type) {
        this.type = type;
    }

    public String getTitle() {return title;}

    public String getContents() {
        return contents;
    }

    public Location getLocation() {
        return location;
    }

    public String getInsDate() {
        return insDate;
    }

    public String getUpdDate() {
        return updDate;
    }

    public Type getType() {return type;}

    public Trash() {}

    public Trash(String title, String contents, Location location, String insDate, String updDate, Type type) {
        this.title = title;
        this.contents = contents;
        this.location = location;
        this.insDate = insDate;
        this.updDate = updDate;
        this.type = type;
    }
}
