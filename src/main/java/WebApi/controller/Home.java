package WebApi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by usenk on 03.05.2017.
 */
@Controller
@RequestMapping("home")
public class Home {
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String gomeGet() {
        return "Hello this this is get";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String gomePost() {
        return "Hello this this  is Post";
    }
}
