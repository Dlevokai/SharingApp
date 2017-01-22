package app.bootstrap;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import app.domain.Player;
import app.repositories.PlayerRepository;
 
@Component
public class PlayerLoader implements ApplicationListener<ContextRefreshedEvent> {
 
    private PlayerRepository playerRepository;
 
    private Logger log = Logger.getLogger(PlayerLoader.class);
 
    @Autowired
    public void setPlayerRepository(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
 
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
 
        Player playerOne = new Player();
        playerOne.setName("Bob The Builder");
        playerOne.setQuantityContributed(new BigDecimal(2000));
        playerOne.setPercentContributed(new BigDecimal(15));
        playerRepository.save(playerOne);
 
        log.info("Saved A Player1" + playerOne.getName());
        
        Player playerTwo = new Player();
        playerTwo.setName("Jimmy the Rascal");
        playerTwo.setQuantityContributed(new BigDecimal(14.23));
        playerTwo.setPercentContributed(new BigDecimal(87));
        playerRepository.save(playerTwo);
 
        log.info("Saved A Player2" + playerTwo.getName());
 
    }
}