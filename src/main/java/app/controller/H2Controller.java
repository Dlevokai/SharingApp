package app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import app.model.PlayerList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.domain.Player;
import app.model.Greeting;
import app.repositories.PlayerRepository;

@RestController
public class H2Controller {

    @Autowired
    private PlayerRepository playerRepository;

    @RequestMapping("/getH2Data")
    public Player getDataFromH2(@RequestParam(value = "name", defaultValue = "World") String name) {
        return playerRepository.findOne(1);
    }

    @RequestMapping("/getPlayerList")
    public PlayerList getPlayerList() {
        Iterable<Player> playersIterator = playerRepository.findAll();
        List<Player> tempPlayersList = new ArrayList<Player>();
        for (Player player : playersIterator){
            tempPlayersList.add(player);
        }
        PlayerList jsonPlayerList = new PlayerList();
        jsonPlayerList.setPlayerList(tempPlayersList);
        return jsonPlayerList;
    }
}