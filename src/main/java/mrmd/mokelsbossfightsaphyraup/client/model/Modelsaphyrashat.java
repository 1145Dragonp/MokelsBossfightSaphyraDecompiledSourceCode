package mrmd.mokelsbossfightsaphyraup.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class Modelsaphyrashat<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("mokels_bossfight_saphyra", "modelsaphyrashat"), "main");
   public final ModelPart masterbody;

   public Modelsaphyrashat(ModelPart root) {
      this.masterbody = root.getChild("masterbody");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition masterbody = partdefinition.addOrReplaceChild("masterbody", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
      PartDefinition hat = masterbody.addOrReplaceChild(
         "hat",
         CubeListBuilder.create()
            .texOffs(0, 37)
            .addBox(-4.0F, -6.3F, -4.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(0.8F))
            .texOffs(0, 0)
            .addBox(-8.0F, -1.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.8F)),
         PartPose.offsetAndRotation(0.0F, -4.0F, -1.0F, -0.5411F, 0.0F, 0.0F)
      );
      PartDefinition hat2 = hat.addOrReplaceChild(
         "hat2",
         CubeListBuilder.create().texOffs(32, 17).addBox(-3.0F, -5.0F, -3.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.8F)),
         PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, -0.6109F, 0.0F, 0.0F)
      );
      PartDefinition hat3 = hat2.addOrReplaceChild(
         "hat3",
         CubeListBuilder.create().texOffs(8, 66).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.8F)),
         PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.6109F, 0.0F, 0.0F)
      );
      PartDefinition hat4 = hat3.addOrReplaceChild(
         "hat4",
         CubeListBuilder.create().texOffs(0, 17).addBox(-2.0F, -2.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.6F)),
         PartPose.offset(1.0F, -7.0F, -1.0F)
      );
      return LayerDefinition.create(meshdefinition, 128, 128);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.masterbody.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }
}
