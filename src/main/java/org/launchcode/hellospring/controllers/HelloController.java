package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring";
    }

//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name) {
//        return "Hello1, " + name + "!";
//    }
//
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello2, " + name + "!";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name.equals("")) {
            name = "World";
        }

        return createMessage(name, language);
    }

    public static String createMessage(String n, String l) {
        String greeting = "";

        if (l.equals("english")) {
            greeting = "Hello, ";
        }
        else if (l.equals("french")) {
            greeting = "Bonjour, ";
        }
        else if (l.equals("russian")) {
            greeting = "здравствуйте, ";
        }
        else if (l.equals("spanish")) {
            greeting = "Hola, ";
        }
        else if (l.equals("chinese")) {
            greeting = "你好, ";
        }

        return greeting + " " + n + "!";
    }


    @GetMapping("form")
    public String helloForm(){
        String html =
                "<html>" +
                    "<body>" +
                        "<form method = 'post' action = '/hello'>" +
                            "<input type = 'text' name = 'name' />" +
                            "<select name = 'language' id ='language'>" +
                            "<option name = 'language' value = 'english'>English</option>" +
                            "<option name = 'language' value = 'french'>French</option>" +
                            "<option name = 'language' value= 'russian'>Russian</option>" +
                            "<option name = 'language' value= 'spanish'>Spanish</option>" +
                            "<option name = 'language' value= 'chinese'>Chinese</option>" +
                            "</select>" +
                            "<input type = 'submit' value = 'Greet Me!' />" +
                        "</form>" +
                    "</body>" +
                "</html>";
        return html;
    }


}
