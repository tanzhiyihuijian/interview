package cn.com.dom4j.enums;

public enum WeekEnum {

    MONDAY(1, "星期一"),
    TUESDAY(2, "星期二"),
    WEDNESDAY(3, "星期三"),
    THURSDAY(4, "星期四"),
    FRIDAY(5, "星期五"),
    SATURDAY(6, "星期六"),
    SUNDAY(7, "星期天")
    ;

    public static WeekEnum getEnumByCode(int code) {
        if (code <= 0)
            throw new RuntimeException("未查询到该值对应的日期枚举类");

        for (WeekEnum weekEnum : values()) {
            if (code == weekEnum.getCode()) {
                return weekEnum;
            }
        }

        throw new RuntimeException("未查询到该值对应的日期枚举类");
    }


    private int code;
    private String desc;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    WeekEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }






}
