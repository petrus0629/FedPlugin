package org.example.kot.fed;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Main implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String string, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;

            if(command.getName().equalsIgnoreCase("중앙은행")){
                if(args[0].equalsIgnoreCase("발행")){
                    player.sendMessage("중앙은행에서 화폐를 발행합니다.");
                }
            }
        }



        return true;
    }
}
