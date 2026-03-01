package com.dizzy.soulrpg;

import com.dizzy.soulrpg.network.ModMessages;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SoulRPG.MOD_ID)
public class SoulRPG {
    public static final String MOD_ID = "soulrpg";

    public SoulRPG() {
        ModMessages.register();
    }
}
