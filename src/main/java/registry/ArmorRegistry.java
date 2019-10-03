package registry;

import java.util.Locale;

import com.heimnor.common.Heimnor;
import com.heimnor.henum.EnumArmorHeimnor;

import init.armor.HArmor;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SuppressWarnings("deprecation")
@EventBusSubscriber(value = Side.CLIENT, modid = Heimnor.MODID)
public class ArmorRegistry
{

	// Materials
	public static final ArmorMaterial ARMOR_BRAZ = EnumHelper.addArmorMaterial("braz_material", Heimnor.MODID + ":braz", ArmorCategories.BRAZ.getDurability(), ArmorCategories.BRAZ.getProtection(), 10,
			SoundRegistry.equiparmor, ArmorCategories.BRAZ.getToughness());
	public static final ArmorMaterial ORONNE1 = EnumHelper.addArmorMaterial("oronne1_material", Heimnor.MODID + ":oronne1", ArmorCategories.CIVILLOURD.getDurability(),
			ArmorCategories.CIVILLOURD.getProtection(), 10, SoundRegistry.equiparmor, ArmorCategories.CIVILLOURD.getToughness());
	public static final ArmorMaterial DUNE = EnumHelper.addArmorMaterial("dune_material", Heimnor.MODID + ":dune", ArmorCategories.MILITAIRELEGER.getDurability(),
			ArmorCategories.MILITAIRELEGER.getProtection(), 10, SoundRegistry.equiparmor, ArmorCategories.MILITAIRELEGER.getToughness());
	public static final ArmorMaterial SABLE = EnumHelper.addArmorMaterial("sable_material", Heimnor.MODID + ":sable", ArmorCategories.MILITAIRELEGER.getDurability(),
			ArmorCategories.MILITAIRELEGER.getProtection(), 10, SoundRegistry.equiparmor, ArmorCategories.MILITAIRELEGER.getToughness());
	public static final ArmorMaterial STEPPE = EnumHelper.addArmorMaterial("steppe_material", Heimnor.MODID + ":steppe", ArmorCategories.MILITAIRELEGER.getDurability(),
			ArmorCategories.MILITAIRELEGER.getProtection(), 10, SoundRegistry.equiparmor, ArmorCategories.MILITAIRELEGER.getToughness());
	public static final ArmorMaterial CUIRBOU = EnumHelper.addArmorMaterial("cuir_bouilli", Heimnor.MODID + ":cuir_bouilli", ArmorCategories.CIVILLOURD.getDurability(),
			ArmorCategories.CIVILLOURD.getProtection(), 10, SoundRegistry.equiparmor, ArmorCategories.CIVILLOURD.getToughness());
	public static final ArmorMaterial IMPRO = EnumHelper.addArmorMaterial("impro_aterial", Heimnor.MODID + ":impro", ArmorCategories.CIVILLEGER.getDurability(),
			ArmorCategories.CIVILLEGER.getProtection(), 10, SoundRegistry.equiparmor, ArmorCategories.CIVILLEGER.getToughness());
	public static final ArmorMaterial MERC = EnumHelper.addArmorMaterial("merc_material", Heimnor.MODID + ":merc", ArmorCategories.MILITAIRELEGER.getDurability(),
			ArmorCategories.MILITAIRELEGER.getProtection(), 10, SoundRegistry.equiparmor, ArmorCategories.MILITAIRELEGER.getToughness());
	public static final ArmorMaterial HAJI = EnumHelper.addArmorMaterial("haji_material", Heimnor.MODID + ":haji", ArmorCategories.MILITAIRELEGER.getDurability(),
			ArmorCategories.MILITAIRELEGER.getProtection(), 10, SoundRegistry.equiparmor, ArmorCategories.MILITAIRELEGER.getToughness());
	public static final ArmorMaterial TOUNDRA = EnumHelper.addArmorMaterial("toundra_material", Heimnor.MODID + ":toundra", ArmorCategories.CIVILLEGER.getDurability(),
			ArmorCategories.CIVILLEGER.getProtection(), 10, SoundRegistry.equiparmor, ArmorCategories.CIVILLEGER.getToughness());
	public static final ArmorMaterial GUERIN = EnumHelper.addArmorMaterial("guerin_material", Heimnor.MODID + ":guerin", ArmorCategories.MILITAIRELOURD.getDurability(),
			ArmorCategories.MILITAIRELOURD.getProtection(), 10, SoundRegistry.equiparmor, ArmorCategories.MILITAIRELOURD.getToughness());
	public static final ArmorMaterial PLAQUE = EnumHelper.addArmorMaterial("plaque_material", Heimnor.MODID + ":plaque", ArmorCategories.MILITAIRELOURD.getDurability(),
			ArmorCategories.MILITAIRELOURD.getProtection(), 10, SoundRegistry.equiparmor, ArmorCategories.MILITAIRELOURD.getToughness());
	public static final ArmorMaterial CLERC = EnumHelper.addArmorMaterial("clerc_material", Heimnor.MODID + ":clerc", ArmorCategories.MILITAIRELEGER.getDurability(),
			ArmorCategories.MILITAIRELEGER.getProtection(), 10, SoundRegistry.equiparmor, ArmorCategories.MILITAIRELEGER.getToughness());
	public static final ArmorMaterial SERGENT = EnumHelper.addArmorMaterial("sergent_material", Heimnor.MODID + ":sergent", ArmorCategories.MILITAIRELEGER.getDurability(),
			ArmorCategories.MILITAIRELEGER.getProtection(), 10, SoundRegistry.equiparmor, ArmorCategories.MILITAIRELEGER.getToughness());
	public static final ArmorMaterial CLOUTE = EnumHelper.addArmorMaterial("cloute_material", Heimnor.MODID + ":cloute", ArmorCategories.MILITAIRELEGER.getDurability(),
			ArmorCategories.MILITAIRELEGER.getProtection(), 10, SoundRegistry.equiparmor, ArmorCategories.MILITAIRELEGER.getToughness());
	public static final ArmorMaterial HUSCARL = EnumHelper.addArmorMaterial("huscarl_material", Heimnor.MODID + ":huscarl", ArmorCategories.MILITAIRELEGER.getDurability(),
			ArmorCategories.MILITAIRELEGER.getProtection(), 10, SoundRegistry.equiparmor, ArmorCategories.MILITAIRELEGER.getToughness());
	public static final ArmorMaterial MAILLE = EnumHelper.addArmorMaterial("maille_material", Heimnor.MODID + ":maille", ArmorCategories.MILITAIRELEGER.getDurability(),
			ArmorCategories.MILITAIRELEGER.getProtection(), 10, SoundRegistry.equiparmor, ArmorCategories.MILITAIRELEGER.getToughness());
	public static final ArmorMaterial LAMELLAIRE = EnumHelper.addArmorMaterial("lamellaire_material", Heimnor.MODID + ":lamellaire", ArmorCategories.MILITAIRELEGER.getDurability(),
			ArmorCategories.MILITAIRELEGER.getProtection(), 10, SoundRegistry.equiparmor, ArmorCategories.MILITAIRELEGER.getToughness());
	public static final ArmorMaterial MARAUDEUR = EnumHelper.addArmorMaterial("maraudeur_material", Heimnor.MODID + ":maraudeur", ArmorCategories.MILITAIRELOURD.getDurability(),
			ArmorCategories.MILITAIRELOURD.getProtection(), 10, SoundRegistry.equiparmor, ArmorCategories.MILITAIRELOURD.getToughness());

