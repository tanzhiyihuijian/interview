package cn.com.dom4j.jianshu;

import cn.com.dom4j.util.DateUtil;
import cn.com.dom4j.util.NetUtil;
import cn.com.dom4j.util.UnicodeUtil;
import cn.com.dom4j.weather.WeatherService;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CodeResume {

    public static void main(String[] args) {

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse("1995-03-17");

            showAge(date);
            showDiary();

            showBaseInfo();

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


    private static void showBaseInfo() {

        Person me = new Person();
        me.setName("王波");
        me.setGender("男");
        me.setPhone("17611631995");
        me.setWeChat("dom4j_");
        me.setQq("1326266975");
        me.setAddress("上海市闵行区浦江镇世博家园七街坊68号");
        me.setMajor("安徽理工大学 电子商务 ");
        me.setEducation("本科 (2014 – 2018) ");
        me.setEmail("w15635606382@gmail.com");
        me.setBlog("https://blog.csdn.net/Dom4j_");
        me.setGithub("https://github.com/tanzhiyihuijian");


        me.setWorkExperience("2017.07 – 2018.03 北京老玩童信息技术有限公司 " +
                "\n 1) 负责电商项目的新功能模块开发, 包括前台,后台的开发及版本迭代 " +
                "\n 2) 负责日常功能优化及BUG修复 ");

        List<String> projectExperience = new ArrayList<>();
        projectExperience.add("电商旅游项目 "
                + "\n 负责整个旅游项目的开发, 主要功能: 丰富旅游类商品配置项, 将旅游类服务的主流程从线 下移至线上, 提供线下收款支付途径, 建立旅游类订单后台统计 ");

        projectExperience.add("话费充值系统"
                + "\n 负责在现有欧非话费充值的基础上, 提供一套基于聚合数据的话费充值系统 ");

        projectExperience.add("电商系统改版 "
                + "\n · 负责全部商品分类模块的开发 "
                + "\n · 负责商品特价活动模块的开发 "
                + "\n · 负责分销类电商邀请开店活动的开发 "
                + "\n · 负责下单流程中满件包邮活动的开发 ");

        me.setProjectExperience(projectExperience);

        List<String> skill = new ArrayList<>();
        skill.add("Java基础扎实 [自学] ");
        skill.add("熟悉基础的数据结构和算法 ");
        skill.add("熟悉后端开发技术 Spring, Spring mvc, Mybatis, Shiro, Quartz, Maven, SVN, Git");
        skill.add("熟悉MySQL应用开发, 了解Redis");
        skill.add("熟练前端技术及框架, 如 HTML, CSS, Jquery, JqGrid, BootStrap, Vue ");
        skill.add("了解Linux的使用,会使用常用的指令完成项目工作 ");
        skill.add("了解JVM原理, 内存分配及垃圾回收机制, 类加载机制, 并发编程 ");
        skill.add("了解计算机网络, HTTP, TCP/IP等通信协议 ");
        skill.add("热爱技术, 对开发有浓厚兴趣 ");

        me.setSkill(skill);


        System.out.println(me);





    }


    private static void showDiary() {

        Date now = new Date();

        System.out.println("日期: " + DateUtil.format(now, "yyMMdd")
                + "\n星期: 第" + DateUtil.getWeekOfYear(now) + "周, " + DateUtil.getWeekEnum(now).getDesc()
                + "\n地点: " + getCity()
                + "\n天气: " + getWeather()

        );


    }

    private static String getWeather() {

        String city = getCity();

        String cityId = WeatherService.getIDByCityName(city);

        return WeatherService.GetTodayWeatherureByCity(cityId);

    }


    private static String getCity() {

        // 百度定位接口
        String url = "http://api.map.baidu.com/location/ip";

        // String ip = IpUtil.getIp(request);
        String ip = "42.196.43.249";

        String params = "ip=" + ip + "&ak=qY8dp8wTFr8Wf51OqE2GyZHwoahfL56t";

        String result = NetUtil.get(url + "?" + params);

        result = UnicodeUtil.UnicodeToString(result);

        JSONObject jsonObject = new JSONObject(result);
        JSONObject content = (JSONObject) jsonObject.get("content");

        return (String) content.get("address");

    }


    public static void showAge(Date birthday) {

        System.out.println("今天: " + DateUtil.format(new Date(), "yyyy-MM-dd"));

        if (birthday == null)
            return;
        System.out.print("生日: " + DateUtil.format(birthday, "yyyy-MM-dd"));

        Date now = new Date();
        if (DateUtil.compare(birthday, now) > 0)
            return;

        // 获取距今的年数 月数 日数
        int year = DateUtil.getYearInterval(now, birthday);
        System.out.print(" (距今: " + year + "年");

        int month = DateUtil.getMonthInterval(now, birthday);
        System.out.print(" " + month + "月");

        int day = DateUtil.getDayInterval(now, birthday);
        System.out.println(" " + day + "日)");

    }


}
