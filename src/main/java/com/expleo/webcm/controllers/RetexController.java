package com.expleo.webcm.controllers;

import com.expleo.webcm.dao.ProiectDao;
import com.expleo.webcm.dao.ProiectDaoImpl;
import com.expleo.webcm.entity.expleodb.Proiect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/retex")
public class RetexController {
    @Autowired
    private ProiectDao proiectDao;

    @GetMapping
    public String retex(ModelMap model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        List<Proiect> proiectList = proiectDao.findUserIdByEmail(username);
        model.addAttribute("proiectList", proiectList);

        return "retex";
    }
}
