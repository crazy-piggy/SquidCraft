package io.github.squid233.squidcraft.mixin;

import net.minecraft.entity.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import org.spongepowered.asm.mixin.Mixin;

import static net.minecraft.entity.EntityCategory.*;
import static net.minecraft.entity.EntityType.*;
import static net.minecraft.world.biome.Biome.Category.PLAINS;
import static net.minecraft.world.biome.Biome.Precipitation.RAIN;
import static net.minecraft.world.biome.DefaultBiomeFeatures.*;
import static net.minecraft.world.gen.feature.Feature.*;
import static net.minecraft.world.gen.feature.FeatureConfig.DEFAULT;
import static net.minecraft.world.gen.surfacebuilder.SurfaceBuilder.GRASS_CONFIG;

@Mixin(PlainsBiome.class)
public final class PlainsBiomeMixin extends Biome {
    protected PlainsBiomeMixin() {
        super((new Biome.Settings()).configureSurfaceBuilder(SurfaceBuilder.DEFAULT, GRASS_CONFIG).precipitation(RAIN).category(PLAINS).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.4F).waterColor(4159204).waterFogColor(329011).parent(null));
        this.addStructureFeature(VILLAGE.configure(new VillageFeatureConfig("village/plains/town_centers", 6)));
        this.addStructureFeature(PILLAGER_OUTPOST.configure(DEFAULT));
        this.addStructureFeature(MINESHAFT.configure(new MineshaftFeatureConfig(0.004D, MineshaftFeature.Type.NORMAL)));
        this.addStructureFeature(STRONGHOLD.configure(DEFAULT));
        this.addStructureFeature(END_CITY.configure(DEFAULT));
        adds(this);
        Spawn(CREATURE, SHEEP, 12, 4, 4);
        Spawn(CREATURE, SHEEP, 12, 4, 4);
        Spawn(CREATURE, PIG, 10, 4, 4);
        Spawn(CREATURE, CHICKEN, 10, 4, 4);
        Spawn(CREATURE, COW, 8, 4, 4);
        Spawn(CREATURE, HORSE, 5, 2, 6);
        Spawn(CREATURE, DONKEY, 1, 1, 3);
        Spawn(AMBIENT, BAT, 10, 8, 8);
        Spawn(MONSTER, SPIDER, 100, 4, 4);
        Spawn(MONSTER, ZOMBIE, 95, 4, 4);
        Spawn(MONSTER, ZOMBIE_VILLAGER, 5, 1, 1);
        Spawn(MONSTER, SKELETON, 100, 4, 4);
        Spawn(MONSTER, CREEPER, 100, 4, 4);
        Spawn(MONSTER, SLIME, 100, 4, 4);
        Spawn(MONSTER, ENDERMAN, 10, 1, 4);
        Spawn(MONSTER, WITCH, 5, 1, 1);
    }

    private void adds(Biome b) {
        addLandCarvers(b);addDefaultStructures(b);
        addDefaultLakes(b);addDungeons(b);
        addPlainsTallGrass(b);addMineables(b);
        addDefaultOres(b);addDefaultDisks(b);
        addPlainsFeatures(b);addDefaultMushrooms(b);
        addDefaultVegetation(b);addSprings(b);
        addFrozenTopLayer(b);
    }

    public  void Spawn(EntityCategory e,EntityType et,int w, int min, int max) {
        this.addSpawn(e, new SpawnEntry(et, w, min, max));
    }
}
