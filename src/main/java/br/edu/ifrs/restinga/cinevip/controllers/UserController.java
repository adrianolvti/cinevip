package br.edu.ifrs.restinga.cinevip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.ifrs.restinga.cinevip.models.User;

@Controller
@ResponseBody
public class UserController {
  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public User getUser() {
    final User user = new User();
    user.setId(1);
    user.setCpf("02213408076");
    user.setName("Adriano");
    user.setPassword("C@1234");
    return user;
  }

  @RequestMapping(value ="/user", method = RequestMethod.POST)
  public String setUser(@RequestBody User user) {
    return "Id: " + user.getId() + "\n" 
      +"CPF: " + user.getCpf() + "\n" 
      +"Nome: " + user.getName() + "\n"
      +"Password: " + user.getPassword() + "\n";
  }
}