	// Armures
	public static final Item ADAMANTE_HELMET = new HArmor("item_casqueAdamante", ARMOR_BRAZ, EnumArmorHeimnor.ADAMANTE, EntityEquipmentSlot.HEAD, ArmorCategories.BRAZ, "adamante_helmet");
	public static final Item ADAMANTE_CHEST = new HArmor("item_plastronAdamante", ARMOR_BRAZ, EnumArmorHeimnor.ADAMANTE, EntityEquipmentSlot.CHEST, ArmorCategories.BRAZ, "adamante_chest");
	public static final Item ADAMANTE_LEGS = new HArmor("item_jambieresAdamante", ARMOR_BRAZ, EnumArmorHeimnor.ADAMANTE, EntityEquipmentSlot.LEGS, ArmorCategories.BRAZ, "adamante_legs");
	public static final Item ADAMANTE_FEET = new HArmor("item_bottesAdamante", ARMOR_BRAZ, EnumArmorHeimnor.ADAMANTE, EntityEquipmentSlot.FEET, ArmorCategories.BRAZ, "adamante_feet");

	public static final Item ORONNE1_HELMET = new HArmor("item_casqueOronne_1", ORONNE1, EnumArmorHeimnor.ORONNELEG, EntityEquipmentSlot.HEAD, ArmorCategories.CIVILLOURD, "oronne1_helmet");
	public static final Item ORONNE1_CHEST = new HArmor("item_plastronOronne_1", ORONNE1, EnumArmorHeimnor.ORONNELEG, EntityEquipmentSlot.CHEST, ArmorCategories.CIVILLOURD, "oronne1_chest");
	public static final Item ORONNE1_LEGS = new HArmor("item_jambieresOronne_1", ORONNE1, EnumArmorHeimnor.ORONNELEG, EntityEquipmentSlot.LEGS, ArmorCategories.CIVILLOURD, "oronne1_legs");
	public static final Item ORONNE1_FEET = new HArmor("item_bottesOronne_1", ORONNE1, EnumArmorHeimnor.ORONNELEG, EntityEquipmentSlot.FEET, ArmorCategories.CIVILLOURD, "oronne1_feet");

