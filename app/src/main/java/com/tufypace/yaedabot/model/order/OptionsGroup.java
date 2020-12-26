package com.tufypace.yaedabot.model.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OptionsGroup {
    //   @Expose
    @JsonProperty("name")
    public String name;
    //   @Expose
    @JsonProperty("options")
    public List<String> options;

    public OptionsGroup(String name, List<String> options) {
        this.name = name;
        this.options = options;
    }

    public OptionsGroup() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OptionsGroup that = (OptionsGroup) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(options, that.options);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, options);
    }

    @Override
    public String toString() {
        return "OptionsGroup{" +
                "name='" + name + '\'' +
                ", options=" + options +
                '}';
    }
}
