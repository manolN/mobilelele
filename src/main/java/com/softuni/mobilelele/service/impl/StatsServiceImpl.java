package com.softuni.mobilelele.service.impl;

import com.softuni.mobilelele.model.view.StatsView;
import com.softuni.mobilelele.service.StatsService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class StatsServiceImpl implements StatsService {

    private int anonymousRequests;
    private int authorizedRequests;

    @Override
    public void OnRequest() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && (authentication.getPrincipal() instanceof UserDetails)) {
            authorizedRequests++;
        } else {
            anonymousRequests++;
        }
    }

    @Override
    public StatsView getStats() {
        return new StatsView(anonymousRequests, authorizedRequests);
    }
}
