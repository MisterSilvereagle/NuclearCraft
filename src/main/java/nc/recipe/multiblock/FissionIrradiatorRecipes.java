package nc.recipe.multiblock;

import static nc.config.NCConfig.*;

import java.util.*;

import com.google.common.collect.Lists;

import nc.radiation.RadSources;
import nc.recipe.ProcessorRecipeHandler;

public class FissionIrradiatorRecipes extends ProcessorRecipeHandler {
	
	public FissionIrradiatorRecipes() {
		super("fission_irradiator", 1, 0, 1, 0);
	}
	
	@Override
	public void addRecipes() {
		addRecipe(Lists.newArrayList("ingotThorium", "dustThorium"), "dustTBP", 160000, fission_irradiator_heat_per_flux[0], fission_irradiator_efficiency[0], RadSources.THORIUM);
		addRecipe(Lists.newArrayList("ingotTBP", "dustTBP"), "dustProtactinium233", 2720000, fission_irradiator_heat_per_flux[1], fission_irradiator_efficiency[1], RadSources.TBP);
		addRecipe(Lists.newArrayList("ingotBismuth", "dustBismuth"), "dustPolonium", 1920000, fission_irradiator_heat_per_flux[2], fission_irradiator_efficiency[2], RadSources.BISMUTH);
	}
	
	@Override
	public List fixExtras(List extras) {
		List fixed = new ArrayList(4);
		fixed.add(extras.size() > 0 && extras.get(0) instanceof Integer ? (int) extras.get(0) : 1);
		fixed.add(extras.size() > 1 && extras.get(1) instanceof Double ? (double) extras.get(1) : 0D);
		fixed.add(extras.size() > 2 && extras.get(2) instanceof Double ? (double) extras.get(2) : 0D);
		fixed.add(extras.size() > 3 && extras.get(3) instanceof Double ? (double) extras.get(3) : 0D);
		return fixed;
	}
}