	public static final Item DUNE_HELMET = new HArmor("item_shaalCasque_1", DUNE, EnumArmorHeimnor.DUNES, EntityEquipmentSlot.HEAD, ArmorCategories.MILITAIRELEGER, "dune_helmet");
	public static final Item DUNE_CHEST = new HArmor("item_shaalPlastron_1", DUNE, EnumArmorHeimnor.DUNES, EntityEquipmentSlot.CHEST, ArmorCategories.MILITAIRELEGER, "dune_chest");
	public static final Item DUNE_FEET = new HArmor("item_shaalBottes_1", DUNE, EnumArmorHeimnor.DUNES, EntityEquipmentSlot.FEET, ArmorCategories.MILITAIRELEGER, "dune_feet");

	public static final Item SABLE_LEGS = new HArmor("item_shaalJambieres_2", SABLE, EnumArmorHeimnor.SABLES, EntityEquipmentSlot.LEGS, ArmorCategories.MILITAIRELEGER, "sable_legs");

	public static final Item STEPPE_HELMET = new HArmor("item_djarnedinCasque_1", STEPPE, EnumArmorHeimnor.STEPPES, EntityEquipmentSlot.HEAD, ArmorCategories.MILITAIRELEGER, "steppe_helmet");
	public static final Item STEPPE_CHEST = new HArmor("item_djarnedinPlastron_1", STEPPE, EnumArmorHeimnor.STEPPES, EntityEquipmentSlot.CHEST, ArmorCategories.MILITAIRELEGER, "steppe_chest");
	public static final Item STEPPE_FEET = new HArmor("item_djarnedinBottes_1", STEPPE, EnumArmorHeimnor.STEPPES, EntityEquipmentSlot.FEET, ArmorCategories.MILITAIRELEGER, "steppe_feet");

	public static final Item CUIRBOU_HELMET = new HArmor("item_cuirBouilliCasque", CUIRBOU, EnumArmorHeimnor.CUIRBOUILLI, EntityEquipmentSlot.HEAD, ArmorCategories.CIVILLOURD, "cuir_bouilli_helmet");
	public static final Item CUIRBOU_CHEST = new HArmor("item_cuirBouilliPlastron", CUIRBOU, EnumArmorHeimnor.CUIRBOUILLI, EntityEquipmentSlot.CHEST, ArmorCategories.CIVILLOURD, "cuir_bouilli_chest");
	public static final Item CUIRBOU_LEGS = new HArmor("item_cuirBouilliJambieres", CUIRBOU, EnumArmorHeimnor.CUIRBOUILLI, EntityEquipmentSlot.LEGS, ArmorCategories.CIVILLOURD, "cuir_bouilli_legs");
	public static final Item CUIRBOU_FEET = new HArmor("item_cuirBouilliBottes", CUIRBOU, EnumArmorHeimnor.CUIRBOUILLI, EntityEquipmentSlot.FEET, ArmorCategories.CIVILLOURD, "cuir_bouilli_feet");

