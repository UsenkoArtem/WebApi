package WebApi.controller;

import WebApi.dao.UserDAO;
import WebApi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by usenk on 02.05.2017.
 */
@Controller
public class IndexController {
    @Autowired
  private UserDAO userDAO;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index (ModelMap map) {
        List<User> byId = userDAO.findById(1);
        map.put("userAll",byId);
        return "index";
    }
}
