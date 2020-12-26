package com.tufypace.yaedabot.model.restoraunt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tufypace.yaedabot.model.order.Currency;

import java.math.BigDecimal;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceRestoraunt {
    @JsonProperty("id")
    private long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("market")
    private boolean market;
    @JsonProperty("tags")
    private List<RestorauntTag> tags;
    @JsonProperty("priceCategory")
    private PriceCategory priceCategory;
    @JsonProperty("rating")
    private Double rating;
    @JsonProperty("ratingDescription")
    private String ratingDescription;
    @JsonProperty("ratingCount")
    private String ratingCount;
    @JsonProperty("minimalOrderPrice")
    private BigDecimal minimalOrderPrice;
    @JsonProperty("minimalDeliveryCost")
    private BigDecimal minimalDeliveryCost;
    @JsonProperty("isNew")
    private boolean isNew;
    @JsonProperty("picture")
    private RestorantEwyPicture picture;
    @JsonProperty("isPromoAvailable")
    private boolean isPromoAvailable;
    @JsonProperty("personalizationStrategy")
    private Integer personalizationStrategy;
    @JsonProperty("footerDescription")
    private String footerDescription;
    @JsonProperty("deliveryConditions")
    private String deliveryConditions;
    @JsonProperty("isStore")
    private boolean isStore;
    @JsonProperty("currency")
    private Currency currency;
    @JsonProperty("previewDeliveryFee")
    private String previewDeliveryFee;
    @JsonProperty("features")
    private RestorauntPlaceFeatures features;
    @JsonProperty("promos")
    private List<RestorauntPromo> promos;
    @JsonProperty("business")
    public String business;
    @JsonProperty("promoTypes")
    public List<RestorauntPromoType> promoTypes;

    public PlaceRestoraunt() {
        super();
    }

    public PlaceRestoraunt(long id, String name, String description, String slug, boolean market, List<RestorauntTag> tags, PriceCategory priceCategory, Double rating, String ratingDescription, String ratingCount, BigDecimal minimalOrderPrice, BigDecimal minimalDeliveryCost, boolean isNew, RestorantEwyPicture picture, boolean isPromoAvailable, Integer personalizationStrategy, String footerDescription, String deliveryConditions, boolean isStore, Currency currency, String previewDeliveryFee, RestorauntPlaceFeatures features, List<RestorauntPromo> promos, String business, List<RestorauntPromoType> promoTypes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.slug = slug;
        this.market = market;
        this.tags = tags;
        this.priceCategory = priceCategory;
        this.rating = rating;
        this.ratingDescription = ratingDescription;
        this.ratingCount = ratingCount;
        this.minimalOrderPrice = minimalOrderPrice;
        this.minimalDeliveryCost = minimalDeliveryCost;
        this.isNew = isNew;
        this.picture = picture;
        this.isPromoAvailable = isPromoAvailable;
        this.personalizationStrategy = personalizationStrategy;
        this.footerDescription = footerDescription;
        this.deliveryConditions = deliveryConditions;
        this.isStore = isStore;
        this.currency = currency;
        this.previewDeliveryFee = previewDeliveryFee;
        this.features = features;
        this.promos = promos;
        this.business = business;
        this.promoTypes = promoTypes;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSlug() {
        return slug;
    }

    public boolean isMarket() {
        return market;
    }

    public List<RestorauntTag> getTags() {
        return tags;
    }

    public PriceCategory getPriceCategory() {
        return priceCategory;
    }

    public Double getRating() {
        return rating;
    }

    public String getRatingDescription() {
        return ratingDescription;
    }

    public String getRatingCount() {
        return ratingCount;
    }

    public BigDecimal getMinimalOrderPrice() {
        return minimalOrderPrice;
    }

    public BigDecimal getMinimalDeliveryCost() {
        return minimalDeliveryCost;
    }

    public boolean isNew() {
        return isNew;
    }

    public RestorantEwyPicture getPicture() {
        return picture;
    }

    public boolean isPromoAvailable() {
        return isPromoAvailable;
    }

    public Integer getPersonalizationStrategy() {
        return personalizationStrategy;
    }

    public String getFooterDescription() {
        return footerDescription;
    }

    public String getDeliveryConditions() {
        return deliveryConditions;
    }

    public boolean isStore() {
        return isStore;
    }

    public Currency getCurrency() {
        return currency;
    }

    public String getPreviewDeliveryFee() {
        return previewDeliveryFee;
    }

    public RestorauntPlaceFeatures getFeatures() {
        return features;
    }

    public List<RestorauntPromo> getPromos() {
        return promos;
    }

    public String getBusiness() {
        return business;
    }

    public List<RestorauntPromoType> getPromoTypes() {
        return promoTypes;
    }
}
