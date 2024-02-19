package com.negodya1.vintageimprovements.infrastructure.config;

import com.simibubi.create.content.contraptions.ContraptionData;
import com.simibubi.create.content.contraptions.ContraptionMovementSetting;
import com.simibubi.create.foundation.config.ConfigBase;
import com.simibubi.create.infrastructure.config.CKinetics;

public class VCKinetics extends ConfigBase {
	public final VCStress stressValues = nested(1, VCStress::new, Comments.stress);

	@Override
	public String getName() {
		return "kinetics";
	}

	private static class Comments {
		static String stress = "Fine tune the kinetic stats of individual components";
	}

}