	public static final Item IMPRO_HELMET = new HArmor("item_armureImproviseeCasque", IMPRO, EnumArmorHeimnor.IMPROVISEE, EntityEquipmentSlot.HEAD, ArmorCategories.CIVILLEGER, "impro_helmet");
	public static final Item IMPRO_CHEST = new HArmor("item_armureImproviseePlastron", IMPRO, EnumArmorHeimnor.IMPROVISEE, EntityEquipmentSlot.CHEST, ArmorCategories.CIVILLEGER, "impro_chest");
	public static final Item IMPRO_LEGS = new HArmor("item_armureImproviseeJambieres", IMPRO, EnumArmorHeimnor.IMPROVISEE, EntityEquipmentSlot.LEGS, ArmorCategories.CIVILLEGER, "impro_legs");
	public static final Item IMPRO_FEET = new HArmor("item_armureImproviseeBottes", IMPRO, EnumArmorHeimnor.IMPROVISEE, EntityEquipmentSlot.FEET, ArmorCategories.CIVILLEGER, "impro_feet");

	public static final Item MERC_HELMET = new HArmor("item_armureMercenaireCasque", MERC, EnumArmorHeimnor.MERCENAIRE, EntityEquipmentSlot.HEAD, ArmorCategories.MILITAIRELEGER, "merc_helmet");
	public static final Item MERC_CHEST = new HArmor("item_armureMercenairePlastron", MERC, EnumArmorHeimnor.MERCENAIRE, EntityEquipmentSlot.CHEST, ArmorCategories.MILITAIRELEGER, "merc_chest");
	public static final Item MERC_LEGS = new HArmor("item_armureMercenaireJambieres", MERC, EnumArmorHeimnor.MERCENAIRE, EntityEquipmentSlot.LEGS, ArmorCategories.MILITAIRELEGER, "merc_legs");
	public static final Item MERC_FEET = new HArmor("item_armureMercenaireBottes", MERC, EnumArmorHeimnor.MERCENAIRE, EntityEquipmentSlot.FEET, ArmorCategories.MILITAIRELEGER, "merc_feet");

	public static final Item HAJI_HELMET = new HArmor("item_cHaji", HAJI, EnumArmorHeimnor.HAJI, EntityEquipmentSlot.HEAD, ArmorCategories.MILITAIRELEGER, "haji_helmet");
	public static final Item HAJI_CHEST = new HArmor("item_pHaji", HAJI, EnumArmorHeimnor.HAJI, EntityEquipmentSlot.CHEST, ArmorCategories.MILITAIRELEGER, "haji_chest");
	public static final Item HAJI_LEGS = new HArmor("item_jHaji", HAJI, EnumArmorHeimnor.HAJI, EntityEquipmentSlot.LEGS, ArmorCategories.MILITAIRELEGER, "haji_legs");
	public static final Item HAJI_FEET = new HArmor("item_bHaji", HAJI, EnumArmorHeimnor.HAJI, EntityEquipmentSlot.FEET, ArmorCategories.MILITAIRELEGER, "haji_feet");

	public static final Item TOUNDRA_HELMET = new HArmor("item_armureToundraCasque", TOUNDRA, EnumArmorHeimnor.TOUNDRA, EntityEquipmentSlot.HEAD, ArmorCategories.CIVILLEGER, "toundra_helmet");
	public static final Item TOUNDRA_CHEST = new HArmor("item_armureToundraPlastron", TOUNDRA, EnumArmorHeimnor.TOUNDRA, EntityEquipmentSlot.CHEST, ArmorCategories.CIVILLEGER, "toundra_chest");
	public static final Item TOUNDRA_LEGS = new HArmor("item_armureToundraJambieres", TOUNDRA, EnumArmorHeimnor.TOUNDRA, EntityEquipmentSlot.LEGS, ArmorCategories.CIVILLEGER, "toundra_legs");
	public static final Item TOUNDRA_FEET = new HArmor("item_armureToundraBottes", TOUNDRA, EnumArmorHeimnor.TOUNDRA, EntityEquipmentSlot.FEET, ArmorCategories.CIVILLEGER, "toundra_feet");

