package com.spring.libraryManagement.service;

import com.spring.libraryManagement.model.entity.Role;
import com.spring.libraryManagement.model.entity.User;
import com.spring.libraryManagement.repository.UserRepo;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import  net.bytebuddy.utility.RandomString;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
public class UserService {



    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    UserRepo userRepo;


    public List<User> allUsers(){
        return this.userRepo.findAll();
    }

    public ResponseEntity<?> LoginUser(User userData){
        User user =userRepo.findUserByUserName(userData.getUserName());
        if(user.getPassword().equals(userData.getPassword()) && user.getRole().equals(userData.getRole()))
            return ResponseEntity.ok(user);
        return (ResponseEntity<?>) ResponseEntity.internalServerError();
    }



    public ResponseEntity<?> SignupUser( User userData){
        Role defaultRole = new Role();
        defaultRole.setId(2L);
        defaultRole.setRoleName("student");
        userData.setRole(defaultRole);
        userData.setEnabled(false);


        String randomCode =RandomString.make(64);
        System.out.println(randomCode);
        userData.setVerificationCode(randomCode);
        User userSignupDta =this.userRepo.save(userData);
        return ResponseEntity.ok(userSignupDta);
    }


    public void sendVerificationEmail(User user ,String siteURL) throws MessagingException, UnsupportedEncodingException {
        String subject ="please verify your registration";
        String senderName="Library Team";
        String mailContent="<p> Dear "+user.getFirstName()+", </p>";
        mailContent +="<p> please click the link below to verify your registration: </p> ";
        String verifyUrl= siteURL + "/user/verify?code="+user.getVerificationCode();
        mailContent +="<h3> <a href=\"" + verifyUrl +"\" >VERIFY</a> </h3>";
        mailContent +="<p> Thank you <br> The Library Team </p>";

        MimeMessage message =mailSender.createMimeMessage();
        MimeMessageHelper helper =new MimeMessageHelper(message);
        helper.setFrom("eamr87641@gmail.com",senderName);
        helper.setTo(user.getEmail());
        helper.setSubject(subject);
        helper.setText(mailContent,true);
        mailSender.send(message);

    }
    @Transactional
    public boolean verify(String  verificationCode){
        User user =userRepo.findUserByVerificationCode(verificationCode);
        if(user == null ||user.getEnabled()){
            return false;
        }else {
            userRepo.enable(user.getId());
            return true;
        }
    }

}
