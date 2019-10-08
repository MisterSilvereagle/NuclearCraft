package nc.multiblock.network;

import io.netty.buffer.ByteBuf;
import nc.multiblock.turbine.Turbine;
import nc.multiblock.turbine.tile.TileTurbineController;
import net.minecraft.util.math.BlockPos;

public class TurbineUpdatePacket extends MultiblockUpdatePacket {
	
	public boolean isTurbineOn;
	public double power, rawPower, conductivity, totalExpansionLevel, idealTotalExpansionLevel;
	public int shaftWidth, bladeLength, noBladeSets, dynamoCoilCount, dynamoCoilCountOpposite, capacity, energy;
	
	public TurbineUpdatePacket() {
		messageValid = false;
	}
	
	public TurbineUpdatePacket(BlockPos pos, boolean isTurbineOn, double power, double rawPower, double conductivity, double totalExpansionLevel, double idealTotalExpansionLevel, int shaftWidth, int bladeLength, int noBladeSets, int dynamoCoilCount, int dynamoCoilCountOpposite, int capacity, int energy) {
		this.pos = pos;
		this.isTurbineOn = isTurbineOn;
		this.power = power;
		this.rawPower = rawPower;
		this.conductivity = conductivity;
		this.totalExpansionLevel = totalExpansionLevel;
		this.idealTotalExpansionLevel = idealTotalExpansionLevel;
		this.shaftWidth = shaftWidth;
		this.bladeLength = bladeLength;
		this.noBladeSets = noBladeSets;
		this.dynamoCoilCount = dynamoCoilCount;
		this.dynamoCoilCountOpposite = dynamoCoilCountOpposite;
		this.capacity = capacity;
		this.energy = energy;
		
		messageValid = true;
	}
	
	@Override
	public void readMessage(ByteBuf buf) {
		pos = new BlockPos(buf.readInt(), buf.readInt(), buf.readInt());
		isTurbineOn = buf.readBoolean();
		power = buf.readDouble();
		rawPower = buf.readDouble();
		conductivity = buf.readDouble();
		totalExpansionLevel = buf.readDouble();
		idealTotalExpansionLevel = buf.readDouble();
		shaftWidth = buf.readInt();
		bladeLength = buf.readInt();
		noBladeSets = buf.readInt();
		dynamoCoilCount = buf.readInt();
		dynamoCoilCountOpposite = buf.readInt();
		capacity = buf.readInt();
		energy = buf.readInt();
	}
	
	@Override
	public void writeMessage(ByteBuf buf) {
		buf.writeInt(pos.getX());
		buf.writeInt(pos.getY());
		buf.writeInt(pos.getZ());
		buf.writeBoolean(isTurbineOn);
		buf.writeDouble(power);
		buf.writeDouble(rawPower);
		buf.writeDouble(conductivity);
		buf.writeDouble(totalExpansionLevel);
		buf.writeDouble(idealTotalExpansionLevel);
		buf.writeInt(shaftWidth);
		buf.writeInt(bladeLength);
		buf.writeInt(noBladeSets);
		buf.writeInt(dynamoCoilCount);
		buf.writeInt(dynamoCoilCountOpposite);
		buf.writeInt(capacity);
		buf.writeInt(energy);
	}
	
	public static class Handler extends MultiblockUpdatePacket.Handler<TurbineUpdatePacket, Turbine, TileTurbineController> {

		public Handler() {
			super(TileTurbineController.class);
		}
	}
}