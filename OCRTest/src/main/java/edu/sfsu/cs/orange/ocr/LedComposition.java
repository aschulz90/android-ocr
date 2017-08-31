package edu.sfsu.cs.orange.ocr;

import android.graphics.Color;
import android.graphics.Rect;

import java.util.Arrays;
import java.util.List;

public class LedComposition {

    private static final LedComposition INTF = new LedComposition("INTF", 0, Color.RED);
    private static final LedComposition EXTF = new LedComposition("EXTF", INTF.getOffset() + 73, Color.RED);
    private static final LedComposition BUS1F = new LedComposition("BUS1F", EXTF.getOffset() + 73, Color.RED);
    private static final LedComposition FRCE = new LedComposition("FRCE", BUS1F.getOffset() + 292, Color.YELLOW);
    private static final LedComposition MAINT = new LedComposition("MAINT", FRCE.getOffset() + 73, Color.YELLOW);
    private static final LedComposition RUN = new LedComposition("RUN", MAINT.getOffset() + 146, Color.GREEN);
    private static final LedComposition STOP = new LedComposition("STOP", RUN.getOffset() + 73, Color.YELLOW);

    public static final List<LedComposition> LIST = Arrays.asList(INTF, EXTF, BUS1F, FRCE, MAINT, RUN, STOP);

    private final float offset;
    private final int color;
    private final Rect position = new Rect();
    private final boolean found;
    private final String name;
    private float scale;

    private LedComposition(String name, float offset, int color) {
        this.offset = offset;
        this.color = color;
        this.name = name;
        this.found = false;
        this.scale = 1;
    }

    public LedComposition(LedComposition src, Rect pos) {
        this.offset = src.getOffset();
        this.color = src.getColor();
        this.name = src.getName();

        this.found = true;
        setPosition(pos.left, pos.top, pos.right, pos.bottom);
        this.scale = (pos.bottom - pos.top) / 30.f;
    }

    public float getOffset() {
        return offset;
    }

    public int getColor() {
        return color;
    }

    public boolean isFound() {
        return found;
    }

    public void setPosition(int left, int top, int right, int bottom) {
        position.set(left, top, right, bottom);
        this.scale = (bottom - top) / 30.f;
    }

    public Rect getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public float getScale() {
        return scale;
    }
}