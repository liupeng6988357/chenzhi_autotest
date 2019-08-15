package com.chenzhi.module.util;

import com.chenzhi.module.domain.ModuleData;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;


public class SendMail {


    public static void sendEmail(List<ModuleData> moduleDataList) throws Exception{
        // 配置信息
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.163.com");
        properties.put("mail.smtp.auth", "true");

        // 根据邮件的会话属性构造一个发送邮件的Session，这里需要注意的是用户名那里不能加后缀，否则便不是用户名了
        //还需要注意的是，这里的密码不是正常使用邮箱的登陆密码，而是客户端生成的另一个专门的授权码
        //创建Authenticator内部类，重写getPasswordAuthentication()方法
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                /**在程序代码中登录的密码其实就是那个你设置的授权码*/
                return new PasswordAuthentication("13022862396@163.com",
                        "liupeng0929");
            }
        };
        Session session = Session.getInstance(properties, authenticator);
        // 根据Session 构建邮件信息
        Message message = new MimeMessage(session);
        // 创建邮件发送者地址
        Address from = new InternetAddress("13022862396@163.com");
        // 设置邮件消息的发送者
        message.setFrom(from);
        // 验证收件人邮箱地址
        List<String> toAddressList = new ArrayList<String>();
        toAddressList.add("WJ18966971512@163.com");
        toAddressList.add("liupeng@tchenedu.cn");
        StringBuffer buffer = new StringBuffer();
        if (!toAddressList.isEmpty()) {
            String regEx = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern p = Pattern.compile(regEx);
            for (int i = 0; i < toAddressList.size(); i++) {
                Matcher match = p.matcher(toAddressList.get(i));
                if (match.matches()) {
                    buffer.append(toAddressList.get(i));
                    if (i < toAddressList.size() - 1) {
                        buffer.append(",");
                    }
                }
            }
        }
        String toAddress = buffer.toString();
        if (!toAddress.isEmpty()) {
            // 创建邮件的接收者地址
            Address[] to = InternetAddress.parse(toAddress);
            // 设置邮件接收人地址
            message.setRecipients(Message.RecipientType.TO, to);
            // 邮件主题
            message.setSubject("辰知C端产品自动化测试结果");
            // 邮件容器
            MimeMultipart mimeMultiPart = new MimeMultipart();
            // 设置HTML
            BodyPart bodyPart = new MimeBodyPart();

            // 邮件内容
            StringBuilder content = new StringBuilder("<html><head></head><body><h3>自动化测试报告统计</h3>");
            content.append("<table  width=\"1000\" border=\"1\" cellspacing=\"0\" border-color=\"#333\" style=\"font-size=10px;;font-size:12px; \">");
            content.append("<tr style=\"background-color: #C6E2FF; color:#00868B; font-family:等线; font-size:12px;\">" +
                    "<th>业务模块</th><th>模块用例执行总数</th><th>模块用例执行失败总数</th><th>模块用例执行成功总数</th><th>模块用例执行成功率</th><th>迭代版本用例执行成功率</th></tr>");

            double versionSunNumber = 0;

            double versionSuccessNumber = 0;

            for (int i = 0; i < moduleDataList.size(); i++) {
                versionSunNumber = moduleDataList.get(i).getSunNum() + versionSunNumber;
                versionSuccessNumber = moduleDataList.get(i).getSuccessNum() + versionSuccessNumber;

            }

            for (int i = 0; i < moduleDataList.size(); i++) {

                content.append("<tr>");
                content.append("<td>" + moduleDataList.get(i).getModuleNmae() + "</td>"); //第一列
                content.append("<td>" + moduleDataList.get(i).getSunNum() + "</td>"); //二列
                content.append("<td style=\"color:#FF0000;\">" + moduleDataList.get(i).getFailNum() + "</td>"); //第三列
                content.append("<td>" + moduleDataList.get(i).getSuccessNum() + "</td>"); //第四列

                String modulSuccessRate =String.format("%.2f",((moduleDataList.get(i).getSuccessNum()/moduleDataList.get(i).getSunNum())*100)) +"%";

                content.append("<td style=\"color:#FF0000;\">" + modulSuccessRate + "</td>"); //第五列

                String sumSuccessRate = String.format("%.2f", ((versionSuccessNumber/versionSunNumber)*100)) +"%";

                if (i<1) {
                    content.append("<td rowspan=1000 style=\"color:#FF0000;\">" + sumSuccessRate + "</td>");
                }
                content.append("</tr>");
            }

            content.append("</table>");
            content.append("<h3>测试结论</h3>");

            if (versionSuccessNumber!= versionSunNumber){

                content.append("<font style=\"color:#FF0000; font-family:等线\">"+"迭代版本主流程测试用例执行成功率为："+String.format("%.2f", ((versionSuccessNumber/versionSunNumber)*100)) +"%"+"<100%"+"，测试不通过！！！"+"</font>");
            }else {

                content.append("<font style=\"color:#000000; font-family:等线\">"+"迭代版本主流程测试用例执行通过，测试通过！！！"+"</font>");
            }


            content.append("<h3>备注信息</h3>");
            content.append("<font style=\"color:#0000EE; font-family:等线\">"+"如需查看测试报告，请先下载附件后，使用chrome浏览器打开！！！"+"</font>");
            content.append("</body></html>");

            bodyPart.setContent(content.toString(),"text/html;charset=utf-8");
            mimeMultiPart.addBodyPart(bodyPart);
            // 添加附件
            List<String> fileAddressList = new ArrayList<String>();
            fileAddressList.add("D:\\chenzhi_autotest\\AutoTest\\test-output\\testreport.html");
            if (fileAddressList != null) {
                BodyPart attchPart = null;
                for (int i = 0; i < fileAddressList.size(); i++) {
                    if (!fileAddressList.get(i).isEmpty()) {
                        attchPart = new MimeBodyPart();
                        // 附件数据源
                        FileDataSource source = new FileDataSource(
                                fileAddressList.get(i));
                        // 将附件数据源添加到邮件体
                        attchPart.setDataHandler(new DataHandler(source));
                        // 设置附件名称为原文件名
                        attchPart.setFileName(MimeUtility.encodeText(source.getName()));
                        mimeMultiPart.addBodyPart(attchPart);
                    }
                }
            }


            message.setContent(mimeMultiPart);
            message.setSentDate(new Date());
            // 保存邮件
            message.saveChanges();
            // 发送邮件
            Transport.send(message);
        }
    }


}
