package com.negodya1.vintageimprovements.content.kinetics.helve_hammer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import com.negodya1.vintageimprovements.VintagePartialModels;
import com.simibubi.create.content.kinetics.base.KineticBlockEntityRenderer;
import com.simibubi.create.foundation.blockEntity.renderer.SmartBlockEntityRenderer;
import com.simibubi.create.foundation.render.CachedBufferer;
import com.simibubi.create.foundation.render.SuperByteBuffer;
import com.simibubi.create.foundation.utility.AngleHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

import static net.minecraft.world.level.block.DirectionalBlock.FACING;
import static net.minecraft.world.level.block.state.properties.BlockStateProperties.HORIZONTAL_FACING;

public class HelveItemsRenderer extends SmartBlockEntityRenderer<HelveBlockEntity> {

	public HelveItemsRenderer(BlockEntityRendererProvider.Context context) {
		super(context);
	}

	@Override
	public boolean shouldRenderOffScreen(HelveBlockEntity be) {
		return true;
	}

	@Override
	protected void renderSafe(HelveBlockEntity be, float partialTicks, PoseStack ms, MultiBufferSource buffer,
		int light, int overlay) {

		renderItems(be, ms, buffer, light, overlay);
	}

	protected void renderItems(HelveBlockEntity be, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
		boolean input = !be.inputInv.getStackInSlot(0).isEmpty();
		boolean output = !be.outputInv.getStackInSlot(0).isEmpty();

		if (!input && !output) return;

		int j = 0;

		if (input) {
			for (int i = 0; i < be.inputInv.getSlots(); i++) {
				ItemStack stack = be.inputInv.getStackInSlot(i);
				if (stack.isEmpty())
					continue;

				ms.pushPose();

				ItemRenderer itemRenderer = Minecraft.getInstance()
						.getItemRenderer();

				ms.translate(.5, 0, .5);

				ms.mulPose(Vector3f.YP.rotationDegrees(j * 60));
				ms.translate(-.20, 0, 0);

				ms.scale(.33f, .33f, .33f);
				ms.mulPose(Vector3f.XP.rotationDegrees(90));
				itemRenderer.renderStatic(stack, ItemTransforms.TransformType.FIXED, light, overlay, ms, buffer, 0);
				j++;

				ms.popPose();
			}
		}

		if (output) {
			for (int i = 0; i < be.outputInv.getSlots(); i++) {
				ItemStack stack = be.outputInv.getStackInSlot(i);
				if (stack.isEmpty())
					continue;

				ms.pushPose();

				ItemRenderer itemRenderer = Minecraft.getInstance()
						.getItemRenderer();

				ms.translate(.5, 0, .5);

				ms.mulPose(Vector3f.YP.rotationDegrees(j * 60));
				ms.translate(-.35, 0, 0);

				ms.scale(.33f, .33f, .33f);
				ms.mulPose(Vector3f.XP.rotationDegrees(90));
				itemRenderer.renderStatic(stack, ItemTransforms.TransformType.FIXED, light, overlay, ms, buffer, 0);
				j++;

				ms.popPose();
			}
		}
	}

}
