package cn.com.dom4j.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetUtil {

    private static CloseableHttpClient httpClient = HttpClientBuilder.create().build();

    public static String get(String url) {

        StringBuilder sb = new StringBuilder();
        HttpGet httpGet = new HttpGet(url);

        try {
            HttpResponse response = httpClient.execute(httpGet);

            HttpEntity entity = response.getEntity();

            InputStreamReader reader = new InputStreamReader(entity.getContent(), "utf-8");

            char[] chars;
            while (0 < reader.read(chars = new char[10])) {
                sb.append(chars);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpGet.releaseConnection();
        }

        return sb.toString();

    }


    public static String post(String url, String data) {

        HttpURLConnection http = null;
        PrintWriter out = null;
        BufferedReader reader = null;

        try {

            // 创建连接
            URL urlPost = new URL(url);
            http = (HttpURLConnection) urlPost.openConnection();

            http.setDoOutput(true);
            http.setDoInput(true);
            http.setRequestMethod("POST");
            http.setUseCaches(false);
            http.setInstanceFollowRedirects(true);
            http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            http.connect();

            // POST 请求
            OutputStreamWriter outWriter = new OutputStreamWriter(http.getOutputStream(), "utf-8");
            out = new PrintWriter(outWriter);
            out.print(data);
            out.flush();
            out.close();
            out = null;

            // 读取响应
            reader = new BufferedReader(new InputStreamReader(http.getInputStream()));

            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                line = new String(line.getBytes(), "utf-8");
                sb.append(line);
            }

            reader.close();
            reader = null;
            return sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (http != null) {
                http.disconnect();
            }
            if (out != null) {
                out.close();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }




}
