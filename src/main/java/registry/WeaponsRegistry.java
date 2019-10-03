package registry;

import com.heimnor.common.Heimnor;

import init.weapons.Armes;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber(value = Side.CLIENT, modid = Heimnor.MODID)
public class WeaponsRegistry
{

	public static ToolMaterial improvise = EnumHelper.addToolMaterial("improviseMaterial", 3, 1000, 12.0F, 0.0F, 18);
	public static ToolMaterial military = EnumHelper.addToolMaterial("militaryMaterial", 3, 2000, 12.0F, 2.0F, 18);

	public static Armes epeeClaymore = new Armes(military, "epeeclaymore");
	public static Armes masseRhombe = new Armes(military, "masserhombe");
	public static Armes matraque = new Armes(improvise, "matraque");
	public static Armes patteDours = new Armes(improvise, "patteDours");
	public static Armes bodan = new Armes(improvise, "bodan");
	public static Armes saif = new Armes(military, "saif");
	public static Armes brazure = new Armes(military, "brazure");
	public static Armes hachebenie = new Armes(military, "hachebenie");
	public static Armes espadondebraz = new Armes(military, "espadonDeBraz");
	public static Armes bipenne = new Armes(military, "bipenne");
	public static Armes marteaudeguerre = new Armes(military, "marteaudeguerre");
	public static Armes daguedebraz = new Armes(military, "dagueDeBraz");
	public static Armes guisarme = new Armes(military, "guisarme");
	public static Armes marteaudebraz = new Armes(military, "marteauDeBraz");
	public static Armes faux = new Armes(improvise, "faux");
	public static Armes lancedebraz = new Armes(military, "lanceDeBraz");
	public static Armes epeedebraz = new Armes(military, "epeeDeBraz");
	public static Armes bidentdebraz = new Armes(military, "bidentDeBraz");
	public static Armes marteaulourddebraz = new Armes(military, "marteauLourdDeBraz");
	public static Armes hachoir = new Armes(improvise, "hachoir");
	public static Armes becdecorbin = new Armes(military, "becDeCorbin");
	public static Armes khirve = new Armes(military, "khirve");
	public static Armes epeelarge = new Armes(military, "epeeLarge");
	public static Armes daguerituelle = new Armes(military, "dagueRituelle");
	public static Armes chapelier = new Armes(improvise, "Chapelier");
	public static Armes sceptre = new Armes(improvise, "Sceptre");
	public static Armes daguedos = new Armes(improvise, "dagueDos");
	public static Armes tsuri = new Armes(military, "tsuri");
	public static Armes hallebardeailee = new Armes(military, "hallebardeAilee");
	public static Armes epeebatarde = new Armes(military, "epeeBatarde");
	public static Armes hanche = new Armes(military, "hanche");
	public static Armes espadon = new Armes(military, "espadon");
	public static Armes dague = new Armes(improvise, "dague");
	public static Armes hallante = new Armes(military, "hallante");
	public static Armes masseaailettes = new Armes(military, "masseAilettes");
	public static Armes massebenie = new Armes(military, "masseBenie");
	public static Armes hallebarde = new Armes(military, "hallebarde");
	public static Armes sceptreoronne = new Armes(improvise, "sceptreOronne");
	public static Armes hallebardebenie = new Armes(military, "hallebardeBenie");
	public static Armes lancedefaille = new Armes(military, "lanceDeFaille");
	public static Armes vangarde = new Armes(military, "vangarde");
	public static Armes qian = new Armes(military, "qian");
	public static Armes yishi = new Armes(military, "yishi");
	public static Armes epeebenie = new Armes(military, "epeeBenie");
	public static Armes hachedefjil = new Armes(military, "hacheDeFjil");
	public static Armes epeedorion = new Armes(military, "epeeDorion");
	public static Armes daguedefjil = new Armes(military, "dagueDeFjil");
	public static Armes massedos = new Armes(military, "masseOs");
	public static Armes lamedefjil = new Armes(military, "lameDeFjil");
	public static Armes quadree = new Armes(military, "quadree");
	public static Armes surin = new Armes(improvise, "surin");
	public static Armes malfif = new Armes(improvise, "malfif");
	public static Armes tesson = new Armes(improvise, "tesson");
	public static Armes bouteille = new Armes(improvise, "bouteille");
	public static Armes planche = new Armes(improvise, "planche");
	public static Armes massehectaire = new Armes(military, "masseHectaire");
	public static Armes hachedebataille = new Armes(military, "hacheDeBataille");
	public static Armes deuxmains = new Armes(military, "deuxmains");
	public static Armes coutelas = new Armes(military, "coutelas");
	public static Armes zhang = new Armes(military, "zhang");
	public static Armes hallebardebarbue = new Armes(military, "hallebardeBarbue");
	public static Armes masseapointes = new Armes(military, "massePointes");
	public static Armes hachebarbue = new Armes(military, "hacheBarbue");
	public static Armes lance = new Armes(military, "lance");
	public static Armes sceptredefer = new Armes(improvise, "sceptredefer");
	public static Armes hachepahinne = new Armes(military, "hachePahinne");
	public static Armes massedeguerre = new Armes(military, "masseDeGuerre");
	public static Armes katana = new Armes(military, "katana");
	public static Armes katar = new Armes(improvise, "katar");
	public static Armes kukri = new Armes(military, "kukri");
	public static Armes marteau = new Armes(military, "marteau");
	public static Armes sakran = new Armes(military, "sakran");
	public static Armes espadondorion = new Armes(military, "espadonDorion");
	public static Armes epeeailee = new Armes(military, "epeeAilee");
	public static Armes epeedroite = new Armes(military, "epeeDroite");
	public static Armes becdemoinin = new Armes(military, "becDeMoinin");
	public static Armes rapiere = new Armes(military, "rapiere");
	public static Armes sabre = new Armes(military, "sabre");
	public static Armes fauchon = new Armes(military, "fauchon");
	public static Armes fleau = new Armes(military, "fleau");
	public static Armes gantsdeguerre = new Armes(improvise, "gantsDeGuerre");
	public static Armes griffesdefer = new Armes(improvise, "griffesDeFer");
	public static Armes piquederoc = new Armes(improvise, "piqueDeRoc");
	public static Armes epeelongue = new Armes(military, "epeeLongue");
	public static Armes massederoc = new Armes(military, "masseDeRoc");
	public static Armes zenjia = new Armes(military, "zenjia");
	public static Armes lancederoc = new Armes(military, "lanceDeRoc");
	public static Armes pontinne = new Armes(military, "pontinne");
	public static Armes maillet = new Armes(improvise, "maillet");
	public static Armes piquard = new Armes(improvise, "piquard");
	public static Armes daguederoc = new Armes(improvise, "dagueDeRoc");
	public static Armes pieu = new Armes(improvise, "pieu");
	public static Armes torchere = new Armes(improvise, "torchere");
	public static Armes gourdincercle = new Armes(improvise, "gourdinCercle");
	public static Armes baton = new Armes(improvise, "baton");
	public static Armes canne = new Armes(improvise, "canne");
	public static Armes lanceenbois = new Armes(improvise, "lanceEnBois");
	public static Armes piquetier = new Armes(improvise, "piquetier");
	public static Armes serpe = new Armes(improvise, "serpe");
	public static Armes brigande = new Armes(military, "brigande");
	public static Armes pilleuse = new Armes(military, "pilleuse");
	public static Armes yanli = new Armes(military, "yanli");
	public static Armes haida = new Armes(military, "haida");
	public static Armes epee = new Armes(military, "epee");
	public static Armes gourdin = new Armes(improvise, "gourdin");
	public static Armes balais = new Armes(improvise, "balais");
	public static Armes lamedobsidienne = new Armes(military, "lameObsidienne");
	public static Armes hachederoc = new Armes(improvise, "hacheDeRoc");
	public static Armes hachedentrainement = new Armes(improvise, "hacheDentrainement");
	public static Armes epeedentrainement = new Armes(improvise, "epeeDentrainement");

