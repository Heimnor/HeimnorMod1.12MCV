package com.heimnor.models;

import net.minecraft.client.model.ModelRenderer;

public class ModelPain extends ModelBaseH
{
    ModelRenderer Block;
    ModelRenderer Block1;

    public ModelPain()
    {
        this( 0.0f );
    }

    public ModelPain( float par1 )
    {
        Block = new ModelRenderer( this, 0, 0 );
        Block.setTextureSize( 64, 64 );
        Block.addBox( -3F, -2F, -8F, 6, 4, 16);
        Block.setRotationPoint( 0F, -7F, 0F );
        Block1 = new ModelRenderer( this, 0, 20 );
        Block1.setTextureSize( 64, 64 );
        Block1.addBox( -4F, -2F, -8F, 8, 4, 16);
        Block1.setRotationPoint( 0F, -11F, 0F );
    }

   public void renderAll()
   {
        Block.rotateAngleX = 0F;
        Block.rotateAngleY = 0F;
        Block.rotateAngleZ = 0F;
        Block.renderWithRotation(0.0625F);

        Block1.rotateAngleX = 0F;
        Block1.rotateAngleY = 0F;
        Block1.rotateAngleZ = 0F;
        Block1.renderWithRotation(0.0625F);

    }

}
