package com.softuni.mobilelele.model.view;

public class StatsView {

    private int anonymousRequests;
    private int authorizedRequests;

    public StatsView(int anonymousRequests, int authorizedRequests) {
        this.anonymousRequests = anonymousRequests;
        this.authorizedRequests = authorizedRequests;
    }

    public int getAnonymousRequests() {
        return anonymousRequests;
    }

    public int getAuthorizedRequests() {
        return authorizedRequests;
    }

    public int getTotalRequests() {
        return authorizedRequests + anonymousRequests;
    }
}
