package petterim1.customentityexample;

import cn.nukkit.entity.Entity;
import cn.nukkit.entity.custom.CustomEntity;
import cn.nukkit.entity.custom.EntityDefinition;
import cn.nukkit.entity.custom.EntityManager;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

// You can also extend other existing entity behavior
// Just remember to implement CustomEntity
public class MyCustomEntity extends Entity implements CustomEntity {

    // From wiki.bedrock.dev tutorial
    public static final String IDENTIFIER = "tut:skele_yaklin";

    // identifier and implementation are required, alternateName, parentEntity and spawnEgg are optional
    // Remember to register the definition using EntityManager.get().registerDefinition() on startup
    public static final EntityDefinition DEFINITION =
            EntityDefinition.builder().identifier(MyCustomEntity.IDENTIFIER).implementation(MyCustomEntity.class).build();

    public MyCustomEntity(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public EntityDefinition getEntityDefinition() {
        return DEFINITION;
    }

    @Override
    public int getNetworkId() {
        // Network IDs for custom entities are generated automatically
        return EntityManager.get().getRuntimeId(IDENTIFIER);
    }
}
