package th.ac.ku.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import th.ac.ku.restaurant.dto.SignupDto;
import th.ac.ku.restaurant.model.User;
import th.ac.ku.restaurant.service.SignupService;

import javax.validation.Valid;

@Controller
public class SignupController {

    @Autowired
    private SignupService signupService;

    //ไม่ใช้ DTO
//    @GetMapping("/signup")
//    public String getSignupPage() {
//        return "signup"; // return signup.html
//    }

    //ใช้DTO
    @GetMapping("/signup")
    public String getSignupPage(SignupDto user) { //ส่งformให้User
        return "signup"; // return signup.html
    }


    //แบบที่ไม่ใช้ DTO
//    @PostMapping("/signup")
//    public String signupUser(@ModelAttribute User user, Model model) {
//
//        if (signupService.isUsernameAvailable(user.getUsername())) {
//            signupService.createUser(user);
//            model.addAttribute("signupSuccess", true);//ถ้าตรงก็ signup ได้
//        } else {
//            model.addAttribute("signupError", "Username not available");
//        }
//        return "signup";
//    }

    //แบบใช้DTO
    @PostMapping("/signup")
    public String signupUser(@Valid SignupDto user, BindingResult result,
                             Model model) {
        //@Valid - มีการตรวจสอบclassนี้ก่อน (class SignupDto)
        //BindingResult - resultของการทำvalidation
        if (result.hasErrors()) //ดูว่ามีErrorมั้ย
            return "signup";

        if (signupService.isUsernameAvailable(user.getUsername())) {
            signupService.createUser(user);
            model.addAttribute("signupSuccess", true);
        } else {
            model.addAttribute("signupError", "Username not available");
        }
        model.addAttribute("signupDto", new SignupDto());//เพราะมีการส่ง SignupDto
        return "signup";
    }

}
