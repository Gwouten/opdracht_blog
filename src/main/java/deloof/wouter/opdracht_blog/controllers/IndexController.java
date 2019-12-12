package deloof.wouter.opdracht_blog.controllers;

import deloof.wouter.opdracht_blog.model.Blogpost;
import deloof.wouter.opdracht_blog.model.BlogpostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.xml.ws.BindingProvider;

@Controller
public class IndexController {

    @Autowired
    BlogpostDAO dao;

    @ModelAttribute("posts")
    public Iterable<Blogpost> getAllPosts() {
        return dao.findChronological();
    };

    @ModelAttribute("newPost")
    public Blogpost saveBlogpost() {
        return new Blogpost();
    }

    @RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.GET)
    public String showAllPosts(ModelMap map) {
        return "index";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String savePost(@ModelAttribute("newPost") @Valid Blogpost post, BindingResult br) {
        if(br.hasErrors()){
            return "index";
        }
        dao.save(post);
        return "redirect:/index";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletePost(@PathVariable(name = "id") int id) {
        dao.deleteById(id);
        return "redirect:/index";
    }
}