	public static final Item GUERIN_HELMET = new HArmor("item_armureGuerinneCasque", GUERIN, EnumArmorHeimnor.GUERIN, EntityEquipmentSlot.HEAD, ArmorCategories.MILITAIRELOURD, "guerin_helmet");
	public static final Item GUERIN_CHEST = new HArmor("item_armureGuerinnePlastron", GUERIN, EnumArmorHeimnor.GUERIN, EntityEquipmentSlot.CHEST, ArmorCategories.MILITAIRELOURD, "guerin_chest");
	public static final Item GUERIN_LEGS = new HArmor("item_armureGuerinneJambieres", GUERIN, EnumArmorHeimnor.GUERIN, EntityEquipmentSlot.LEGS, ArmorCategories.MILITAIRELOURD, "guerin_legs");
	public static final Item GUERIN_FEET = new HArmor("item_armureGuerinneBottes", GUERIN, EnumArmorHeimnor.GUERIN, EntityEquipmentSlot.FEET, ArmorCategories.MILITAIRELOURD, "guerin_feet");

	public static final Item PLAQUE_HELMET = new HArmor("item_armurePlaquesCasque", PLAQUE, EnumArmorHeimnor.PLAQUES, EntityEquipmentSlot.HEAD, ArmorCategories.MILITAIRELOURD, "plaque_helmet");
	public static final Item PLAQUE_CHEST = new HArmor("item_armurePlaquesPlastron", PLAQUE, EnumArmorHeimnor.PLAQUES, EntityEquipmentSlot.CHEST, ArmorCategories.MILITAIRELOURD, "plaque_chest");
	public static final Item PLAQUE_LEGS = new HArmor("item_armurePlaquesJambieres", PLAQUE, EnumArmorHeimnor.PLAQUES, EntityEquipmentSlot.LEGS, ArmorCategories.MILITAIRELOURD, "plaque_legs");
	public static final Item PLAQUE_FEET = new HArmor("item_armurePlaquesBottes", PLAQUE, EnumArmorHeimnor.PLAQUES, EntityEquipmentSlot.FEET, ArmorCategories.MILITAIRELOURD, "plaque_feet");

	public static final Item CLERC_HELMET = new HArmor("item_cClericale", CLERC, EnumArmorHeimnor.CLERICALE, EntityEquipmentSlot.HEAD, ArmorCategories.MILITAIRELEGER, "clerc_helmet");
	public static final Item CLERC_CHEST = new HArmor("item_pClericale", CLERC, EnumArmorHeimnor.CLERICALE, EntityEquipmentSlot.CHEST, ArmorCategories.MILITAIRELEGER, "clerc_chest");
	public static final Item CLERC_LEGS = new HArmor("item_jClericale", CLERC, EnumArmorHeimnor.CLERICALE, EntityEquipmentSlot.LEGS, ArmorCategories.MILITAIRELEGER, "clerc_legs");
	public static final Item CLERC_FEET = new HArmor("item_bClericale", CLERC, EnumArmorHeimnor.CLERICALE, EntityEquipmentSlot.FEET, ArmorCategories.MILITAIRELEGER, "clerc_feet");

	public static final Item SERGENT_HELMET = new HArmor("item_cSergent", SERGENT, EnumArmorHeimnor.SERGENT, EntityEquipmentSlot.HEAD, ArmorCategories.MILITAIRELOURD, "sergent_helmet");
	public static final Item SERGENT_CHEST = new HArmor("item_pSergent", SERGENT, EnumArmorHeimnor.SERGENT, EntityEquipmentSlot.CHEST, ArmorCategories.MILITAIRELOURD, "sergent_chest");
	public static final Item SERGENT_LEGS = new HArmor("item_jSergent", SERGENT, EnumArmorHeimnor.SERGENT, EntityEquipmentSlot.LEGS, ArmorCategories.MILITAIRELOURD, "sergent_legs");
	public static final Item SERGENT_FEET = new HArmor("item_bSergent", SERGENT, EnumArmorHeimnor.SERGENT, EntityEquipmentSlot.FEET, ArmorCategories.MILITAIRELOURD, "sergent_feet");

	public static final Item CLOUTE_HELMET = new HArmor("item_cCloute", CLOUTE, EnumArmorHeimnor.CLOUTE, EntityEquipmentSlot.HEAD, ArmorCategories.MILITAIRELEGER, "cloute_helmet");
	public static final Item CLOUTE_CHEST = new HArmor("item_pCloute", CLOUTE, EnumArmorHeimnor.CLOUTE, EntityEquipmentSlot.CHEST, ArmorCategories.MILITAIRELEGER, "cloute_chest");
	public static final Item CLOUTE_LEGS = new HArmor("item_jCloute", CLOUTE, EnumArmorHeimnor.CLOUTE, EntityEquipmentSlot.LEGS, ArmorCategories.MILITAIRELEGER, "cloute_legs");
	public static final Item CLOUTE_FEET = new HArmor("item_bCloute", CLOUTE, EnumArmorHeimnor.CLOUTE, EntityEquipmentSlot.FEET, ArmorCategories.MILITAIRELEGER, "cloute_feet");

