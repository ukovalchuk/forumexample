package com.example.controller;

import com.example.dao.CommentDAO;
import com.example.dao.TopicDAO;
import com.example.dao.UserDAO;
import com.example.entity.CommentEntity;
import com.example.entity.TopicEntity;
import com.example.entity.UserEntity;
import com.example.service.RegisterService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    private UserDAO userDAO;
    private TopicDAO topicDAO;
    private CommentDAO commentDAO;
    private RegisterService registerService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admim";
    }

    @RequestMapping(value = "/edit_user", method = RequestMethod.GET)
    public String edit_user(@RequestParam(value = "id") Integer userId, Model model) {

        UserEntity user = userDAO.findUser(userId);
        model.addAttribute("id",user);
        return "edit_user{id}";
    }

    @RequestMapping(value = "/edit_user", method = RequestMethod.POST)
    public String edit_user(@RequestParam(value = "name") String name, @RequestParam(value = "email") String email,
                            @RequestParam(value = "role_id") Integer roleId, UserEntity user, Model model) {

        UserEntity userEntity=userDAO.editUser(user);

        return "edit_user";
    }


    @RequestMapping(value = "/edit_topic", method = RequestMethod.GET)// get  ?topic_id=1
    public String edit_topic(@PathVariable Integer id, Model model ) {

        TopicEntity topicEntity = topicDAO.findTopic(id);
        model.addAttribute("id",topicEntity);
        return "edit_topic{id}";
    }

    @RequestMapping(value = "/edit_topic", method = RequestMethod.POST)// get  ?topic_id=1
    public String edit_topic(@RequestParam(value = "text", required = true) String text, TopicEntity topic,  Model model ) {

        TopicEntity topicEntity = topicDAO.editTopic(topic);

//        model.addAttribute("topicT",topicEntity);
        return "edit_topic";
    }


    @RequestMapping(value = "/edit_comment", method = RequestMethod.GET) //   /edit_comment?id=2&text=eeee&text2=9999
    public ModelAndView edit_comment(@RequestParam(value = "id", required = true) Integer commentId) {
        ModelAndView mov = new ModelAndView("edit_comment");

        CommentEntity commentEntity = commentDAO.findCommentById(commentId);
        mov.addObject("comment", commentEntity);
        return mov;
    }


    @RequestMapping(value = "/edit_comment", method = RequestMethod.POST) //   /edit_commit
    public String edit_comment(@RequestParam (value = "text")String text,TopicEntity topic, Model model){

        CommentEntity commentEntity=commentDAO.createComment(topic);
        // todo dao edit comment
        model.addAttribute("text",commentEntity);

        //  from Topic page by click edit button for comment -  show edit form
        return "/edit_topic";
    }


    public CommentDAO getCommentDAO() {
        return commentDAO;
    }

    public void setCommentDAO(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public TopicDAO getTopicDAO() {
        return topicDAO;
    }

    public void setTopicDAO(TopicDAO topicDAO) {
        this.topicDAO = topicDAO;
    }
}
