package me.petterim1.customentityexample;

import cn.nukkit.entity.Entity;
import cn.nukkit.entity.custom.CustomEntity;
import cn.nukkit.entity.custom.EntityDefinition;
import cn.nukkit.entity.custom.EntityManager;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class MyCustomEntity extends Entity implements CustomEntity {

    public static final String IDENTIFIER = "tut:skele_yaklin"; // From wiki.bedrock.dev tutorial pack

    public MyCustomEntity(FullChunk fullChunk, CompoundTag compoundTag) {
        super(fullChunk, compoundTag);
    }

    @Override
    public EntityDefinition getEntityDefinition() {
        // Remember to register the definition using EntityManager.get().registerDefinition()
        return EntityManager.get().getDefinition(IDENTIFIER);
    }

    @Override
    public String getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public int getNetworkId() {
        // Network IDs for custom entities are generated automatically
        return EntityManager.get().getRuntimeId(IDENTIFIER);
    }
}
