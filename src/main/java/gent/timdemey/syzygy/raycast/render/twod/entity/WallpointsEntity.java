package gent.timdemey.syzygy.raycast.render.twod.entity;

import gent.timdemey.syzygy.core.Frame;
import gent.timdemey.syzygy.core.RenderInfo;
import gent.timdemey.syzygy.raycast.render.twod.RC2DRenderInfo;
import gent.timdemey.syzygy.raycast.world.GameState;

import java.awt.Color;
import java.awt.Graphics2D;

public class WallpointsEntity implements RenderEntity {

    @Override
    public void render(Graphics2D g, Frame fInfo, RenderInfo rInfo, GameState sInfo, RC2DRenderInfo rcInfo) {
        g.setColor(Color.red);

        for (int w = 0; w < sInfo.raycount; w++) {
            double[][] gridhits = sInfo.wall[w].gridhits;

            int k = sInfo.wall[w].leaps - 1;
            if (k >= 0) {
                RenderUtils.renderDot(g, rInfo, rcInfo, gridhits[k][0], gridhits[k][1]);
            }

        }

    }

}
