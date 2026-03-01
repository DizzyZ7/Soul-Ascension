package com.dizzy.soulrpg.capability;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.dizzy.soulrpg.SoulRPG;

public class SoulProvider implements ICapabilitySerializable<CompoundTag> {

    public static Capability<ISoulData> SOUL =
            CapabilityManager.get(new CapabilityToken<>() {});

    private final SoulData backend = new SoulData();
    private final LazyOptional<ISoulData> optional = LazyOptional.of(() -> backend);

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(
            @NotNull Capability<T> cap,
            @Nullable Direction side) {
        return cap == SOUL ? optional.cast() : LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putInt("soul", backend.getSoul());
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        backend.setSoul(nbt.getInt("soul"));
    }
}
