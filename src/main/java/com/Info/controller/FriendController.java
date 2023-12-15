package com.Info.controller;

import com.Info.model.entity.Check;
import com.Info.model.entity.Friends;
import com.Info.model.entity.Peer;
import com.Info.service.CommonService;
import com.Info.service.FriendService;
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
@RequestMapping("/friends")
public class FriendController {

    private static final Logger log = LoggerFactory.getLogger(CheckController.class);

    @Autowired
    private CommonService<Friends, Long> friendsCommonService;

    @Autowired
    private CommonService<Peer, Long> peerCommonService;

    @GetMapping()
    public String friends(Model model) throws SQLException {
        List<Friends> listFriends = friendsCommonService.getAll();
        List<Peer> listPeers = peerCommonService.getAll();
        System.out.println(listFriends.toString());
        model.addAttribute("friends", listFriends);
        model.addAttribute("peers", listPeers);
        return "friends";
    }

    @GetMapping("/import")
    public String importS(Model model) {
        System.out.println("import import import import");
        return "friends";
    }

    @PostMapping("/add")
    public String addCheck(@RequestParam("newPeer1Id") Long id1,
                           @RequestParam("newPeer2Id") Long id2) {
        System.out.println("============================ id1=" + id1 + " id2=" + id2);

        Peer peer1 = peerCommonService.findById(id1);
        Peer peer2 = peerCommonService.findById(id2);
        Friends friends = new Friends();
        friends.setPeer1(peer1);
        friends.setPeer2(peer2);
        friendsCommonService.save(friends);
        return "redirect:/friends";
    }


    @PostMapping("/update")
    public String update(
            @RequestParam("id") Long id,
            @RequestParam("peerId1") Long updatedId1,
            @RequestParam("peerId2") Long updatedId2
    ) {
        Friends existingFriends = friendsCommonService.findById(id);
        if (existingFriends != null) {
            existingFriends.setPeer1(peerCommonService.findById(updatedId1));
            existingFriends.setPeer2(peerCommonService.findById(updatedId2));
            friendsCommonService.add(existingFriends);
        } else {
            System.out.println("update not executed");
        }

        return "redirect:/friends";
    }

    @PostMapping("/delete")
    public String delete(
            @RequestParam("id") Long id
    ) {
        Friends existingFriend = friendsCommonService.findById(id);
        if (existingFriend != null) {
            friendsCommonService.deleteById(id);
        } else {
            System.out.println("delete not executed");
        }
        return "redirect:/friends";
    }
}