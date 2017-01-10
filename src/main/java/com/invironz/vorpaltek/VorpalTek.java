package com.invironz.vorpaltek;

import com.invironz.vorpaltek.core.VorpalTekCoreModule;
import com.invironz.vorpaltek.factory.VorpalTekFactoryModule;
import com.invironz.vorpaltek.farm.VorpalTekFarmModule;
import com.invironz.vorpaltek.lib.IVorpalTekModule;
import com.invironz.vorpaltek.lib.VorpalTekNames;
import com.invironz.vorpaltek.power.VorpalTekPowerModule;
import com.invironz.vorpaltek.proxy.CommonProxy;
import com.invironz.vorpaltek.transport.VorpalTekTransportModule;
import com.invironz.vorpaltek.workshop.VorpalTekWorkshopModule;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by charmquark on 1/9/2017.
 */
@Mod(modid = VorpalTekNames.MOD_ID, name = VorpalTekNames.MOD_NAME, version = VorpalTekNames.VERSION, useMetadata = true)
public class VorpalTek {
    @Mod.Instance(VorpalTekNames.MOD_ID)
    public static VorpalTek instance;

    @SidedProxy(clientSide = VorpalTekNames.PROXY_CLIENT, serverSide = VorpalTekNames.PROXY_SERVER)
    public static CommonProxy proxy;

    private IVorpalTekModule[] modules = null;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    public VorpalTekCoreModule getCoreModuleInstance() {
        return VorpalTekCoreModule.getInstance();
    }

    public VorpalTekFactoryModule getFactoryModuleInstance() {
        return VorpalTekFactoryModule.getInstance();
    }

    public VorpalTekFarmModule getFarmModuleInstance() {
        return VorpalTekFarmModule.getInstance();
    }

    public IVorpalTekModule[] getModules() {
        if (modules == null) {
            modules = new IVorpalTekModule[] {
                getCoreModuleInstance(),
                getPowerModuleInstance(),
                getTransportModuleInstance(),
                getWorkshopModuleInstance(),
                getFactoryModuleInstance(),
                getFarmModuleInstance()
            };
        }
        return modules;
    }

    public VorpalTekPowerModule getPowerModuleInstance() {
        return VorpalTekPowerModule.getInstance();
    }

    public VorpalTekTransportModule getTransportModuleInstance() {
        return VorpalTekTransportModule.getInstance();
    }

    public VorpalTekWorkshopModule getWorkshopModuleInstance() {
        return VorpalTekWorkshopModule.getInstance();
    }
}