	public static Item[] weapons = new Item[] { epeeClaymore, masseRhombe, guisarme, saif, brazure, espadondebraz, daguedebraz, marteaudebraz, lancedebraz, epeedebraz, bidentdebraz,
			marteaulourddebraz, becdecorbin, khirve, pontinne, epeelarge, daguerituelle, massedos, daguedos, hanche, espadon, dague, hallante, masseaailettes, hallebarde, espadondorion, epeedorion,
			lancedefaille, vangarde, qian, bodan, zhang, yishi, tsuri, yanli, haida, zenjia, katana, hachedefjil, daguedefjil, lamedefjil, quadree, malfif, massehectaire, hachedebataille, deuxmains,
			coutelas, hallebardebarbue, hachebarbue, masseapointes, lance, epeelongue, hachepahinne, massedeguerre, sakran, katar, kukri, marteau, epeedroite, becdemoinin, rapiere, sabre, fauchon,
			fleau, gantsdeguerre, griffesdefer, piquederoc, massederoc, hachederoc, lancederoc, daguederoc, brigande, pilleuse, epee, lamedobsidienne, lanceenbois, hachedentrainement,
			epeedentrainement, marteaudeguerre, bipenne, epeebatarde, sceptredefer, sceptreoronne, sceptre, chapelier, hallebardebenie, hachebenie, epeebenie, massebenie, epeeailee, hallebardeailee,
			piquetier, serpe, matraque, pieu, torchere, gourdincercle, baton, canne, surin, hachoir, tesson, gourdin, balais, patteDours, maillet, piquard, bouteille, planche, faux };

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void registerItemsModels(ModelRegistryEvent event)
	{

		for (int i = 0; i < weapons.length; i++)
			registerModel(weapons[i], 0);
	}

	@SideOnly(Side.CLIENT)
	public static void registerModel(Item item, int metadata)
	{
		if (metadata < 0)
			metadata = 0;
		String resourceName = item.getRegistryName().toString().substring(11);

		if (metadata > 0)
			resourceName += "_m" + String.valueOf(metadata);

		ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(Heimnor.MODID + ":armes/" + resourceName, "inventory"));
	}
}
