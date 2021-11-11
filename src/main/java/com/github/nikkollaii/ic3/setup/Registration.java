package com.github.nikkollaii.ic3.setup;

import com.github.nikkollaii.ic3.block.batbox.BatBoxBE;
import com.github.nikkollaii.ic3.block.batbox.BatBoxBlock;
import com.github.nikkollaii.ic3.block.batbox.BatBoxContainer;
import com.github.nikkollaii.ic3.block.generator.GeneratorBE;
import com.github.nikkollaii.ic3.block.generator.GeneratorBlock;
import com.github.nikkollaii.ic3.block.generator.GeneratorContainer;
import com.github.nikkollaii.ic3.item.ArmorMaterials;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.grower.JungleTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

import static com.github.nikkollaii.ic3.IC3.MOD_ID;

public class Registration {
    public static final CreativeModeTab TAB = new CreativeModeTab("ic3Tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(GENERATOR_ITEM.get());
        }
    };

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MOD_ID);
    private static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, MOD_ID);

    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
        BLOCKS.register(bus);
        BLOCK_ENTITIES.register(bus);
        CONTAINERS.register(bus);
    }

    public static final RegistryObject<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot", () -> new Item(new Item.Properties().tab(TAB)));
    public static final RegistryObject<Block> BRONZE_BLOCK = BLOCKS.register("bronze_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).strength(7.0F, 5.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistryObject<BlockItem> BRONZE_BLOCK_ITEM = ITEMS.register("bronze_block", () -> new BlockItem(BRONZE_BLOCK.get(), new Item.Properties().tab(TAB)));

    public static final Tier BRONZE_TIER = TierSortingRegistry.registerTier(
            new ForgeTier(2, 200, 6.0F, 2.0F, 14, BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(BRONZE_INGOT.get())),
            new ResourceLocation("ic3:bronze_tier"),
            List.of(Tiers.IRON),
            List.of()
    );

    public static final RegistryObject<Item> BRONZE_SWORD = ITEMS.register("bronze_sword", () -> new SwordItem(BRONZE_TIER,3, -2.4F,  new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> BRONZE_SHOVEL = ITEMS.register("bronze_shovel", () -> new DiggerItem(1.5F, -3.0F, BRONZE_TIER, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> BRONZE_PICKAXE = ITEMS.register("bronze_pickaxe", () -> new DiggerItem(1, -2.8F, BRONZE_TIER, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> BRONZE_AXE = ITEMS.register("bronze_axe", () -> new DiggerItem(6.0F, -3.1F, BRONZE_TIER, BlockTags.MINEABLE_WITH_AXE, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> BRONZE_HOE = ITEMS.register("bronze_hoe", () -> new HoeItem(BRONZE_TIER,-2, -1.0F, new Item.Properties().tab(TAB)));

    public static final RegistryObject<Item> BRONZE_HELMET = ITEMS.register("bronze_helmet", () -> new ArmorItem(ArmorMaterials.BRONZE, EquipmentSlot.HEAD, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> BRONZE_CHESTPLATE = ITEMS.register("bronze_chestplate", () -> new ArmorItem(ArmorMaterials.BRONZE, EquipmentSlot.CHEST, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> BRONZE_LEGGINGS = ITEMS.register("bronze_leggings", () -> new ArmorItem(ArmorMaterials.BRONZE, EquipmentSlot.LEGS, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> BRONZE_BOOTS = ITEMS.register("bronze_boots", () -> new ArmorItem(ArmorMaterials.BRONZE, EquipmentSlot.FEET, new Item.Properties().tab(TAB)));

    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", () -> new Item(new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> RAW_TIN = ITEMS.register("raw_tin", () -> new Item(new Item.Properties().tab(TAB)));
    public static final RegistryObject<Block> TIN_ORE = BLOCKS.register("tin_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3.0F, 3.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<BlockItem> TIN_ORE_ITEM = ITEMS.register("tin_ore", () -> new BlockItem(TIN_ORE.get(), new Item.Properties().tab(TAB)));
    public static final RegistryObject<Block> DEEPSLATE_TIN_ORE = BLOCKS.register("deepslate_tin_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<BlockItem> DEEPSLATE_TIN_ORE_ITEM = ITEMS.register("deepslate_tin_ore", () -> new BlockItem(DEEPSLATE_TIN_ORE.get(), new Item.Properties().tab(TAB)));
    public static final RegistryObject<Block> TIN_BLOCK = BLOCKS.register("tin_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).strength(5.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistryObject<BlockItem> TIN_BLOCK_ITEM = ITEMS.register("tin_block", () -> new BlockItem(TIN_BLOCK.get(), new Item.Properties().tab(TAB)));

    public static final RegistryObject<Block> HEVEA_SAPLING = BLOCKS.register("hevea_sapling", () -> new SaplingBlock(new JungleTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<BlockItem> HEVEA_SAPLING_ITEM = ITEMS.register("hevea_sapling", () -> new BlockItem(HEVEA_SAPLING.get(), new Item.Properties().tab(TAB)));
    public static final RegistryObject<Block> HEVEA_LOG = BLOCKS.register("hevea_log", () -> log(MaterialColor.DIRT, MaterialColor.PODZOL));
    public static final RegistryObject<BlockItem> HEVEA_LOG_ITEM = ITEMS.register("hevea_log", () -> new BlockItem(HEVEA_LOG.get(), new Item.Properties().tab(TAB)));
    public static final RegistryObject<Block> STRIPPED_HEVEA_LOG  = BLOCKS.register("stripped_hevea_log", () -> log(MaterialColor.DIRT, MaterialColor.DIRT));
    public static final RegistryObject<BlockItem> STRIPPED_HEVEA_LOG_ITEM = ITEMS.register("stripped_hevea_log", () -> new BlockItem(STRIPPED_HEVEA_LOG.get(), new Item.Properties().tab(TAB)));
    public static final RegistryObject<Block> HEVEA_WOOD = BLOCKS.register("hevea_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.DIRT).strength(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<BlockItem> HEVEA_WOOD_ITEM = ITEMS.register("hevea_wood", () -> new BlockItem(HEVEA_WOOD.get(), new Item.Properties().tab(TAB)));
    public static final RegistryObject<Block> STRIPPED_HEVEA_WOOD = BLOCKS.register("stripped_hevea_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.DIRT).strength(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<BlockItem> STRIPPED_HEVEA_WOOD_ITEM = ITEMS.register("stripped_hevea_wood", () -> new BlockItem(STRIPPED_HEVEA_WOOD.get(), new Item.Properties().tab(TAB)));
    public static final RegistryObject<Block> HEVEA_LEAVES = BLOCKS.register("hevea_leaves", () -> leaves(SoundType.GRASS));
    public static final RegistryObject<BlockItem> HEVEA_LEAVES_ITEM = ITEMS.register("hevea_leaves", () -> new BlockItem(HEVEA_LEAVES.get(), new Item.Properties().tab(TAB)));

    public static final RegistryObject<Block> GENERATOR = BLOCKS.register("generator", GeneratorBlock::new);
    public static final RegistryObject<BlockItem> GENERATOR_ITEM = ITEMS.register("generator", () -> new BlockItem(GENERATOR.get(), new Item.Properties().tab(TAB)));
    public static final RegistryObject<BlockEntityType<?>> GENERATOR_BE = BLOCK_ENTITIES.register("generator", () -> BlockEntityType.Builder.of(GeneratorBE::new, GENERATOR.get()).build(null));
    public static final RegistryObject<MenuType<GeneratorContainer>> GENERATOR_CONTAINER = CONTAINERS.register("generator", () -> IForgeContainerType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        Level world = inv.player.getCommandSenderWorld();
        return new GeneratorContainer(windowId, world, pos, inv, inv.player);
    }));

    public static final RegistryObject<Block> BATBOX = BLOCKS.register("batbox", BatBoxBlock::new);
    public static final RegistryObject<BlockItem> BATBOX_ITEM = ITEMS.register("batbox", () -> new BlockItem(BATBOX.get(), new Item.Properties().tab(TAB)));
    public static final RegistryObject<BlockEntityType<?>> BATBOX_BE = BLOCK_ENTITIES.register("batbox", () -> BlockEntityType.Builder.of(BatBoxBE::new, BATBOX.get()).build(null));
    public static final RegistryObject<MenuType<BatBoxContainer>> BATBOX_CONTAINER = CONTAINERS.register("batbox", () -> IForgeContainerType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        Level world = inv.player.getCommandSenderWorld();
        return new BatBoxContainer(windowId, world, pos, inv, inv.player);
    }));

    private static RotatedPillarBlock log(MaterialColor pTopColor, MaterialColor pBarkColor) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (p_152624_) -> {
            return p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? pTopColor : pBarkColor;
        }).strength(2.0F).sound(SoundType.WOOD));
    }

    private static LeavesBlock leaves(SoundType pSoundType) {
        return new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(pSoundType).noOcclusion());
    }
}
