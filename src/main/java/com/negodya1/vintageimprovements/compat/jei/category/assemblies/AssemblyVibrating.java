package com.negodya1.vintageimprovements.compat.jei.category.assemblies;

import com.mojang.blaze3d.vertex.PoseStack;
import com.negodya1.vintageimprovements.compat.jei.category.animations.AnimatedCoiling;
import com.negodya1.vintageimprovements.compat.jei.category.animations.AnimatedVibratingTable;
import com.simibubi.create.compat.jei.category.sequencedAssembly.SequencedAssemblySubCategory;
import com.simibubi.create.content.processing.sequenced.SequencedRecipe;

public class AssemblyVibrating extends SequencedAssemblySubCategory {

    AnimatedVibratingTable table;

    public AssemblyVibrating() {
        super(25);
        table = new AnimatedVibratingTable();
    }

    @Override
    public void draw(SequencedRecipe<?> recipe, PoseStack graphics, double mouseX, double mouseY, int index) {
        graphics.pushPose();
        graphics.translate(0, 51.5f, 0);
        graphics.scale(.6f, .6f, .6f);
        table.draw(graphics, getWidth() / 2, 30);
        graphics.popPose();
    }

}
