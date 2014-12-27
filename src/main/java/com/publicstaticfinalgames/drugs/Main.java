package com.publicstaticfinalgames.drugs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;

import com.publicstaticfinalgames.drugs.blocks.CannabisPlantBlock;
import com.publicstaticfinalgames.drugs.blocks.CocaPlantBlock;
import com.publicstaticfinalgames.drugs.blocks.CocaineTraceBlock;
import com.publicstaticfinalgames.drugs.blocks.DryingRack;
import com.publicstaticfinalgames.drugs.blocks.Grinder;
import com.publicstaticfinalgames.drugs.dimensions.HighWorldGenerator;
import com.publicstaticfinalgames.drugs.items.ItemCocaine;
import com.publicstaticfinalgames.drugs.items.ItemCookedBrownie;
import com.publicstaticfinalgames.drugs.items.ItemFilledPipe;
import com.publicstaticfinalgames.drugs.items.ItemJoint;
import com.publicstaticfinalgames.drugs.items.ItemMagicMush;
import com.publicstaticfinalgames.drugs.items.ItemStraw;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main {
	public static final String NAME = "Drugs Mod";
	public static final String MODID = "DrugsMod";
	public static final String VERSION = "1.0";

	@SidedProxy(clientSide = "com.publicstaticfinalgames.drugs.ClientProxy", serverSide = "com.publicstaticfinalgames.drugs.CommonProxy")
	public static CommonProxy proxy;

	@Instance
	public static Main instance;
	
	public static HighWorldGenerator highWorldGen;
	
	public static Block cocaineTrace;
	public static Block cannabisPlantBlock;
	public static Block cocaPlantBlock;
	public static Block grinder;
	public static Block dryingRack;

	public static Item cocaSeed;
	public static Item cocaine;
	public static Item cocaineLeave;
	public static Item cocainePaste;
	public static Item cannabisCookedBrownie;
	public static Item cannabisBrownie;
	public static Item cannabisSeed;
	public static Item cannabisDryied;
	public static Item cannabisGrinded;
	public static Item cannabisLeave;
	public static Item pipe;
	public static Item filledPipe;
	public static Item joint;
	public static Item straw;
	public static Item magicMush;

	public static final CreativeTabs drugsTab = new CreativeTabs("drugmodTab") {
		public Item getTabIconItem() {
			return cannabisLeave;
		}
	};

	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		/*
		 * 
		 * Blocks
		 */
		grinder = new Grinder(Material.iron).setBlockName("grinder").setCreativeTab(drugsTab);
		dryingRack = new DryingRack(Material.wood).setBlockName("dryingRack").setCreativeTab(drugsTab);
		cocaineTrace = new CocaineTraceBlock(Material.iron).setBlockName("cocainetrace");

		cannabisPlantBlock = new CannabisPlantBlock().setBlockName("cannabisPlantBlock").setBlockTextureName(MODID + ":" + "marijuana");
		cocaPlantBlock = new CocaPlantBlock().setBlockName("cocaPlantBlock");
		GameRegistry.registerBlock(grinder, "grinder");
		GameRegistry.registerBlock(dryingRack, "dryingRack");
		GameRegistry.registerBlock(cocaineTrace, "cocainetrace");
		GameRegistry.registerBlock(cannabisPlantBlock, "cannabisPlantBlock");
		GameRegistry.registerBlock(cocaPlantBlock, "cocaPlantBlock");

		/*
		 * 
		 * Items
		 */
		straw = new ItemStraw().setUnlocalizedName("straw").setCreativeTab(drugsTab).setMaxStackSize(1).setMaxDamage(20).setTextureName(MODID + ":" + "straw");
		pipe = new Item().setUnlocalizedName("pipe").setCreativeTab(drugsTab).setMaxStackSize(1).setTextureName(MODID + ":" + "emptyPipe");
		filledPipe = new ItemFilledPipe().setUnlocalizedName("filledPipe").setCreativeTab(drugsTab).setMaxStackSize(1).setTextureName(MODID + ":" + "filledPipe");
		cannabisCookedBrownie = new ItemCookedBrownie(6, false).setUnlocalizedName("cannabisCookedBrownie").setCreativeTab(drugsTab).setTextureName(MODID + ":" +"cookedBrownie");
		cannabisSeed = new ItemSeeds(cannabisPlantBlock, Blocks.farmland).setUnlocalizedName("cannabisSeed").setCreativeTab(drugsTab).setTextureName(MODID + ":"+ "cannabisSeeds");
		cannabisLeave = new Item().setUnlocalizedName("weed1").setCreativeTab(drugsTab).setTextureName(MODID + ":" + "cannabisLeave");
		cannabisGrinded = new Item().setUnlocalizedName("grindedCannabis").setCreativeTab(drugsTab);
		cannabisDryied = new Item().setUnlocalizedName("cannabisDryied").setCreativeTab(drugsTab);
		cannabisBrownie = new Item().setUnlocalizedName("cannabisBrownie").setCreativeTab(drugsTab).setTextureName(MODID + ":" + "uncookedBrownie");
		cocaine = new ItemCocaine().setUnlocalizedName("cocaine").setCreativeTab(drugsTab).setTextureName(MODID + ":" + "cocaine");
		cocaineLeave = new Item().setUnlocalizedName("cocaineLeave").setCreativeTab(drugsTab).setTextureName(MODID + ":" + "cocaineLeaf");
		cocaSeed = new ItemSeeds(cocaPlantBlock, Blocks.farmland).setUnlocalizedName("cocaineSeed").setCreativeTab(drugsTab).setTextureName(MODID + ":" + "cocaSeeds");
		cocainePaste = new Item().setUnlocalizedName("cocainePaste").setCreativeTab(drugsTab).setTextureName(MODID + ":" + "cocainePaste");
		joint = new ItemJoint().setUnlocalizedName("joint").setMaxStackSize(1).setCreativeTab(drugsTab).setTextureName(MODID + ":" + "joint");
		magicMush = new ItemMagicMush(2, false).setAlwaysEdible().setUnlocalizedName("magicMush").setCreativeTab(drugsTab).setTextureName(MODID + ":" + "magicMush");
		GameRegistry.registerItem(straw, "straw");
		GameRegistry.registerItem(cocaine, "cocaine");
		GameRegistry.registerItem(cocaSeed, "cocaineSeed");
		GameRegistry.registerItem(cocaineLeave, "cocaineLeave");
		GameRegistry.registerItem(cocainePaste, "cocainePaste");
		GameRegistry.registerItem(cannabisSeed, "cannabisSeed");
		GameRegistry.registerItem(cannabisLeave, "cannabis");
		GameRegistry.registerItem(cannabisGrinded, "cannabisGrinded");
		GameRegistry.registerItem(cannabisDryied, "cannabisDryied");
		GameRegistry.registerItem(cannabisBrownie, "cannabisBrownie");
		GameRegistry.registerItem(cannabisCookedBrownie, "cannabisCookedBrownie");
		GameRegistry.registerItem(pipe, "pipe");
		GameRegistry.registerItem(filledPipe, "filledPipe");
		GameRegistry.registerItem(joint, "joint");
		GameRegistry.registerItem(magicMush, "magicMush");

		/*
		 * 
		 * Recipes
		 */
		GameRegistry.addRecipe(new ItemStack(Main.straw), new Object[] {
				"B  ",
				" B ",
				"  B",
				'B', Blocks.reeds
		});

		GameRegistry.addRecipe(new ItemStack(Main.dryingRack), new Object[] {
				"SSS",
				" I ",
				"S S",
				'S', Items.stick,
				'I', Items.iron_ingot
		});

		GameRegistry.addRecipe(new ItemStack(Main.grinder), new Object[] {
				" I ",
				"IBI",
				" I ",
				'I', Items.iron_ingot,
				'B', Blocks.iron_bars
		});

		GameRegistry.addRecipe(new ItemStack(Main.pipe), new Object[] {
				"  W",
				"SSI",
				'W', Blocks.planks,
				'S', Items.stick,
				'I', Items.iron_ingot
		});

		GameRegistry.addRecipe(new ItemStack(Main.filledPipe), new Object[] {
				"W",
				"P",
				'W', Main.cannabisGrinded,
				'P', Main.pipe
		});

		GameRegistry.addRecipe(new ItemStack(Main.cannabisBrownie, 3), new Object[] {
				"CCC",
				"WEW",
				"FWF",
				'C', Items.sugar,
				'W', Main.cannabisGrinded,
				'E', Items.egg,
				'F', Items.wheat
		});

		GameRegistry.addRecipe(new ItemStack(Main.joint, 1), new Object[] {
				"WWW",
				"PPP",
				'P', Items.paper,
				'W', Main.cannabisGrinded
		});

		GameRegistry.addShapelessRecipe(new ItemStack(Main.cocainePaste), new Object[] {
				Main.cocaineLeave,
				Items.water_bucket
		});

		GameRegistry.addSmelting(cannabisBrownie, new ItemStack(cannabisCookedBrownie, 1), 0);
		
		highWorldGen = new HighWorldGenerator();
		DimensionManager.registerProviderType(highWorldGen.dimensionId, HighWorldGenerator.class, false);
		DimensionManager.createProviderFor(highWorldGen.dimensionId);
		DimensionManager.registerDimension(highWorldGen.dimensionId, highWorldGen.dimensionId);
		
		MinecraftForge.addGrassSeed(new ItemStack(cannabisSeed, 1), 8);
		MinecraftForge.addGrassSeed(new ItemStack(cocaSeed, 1), 8);
		proxy.registerRenderers();
	}

	@EventHandler
	public void starting(FMLServerStartingEvent event) {
		event.getServer().addChatMessage(new ChatComponentText("Drug Mod succesfully loaded, currently using version " + VERSION));
	}
}