	public static final Item HUSCARL_HELMET = new HArmor("item_cHuscarl", HUSCARL, EnumArmorHeimnor.HUSCARL, EntityEquipmentSlot.HEAD, ArmorCategories.MILITAIRELEGER, "huscarl_helmet");
	public static final Item HUSCARL_CHEST = new HArmor("item_pHuscarl", HUSCARL, EnumArmorHeimnor.HUSCARL, EntityEquipmentSlot.CHEST, ArmorCategories.MILITAIRELEGER, "huscarl_chest");
	public static final Item HUSCARL_LEGS = new HArmor("item_jHuscarl", HUSCARL, EnumArmorHeimnor.HUSCARL, EntityEquipmentSlot.LEGS, ArmorCategories.MILITAIRELEGER, "huscarl_legs");
	public static final Item HUSCARL_FEET = new HArmor("item_bHuscarl", HUSCARL, EnumArmorHeimnor.HUSCARL, EntityEquipmentSlot.FEET, ArmorCategories.MILITAIRELEGER, "huscarl_feet");

	public static final Item MAILLE_HELMET = new HArmor("item_cMaille", MAILLE, EnumArmorHeimnor.MAILLE, EntityEquipmentSlot.HEAD, ArmorCategories.MILITAIRELEGER, "maille_helmet");
	public static final Item MAILLE_CHEST = new HArmor("item_pMaille", MAILLE, EnumArmorHeimnor.MAILLE, EntityEquipmentSlot.CHEST, ArmorCategories.MILITAIRELEGER, "maille_chest");
	public static final Item MAILLE_LEGS = new HArmor("item_jMaille", MAILLE, EnumArmorHeimnor.MAILLE, EntityEquipmentSlot.LEGS, ArmorCategories.MILITAIRELEGER, "maille_legs");
	public static final Item MAILLE_FEET = new HArmor("item_bMaille", MAILLE, EnumArmorHeimnor.MAILLE, EntityEquipmentSlot.FEET, ArmorCategories.MILITAIRELEGER, "maille_feet");

	public static final Item LAMELLAIRE_HELMET = new HArmor("item_cLamellaire", LAMELLAIRE, EnumArmorHeimnor.LAMELLAIRE, EntityEquipmentSlot.HEAD, ArmorCategories.MILITAIRELEGER, "lamellaire_helmet");
	public static final Item LAMELLAIRE_CHEST = new HArmor("item_pLamellaire", LAMELLAIRE, EnumArmorHeimnor.LAMELLAIRE, EntityEquipmentSlot.CHEST, ArmorCategories.MILITAIRELEGER, "lamellaire_chest");
	public static final Item LAMELLAIRE_LEGS = new HArmor("item_jLamellaire", LAMELLAIRE, EnumArmorHeimnor.LAMELLAIRE, EntityEquipmentSlot.LEGS, ArmorCategories.MILITAIRELEGER, "lamellaire_legs");
	public static final Item LAMELLAIRE_FEET = new HArmor("item_bLamellaire", LAMELLAIRE, EnumArmorHeimnor.LAMELLAIRE, EntityEquipmentSlot.FEET, ArmorCategories.MILITAIRELEGER, "lamellaire_feet");

	public static final Item MARAUDEUR_HELMET = new HArmor("item_cMaraudeur", MARAUDEUR, EnumArmorHeimnor.MARAUDEUR, EntityEquipmentSlot.HEAD, ArmorCategories.MILITAIRELOURD, "maraudeur_helmet");
	public static final Item MARAUDEUR_CHEST = new HArmor("item_pMaraudeur", MARAUDEUR, EnumArmorHeimnor.MARAUDEUR, EntityEquipmentSlot.CHEST, ArmorCategories.MILITAIRELOURD, "maraudeur_chest");
	public static final Item MARAUDEUR_LEGS = new HArmor("item_jMaraudeur", MARAUDEUR, EnumArmorHeimnor.MARAUDEUR, EntityEquipmentSlot.LEGS, ArmorCategories.MILITAIRELOURD, "maraudeur_legs");
	public static final Item MARAUDEUR_FEET = new HArmor("item_bMaraudeur", MARAUDEUR, EnumArmorHeimnor.MARAUDEUR, EntityEquipmentSlot.FEET, ArmorCategories.MILITAIRELOURD, "maraudeur_feet");

