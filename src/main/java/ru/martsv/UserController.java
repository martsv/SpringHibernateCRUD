package ru.martsv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.martsv.model.User;
import ru.martsv.service.UserService;

/**
 * Created by mart on 17.05.16.
 */
@Controller
public class UserController {
    private UserService userService;

    @Autowired(required=true)
    @Qualifier(value="userService")
    public void setUserService(UserService us){
        this.userService = us;
    }

    /*@RequestMapping(value = "/users", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.findAllUsers());
        return "user";
    }*/

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String listUsers(Model model,
                            @RequestParam(value = "offset", defaultValue = "0") Integer offset,
                            @RequestParam(value = "maxResults", defaultValue = "5") Integer maxResults,
                            @RequestParam(value = "search", defaultValue = "") String search) {
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.findPartUsers(offset, maxResults, search));
        model.addAttribute("count", userService.count(search));
        model.addAttribute("offset", offset);
        model.addAttribute("search", search);
        return "user";
    }

    //For add and update person both
    @RequestMapping(value= "/user/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user,
                          @RequestParam(value = "offset", defaultValue = "0") Integer offset) {
        if(user.getId() == 0){
            //new user, add it
            this.userService.addUser(user);
        }else{
            //existing user, call update
            this.userService.updateUser(user);
        }
        return "redirect:/users?offset=" + offset;
    }

    @RequestMapping(value= "/search", method = RequestMethod.POST)
    public String searchUser(@RequestParam(value = "userName", defaultValue = "") String userName) {
        if (userName != null && !"".equals(userName))
            return "redirect:/users?search=" + userName;
        else
            return "redirect:/users";
    }

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id,
                             @RequestParam(value = "offset", defaultValue = "0") Integer offset) {
        this.userService.deleteUser(id);
        int shift = (userService.count() > offset? offset : offset - 5);
        return "redirect:/users" + ((shift <= 0)? "": "?offset=" + shift);
    }

    @RequestMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model,
                           @RequestParam(value = "offset", defaultValue = "0") Integer offset,
                           @RequestParam(value = "maxResults", defaultValue = "5") Integer maxResults) {
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUsers", this.userService.findPartUsers(offset, maxResults, ""));
        model.addAttribute("count", userService.count());
        model.addAttribute("offset", offset);
        return "user";
    }
}
