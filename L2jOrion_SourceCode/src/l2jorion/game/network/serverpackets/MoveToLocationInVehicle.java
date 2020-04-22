/*
 * L2jOrion Project - www.l2jorion.com 
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 *
 * http://www.gnu.org/copyleft/gpl.html
 */
package l2jorion.game.network.serverpackets;

import l2jorion.game.model.actor.instance.L2PcInstance;
import l2jorion.util.Point3D;
/**
 * @author Damon
 */
public class MoveToLocationInVehicle extends L2GameServerPacket
{
	private final int _charObjId;
	private final int _boatId;
	private final Point3D _destination;
	private final Point3D _origin;
	
	public MoveToLocationInVehicle(L2PcInstance player, Point3D pos, Point3D originPos)
	{
		_charObjId = player.getObjectId();
		_boatId = player.getBoat().getObjectId();
		_destination = pos;
		_origin = originPos;
	}
	
	@Override
	protected void writeImpl()
	{
		writeC(0x71);
		writeD(_charObjId);
		writeD(_boatId);
		writeD(_destination.getX());
		writeD(_destination.getY());
		writeD(_destination.getZ());
		writeD(_origin.getX());
		writeD(_origin.getY());
		writeD(_origin.getZ());
	}
	
	@Override
	public String getType()
	{
		return "[S] 71 MoveToLocationInVehicle";
	}
	
}