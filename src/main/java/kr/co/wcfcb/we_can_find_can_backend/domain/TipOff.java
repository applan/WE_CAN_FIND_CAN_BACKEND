package kr.co.wcfcb.we_can_find_can_backend.domain;

public class TipOff {

    /**
     * 제보 타입
     * FULL - 쓰레기통 가득 참
     * MOVE - 쓰레기통 위치 이동
     */
    enum Type {
        FULL, MOVE
    }

    // 제보 제목
    private String title;

    // 제보 타입
    private Type type;
    
    // 제보 내용
    private String contents;

    // 제보 위치
    private Location location;

    public TipOff(String title, Type type, String contents, Location location) {
        this.title = title;
        this.type = type;
        this.contents = contents;
        this.location = location;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public Type getType() {
        return type;
    }

    public String getContents() {
        return contents;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "TipOff{" +
                "title='" + title + '\'' +
                ", type=" + type +
                ", contents='" + contents + '\'' +
                ", location=" + location +
                '}';
    }
}
