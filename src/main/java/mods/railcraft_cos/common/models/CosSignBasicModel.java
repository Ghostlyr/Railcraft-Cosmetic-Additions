// Date: 18/03/2016 18:29:34
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package mods.railcraft_cos.common.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class CosSignBasicModel extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
  
  public CosSignBasicModel()
  {
    textureWidth = 32;
    textureHeight = 32;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 2, 12, 1);
      Shape1.setRotationPoint(-1F, 12F, 0F);
      Shape1.setTextureSize(32, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 6, 0);
      Shape2.addBox(0F, 0F, 0F, 6, 6, 1);
      Shape2.setRotationPoint(-3F, 10F, -1F);
      Shape2.setTextureSize(32, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Shape1.render(f5);
    Shape2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
  }

}