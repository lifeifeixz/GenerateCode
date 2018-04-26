/*
 * 工具类
 * 功能：
 * 1.读取互联网上的超文本
 * 2.读取硬盘上的文件
 * 3.往硬盘上写出文件
 *
 * 后续过程仍会增加功能
 */
package test.gongxaing.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author flysLi
 * @date 2017/10/27
 */
@SuppressWarnings("all")
public class ResourceTransportationUtil {

    /**
     * 加载远程文件得到DOM格式
     *
     * @param uri 一个网页地址
     * @return
     * @throws Exception
     */
    public static Document get(String uri) throws Exception {
        URL url = new URL(uri);
        HttpURLConnection httpUrl = (HttpURLConnection) url.openConnection();
        InputStream is = httpUrl.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        is.close();
        br.close();
        return Jsoup.parse(sb.toString());
    }

    /**
     * 加载远程文件得到String格式
     *
     * @param uri     超链接
     * @param charset 字符编码
     * @return
     * @throws Exception
     */
    public static Document get(String uri, String charset) throws Exception {
        URL url = new URL(uri);
        HttpURLConnection httpUrl = (HttpURLConnection) url.openConnection();
        //设置请求超时时间
        httpUrl.setReadTimeout(1000 * 60);
        InputStream is = httpUrl.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, charset));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        is.close();
        br.close();
        return Jsoup.parse(sb.toString());
    }

    /**
     * 读取本地(硬盘)资源
     *
     * @param uri
     * @return
     * @throws Exception
     */
    public static String reader(String uri) {
        URL url;
        HttpURLConnection httpUrl;
        InputStream is = null;
        BufferedReader br = null;
        StringBuilder sb;
        try {
            url = new URL(uri);
            httpUrl = (HttpURLConnection) url.openConnection();
            is = httpUrl.getInputStream();
            br = new BufferedReader(new InputStreamReader(is, "utf-8"));
            sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 读取本地资源
     *
     * @param path
     * @return
     */
    public static String readLocalResource(String path) {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));//构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                result.append(System.lineSeparator() + s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void writer(String content, String path) {
        FileOutputStream fop = null;
        File file;
        try {
            file = new File(path);
            fop = new FileOutputStream(file);
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            // get the content in bytes
            byte[] contentInBytes = content.getBytes();
            fop.write(contentInBytes);
            fop.flush();
            fop.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fop != null) {
                    fop.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 下载文件
     *
     * @param url
     * @param savePath
     * @throws Exception
     */
    public static void download(String url, String savePath) throws Exception {
        //截取后缀名
        String imageName = url.substring(url.lastIndexOf("/") + 1, url.length());
        URL uri = new URL(url);
        InputStream in = uri.openStream();
        FileOutputStream fo = new FileOutputStream(new File(savePath, imageName));
        byte[] buf = new byte[1024];
        int length = 0;
        while ((length = in.read(buf, 0, buf.length)) != -1) {
            fo.write(buf, 0, length);
        }
        in.close();
        fo.close();

    }

    /**
     * 自定义文件名称下载
     *
     * @param url      资源路径
     * @param newName  新文件名
     * @param savePath 存放路径
     */
    public static void download(String url, String newName, File savePath) throws Exception {
        URL uri = new URL(url);
        InputStream in = uri.openStream();
        FileOutputStream fo = new FileOutputStream(new File(savePath.getPath(), newName));
        byte[] buf = new byte[1024];
        int length = 0;
        while ((length = in.read(buf, 0, buf.length)) != -1) {
            fo.write(buf, 0, length);
        }
        in.close();
        fo.close();
    }

    /**
     * 一个更暴力的抓取方式
     *
     * @param pageUrl
     * @param encoding
     * @return
     */
    public static String getPageSource(String pageUrl, String encoding) {
        StringBuffer sb = new StringBuffer();
        try {
            //构建一URL对象
            URL url = new URL(pageUrl);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            //使用openStream得到一输入流并由此构造一个BufferedReader对象
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), encoding));
            String line;
            //读取www资源
            while ((line = in.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            in.close();
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return sb.toString();
    }

    /**
     * 往文件中追加数据
     *
     * @param file
     * @param data
     */
    public static void appendData(File file, String data) {
        FileWriter fw = null;
        try {
            //如果文件存在，则追加内容；如果文件不存在，则创建文件
            fw = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.println(data);
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // System.out.println(FetchResourceDefault.readLocalResource("D:\\L临时数据\\user.sql"));
        System.out.println(ResourceTransportationUtil.getPageSource("http://www.jingyu.com/?msrc=360xiaoshuo", "UTF-8"));
    }
}
