package com.negodya1.vintageimprovements.content.kinetics.coiling;

import com.jozufozu.flywheel.util.transform.TransformStack;
import com.mojang.blaze3d.vertex.PoseStack;
import com.simibubi.create.foundation.blockEntity.behaviour.ValueBoxTransform;
import com.simibubi.create.foundation.utility.VecHelper;

import net.minecraft.core.Direction;
import net.minecraft.world.level.CollisionGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class CoilingFilterSlot extends ValueBoxTransform {

	@Override
	public Vec3 getLocalOffset(BlockState state) {
		int offset = 2;
		if (state.getValue(CoilingBlock.HORIZONTAL_FACING) == Direction.NORTH || state.getValue(CoilingBlock.HORIZONTAL_FACING) == Direction.SOUTH)
			return VecHelper.voxelSpace(8, 14.5f, 8 + (state.getValue(CoilingBlock.HORIZONTAL_FACING) == Direction.NORTH ? offset : -offset));
		return VecHelper.voxelSpace(8 + (state.getValue(CoilingBlock.HORIZONTAL_FACING) == Direction.WEST ? offset : -offset), 14.5f, 8);
	}

	@Override
	public void rotate(BlockState state, PoseStack ms) {
		int yRot = 180;
		TransformStack.cast(ms)
			.rotateY(yRot)
			.rotateX(90);
	}

}
