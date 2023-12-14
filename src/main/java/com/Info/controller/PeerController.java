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
//        model.addAttribute("peer", new Peer());
        model.addAttribute("peers", peerList);
        return "peers";
    }

    @GetMapping("/import")
    public String importS(Model model) {
        log.info("Accessing add peer form");
        System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
//        model.addAttribute("peers", new Peer());
        return "peers";
    }

//    @GetMapping("/add")
//    public String addPeerForm(Model model) {
//        log.info("Accessing add peer form");
//        model.addAttribute("peers", new Peer());
//        return "peers/add";
//    }

    @PostMapping("/add")
    public String addPeer(
            @RequestParam("newNickname") String newNickname,
            @RequestParam("newBirthday") LocalDate newBirthday
    ) {

        Peer peer = new Peer();
        peer.setBirthday(newBirthday);
        peer.setNickname(newNickname);
        commonService.add(peer);
        System.out.println("newNickname=" + newNickname + " newBirthday=" + newBirthday);
        return "redirect:/peers";
    }

    @PostMapping()
    public String create(@ModelAttribute("peers") @Valid Peer peer, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", NULL);
            log.error("Error while creating peer: {}", bindingResult.getAllErrors());
        } else {
            commonService.add(peer);
            redirectAttributes.addFlashAttribute("success", NULL);
            log.info("Created a new peer with nickname {}", peer.getNickname());
        }
        return "redirect:/peers";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        commonService.deleteById(id);
        log.info("Deleted peer with nickname {}", id);
        return "redirect:/peers";
    }

    @PostMapping("/update/{id}")
    public String updatePeer(@PathVariable Long id, Model model) {
        model.addAttribute("peer", commonService.findById(id));
        System.out.println("idididididid"+id);
        log.info("Accessing update peer form for peer with nickname {}", id);
        return "peers";
    }
//    @PostMapping("/update/{id}")
//    public String updatePeer(@PathVariable String id, Model model) {
//        model.addAttribute("peer", commonService.findById(id));
//        log.info("Accessing update peer form for peer with nickname {}", id);
//        return "peers/update";
//    }
//
//    @PostMapping("/update")
//    public String update(@ModelAttribute("peers") Peers updatedPeer) {
//        commonService.add(updatedPeer);
//        log.info("Updated peer with nickname {}", updatedPeer.getNickname());
//        return "redirect:/peers";
//    }
    @PostMapping("/update")
    public String update(@ModelAttribute("peer") Peer updatedPeer,@PathVariable Long id, Model model) {
//        model.addAttribute("peer", new Peer());
        // Получите существующий объект Peer из базы данных по его идентификатору
        Peer existingPeer = commonService.findById(updatedPeer.getId());

        if (existingPeer != null) {
            // Обновите существующий объект с новыми данными
            existingPeer.setNickname(updatedPeer.getNickname());
            existingPeer.setBirthday(updatedPeer.getBirthday());

            // Сохраните обновленный объект в базе данных
            commonService .add(existingPeer);
            commonService .save(existingPeer);
            System.out.println("AAAAAAAAAAAAAAAAAAAAAABBB"+existingPeer);
            log.info("Updated peer with nickname {}", existingPeer.getNickname());
        }else {
            System.out.println("AAAAAAAAAAAAAAAAAAAAAA");
        }

//        commonService.add(peer);
        return "peers";
    }
}