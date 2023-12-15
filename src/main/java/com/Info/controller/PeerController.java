package com.Info.controller;

import com.Info.model.entity.Peer;
import com.Info.service.CommonService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static java.lang.constant.ConstantDescs.NULL;

@Controller
@RequestMapping("/peers")
public class PeerController {

    private static final Logger log = LoggerFactory.getLogger(PeerController.class);

    @Autowired
    private CommonService<Peer, Long> commonService;

    @GetMapping()
    public String peers(Model model) throws SQLException {
        log.info("Accessing peers page");
        List<Peer> peerList = commonService.getAll();
        System.out.println(peerList.toString());
        model.addAttribute("peers", peerList);
        return "peers";
    }

    @GetMapping("/import")
    public String importS(Model model) {
        log.info("Accessing add peer form");
        System.out.println("import import import import");
        return "peers";
    }

    @PostMapping("/add")
    public String addPeer(@RequestParam("newNickname") String newNickname,
                          @RequestParam("newBirthday") LocalDate newBirthday) {
        Peer peer = new Peer();
        peer.setBirthday(newBirthday);
        peer.setNickname(newNickname);
        commonService.add(peer);
        System.out.println("newNickname=" + newNickname + " newBirthday=" + newBirthday);
        return "redirect:/peers";
    }

//    @PostMapping()
//    public String create(@ModelAttribute("peers") @Valid Peer peer, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        if (bindingResult.hasErrors()) {
//            redirectAttributes.addFlashAttribute("error", NULL);
//            log.error("Error while creating peer: {}", bindingResult.getAllErrors());
//        } else {
//            commonService.add(peer);
//            redirectAttributes.addFlashAttribute("success", NULL);
//            log.info("Created a new peer with nickname {}", peer.getNickname());
//        }
//        return "redirect:/peers";
//    }


    @PostMapping("/update")
    public String update(
            @RequestParam("id") Long id,
            @RequestParam("updatedNickname") String newNickname,
            @RequestParam("updatedBirthday") LocalDate newBirthday
    ) {
        Peer existingPeer = commonService.findById(id);
        if (existingPeer != null) {
            existingPeer.setNickname(newNickname);
            existingPeer.setBirthday(newBirthday);
            commonService.add(existingPeer);
        } else {
            System.out.println("update not executed");
        }
        return "redirect:/peers";
    }

    @PostMapping("/delete")
    public String delete(
            @RequestParam("id") Long id
    ) {
        Peer existingPeer = commonService.findById(id);
        if (existingPeer != null) {
            commonService.deleteById(id);
        } else {
            System.out.println("delete not executed");
        }
        return "redirect:/peers";
    }
}