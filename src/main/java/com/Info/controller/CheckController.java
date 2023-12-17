package com.Info.controller;


import com.Info.model.entity.Check;
import com.Info.model.entity.Friends;
import com.Info.model.entity.Peer;
import com.Info.model.entity.Task;
import com.Info.service.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/checks")
public class CheckController {

    private static final Logger log = LoggerFactory.getLogger(CheckController.class);

    @Autowired
    private CommonService<Check, Long> checkCommonService;

    @Autowired
    private CommonService<Peer, Long> peerCommonService;

    @Autowired
    private CommonService<Task, Long> taskCommonService;

    @GetMapping()
    public String checks(Model model) throws SQLException {
        List<Check> checksList = checkCommonService.getAll();
        List<Peer> peersList = peerCommonService.getAll();
        List<Task> tasksList = taskCommonService.getAll();
        model.addAttribute("checks", checksList);
        model.addAttribute("peers", peersList);
        model.addAttribute("tasks", tasksList);
        return "checks";
    }

    @GetMapping("/import")
    public String importS(Model model) {
        System.out.println("import import import import");
        return "checks";
    }

    @PostMapping("/add")
    public String addCheck(@RequestParam("peerId") Long peerId,
                           @RequestParam("taskId") Long taskId,
                           @RequestParam("date") LocalDate date
    ) {

        Peer peer = peerCommonService.findById(peerId);
        Task task = taskCommonService.findById(taskId);
        Check check = new Check();
        check.setPeer(peer);
        check.setTask(task);
        check.setDate(date);
        checkCommonService.add(check);
        return "redirect:/checks";
    }


    @PostMapping("/update")
    public String update(
            @RequestParam("id") Long id,
            @RequestParam("peerId") Long peerId,
            @RequestParam("taskId") Long taskId,
            @RequestParam("date") LocalDate date
    ) {
        Check existingCheck = checkCommonService.findById(id);
        if (existingCheck != null) {
            Peer peer = peerCommonService.findById(peerId);
            Task task = taskCommonService.findById(taskId);
            existingCheck.setPeer(peer);
            existingCheck.setTask(task);
            existingCheck.setDate(date);
            checkCommonService.add(existingCheck);
        } else {
            System.out.println("update not executed");
        }

        return "redirect:/checks";
    }

    @PostMapping("/delete")
    public String delete(
            @RequestParam("id") Long id
    ) {
        checkCommonService.deleteById(id);
        return "redirect:/checks";
    }
}