	public static final Item[] armors = new Item[] { ADAMANTE_HELMET, ADAMANTE_CHEST, ADAMANTE_LEGS, ADAMANTE_FEET, ORONNE1_HELMET, ORONNE1_CHEST, ORONNE1_LEGS, ORONNE1_FEET, DUNE_HELMET, DUNE_CHEST,
			DUNE_FEET, SABLE_LEGS, STEPPE_HELMET, STEPPE_CHEST, STEPPE_FEET, CUIRBOU_HELMET, CUIRBOU_CHEST, CUIRBOU_LEGS, CUIRBOU_FEET, IMPRO_HELMET, IMPRO_CHEST, IMPRO_LEGS, IMPRO_FEET, MERC_HELMET,
			MERC_CHEST, MERC_LEGS, MERC_FEET, HAJI_HELMET, HAJI_CHEST, HAJI_LEGS, HAJI_FEET, TOUNDRA_HELMET, TOUNDRA_CHEST, TOUNDRA_LEGS, TOUNDRA_FEET, GUERIN_HELMET, GUERIN_CHEST, GUERIN_LEGS,
			GUERIN_FEET, PLAQUE_HELMET, PLAQUE_CHEST, PLAQUE_LEGS, PLAQUE_FEET, CLERC_HELMET, CLERC_CHEST, CLERC_LEGS, CLERC_FEET, SERGENT_HELMET, SERGENT_CHEST, SERGENT_LEGS, SERGENT_FEET,
			CLOUTE_HELMET, CLOUTE_CHEST, CLOUTE_LEGS, CLOUTE_FEET, HUSCARL_HELMET, HUSCARL_CHEST, HUSCARL_LEGS, HUSCARL_FEET, MAILLE_HELMET, MAILLE_CHEST, MAILLE_LEGS, MAILLE_FEET, LAMELLAIRE_HELMET,
			LAMELLAIRE_CHEST, LAMELLAIRE_LEGS, LAMELLAIRE_FEET, MARAUDEUR_HELMET, MARAUDEUR_CHEST, MARAUDEUR_LEGS, MARAUDEUR_FEET };

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void registerItemsModels(ModelRegistryEvent event)
	{

		for (int i = 0; i < armors.length; i++)
			registerModel(armors[i]);
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerModel(Item item)
	{

		String resourceName = item.getRegistryName().toString().substring(16);
		resourceName.toLowerCase(Locale.ROOT);
		
		ModelLoader.setCustomModelResourceLocation(	item , 0, new ModelResourceLocation(Heimnor.MODID + ":armors/" + resourceName, "inventory"));
	}
	
	public enum ArmorCategories
	{
		CIVILLEGER(0.0F, 0.0F, 50, new int[] { 1, 3, 2, 1 }, 0),
		CIVILLOURD(0.0F, 0.0F, 70, new int[] { 1, 4, 2, 1 }, 0),
		MILITAIRELEGER(0.006F, 0.0115F, 90, new int[] { 2, 5, 2, 1 }, 0),
		MILITAIRELOURD(0.015F, 0.02F, 120, new int[] { 3, 6, 3, 2 }, 1),
		BRAZ(0.02F, 0.025F, 130, new int[] { 4, 6, 5, 3 }, 2);

		private float moveMin;
		private float moveMax;
		private int[] protection;
		private int toughness;
		private int durability;

		ArmorCategories(float moveMin, float moveMax, int durability, int[] protection, int toughness)
		{

			this.moveMin = moveMin;
			this.moveMax = moveMax;
			this.durability = durability;
			this.protection = protection;
			this.toughness = toughness;
		}

		public float getMoveMin()
		{
			return this.moveMin;
		}

		public float getMoveMax()
		{
			return this.moveMax;
		}

		public int[] getProtection()
		{
			return this.protection;
		}

		public int getDurability()
		{
			return this.durability;
		}

		public int getToughness()
		{
			return this.toughness;
		}
	}
}
