package me.petterim1.customentityexample;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.entity.Entity;
import cn.nukkit.entity.custom.EntityDefinition;
import cn.nukkit.entity.custom.EntityManager;
import cn.nukkit.plugin.PluginBase;

public class Main extends PluginBase {

    @Override
    public void onEnable() {
        // Register the custom entity
        // identifier and implementation are required, alternateName, parentEntity and spawnEgg are optional
        EntityManager.get().registerDefinition(EntityDefinition.builder().identifier(MyCustomEntity.IDENTIFIER).implementation(MyCustomEntity.class).build());
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        // Test command to spawn the custom entity to player's location
        if (commandSender instanceof Player && command.getName().equals("test")) {
            Entity entity = Entity.createEntity(MyCustomEntity.IDENTIFIER, (Player) commandSender);
            if (entity == null) {
                commandSender.sendMessage("Failed to create entity");
            } else {
                entity.spawnToAll();
                commandSender.sendMessage("Entity created");
            }
        }
        return true;
    }
}
