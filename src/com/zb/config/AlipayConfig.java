package com.zb.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016102500759969";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDkxLzyGwRDkkmzRlZLa4XvtDgWdWh4QDowmUvrz13dREJhDdNgphrAm++0ATsvhC2qc/ZT2jemabaLmbqaW60+kslvxhsUAU2V0+zwtXogXP8f7Anmp2XyzIaaD1P8nXkR4YpRNT28dQe0lPe+ZHfnqWYM0aQvR/Vzikwqg3xRbPk9rxTCs5wlgw/7ZsjeFyTCnZ4Pg5aYPGg4ujviy23h2M/8PcXjjvWNoSQUkhZIQO1M+ZULLo4UGNRRahvVIxIfM6FCGfRSIZEIFS84Tn/2oFQGoz/ne12mXto1cqU839e4kCiScECGDj7Pj3DcBDSY+gVJiyAWjFjZvpaA6w8bAgMBAAECggEAQP/5Y5zziDN/h1Wb3VAOvT3qlc8EQO6W2gokfTrtQ5pKdgMUpShs/38PC4kyBN08kGrkeYzONRViTaX/VC5qOhZA7+ZM+VEpd0HA19/odFuYDbzmT0gO+n7MW+exCFzB8qevwkUrZmmmJ9QP1GP9gbArE8dZLCn4/rwzyfyUDRos7UUlMjTFCSJ7S2zR//xtWBs55mux5Dn9AL4+jjL8tBSeEFDitlSpK+MhEO9tLoD8A8NxXCbmYOkP8nIexayQ61V4qmo++JJDwEP6lTZZCwHtEdDJylPwjK1cYqIbAUh3IRY//1qYdJRGgK5QpEW125gOuVvpqgDxVPlsO6e8wQKBgQDzGlkHFF3SC1532FinIdILTAYPbDNeHBv8qzvu7rC97mC2s03HfNOYcHj1xJu3VezogCwWNHxBsCkNOE/bz22/C789nkEcUOHnVoISHyirPofwa4Yr8Sj+7vuLhNcBFOLQqGd6pGb7xs0PnUXmdMborgSxm+PNE9UxNlIkLKebYQKBgQDw57Xeuh4X46AWABs9z7QfhMyt1jo7wglVj0p7B8wsncKcSizslL21LO94rIi6yJ1e2jNdqCDytx6FydhI2e4mdyKr7ZsYuAYmoKCPq7cdjPty2xyyzdZ9Om8vSipdBOWxE3eJTAzRcN4hJYui3dL7a2gB9Hlg3qHv61CaraAX+wKBgGw4w39CUs3p38EsX7LvfGkpC92bxnZTvyXJOOISAj5bO1S6F5sB99R55W9LeiKwrsmGHZo4/UPk3zGSawKooeuVmCofJE8ttpNc0ISuuFUbfjrKMy2mqyBqVTL0DR7fJGXNQlu3ilz1UF5uHisMu2vj5BUJF+04sgS5cPHHq0mhAoGAP3AlGnPUfOH6RBDfG5XYjvw/kf958kaUgq1rJZ7WC2G338RAtEQu+MjOfu6gSt+NYW8AW8dsdb33EbAnfne1GPgCb1fwob/EDuP5pBvJ6sQ3avV8RzGhK/T5VnCnWztw6QKBVexq67RXKk9iyA62AnM0Pl+Mnw/BgRZscW8LW4UCgYAHS3bYf6xwEXW6inf65HvPMwjH+11WjT+QPWuLHB6PIMktNq6ROrbl6bosbMHuAbvUrgD9MThjKXgXRa1fhonfSjQkYSwDX4mS6bYlUFlLoSoPy2blhx3gPR4VicPTKn11De2C1TpWZUHeJAYoBscsBwccTWpdO37dXRsJ+cjjwA==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA5MS88hsEQ5JJs0ZWS2uF77Q4FnVoeEA6MJlL689d3URCYQ3TYKYawJvvtAE7L4QtqnP2U9o3pmm2i5m6mlutPpLJb8YbFAFNldPs8LV6IFz/H+wJ5qdl8syGmg9T/J15EeGKUTU9vHUHtJT3vmR356lmDNGkL0f1c4pMKoN8UWz5Pa8UwrOcJYMP+2bI3hckwp2eD4OWmDxoOLo74stt4djP/D3F4471jaEkFJIWSEDtTPmVCy6OFBjUUWob1SMSHzOhQhn0UiGRCBUvOE5/9qBUBqM/53tdpl7aNXKlPN/XuJAoknBAhg4+z49w3AQ0mPoFSYsgFoxY2b6WgOsPGwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "localhost:8080/yongheproject/paysucess";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "localhost:8080/yongheproject/success.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

