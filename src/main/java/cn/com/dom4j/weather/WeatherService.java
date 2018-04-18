package cn.com.dom4j.weather;

import cn.com.dom4j.constant.CoreConstant;
import cn.com.dom4j.util.PureNetUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class WeatherService {


    /**
     * 调用接口返回数据后,解析数据,根据输入城市名得到对应ID
     *
     * @param cityName 城市名称
     * @return 返回对应ID
     */
    public static String getIDByCityName(String cityName) {

        String url = CoreConstant.CITY_LIST_URL;
        String result = PureNetUtil.get(url);

        if (result != null) {
            JSONObject obj = JSONObject.fromObject(result);
            result = obj.getString("resultcode");//得到返回状态码
            if (result != null && result.equals("200")) {//200表示成功返回数据
                result = obj.getString("result");//得到城市列表的json格式字符串数组
                JSONArray arr = JSONArray.fromObject(result);
                for (Object o : arr) {//对arr进行遍历
                    //将数组中的一个json个数字符串进行解析
                    obj = JSONObject.fromObject(o.toString());
                    /*此时obj如 {"id":"2","province":"北京","city":"北京","district":"海淀"}*/
                    //以city这个key为线索判断所需要寻找的这条记录
                    result = obj.getString("district");
                    //防止输入城市名不全,如苏州市输入为苏州,类似与模糊查询
                    if (result.equals(cityName) || result.contains(cityName)) {
                        result = obj.getString("id");//得到ID
                        return result;
                    }
                }
            }
        }
        return result;
    }


    /**
     * 获取返回数据中的一个属性示例,此处以获取今日温度为例
     * "temperature": "8℃~20℃"     今日温度
     *
     * @return
     */
    public static String GetTodayWeatherureByCity(String city) {

        String url = CoreConstant.WEATHER_REPORT_BY_CITY_URL;
        String result = PureNetUtil.get(url.replace("*", city));

        if (result != null) {
            JSONObject obj = JSONObject.fromObject(result);
            /*获取返回状态码*/
            result = obj.getString("resultcode");
            /*如果状态码是200说明返回数据成功*/
            if (result != null && result.equals("200")) {
                result = obj.getString("result");
                //此时result中数据有多个key,可以对其key进行遍历,得到对个属性
                obj = JSONObject.fromObject(result);
                //今日温度对应的key是today
                result = obj.getString("today");
                obj = JSONObject.fromObject(result);
                //今日温度对应当key是temperature
                result = obj.getString("weather");
                return result;
            }
        }
        return result;
    }


    /**
     * 利用遍历数组的方式获取
     *
     * @param wid 天气对应id
     * @return 天气名称
     */
    public static String getWeatherByWid(String wid) {

        String url = CoreConstant.WEATHER_SIGN_AND_TYPE_LIST_URL;
        String result = PureNetUtil.get(url);

        if (result != null) {
            JSONObject obj = JSONObject.fromObject(result);
            result = obj.getString("resultcode");
            /*获取返回状态码*/
            if (result != null && result.equals("200")) {
                /*获取数组数据*/
                result = obj.getString("result");
                JSONArray arr = JSONArray.fromObject(result);
                for (Object o : arr) {//遍历数组
                    obj = JSONObject.fromObject(o.toString());
                    //如果遍历到需要的数据后直接返回结果,根据key(wid)得到value判断是否等于传入参数
                    if (obj.getString("wid").equals(wid)) {
                        result = obj.getString("weather");
                        return result;
                    }
                }
            }
        }
        return result;
    }


}
