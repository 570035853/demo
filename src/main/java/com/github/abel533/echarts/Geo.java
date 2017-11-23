package com.github.abel533.echarts;

import com.github.abel533.echarts.Basic;
import com.github.abel533.echarts.Component;
import com.github.abel533.echarts.code.Roam;
import com.github.abel533.echarts.style.ItemStyle;
import lombok.Getter;
import lombok.Setter;

/**
 * @author liuzh
 * @since 2016-02-28 17:05
 */
@Getter
@Setter
public class Geo extends Basic<com.github.abel533.echarts.Geo> implements Component {
    private String map;
    private Roam roam;
    private ItemStyle label;
    private ItemStyle itemStyle;

    public String map() {
        return this.map;
    }

    public com.github.abel533.echarts.Geo map(String map) {
        this.map = map;
        return this;
    }

    public Roam roam() {
        return this.roam;
    }

    public com.github.abel533.echarts.Geo roam(Roam roam) {
        this.roam = roam;
        return this;
    }

    public ItemStyle label() {
        if (this.label == null) {
            this.label = new ItemStyle();
        }
        return this.label;
    }

    public com.github.abel533.echarts.Geo label(ItemStyle label) {
        this.label = label;
        return this;
    }

    public ItemStyle itemStyle() {
        if (this.itemStyle == null) {
            this.itemStyle = new ItemStyle();
        }
        return this.itemStyle;
    }

    public com.github.abel533.echarts.Geo itemStyle(ItemStyle itemStyle) {
        this.itemStyle = itemStyle;
        return this;
    }
}
