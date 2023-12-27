package net.grey3345.gkironmod.util;

import org.jetbrains.annotations.Nullable;

public enum HeatState {
    BURN(5,null),
    HOT(3,BURN),
    WARM(1,HOT);
    public final float damage;
    public final HeatState next;
    HeatState(float damage, @Nullable HeatState next) {
        this.damage = damage;
        this.next = next;
    }
}
