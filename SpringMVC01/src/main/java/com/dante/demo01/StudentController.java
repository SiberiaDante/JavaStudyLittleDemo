package com.dante.demo01;

import com.dante.demo02.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {

    @InitBinder
    public void InitBinder(DataBinder binder) {
        System.out.println("---------StudentValidator------------");
        binder.setValidator(new StudentValidator());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/student1")
    public String student(ModelMap modelMap) {
        Student student = new Student();
        student.setFavoriteFrameworks(new String[]{"Spring MVC", "Struts 2"});
        modelMap.addAttribute("student",student);
        return "demo01/student";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/student")
    public ModelAndView student() {
        Student student = new Student();
        student.setFavoriteFrameworks(new String[]{"Spring MVC", "Struts 2"});
        return new ModelAndView("demo01/student", "command", student);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addStudent")
    public String addStudent(@Validated Student student, ModelMap modelMap, Errors errors) {
        if (errors.hasErrors()) {
            System.out.println("--------------------------------hasErrors---------------------");
            return "demo01/student";
        } else {
            System.out.println("--------------------------------no error---------------------");
        }
        modelMap.addAttribute("name", student.getName());
        modelMap.addAttribute("age", student.getAge());
        modelMap.addAttribute("id", student.getId());
        modelMap.addAttribute("password", student.getPassword());
        modelMap.addAttribute("address", student.getAddress());
        modelMap.addAttribute("receivePaper", student.isReceivePaper());
        modelMap.addAttribute("favoriteFrameworks", student.getFavoriteFrameworks());
        modelMap.addAttribute("gender", student.getGender());
        modelMap.addAttribute("numbers", student.getNumbers());
        modelMap.addAttribute("country", student.getCountry());
        modelMap.addAttribute("skills", student.getSkills());
        return "demo01/result";
    }

    @ModelAttribute("webFrameworkList")
    public List<String> getWebFrameworkList() {
        List<String> webFrameworkList = new ArrayList<String>();
        webFrameworkList.add("Spring MVC");
        webFrameworkList.add("Spring Boot");
        webFrameworkList.add("Struts 2");
        webFrameworkList.add("Apache Hadoop");
        return webFrameworkList;
    }

    @ModelAttribute("numberList")
    public List<String> getNumbersList() {
        List<String> numbersList = new ArrayList<String>();
        numbersList.add("1");
        numbersList.add("2");
        numbersList.add("3");
        numbersList.add("4");
        return numbersList;
    }

    @ModelAttribute("countryList")
    public Map<String, String> getCountryList() {
        Map<String, String> countryList = new HashMap<String, String>();
        countryList.put("US", "United States");
        countryList.put("CH", "China");
        countryList.put("SG", "Singapore");
        countryList.put("MY", "Malaysia");
        return countryList;
    }

    @ModelAttribute("skillsList")
    public Map<String, String> getSkillsList() {
        Map<String, String> skillList = new HashMap<String, String>();
        skillList.put("Hibernate", "Hibernate");
        skillList.put("Spring", "Spring");
        skillList.put("Apache Hadoop", "Apache Hadoop");
        skillList.put("Struts", "Struts");
        return skillList;
    }
}
