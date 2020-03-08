package Utils;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailUtil {

    private static MyLogger logger = new MyLogger("Utils.EmailUtil");
    public static boolean sendEmail(String toEmail, String emailContent, String emailTitle) {
        boolean flag = false;
        final  Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", GlobalValue.WANGYI_EMAIL_HOST);
        // 发件人的账号
        props.put("mail.user", GlobalValue.WANGYI_EMAIL);
        //发件人的授权码
        props.put("mail.password", GlobalValue.WANGYI_163_CODE);
        try
        {
            // 构建授权信息，用于进行SMTP进行身份验证
            Authenticator authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    // 用户名、密码
                    String userName = props.getProperty("mail.user");
                    String password = props.getProperty("mail.password");
                    return new PasswordAuthentication(userName, password);
                }
            };
            // 使用环境属性和授权信息，创建邮件会话
            Session mailSession = Session.getInstance(props, authenticator);
            // 创建邮件消息
            MimeMessage message = new MimeMessage(mailSession);
            // 设置发件人
            String username = props.getProperty("mail.user");
            InternetAddress form = new InternetAddress(username);
            message.setFrom(form);
            // 设置收件人
            InternetAddress to = new InternetAddress(toEmail);
            message.setRecipient(Message.RecipientType.TO, to);
            // 设置邮件标题
            message.setSubject(emailTitle);
            // 设置邮件的内容体
            message.setContent(emailContent, "text/html;charset=UTF-8");
            // 发送邮件
            Transport.send(message);
            flag = true;
            logger.info("flag", ""+flag);

        }
        catch (AddressException e) {
            logger.info("AddressException", "初始化邮件地址错误");
            e.printStackTrace();
            return false;
        }
        catch (MessagingException e) {
            logger.info("MessagingException", "邮件发送错误");
            e.printStackTrace();
            return false;
        }
        catch (Exception e){
            logger.info("Exception", "其他错误");
            e.printStackTrace();
            return false;
        }
        return flag;
    }
}
