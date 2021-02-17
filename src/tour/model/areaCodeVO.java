package tour.model;

public class areaCodeVO {

    private int code;
    private String name;
    private int rnum;

    public areaCodeVO() {
    }

    public areaCodeVO(int code, String name, int rnum) {
        this.code = code;
        this.name = name;
        this.rnum = rnum;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRnum() {
        return rnum;
    }

    public void setRnum(int rnum) {
        this.rnum = rnum;
    }
}
