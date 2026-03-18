package edu.mcc.codeschool.class19.models.external;

public class CardMarket {
    private String url;
    private CardMarketPrices prices;

    public String getUrl() {
        return url;
    }

    public CardMarket setUrl(String url) {
        this.url = url;
        return this;
    }

    public CardMarketPrices getPrices() {
        return prices;
    }

    public CardMarket setPrices(CardMarketPrices prices) {
        this.prices = prices;
        return this;
    }
}
