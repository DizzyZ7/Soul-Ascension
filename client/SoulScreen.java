package com.dizzy.soulrpg.client;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class SoulScreen extends Screen {

    protected SoulScreen() {
        super(Component.literal("Soul RPG"));
    }

    @Override
    protected void init() {
    }

    @Override
    public void render(net.minecraft.client.gui.GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(graphics);
        graphics.drawCenteredString(
                this.font,
                "Soul Level: " + ClientSoulData.get(),
                this.width / 2,
                this.height / 2,
                0xFFFFFF
        );
        super.render(graphics, mouseX, mouseY, partialTick);
    }
}
