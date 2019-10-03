package com.heimnor.models;

import net.minecraft.client.model.ModelRenderer;

public class ModelBalais extends ModelBaseH
{
    ModelRenderer Block;
    ModelRenderer Block1;
    ModelRenderer Block3;
    ModelRenderer Block4;
    ModelRenderer Block5;
    ModelRenderer Block2;

    public ModelBalais()
    {
        this( 0.0f );
    }

    public ModelBalais( float par1 )
    {
        Block = new ModelRenderer( this, 0, 0 );
        Block.setTextureSize( 64, 64 );
        Block.addBox( -1F, -20F, -1F, 2, 40, 2);
        Block.setRotationPoint( 0F, -8F, 0F );
        Block1 = new ModelRenderer( this, 8, 0 );
        Block1.setTextureSize( 64, 64 );
        Block1.addBox( -2F, -4F, -2F, 4, 8, 4);
        Block1.setRotationPoint( 0F, 16F, 0F );
        Block3 = new ModelRenderer( this, 9, -5 );
        Block3.setTextureSize( 64, 64 );
        Block3.addBox( -0.5F, -9F, -9F, 1, 18, 18);
        Block3.setRotationPoint( 5F, 28F, 0F );
        Block4 = new ModelRenderer( this, 8, 12 );
        Block4.setTextureSize( 64, 64 );
        Block4.addBox( -9F, -9F, -0.5F, 18, 18, 1);
        Block4.setRotationPoint( 0F, 28F, 5F );
        Block5 = new ModelRenderer( this, 8, 31 );
        Block5.setTextureSize( 64, 64 );
        Block5.addBox( -9F, -9F, -0.5F, 18, 18, 1);
        Block5.setRotationPoint( 0F, 28F, -5F );
        Block2 = new ModelRenderer( this, 9, 32 );
        Block2.setTextureSize( 64, 64 );
        Block2.addBox( -0.5F, -9F, -9F, 1, 18, 18);
        Block2.setRotationPoint( -5F, 28F, 0F );
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

        Block3.rotateAngleX = 0F;
        Block3.rotateAngleY = 0F;
        Block3.rotateAngleZ = -0.4363323F;
        Block3.renderWithRotation(0.0625F);

        Block4.rotateAngleX = 0.4363323F;
        Block4.rotateAngleY = 0F;
        Block4.rotateAngleZ = 0F;
        Block4.renderWithRotation(0.0625F);

        Block5.rotateAngleX = -0.4363323F;
        Block5.rotateAngleY = 0F;
        Block5.rotateAngleZ = 0F;
        Block5.renderWithRotation(0.0625F);

        Block2.rotateAngleX = 0F;
        Block2.rotateAngleY = 0F;
        Block2.rotateAngleZ = 0.4363323F;
        Block2.renderWithRotation(0.0625F);

    }

}
