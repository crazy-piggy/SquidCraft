package io.github.squid233.squidcraft.mixin;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BuiltinBiomes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/**
 * @author squid233
 */
@Mixin(BuiltinBiomes.class)
public interface BuiltinBiomesAccessor {
    @Accessor("BY_RAW_ID")
    static Int2ObjectMap<RegistryKey<Biome>> getRawIdMap() {
        throw new AssertionError();
    }
}
