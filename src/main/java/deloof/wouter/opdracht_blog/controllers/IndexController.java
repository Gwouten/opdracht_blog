package deloof.wouter.opdracht_blog.controllers;

import deloof.wouter.opdracht_blog.model.Blogpost;
import deloof.wouter.opdracht_blog.model.BlogpostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @Autowired
    BlogpostDAO dao;

    @ModelAttribute("posts")
    public Iterable<Blogpost> getAllPosts() {
        return dao.findAll();
    };

    @RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.GET)
    public String showAllPosts(ModelMap map) {
        return "index";
    }
}
